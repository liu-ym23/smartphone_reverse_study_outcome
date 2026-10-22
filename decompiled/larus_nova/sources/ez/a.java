package ez;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f474829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f474832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f474833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f474835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f474836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f474837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap<String, String> f474838j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L26;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f474829a, r101.f474829a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f474830b, r101.f474830b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f474831c, r101.f474831c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474832d, r101.f474832d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f474833e, r101.f474833e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f474834f, r101.f474834f) == true) goto L18;
        return false;
    L18:
        if (this.f474835g == r101.f474835g) goto L20;
        return false;
    L20:
        if (this.f474836h == r101.f474836h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f474837i, r101.f474837i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474838j, r101.f474838j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Bitmap r100 = this.f474829a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f474830b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f474831c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f474832d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f474833e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f474834f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((((r115 + r117) * 31) + this.f474835g) * 31) + this.f474836h) * 31;
        String r119 = this.f474837i;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        HashMap<String, String> r122 = this.f474838j;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiSearchParams(bitmap=" + this.f474829a + ", pageType=" + this.f474830b + ", enterFrom=" + this.f474831c + ", openSearchPage=" + this.f474832d + ", enterFromSecond=" + this.f474833e + ", searchFrom=" + this.f474834f + ", showBg=" + this.f474835g + ", showSelector=" + this.f474836h + ", federationInfo=" + this.f474837i + ", logMap=" + this.f474838j + ")";
    }

    public a(Bitmap r100, String r101, String r102, HashMap r103) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter("result", "pageType");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter("visual_live_screenshot_entrance", "openSearchPage");
        Intrinsics.checkNotNullParameter("visual_live_screenshot_entrance", "enterFromSecond");
        Intrinsics.checkNotNullParameter("live_screenshot_click", "searchFrom");
        Intrinsics.checkNotNullParameter(r102, "federationInfo");
        Intrinsics.checkNotNullParameter(r103, "logMap");
        this.f474829a = r100;
        this.f474830b = "result";
        this.f474831c = r101;
        this.f474832d = "visual_live_screenshot_entrance";
        this.f474833e = "visual_live_screenshot_entrance";
        this.f474834f = "live_screenshot_click";
        this.f474835g = 1;
        this.f474836h = 1;
        this.f474837i = r102;
        this.f474838j = r103;
    }
}
