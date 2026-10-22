package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.DoubaoAccountEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f563979a = null;

    static {
        f563979a = new a0();
    }

    public a0() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof DoubaoAccountEntity) == false) goto L7;
        return ((DoubaoAccountEntity) r100).getDoubaoUid().hashCode() + 0;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
