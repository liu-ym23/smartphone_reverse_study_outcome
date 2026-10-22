package com.bytedance.android.shopping.card_list.utils;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements View.OnTouchListener {
    public final /* synthetic */ HalfPanelHelper a;

    public m(HalfPanelHelper r1) {
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
        if (this.a.p.onTouchEvent(r6) == true) goto L32;
        HalfPanelHelper r7 = this.a;
        r7.getClass();
        int r1 = r6.getAction();
        float r2 = 0.0f;
        if (r1 == 0) goto L28;
        if (r1 != 1) goto L12;
    L19:
        UserInteractFrameLayout r8 = r7.d;
        if (r8 == null) goto L22;
        r2 = r8.getTranslationY();
    L22:
        float r9 = r7.c();
        float r3 = r7.l;
        if (r2 <= (r3 + r9)) goto L26;
        r7.r.a();
        goto L32
    L26:
        if (r2 >= (r9 - r3)) goto L32;
        r7.b();
        goto L32
    L12:
        if (r1 != 2) goto L14;
        float r10 = r7.b - (r7.a - ((int) r6.getRawY()));
        UserInteractFrameLayout r11 = r7.d;
        if (r11 == null) goto L32;
        r11.setTranslationY(RangesKt.coerceAtLeast(r10, 0.0f));
        goto L32
    L14:
        if (r1 == 3) goto L19;
    L28:
        r7.a = (int) r6.getRawY();
        UserInteractFrameLayout r12 = r7.d;
        if (r12 == null) goto L31;
        r2 = r12.getTranslationY();
    L31:
        r7.b = r2;
    L32:
        return true;
    }
}
