package wj5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ l a;

    public x(l r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        IDocUserPermission r4 = (IDocUserPermission) r3;
        tt5.a.h("DocShortcutMoreInfoBehavior", "docPermissionFlow ok. ");
        oj5.a r0 = this.a.c();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "userPermission");
        DocPermission r1 = r0.i;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.a = r4;
    L5:
        l r5 = this.a;
        r5.e(r5.c());
    }
}
