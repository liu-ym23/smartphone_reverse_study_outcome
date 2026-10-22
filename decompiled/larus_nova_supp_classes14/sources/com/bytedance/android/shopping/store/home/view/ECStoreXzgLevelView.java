package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R*\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreXzgLevelView;", "Landroid/widget/LinearLayout;", "", "isLightStyle", "", "setStyle", "", "color", "setNoLevelViewColor", "", "value", "g", "F", "getCollapse", "()F", "setCollapse", "(F)V", "collapse", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreXzgLevelView extends LinearLayout {
    public static final /* synthetic */ int m = 0;
    public final ECDraweeView a;
    public final ECDraweeView b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final TextView e;
    public com.bytedance.android.ec.model.o f;
    public float g;
    public int h;
    public int i;
    public final int j;
    public boolean k;
    public boolean l;

    public static final class a implements Runnable {
        public final /* synthetic */ ECStoreXzgLevelView a;

        public a(ECStoreXzgLevelView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECStoreXzgLevelView r0 = this.a;     // Catch: Throwable -> L9
            int r1 = ECStoreXzgLevelView.m;     // Catch: Throwable -> L9
            com.bytedance.android.ec.model.o r2 = r0.f;     // Catch: Throwable -> L9
            if (r2 == null) goto L7;
            Integer r3 = r2.f();     // Catch: Throwable -> L9
            if (r3 == null) goto L7;
            r3.intValue();     // Catch: Throwable -> L9
        L7:
            r0.c.removeAllViews();     // Catch: Throwable -> L9
            r0.d.removeAllViews();     // Catch: Throwable -> L9
            this.a.c.setVisibility(0);     // Catch: Throwable -> L9
            this.a.d.setVisibility(0);     // Catch: Throwable -> L9
            this.a.requestLayout();     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public ECStoreXzgLevelView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECStoreXzgLevelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final float getCollapse() {
        return this.g;
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
    public final void a(boolean r4) {
        if (r4 == false) goto L5;
        setCollapse(1.0f);
    L5:
        com.bytedance.android.ec.model.o r5 = this.f;
        String r1 = null;
        if (r5 == null) goto L8;
        String r6 = r5.b();
    L9:
        if (r6 == null) goto L15;
        com.bytedance.android.ec.model.o r7 = this.f;
        if (r7 == null) goto L13;
        String r8 = r7.b();
    L14:
        int r9 = ColorProtector.parseColor(r8);
    L16:
        com.bytedance.android.ec.model.o r2 = this.f;
        if (r2 == null) goto L19;
        String r3 = r2.d();
    L20:
        if (r3 == null) goto L25;
        com.bytedance.android.ec.model.o r10 = this.f;
        if (r10 == null) goto L24;
        r1 = r10.d();
    L24:
        int r11 = ColorProtector.parseColor(r1);
    L26:
        this.e.setTextColor(ColorUtils.blendARGB(r9, r11, this.g));
        float r12 = 1;
        this.b.setAlpha(r12 - this.g);
        this.a.setAlpha(1.0f);
        com.bytedance.android.ec.model.o r13 = this.f;
        if (r13 == null) goto L31;
        Integer r14 = r13.f();
        if (r14 == null) goto L31;
        int r15 = r14.intValue();
    L32:
        if (r15 != 0) goto L34;
        this.c.setAlpha(1.0f);
        this.d.setAlpha(0.0f);
        return;
    L34:
        this.c.setAlpha(r12 - this.g);
        this.d.setAlpha(this.g);
        return;
    L31:
        r15 = 0;
        goto L32
    L25:
        r11 = (int) 4279638051L;
        goto L26
    L19:
        r3 = null;
        goto L20
    L13:
        r8 = null;
        goto L14
    L15:
        r9 = -1;
        goto L16
    L8:
        r6 = null;
        goto L9
    }

    public final void setCollapse(float r2) {
        if (this.g == r2) goto L6;
        this.g = r2;
        a(false);
        return;
    }

    public final void setNoLevelViewColor(int r2) {
        this.e.setTextColor(r2);
    }

    public final void setStyle(boolean r3) {
        if (r3 == false) goto L4;
        this.e.setTextColor(-1);
        return;
    L4:
        TextView r4 = this.e;
        int r0 = g1.a;
        r4.setTextColor(g1.a.a(getContext(), 2131101189));
    }

    public ECStoreXzgLevelView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        TextView r8 = new TextView(r5);
        int r9 = g1.a;
        r8.setText(g1.a.c(r5, 2131896879, new Object[0]));
        com.bytedance.android.shopping.extensions.f.e(r8, 500);
        r8.setGravity(16);
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(-2, com.bytedance.android.shopping.store.utils.o.a(14));
        r1.setMargins(com.bytedance.android.shopping.extensions.b.b(3), 0, 0, 0);
        Unit r2 = Unit.INSTANCE;
        r8.setLayoutParams(r1);
        r8.setIncludeFontPadding(false);
        wg.a.g(r8, 11);
        this.e = r8;
        LinearLayout.inflate(r5, 2131560974, this);
        this.b = (ECDraweeView) findViewById(2131393403);
        this.a = (ECDraweeView) findViewById(2131393402);
        this.c = (LinearLayout) findViewById(2131371906);
        this.d = (LinearLayout) findViewById(2131367125);
        setGravity(16);
        this.h = com.bytedance.android.shopping.extensions.b.b(28);
        this.i = com.bytedance.android.shopping.extensions.b.b(58);
        com.bytedance.android.shopping.store.utils.o.a(16);
        this.j = com.bytedance.android.shopping.store.utils.o.a(20);
    }

    public /* synthetic */ ECStoreXzgLevelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        Point r8 = l0.f(getContext());
        if (r8 == null) goto L7;
        int r9 = r8.x;
        Rect r10 = new Rect();
        this.b.getGlobalVisibleRect(r10);
        int r11 = r9 - (this.h + this.i);
        if ((r10.right + ((this.j + com.bytedance.android.shopping.extensions.b.b(1)) * 5)) <= r11) goto L7;
        Math.floor(((double) (((r11 - r10.right) / 5) - com.bytedance.android.shopping.extensions.b.b(1))) * 0.8d);
        boolean r12 = true;
    L8:
        if (r12 == true) goto L10;
        return;
    L10:
        if (this.k == false) goto L12;
        return;
    L12:
        if (this.l == true) goto L17;
        this.k = true;
        this.c.setVisibility(4);
        this.d.setVisibility(4);
        post(new a(this));
        return;
    L17:
        return;
    L7:
        r12 = false;
        goto L8
    }
}
