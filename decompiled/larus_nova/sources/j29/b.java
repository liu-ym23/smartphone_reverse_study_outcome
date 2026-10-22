package j29;

import com.larus.bmhome.actionbar.model.j1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b implements t1a.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f497039b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1 f497040a;

    public static final class a {
    }

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f497040a, ((b) r100).f497040a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        j1 r100 = this.f497040a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "InstructionConfExtWrap(avatarDetectInfo=" + this.f497040a + ')';
    }

    static {
    }

    public b(j1 r100) {
        this.f497040a = r100;
    }
}
