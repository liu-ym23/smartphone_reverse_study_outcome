package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleAnimationPresenter.a a;

    public m(ECWindowCroppedStyleAnimationPresenter.a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        Float r8 = (Float) r7;
        if (r8.floatValue() > 0) goto L6;
        ECWindowCroppedStyleAnimationPresenter r9 = this.a.a;
        int r0 = ECWindowCroppedStyleAnimationPresenter.B;
        r9.c0().setVisibility(4);
        r9.c0().setAlpha(0.0f);
        ((View) r9.t.getValue()).setTranslationY(-r9.y);
        r9.d0().setTranslationY(-r9.y);
        r9.a0(0.0f);
        return;
    L6:
        if (r8.floatValue() < 0.99d) goto L8;
        ECWindowCroppedStyleAnimationPresenter r10 = this.a.a;
        int r1 = ECWindowCroppedStyleAnimationPresenter.B;
        ExtensionsKt.gone(r10.b0());
        r10.c0().setAlpha(1.0f);
        ((View) r10.t.getValue()).setTranslationY(0.0f);
        r10.d0().setTranslationY(0.0f);
        r10.A = true;
        return;
    L8:
        ECWindowCroppedStyleAnimationPresenter r2 = this.a.a;
        float r11 = r8.floatValue();
        int r3 = ECWindowCroppedStyleAnimationPresenter.B;
        r2.a0(r11);
    }
}
