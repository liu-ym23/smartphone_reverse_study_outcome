package hq9;

import androidx.fragment.app.Fragment;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumSettingConfig;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Fragment> f486527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<xp9.i, Unit> f486528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<xp9.i, Unit> f486529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AlbumSettingConfig f486530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f486531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f486532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f486533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final kq9.e f486534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f486535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f486536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f486537k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MediaPickerUIMode f486538l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larus.platform.api.b0 f486539m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f486540n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f486541o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f486542p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f486543q;

    public b0() {
        this(null, null, null, null, 0, null, null, null, null, null, 131071);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f486527a, r101.f486527a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486528b, r101.f486528b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f486529c, r101.f486529c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486530d, r101.f486530d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486531e, r101.f486531e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f486532f, r101.f486532f) == true) goto L27;
        return false;
    L27:
        if (this.f486533g == r101.f486533g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f486534h, r101.f486534h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f486535i, r101.f486535i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f486536j, r101.f486536j) == true) goto L39;
        return false;
    L39:
        if (this.f486537k == r101.f486537k) goto L42;
        return false;
    L42:
        if (this.f486538l == r101.f486538l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f486539m, r101.f486539m) == true) goto L48;
        return false;
    L48:
        if (this.f486540n == r101.f486540n) goto L51;
        return false;
    L51:
        if (this.f486541o == r101.f486541o) goto L54;
        return false;
    L54:
        if (this.f486542p == r101.f486542p) goto L57;
        return false;
    L57:
        if (this.f486543q == r101.f486543q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        WeakReference<Fragment> r100 = this.f486527a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function1<xp9.i, Unit> r104 = this.f486528b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function1<xp9.i, Unit> r107 = this.f486529c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        AlbumSettingConfig r110 = this.f486530d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f486531e.hashCode()) * 31;
        Function0<Unit> r113 = this.f486532f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.f486533g) * 31;
        kq9.e r116 = this.f486534h;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Function0<Unit> r119 = this.f486535i;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Function0<Unit> r122 = this.f486536j;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        int r125 = 1231;
        if (this.f486537k == false) goto L37;
        int r126 = 1231;
    L38:
        int r127 = (((r124 + r126) * 31) + this.f486538l.hashCode()) * 31;
        com.larus.platform.api.b0 r128 = this.f486539m;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        int r129 = (r127 + r101) * 31;
        if (this.f486540n == false) goto L45;
        int r130 = 1231;
    L46:
        int r131 = (r129 + r130) * 31;
        if (this.f486541o == false) goto L49;
        int r132 = 1231;
    L50:
        int r133 = (r131 + r132) * 31;
        if (this.f486542p == false) goto L53;
        int r134 = 1231;
    L54:
        int r135 = (r133 + r134) * 31;
        if (this.f486543q == true) goto L59;
        r125 = 1237;
    L59:
        return r135 + r125;
    L53:
        r134 = 1237;
        goto L54
    L49:
        r132 = 1237;
        goto L50
    L45:
        r130 = 1237;
        goto L46
    L37:
        r126 = 1237;
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
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BottomPhotoPickerPageConfig(quickAlbumInputHost=" + this.f486527a + ", resultCallback=" + this.f486528b + ", multiResultCallback=" + this.f486529c + ", albumSettingConfig=" + this.f486530d + ", displayType=" + this.f486531e + ", guideCallback=" + this.f486532f + ", bottomPeekHeight=" + this.f486533g + ", traceInfo=" + this.f486534h + ", dismissCallback=" + this.f486535i + ", backCallback=" + this.f486536j + ", needEnterInAnimation=" + this.f486537k + ", pageMode=" + this.f486538l + ", pageSlideCallback=" + this.f486539m + ", isImmerseStyle=" + this.f486540n + ", forceDayMode=" + this.f486541o + ", useBottomPhotoPickerFragmentV3=" + this.f486542p + ", enableEmbeddedTouchIntercept=" + this.f486543q + ')';
    }

    public /* synthetic */ b0(Function1 r210, AlbumSettingConfig r211, String r212, Function0 r213, int r214, kq9.e r215, Function0 r216, Function0 r217, MediaPickerUIMode r218, com.larus.platform.api.b0 r219, int r310) {
        if ((r310 & 2) == 0) goto L5;
        Function1 r100 = null;
    L7:
        if ((r310 & 8) == 0) goto L9;
        AlbumSettingConfig r101 = null;
    L11:
        if ((r310 & 16) == 0) goto L13;
        String r102 = "album_display";
    L15:
        if ((r310 & 32) == 0) goto L17;
        Function0 r103 = null;
    L19:
        if ((r310 & 64) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r310 & 128) == 0) goto L25;
        kq9.e r105 = null;
    L27:
        if ((r310 & 256) == 0) goto L29;
        Function0 r110 = null;
    L31:
        if ((r310 & 512) == 0) goto L33;
        Function0 r111 = null;
    L35:
        if ((r310 & 2048) == 0) goto L37;
        MediaPickerUIMode r112 = MediaPickerUIMode.NORMAL;
    L39:
        if ((r310 & 4096) == 0) goto L41;
        com.larus.platform.api.b0 r113 = null;
    L42:
        this(null, r100, null, r101, r102, r103, r104, r105, r110, r111, false, r112, r113, false, false, false, false);
        return;
    L41:
        r113 = r219;
        goto L42
    L37:
        r112 = r218;
        goto L39
    L33:
        r111 = r217;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(WeakReference<Fragment> r100, Function1<? super xp9.i, Unit> r101, Function1<? super xp9.i, Unit> r102, AlbumSettingConfig r103, String r104, Function0<Unit> r110, int r111, kq9.e r112, Function0<Unit> r113, Function0<Unit> r114, boolean r115, MediaPickerUIMode r116, com.larus.platform.api.b0 r117, boolean r118, boolean r119, boolean r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r104, "displayType");
        Intrinsics.checkNotNullParameter(r116, "pageMode");
        this.f486527a = r100;
        this.f486528b = r101;
        this.f486529c = r102;
        this.f486530d = r103;
        this.f486531e = r104;
        this.f486532f = r110;
        this.f486533g = r111;
        this.f486534h = r112;
        this.f486535i = r113;
        this.f486536j = r114;
        this.f486537k = r115;
        this.f486538l = r116;
        this.f486539m = r117;
        this.f486540n = r118;
        this.f486541o = r119;
        this.f486542p = r210;
        this.f486543q = r211;
    }
}
