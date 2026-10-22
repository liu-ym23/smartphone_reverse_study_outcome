package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class z implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f564005a = null;

    static {
        f564005a = new z();
    }

    public z() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof CountdownEntity) == false) goto L12;
        CountdownEntity r101 = (CountdownEntity) r100;
        long r102 = r101.getCountdownSeconds();
        int r103 = ((int) (r102 ^ (r102 >>> 32))) + 0;
        String r104 = r101.getLabel();
        if (r104 == null) goto L7;
        r103 = (r103 * 31) + r104.hashCode();
    L7:
        CountdownStatusEnum r105 = r101.getStatus();
        if (r105 != null) goto L10;
        return r103;
    L10:
        return (r103 * 31) + r105.name().hashCode();
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
