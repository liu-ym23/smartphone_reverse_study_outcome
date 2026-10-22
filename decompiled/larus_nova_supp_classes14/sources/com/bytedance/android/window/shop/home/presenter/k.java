package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ ECWindowCroppedStyleAnimationPresenter a;
    public final /* synthetic */ float b;

    public k(ECWindowCroppedStyleAnimationPresenter r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        this.a.b0().setY(this.b + ((Integer) r3).intValue());
    }
}
