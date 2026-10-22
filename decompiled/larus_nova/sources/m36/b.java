package m36;

import com.bytedance.ies.bullet.service.base.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<Object> f511738a;

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
        if (Intrinsics.areEqual(this.f511738a, ((b) r100).f511738a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Class<Object> r100 = this.f511738a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "PopupConfig(fragmentCls=" + this.f511738a + ')';
    }

    @Override // com.bytedance.ies.bullet.service.base.v
    public final Class<Object> a() {
        return this.f511738a;
    }

    public b(Object r100) {
        this.f511738a = null;
    }
}
