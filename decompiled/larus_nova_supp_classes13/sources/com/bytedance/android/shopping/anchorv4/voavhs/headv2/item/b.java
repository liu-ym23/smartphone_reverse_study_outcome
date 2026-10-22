package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.utils.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends FrameLayout {
    public ti.l a;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.j b;
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u c;

    public static final class a {
    }

    static {
    }

    public b(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headerDependency");
        super(r2);
        this.c = r3;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = d0.a();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.j r7 = this.b;
        if (r7 == null) goto L5;
        String r8 = r7.a();
    L7:
        if (Intrinsics.areEqual(r8, "ai_combination") == false) goto L10;
        int r9 = com.bytedance.android.ec.hybrid.list.util.c.a;
        wg.a.f(this, 0, -r6, 0, -com.bytedance.android.ec.hybrid.list.util.c.d(20));
        return;
    L10:
        return;
    L5:
        r8 = null;
        goto L7
    }
}
