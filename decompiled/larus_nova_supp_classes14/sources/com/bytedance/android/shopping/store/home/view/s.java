package com.bytedance.android.shopping.store.home.view;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.a2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s implements Runnable {
    public final /* synthetic */ FollowGiftBubbleView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ViewGroup c;

    public s(FollowGiftBubbleView r1, View r2, ViewGroup r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.TextView, com.bytedance.android.shopping.store.home.view.FollowGiftBubbleView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        int[] r1 = new int[2];
        int[] r0 = new int[2];
        this.b.getLocationInWindow(r1);
        this.c.getLocationInWindow(r0);
        dm.a.a("FollowGiftBubbleView").a("anchorView location: (" + r1[0] + ',' + r1[1] + "), containerLocation: (" + r0[0] + ", " + r0[1] + ')');
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, FollowGiftBubbleView.e);
        r2.rightMargin = (r0[0] + this.c.getWidth()) - (r1[0] + this.b.getWidth());
        r2.topMargin = (r1[1] - r0[1]) - FollowGiftBubbleView.d;
        r2.gravity = 8388661;
        ?? r3 = this.a;
        r3.setText(r3.a);
        String r4 = this.a.b;
        String r5 = null;
        if (r4 != null) goto L5;
    L10:
        String r6 = this.a.c;
        if (r6 != null) goto L13;
    L19:
        this.a.y();
        this.c.addView(this.a, r2);
        return;
    L13:
        if (a2.b(r6) == false) goto L15;
        r5 = r6;
    L15:
        if (r5 == null) goto L19;
        Drawable r7 = this.a.getBackground();
        if (r7 == null) goto L19;
        r7.setColorFilter(com.bytedance.android.ec.core.utils.s.a(r5, 16711760), PorterDuff.Mode.SRC_ATOP);
        goto L19
    L5:
        if (a2.b(r4) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L10;
        this.a.setTextColor(com.bytedance.android.ec.core.utils.s.a(r4, 16777215));
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
