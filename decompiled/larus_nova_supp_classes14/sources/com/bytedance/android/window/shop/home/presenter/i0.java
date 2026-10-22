package com.bytedance.android.window.shop.home.presenter;

import android.view.Choreographer;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0 implements AppBarLayout.OnOffsetChangedListener {
    public final /* synthetic */ AppBarLayout a;
    public final /* synthetic */ ECWindowDialogStyleRootPresenter b;

    public i0(AppBarLayout r1, ECWindowDialogStyleRootPresenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onOffsetChanged(AppBarLayout r5, int r6) {
        Pair r7 = new Pair(Integer.valueOf(r6), Integer.valueOf(this.a.getTotalScrollRange()));
        ECWindowParam r0 = this.b.O().getShopParam();
        ECWindowDialogStyleRootPresenter r1 = this.b;
        float r2 = ((Number) r7.getFirst()).intValue();
        float r3 = ((Number) r7.getSecond()).intValue();
        r1.getClass();
        r0.setTopMode(AbsECWindowPresenter.S(r2, r3));
        Pair r4 = (Pair) this.b.O().getOffsetState().getValue();
        if (r4 != null) goto L5;
    L8:
        this.b.O().getOffsetState().setValue(r7);
        this.b.O().getCollapseProgress().setValue(Float.valueOf(this.b.E()));
        MutableLiveData<Float> r8 = this.b.O().getSubCollapseProgress();
        ECWindowDialogStyleRootPresenter r9 = this.b;
        r8.setValue(Float.valueOf(r9.Y(((View) r9.o.getValue()).getHeight())));
        final ECWindowDialogStyleRootPresenter r10 = this.b;
        r10.getClass();
        Choreographer.getInstance().postFrameCallback(new j0(new ECWindowDialogStyleRootPresenter$updateMultiDispatchActiveRange$1(r10)));
        if (Math.abs(((Number) r7.getFirst()).intValue()) != 0) goto L11;
    L12:
        ECWindowDialogStyleRootPresenter.a0(this.b);
    L13:
        this.b.y().setBackgroundColor(ColorUtils.blendARGB(((Number) this.b.m.getValue()).intValue(), ((Number) this.b.n.getValue()).intValue(), 1 + (r6 / this.a.getTotalScrollRange())));
        return;
    L11:
        if (Math.abs(((Number) r7.getFirst()).intValue()) != Math.abs(((Number) r7.getSecond()).intValue())) goto L13;
    L5:
        if (((Number) r4.getFirst()).intValue() != ((Number) r7.getFirst()).intValue()) goto L8;
        if (((Number) r4.getSecond()).intValue() == ((Number) r7.getSecond()).intValue()) goto L13;
        goto L8
    }
}
