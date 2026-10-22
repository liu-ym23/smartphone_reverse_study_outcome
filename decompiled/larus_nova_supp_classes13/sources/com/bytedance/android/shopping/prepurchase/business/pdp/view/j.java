package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements View.OnLayoutChangeListener {
    public final /* synthetic */ MultiRecyclerNestedScrollView a;
    public final /* synthetic */ RecyclerView b;

    public static final class a implements Runnable {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j r0 = this.a;     // Catch: Throwable -> L4
            MultiRecyclerNestedScrollView r1 = r0.a;     // Catch: Throwable -> L4
            RecyclerView r2 = r0.b;     // Catch: Throwable -> L4
            int r3 = MultiRecyclerNestedScrollView.n;     // Catch: Throwable -> L4
            r1.j(r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public j(MultiRecyclerNestedScrollView r1, FixedRecyclerView r2) {
        this.a = r1;
        this.b = r2;
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
    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (this.b.getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.a.h() == true) goto L8;
        return;
    L8:
        if (this.a.canScrollVertically(-1) == true) goto L10;
        return;
    L10:
        if (this.a.i() == false) goto L13;
        int r10 = this.a.getScrollY();
        this.a.scrollBy(0, -r10);
        this.b.startNestedScroll(2);
        this.b.scrollBy(0, r10);
        this.b.stopNestedScroll();
        return;
    L13:
        if (this.b.canScrollVertically(1) == false) goto L19;
        this.a.post(new a(this));
        return;
    }
}
