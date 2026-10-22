package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x2 implements Runnable {
    public final /* synthetic */ ECShopMarqueeTextView a;
    public final /* synthetic */ t2 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public static final class a implements Runnable {
        public final /* synthetic */ x2 a;

        public a(x2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.E();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public x2(ECShopMarqueeTextView r1, t2 r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
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
    public final void a() {
        this.a.setVisibility(0);
        this.a.setMaxWidth(this.b.u);
        AppCompatTextView r0 = this.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.c);
        String r2 = this.d;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.append(r2);
        r0.setText(r1.toString());
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        this.a.post(new a(this));
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
