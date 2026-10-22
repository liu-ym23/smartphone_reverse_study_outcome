package com.bytedance.android.shopping.yata.biz.popup.component;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior;
import hl3.f;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends a implements SheetBaseBehavior.b, View.OnClickListener {
    public View e;
    public View f;
    public SheetBaseBehavior<?> g;
    public ObjectAnimator h;
    public boolean i;
    public boolean j;

    @Override // com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior.b
    public final void b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "sheet");
    }

    public final void d() {
        e(false);
        SheetBaseBehavior<?> r0 = this.g;
        if (r0 == null) goto L5;
        r0.setState(5);
    L5:
        com.bytedance.android.shopping.yata.biz.popup.a r1 = this.a;
        if (r1 == null) goto L19;
        hl3.e r2 = r1.b;
        if (r2 == null) goto L10;
        r2.a(r1);
    L10:
        Iterator<hl3.b> r3 = r1.c.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        r3.next().a(r1);
        goto L12
    L14:
        f r4 = r1.a;
        if (r4 == null) goto L20;
        r4.a(r1);
        return;
    L20:
        return;
    }

    public final void e(boolean r3) {
        if (this.i == true) goto L5;
        return;
    L5:
        ObjectAnimator r0 = this.h;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        if (r3 == false) goto L11;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.f, View.ALPHA, new float[]{0.0f, 1.0f});
    L12:
        this.h = r4;
        if (r4 == null) goto L15;
        r4.setDuration(200);
    L15:
        ObjectAnimator r5 = this.h;
        if (r5 == null) goto L19;
        r5.start();
        return;
    L19:
        return;
    L11:
        r4 = ObjectAnimator.ofFloat(this.f, View.ALPHA, new float[]{1.0f, 0.0f});
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (Intrinsics.areEqual(r3, this.f) == false) goto L18;
        com.bytedance.android.shopping.yata.biz.popup.a r4 = this.a;
        if (r4 == null) goto L14;
        hl3.e r0 = r4.b;
        if (r0 == null) goto L9;
        r0.b(r4);
    L9:
        Iterator<hl3.b> r1 = r4.c.iterator();
    L11:
        if (r1.hasNext() == false) goto L14;
        r1.next().b(r4);
    L14:
        if (this.j == false) goto L19;
        d();
        return;
    L19:
        return;
    }

    public c(Context r2, il3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        super(r2, r3);
    }

    @Override // com.bytedance.android.shopping.yata.biz.popup.behavior.SheetBaseBehavior.b
    public final void a(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "sheet");
        if (r3 != 5) goto L19;
        hl3.c r4 = this.b;
        if (r4 == null) goto L8;
        r4.release();
    L8:
        com.bytedance.android.shopping.yata.biz.popup.a r5 = this.a;
        if (r5 == null) goto L17;
        hl3.e r6 = r5.b;
        if (r6 == null) goto L13;
        r6.d(r5);
    L13:
        Iterator<hl3.b> r7 = r5.c.iterator();
    L15:
        if (r7.hasNext() == false) goto L20;
        r7.next().d(r5);
        goto L15
    L20:
        return;
    L17:
        return;
    }
}
