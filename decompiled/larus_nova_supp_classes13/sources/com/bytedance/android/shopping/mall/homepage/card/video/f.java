package com.bytedance.android.shopping.mall.homepage.card.video;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ NativeVideoCard a;

    public f(NativeVideoCard r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        NativeVideoCard r0 = this.a;
        float r4 = ((Float) r3).floatValue();
        int r1 = NativeVideoCard.T1;
        r0.P4(r4);
    }
}
