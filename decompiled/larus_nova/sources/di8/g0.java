package di8;

import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f468782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f468783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f468784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f468785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f468786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<View> f468787f;

    public g0() {
        this(null, null, null, false, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f468782a, r101.f468782a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468783b, r101.f468783b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f468784c, r101.f468784c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f468785d, r101.f468785d) == true) goto L21;
        return false;
    L21:
        if (this.f468786e == r101.f468786e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f468787f, r101.f468787f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f468782a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f468783b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f468784c.hashCode()) * 31;
        Integer r107 = this.f468785d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f468786e == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        Function0<View> r112 = this.f468787f;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = 1237;
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
        return "NestedMenuLeftModel(iconRes=" + this.f468782a + ", iconUrl=" + this.f468783b + ", imageName=" + this.f468784c + ", iconSizePx=" + this.f468785d + ", showOriginColor=" + this.f468786e + ", customViewProvider=" + this.f468787f + ')';
    }

    public g0(Integer r100, String r101, Integer r102, boolean r103, gi8.a r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L11;
        String r106 = "";
    L13:
        if ((r105 & 8) == 0) goto L16;
        r102 = null;
    L16:
        if ((r105 & 16) == 0) goto L19;
        r103 = false;
    L19:
        if ((r105 & 32) == 0) goto L21;
        r104 = null;
    L21:
        Intrinsics.checkNotNullParameter(r106, "imageName");
        this.f468782a = r100;
        this.f468783b = r101;
        this.f468784c = r106;
        this.f468785d = r102;
        this.f468786e = r103;
        this.f468787f = r104;
        return;
    L11:
        r106 = null;
        goto L13
    }
}
