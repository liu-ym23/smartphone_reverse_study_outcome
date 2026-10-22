package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.deepfeed.utlis.j;
import com.bytedance.android.shopping.deepfeed.weights.o;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.ProductRecReasonCustom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import he3.q1;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tc3.f;
import yj.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductRecommendView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductRecommendView extends LinearLayout {
    public final SimpleDraweeView a;
    public final ProductTextView b;
    public final ProductTextView c;

    public ProductRecommendView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProductRecommendView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
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
    public final void a(q1 r9) {
        Intrinsics.checkNotNullParameter(r9, "recReason");
        ImageURL r0 = r9.d();
        if (r0 == null) goto L7;
        List<String> r1 = r0.getUrlList();
        if (r1 == null) goto L7;
        String r2 = (String) CollectionsKt.firstOrNull(r1);
    L8:
        boolean r4 = true;
        if (k.c(r2) == false) goto L22;
        this.a.setVisibility(0);
        SimpleDraweeView r3 = this.a;
        if (r2 == null) goto L23;
        new c(r3);
        IHybridHostService r6 = com.bytedance.android.ec.hybrid.a.h();
        if (r6 == null) goto L18;
        l r7 = r6.getIHybridHostFrescoService();
        if (r7 == null) goto L18;
        r7.f(r3, r2, new HashMap());
        Boolean r8 = Boolean.FALSE;
    L20:
        if ((!Intrinsics.areEqual(r8, Boolean.TRUE)) == false) goto L23;
        r3.setImageURI(r2);
    L18:
        r8 = null;
    L23:
        String r5 = r9.f();
        if (r5 != null) goto L26;
    L29:
        if (r4 == true) goto L37;
        ProductRecReasonCustom r10 = r9.e();
        if (r10 == null) goto L33;
        String r11 = r10.getHeaderFlag();
    L35:
        if (Intrinsics.areEqual(String.valueOf(r11), "1") == false) goto L37;
        this.c.setVisibility(0);
        this.c.setText(r9.f());
        String r12 = " · ";
    L38:
        String r13 = r9.b();
        if (r13 == null) goto L41;
        this.b.setVisibility(0);
        this.b.setText(r12.concat(r13));
    L42:
        ConcurrentHashMap<String, j.a> r14 = j.a;
        Integer r15 = j.d(r9.c());
        if (r15 == null) goto L45;
        this.b.setTextColor(r15.intValue());
    L45:
        ProductRecReasonCustom r16 = r9.e();
        if (r16 == null) goto L48;
        String r17 = r16.getMixedCouponVersion();
    L50:
        if (Intrinsics.areEqual(r17, "v2") == false) goto L59;
        int r18 = DeepFeedLinearGradientDrawable.d;
        setBackground(DeepFeedLinearGradientDrawable.a.a(com.bytedance.android.shopping.extensions.b.b(3)));
        if (f.e() == false) goto L69;
        ViewGroup.LayoutParams r19 = this.a.getLayoutParams();
        if (r19 == null) goto L58;
        LinearLayout.LayoutParams r20 = (LinearLayout.LayoutParams) r19;
        r20.gravity = 16;
        this.a.setLayoutParams(r20);
        d2.d(this.a, 0, 0, 0, 0);
        this.c.setGravity(16);
        this.b.setGravity(16);
        return;
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L69:
        return;
    L59:
        setBackground(null);
        if (f.e() == false) goto L70;
        ViewGroup.LayoutParams r21 = this.a.getLayoutParams();
        if (r21 == null) goto L67;
        LinearLayout.LayoutParams r22 = (LinearLayout.LayoutParams) r21;
        r22.gravity = 80;
        this.a.setLayoutParams(r22);
        d2.d(this.a, 0, 0, 0, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(1.5d)));
        this.c.setGravity(80);
        this.b.setGravity(80);
        return;
    L67:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L70:
        return;
    L48:
        r17 = null;
        goto L50
    L41:
        this.b.setVisibility(8);
        goto L42
    L33:
        r11 = null;
    L37:
        r12 = "";
        goto L38
    L26:
        if (r5.length() == 0) goto L29;
        r4 = false;
        goto L29
    L22:
        this.a.setVisibility(8);
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.deepfeed.weights.common.ProductTextView] */
    public ProductRecommendView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        SimpleDraweeView r13 = new SimpleDraweeView(r10);
        if (f.e() == false) goto L5;
        int r14 = 80;
    L6:
        setGravity(r14);
        Unit r15 = Unit.INSTANCE;
        this.a = r13;
        ?? r16 = new ProductTextView(r10, null, 6, 0);
        if (f.e() == false) goto L9;
        int r5 = 80;
    L10:
        r16.setGravity(r5);
        com.bytedance.android.shopping.deepfeed.ui.view.a r6 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r16.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r10, 12));
        r16.setTextColor(-16777216);
        r16.setIncludeFontPadding(false);
        this.b = r16;
        ?? r7 = new ProductTextView(r10, null, 6, 0);
        if (f.e() == false) goto L13;
        int r2 = 80;
    L14:
        r7.setGravity(r2);
        r7.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r10, 12));
        r7.setTextColor(ColorProtector.parseColor("#B48352"));
        r7.setIncludeFontPadding(false);
        Intrinsics.checkNotNullParameter("DouyinSansBold.otf", "font");
        ConcurrentHashMap<String, j.a> r3 = j.a;
        Typeface r4 = j.c("DouyinSansBold.otf", r7.getContext(), 400);
        if (r4 == null) goto L17;
        r7.setTypeface(r4);
    L17:
        r7.setVisibility(8);
        this.c = r7;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r10, 12));
        r8.rightMargin = com.bytedance.android.shopping.extensions.b.b(2);
        if (f.e() == false) goto L20;
        r8.gravity = 80;
        r8.bottomMargin = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(1.5d));
    L21:
        addView(r13, r8);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r10, 16));
        if (f.e() == false) goto L24;
        r9.gravity = 80;
    L24:
        addView(r7, r9);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r10, 16));
        if (f.e() == false) goto L27;
        r17.gravity = 80;
    L27:
        addView(r16, r17);
        Integer r18 = f.c();
        if (r18 != null) goto L31;
    L33:
        Integer r19 = f.c();
        if (r19 != null) goto L37;
        return;
    L37:
        if (r19.intValue() != 2) goto L41;
        r16.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 14));
        r7.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 14));
        o.a(r13, 14);
        o.a(r7, 20);
        o.a(r16, 20);
        return;
    L41:
        return;
    L31:
        if (r18.intValue() != 1) goto L33;
        r16.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 13));
        r7.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 13));
        o.a(r13, 13);
        o.a(r7, 20);
        o.a(r16, 20);
        return;
    L20:
        r8.gravity = 16;
        goto L21
    L13:
        r2 = 16;
        goto L14
    L9:
        r5 = 16;
        goto L10
    L5:
        r14 = 16;
        goto L6
    }

    public /* synthetic */ ProductRecommendView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
