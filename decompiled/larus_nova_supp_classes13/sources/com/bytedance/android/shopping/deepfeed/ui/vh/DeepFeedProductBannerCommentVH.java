package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.shopping.deepfeed.action.DeepFeedCommentClickArea;
import com.bytedance.android.shopping.deepfeed.ui.view.CommentItemView;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductBannerCommentVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbstractDeepFeedBannerVH;", "a", "b", "c", "d", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductBannerCommentVH extends AbstractDeepFeedBannerVH {
    public static final /* synthetic */ int u = 0;
    public final LinearLayout a;
    public final TextView b;
    public final CommentItemView c;
    public final LinearLayout d;
    public final SimpleDraweeView e;
    public final LinearLayout f;
    public final SimpleDraweeView g;
    public final SimpleDraweeView h;
    public final SimpleDraweeView i;
    public final LinearLayout j;
    public final TextView k;
    public final TextView l;
    public final View m;
    public Integer n;
    public Function1<? super DeepFeedCommentClickArea, Unit> o;
    public Function0<Unit> p;
    public final int q;
    public final Context r;
    public final com.bytedance.android.ec.core.imagex.r s;
    public final boolean t;

    public static final class a extends MetricAffectingSpan {
        public final int a;

        public a(int r1) {
            this.a = r1;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            r3.baselineShift += this.a;
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            r3.baselineShift += this.a;
        }
    }

    public static final class b {
    }

    public static final class c extends ReplacementSpan {
        public final Matrix a;
        public LinearGradient b;
        public float c;
        public float d;
        public final String e;

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.e = r2;
            this.a = new Matrix();
            this.c = -1.0f;
            this.d = -1.0f;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
            Intrinsics.checkNotNullParameter(r1, "paint");
            Intrinsics.checkNotNullParameter(r2, "text");
            return (int) r1.measureText(this.e);
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r21, CharSequence r22, int r23, int r24, float r25, int r26, int r27, int r28, Paint r29) {
            Intrinsics.checkNotNullParameter(r21, "canvas");
            Intrinsics.checkNotNullParameter(r22, "text");
            Intrinsics.checkNotNullParameter(r29, "paint");
            if (this.e.length() != 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L8;
            return;
        L8:
            Shader r6 = r29.getShader();
            int r8 = r29.getColor();
            float r9 = RangesKt.coerceAtLeast(r29.measureText(this.e), 1.0f);
            float r10 = RangesKt.coerceAtLeast(r28 - r26, 1.0f);
            if (this.b != null) goto L11;
        L15:
            double r11 = Math.toRadians(99.48d);
            Pair r12 = TuplesKt.to(Float.valueOf((float) Math.sin(r11)), Float.valueOf((float) (-Math.cos(r11))));
            this.b = new LinearGradient(0.0f, 0.0f, r9 * ((Number) r12.getFirst()).floatValue(), ((Number) r12.getSecond()).floatValue() * r10, new int[]{ColorProtector.parseColor("#A20A32"), ColorProtector.parseColor("#1D1724"), ColorProtector.parseColor("#161823")}, new float[]{0.0465f, 0.4277f, 0.8986f}, Shader.TileMode.CLAMP);
            this.c = r9;
            this.d = r10;
        L16:
            this.a.reset();
            this.a.setTranslate(r25, r26);
            LinearGradient r3 = this.b;
            if (r3 == null) goto L19;
            r3.setLocalMatrix(this.a);
        L19:
            r29.setShader(this.b);
            r21.drawText(this.e, r25, r27, r29);
            r29.setShader(r6);
            r29.setColor(r8);
            return;
        L11:
            if (this.c != r9) goto L15;
            if (this.d != r10) goto L15;
        L5:
            r5 = false;
            goto L6
        }
    }

    public static final class d extends MetricAffectingSpan {
        public final int a;

        public d() {
            this.a = 900;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            r3.setTypeface(i.a(r3.getTypeface(), this.a));
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "textPaint");
            r3.setTypeface(i.a(r3.getTypeface(), this.a));
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ DeepFeedProductBannerCommentVH a;

        public e(DeepFeedProductBannerCommentVH r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (((RecyclerView.ViewHolder) this.a).itemView.isShown() == false) goto L11;
            Function0<Unit> r0 = this.a.p;     // Catch: Throwable -> L8
            if (r0 == null) goto L15;
            Unit r1 = (Unit) r0.invoke();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void T3(int r1) {
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void U3(int r1) {
    }

    public final void Y3() {
        com.bytedance.android.shopping.deepfeed.ui.view.a r0 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        int r1 = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(this.r, 12);
        ViewGroup.LayoutParams r2 = this.a.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r2 = null;
    L5:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;
        if (r3 != null) goto L8;
        return;
    L8:
        r3.leftMargin = r1;
        r3.rightMargin = r1;
        if (this.t == true) goto L11;
        r3.gravity = 17;
        r3.topMargin = 0;
        r3.bottomMargin = com.bytedance.android.shopping.extensions.b.b(10);
    L12:
        this.a.setLayoutParams(r3);
        return;
    L11:
        r3.gravity = 17;
        r3.topMargin = 0;
        r3.bottomMargin = com.bytedance.android.shopping.extensions.b.b(14);
        goto L12
    }

    public final void X3(SimpleDraweeView r10, ImageURL r11) {
        if (r11 == null) goto L4;
        InFeedUrlModel r0 = new InFeedUrlModel();
        r0.setUrlList(r11.getUrlList());
    L5:
        h0.d(r10, r0, this.s, null, null, null, null, 120);
        return;
    L4:
        r0 = null;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v47 */
    public final void W3(he3.h r27, int r28, Bitmap r29) {
        TextView r1 = this.b;
        r1.setTypeface(i.a(r1.getTypeface(), 700));
        if (r27 == null) goto L5;
        he3.f r2 = r27.b();
    L7:
        if (r2 != null) goto L16;
        if (r27 == null) goto L10;
        List<he3.g> r3 = r27.c();
    L11:
        if (r3 != null) goto L14;
        r3 = CollectionsKt.emptyList();
    L14:
        if (r3.size() != 1) goto L16;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        TextView r5 = this.b;
        com.bytedance.android.shopping.deepfeed.ui.view.a r6 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        d2.d(r5, com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(this.r, 24), 0, 0, 0);
    L21:
        ?? r7 = this.b;
        if (r27 == null) goto L24;
        he3.n r8 = r27.f();
    L25:
        if (r8 == null) goto L27;
        List<String> r9 = r8.b();
    L28:
        if (r9 != null) goto L30;
        r9 = CollectionsKt.emptyList();
    L30:
        String r10 = "";
        if (r9.isEmpty() == false) goto L33;
        ?? r11 = "";
    L57:
        r7.setText(r11);
        if (r27 == null) goto L62;
        ImageURL r12 = r27.a();
        if (r12 == null) goto L62;
        InFeedUrlModel r13 = new InFeedUrlModel();
        r13.setUrlList(r12.getUrlList());
        InFeedUrlModel r14 = r13;
    L64:
        if (r14 != null) goto L66;
        this.i.setVisibility(8);
        this.i.setImageDrawable(null);
        this.i.getHierarchy().setPlaceholderImage(null);
    L67:
        if (r27 == null) goto L69;
        he3.f r15 = r27.b();
    L70:
        if (r15 != null) goto L72;
        this.c.setVisibility(8);
    L77:
        Context r16 = this.r;
        if (r27 == null) goto L80;
        List<he3.g> r17 = r27.c();
    L81:
        if (r17 != null) goto L83;
        r17 = CollectionsKt.emptyList();
    L83:
        LinearLayout r18 = this.d;
        if (r17.isEmpty() == false) goto L86;
        int r19 = 8;
    L87:
        r18.setVisibility(r19);
        if (r17.isEmpty() == true) goto L139;
        ViewGroup.LayoutParams r20 = this.d.getLayoutParams();
        if (r20 == null) goto L211;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        ViewGroup.LayoutParams r110 = this.e.getLayoutParams();
        if (r110 == null) goto L209;
        LinearLayout.LayoutParams r111 = (LinearLayout.LayoutParams) r110;
        ViewGroup.LayoutParams r112 = this.f.getLayoutParams();
        if (r112 == null) goto L207;
        LinearLayout.LayoutParams r113 = (LinearLayout.LayoutParams) r112;
        ViewGroup.LayoutParams r114 = this.g.getLayoutParams();
        if (r114 == null) goto L205;
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r114;
        ViewGroup.LayoutParams r116 = this.h.getLayoutParams();
        if (r116 == null) goto L203;
        LinearLayout.LayoutParams r117 = (LinearLayout.LayoutParams) r116;
        if (r17.size() < 3) goto L116;
        this.d.setGravity(0);
        com.bytedance.android.shopping.deepfeed.ui.view.a r22 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r21.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 232);
        this.f.setVisibility(0);
        this.h.setVisibility(0);
        r111.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 232);
        r111.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 232);
        r111.weight = 0.0f;
        r113.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 115);
        r113.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 232);
        r113.weight = 0.0f;
        r113.setMarginStart(com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 4));
        r115.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 115);
        r115.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 114);
        r115.weight = 0.0f;
        r117.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 115);
        r117.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 114);
        r117.weight = 0.0f;
        r117.topMargin = com.bytedance.android.shopping.extensions.b.b(4);
        V3(this.e, com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16));
        V3(this.g, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8));
        V3(this.h, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8));
        SimpleDraweeView r23 = this.e;
        he3.g r24 = (he3.g) CollectionsKt.getOrNull(r17, 0);
        if (r24 == null) goto L105;
        ImageURL r25 = r24.a();
    L106:
        X3(r23, r25);
        SimpleDraweeView r26 = this.g;
        he3.g r30 = (he3.g) CollectionsKt.getOrNull(r17, 1);
        if (r30 == null) goto L109;
        ImageURL r31 = r30.a();
    L110:
        X3(r26, r31);
        SimpleDraweeView r32 = this.h;
        he3.g r33 = (he3.g) CollectionsKt.getOrNull(r17, 2);
        if (r33 == null) goto L113;
        ImageURL r34 = r33.a();
    L114:
        X3(r32, r34);
        Y3();
    L138:
        this.d.setLayoutParams(r21);
        this.e.setLayoutParams(r111);
        this.f.setLayoutParams(r113);
        this.g.setLayoutParams(r115);
        this.h.setLayoutParams(r117);
        goto L139
    L113:
        r34 = null;
        goto L114
    L109:
        r31 = null;
        goto L110
    L105:
        r25 = null;
        goto L106
    L116:
        if (r17.size() != 2) goto L126;
        this.d.setGravity(0);
        com.bytedance.android.shopping.deepfeed.ui.view.a r35 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r21.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 173);
        this.f.setVisibility(0);
        this.h.setVisibility(8);
        r111.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 173);
        r111.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 173);
        r111.weight = 0.0f;
        r113.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 173);
        r113.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 173);
        r113.weight = 0.0f;
        r113.setMarginStart(com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 6));
        r115.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 173);
        r115.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, 173);
        r115.weight = 0.0f;
        r117.topMargin = 0;
        V3(this.e, com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16));
        V3(this.g, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(8));
        SimpleDraweeView r36 = this.e;
        he3.g r37 = (he3.g) CollectionsKt.getOrNull(r17, 0);
        if (r37 == null) goto L120;
        ImageURL r38 = r37.a();
    L121:
        X3(r36, r38);
        SimpleDraweeView r39 = this.g;
        he3.g r40 = (he3.g) CollectionsKt.getOrNull(r17, 1);
        if (r40 == null) goto L124;
        ImageURL r41 = r40.a();
    L125:
        X3(r39, r41);
        Y3();
        goto L138
    L124:
        r41 = null;
        goto L125
    L120:
        r38 = null;
        goto L121
    L126:
        this.d.setGravity(1);
        if (r27 == null) goto L129;
        he3.f r42 = r27.b();
    L130:
        if (r42 != null) goto L132;
        int r43 = 303;
    L133:
        com.bytedance.android.shopping.deepfeed.ui.view.a r44 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r21.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, r43);
        this.f.setVisibility(8);
        r111.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, r43);
        r111.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(r16, r43);
        r111.weight = 0.0f;
        r113.width = 0;
        r113.height = 0;
        r113.weight = 0.0f;
        r113.setMarginStart(0);
        V3(this.e, com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(16));
        SimpleDraweeView r45 = this.e;
        he3.g r46 = (he3.g) CollectionsKt.getOrNull(r17, 0);
        if (r46 == null) goto L136;
        ImageURL r47 = r46.a();
    L137:
        X3(r45, r47);
        Y3();
        goto L138
    L136:
        r47 = null;
        goto L137
    L132:
        r43 = 267;
        goto L133
    L129:
        r42 = null;
        goto L130
    L203:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L205:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L207:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L209:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L211:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L139:
        if (r27 == null) goto L143;
        he3.p r48 = r27.d();
        if (r48 == null) goto L143;
        List<he3.o> r49 = r48.b();
    L144:
        if (r49 != null) goto L146;
        r49 = CollectionsKt.emptyList();
    L146:
        ArrayList r50 = new ArrayList();
        Iterator r51 = r49.iterator();
    L148:
        if (r51.hasNext() == false) goto L158;
        String r52 = ((he3.o) r51.next()).a();
        if (r52 != null) goto L152;
    L154:
        r52 = null;
    L155:
        if (r52 == null) goto L148;
        r50.add(r52);
        goto L148
    L152:
        if ((!StringsKt.isBlank(r52)) == false) goto L154;
    L158:
        if (r50.isEmpty() == false) goto L160;
        this.j.setVisibility(8);
        this.m.setVisibility(8);
    L200:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new f(this));
        this.c.setOnCommentAreaClickListener(new DeepFeedProductBannerCommentVH$bindClickListeners$2(this));
        this.d.setOnClickListener(new g(this));
        this.l.setOnClickListener(new h(this));
        ((RecyclerView.ViewHolder) this).itemView.post(new e(this));
        return;
    L160:
        this.j.setVisibility(0);
        ViewGroup.LayoutParams r53 = this.j.getLayoutParams();
        if ((r53 instanceof LinearLayout.LayoutParams) == true) goto L163;
        r53 = null;
    L163:
        LinearLayout.LayoutParams r54 = (LinearLayout.LayoutParams) r53;
        if (r54 == null) goto L184;
        if (r27 == null) goto L168;
        he3.f r55 = r27.b();
    L169:
        if (r55 != null) goto L178;
        if (r27 == null) goto L172;
        List<he3.g> r56 = r27.c();
    L173:
        if (r56 != null) goto L175;
        r56 = CollectionsKt.emptyList();
    L175:
        int r57 = 1;
        if (r56.size() != 1) goto L179;
        boolean r58 = true;
    L180:
        if (r58 == false) goto L182;
        com.bytedance.android.shopping.deepfeed.ui.view.a r59 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        r54.width = com.bytedance.android.shopping.deepfeed.ui.view.a.C0061a.a(this.r, 303);
        r54.gravity = r57;
        r54.leftMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r54.rightMargin = com.bytedance.android.shopping.extensions.b.b(4);
    L183:
        this.j.setLayoutParams(r54);
        goto L184
    L182:
        r54.width = -1;
        r54.gravity = 0;
    L179:
        r58 = false;
        goto L180
    L172:
        r56 = null;
        goto L173
    L178:
        r57 = 1;
        goto L179
    L168:
        r55 = null;
    L184:
        TextView r60 = this.k;
        if (r27 == null) goto L189;
        he3.p r61 = r27.d();
        if (r61 == null) goto L189;
        String r62 = r61.a();
    L190:
        if (r62 == null) goto L193;
        r10 = r62;
    L193:
        r60.setText(r10);
        this.l.setText(CollectionsKt.joinToString$default(r50, "  ", null, null, 0, null, null, 62, null));
        if (r27 == null) goto L196;
        he3.f r63 = r27.b();
    L197:
        if (r63 != null) goto L199;
        this.m.setVisibility(0);
        goto L200
    L199:
        this.m.setVisibility(8);
        goto L200
    L196:
        r63 = null;
    L189:
        r62 = null;
    L143:
        r49 = null;
        goto L144
    L86:
        r19 = 0;
        goto L87
    L80:
        r17 = null;
        goto L81
    L72:
        this.c.setVisibility(0);
        CommentItemView r64 = this.c;
        if (r27 == null) goto L75;
        he3.f r65 = r27.b();
    L76:
        r64.a(r65, this.s, true);
        goto L77
    L75:
        r65 = null;
        goto L76
    L69:
        r15 = null;
        goto L70
    L66:
        this.i.setVisibility(0);
        LruCache<String, Bitmap> r66 = l.a;
        l.a(this.n, r14, r28, this.i, this.s, r29);
    L62:
        r14 = null;
        goto L64
    L33:
        if (r8 == null) goto L35;
        List<Integer> r67 = r8.a();
    L36:
        if (r67 != null) goto L38;
        r67 = CollectionsKt.emptyList();
    L38:
        r11 = new SpannableStringBuilder();
        Iterator r68 = r9.iterator();
        int r118 = 0;
    L40:
        if (r68.hasNext() == false) goto L57;
        Object r119 = r68.next();
        int r120 = r118 + 1;
        if (r118 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        String r121 = (String) r119;
        int r122 = r11.length();
        if (r121 != null) goto L47;
        r121 = "";
    L47:
        r11.append(r121);
        if (r67.contains(Integer.valueOf(r118)) == false) goto L51;
        r11.setSpan(new c(r121), r122, r11.length(), 33);
        r11.setSpan(new AbsoluteSizeSpan(24, true), r122, r11.length(), 33);
        r11.setSpan(new d(), r122, r11.length(), 33);
    L56:
        r118 = r120;
        goto L40
    L51:
        if (r121.length() <= 0) goto L53;
        boolean r123 = true;
    L54:
        if (r123 == false) goto L56;
        r11.setSpan(new a(this.q), r122, r11.length(), 33);
        goto L56
    L53:
        r123 = false;
        goto L54
    L35:
        r67 = null;
        goto L36
    L27:
        r9 = null;
        goto L28
    L24:
        r8 = null;
        goto L25
    L20:
        d2.d(this.b, 0, 0, 0, 0);
        goto L21
    L10:
        r3 = null;
    L16:
        r4 = false;
        goto L18
    L5:
        r2 = null;
        goto L7
    }

    public DeepFeedProductBannerCommentVH(Context r2, View r3, com.bytedance.android.ec.core.imagex.r r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.r = r2;
        this.s = r4;
        this.t = r5;
        this.a = (LinearLayout) r3.findViewById(2131368675);
        this.b = (TextView) r3.findViewById(2131390374);
        this.c = (CommentItemView) r3.findViewById(2131367332);
        this.d = (LinearLayout) r3.findViewById(2131377519);
        this.e = r3.findViewById(2131376346);
        this.f = (LinearLayout) r3.findViewById(2131377601);
        this.g = r3.findViewById(2131376566);
        this.h = r3.findViewById(2131376561);
        this.i = r3.findViewById(2131367313);
        this.j = (LinearLayout) r3.findViewById(2131375188);
        this.k = (TextView) r3.findViewById(2131367364);
        this.l = (TextView) r3.findViewById(2131390772);
        this.m = r3.findViewById(2131368676);
        this.q = com.bytedance.android.shopping.extensions.b.b(-2);
    }

    public static void V3(SimpleDraweeView r0, float r1, float r2, float r3, float r4) {
        r0.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r1, r2, r3, r4));
    }
}
