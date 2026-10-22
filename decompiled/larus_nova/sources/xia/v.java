package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.BrowserBookmarkEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class v implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f564001a = null;

    static {
        f564001a = new v();
    }

    public v() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof BrowserBookmarkEntity) == false) goto L7;
        BrowserBookmarkEntity r101 = (BrowserBookmarkEntity) r100;
        return ((r101.getTitle().hashCode() + 0) * 31) + r101.getWebUrl().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
