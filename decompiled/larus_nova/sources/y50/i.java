package y50;

import android.os.Build;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f566214a = null;

    static {
        f566214a = new i();
    }

    public i() {
    }

    @JvmStatic
    public static final void l(String r100, String r101, String r102, String r103, int r104, String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "containerType");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "methodName");
        Intrinsics.checkNotNullParameter(r110, "errorMsg");
        if (r111 != null) goto L5;
        r111 = new JSONObject();
    L5:
        f566214a.getClass();
        BaseMonitor.add(r111, ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME, Build.MODEL);
        IMiddleWareHostContext r105 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hostAppId();
    L9:
        BaseMonitor.add(r111, "host_app_id", String.valueOf(r107));
        IMiddleWareHostContext r108 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r108 == null) goto L12;
        r106 = r108.appId();
    L12:
        BaseMonitor.add(r111, "webcast_app_id", String.valueOf(r106));
        BaseMonitor.add(r111, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r100);
        BaseMonitor.add(r111, "schema", r101);
        BaseMonitor.add(r111, "url", r102);
        BaseMonitor.add(r111, "method_name", r103);
        BaseMonitor.add(r111, "error_msg", r110);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_monitor_container", r104, r111);
        return;
    L8:
        r107 = 0;
        goto L9
    }

    public static /* synthetic */ void m(String r100, String r101, String r102, String r103, int r104, String r110, JSONObject r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r100 = "unknown";
    L5:
        String r105 = "";
        if ((r112 & 2) == 0) goto L8;
        String r106 = "";
    L10:
        if ((r112 & 4) == 0) goto L12;
        String r107 = "";
    L14:
        if ((r112 & 8) == 0) goto L16;
        String r108 = "";
    L18:
        if ((r112 & 16) == 0) goto L20;
        int r109 = 0;
    L22:
        if ((r112 & 32) != 0) goto L26;
        r105 = r110;
    L26:
        if ((r112 & 64) == 0) goto L28;
        r111 = null;
    L28:
        JSONObject r113 = r111;
        l(r100, r106, r107, r108, r109, r105, r113);
        return;
    L20:
        r109 = r104;
        goto L22
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r106 = r101;
        goto L10
    }
}
