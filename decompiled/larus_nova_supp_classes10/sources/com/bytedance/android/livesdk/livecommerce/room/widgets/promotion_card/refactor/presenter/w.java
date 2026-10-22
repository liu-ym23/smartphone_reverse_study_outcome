package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements View.OnLayoutChangeListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ View b;

    public w(Function0 r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.a.invoke();
        this.b.removeOnLayoutChangeListener(this);
    }
}
