package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\u0013\b\u0016\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$B\u001d\b\u0016\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b#\u0010'B%\b\u0016\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b#\u0010*R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0010\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR#\u0010\u0015\u001a\n \u0003*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0018\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\fR#\u0010\u001d\u001a\n \u0003*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR#\u0010 \u001a\n \u0003*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u001c¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECPromotionListFooterView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getTvItemFooter", "()Landroid/widget/TextView;", "tvItemFooter", "Landroid/view/View;", "b", "getViewFooterDividerLineLeft", "()Landroid/view/View;", "viewFooterDividerLineLeft", "c", "getViewFooterDividerLineRight", "viewFooterDividerLineRight", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "d", "getBackground", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", TraceCons.METRIC_BACKGROUND, "e", "getGuildMargin", "guildMargin", "Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView;", "f", "getLeftContent", "()Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView;", "leftContent", "g", "getRightContent", "rightContent", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionListFooterView extends ConstraintLayout {
    public static final /* synthetic */ int n = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public xi2.j h;
    public List<String> i;
    public WeakReference<j> j;
    public boolean k;
    public boolean l;
    public xi2.j.a m;

    public static final class a {
    }

    static {
    }

    private final ECDraweeView getBackground() {
        return (ECDraweeView) this.d.getValue();
    }

    private final View getGuildMargin() {
        return (View) this.e.getValue();
    }

    private final ECCustomizedElementView getLeftContent() {
        return (ECCustomizedElementView) this.f.getValue();
    }

    private final ECCustomizedElementView getRightContent() {
        return (ECCustomizedElementView) this.g.getValue();
    }

    private final TextView getTvItemFooter() {
        return (TextView) this.a.getValue();
    }

    private final View getViewFooterDividerLineLeft() {
        return (View) this.b.getValue();
    }

    private final View getViewFooterDividerLineRight() {
        return (View) this.c.getValue();
    }

    public final void Y5() {
        WeakReference<j> r0 = this.j;
        if (r0 == null) goto L7;
        j r1 = r0.get();
        if (r1 == null) goto L7;
        r1.h(false);
    L7:
        ExtensionsKt.gone(getTvItemFooter());
        ExtensionsKt.gone(getViewFooterDividerLineLeft());
        ExtensionsKt.gone(getViewFooterDividerLineRight());
        ExtensionsKt.gone(getBackground());
        ExtensionsKt.gone(getLeftContent());
        ExtensionsKt.gone(getRightContent());
    }

    public ECPromotionListFooterView(Context r2) {
        super(r2);
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.a = LazyKt.lazy(r3, new ECPromotionListFooterView$tvItemFooter$2(this));
        this.b = LazyKt.lazy(r3, new ECPromotionListFooterView$viewFooterDividerLineLeft$2(this));
        this.c = LazyKt.lazy(r3, new ECPromotionListFooterView$viewFooterDividerLineRight$2(this));
        this.d = LazyKt.lazy(r3, new ECPromotionListFooterView$background$2(this));
        this.e = LazyKt.lazy(r3, new ECPromotionListFooterView$guildMargin$2(this));
        this.f = LazyKt.lazy(r3, new ECPromotionListFooterView$leftContent$2(this));
        this.g = LazyKt.lazy(r3, new ECPromotionListFooterView$rightContent$2(this));
    }

    public static final /* synthetic */ ECDraweeView S5(ECPromotionListFooterView r0) {
        return r0.getBackground();
    }

    public static final /* synthetic */ View T5(ECPromotionListFooterView r0) {
        return r0.getGuildMargin();
    }

    public static final /* synthetic */ ECCustomizedElementView U5(ECPromotionListFooterView r0) {
        return r0.getLeftContent();
    }

    public static final /* synthetic */ ECCustomizedElementView V5(ECPromotionListFooterView r0) {
        return r0.getRightContent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b6(final j r5) {
        if (r5 == null) goto L4;
        this.j = new WeakReference(r5);
    L4:
        WeakReference<j> r0 = this.j;
        if (r0 == null) goto L9;
        j r1 = r0.get();
        if (r1 == null) goto L9;
        r1.h(true);
    L9:
        ExtensionsKt.visible(getTvItemFooter());
        ExtensionsKt.visible(getViewFooterDividerLineLeft());
        ExtensionsKt.visible(getViewFooterDividerLineRight());
        TextView r2 = getTvItemFooter();
        Context r3 = null;
        if (r5 == null) goto L12;
        String r4 = r5.e();
    L13:
        r2.setText(r4);
        if (r5 == null) goto L16;
        List<String> r6 = r5.g();
    L17:
        this.i = r6;
        if (r5 != null) goto L20;
    L31:
        this.l = false;
        ExtensionsKt.gone(getBackground());
        ExtensionsKt.gone(getLeftContent());
        ExtensionsKt.gone(getRightContent());
        return;
    L20:
        if (r5.c() != true) goto L31;
        this.l = true;
        if (this.k == false) goto L24;
        c6(r5.f());
        return;
    L24:
        Context r7 = getContext();
        if ((r7 instanceof LifecycleOwner) == false) goto L28;
        r3 = r7;
    L28:
        LifecycleOwner r8 = (LifecycleOwner) r3;
        if (r8 == null) goto L34;
        r5.d(r8, new ECPromotionListFooterView$showBottomInfo$$inlined$also$lambda$1(this, r5));
        this.k = true;
        return;
    L34:
        return;
    L16:
        r6 = null;
        goto L17
    L12:
        r4 = null;
        goto L13
    }

    public final void c6(xi2.j r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.a() != null) goto L6;
        ExtensionsKt.gone(getBackground());
        Unit r0 = Unit.INSTANCE;
    L10:
        if (r2.e() != null) goto L12;
        ExtensionsKt.gone(getLeftContent());
        Unit r1 = Unit.INSTANCE;
    L16:
        if (r2.h() != null) goto L18;
        ExtensionsKt.gone(getRightContent());
        Unit r3 = Unit.INSTANCE;
        return;
    L18:
        if (this.l == false) goto L23;
        ExtensionsKt.visible(getRightContent());
        return;
    L23:
        return;
    L12:
        if (this.l == false) goto L16;
        ExtensionsKt.visible(getLeftContent());
        goto L16
    L6:
        if (this.l == false) goto L10;
        ExtensionsKt.visible(getBackground());
        goto L10
    }

    public ECPromotionListFooterView(Context r1, AttributeSet r2) {
        super(r1, r2);
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.a = LazyKt.lazy(r3, new ECPromotionListFooterView$tvItemFooter$2(this));
        this.b = LazyKt.lazy(r3, new ECPromotionListFooterView$viewFooterDividerLineLeft$2(this));
        this.c = LazyKt.lazy(r3, new ECPromotionListFooterView$viewFooterDividerLineRight$2(this));
        this.d = LazyKt.lazy(r3, new ECPromotionListFooterView$background$2(this));
        this.e = LazyKt.lazy(r3, new ECPromotionListFooterView$guildMargin$2(this));
        this.f = LazyKt.lazy(r3, new ECPromotionListFooterView$leftContent$2(this));
        this.g = LazyKt.lazy(r3, new ECPromotionListFooterView$rightContent$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r9, int r10) {
        super.onMeasure(r9, r10);
        if (ECLiveABUtils.INSTANCE.getECOM_LIVE_FIX_PROMOTION_FOOTER_VIEW_BG_SIZE() == true) goto L5;
        return;
    L5:
        int r0 = getLeftContent().getMeasuredWidth();
        int r1 = getRightContent().getMeasuredWidth();
        boolean r3 = false;
        if (getLeftContent().getVisibility() != 0) goto L8;
        boolean r2 = true;
    L10:
        if (getRightContent().getVisibility() != 0) goto L12;
        r3 = true;
    L12:
        if (r2 == true) goto L15;
        if (r3 == true) goto L15;
        return;
    L15:
        int r4 = getMeasuredWidth() - UtilityKotlinExtentionsKt.d(32);
        if (r4 > 0) goto L18;
        return;
    L18:
        ViewGroup.LayoutParams r5 = getBackground().getLayoutParams();
        if (r5 == null) goto L30;
        float r6 = r4;
        xi2.j.a r7 = this.m;
        if (r7 == null) goto L23;
        float r8 = r7.b();
    L24:
        int r11 = (int) (r6 * r8);
        if (r5.width == r4) goto L27;
    L28:
        r5.width = r4;
        r5.height = r11;
        getBackground().setLayoutParams(r5);
        measureChild(getBackground(), r9, r10);
        goto L30
    L27:
        if (r5.height == r11) goto L30;
    L23:
        r8 = 1.0f;
    L30:
        if ((r0 + r1) > r4) goto L32;
        return;
    L32:
        if (r3 == false) goto L40;
        if (r1 <= 0) goto L40;
        if (getRightContent().getChildCount() <= 0) goto L40;
        int r12 = Z5(r1, r4 - r0, getRightContent());
        if (r12 == r1) goto L39;
        measureChild(getRightContent(), r9, r10);
    L39:
        Unit r13 = Unit.INSTANCE;
        r1 = r12;
    L40:
        if (r2 == false) goto L48;
        if (r0 > 0) goto L43;
        return;
    L43:
        if (getLeftContent().getChildCount() > 0) goto L45;
        return;
    L45:
        if (Z5(r0, r4 - r1, getLeftContent()) == r0) goto L51;
        measureChild(getLeftContent(), r9, r10);
        return;
    L51:
        return;
    L48:
        return;
    L8:
        r2 = false;
        goto L10
    }

    public ECPromotionListFooterView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.NONE;
        this.a = LazyKt.lazy(r4, new ECPromotionListFooterView$tvItemFooter$2(this));
        this.b = LazyKt.lazy(r4, new ECPromotionListFooterView$viewFooterDividerLineLeft$2(this));
        this.c = LazyKt.lazy(r4, new ECPromotionListFooterView$viewFooterDividerLineRight$2(this));
        this.d = LazyKt.lazy(r4, new ECPromotionListFooterView$background$2(this));
        this.e = LazyKt.lazy(r4, new ECPromotionListFooterView$guildMargin$2(this));
        this.f = LazyKt.lazy(r4, new ECPromotionListFooterView$leftContent$2(this));
        this.g = LazyKt.lazy(r4, new ECPromotionListFooterView$rightContent$2(this));
    }

    public static int Z5(int r6, int r7, ECCustomizedElementView r8) {
        if (r6 > r7) goto L4;
        return r6;
    L4:
        int r0 = r8.getChildCount() - 1;
    L5:
        if (r0 < 0) goto L22;
        View r1 = r8.getChildAt(r0);
        r0 = r0 - 1;
        if (ECLiveABUtils.INSTANCE.getECOM_LIVE_FIX_PROMOTION_FOOTER_VIEW_BG_SIZE() == false) goto L15;
        int r2 = (r1.getMeasuredWidth() + o0.a(r1)) + o0.b(r1);
        if (r2 <= 0) goto L21;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L20;
        r3.width = 0;
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        r4.leftMargin = 0;
        r4.rightMargin = 0;
    L20:
        r6 = r6 - r2;
    L21:
        if (r6 > r7) goto L5;
    L15:
        r2 = (r1.getWidth() + o0.a(r1)) + o0.b(r1);
        if (r2 <= 0) goto L21;
        o0.f(r1, 0);
        o0.e(r1, 0);
        Intrinsics.checkNotNullParameter(r1, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ((ViewGroup.MarginLayoutParams) r5).rightMargin = 0;
        r1.setLayoutParams(r5);
    L22:
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void R5(ECPromotionListFooterView r9, ECCustomizedElementView r10, List r11, boolean r12) {
        r9.getClass();
        List<com.bytedance.android.ec.model.live.b> r0 = r10.getCurrentData();
        int r1 = 0;
        if (r0 != null) goto L5;
    L57:
        r10.b(r11, false);
        return;
    L5:
        if ((!r0.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L57;
        if (r0.size() != r11.size()) goto L21;
        Iterator<com.bytedance.android.ec.model.live.b> r2 = r0.iterator();
        Iterator r3 = r11.iterator();
    L13:
        if (r2.hasNext() == false) goto L20;
        if (r3.hasNext() == false) goto L20;
        com.bytedance.android.ec.model.live.b r5 = r2.next();
        com.bytedance.android.ec.model.live.b r6 = (com.bytedance.android.ec.model.live.b) r3.next();
        String r7 = r6.r();
        r6.u(r5.r());
        if ((!Intrinsics.areEqual(r6, r5)) == true) goto L18;
        r6.u(r7);
        goto L13
    L18:
        r6.u(r7);
    L20:
        boolean r4 = true;
    L22:
        if (r4 == true) goto L57;
        if (r12 == false) goto L57;
        ECCustomizedElementView.a r8 = r10.getAnimatorState();
        ECCustomizedElementView.a.b r13 = ECCustomizedElementView.a.b.a;
        if (Intrinsics.areEqual(r8, r13) == false) goto L28;
        r9.post(new e(r9, r11, r12, r10));
        return;
    L28:
        ECPromotionListFooterView$bindOrReplace$2$2 r14 = ECPromotionListFooterView$bindOrReplace$2$2.INSTANCE;
        ECPromotionListFooterView$bindOrReplace$2$3 r15 = ECPromotionListFooterView$bindOrReplace$2$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.isEmpty() == false) goto L31;
        return;
    L31:
        if (Intrinsics.areEqual(r10.i, r13) == true) goto L73;
        ArrayList r16 = new ArrayList(r11.size());
        List<com.bytedance.android.ec.model.live.b> r17 = r10.a;
        if (r17 == null) goto L53;
        Iterator<T> r18 = r17.iterator();
    L37:
        if (r18.hasNext() == false) goto L48;
        com.bytedance.android.ec.model.live.b r19 = (com.bytedance.android.ec.model.live.b) r18.next();
        if (r1 < r11.size()) goto L42;
        r16.add(new Triple(Integer.valueOf(r1), Boolean.TRUE, null));
    L46:
        r1 = r1 + 1;
        goto L37
    L42:
        if ((!Intrinsics.areEqual(r19, (com.bytedance.android.ec.model.live.b) ListProtector.get(r11, r1))) == false) goto L46;
        View r20 = r10.j((com.bytedance.android.ec.model.live.b) ListProtector.get(r11, r1));
        if (r20 == null) goto L46;
        r16.add(new Triple(Integer.valueOf(r1), Boolean.TRUE, r20));
    L48:
        if (r1 >= r11.size()) goto L53;
        View r21 = r10.j((com.bytedance.android.ec.model.live.b) ListProtector.get(r11, r1));
        if (r21 == null) goto L52;
        r16.add(new Triple(Integer.valueOf(r1), Boolean.FALSE, r21));
    L52:
        r1 = r1 + 1;
    L53:
        d r22 = new d(r10, r16);
        if (((Unit) UtilityKotlinExtentionsKt.f(r14, r15, new ECCustomizedElementView$replaceIfChange$2(r10, r16, r22))) != null) goto L56;
        r10.i = ECCustomizedElementView.a.b.a;
        r22.run();
        r10.i = ECCustomizedElementView.a.C0070a.a;
        Unit r23 = Unit.INSTANCE;
    L56:
        r10.a = r11;
        return;
    L73:
        return;
    L21:
        r4 = false;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r10, r11);
        if (ECLiveABUtils.INSTANCE.getECOM_LIVE_FIX_PROMOTION_FOOTER_VIEW_BG_SIZE() == false) goto L5;
        return;
    L5:
        int r12 = getLeftContent().getWidth();
        int r13 = getRightContent().getWidth();
        boolean r14 = false;
        boolean r15 = true;
        if (getLeftContent().getVisibility() != 0) goto L8;
        boolean r16 = true;
    L10:
        if (getRightContent().getVisibility() != 0) goto L12;
        boolean r0 = true;
    L13:
        if (r16 == true) goto L16;
        if (r0 == true) goto L16;
        return;
    L16:
        int r1 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r2 = getWidth() - UtilityKotlinExtentionsKt.d(32);
        float r3 = r2;
        xi2.j.a r4 = this.m;
        if (r4 == null) goto L19;
        float r5 = r4.b();
    L20:
        int r6 = (int) (r3 * r5);
        ViewGroup.LayoutParams r17 = getBackground().getLayoutParams();
        if (r17 != null) goto L23;
    L27:
        if (r1 > 0) goto L29;
        return;
    L29:
        if ((r12 + r13) <= r1) goto L53;
        if (r0 == false) goto L39;
        if (r13 <= 0) goto L39;
        if (getRightContent().getChildCount() <= 0) goto L39;
        int r18 = Z5(r13, r1 - r12, getRightContent());
        if (r18 == r13) goto L38;
        r14 = true;
    L38:
        Unit r19 = Unit.INSTANCE;
        r13 = r18;
    L39:
        if (r16 == false) goto L48;
        if (r12 <= 0) goto L48;
        if (getLeftContent().getChildCount() <= 0) goto L48;
        if (Z5(r12, r1 - r13, getLeftContent()) != r12) goto L47;
        r15 = r14;
    L47:
        r14 = r15;
    L48:
        if (r14 == false) goto L52;
        requestLayout();
        return;
    L52:
        return;
    L53:
        return;
    L23:
        if (r17.width == r2) goto L25;
    L26:
        r17.width = r2;
        r17.height = r6;
        requestLayout();
        goto L27
    L25:
        if (r17.height == r6) goto L27;
    L19:
        r5 = 1.0f;
        goto L20
    L12:
        r0 = false;
        goto L13
    L8:
        r16 = false;
        goto L10
    }
}
