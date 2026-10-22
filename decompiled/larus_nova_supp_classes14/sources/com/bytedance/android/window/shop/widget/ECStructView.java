package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECStructView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "c", "StructType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECStructView extends LinearLayout {
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public int a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECStructView$StructType;", "", "", "drawableRes", "I", "getDrawableRes", "()I", "A", "B", "C", "D", "E", "INNER_FLOW_PRODUCT_CARD", "INNER_FLOW_VIDEO_CARD", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StructType extends Enum<StructType> {
        public static final StructType A = null;
        public static final StructType B = null;
        public static final StructType C = null;
        public static final StructType D = null;
        public static final StructType E = null;
        public static final StructType INNER_FLOW_PRODUCT_CARD = null;
        public static final StructType INNER_FLOW_VIDEO_CARD = null;
        public static final /* synthetic */ StructType[] a = null;
        private final int drawableRes;

        static {
            StructType r1 = new StructType("A", 0, 2131234774);
            A = r1;
            StructType r2 = new StructType("B", 1, 2131234772);
            B = r2;
            StructType r3 = new StructType("C", 2, 2131234773);
            C = r3;
            StructType r4 = new StructType("D", 3, 2131234775);
            D = r4;
            StructType r5 = new StructType("E", 4, 2131234874);
            E = r5;
            StructType r6 = new StructType("INNER_FLOW_PRODUCT_CARD", 5, 2131234756);
            INNER_FLOW_PRODUCT_CARD = r6;
            StructType r7 = new StructType("INNER_FLOW_VIDEO_CARD", 6, 2131234757);
            INNER_FLOW_VIDEO_CARD = r7;
            a = new StructType[]{r1, r2, r3, r4, r5, r6, r7};
        }

        public static StructType valueOf(String r1) {
            return (StructType) r27.a.a(StructType.class, r1);
        }

        public static StructType[] values() {
            return (StructType[]) a.clone();
        }

        public final int getDrawableRes() {
            return this.drawableRes;
        }

        public StructType(String r1, int r2, int r3) {
            super(r1, r2);
            this.drawableRes = r3;
        }
    }

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ECStructView a;

        public a(ECStructView r1) {
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
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.a.getWidth() <= 0) goto L38;
            ECStructView r0 = this.a;
            if (r0.a == r0.getWidth()) goto L39;
            this.a.removeAllViews();
            ECStructView r1 = this.a;
            int r2 = r1.getWidth();
            StructType[][] r3 = r1.a();
            boolean r4 = true;
            if (r3 != null) goto L10;
        L16:
            if (r4 == true) goto L32;
            int r5 = r2 / r3.length;
            int r6 = r3.length;
            int r7 = 0;
        L19:
            if (r7 >= r6) goto L32;
            StructType[] r8 = r3[r7];
            c r9 = new c(r1.getContext(), r7, r3.length);
            r9.setLayoutParams(new LinearLayout.LayoutParams(r5, -1));
            int r10 = r8.length;
            int r11 = 0;
        L21:
            if (r11 >= r10) goto L31;
            StructType r12 = r8[r11];
            int r13 = r3.length;
            Intrinsics.checkNotNullParameter(r12, "type");
            Intrinsics.checkNotNullParameter(r12, "type");
            ImageView r14 = new ImageView(r9.getContext());
            Drawable r15 = ResourcesCompat.getDrawable(r14.getResources(), r12.getDrawableRes(), null);
            if (r15 == null) goto L30;
            r14.setImageDrawable(r15);
            if (r13 != 2) goto L28;
            int r16 = r5 - ECStructView.b;
            int r17 = ECStructView.c / 2;
        L29:
            int r18 = r16 - r17;
            LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(r18, (r15.getIntrinsicHeight() * r18) / r15.getIntrinsicWidth());
            r19.setMargins(0, 0, 0, ECStructView.d);
            Unit r110 = Unit.INSTANCE;
            r14.setLayoutParams(r19);
            goto L30
        L28:
            r17 = ECStructView.b * 2;
            r16 = r5;
        L30:
            r9.addView(r14);
            r11 = r11 + 1;
            goto L21
        L31:
            Unit r20 = Unit.INSTANCE;
            r1.addView(r9);
            r7 = r7 + 1;
        L32:
            ECStructView r21 = this.a;
            r21.a = r21.getWidth();
            return;
        L10:
            if (r3.length != 0) goto L12;
            boolean r22 = true;
        L13:
            if (r22 == true) goto L16;
            r4 = false;
            goto L16
        L12:
            r22 = false;
            goto L13
        L39:
            return;
        }
    }

    public static final class b {
    }

    public static final class c extends LinearLayout {
        public c(Context r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            setOrientation(1);
            if (r4 != 1) goto L5;
            int r5 = ECStructView.b;
            setPadding(r5, 0, r5, 0);
            return;
        L5:
            if (r3 != 0) goto L7;
            setPadding(ECStructView.b, 0, ECStructView.c / 2, 0);
            return;
        L7:
            setPadding(ECStructView.c / 2, 0, ECStructView.b, 0);
        }
    }

    public abstract StructType[][] a();

    static {
        b = com.bytedance.android.shopping.extensions.b.b(12);
        c = com.bytedance.android.shopping.extensions.b.b(9);
        d = com.bytedance.android.shopping.extensions.b.b(9);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (getVisibility() != 0) goto L6;
        return true;
    L6:
        return super.onTouchEvent(r2);
    }

    public ECStructView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }
}
