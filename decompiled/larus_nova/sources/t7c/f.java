package t7c;

import com.larksuite.arch.jack.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545015a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f545015a, ((f) r100).f545015a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f545015a.hashCode();
    }

    public final String toString() {
        return "TitleSectionViewState(title=" + this.f545015a + ')';
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f545015a = r100;
    }
}
