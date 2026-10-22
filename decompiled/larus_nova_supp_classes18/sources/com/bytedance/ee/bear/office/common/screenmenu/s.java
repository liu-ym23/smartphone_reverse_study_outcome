package com.bytedance.ee.bear.office.common.screenmenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ ScreenMenuLayout b;
    public final /* synthetic */ View c;
    public final /* synthetic */ CommonMenu d;

    public s(ScreenMenuLayout r1, ScreenMenuLayout r2, View r3, CommonMenu r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        ScreenMenuLayout r0 = this.b;
        View r1 = this.c;
        LinearLayoutCompat r2 = this.d;
        Animator r3 = r0.i;
        if (r3 == null) goto L5;
        r3.cancel();
    L5:
        Animator r4 = r0.h;
        if (r4 == null) goto L8;
        r4.cancel();
    L8:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r1, View.ALPHA, new float[]{0.0f, 1.0f});
        r5.setDuration(100);
        if (r1.getWidth() != 0) goto L11;
    L18:
        tt5.a.h("ScreenMenuLayout", "sub menu enter animation fallback alpha only. " + r0.g(r2, r1));
        r0.h = r5;
        r5.start();
        return;
    L11:
        if (r1.getHeight() == 0) goto L18;
        if (r2.getWidth() == 0) goto L18;
        if (r2.getHeight() == 0) goto L18;
        Pair r6 = ScreenMenuLayout.h(r1, r2);
        r1.setPivotX(((Number) r6.getFirst()).floatValue());
        r1.setPivotY(((Number) r6.getSecond()).floatValue());
        r1.setScaleX(0.0f);
        r1.setScaleY(0.0f);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r1, View.SCALE_X, new float[]{0.0f, 1.0f});
        r7.setDuration(100);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r1, View.SCALE_Y, new float[]{0.0f, 1.0f});
        r8.setDuration(100);
        AnimatorSet r9 = new AnimatorSet();
        r9.playTogether(new Animator[]{r5, r7, r8});
        r9.start();
        r0.h = r9;
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
