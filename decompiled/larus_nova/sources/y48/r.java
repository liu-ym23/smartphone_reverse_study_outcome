package y48;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class r extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f566129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f566130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f566131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f566132d;

    public r() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f566129a, r101.f566129a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566130b, r101.f566130b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566131c, r101.f566131c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566132d, r101.f566132d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Drawable r100 = this.f566129a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f566130b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f566131c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f566132d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ChatSpeakerFullShadowStyle(background=" + this.f566129a + ", backgroundRes=" + this.f566130b + ", alpha=" + this.f566131c + ", height=" + this.f566132d + ')';
    }

    public r(Integer r100, int r101) {
        if ((r101 & 8) == 0) goto L5;
        r100 = null;
    L5:
        this.f566129a = null;
        this.f566130b = null;
        this.f566131c = null;
        this.f566132d = r100;
    }
}
