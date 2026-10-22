package com.bytedance.ee.bear.wikiv2;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiException;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ WikiFragment a;

    public c(WikiFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        boolean r2 = false;
        tt5.a.e("WikiFragment", "Load onError. ", r7, false);
        WikiFragment r1 = this.a;
        Intrinsics.checkNotNull(r7);
        int r3 = WikiFragment.l;
        if (r1.getChildFragmentManager().findFragmentById(2131393212) == null) goto L5;
        r2 = true;
    L5:
        tt5.a.h("WikiFragment", "dispatchLoadFail, contentLoaded: " + r2);
        if (r2 == true) goto L8;
    L10:
        if (r7 != null) goto L12;
        r1.Z90().c(2);
        return;
    L12:
        r1.Z90().e(r7);
        return;
    L8:
        if (WikiException.isNotFound(r7) == true) goto L10;
    }
}
