package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerViewExtKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ECWindowInnerFlowBarrageElementPresenter a;

    public a(ECWindowInnerFlowBarrageElementPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        RecyclerViewExtKt.smoothScrollBy(this.a.F(), com.bytedance.android.shopping.extensions.b.b(120), 0, new LinearInterpolator(), ECDraweeView.ROUND, false);
    }
}
