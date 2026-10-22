package com.bytedance.android.shopping.collect.custom_view;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements com.bytedance.android.shopping.api.mall.feed.f {
    public boolean a;
    public final AndroidYaTaInstance b;
    public final Function0<Unit> c;

    @Override // com.bytedance.android.shopping.api.mall.feed.f
    public final void a(ECMallFeedState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        switch(c.a[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L17;
        };
    L5:
        this.a = false;
        return;
    L12:
        this.a = false;
        return;
    L17:
        return;
    L7:
        if (this.a == true) goto L15;
        int r3 = com.bytedance.android.shopping.collect.util.e.e;
        if (com.bytedance.android.shopping.collect.util.e.a.a(this.b) == true) goto L11;
        this.c.invoke();
    L11:
        this.a = true;
        return;
    }

    public d(AndroidYaTaInstance r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "showGULView");
        this.b = r2;
        this.c = r3;
    }
}
