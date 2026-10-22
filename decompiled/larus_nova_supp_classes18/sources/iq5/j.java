package iq5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.d a;

    public j(com.bytedance.ee.bear.wikiv2.selector.d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.d("FolderSelectPresenter", "loadData()...error = " + r4);
        this.a.c.E(r4);
    }
}
