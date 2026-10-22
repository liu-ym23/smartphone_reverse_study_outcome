package com.ss.cast.sourcecommon.monitor;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.bean.BytecastBrowseType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public final class SourceMonitor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<ContextManager.CastContext, SourceMonitor> f456607e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile SourceMonitor f456608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f456609g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CastLogger f456610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CastMonitor f456611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TeaEventTrack f456612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f456613d;

    /* JADX INFO: renamed from: com.ss.cast.sourcecommon.monitor.SourceMonitor$1, reason: invalid class name */
    class AnonymousClass1 extends HashMap<String, String> {
        final /* synthetic */ SourceMonitor this$0;
        final /* synthetic */ String val$protocol;
        final /* synthetic */ Long val$startPlayTime;

        public AnonymousClass1(SourceMonitor r100, String r101, Long r102) {
            this.this$0 = r100;
            this.val$protocol = r101;
            this.val$startPlayTime = r102;
            put("state", TeaEventTrack.TEA_EVENT_STATE_PUSH_SUCCESS);
            put("cast_protocol", r101.toLowerCase(Locale.ROOT));
            if (r102 == null) goto L6;
            r100.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_PUSH_TIME, new Map[]{new C54631(this)});
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.cast.sourcecommon.monitor.SourceMonitor$3, reason: invalid class name */
    class AnonymousClass3 extends HashMap<String, String> {
        final /* synthetic */ SourceMonitor this$0;
        final /* synthetic */ String val$finalProtocolType;
        final /* synthetic */ Long val$startTime;

        public AnonymousClass3(SourceMonitor r100, String r101, Long r102) {
            this.this$0 = r100;
            this.val$finalProtocolType = r101;
            this.val$startTime = r102;
            put("cast_protocol", r101);
            put("cast_duration", String.valueOf(System.currentTimeMillis() - r102.longValue()));
        }
    }

    static {
        f456607e = new ConcurrentHashMap();
        f456609g = new Object();
    }

    public static SourceMonitor a() {
        if (f456608f != null) goto L15;
        monitor-enter(SourceMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f456608f != null) goto L9;
        f456608f = new SourceMonitor(null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SourceMonitor.class);     // Catch: Throwable -> L11
    L15:
        return f456608f;
    }

    public SourceMonitor(ContextManager.CastContext r100) {
        this.f456613d = "";
        this.f456610a = ContextManager.getLogger(r100);
        this.f456611b = ContextManager.getMonitor(r100);
        this.f456612c = ContextManager.getTeaEventTrack(r100);
    }

    public static SourceMonitor b(ContextManager.CastContext r100) {
        if (r100 == null) goto L4;
        ConcurrentHashMap<ContextManager.CastContext, SourceMonitor> r101 = f456607e;
        if (r101.get(r100) != null) goto L18;
        Object r102 = f456609g;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r101.get(r100) != null) goto L12;
        r101.put(r100, new SourceMonitor(r100));     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L18:
        return r101.get(r100);
    L4:
        return a();
    }

    public final void f(String r100) {
        Logger.d("SourceMonitor", "trackByteCastGetMediaInfoProtocol, protocolType: ".concat(r100));
        HashMap r101 = new HashMap();
        Locale r102 = Locale.ROOT;
        r101.put("protocol", r100.toLowerCase(r102));
        r101.put("content", "");
        r101.put("state", "start");
        this.f456612c.castProtocol = r100.toLowerCase(r102);
        r101.put("cast_protocol", r100.toLowerCase(r102));
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_GET_MEDIA_INFO_PROTOCOL, new Map[]{r101});
    }

    public final void i(BytecastBrowseType r100) {
        this.f456610a.d("SourceMonitor", "trackBytecastStartBrowse");
        String r101 = UUID.randomUUID().toString();
        this.f456613d = r101;
        this.f456612c.browseId = r101;
        this.f456611b.browseId = r101;
        HashMap r102 = new HashMap();
        r102.put("event_type", r100.getValue());
        r102.put("content", "");
        HashMap r103 = new HashMap();
        r103.put("browse_id", this.f456613d);
        this.f456611b.sendSourceEvent(CastMonitor.BYTECAST_START_BROWSE_V2, r102, r103, "");
        r103.put("state", "start");
        r103.put("browse_protocol", "");
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_BROWSE, new Map[]{r102, r103});
    }

    public final void j(BytecastBrowseType r100) {
        HashMap r101 = new HashMap();
        r101.put("event_type", r100.getValue());
        r101.put("content", "");
        HashMap r102 = new HashMap();
        r102.put("browse_id", this.f456613d);
        this.f456611b.sendSourceEvent(CastMonitor.BYTECAST_STOP_BROWSE_V2, r101, r102, "");
    }

    public final void k(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        HashMap r101 = new HashMap();
        Locale r102 = Locale.ROOT;
        r101.put("protocol", r100.toLowerCase(r102));
        r101.put("content", "");
        HashMap r103 = new HashMap();
        r103.put("browse_id", this.f456613d);
        this.f456611b.sendSourceEvent(CastMonitor.BYTECAST_START_BROWSE_PROTOCOL_V2, r101, r103, "");
        r103.put("state", "start");
        this.f456612c.castProtocol = r100.toLowerCase(r102);
        r103.put("browse_protocol", "");
        r103.put("cast_protocol", r100);
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_BROWSE_PROTOCOL, new Map[]{r101, r103});
    }

    public final void l(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        HashMap r101 = new HashMap();
        r101.put("protocol", r100.toLowerCase(Locale.ROOT));
        r101.put("content", "");
        HashMap r102 = new HashMap();
        r102.put("browse_id", this.f456613d);
        this.f456611b.sendSourceEvent(CastMonitor.BYTECAST_STOP_BROWSE_PROTOCOL_V2, r101, r102, "");
    }

    public final void g(String r100, boolean r101) {
        Logger.d("SourceMonitor", "trackByteCastGetMediaInfoResultProtocol, protocolType: " + r100 + ", result: " + r101);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        HashMap r102 = new HashMap();
        r102.put("protocol", r100.toLowerCase(Locale.ROOT));
        r102.put("content", "");
        if (r101 == false) goto L8;
        String r103 = "success";
    L9:
        r102.put("state", r103);
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_GET_MEDIA_INFO_PROTOCOL, new Map[]{r102});
        return;
    L8:
        r103 = "failure";
        goto L9
    }

    public final void e(final String r100, final Long r101, String r102) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        HashMap r103 = new HashMap();
        Locale r104 = Locale.ROOT;
        r103.put("protocol", r100.toLowerCase(r104));
        r103.put("content", "");
        r103.put("cast_id", r102);
        r103.put("state", "success");
        this.f456612c.castProtocol = r100.toLowerCase(r104);
        r103.put("cast_protocol", r100.toLowerCase(r104));
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_CONNECT_PROTOCOL, new Map[]{r103});
        if (r101 == null) goto L9;
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_CONNECT_TIME, new Map[]{new AnonymousClass4(this, r101, r100)});
        return;
    }

    public final void d(String r100, String r101, String r102, int r103, String r110) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        HashMap r104 = new HashMap();
        Locale r105 = Locale.ROOT;
        r104.put("protocol", r100.toLowerCase(r105));
        r104.put("content", "");
        r104.put("cast_id", r102);
        if (r103 == 0) goto L8;
        r104.put("err_code", String.valueOf(r103));
        r104.put(LocationMonitorConst.ERR_MSG, r110);
    L8:
        r104.put("state", r101);
        this.f456612c.castProtocol = r100.toLowerCase(r105);
        r104.put("cast_protocol", r100.toLowerCase(r105));
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_CONNECT_PROTOCOL, new Map[]{r104});
    }

    public final void c(final String r100, String r101, String r102, String r103, boolean r110, final Long r111) {
        HashMap r104 = new HashMap();
        Locale r105 = Locale.ROOT;
        r104.put("protocol", r100.toLowerCase(r105));
        HashMap r106 = new HashMap();
        r106.put("browse_id", this.f456613d);
        r106.put("content", r101);
        r106.put(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME, r102);
        r106.put("manufacture", r103);
        if (r110 == false) goto L6;
        this.f456611b.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT_PROTOCOL_V2, r104, r106, "");
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        String r107 = "failure";
    L9:
        r106.put("state", r107);
        this.f456612c.castProtocol = r100.toLowerCase(r105);
        r106.put("browse_protocol", "");
        r106.put("cast_protocol", r100);
        r106.put("support_play", String.valueOf(r110));
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_BROWSE_PROTOCOL, new Map[]{r104, r106});
        if (TextUtils.isEmpty(r102) == true) goto L14;
        if (r111 == null) goto L15;
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_BROWSE_TIME, new Map[]{new AnonymousClass2(this, r111, r100)});
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r107 = "success";
        goto L9
    }

    public final void h(BytecastBrowseType r100, String r101, String r102, String r103, boolean r110, Long r111) {
        HashMap r104 = new HashMap();
        r104.put("event_type", r100.getValue());
        r104.put("result", "success");
        HashMap r105 = new HashMap();
        r105.put("browse_id", this.f456613d);
        r105.put("content", r101);
        r105.put(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME, r102);
        r105.put("manufacture", r103);
        if (r110 == false) goto L5;
        this.f456611b.sendSourceEvent(CastMonitor.BYTECAST_BROWSE_RESULT_V2, r104, r105, "");
    L5:
        r104.remove("result");
        r105.put("state", "success");
        r105.put("browse_protocol", "");
        if (r111 == null) goto L8;
        r105.put("cast_duration", String.valueOf(System.currentTimeMillis() - r111.longValue()));
    L8:
        r105.put("support_play", String.valueOf(r110));
        this.f456612c.trackSourceEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_BROWSE, new Map[]{r104, r105});
    }
}
