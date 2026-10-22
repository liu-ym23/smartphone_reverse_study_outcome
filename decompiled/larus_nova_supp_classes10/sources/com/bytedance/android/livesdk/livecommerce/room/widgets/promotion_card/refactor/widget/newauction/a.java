package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a<T> {
    public T a;
    public final View b;
    public final View c;
    public final float d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.a$a, reason: collision with other inner class name */
    public static final class C0114a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ Object b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction.a$b$a, reason: collision with other inner class name */
        public static final class C0115a extends AnimatorListenerAdapter {
            public final /* synthetic */ b a;

            public C0115a(b r1) {
                this.a = r1;
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
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r3) {
                Intrinsics.checkNotNullParameter(r3, "animation");
                b r4 = this.a;
                a r0 = r4.a;
                T r5 = (T) r4.b;
                r0.a = r5;
                r0.a(r5, r0.b);
                this.a.a.b.setAlpha(1.0f);
                this.a.a.c.setVisibility(4);
            }
        }

        public b(a r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            this.a.b.animate().alpha(0.0f).setListener(null).setDuration(250).start();
            this.a.c.setVisibility(0);
            this.a.c.setAlpha(0.0f);
            View r10 = this.a.c;
            r10.setTranslationY(r10.getMeasuredHeight() * this.a.d);
            this.a.c.animate().translationY(0.0f).alpha(1.0f).setListener(new C0115a(this)).setDuration(250).start();
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ a a;
        public final /* synthetic */ Object b;

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
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            a r4 = this.a;
            T r0 = (T) this.b;
            r4.a = r0;
            r4.a(r0, r4.b);
            this.a.b.setAlpha(1.0f);
            this.a.c.setVisibility(4);
        }

        public c(a r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public abstract void a(T r1, View r2);

    public abstract boolean b(T r1, T r2);

    public final void c(T r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        T r0 = this.a;
        if (r0 != null) goto L8;
        a(r8, this.b);
        this.b.setAlpha(1.0f);
        this.c.setVisibility(4);
        this.a = r8;
        return;
    L8:
        if (b(r0, r8) == true) goto L10;
        a(r8, this.b);
        this.b.setAlpha(1.0f);
        this.c.setVisibility(4);
        this.a = r8;
        return;
    L10:
        a(this.a, this.b);
        a(r8, this.c);
        View r1 = this.c;
        if (ViewCompat.isLaidOut(r1) == true) goto L13;
    L15:
        r1.addOnLayoutChangeListener(new b(this, r8));
        return;
    L13:
        if (r1.isLayoutRequested() == true) goto L15;
        this.b.animate().alpha(0.0f).setListener(null).setDuration(250).start();
        this.c.setVisibility(0);
        this.c.setAlpha(0.0f);
        View r2 = this.c;
        r2.setTranslationY(r2.getMeasuredHeight() * this.d);
        this.c.animate().translationY(0.0f).alpha(1.0f).setListener(new c(this, r8)).setDuration(250).start();
    }

    public a(View r2, View r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "hideView");
        Intrinsics.checkNotNullParameter(r3, "showView");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
