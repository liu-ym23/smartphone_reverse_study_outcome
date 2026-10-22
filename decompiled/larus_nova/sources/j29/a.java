package j29;

import kotlin.jvm.internal.Intrinsics;
import zp9.g;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements t1a.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f497037b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f497038a;

    /* JADX INFO: renamed from: j29.a$a, reason: collision with other inner class name */
    public static final class C6384a {
    }

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f497038a, ((a) r100).f497038a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        g r100 = this.f497038a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CreationTrackParamsWrap(creationFeedTrackParams=" + this.f497038a + ')';
    }

    static {
    }

    public a(g r100) {
        this.f497038a = r100;
    }
}
