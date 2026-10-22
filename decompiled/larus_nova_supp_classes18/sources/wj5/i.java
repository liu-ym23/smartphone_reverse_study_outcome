package wj5;

import com.bytedance.ee.bear.list.dto.DocVersion;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ a a;

    public i(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        DocVersion r4 = (DocVersion) r3;
        tt5.a.h("DocMoreInfoBehavior", "ownerTypeFlow ok. ");
        oj5.a r0 = this.a.c();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "docVersion");
        r0.j = r4;
    L5:
        a r5 = this.a;
        r5.e(r5.c());
    }
}
