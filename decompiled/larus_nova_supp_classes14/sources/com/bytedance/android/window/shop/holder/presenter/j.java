package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ WindowHeaderBubbleItemPresenter a;
    public final /* synthetic */ uq3.e b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Function0 e;

    public j(WindowHeaderBubbleItemPresenter r1, uq3.e r2, View r3, int r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void onChanged(Object r9) {
        Integer r10 = (Integer) r9;
        WindowHeaderBubbleItemPresenter r11 = this.a;
        if (r11.l != null) goto L23;
        String r3 = this.b.g;
        if (r3 == null) goto L24;
        View r2 = this.c;
        int r1 = this.d;
        if (r1 != 1) goto L11;
        List r4 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.o());
    L18:
        r11.l = new com.bytedance.android.ec.window.base.common.bubble.r(r2, r3, null, r4, new i(this), 316);
        com.bytedance.android.ec.window.base.common.bubble.r r12 = this.a.l;
        if (r12 == null) goto L21;
        r12.b();
    L21:
        SharedPrefHelper r13 = (SharedPrefHelper) this.a.j.getValue();
        r13.l("sp_key_guide_bubble_show", Boolean.TRUE);
        r13.a();
        return;
    L11:
        if (r1 != 2) goto L13;
        r4 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.a());
        goto L18
    L13:
        if (r1 == 3) goto L15;
        r4 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.a());
        goto L18
    L15:
        r4 = CollectionsKt.listOf(new com.bytedance.android.ec.window.base.common.bubble.p());
        goto L18
    L24:
        return;
    }
}
