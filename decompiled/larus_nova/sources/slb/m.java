package slb;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f542546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<j> f542547b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f542546a, r101.f542546a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542547b, r101.f542547b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f542546a.hashCode() * 31) + this.f542547b.hashCode();
    }

    public final String toString() {
        return "PromptGroup(title=" + this.f542546a + ", prompts=" + this.f542547b + ')';
    }

    public m(String r100, ArrayList<j> r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "prompts");
        this.f542546a = r100;
        this.f542547b = r101;
    }
}
