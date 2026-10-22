package fi3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f477314c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f477315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f477316b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L10;
        s r101 = (s) r100;
        if (this.f477315a == r101.f477315a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477316b, r101.f477316b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f477315a * 31;
        List<String> r101 = this.f477316b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "PDPJumpToImageDetailParams(index=" + this.f477315a + ", imageList=" + this.f477316b + ")";
    }

    public s(int r100, List<String> r101) {
        this.f477315a = r100;
        this.f477316b = r101;
    }
}
