package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.Typeface;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n0 implements Runnable {
    public final /* synthetic */ ECShopMarqueeTextView a;
    public final /* synthetic */ View b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public n0(ECShopMarqueeTextView r1, View r2, String r3, String r4) {
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
        View r0 = this.b;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getMeasuredWidth());
    L6:
        int r2 = RangesKt.coerceAtLeast(r1.intValue(), com.bytedance.android.shopping.extensions.b.b(35));
        this.a.setMaxWidth(r2 - com.bytedance.android.shopping.extensions.b.b(16));
        AppCompatTextView r3 = this.a;
        StringBuilder r4 = new StringBuilder();
        r4.append(this.c);
        String r5 = this.d;
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r4.append(r5);
        r3.setText(r4.toString());
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        this.a.E();
        return;
    L5:
        r1 = null;
        goto L6
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
