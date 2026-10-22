package fi3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f477261b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477262a;

    public static final class a {
    }

    static {
    }

    public f() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f477262a, ((f) r100).f477262a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f477262a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ClickTabActionParams(groupId=" + this.f477262a + ")";
    }

    public f(String r100) {
        this.f477262a = r100;
    }
}
