package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class r implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f563997a = null;

    static {
        f563997a = new r();
    }

    public r() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof AppInfoEntity) == false) goto L19;
        AppInfoEntity r101 = (AppInfoEntity) r100;
        int r102 = (((((r101.getAppName().hashCode() + 0) * 31) + r101.getAppPackageName().hashCode()) * 31) + r101.getAppStatus()) * 31;
        if (r101.isExactMatch() == false) goto L7;
        int r103 = 1231;
    L8:
        int r104 = r102 + r103;
        String r105 = r101.getIcon();
        if (r105 == null) goto L11;
        r104 = (r104 * 31) + r105.hashCode();
    L11:
        String r106 = r101.getOpenStoreDetailDeeplink();
        if (r106 == null) goto L14;
        r104 = (r104 * 31) + r106.hashCode();
    L14:
        String r107 = r101.getPackageSize();
        if (r107 != null) goto L17;
        return r104;
    L17:
        return (r104 * 31) + r107.hashCode();
    L7:
        r103 = 1237;
        goto L8
    L19:
        throw new IllegalStateException("Check failed.".toString());
    }
}
