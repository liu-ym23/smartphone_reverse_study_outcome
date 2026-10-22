package ev6;

import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f474415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f474416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f474417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f474418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f474419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f474420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f474421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f474422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f474423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, ? extends Object> f474424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, ? extends Object> f474425k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f0 f474426l;

    public r() {
        this(false, false, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f474415a == r101.f474415a) goto L12;
        return false;
    L12:
        if (this.f474416b == r101.f474416b) goto L15;
        return false;
    L15:
        if (this.f474417c == r101.f474417c) goto L18;
        return false;
    L18:
        if (this.f474418d == r101.f474418d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474419e, r101.f474419e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474420f, r101.f474420f) == true) goto L27;
        return false;
    L27:
        if (this.f474421g == r101.f474421g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474422h, r101.f474422h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f474423i, r101.f474423i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f474424j, r101.f474424j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f474425k, r101.f474425k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f474426l, r101.f474426l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f474415a == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.f474416b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f474417c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.f474418d == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r105 + r106) * 31;
        String r108 = this.f474419e;
        int r109 = 0;
        if (r108 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r107 + r110) * 31;
        String r112 = this.f474420f;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        if (this.f474421g == true) goto L22;
        r100 = 1237;
    L22:
        int r115 = (r114 + r100) * 31;
        String r116 = this.f474422h;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f474423i;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, ? extends Object> r122 = this.f474424j;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, ? extends Object> r125 = this.f474425k;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        f0 r128 = this.f474426l;
        if (r128 == null) goto L43;
        r109 = r128.hashCode();
    L43:
        return r127 + r109;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r108.hashCode();
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShelfProductLotteryUIData(countDownInfoVisible=" + this.f474415a + ", currTime=" + this.f474416b + ", drawTime=" + this.f474417c + ", isFitFormatLength=" + this.f474418d + ", countDownTextColor=" + this.f474419e + ", hintText=" + this.f474420f + ", clickInfoVisible=" + this.f474421g + ", clickText=" + this.f474422h + ", clickArrowUrl=" + this.f474423i + ", payload=" + this.f474424j + ", trackingParams=" + this.f474425k + ", soldInfo=" + this.f474426l + ')';
    }

    public r(boolean r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 64) == 0) goto L8;
        r101 = false;
    L8:
        this.f474415a = r100;
        this.f474416b = 0;
        this.f474417c = 0;
        this.f474418d = false;
        this.f474419e = null;
        this.f474420f = null;
        this.f474421g = r101;
        this.f474422h = null;
        this.f474423i = null;
        this.f474424j = null;
        this.f474425k = null;
        this.f474426l = null;
    }
}
