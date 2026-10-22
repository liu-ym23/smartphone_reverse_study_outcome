package wj5;

import com.bytedance.ee.bear.DocObjInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f559990a;

    public e(a r100) {
        this.f559990a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocObjInfo r101 = (DocObjInfo) r100;
        tt5.a.h("DocMoreInfoBehavior", "objInfoFlow ok. ");
        oj5.a r102 = this.f559990a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "docObjInfo");
        r102.f523537h = r101;
    L5:
        a r103 = this.f559990a;
        r103.e(r103.c());
    }
}
