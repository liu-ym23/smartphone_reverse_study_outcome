package wj5;

import com.bytedance.ee.bear.DocMetaInfo;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        DocMetaInfo r4 = (DocMetaInfo) r3;
        tt5.a.h("DocMoreInfoBehavior", "metaFlow ok. ");
        oj5.a r0 = this.a.c();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "docMetaInfo");
        r0.g = r4;
    L5:
        a r5 = this.a;
        r5.e(r5.c());
    }
}
