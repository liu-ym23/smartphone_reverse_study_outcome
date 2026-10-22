package com.bytedance.android.shopping.deepfeed.ui.view;

import androidx.appcompat.widget.AppCompatTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Runnable {
    public final /* synthetic */ CommentItemView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;

    public f(CommentItemView r1, String r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Type inference failed for: r3v17, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedMaskTextView] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedMaskTextView] */
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
        if ((!Intrinsics.areEqual(this.a.e.getTag(), this.b)) == false) goto L6;
        return;
    L6:
        if (this.c == true) goto L8;
    L10:
        int r0 = 0;
    L12:
        if (StringsKt.isBlank(this.d) == false) goto L15;
        this.a.e.setText("");
        this.a.f.setVisibility(8);
        this.a.b(false, false);
        return;
    L15:
        int r3 = this.a.e.getWidth();
        if (r3 > 0) goto L19;
        this.a.e.setText(this.d);
        this.a.f.setVisibility(8);
        this.a.b(false, true);
        return;
    L19:
        int r5 = r3 - r0;
        if (this.a.e.getPaint().breakText(this.d, true, RangesKt.coerceAtLeast(r5, 0), null) < this.d.length()) goto L23;
        ?? r4 = this.a.e;
        r4.setPadding(r4.getPaddingLeft(), this.a.e.getPaddingTop(), r0, this.a.e.getPaddingBottom());
        this.a.e.setText(this.d);
        this.a.f.setVisibility(8);
        this.a.b(false, true);
        return;
    L23:
        int r6 = this.a.e.getPaint().breakText(this.d, true, r3, null);
        CharSequence r7 = StringsKt.take(this.d, r6);
        String r8 = StringsKt.drop(this.d, r6);
        if (r8 == null) goto L38;
        String r9 = StringsKt.trimStart(r8).toString();
        if (r6 != this.d.length()) goto L28;
        r7 = StringsKt.take(this.d, this.a.e.getPaint().breakText(this.d, true, RangesKt.coerceAtLeast(r5, 0), null));
        this.a.e.setMaskLengthDp(r0);
    L28:
        this.a.e.setText(r7);
        CommentItemView r10 = this.a;
        r10.getClass();
        if (StringsKt.isBlank(r9) == false) goto L31;
        r10.f.setVisibility(8);
        r10.b(false, true);
        return;
    L31:
        int r11 = RangesKt.coerceAtLeast(r10.h.getWidth() - r0, 0);
        AppCompatTextView r12 = r10.f;
        if (r11 > 0) goto L34;
        int r13 = r9.length();
    L35:
        ?? r14 = r10.f;
        r14.setPadding(r14.getPaddingLeft(), r10.f.getPaddingTop(), r0, r10.f.getPaddingBottom());
        r10.f.setVisibility(0);
        r10.f.setText(StringsKt.take(r9, r13));
        r10.b(true, false);
        return;
    L34:
        r13 = r12.getPaint().breakText(r9, true, r11, null);
        goto L35
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L8:
        if (this.a.g.getVisibility() != 0) goto L10;
        r0 = RangesKt.coerceAtLeast(this.a.g.getWidth(), 0);
        goto L12
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
