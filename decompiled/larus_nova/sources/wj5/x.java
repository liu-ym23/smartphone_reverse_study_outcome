package wj5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f560015a;

    public x(l r100) {
        this.f560015a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IDocUserPermission r101 = (IDocUserPermission) r100;
        tt5.a.h("DocShortcutMoreInfoBehavior", "docPermissionFlow ok. ");
        oj5.a r102 = this.f560015a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "userPermission");
        DocPermission r103 = r102.f523538i;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r103.f234419a = r101;
    L5:
        l r104 = this.f560015a;
        r104.e(r104.c());
    }
}
