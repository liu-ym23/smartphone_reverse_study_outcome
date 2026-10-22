package wj5;

import com.bytedance.ee.bear.DocObjInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f560009a;

    public r(l r100) {
        this.f560009a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocObjInfo r101 = (DocObjInfo) r100;
        tt5.a.h("DocShortcutMoreInfoBehavior", "objInfoFlow ok. ");
        oj5.a r102 = this.f560009a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "docObjInfo");
        r102.f523537h = r101;
    L5:
        l r103 = this.f560009a;
        r103.e(r103.c());
    }
}
