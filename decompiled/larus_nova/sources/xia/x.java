package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class x implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f564003a = null;

    static {
        f564003a = new x();
    }

    public x() {
    }

    @Override // xia.c
    public final int a(AppEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        if ((r100 instanceof CloudDocumentEntity) == false) goto L7;
        CloudDocumentEntity r101 = (CloudDocumentEntity) r100;
        return ((r101.getTitle().hashCode() + 0) * 31) + r101.getUrl().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
