package wj5;

import com.bytedance.ee.bear.DocMetaInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f560007a;

    public p(l r100) {
        this.f560007a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocMetaInfo r101 = (DocMetaInfo) r100;
        tt5.a.h("DocShortcutMoreInfoBehavior", "metaFlow ok. ");
        oj5.a r102 = this.f560007a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "docMetaInfo");
        r102.f523536g = r101;
    L5:
        l r103 = this.f560007a;
        r103.e(r103.c());
    }
}
