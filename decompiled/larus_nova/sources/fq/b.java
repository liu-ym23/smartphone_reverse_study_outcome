package fq;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IAction> f478398a;

    public static final class a {
    }

    static {
    }

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f478398a, ((b) r100).f478398a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<IAction> r100 = this.f478398a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "GroupActionParams(actions=" + this.f478398a + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends IAction> r100) {
        this.f478398a = r100;
    }
}
