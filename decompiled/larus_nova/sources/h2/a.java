package h2;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f483562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f483563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f483564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f483565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f483566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f483567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f483568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f483569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f483570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f483571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f483572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f483573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f483574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f483575n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f483576o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f483577p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f483578q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f483579r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Integer f483580s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f483581t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f483582u;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f483562a, r101.f483562a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f483563b, r101.f483563b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f483564c, r101.f483564c) == true) goto L18;
        return false;
    L18:
        if (this.f483565d == r101.f483565d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f483566e, r101.f483566e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f483567f, r101.f483567f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f483568g, r101.f483568g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f483569h, r101.f483569h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f483570i, r101.f483570i) == true) goto L36;
        return false;
    L36:
        if (this.f483571j == r101.f483571j) goto L39;
        return false;
    L39:
        if (this.f483572k == r101.f483572k) goto L42;
        return false;
    L42:
        if (this.f483573l == r101.f483573l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f483574m, r101.f483574m) == true) goto L48;
        return false;
    L48:
        if (this.f483575n == r101.f483575n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f483576o, r101.f483576o) == true) goto L54;
        return false;
    L54:
        if (this.f483577p == r101.f483577p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f483578q, r101.f483578q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f483579r, r101.f483579r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f483580s, r101.f483580s) == true) goto L66;
        return false;
    L66:
        if (this.f483581t == r101.f483581t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f483582u, r101.f483582u) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f483562a.hashCode() * 31;
        String r101 = this.f483563b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((((((((((r100 + r103) * 31) + this.f483564c.hashCode()) * 31) + this.f483565d) * 31) + this.f483566e.hashCode()) * 31) + this.f483567f.hashCode()) * 31) + this.f483568g.hashCode()) * 31) + this.f483569h.hashCode()) * 31) + this.f483570i.hashCode()) * 31;
        int r105 = 1231;
        if (this.f483571j == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f483572k == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.f483573l == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (((r109 + r110) * 31) + this.f483574m.hashCode()) * 31;
        if (this.f483575n == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (((r111 + r112) * 31) + this.f483576o.hashCode()) * 31;
        if (this.f483577p == true) goto L26;
        r105 = 1237;
    L26:
        int r114 = (((((r113 + r105) * 31) + this.f483578q.hashCode()) * 31) + this.f483579r.hashCode()) * 31;
        Integer r115 = this.f483580s;
        if (r115 == null) goto L31;
        r102 = r115.hashCode();
    L31:
        return ((((r114 + r102) * 31) + this.f483581t) * 31) + this.f483582u.hashCode();
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AISDKConfig(application=" + this.f483562a + ", deviceId=" + this.f483563b + ", appName=" + this.f483564c + ", appId=" + this.f483565d + ", appVersion=" + this.f483566e + ", appVersionCode=" + this.f483567f + ", appPackageName=" + this.f483568g + ", appChannel=" + this.f483569h + ", updateVersionCode=" + this.f483570i + ", isOversea=" + this.f483571j + ", isDebug=" + this.f483572k + ", isTestChannel=" + this.f483573l + ", bid=" + this.f483574m + ", boeEnable=" + this.f483575n + ", boeEnv=" + this.f483576o + ", ppeEnable=" + this.f483577p + ", ppeEnv=" + this.f483578q + ", language=" + this.f483579r + ", fontSizeInPx=" + this.f483580s + ", textZoom=" + this.f483581t + ", settingsHost=" + this.f483582u + ')';
    }

    public a(Context r110, String r111, String r112, int r113, String r114, String r210, String r211, String r212, String r213, boolean r214, boolean r215, boolean r216, String r217, boolean r218, String r219, boolean r310, String r311, String r312, Integer r313, int r314, String r315) {
        Intrinsics.checkNotNullParameter(r110, "application");
        Intrinsics.checkNotNullParameter(r112, "appName");
        Intrinsics.checkNotNullParameter(r114, "appVersion");
        Intrinsics.checkNotNullParameter(r210, DBDefinition.APP_VERSION_CODE);
        Intrinsics.checkNotNullParameter(r211, "appPackageName");
        Intrinsics.checkNotNullParameter(r212, "appChannel");
        Intrinsics.checkNotNullParameter(r213, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r217, "bid");
        Intrinsics.checkNotNullParameter(r219, "boeEnv");
        Intrinsics.checkNotNullParameter(r311, "ppeEnv");
        Intrinsics.checkNotNullParameter(r312, "language");
        Intrinsics.checkNotNullParameter(r315, "settingsHost");
        this.f483562a = r110;
        this.f483563b = r111;
        this.f483564c = r112;
        this.f483565d = r113;
        this.f483566e = r114;
        this.f483567f = r210;
        this.f483568g = r211;
        this.f483569h = r212;
        this.f483570i = r213;
        this.f483571j = r214;
        this.f483572k = r215;
        this.f483573l = r216;
        this.f483574m = r217;
        this.f483575n = r218;
        this.f483576o = r219;
        this.f483577p = r310;
        this.f483578q = r311;
        this.f483579r = r312;
        this.f483580s = r313;
        this.f483581t = r314;
        this.f483582u = r315;
    }
}
