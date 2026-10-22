package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroElasticMultiElementTitle;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroElasticTitle;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.q;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.PromotionCardStyleHelper;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/IntroInfoElasticTitleWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/info/a;", "", "getCurrentContentDescription", "", "a", "I", "getType", "()I", LocationMonitorConst.TYPE, "Loh2/e;", "b", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "c", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroInfoElasticTitleWidget extends LinearLayout implements a {
    public final int a;
    public oh2.e b;
    public oh2.c c;
    public StringBuilder d;
    public IntroInfoTagAndCountdownLayout e;
    public IntroInfoSalePointView f;
    public IntroInfoSalePointView g;
    public d h;
    public s i;

    public IntroInfoElasticTitleWidget(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroInfoElasticTitleWidget(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.d;
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public final void release() {
        IntroInfoTagAndCountdownLayout r0 = this.e;
        if (r0 == null) goto L10;
        oh2.e r1 = getArgument();
        if (r1 == null) goto L9;
        oh2.d r2 = r1.d;
        if (r2 == null) goto L9;
        r2.a();
    L9:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(r0);
    L10:
        d r3 = this.h;
        if (r3 == null) goto L13;
        r3.a();
    L13:
        this.h = null;
    }

    public oh2.e getArgument() {
        return this.b;
    }

    public oh2.c getContainerAbility() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public int getType() {
        return this.a;
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoSalePointView] */
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
    public final void b(s r19) {
        Intrinsics.checkNotNullParameter(r19, "elasticTitle");
        this.d = new StringBuilder();
        this.i = r19;
        if (this.e == null) goto L5;
        getArgument();
    L5:
        IntroInfoTagAndCountdownLayout r1 = this.e;
        if (r1 == null) goto L9;
        r1.a = getContainerAbility();
    L9:
        if (r19.c() == null) goto L11;
    L16:
        IntroInfoTagAndCountdownLayout r2 = this.e;
        if (r2 == null) goto L19;
        r2.setVisibility(0);
    L19:
        final IntroInfoTagAndCountdownLayout r3 = this.e;
        if (r3 == null) goto L59;
        int r6 = IntroInfoTagAndCountdownLayout.j;
        Intrinsics.checkNotNullParameter(r19, "model");
        r3.f = 0;
        r3.e = false;
        t1 r7 = r19.c();
        if (r7 == null) goto L29;
        UtilityKotlinExtentionsKt.f(r7.c(), r7.a(), new IntroInfoTagAndCountdownLayout$bind$$inlined$let$lambda$1(r3));
        List r8 = r7.b();
        if (r8 == null) goto L28;
        String r13 = (String) CollectionsKt.firstOrNull(r8);
        if (r13 == null) goto L28;
        h0.e(r3.b, r13, null, null, null, 120);
    L28:
        ViewExtensionsKt.g(r3.b, 0.0f, 0.0f, 0.0f, 0.0f);
        r3.b.setVisibility(0);
    L30:
        r3.i = null;
        r r0 = r19.b();
        r3.d = r0;
        if (r0 == null) goto L54;
        r3.a(r0);
        ViewGroup.LayoutParams r4 = r3.b.getLayoutParams();
        if (r4 == null) goto L53;
        ((LinearLayout.LayoutParams) r4).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(2.0f)), 0);
        r r5 = r3.d;
        if (r5 == null) goto L47;
        String r9 = r5.a();
        if (r9 == null) goto L47;
        Integer r10 = com.bytedance.android.ec.core.utils.s.b(r9);
        if (r10 == null) goto L47;
        int r11 = r10.intValue();
        r r12 = r3.d;
        if (r12 == null) goto L43;
        String r14 = r12.b();
    L44:
        r3.c.setTextColor(com.bytedance.android.ec.core.utils.s.a(r14, -1));
        int r15 = c0.a;
        c0.b(r3.c, MonitorLevel.ERROR);
        d2.e(r3, UtilityKotlinExtentionsKt.d(4));
        r3.c.setTypeface(Typeface.MONOSPACE);
        r3.setPadding(0, 0, UtilityKotlinExtentionsKt.d(2), 0);
        if (Build.VERSION.SDK_INT < 23) goto L59;
        float r16 = UtilityKotlinExtentionsKt.c(3);
        GradientDrawable r17 = new GradientDrawable();
        r17.setStroke(2, r11);
        r17.setCornerRadius(r16);
        r3.setForeground(r17);
        goto L59
    L43:
        r14 = null;
    L47:
        r r18 = r3.d;
        if (r18 == null) goto L50;
        String r20 = r18.b();
    L51:
        r3.c(r20);
        Unit r21 = Unit.INSTANCE;
        goto L59
    L50:
        r20 = null;
        goto L51
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L54:
        ViewGroup.LayoutParams r22 = r3.b.getLayoutParams();
        if (r22 == null) goto L58;
        ((LinearLayout.LayoutParams) r22).setMargins(0, 0, 0, 0);
        r3.c(null);
        r3.c.setVisibility(8);
        goto L59
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L29:
        r3.b.setVisibility(8);
    L59:
        IntroInfoTagAndCountdownLayout r23 = this.e;
        if (r23 == null) goto L75;
        int r24 = IntroInfoTagAndCountdownLayout.j;
        if (r23.b(null) == false) goto L69;
        oh2.e r25 = getArgument();
        if (r25 == null) goto L68;
        oh2.d r26 = r25.d;
        if (r26 == null) goto L68;
        r26.a();
    L68:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(r23);
        goto L75
    L69:
        oh2.e r27 = getArgument();
        if (r27 == null) goto L74;
        oh2.d r28 = r27.d;
        if (r28 == null) goto L74;
        r28.a();
    L74:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(r23);
    L75:
        s r29 = this.i;
        if (r29 == null) goto L78;
        q r30 = r29.a();
    L79:
        s r31 = this.i;
        if (r31 == null) goto L88;
        q r32 = r31.a();
        if (r32 == null) goto L88;
        List<IntroElasticMultiElementTitle> r33 = r32.b();
        if (r33 == null) goto L88;
        if ((!r33.isEmpty()) == false) goto L88;
    L89:
        if (r29 == null) goto L113;
        if (r30 == null) goto L114;
        if (r33 == null) goto L115;
        long r34 = r30.a();
        if (r34 > 0) goto L95;
    L111:
        Unit r35 = (Unit) UtilityKotlinExtentionsKt.f(this.f, CollectionsKt.firstOrNull(r33), new IntroInfoElasticTitleWidget$setSalePointCarousel$$inlined$lets3$lambda$1(this));
        return;
    L95:
        if (r33.size() == 1) goto L111;
        if (r33.size() <= 1) goto L116;
        ?? r110 = this.f;
        if (r110 == 0) goto L119;
        IntroInfoSalePointView r36 = this.g;
        if (r36 == null) goto L120;
        d r37 = this.h;
        if (r37 == null) goto L108;
        r37.a();
    L108:
        this.h = null;
        this.h = new d(this, r110, r36, r33, r33, r34, r34);
        r110.setVisibility(0);
        d r38 = this.h;
        if (r38 == null) goto L117;
        r38.j();
        return;
    L117:
        return;
    L120:
        return;
    L119:
        return;
    L116:
        return;
    L115:
        return;
    L114:
        return;
    L113:
        return;
    L88:
        r33 = null;
        goto L89
    L78:
        r30 = null;
        goto L79
    L11:
        if (r19.b() != null) goto L16;
        IntroInfoTagAndCountdownLayout r39 = this.e;
        if (r39 == null) goto L59;
        r39.setVisibility(8);
        goto L59
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setArgument(oh2.e r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a
    public void setContainerAbility(oh2.c r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoSalePointView] */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoSalePointView] */
    public IntroInfoElasticTitleWidget(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = 1;
        setGravity(16);
        IntroInfoTagAndCountdownLayout r7 = new IntroInfoTagAndCountdownLayout(getContext(), null, 6, 0);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14)));
        r7.setPadding(0, 0, UtilityKotlinExtentionsKt.d(4), 0);
        r7.setVisibility(8);
        addView(r7);
        Unit r8 = Unit.INSTANCE;
        this.e = r7;
        ?? r9 = new IntroInfoSalePointView(getContext());
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(r9);
        this.f = r9;
        ?? r10 = new IntroInfoSalePointView(getContext());
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(r10);
        this.g = r10;
        o0.c(this, 16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.Integer, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r10v17, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.Integer, java.lang.Number] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView] */
    /* JADX WARN: Type inference failed for: r18v0, types: [android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoSalePointView, com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View[]] */
    public static final void a(IntroInfoElasticTitleWidget r17, final IntroInfoSalePointView r18, IntroElasticMultiElementTitle r19) {
        r17.getClass();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "data");
        r18.removeAllViews();
        List<IntroElasticTitle> r1 = r19.b();
        AttributeSet r4 = null;
        if (r1 == null) goto L85;
        Iterator r2 = r1.iterator();
        int r6 = 0;
    L6:
        if (r2.hasNext() == false) goto L85;
        Object r7 = r2.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        final IntroElasticTitle r9 = (IntroElasticTitle) r7;
        final String r10 = a2.d(r9.d());
        if (r10 == null) goto L66;
        Context r11 = r18.getContext();
        ArrayList r12 = (ArrayList) r18.b;
        if ((!r12.isEmpty()) == false) goto L17;
        View r13 = (View) ListProtector.remove(r12, 0);
        ViewParent r14 = r13.getParent();
        Object r15 = r13;
        if (r14 != null) goto L17;
    L18:
        GradientAndItalicTextView r16 = (GradientAndItalicTextView) r15;
        float r110 = 12.0f;
        final ?? r111 = r16;
        if (r16 != null) goto L21;
        AppCompatTextView r112 = new GradientAndItalicTextView(r11, r4, 6, 0);
        r112.setTextSize(1, 12.0f);
        r112.setTextColor(th.a.a(r11, 2131106053));
        r112.setEllipsize(TextUtils.TruncateAt.END);
        r112.setMaxLines(1);
        r112.setIncludeFontPadding(false);
        r111 = r112;
    L21:
        Integer r113 = r9.getType();
        if (r113 != null) goto L25;
    L37:
        ?? r114 = Integer.valueOf(r9.e());
        if (r114.intValue() <= 0) goto L40;
        boolean r115 = true;
    L41:
        if (r115 == true) goto L44;
        r114 = r4;
    L44:
        if (r114 == 0) goto L46;
        r110 = r114.intValue();
    L46:
        r111.setTextSize(1, r110);
        c0.b(r111, MonitorLevel.ERROR);
    L47:
        r111.setText(r10);
        List<String> r116 = r9.c();
        if (r116 == null) goto L60;
        ?? r117 = PromotionCardStyleHelper.ButtonHelper.a(r116);
        if (((ArrayList) r117).size() != 3) goto L52;
        boolean r118 = true;
    L53:
        if (r118 == true) goto L56;
        r117 = r4;
    L56:
        if (r117 == 0) goto L60;
        int[] r119 = CollectionsKt.toIntArray(r117);
        if (r119 == null) goto L60;
        r111.setLinearGradientCreator(new ol2.a(r119, new float[]{0.0491f, 0.3019f, 0.7577f}, IntroInfoSalePointView$bindData$1$view$1$1$4$1.INSTANCE));
    L61:
        UtilityKotlinExtentionsKt.h(r119, new IntroInfoSalePointView$bindData$$inlined$forEachIndexed$lambda$1(r111, r10, r9, r18));
        if (Intrinsics.areEqual(r9.a(), Boolean.TRUE) == false) goto L64;
        c0.b(r111, MonitorLevel.FATAL);
    L65:
        r111.setEllipsize(TextUtils.TruncateAt.END);
        ?? r120 = r111;
    L67:
        if (r120 == 0) goto L84;
        if (r6 <= 0) goto L80;
        Context r5 = r18.getContext();
        ArrayList r20 = (ArrayList) r18.c;
        if ((!r20.isEmpty()) == false) goto L75;
        View r21 = (View) ListProtector.remove(r20, 0);
        if (r21.getParent() != null) goto L75;
    L76:
        Space r22 = (Space) r21;
        if (r22 != null) goto L79;
        r22 = new Space(r5);
        r22.setLayoutParams(new LinearLayoutCompat.LayoutParams(UtilityKotlinExtentionsKt.d(4), -1));
    L79:
        r18.addView(r22);
    L81:
        r18.addView(r120);
        if (r22 == null) goto L84;
        r18.setHideGroup(new View[]{r22, r120});
    L75:
        r21 = null;
        goto L76
    L80:
        r22 = null;
    L84:
        r6 = r8;
        r4 = null;
        goto L6
    L64:
        c0.b(r111, MonitorLevel.ERROR);
        goto L65
    L52:
        r118 = false;
    L60:
        r119 = null;
        goto L61
    L40:
        r115 = false;
        goto L41
    L25:
        if (r113.intValue() != 3) goto L37;
        ?? r121 = Integer.valueOf(r9.e());
        if (r121.intValue() <= 0) goto L29;
        boolean r122 = true;
    L30:
        if (r122 == true) goto L33;
        r121 = r4;
    L33:
        if (r121 == 0) goto L35;
        float r123 = r121.intValue();
    L36:
        r111.setTextSize(1, r123);
        c0.b(r111, MonitorLevel.FATAL);
        goto L47
    L35:
        r123 = 10.0f;
        goto L36
    L29:
        r122 = false;
    L17:
        r15 = r4;
        goto L18
    L66:
        r120 = 0;
    L85:
        StringBuilder r3 = r17.d;
        if (r3 == null) goto L88;
        r3.append(r19.a());
    L88:
        List<s1> r23 = r19.c();
        if (r23 == null) goto L114;
        Iterator r24 = r23.iterator();
    L92:
        if (r24.hasNext() == false) goto L130;
        s1 r25 = (s1) r24.next();
        String r26 = r25.a();
        Map<String, String> r27 = r25.b();
        if (r26 == null) goto L92;
        if (r26.length() <= 0) goto L98;
        boolean r28 = true;
    L99:
        if (r28 == true) goto L102;
        r26 = null;
    L102:
        if (r26 == null) goto L92;
        oh2.e r29 = r17.getArgument();
        if (r29 == null) goto L92;
        IntroCardEventCenter r30 = r29.a;
        if (r30 == null) goto L92;
        oh2.e r31 = r17.getArgument();
        if (r31 == null) goto L112;
        com.bytedance.android.livesdk.livecommerce.intro.event.a r32 = r31.b;
        if (r32 == null) goto L112;
        r32.c();
        String r33 = "a1128.b3295.c59667.d30609";
    L113:
        r30.a(r26, r27, r33);
    L112:
        r33 = null;
        goto L113
    L98:
        r28 = false;
        goto L99
    L130:
        return;
    }

    public /* synthetic */ IntroInfoElasticTitleWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
