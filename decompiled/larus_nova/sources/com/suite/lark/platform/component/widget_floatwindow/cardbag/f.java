package com.suite.lark.platform.component.widget_floatwindow.cardbag;

import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements LayoutTransition.TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogAnimationLayout f461177a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f461178a;

        @Override // java.lang.Runnable
        public final void run() {
            DialogAnimationLayout r100 = this.f461178a.f461177a;     // Catch: Throwable -> L4
            int r101 = DialogAnimationLayout.f461157i;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(f r100) {
            this.f461178a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f461179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f461180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f461181c;

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
            DialogAnimationLayout r100 = this.f461181c.f461177a;
            int r101 = DialogAnimationLayout.f461157i;
            r100.c();
            DialogAnimationLayout r102 = this.f461181c.f461177a;
            View r103 = this.f461179a;
            int r104 = this.f461180b;
            r102.getClass();
            boolean r105 = false;
            ValueAnimator r106 = null;
            if (r104 != 2) goto L5;
            if (r103 == null) goto L32;
            int r107 = r103.getHeight();
            jpc.a r108 = (jpc.a) r103.getTag();
            if (r108 != null) goto L31;
            r108 = new jpc.a();
        L31:
            r108.f500012a = r107;
            r103.setTag(r108);
            DialogAnimationLayout.a r109 = new DialogAnimationLayout.a(r102, 0);
            int r110 = (int) r102.getResources().getDimension(R.dimen.card_dp_step);
            ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r111.addListener(new com.suite.lark.platform.component.widget_floatwindow.cardbag.a(r109, r102));
            r111.addUpdateListener(new com.suite.lark.platform.component.widget_floatwindow.cardbag.b(r102, r110, r107));
            r111.setDuration(300);
            r111.start();
        L32:
            r102.f461164g = r106;
            return;
        L5:
            if (r104 != 3) goto L32;
            int r112 = (r102.f461162e.size() - 1) - r102.getChildCount();
            if (r112 < 0) goto L22;
            r102.setLayoutTransition(null);
            View r113 = (View) ListProtector.get(r102.f461162e, r112);
            if (r113.getParent() != null) goto L22;
            int r114 = (r102.f461163f * 3) * 2;
            r113.setPadding(r114, 0, r114, 0);
            if (((jpc.a) r113.getTag()) != null) goto L17;
            jpc.a r115 = new jpc.a();
            r115.f500014c = 0;
            r115.f500013b = r114;
            r113.setTag(r115);
        L17:
            if (r102.getChildCount() <= 1) goto L19;
            int r116 = r102.getChildAt(r102.getChildCount() - 1).getHeight();
        L20:
            FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(r102.f461159b, r116);
            r117.gravity = r102.f461160c;
            r102.addView(r113, 0, r117);
            goto L22
        L19:
            r116 = -2;
        L22:
            if (r102.f461162e.size() <= 0) goto L24;
            r105 = true;
        L24:
            if (r105 == false) goto L32;
            DialogAnimationLayout.a r118 = new DialogAnimationLayout.a(r102, 1);
            int r119 = (int) r102.getResources().getDimension(R.dimen.card_dp_step);
            r106 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r106.addListener(new c(r118, r102));
            r106.addUpdateListener(new d(r102, r119));
            r106.setDuration(300);
            r106.start();
            goto L32
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

        public b(f r100, View r101, int r102) {
            this.f461181c = r100;
            this.f461179a = r101;
            this.f461180b = r102;
        }
    }

    public f(DialogAnimationLayout r100) {
        this.f461177a = r100;
    }

    @Override // android.animation.LayoutTransition.TransitionListener
    public final void endTransition(LayoutTransition r100, ViewGroup r101, View r102, int r103) {
        int r104 = this.f461177a.getHeight();
        DialogAnimationLayout r105 = this.f461177a;
        if (r104 <= r105.f461165h) goto L6;
        r105.f461165h = r105.getHeight();
    L6:
        if (r103 != 3) goto L8;
        this.f461177a.post(new a(this));
    L8:
        this.f461177a.post(new b(this, r102, r103));
    }

    @Override // android.animation.LayoutTransition.TransitionListener
    public final void startTransition(LayoutTransition r100, ViewGroup r101, View r102, int r103) {
        DialogAnimationLayout r104 = this.f461177a;
        int r105 = DialogAnimationLayout.f461157i;
        r104.c();
    }
}
