package mi5;

import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ a a;

    public e(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        IDocPublicPermission r4 = (IDocPublicPermission) r3;
        tt5.a.h("DocShareInfoBehavior", "docPublicPermFlow success");
        ShareDocInfo r0 = this.a.b();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.g = r4;
    L5:
        ShareDocInfo r5 = this.a.b();
        if (r5 == null) goto L8;
        r5.h = true;
    L8:
        ShareDocInfo r6 = this.a.b();
        if (r6 == null) goto L11;
        r6.j = false;
    L11:
        a r7 = this.a;
        r7.c(r7.b());
    }
}
