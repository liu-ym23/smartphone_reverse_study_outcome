package wj5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f559992a;

    public g(a r100) {
        this.f559992a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocPermission r101 = (DocPermission) r100;
        tt5.a.h("DocMoreInfoBehavior", "permFlow ok. ");
        oj5.a r102 = this.f559992a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "docPermission");
        r102.f523538i = r101;
    L5:
        a r103 = this.f559992a;
        r103.e(r103.c());
    }
}
