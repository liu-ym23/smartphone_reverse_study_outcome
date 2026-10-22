package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.LifeLogEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f563982a = null;

    static {
        f563982a = new d();
    }

    public d() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof LifeLogEntity) == false) goto L7;
        LifeLogEntity r101 = (LifeLogEntity) r100;
        return ((r101.getTitle().hashCode() + 0) * 31) + r101.getContent().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
