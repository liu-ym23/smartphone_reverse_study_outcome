package ht;

import com.bytedance.ies.sve_core.s;
import com.bytedance.ies.sve_core.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f487096c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f487097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f487098b;

    /* JADX INFO: renamed from: ht.a$a, reason: collision with other inner class name */
    public static final class C6194a {
        public static u a() {
            return new u("Bottom_Loading_State");
        }
    }

    static {
    }

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f487097a, r101.f487097a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f487098b, r101.f487098b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f487097a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f487098b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BottomLoadingState(isLoading=" + this.f487097a + ", isLoadError=" + this.f487098b + ")";
    }

    public a(Boolean r100, Boolean r101) {
        this.f487097a = r100;
        this.f487098b = r101;
    }
}
