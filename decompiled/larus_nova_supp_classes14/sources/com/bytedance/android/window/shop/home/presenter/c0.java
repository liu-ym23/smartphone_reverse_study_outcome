package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleRootPresenterV2 a;

    public c0(ECWindowCroppedStyleRootPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Pair r7 = (Pair) r6;
        float r8 = this.a.E();
        ECWindowCroppedStyleRootPresenterV2 r0 = this.a;
        r0.getClass();
        boolean r1 = AbsECWindowPresenter.S(r8, 0.0f);
        boolean r2 = AbsECWindowPresenter.S(r8, 1.0f);
        int r3 = 0;
        if (r1 == true) goto L6;
        if (r2 == true) goto L6;
    L21:
        ECWindowCroppedStyleRootPresenterV2 r4 = this.a;
        ((View) r4.q.getValue()).setAlpha(1 - r8);
        if (r4.T() == false) goto L25;
        r3 = 8;
    L25:
        if (((View) r4.q.getValue()).getVisibility() == r3) goto L29;
        ((View) r4.q.getValue()).setVisibility(r3);
        return;
    L29:
        return;
    L6:
        if (r2 == false) goto L8;
        Unit r5 = (Unit) r0.n.getValue();
        int r9 = 2;
    L9:
        MutableLiveData r10 = r0.O().getCroppedState();
        Integer r11 = (Integer) r10.getValue();
        if (r11 != null) goto L13;
    L14:
        boolean r12 = true;
    L16:
        if (r12 == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L21;
        r10.setValue(Integer.valueOf(r9));
        goto L21
    L13:
        if (r11.intValue() != r9) goto L14;
        r12 = false;
        goto L16
    L8:
        r9 = 1;
        goto L9
    }
}
