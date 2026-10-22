package com.ss.android.lark.optrace.core;

import android.os.SystemClock;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.api.ITracing;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.api.TracingSpanData;
import com.ss.android.lark.optrace.extension.TracingExtension;
import com.ss.android.lark.optrace.extension.TracingExtensionEnum;
import com.ss.android.lark.optrace.extension.clientRequest.TrancingClientRequestExtension;
import com.ss.android.lark.optrace.extension.clientRequest.TrancingClientRequestExtensionImpl;
import com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtension;
import com.ss.android.lark.optrace.extension.clientduration.TracingClientDurationExtensionImpl;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class TracingCoreTarget implements TracingCoreSpan {
    private static final long serialVersionUID = 446009563012766987L;

    @SerializedName("traceId")
    @Expose
    protected String cacheTracingId;

    @SerializedName("createTime")
    @Expose
    private long createTime;
    protected Map<TracingExtensionEnum, TracingExtension> extensions;
    private TracingCoreSpan parent;
    protected TracingSpanData spanData;

    public abstract void generateSpanData();

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void clientDurationEndAll() {
        Iterator<TracingExtensionEnum> r100 = this.extensions.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        TracingExtensionEnum r101 = r100.next();
        TracingExtension r102 = this.extensions.get(r101);
        if (r102 == null) goto L4;
        if ((r102 instanceof TracingClientDurationExtension) == false) goto L4;
        ((TracingClientDurationExtension) r102).endAll();
        goto L4
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public String getRequestId() {
        TracingExtension r100 = this.extensions.get(TracingExtensionEnum.CLIENT_REQUEST);
        if ((r100 instanceof TrancingClientRequestExtension) == true) goto L5;
        return null;
    L5:
        return ((TrancingClientRequestExtension) r100).getRequestId();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("TracingCoreTarget{parent=");
        TracingCoreSpan r101 = this.parent;
        String r102 = "";
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        r100.append(r103);
        r100.append(", spanData=");
        TracingSpanData r104 = this.spanData;
        if (r104 == null) goto L9;
        String r105 = r104.toString();
    L10:
        r100.append(r105);
        r100.append(", cacheTracingId='");
        String r106 = this.cacheTracingId;
        if (r106 == null) goto L13;
        r102 = r106;
    L13:
        r100.append(r102);
        r100.append("', createTime=");
        r100.append(this.createTime);
        r100.append(", extensions=");
        r100.append(this.extensions.toString());
        r100.append('}');
        return r100.toString();
    L9:
        r105 = "";
        goto L10
    L5:
        r103 = "";
        goto L6
    }

    public TracingCoreTarget() {
        this.parent = null;
        this.createTime = SystemClock.elapsedRealtime();
        this.extensions = new ConcurrentHashMap();
        addExtension(TracingExtensionEnum.CLIENT_DURATION, new TracingClientDurationExtensionImpl());
        addExtension(TracingExtensionEnum.CLIENT_REQUEST, new TrancingClientRequestExtensionImpl());
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long createTime() {
        return this.createTime;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public String getTracingID() {
        return this.cacheTracingId;
    }

    public TracingCoreTarget(TracingCoreSpan r100) {
        this.parent = r100;
        this.createTime = SystemClock.elapsedRealtime();
        this.extensions = new ConcurrentHashMap();
        addExtension(TracingExtensionEnum.CLIENT_DURATION, new TracingClientDurationExtensionImpl());
        addExtension(TracingExtensionEnum.CLIENT_REQUEST, new TrancingClientRequestExtensionImpl());
        generateSpanData();
        TracingCoreSpan r101 = this.parent;
        if (r101 != null) goto L5;
        String r102 = "1";
    L6:
        this.cacheTracingId = r102 + "-" + this.spanData.getSpan();
        return;
    L5:
        r102 = r101.getTracingID();
        goto L6
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long clientDuration(String r100) {
        TracingExtension r101 = this.extensions.get(TracingExtensionEnum.CLIENT_DURATION);
        if ((r101 instanceof TracingClientDurationExtension) == true) goto L5;
        Log.e("TracingCoreTarget", "Not implement Client Duration extension");
        return -1;
    L5:
        return ((TracingClientDurationExtension) r101).duration(r100);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long clientDurationTagEnd(String r100) {
        TracingExtension r101 = this.extensions.get(TracingExtensionEnum.CLIENT_DURATION);
        if ((r101 instanceof TracingClientDurationExtension) == true) goto L5;
        Log.e("TracingCoreTarget", "Not implement Client Duration extension");
        return -1;
    L5:
        return ((TracingClientDurationExtension) r101).end(r100);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void clientDurationTagStart(String r100) {
        TracingExtension r101 = this.extensions.get(TracingExtensionEnum.CLIENT_DURATION);
        if ((r101 instanceof TracingClientDurationExtension) == false) goto L5;
        ((TracingClientDurationExtension) r101).start(r100);
        return;
    L5:
        Log.e("TracingCoreTarget", "Not implement Client Duration extension");
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void setRequestId(String r100) {
        TracingExtension r101 = this.extensions.get(TracingExtensionEnum.CLIENT_REQUEST);
        if ((r101 instanceof TrancingClientRequestExtension) == false) goto L6;
        ((TrancingClientRequestExtension) r101).setRequestId(r100);
        return;
    }

    public TracingCoreTarget(String r100) {
        this();
        this.cacheTracingId = r100;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void addExtension(TracingExtensionEnum r100, TracingExtension r101) {
        this.extensions.put(r100, r101);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void d(String r100, Object... r101) {
        String r102 = getTracingID();
        int r103 = kyb.a.f506724a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "traceId");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.d(r100, "[" + r102 + "] " + kyb.a.a(Arrays.copyOf(r101, r101.length)));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void e(String r100, Object... r101) {
        String r102 = getTracingID();
        int r103 = kyb.a.f506724a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "traceId");
        Intrinsics.checkNotNullParameter(r101, "msg");
        boolean r104 = false;
        if (r101.length != 0) goto L5;
        boolean r105 = true;
    L7:
        if ((!r105) == true) goto L9;
    L11:
        String r106 = kyb.a.a(Arrays.copyOf(r101, r101.length));
        if (r104 == false) goto L14;
        Object r107 = r101[r101.length - 1];
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Throwable");
        Log.e(r100, "[" + r102 + "] " + r106, (Throwable) r107);
        return;
    L14:
        Log.e(r100, "[" + r102 + "] " + r106);
        return;
    L9:
        if ((r101[r101.length - 1] instanceof Throwable) == false) goto L11;
        r104 = true;
        goto L11
    L5:
        r105 = false;
        goto L7
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void i(String r100, Object... r101) {
        String r102 = getTracingID();
        int r103 = kyb.a.f506724a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "traceId");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.i(r100, "[" + r102 + "] " + kyb.a.a(Arrays.copyOf(r101, r101.length)));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void w(String r100, Object... r101) {
        String r102 = getTracingID();
        int r103 = kyb.a.f506724a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "traceId");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.w(r100, "[" + r102 + "] " + kyb.a.a(Arrays.copyOf(r101, r101.length)));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public <T> void linkTracing(ITracing r100, T r101, hyb.b<T> r102) {
        if (r100 != null) goto L6;
        Log.e("TracingCoreTarget", "linkedTracing == null");
        return;
    L6:
        r100.getTracingID();
        r102.a();
        TracingCoreTarget r103 = (TracingCoreTarget) r100;
        Iterator<TracingExtensionEnum> r104 = r103.extensions.keySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L16;
        TracingExtensionEnum r105 = r104.next();
        TracingExtension r106 = r103.extensions.get(r105);
        if (r106 == null) goto L11;
        TracingExtension r107 = this.extensions.get(r105);
        if (r107 != null) goto L14;
        this.extensions.put(r105, r106);
        goto L8
    L14:
        r107.mergeExtension(r106);
        goto L8
    L11:
        Log.e("TracingCoreTarget", "linkExtension == null, enum = " + r105.name());
        goto L8
    }
}
