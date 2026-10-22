package com.bytedance.ee.bear.share.newshare;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ ShareFolderFragment a;

    public m(ShareFolderFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.f("ShareFolderFragment", r4, false);
        ShareFolderFragment r0 = this.a;
        Intrinsics.checkNotNull(r4);
        r0.Ma0(r4);
        ShareFolderFragment.Qa0(this.a);
    }
}
