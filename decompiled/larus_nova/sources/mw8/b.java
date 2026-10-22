package mw8;

import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f515992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f515993b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Float.compare(this.f515992a, r101.f515992a) == 0) goto L12;
        return false;
    L12:
        if (this.f515993b == r101.f515993b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f515992a) * 31) + this.f515993b;
    }

    public final String toString() {
        return "LatexSingleConfig(latexTextSize=" + this.f515992a + ", latexTextColor=" + this.f515993b + ')';
    }

    public /* synthetic */ b(int r100) {
        this(48.0f, FakePickerAvatarCreator.BLUE);
    }

    public b(float r100, int r101) {
        this.f515992a = r100;
        this.f515993b = r101;
    }
}
