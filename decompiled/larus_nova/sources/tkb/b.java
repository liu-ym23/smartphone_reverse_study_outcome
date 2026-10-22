package tkb;

import androidx.compose.ui.geometry.Size;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f546599a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Size.m4647equalsimpl0(this.f546599a, ((b) r100).f546599a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Size.m4652hashCodeimpl(this.f546599a);
    }

    public final String toString() {
        return "ImageOptions(size=" + Size.m4655toStringimpl(this.f546599a) + ')';
    }

    public /* synthetic */ b() {
        this(Size.Companion.m4659getUnspecifiedNHjbRc());
    }

    public b(long r100) {
        this.f546599a = r100;
    }
}
