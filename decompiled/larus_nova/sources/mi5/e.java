package mi5;

import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f514076a;

    public e(a r100) {
        this.f514076a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IDocPublicPermission r101 = (IDocPublicPermission) r100;
        tt5.a.h("DocShareInfoBehavior", "docPublicPermFlow success");
        ShareDocInfo r102 = this.f514076a.b();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f234248g = r101;
    L5:
        ShareDocInfo r103 = this.f514076a.b();
        if (r103 == null) goto L8;
        r103.f234249h = true;
    L8:
        ShareDocInfo r104 = this.f514076a.b();
        if (r104 == null) goto L11;
        r104.f234251j = false;
    L11:
        a r105 = this.f514076a;
        r105.c(r105.b());
    }
}
