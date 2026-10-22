package com.bytedance.android.shopping.mall.homepage.card.live;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ NativeLiveCard a;

    public m(NativeLiveCard r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        NativeLiveCard r0 = this.a;
        float r4 = ((Float) r3).floatValue();
        int r1 = NativeLiveCard.Z2;
        r0.o5(r4);
    }
}
