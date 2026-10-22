package com.bytedance.android.shopping.new_cart.container;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements View.OnTouchListener {
    public final /* synthetic */ CartDialogFragment a;

    public g(CartDialogFragment r1) {
        this.a = r1;
    }

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
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        if (r5.getVisibility() == 0) goto L7;
        return false;
    L7:
        if (this.a.L.onTouchEvent(r6) == true) goto L37;
        CartDialogFragment r7 = this.a;
        r7.getClass();
        int r1 = r6.getAction();
        float r2 = 0.0f;
        if (r1 == 0) goto L33;
        if (r1 != 1) goto L12;
    L19:
        UserInteractFrameLayout r8 = r7.D;
        if (r8 == null) goto L22;
        r2 = r8.getTranslationY();
    L22:
        float r9 = r7.Z90();
        float r3 = r7.e;
        if (r2 <= (r3 + r9)) goto L31;
        r7.dismissAllowingStateLoss();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L37;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L37
    L31:
        if (r2 >= (r9 - r3)) goto L37;
        r7.U90();
        goto L37
    L12:
        if (r1 != 2) goto L14;
        float r11 = r7.N - (r7.M - ((int) r6.getRawY()));
        UserInteractFrameLayout r12 = r7.D;
        if (r12 == null) goto L37;
        r12.setTranslationY(RangesKt.coerceAtLeast(r11, 0.0f));
        goto L37
    L14:
        if (r1 == 3) goto L19;
    L33:
        r7.M = (int) r6.getRawY();
        UserInteractFrameLayout r13 = r7.D;
        if (r13 == null) goto L36;
        r2 = r13.getTranslationY();
    L36:
        r7.N = r2;
    L37:
        return true;
    }
}
