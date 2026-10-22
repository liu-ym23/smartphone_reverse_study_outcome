package com.bytedance.ee.bear.list.more.more3;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ SpaceFolderMoreProvider.b a;

    public q(SpaceFolderMoreProvider.b r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "throwable");
        tt5.a.e("SpaceFolderMoreProvider", "folderComplaintFlow err. ", r5, false);
        if (ax4.d.b(r5, 7) == false) goto L9;
        oj5.b r6 = this.a.c();
        if (r6 == null) goto L7;
        r6.r = true;
    L7:
        SpaceFolderMoreProvider.b r7 = this.a;
        r7.e(r7.c());
        return;
    }
}
