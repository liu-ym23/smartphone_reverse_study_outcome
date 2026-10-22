package com.bytedance.android.shopping.deepfeed.weights.common;

import android.text.TextPaint;
import android.widget.Scroller;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ DeepFeedMarqueeTextView a;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedMarqueeTextView] */
        public final void a() {
            ?? r0 = this.a.a;
            int r1 = DeepFeedMarqueeTextView.t;
            if (r0.getMeasuredWidth() > 0) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L13;
            this.a.a.setCanScrollable(true);
            DeepFeedMarqueeTextView r3 = this.a.a;
            r3.j = true;
            Scroller r4 = r3.b;
            if (r4 == null) goto L12;
            r4.startScroll(0, 0, 0, 0, 0);
        L12:
            r3.y();
            return;
        L13:
            DeepFeedMarqueeTextView r5 = this.a.a;
            r5.o = true;
            Function0<Unit> r6 = r5.p;
            if (r6 == null) goto L18;
            Unit r7 = (Unit) r6.invoke();
            return;
        L18:
            return;
        L5:
            if (r0.getMeasuredWidth() >= r0.x()) goto L7;
            r2 = true;
            goto L8
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

    public b(ProductMarqueeTextView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedMarqueeTextView] */
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
        ?? r0 = this.a;
        if (r0.n == false) goto L6;
    L33:
        this.a.post(new a(this));
        return;
    L6:
        if (r0.i == false) goto L22;
        CharSequence r1 = r0.getText();
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L22;
        if (r0.getVisibility() == 8) goto L22;
        if (r0.getMeasuredWidth() <= 0) goto L22;
        boolean r3 = false;
    L24:
        if (r3 == true) goto L33;
        TextPaint r4 = r0.getPaint();
        String r5 = r0.getText().toString();
        int r6 = r5.length();
    L27:
        if (r6 < 0) goto L32;
        float r7 = r4.measureText(r5, 0, r6);
        if (r7 <= r0.getMeasuredWidth()) goto L30;
        r6 = r6 - 1;
        goto L27
    L30:
        r0.setMaxWidth((int) r7);
        r0.n = true;
        r0.requestLayout();
    L32:
        r0.n = false;
        goto L33
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        r2 = false;
    L22:
        r3 = true;
        goto L24
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
