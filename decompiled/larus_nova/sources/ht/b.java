package ht;

import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.ies.sve_core.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f487099b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.sve_list.b<d0> f487100a;

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
        if (Intrinsics.areEqual(this.f487100a, ((b) r100).f487100a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        com.bytedance.ies.sve_list.b<d0> r100 = this.f487100a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CoLComponentDataState(items=" + this.f487100a + ")";
    }

    public b(com.bytedance.ies.sve_list.b<d0> r100) {
        this.f487100a = r100;
    }
}
