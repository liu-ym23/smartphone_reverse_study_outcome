package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.shopping.deepfeed.weights.common.ProductPriceView;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.facebook.drawee.view.SimpleDraweeView;
import he3.c1;
import he3.k1;
import he3.m1;
import he3.o1;
import he3.p0;
import he3.p1;
import he3.q1;
import he3.r1;
import he3.u1;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001b¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductTitleView;", "a", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductTitleView;", "getMaskTitle", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductTitleView;", "maskTitle", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoExtraView;", "b", "Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoExtraView;", "getExtraView", "()Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedProductInfoExtraView;", "extraView", "", "", "c", "Ljava/util/List;", "getRecReasonTagList", "()Ljava/util/List;", "recReasonTagList", "Lcom/facebook/drawee/view/SimpleDraweeView;", "d", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getDisplayImage", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setDisplayImage", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "displayImage", "e", "getDisplayImageDanceImage", "setDisplayImageDanceImage", "displayImageDanceImage", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductInfoView extends ConstraintLayout {
    public final DeepFeedProductTitleView a;
    public final DeepFeedProductInfoExtraView b;
    public final List<String> c;
    public SimpleDraweeView d;
    public SimpleDraweeView e;

    public DeepFeedProductInfoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DeepFeedProductInfoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final SimpleDraweeView getDisplayImage() {
        return this.d;
    }

    public final SimpleDraweeView getDisplayImageDanceImage() {
        return this.e;
    }

    public final DeepFeedProductInfoExtraView getExtraView() {
        return this.b;
    }

    public final DeepFeedProductTitleView getMaskTitle() {
        return this.a;
    }

    public final List<String> getRecReasonTagList() {
        return this.c;
    }

    public final void setDisplayImage(SimpleDraweeView r1) {
        this.d = r1;
    }

    public final void setDisplayImageDanceImage(SimpleDraweeView r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductTitleView] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoExtraView] */
    public DeepFeedProductInfoView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.c = new ArrayList();
        ViewGroup.inflate(r6, 2131564649, this);
        ?? r9 = (DeepFeedProductTitleView) findViewById(2131375264);
        this.a = r9;
        ?? r10 = (DeepFeedProductInfoExtraView) findViewById(2131375257);
        this.b = r10;
        SimpleDraweeView r0 = findViewById(2131369153);
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r2 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r1.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r6, 48);
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        r3.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r6, 48);
        Integer r4 = com.bytedance.android.shopping.deepfeed.utlis.j.d("#00000008");
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
        r0.getHierarchy().setOverlayImage(new ColorDrawable(r5));
    L5:
        Unit r11 = Unit.INSTANCE;
        this.d = r0;
        SimpleDraweeView r12 = findViewById(2131369154);
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        r13.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r6, 60);
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        r14.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r6, 60);
        this.e = r12;
        if (tc3.f.d() == false) goto L23;
        ConstraintLayout.LayoutParams r15 = r10.getLayoutParams();
        if (r15 == null) goto L22;
        ConstraintLayout.LayoutParams r16 = r15;
        r16.topToTop = 0;
        r10.setLayoutParams(r16);
        Integer r17 = tc3.f.c();
        if (r17 != null) goto L13;
    L15:
        d2.d(r10, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(12), 0, 0);
    L16:
        ConstraintLayout.LayoutParams r18 = r9.getLayoutParams();
        if (r18 == null) goto L20;
        ConstraintLayout.LayoutParams r19 = r18;
        ((ViewGroup.MarginLayoutParams) r19).height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(getContext(), 21);
        r19.topToBottom = r10.getId();
        r9.setLayoutParams(r19);
        d2.d(r9, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(5), 0, 0);
    L31:
        setClipChildren(false);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L13:
        if (r17.intValue() != 1) goto L15;
        d2.d(r10, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(9), 0, 0);
        goto L16
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L23:
        ConstraintLayout.LayoutParams r20 = r9.getLayoutParams();
        if (r20 == null) goto L36;
        ConstraintLayout.LayoutParams r21 = r20;
        r21.topToTop = 0;
        r9.setLayoutParams(r21);
        if (tc3.f.e() == true) goto L28;
        r9.setPadding(0, com.bytedance.android.shopping.extensions.b.b(12), 0, 0);
    L28:
        d2.d(r9, com.bytedance.android.shopping.extensions.b.b(8), 0, 0, 0);
        ConstraintLayout.LayoutParams r22 = r10.getLayoutParams();
        if (r22 == null) goto L34;
        ConstraintLayout.LayoutParams r23 = r22;
        r23.topToBottom = r9.getId();
        r10.setLayoutParams(r23);
        d2.d(r10, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(3), 0, 0);
        goto L31
    L34:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public /* synthetic */ DeepFeedProductInfoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoExtraView, java.lang.Object] */
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
    public final void R5(InFeedProductV2 r24, CompositeDisposable r25, com.bytedance.android.shopping.deepfeed.action.h r26, com.bytedance.android.shopping.deepfeed.action.i r27) {
        Intrinsics.checkNotNullParameter(r25, "composite");
        Intrinsics.checkNotNullParameter(r26, "dfContext");
        Intrinsics.checkNotNullParameter(r27, "parentAbility");
        ((ArrayList) this.c).clear();
        this.a.R5(r24, r25, r27);
        ?? r6 = this.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r26, "dfContext");
        String r8 = "";
        if (r24 == null) goto L128;
        r6.n = r24;
        InFeedProductPackData r0 = r24.getPackData();
        if (r0 == null) goto L128;
        InFeedProductPackDataElements r1 = r0.getElements();
        if (r1 == null) goto L128;
        List<p0> r2 = r1.getProducts();
        if (r2 == null) goto L128;
        p0 r12 = (p0) CollectionsKt.firstOrNull(r2);
        if (r12 == null) goto L128;
        ProductPriceView r13 = r6.a;
        p1 r3 = r12.k();
        r13.getClass();
        if (r3 != null) goto L17;
    L24:
        p0 r15 = null;
    L72:
        p1 r4 = r12.k();
        if (r4 == null) goto L75;
        Object r5 = r4.a();
    L76:
        if (r5 == null) goto L82;
        p1 r7 = r12.k();
        if (r7 == null) goto L87;
        o1 r9 = r7.b();
        if (r9 == null) goto L87;
        String r10 = r9.a();
    L89:
        if (tc3.f.e() == false) goto L92;
        r6.b.setVisibility(8);
    L96:
        if (r24.getDynamicData().g == true) goto L106;
        u1 r11 = r12.n();
        if (r11 == null) goto L101;
        String r14 = r11.c();
        String r16 = r14;
        if (r14 == null) goto L101;
    L107:
        if (r16 != 0) goto L109;
        int r17 = 8;
        r6.c.setVisibility(8);
    L116:
        r6.m.setVisibility(r17);
        r6.postDelayed(new m(r6, r24, r26), 100);
        if (DeepFeedProductInfoExtraView.U5(r24) == null) goto L119;
        boolean r18 = true;
    L120:
        if (r18 == false) goto L123;
        r6.Y5(r24, r26, false);
    L129:
        if (r24 == null) goto L131;
        p0 r19 = r24.cardData();
    L132:
        if (r19 == null) goto L144;
        k1 r20 = r19.g();
        if (r20 == null) goto L144;
        ImageURL r21 = r20.a();
        if (r21 == null) goto L144;
        List<String> r22 = r21.getUrlList();
        if (r22 == null) goto L144;
        String r23 = (String) CollectionsKt.firstOrNull(r22);
        if (r23 == null) goto L144;
        SimpleDraweeView r28 = this.d;
        if (r28 == null) goto L144;
        r28.setImageURI(r23);
    L144:
        if (r19 == null) goto L152;
        m1 r29 = r19.i();
        if (r29 == null) goto L152;
        he3.m r30 = r29.a();
        if (r30 == null) goto L152;
        he3.r r31 = r30.b();
        if (r31 == null) goto L152;
        String r110 = r31.a();
    L153:
        if (r110 != null) goto L155;
    L158:
        boolean r32 = true;
    L159:
        if (r32 == false) goto L163;
        SimpleDraweeView r33 = this.e;
        if (r33 == null) goto L169;
        r33.setVisibility(8);
    L169:
        if (r24 == null) goto L197;
        InFeedProductPackData r34 = r24.getPackData();
        if (r34 == null) goto L197;
        InFeedProductPackDataElements r35 = r34.getElements();
        if (r35 == null) goto L197;
        List<p0> r36 = r35.getProducts();
        if (r36 == null) goto L197;
        p0 r37 = (p0) CollectionsKt.firstOrNull(r36);
        if (r37 == null) goto L197;
        r1 r38 = r37.m();
        if (r38 == null) goto L197;
        List<q1> r39 = r38.a();
        if (r39 == null) goto L197;
        Iterator<T> r40 = r39.iterator();
        int r41 = 0;
    L184:
        if (r40.hasNext() == false) goto L197;
        Object r42 = r40.next();
        int r43 = r41 + 1;
        if (r41 >= 0) goto L188;
        CollectionsKt.throwIndexOverflow();
    L188:
        q1 r44 = (q1) r42;
        if (r41 >= 2) goto L196;
        if (com.bytedance.android.shopping.extensions.k.c(r44.g()) == false) goto L196;
        List<String> r45 = this.c;
        String r46 = r44.g();
        if (r46 != null) goto L195;
        r46 = r8;
    L195:
        ((ArrayList) r45).add(r46);
    L196:
        r41 = r43;
    L197:
        r26.k();
        SimpleDraweeView r47 = this.d;
        if (r47 == null) goto L200;
        r47.setOnClickListener(new s(r27));
    L200:
        SimpleDraweeView r48 = this.e;
        if (r48 == null) goto L204;
        r48.setOnClickListener(new t(r27));
    L204:
        if (tc3.f.e() == false) goto L256;
        Integer r49 = tc3.f.c();
        if (r49 != null) goto L210;
    L230:
        Integer r50 = tc3.f.c();
        if (r50 != null) goto L234;
        return;
    L234:
        if (r50.intValue() != 2) goto L254;
        o.a(this.a, 20);
        o.a(this.b, 22);
        SimpleDraweeView r51 = this.d;
        if (r51 == null) goto L238;
        ViewGroup.LayoutParams r52 = r51.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r53 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r52.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r51.getContext(), 44);
        r52.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r51.getContext(), 44);
        r51.setLayoutParams(r52);
    L238:
        SimpleDraweeView r54 = this.e;
        if (r54 == null) goto L255;
        ViewGroup.LayoutParams r55 = r54.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r56 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r55.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r54.getContext(), 55);
        r55.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r54.getContext(), 55);
        r54.setLayoutParams(r55);
        return;
    L255:
        return;
    L254:
        return;
    L210:
        if (r49.intValue() != 1) goto L230;
        o.a(this.a, 22);
        if (tc3.f.d() == true) goto L214;
        d2.d(this.a, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(10), 0, 0);
    L214:
        o.a(this.b, 28);
        SimpleDraweeView r57 = this.d;
        if (r57 == null) goto L217;
        ViewGroup.LayoutParams r58 = r57.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r59 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r58.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r57.getContext(), 52);
        r58.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r57.getContext(), 52);
        r57.setLayoutParams(r58);
    L217:
        SimpleDraweeView r60 = this.e;
        if (r60 == null) goto L220;
        ViewGroup.LayoutParams r61 = r60.getLayoutParams();
        com.bytedance.android.shopping.deepfeed.ui.view.a r62 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r61.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r60.getContext(), 65);
        r61.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r60.getContext(), 65);
        r60.setLayoutParams(r61);
    L220:
        SimpleDraweeView r63 = this.e;
        if (r63 != null) goto L223;
    L227:
        SimpleDraweeView r64 = this.d;
        if (r64 == null) goto L252;
        d2.d(r64, 0, com.bytedance.android.shopping.extensions.b.b(10), 0, 0);
        return;
    L252:
        return;
    L223:
        if (r63.getVisibility() != 0) goto L227;
        SimpleDraweeView r65 = this.d;
        if (r65 == null) goto L250;
        d2.d(r65, 0, com.bytedance.android.shopping.extensions.b.b(6), 0, 0);
        return;
    L250:
        return;
    L256:
        return;
    L163:
        SimpleDraweeView r66 = this.e;
        if (r66 == null) goto L166;
        r66.setVisibility(0);
    L166:
        SimpleDraweeView r67 = this.e;
        if (r67 == null) goto L169;
        h0.e(r67, r110, null, null, null, 120);
        goto L169
    L155:
        if (r110.length() == 0) goto L158;
        r32 = false;
    L152:
        r110 = r15;
        goto L153
    L131:
        r19 = r15;
        goto L132
    L123:
        if (tc3.f.b() == true) goto L125;
        r6.S5(r24);
    L125:
        int r68 = ie3.b.a;
        r6.k.setVisibility(8);
        r26.d();
        if (tc3.f.b() == false) goto L129;
        r6.V5(r24, MarqueeViewItemType.TWO_REC_REASON_VIEW);
        goto L129
    L119:
        r18 = false;
        goto L120
    L109:
        if (r16.length() <= 0) goto L111;
        boolean r69 = true;
    L112:
        if (r69 == false) goto L114;
        SalesViewContainer r70 = r6.c;
        r70.getClass();
        Intrinsics.checkNotNullParameter(r16, "t");
        r70.a.setText(r16);
        r6.c.setVisibility(0);
        r17 = 8;
        goto L116
    L114:
        r17 = 8;
        r6.c.setVisibility(8);
        goto L116
    L111:
        r69 = false;
    L101:
        u1 r71 = r12.n();
        if (r71 == null) goto L106;
        List<String> r72 = r71.a();
        if (r72 == null) goto L106;
        r16 = (String) CollectionsKt.firstOrNull(r72);
    L106:
        r16 = r15;
        goto L107
    L92:
        if (com.bytedance.android.shopping.extensions.k.c(r10) == false) goto L94;
        r6.b.setVisibility(0);
        r6.b.setText(r10);
        goto L96
    L94:
        r6.b.setVisibility(8);
    L87:
        r10 = r15;
        goto L89
    L82:
        p1 r73 = r12.k();
        if (r73 == null) goto L87;
        o1 r74 = r73.d();
        if (r74 == null) goto L87;
        r10 = r74.a();
        goto L89
    L75:
        r5 = r15;
        goto L76
    L17:
        if (r3.a() != null) goto L19;
    L21:
        Integer r111 = r3.c();
    L22:
        if (r111 != null) goto L25;
        r13.setVisibility(8);
        goto L24
    L25:
        r13.setVisibility(0);
    L66:
        e = e;
    L67:
        r15 = null;
    L68:
        String r75 = e.getMessage();
        if (r75 != null) goto L71;
        r75 = r8;
    L71:
        ECExceptionMonitor.c(r75);
        r13.setVisibility(8);
        goto L72
    L27:
        if (r111.intValue() <= 1000000) goto L35;
        String r76 = "万";
        Object[] r77 = new Object[1];     // Catch: Exception -> L66
        r77[0] = Double.valueOf(((double) r111.intValue()) / 1000000.0d);     // Catch: Exception -> L33
        r8 = "";
        String r78 = new Regex("\\.0$").replace(String.format("%.1f", Arrays.copyOf(r77, 1)), r8);     // Catch: Exception -> L66
    L37:
        r15 = null;
    L64:
        e = e;
        goto L68
    L39:
        if (StringsKt.contains$default(r78, ".", false, 2, null) == false) goto L45;
        int r79 = StringsKt.indexOf$default(r78, ".", 0, false, 6, null);     // Catch: Exception -> L64
        if (r78 == null) goto L44;
        String r112 = r78.substring(0, r79);     // Catch: Exception -> L64
        CharSequence r80 = r78.substring(r79);     // Catch: Exception -> L64
        r13.b.setVisibility(0);     // Catch: Exception -> L64
        CharSequence r81 = r80;
        r78 = r112;
    L46:
        r13.a.setText(r78);     // Catch: Exception -> L64
        r13.b.setText(r81);     // Catch: Exception -> L64
        if (r76 != null) goto L54;
        List<c1> r82 = r3.e();     // Catch: Exception -> L64
        if (r82 == null) goto L53;
        c1 r84 = (c1) CollectionsKt.firstOrNull(r82);     // Catch: Exception -> L64
        if (r84 == null) goto L53;
        r76 = r84.a();     // Catch: Exception -> L64
    L53:
        r76 = null;
    L54:
        if (r76 != null) goto L56;
    L59:
        boolean r85 = true;
    L60:
        if (r85 == false) goto L62;
        r13.c.setVisibility(8);     // Catch: Exception -> L64
        goto L72
    L62:
        r13.c.setVisibility(0);     // Catch: Exception -> L64
        r13.c.setText(r76);     // Catch: Exception -> L64
        goto L72
    L56:
        if (r76.length() == 0) goto L59;
        r85 = false;
        goto L60
    L44:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L64
    L45:
        r13.b.setVisibility(8);     // Catch: Exception -> L64
        r81 = r8;
    L33:
        e = e;
        r8 = "";
        goto L67
    L35:
        r78 = new Regex("\\.?0+$").replace(String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(((double) r111.intValue()) / 100.0d)}, 1)), "");     // Catch: Exception -> L66
        r76 = null;
        goto L37
    L19:
        if (r3.a().intValue() <= 0) goto L21;
        r111 = r3.a();
    L128:
        r15 = null;
        goto L129
    }
}
