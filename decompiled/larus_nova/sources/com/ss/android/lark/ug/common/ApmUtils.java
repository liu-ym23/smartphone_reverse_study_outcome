package com.ss.android.lark.ug.common;

import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.ApmAgent;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class ApmUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f444430a = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B7\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/ug/common/ApmUtils$GetDataCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larksuite/framework/callback/IGetDataCallback;", "delegate", "name", "", "category", "", "", "<init>", "(Lcom/larksuite/framework/callback/IGetDataCallback;Ljava/lang/String;Ljava/util/Map;)V", "onSuccess", "", "t", "(Ljava/lang/Object;)V", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class GetDataCallback<T> implements IGetDataCallback<T> {
        private final Map<String, Object> category;
        private final IGetDataCallback<T> delegate;
        private final String name;

        public GetDataCallback(IGetDataCallback<T> r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            Intrinsics.checkNotNullParameter(r101, "name");
            this(r100, r101, null, 4, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "err");
            this.delegate.onError(r100);
            String r101 = this.name;
            Map r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to("isSuccess", Boolean.FALSE), TuplesKt.to("errorCode", Integer.valueOf(r100.getErrorCode()))});
            Map<String, Object> r103 = this.category;
            if (r103 != null) goto L5;
            r103 = MapsKt.emptyMap();
        L5:
            Map r104 = MapsKt.plus(r102, r103);
            if (r100.getDebugMsg() != null) goto L8;
            Map r105 = null;
        L9:
            ApmUtils.b(r101, r104, null, r105);
            return;
        L8:
            r105 = MapsKt.mapOf(TuplesKt.to("errMsg", String.valueOf(r100.getDebugMsg())));
            goto L9
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public void onSuccess(T r100) {
            this.delegate.onSuccess(r100);
            String r101 = this.name;
            Map r102 = MapsKt.mapOf(TuplesKt.to("isSuccess", Boolean.TRUE));
            Map<String, Object> r103 = this.category;
            if (r103 != null) goto L5;
            r103 = MapsKt.emptyMap();
        L5:
            ApmUtils.b(r101, MapsKt.plus(r102, r103), null, null);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        public GetDataCallback(IGetDataCallback<T> r100, String r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            Intrinsics.checkNotNullParameter(r101, "name");
            this.delegate = r100;
            this.name = r101;
            this.category = r102;
            ApmUtils.f444430a.put(r101, Long.valueOf(SystemClock.elapsedRealtime()));
        }

        public /* synthetic */ GetDataCallback(IGetDataCallback r100, String r101, Map r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    static {
        f444430a = new ConcurrentHashMap();
    }

    public static JSONObject a(Map r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L7
    L9:
        return r101;
    }

    @JvmStatic
    public static final void b(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Number> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        ConcurrentHashMap<String, Long> r104 = f444430a;
        Long r105 = r104.get(r100);
        Integer r106 = null;
        if (r101 == null) goto L5;
        Object r107 = r101.get("errorCode");
    L7:
        if ((r107 instanceof Integer) == false) goto L9;
        r106 = (Integer) r107;
    L9:
        if (r106 != null) goto L16;
        if (r105 == null) goto L16;
        long r108 = SystemClock.elapsedRealtime() - r105.longValue();
        if (r102 != null) goto L14;
        r102 = MapsKt.mapOf(TuplesKt.to("latency", Long.valueOf(r108)));
    L15:
        r104.remove(r100);
        goto L16
    L14:
        MapsKt.plus(r102, new Pair("latency", Long.valueOf(r108)));
    L16:
        ApmAgent.monitorEvent(r100, a(r101), a(r102), a(r103));
        return;
    L5:
        r107 = null;
        goto L7
    }
}
