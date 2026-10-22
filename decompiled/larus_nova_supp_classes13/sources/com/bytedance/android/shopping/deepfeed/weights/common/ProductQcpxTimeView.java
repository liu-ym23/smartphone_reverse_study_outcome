package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kk.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductQcpxTimeView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductQcpxTimeView extends LinearLayout {
    public final ProductTextView a;
    public final ProductTextView b;
    public long c;
    public final a d;

    public static final class a implements Runnable {
        public final /* synthetic */ ProductQcpxTimeView a;
        public final /* synthetic */ Context b;

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
            ProductQcpxTimeView r0 = this.a;
            long r1 = r0.c;
            if (r1 <= 1) goto L5;
            r0.c = r1 - 1;
            r0.a();
            this.a.postDelayed(this, 1000);
            return;
        L5:
            r0.a.setText("已过期");
            this.a.a.setTextColor(qc3.a.d(this.b, 2131106044));
            this.a.b.setTextColor(qc3.a.d(this.b, 2131106044));
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

        public a(ProductQcpxTimeView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ProductQcpxTimeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductQcpxTimeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        d.c(new ProductQcpxTimeView$updateCountdownText$1(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    public ProductQcpxTimeView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        ?? r10 = new ProductTextView(r7, null, 6, 0);
        r10.setGravity(16);
        com.bytedance.android.shopping.deepfeed.ui.view.a r3 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r10.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r7, 12));
        r10.setTextColor(qc3.a.d(r7, 2131106032));
        r10.setIncludeFontPadding(false);
        Unit r5 = Unit.INSTANCE;
        this.a = r10;
        ?? r6 = new ProductTextView(r7, null, 6, 0);
        r6.setGravity(16);
        r6.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r7, 12));
        r6.setTextColor(qc3.a.d(r7, 2131106032));
        r6.setIncludeFontPadding(false);
        this.b = r6;
        this.d = new a(this, r7);
        setOrientation(0);
        addView(r6, new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r7, 16)));
        addView(r10, new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r7, 16)));
    }

    public /* synthetic */ ProductQcpxTimeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
