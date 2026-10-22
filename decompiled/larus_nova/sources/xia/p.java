package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class p implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f563995a = null;

    static {
        f563995a = new p();
    }

    public p() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        int r101 = (r100.getId().hashCode() + 0) * 31;
        long r102 = r100.getCreateTime();
        int r103 = ((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + r100.getType()) * 31) + r100.get_packageName().hashCode();
        String r104 = r100.getExtraData();
        if (r104 != null) goto L5;
        return r103;
    L5:
        return (r103 * 31) + r104.hashCode();
    }
}
