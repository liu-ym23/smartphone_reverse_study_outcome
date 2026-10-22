package wj5;

import com.bytedance.ee.bear.DocMetaInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f559988a;

    public c(a r100) {
        this.f559988a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocMetaInfo r101 = (DocMetaInfo) r100;
        tt5.a.h("DocMoreInfoBehavior", "metaFlow ok. ");
        oj5.a r102 = this.f559988a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "docMetaInfo");
        r102.f523536g = r101;
    L5:
        a r103 = this.f559988a;
        r103.e(r103.c());
    }
}
