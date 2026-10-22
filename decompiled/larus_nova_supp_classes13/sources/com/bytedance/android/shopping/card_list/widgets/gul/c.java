package com.bytedance.android.shopping.card_list.widgets.gul;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import com.bytedance.android.shopping.api.mall.feed.f;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements f {
    public boolean a;
    public final boolean b;
    public final CardListObjectContainer c;
    public final Function0<Unit> d;

    public final void b() {
        int r0 = com.bytedance.android.shopping.card_list.utils.f.a;
        CardListObjectContainer r1 = this.c;
        if (r1 == null) goto L9;
        com.bytedance.android.shopping.card_list.common_params.a r2 = r1.e;
        if (r2 == null) goto L9;
        Function0<AndroidYaTaInstance> r3 = r2.c;
        if (r3 == null) goto L9;
        AndroidYaTaInstance r4 = (AndroidYaTaInstance) r3.invoke();
    L11:
        if ((!Intrinsics.areEqual(com.bytedance.android.shopping.card_list.utils.f.a(r4, null), Boolean.TRUE)) == false) goto L14;
        this.d.invoke();
        return;
    L14:
        return;
    L9:
        r4 = null;
        goto L11
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.f
    public final void a(ECMallFeedState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        boolean r1 = true;
        switch(b.a[r4.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L22;
        };
    L5:
        this.a = false;
        return;
    L22:
        return;
    L7:
        if (this.a == true) goto L20;
        b();
        this.a = true;
        return;
    L20:
        return;
    L10:
        if (this.b == true) goto L12;
    L16:
        r1 = false;
    L17:
        this.a = r1;
        return;
    L12:
        if (this.a == false) goto L16;
        if (r4 != ECMallFeedState.REFRESHING) goto L16;
        b();
        goto L17
    }

    public c(boolean r2, CardListObjectContainer r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "showGULView");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
