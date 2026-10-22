package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f563989a = null;

    static {
        f563989a = new j();
    }

    public j() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof ProactiveMemoryEntity) == false) goto L12;
        ProactiveMemoryEntity r101 = (ProactiveMemoryEntity) r100;
        int r102 = r101.getContent().hashCode() + 0;
        String r103 = r101.getTitle();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        Integer r104 = r101.getProductType();
        if (r104 == null) goto L13;
        int r105 = r102 * 31;
        return r105 + r104.intValue();
    L13:
        return r102;
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
