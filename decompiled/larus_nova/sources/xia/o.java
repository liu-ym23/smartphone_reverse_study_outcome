package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.SimCardEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class o implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f563994a = null;

    static {
        f563994a = new o();
    }

    public o() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof SimCardEntity) == false) goto L15;
        SimCardEntity r101 = (SimCardEntity) r100;
        int r102 = r101.getSimSlot().hashCode() + 0;
        String r103 = r101.getSimCarrier();
        if (r103 == null) goto L7;
        r102 = (r102 * 31) + r103.hashCode();
    L7:
        String r104 = r101.getPhoneNumber();
        if (r104 == null) goto L10;
        r102 = (r102 * 31) + r104.hashCode();
    L10:
        String r105 = r101.getAnonymizedPhoneNumber();
        if (r105 != null) goto L13;
        return r102;
    L13:
        return (r102 * 31) + r105.hashCode();
    L15:
        throw new IllegalStateException("Check failed.".toString());
    }
}
