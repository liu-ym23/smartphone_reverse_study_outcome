package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.WebsiteEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class u implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f564000a = null;

    static {
        f564000a = new u();
    }

    public u() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof WebsiteEntity) == false) goto L9;
        WebsiteEntity r101 = (WebsiteEntity) r100;
        int r102 = r101.getWebUrl().hashCode() + 0;
        String r103 = r101.getTitle();
        if (r103 != null) goto L7;
        return r102;
    L7:
        return (r102 * 31) + r103.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
