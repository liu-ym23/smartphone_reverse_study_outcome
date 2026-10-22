package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ VideoChorusTopBarControlContainer a;
    public final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c b;

    public r(VideoChorusTopBarControlContainer r1, com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r7 = this.b;
        if (r7 == null) goto L10;
        jd2.c r8 = r7.f();
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.a != 2) goto L12;
        VideoChorusTopBarControlContainer r9 = this.a;
        r9.l(VideoChorusTopBarControlContainer.h(r9), VideoChorusTopBarControlContainer.i(this.a));
        return;
    L12:
        return;
    }
}
