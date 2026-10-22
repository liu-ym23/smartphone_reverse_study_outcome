package wh;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.d;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.i;
import com.bytedance.forest.utils.h;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Forest f559632a;

    static {
    }

    @JvmStatic
    public static final long a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();
        if (r101 == null) goto L19;
        File r102 = r101.getFilesDir();
        if (r102 == null) goto L19;
        String r103 = r102.getAbsolutePath();
        if (r103 == null) goto L19;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, "offlineX");
        d r105 = d.f48119b;
        if (r105.getIECHostAppInfo().isDebug() == false) goto L12;
    L15:
        String r106 = "36723dc3e85a23e701d1697d57de07ed";
    L16:
        Long r107 = ResLoadUtils.getLatestChannelVersion(r104, r106, r100);
        if (r107 == null) goto L19;
        return r107.longValue();
    L12:
        if (r105.getIECHostAppInfo().isLocalTest() == true) goto L15;
        r106 = "5fb33cde3ebff01c8433ddc22aac0816";
    L19:
        return -1;
    }

    public static Forest b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Forest r100 = f559632a;
        if (r100 != null) goto L69;
        Context r111 = r110.getApplicationContext();
        if (r111 == null) goto L68;
        Application r112 = (Application) r111;
        d r101 = d.f48119b;
        if (r101.getIECHostAppInfo().isDebug() == false) goto L9;
    L12:
        String r102 = "36723dc3e85a23e701d1697d57de07ed";
    L13:
        boolean r103 = false;
        vi.a r104 = null;
        String r105 = r101.getIECHostAppInfo().getAppId();     // Catch: Throwable -> L26
        if (r105 != null) goto L17;
    L28:
        long r106 = 0;
    L29:
        long r113 = r106;
        Lazy r107 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.n() == false) goto L44;
        int r108 = ECSdk.f48106a;
        IECHostService r109 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r109 == null) goto L34;
        r104 = r109.getIECHostAppInfo();
    L34:
        if (r104 != null) goto L36;
    L37:
        if (r104 != null) goto L39;
    L41:
        if (r103 == false) goto L43;
        String r114 = "webofflinex_debug/live";
    L45:
        String r115 = r114;
        d r116 = d.f48119b;
        String r117 = r116.getIECHostAppInfo().getAppVersionName();
        if (r117 != null) goto L48;
        String r118 = "";
    L49:
        String r119 = r116.getIECHostAppInfo().getServerDeviceId();
        if (r119 != null) goto L52;
        String r120 = "";
    L53:
        r100 = new Forest(r112, new i("gecko.zijieapi.com", new GeckoConfig("-1", r115, r113, r118, r120, "cn"), 4));
        GeckoConfig r121 = r100.getConfig().a(r102);
        if (r121 == null) goto L63;
        int r122 = h.f244547a;
        if (h.a(r121.f244242c) == false) goto L63;
        GeckoConfig r123 = r100.getConfig().f244346h;
        if (r123 == null) goto L60;
        r123.f244242c = r121.f244242c;
    L60:
        GeckoConfig r124 = r100.getConfig().f244346h;
        if (r124 == null) goto L63;
        r124.f244247h = r121.f244247h;
    L63:
        GeckoConfig r125 = r100.getConfig().f244346h;
        if (r125 == null) goto L66;
        r125.f244241b = r102;
    L66:
        f559632a = r100;
        goto L69
    L52:
        r120 = r119;
        goto L53
    L48:
        r118 = r117;
        goto L49
    L43:
        r114 = "webofflinex/live";
        goto L45
    L39:
        if (r104.isLocalTest() != true) goto L41;
    L40:
        r103 = true;
        goto L41
    L36:
        if (r104.isDebug() == true) goto L40;
    L44:
        r114 = "offlineX";
        goto L45
    L17:
        if (r105.length() <= 0) goto L19;
        boolean r126 = true;
    L20:
        if (r126 == true) goto L23;
        r105 = null;
    L23:
        if (r105 == null) goto L28;
        r106 = CastLongProtector.parseLong(r105);     // Catch: Throwable -> L26
        goto L29
    L19:
        r126 = false;
    L26:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L28
    L9:
        if (r101.getIECHostAppInfo().isLocalTest() == true) goto L12;
        r102 = "5fb33cde3ebff01c8433ddc22aac0816";
        goto L13
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    L69:
        return r100;
    }
}
