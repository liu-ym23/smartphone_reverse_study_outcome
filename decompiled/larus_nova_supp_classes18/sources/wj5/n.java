package wj5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ l a;

    public n(l r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        IDocPublicPermission r4 = (IDocPublicPermission) r3;
        tt5.a.h("DocShortcutMoreInfoBehavior", "publicPermissionFlow ok. ");
        oj5.a r0 = this.a.c();
        if (r0 == null) goto L5;
        r0.q = false;
    L5:
        oj5.a r1 = this.a.c();
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "publicPermission");
        DocPermission r2 = r1.i;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.b = r4;
    L8:
        l r5 = this.a;
        r5.e(r5.c());
    }
}
