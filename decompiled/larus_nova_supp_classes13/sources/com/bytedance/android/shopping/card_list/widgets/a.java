package com.bytedance.android.shopping.card_list.widgets;

import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements q {
    public Function0<Unit> a;
    public final Function0<String> b;

    public a(int r3) {
        CardListGULViewAction$1 r4 = CardListGULViewAction$1.INSTANCE;
        CardListGULViewAction$2 r0 = CardListGULViewAction$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "scrollByOuterView");
        Intrinsics.checkNotNullParameter(r0, "getPageName");
        this.a = r4;
        this.b = r0;
    }
}
