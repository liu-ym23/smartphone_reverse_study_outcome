package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ICSProtocolEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f563978a = null;

    static {
        f563978a = new a();
    }

    public a() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof ICSProtocolEntity) == false) goto L9;
        ICSProtocolEntity r101 = (ICSProtocolEntity) r100;
        int r102 = r101.getDoubaoUid().hashCode() + 0;
        String r103 = r101.getICal();
        if (r103 != null) goto L7;
        return r102;
    L7:
        return (r102 * 31) + r103.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
