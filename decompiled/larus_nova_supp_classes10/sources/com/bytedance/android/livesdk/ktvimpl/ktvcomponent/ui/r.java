package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public r(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.livesdk.ktvimpl.base.i r3 = (com.bytedance.android.livesdk.ktvimpl.base.i) sh6.c.b((sh6.b) r2);
        if (r3 == null) goto L12;
        PublishSubject<fd2.a> r4 = r3.g;
        if (r4 == null) goto L13;
        Observable r5 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r5 == null) goto L14;
        Disposable r6 = r5.subscribe(new q(this));
        if (r6 == null) goto L15;
        RxUtilKt.c(r6, this.a.w);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
