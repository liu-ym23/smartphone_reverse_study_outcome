package wj5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f560005a;

    public n(l r100) {
        this.f560005a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IDocPublicPermission r101 = (IDocPublicPermission) r100;
        tt5.a.h("DocShortcutMoreInfoBehavior", "publicPermissionFlow ok. ");
        oj5.a r102 = this.f560005a.c();
        if (r102 == null) goto L5;
        r102.f523546q = false;
    L5:
        oj5.a r103 = this.f560005a.c();
        if (r103 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "publicPermission");
        DocPermission r104 = r103.f523538i;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r104.f234420b = r101;
    L8:
        l r105 = this.f560005a;
        r105.e(r105.c());
    }
}
