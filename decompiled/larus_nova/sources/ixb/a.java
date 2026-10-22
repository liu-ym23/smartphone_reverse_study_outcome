package ixb;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.quality.HangDetectConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import swb.b;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WebViewOptimizeConfig f496453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f496454b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f496455c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f496456d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f496457e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f496458f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f496459g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f496460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f496461i;

    static {
        WebViewOptimizeConfig r100 = (WebViewOptimizeConfig) SettingManager.getInstance().get(WebViewOptimizeConfig.class);
        f496453a = r100;
        int r101 = g.f437223a;
        f496454b = g.a.a("chameleon.webview.blank.detection.enable");
        f496455c = g.a.a("chameleon.webview.freezescreen.detection.enable");
        f496456d = g.a.a("doubao.chameleon.webview.blankscreen.detection.disable");
        f496457e = g.a.a("doubao.chameleon.webview.freezescreen.detection.disable");
        if (r100 == null) goto L7;
        HangDetectConfig r102 = r100.getHangDetect();
        if (r102 == null) goto L7;
        int r103 = r102.getMaxKillCount();
    L8:
        f496458f = r103;
        if (r100 == null) goto L13;
        HangDetectConfig r104 = r100.getHangDetect();
        if (r104 == null) goto L13;
        long r105 = r104.getMinKillInterval();
    L14:
        f496459g = r105 * 1000;
        return;
    L13:
        r105 = 120;
    L7:
        r103 = 3;
        goto L8
    }

    public static boolean a() {
        if (b.b() == false) goto L9;
        if (f496457e == false) goto L9;
        j.e("WebViewOptimizeUtil", "DouBao disable hang detect");
        return false;
    L9:
        if (b.b() == false) goto L11;
    L14:
        WebViewOptimizeConfig r100 = f496453a;
        if (r100 == null) goto L17;
        HangDetectConfig r101 = r100.getHangDetect();
    L18:
        if (r101 != null) goto L20;
        return false;
    L20:
        return r101.getEnableDetection();
    L17:
        r101 = null;
        goto L18
    L11:
        if (f496455c == true) goto L14;
        j.e("WebViewOptimizeUtil", "hangFgEnable is false");
        return false;
    }
}
