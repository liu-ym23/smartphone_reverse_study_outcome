package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.AutoResizePriceContainer;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.CommonGirdleStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionIPActivity;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionSubsidizedActivity;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.shopping.anchorv3.activities.view.AbsActivitiesBarView;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.android.shopping.widget.PriceView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/ActivityBarShopLayout;", "Lcom/bytedance/android/shopping/anchorv3/activities/view/AbsActivitiesBarView;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "getSecKillDate", "getPreSaleDate", "getAppointDate", "Lcom/bytedance/android/shopping/anchorv3/activities/vo/ActivityVO;", "activityVO", "", "setIPActivity", "setCommonGirdleLayout", "text", "setTagText", "setSubsidizedActivity", "", "getLayout", "setPrice", "Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "specDetail", "setSpecPrice", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityBarShopLayout extends AbsActivitiesBarView implements com.bytedance.android.shopping.feed.view.c {
    public Map<Integer, View> e;
    public c2 f;
    public PromotionProductStruct g;
    public View h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ActivityBarShopLayout a;

        public b(ActivityBarShopLayout r1) {
            this.a = r1;
        }

        public final void a() {
            float r0 = ((UIUtils.getScreenWidth(this.a.g(2131388481).getContext()) - ((LinearLayout) this.a.g(2131378848)).getMeasuredWidth()) - ((TextView) this.a.g(2131391140)).getMeasuredWidth()) - UIUtils.dip2Px(this.a.g(2131388481).getContext(), 40.0f);
            this.a.g(2131367778).setIsMeasureChildFullWidth(true);
            this.a.g(2131367778).setMaxWidth((int) r0);
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

    public static final class c implements Runnable {
        public final /* synthetic */ ActivityBarShopLayout a;

        public c(ActivityBarShopLayout r1) {
            this.a = r1;
        }

        public final void a() {
            PriceView r0 = this.a.g(2131388481);
            if (r0 == null) goto L5;
            Context r1 = r0.getContext();
        L6:
            float r2 = ((UIUtils.getScreenWidth(r1) - ((LinearLayout) this.a.g(2131378848)).getMeasuredWidth()) - ((TextView) this.a.g(2131391140)).getMeasuredWidth()) - UIUtils.dip2Px(this.a.g(2131388481).getContext(), 40.0f);
            AutoResizePriceContainer r3 = this.a.g(2131367778);
            if (r3 == null) goto L9;
            r3.setIsMeasureChildFullWidth(true);
        L9:
            AutoResizePriceContainer r4 = this.a.g(2131367778);
            if (r4 == null) goto L13;
            r4.setMaxWidth((int) r2);
            return;
        L13:
            return;
        L5:
            r1 = null;
            goto L6
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

    static {
    }

    public ActivityBarShopLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ActivityBarShopLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public int getLayout() {
        return 2131560627;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getAppointDate() {
        int r1 = g1.a;
        return new SimpleDateFormat(g1.a.c(getContext(), 2131895756, new Object[0]), Locale.getDefault()).format(Long.valueOf(getMEndTime() * ((long) 1000)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getPreSaleDate() {
        int r1 = g1.a;
        return new SimpleDateFormat(g1.a.c(getContext(), 2131895849, new Object[0]), Locale.getDefault()).format(Long.valueOf(getMEndTime() * ((long) 1000)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getSecKillDate() {
        int r1 = g1.a;
        return new SimpleDateFormat(g1.a.c(getContext(), 2131895881, new Object[0]), Locale.getDefault()).format(Long.valueOf(getMEndTime() * ((long) 1000)));
    }

    private final void setCommonGirdleLayout(ActivityVO r11) {
        if (r11.getCommonGirdleStruct() != null) goto L5;
        return;
    L5:
        CommonGirdleStruct r0 = r11.getCommonGirdleStruct();
        long r1 = 0;
        if (r0 == null) goto L10;
        Long r2 = r0.getServerTime();
        if (r2 == null) goto L10;
        long r3 = r2.longValue();
    L11:
        d(r3, r11.getEndTime());
        CommonGirdleStruct r4 = r11.getCommonGirdleStruct();
        if (r4 == null) goto L16;
        ECUrlModel r5 = r4.getBackground();
        if (r5 == null) goto L16;
        g(2131362696).setVisibility(0);
        y.a(g(2131362696), r5);
    L17:
        CommonGirdleStruct r6 = r11.getCommonGirdleStruct();
        String r7 = null;
        if (r6 == null) goto L29;
        ECUrlModel r8 = r6.getRightBackground();
        if (r8 == null) goto L29;
        g(2131362681).setVisibility(0);
        SimpleDraweeView r9 = g(2131362681);
        ViewGroup.LayoutParams r10 = g(2131362681).getLayoutParams();
        if ((r10 instanceof RelativeLayout.LayoutParams) == true) goto L24;
        r10 = null;
    L24:
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r10;
        if (r12 == null) goto L27;
        r12.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8.getWidth()));
        r12.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r8.getHeight()));
        Unit r13 = Unit.INSTANCE;
    L28:
        r9.setLayoutParams(r12);
        y.a(g(2131362681), r8);
    L30:
        CommonGirdleStruct r14 = r11.getCommonGirdleStruct();
        if (r14 == null) goto L33;
        String r15 = r14.getHeaderText();
    L34:
        if (r15 == null) goto L36;
        setTagText(r15);
    L40:
        CommonGirdleStruct r16 = r11.getCommonGirdleStruct();
        if (r16 == null) goto L53;
        Long r17 = r16.getEndTime();
        if (r17 == null) goto L53;
        long r18 = r17.longValue();
        CommonGirdleStruct r19 = r11.getCommonGirdleStruct();
        if (r19 == null) goto L50;
        Long r110 = r19.getServerTime();
        if (r110 == null) goto L50;
        r1 = r110.longValue();
    L50:
        if (r18 <= r1) goto L52;
        ((LinearLayout) g(2131378848)).setVisibility(0);
        return;
    L52:
        ((LinearLayout) g(2131378848)).setVisibility(8);
        return;
    L53:
        ((LinearLayout) g(2131378848)).setVisibility(8);
        return;
    L36:
        CommonGirdleStruct r20 = r11.getCommonGirdleStruct();
        if (r20 == null) goto L39;
        r7 = r20.getEffectivePriceDesc();
    L39:
        setTagText(r7);
        goto L40
    L33:
        r15 = null;
        goto L34
    L27:
        r12 = null;
    L29:
        g(2131362681).setVisibility(8);
    L16:
        g(2131362696).setVisibility(8);
    L10:
        r3 = 0;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setIPActivity(ActivityVO r15) {
        Long r0 = null;
        String r1 = null;
        if (r15 == null) goto L5;
        PromotionIPActivity r2 = r15.getIpActivityInfo();
    L7:
        if (r2 != null) goto L9;
    L65:
        if (r15 == null) goto L67;
        CommonGirdleStruct r3 = r15.getCommonGirdleStruct();
    L68:
        if (r3 == null) goto L77;
        c2 r4 = this.f;
        if (r4 != null) goto L76;
        int r5 = c2.h;
        Context r6 = getContext();
        TimeUnit r7 = TimeUnit.SECONDS;
        if (r15 == null) goto L75;
        r0 = Long.valueOf(r15.getEndTime());
    L75:
        r4 = c2.a.a(r6, r7.toMillis(r0.longValue() - (System.currentTimeMillis() / 1000)), false);
    L76:
        h(r15, r4);
    L78:
        g(2131362699).setVisibility(8);
        return;
    L77:
        g(2131362696).setVisibility(8);
        g(2131362697).setVisibility(8);
        ((TextView) g(2131362719)).setVisibility(8);
        goto L78
    L67:
        r3 = null;
        goto L68
    L9:
        if (r15.getActivityType() == 1) goto L11;
    L18:
        g(2131362696).setVisibility(0);
        ((TextView) g(2131362719)).setVisibility(0);
        g(2131384705).setBackgroundResource(2131106784);
        ((LinearLayout) g(2131378595)).setBackgroundResource(2131106784);
        ((LinearLayout) g(2131378595)).setPadding(0, 0, 0, 0);
        ((TextView) g(2131391366)).setVisibility(8);
        g(2131369185).setVisibility(0);
        TextView r8 = (TextView) g(2131362544);
        int r10 = g1.a;
        r8.setTextColor(g1.a.a(getContext(), 2131101185));
        i(r15);
        y.d(g(2131362696), r2.getIpBeltUrl());
        if (r15.getActivityType() == 3) goto L30;
        g(2131362697).setVisibility(0);
        ECUrlModel r9 = r2.getIpLogoUrl();
        if (r9 == null) goto L29;
        ViewGroup.LayoutParams r11 = g(2131362697).getLayoutParams();
        if ((r11 instanceof LinearLayout.LayoutParams) == true) goto L25;
        r11 = null;
    L25:
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r11;
        if (r12 == null) goto L28;
        r12.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r9.getWidth()));
        r12.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r9.getHeight()));
        r12.bottomMargin = com.bytedance.android.shopping.extensions.b.b(4);
        g(2131362697).setLayoutParams(r12);
    L28:
        y.a(g(2131362697), r2.getIpLogoUrl());
    L29:
        g(2131362699).setVisibility(8);
    L39:
        int r13 = r15.getActivityType();
        if (r13 == 1) goto L57;
        if (r13 == 2) goto L55;
        if (r13 != 3) goto L45;
        ((TextView) g(2131390105)).setText(getContext().getString(2131914063));
        ((ImageView) g(2131375968)).setVisibility(0);
        ((ImageView) g(2131375968)).setImageResource(2131233345);
        ((LinearLayout) g(2131378849)).setVisibility(8);
    L60:
        ((TextView) g(2131390105)).setTextColor(g1.a.a(getContext(), 2131101865));
        c2 r14 = this.f;
        if (r14 != null) goto L64;
        int r16 = c2.h;
        r14 = c2.a.a(getContext(), TimeUnit.SECONDS.toMillis(r15.getEndTime() - (System.currentTimeMillis() / 1000)), false);
    L64:
        h(r15, r14);
        return;
    L45:
        if (r13 == 6) goto L53;
        ((LinearLayout) g(2131378609)).setVisibility(8);
        ((LinearLayout) g(2131378848)).setVisibility(0);
        ((TextView) g(2131391140)).setVisibility(8);
        CommonGirdleStruct r17 = r15.getCommonGirdleStruct();
        if (r17 == null) goto L49;
        r1 = r17.getHeaderText();
    L49:
        if (r1 == null) goto L51;
        ((TextView) g(2131390105)).setText(r1);
    L52:
        ((ImageView) g(2131375968)).setVisibility(8);
        goto L60
    L51:
        ((TextView) g(2131390105)).setText(r2.getIpSlogan());
        goto L52
    L53:
        ((TextView) g(2131390105)).setText(getContext().getString(2131895844));
        ((ImageView) g(2131375968)).setVisibility(8);
        goto L60
    L55:
        ((TextView) g(2131390105)).setText(getContext().getString(2131914066));
        ((ImageView) g(2131375968)).setVisibility(0);
        ((ImageView) g(2131375968)).setImageResource(2131233368);
        goto L60
    L57:
        if (r15.isOnActivity() == true) goto L59;
        ((TextView) g(2131390105)).setText(r2.getIpSlogan());
        ((ImageView) g(2131375968)).setVisibility(8);
        goto L60
    L59:
        ((TextView) g(2131390105)).setText(r15.getTitle());
        ((ImageView) g(2131375968)).setVisibility(0);
        ((ImageView) g(2131375968)).setImageResource(2131233369);
        goto L60
    L30:
        g(2131362697).setVisibility(8);
        g(2131362699).setVisibility(0);
        ECUrlModel r18 = r2.getIpLogoUrl();
        if (r18 == null) goto L39;
        ViewGroup.LayoutParams r19 = g(2131362699).getLayoutParams();
        if ((r19 instanceof LinearLayout.LayoutParams) == true) goto L35;
        r19 = null;
    L35:
        LinearLayout.LayoutParams r20 = (LinearLayout.LayoutParams) r19;
        if (r20 == null) goto L38;
        r20.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r18.getWidth()));
        r20.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r18.getHeight()));
        g(2131362699).setLayoutParams(r20);
    L38:
        y.a(g(2131362699), r2.getIpLogoUrl());
        goto L39
    L11:
        if (r15.isOnActivity() == true) goto L18;
        PromotionProductStruct r110 = this.g;
        if (r110 == null) goto L18;
        PromotionProductBaseStruct r111 = r110.getBaseInfo();
        if (r111 == null) goto L18;
        if (r111.isSoldOut() == true) goto L65;
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setSubsidizedActivity(ActivityVO r11) {
        PromotionSubsidizedActivity r0 = r11.getSubsidizedActivity();
        if (r0 == null) goto L116;
        ViewGroup.LayoutParams r3 = g(2131384705).getLayoutParams();
        ConstraintLayout.LayoutParams r5 = null;
        if ((r3 instanceof FrameLayout.LayoutParams) == true) goto L7;
        r3 = null;
    L7:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        if (r4 == null) goto L10;
        r4.height = -2;
        g(2131384705).setLayoutParams(r4);
    L10:
        ((LinearLayout) g(2131378848)).setVisibility(8);
        ((LinearLayout) g(2131378595)).setVisibility(8);
        ((TextView) g(2131362544)).setVisibility(8);
        g(2131367778).setVisibility(8);
        View r2 = this.h;
        if (r2 != null) goto L17;
        ViewStub r6 = (ViewStub) g(2131370670);
        if (r6 == null) goto L15;
        View r7 = r6.inflate();
    L16:
        this.h = r7;
    L18:
        View r8 = this.h;
        if (r8 == null) goto L21;
        View r9 = r8.findViewById(2131362690);
    L22:
        View r10 = this.h;
        if (r10 == null) goto L25;
        TextView r12 = (TextView) r10.findViewById(2131362687);
    L26:
        if (r9 == null) goto L28;
        r9.setVisibility(0);
    L28:
        if (r12 == null) goto L31;
        r12.setVisibility(0);
    L31:
        if (r12 == null) goto L33;
        int r13 = g1.a;
        Context r14 = getContext();
        int r15 = k0.a;
        r12.setText(g1.a.c(r14, 2131913980, new Object[]{k0.a(r11.getSales())}));
    L33:
        View r16 = this.h;
        if (r16 == null) goto L43;
        SimpleDraweeView r17 = r16.findViewById(2131362712);
        if (r17 == null) goto L43;
        ECUrlModel r18 = r0.getLogoBackground();
        if (r18 == null) goto L43;
        ViewGroup.LayoutParams r19 = r17.getLayoutParams();
        if (r19 == null) goto L42;
        r19.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r18.getWidth()));
        r19.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r18.getHeight()));
        r17.setLayoutParams(r19);
    L42:
        y.a(r17, r18);
    L43:
        View r110 = this.h;
        if (r110 == null) goto L48;
        SimpleDraweeView r111 = r110.findViewById(2131362691);
        if (r111 == null) goto L48;
        y.a(r111, r0.getBeltBackground());
    L48:
        View r112 = this.h;
        if (r112 == null) goto L58;
        SimpleDraweeView r113 = r112.findViewById(2131362689);
        if (r113 == null) goto L58;
        ECUrlModel r20 = r0.getSellPriceIcon();
        if (r20 == null) goto L57;
        ViewGroup.LayoutParams r21 = r113.getLayoutParams();
        if (r21 == null) goto L57;
        r21.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r20.getWidth()));
        r21.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r20.getHeight()));
        r113.setLayoutParams(r21);
    L57:
        y.a(r113, r0.getSellPriceIcon());
    L58:
        View r114 = this.h;
        if (r114 == null) goto L95;
        com.bytedance.android.ec.core.widget.PriceView r115 = r114.findViewById(2131362688);
        if (r115 == null) goto L95;
        int r22 = com.bytedance.android.shopping.utils.g.a;
        Long r23 = r0.getSellPrice();
        if (r23 == null) goto L65;
        long r24 = r23.longValue();
    L66:
        r115.setPriceText(com.bytedance.android.shopping.utils.g.d(r24));
        if (r0.getSellPrice() != null) goto L69;
    L73:
        ECUrlModel r25 = r0.getLogoBackground();
        if (r25 == null) goto L95;
        int r26 = r25.getWidth();
        Long r27 = r0.getSellPrice();
        if (r27 != null) goto L78;
    L93:
        r115.setMaxWidth(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r26)) - com.bytedance.android.shopping.extensions.b.b(18));
        goto L95
    L78:
        if ((r27.longValue() / ((long) 100)) <= 10000) goto L86;
        ConstraintLayout.LayoutParams r28 = r115.getLayoutParams();
        if ((r28 instanceof ConstraintLayout.LayoutParams) == false) goto L83;
        r5 = r28;
    L83:
        ConstraintLayout.LayoutParams r29 = r5;
        if (r29 == null) goto L93;
        ((ViewGroup.MarginLayoutParams) r29).leftMargin = 0;
        r29.startToStart = 0;
        r29.endToEnd = 0;
        goto L93
    L86:
        ConstraintLayout.LayoutParams r30 = r115.getLayoutParams();
        if ((r30 instanceof ConstraintLayout.LayoutParams) == false) goto L90;
        r5 = r30;
    L90:
        ConstraintLayout.LayoutParams r31 = r5;
        if (r31 == null) goto L93;
        ((ViewGroup.MarginLayoutParams) r31).leftMargin = com.bytedance.android.shopping.extensions.b.b(16);
        r31.startToStart = 0;
        r31.endToEnd = -1;
        goto L93
    L69:
        if (r0.getMaxSellPrice() == null) goto L73;
        if ((true ^ Intrinsics.areEqual(r0.getMaxSellPrice(), r0.getSellPrice())) == false) goto L73;
        r115.setExtraText(getResources().getString(2131895957));
        goto L73
    L65:
        r24 = 0;
    L95:
        if (k.c(r0.getSubsidizedPriceDesc()) == false) goto L106;
        View r116 = this.h;
        if (r116 == null) goto L101;
        TextView r117 = (TextView) r116.findViewById(2131362739);
        if (r117 == null) goto L101;
        r117.setText(r0.getSubsidizedPriceDesc());
    L101:
        View r118 = this.h;
        if (r118 == null) goto L111;
        TextView r119 = (TextView) r118.findViewById(2131362739);
        if (r119 == null) goto L111;
        r119.setVisibility(0);
    L111:
        View r120 = this.h;
        if (r120 == null) goto L120;
        TextView r121 = (TextView) r120.findViewById(2131362722);
        if (r121 == null) goto L121;
        r121.setText(r0.getMarketPriceDesc());
        return;
    L121:
        return;
    L120:
        return;
    L106:
        View r122 = this.h;
        if (r122 == null) goto L111;
        TextView r123 = (TextView) r122.findViewById(2131362739);
        if (r123 == null) goto L111;
        r123.setVisibility(8);
        goto L111
    L25:
        r12 = null;
        goto L26
    L21:
        r9 = null;
        goto L22
    L15:
        r7 = null;
        goto L16
    L17:
        r2.setVisibility(0);
        goto L18
    L116:
        View r124 = this.h;
        if (r124 == null) goto L123;
        r124.setVisibility(8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setTagText(String r5) {
        if (r5 == null) goto L5;
        ((TextView) g(2131390105)).setText(r5);
        TextView r6 = (TextView) g(2131390105);
        int r2 = g1.a;
        r6.setTextColor(g1.a.a(getContext(), 2131101198));
        ((LinearLayout) g(2131378595)).setBackgroundResource(2131106784);
        ((LinearLayout) g(2131378595)).setPadding(0, 0, 0, 0);
        ((ImageView) g(2131375968)).setVisibility(8);
        ((LinearLayout) g(2131378595)).setVisibility(0);
        return;
    L5:
        ((LinearLayout) g(2131378595)).setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(c2 r15) {
        Intrinsics.checkNotNullParameter(r15, "uiCountDown");
        this.f = r15;
        ActivityVO r0 = getMActivityVO();
        if (r0 != null) goto L5;
    L7:
        ActivityVO r1 = getMActivityVO();
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.getActivityType() != 1) goto L12;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L21;
        r1 = null;
    L21:
        if (r1 != null) goto L23;
        return;
    L23:
        if (r1.isOnActivity() == false) goto L25;
        String r10 = "";
        if (r15.a <= 0) goto L42;
        TextView r5 = (TextView) g(2131391366);
        ActivityVO r9 = getMActivityVO();
        if (r9 != null) goto L33;
    L35:
        int r11 = g1.a;
        r10 = g1.a.c(getContext(), 2131895884, new Object[]{Integer.valueOf(r15.a)});
    L36:
        r5.setText(r10);
        TextView r6 = (TextView) g(2131362544);
        int r12 = g1.a;
        Context r13 = getContext();
        int r14 = k0.a;
        r6.setText(g1.a.c(r13, 2131913980, new Object[]{k0.a(r1.getSales())}));
        ((LinearLayout) g(2131378849)).setVisibility(0);
        ActivityVO r2 = getMActivityVO();
        if (r2 != null) goto L39;
    L41:
        ((TextView) g(2131390757)).setText(r15.c);
        ((TextView) g(2131390954)).setText(r15.d);
        ((TextView) g(2131391365)).setText(r15.e);
        return;
    L39:
        if (r2.getActivityType() != 14) goto L41;
        ((TextView) g(2131362719)).setText(g1.a.c(getContext(), 2131914062, new Object[]{Integer.valueOf(r15.a)}));
        ((TextView) g(2131362719)).setVisibility(0);
        goto L41
    L33:
        if (r9.getActivityType() != 14) goto L35;
    L42:
        TextView r7 = (TextView) g(2131391366);
        ActivityVO r16 = getMActivityVO();
        if (r16 != null) goto L45;
    L47:
        r10 = th.a.e(getContext(), true).getString(2131895883);
    L48:
        r7.setText(r10);
        TextView r8 = (TextView) g(2131362544);
        int r17 = g1.a;
        Context r18 = getContext();
        int r19 = k0.a;
        r8.setText(g1.a.c(r18, 2131913980, new Object[]{k0.a(r1.getSales())}));
        ((LinearLayout) g(2131378849)).setVisibility(0);
        ((TextView) g(2131390757)).setText(r15.c);
        ((TextView) g(2131390954)).setText(r15.d);
        ((TextView) g(2131391365)).setText(r15.e);
        return;
    L45:
        if (r16.getActivityType() != 14) goto L47;
    L25:
        if (r15.a <= 0) goto L27;
        TextView r110 = (TextView) g(2131391366);
        int r3 = g1.a;
        r110.setText(g1.a.c(getContext(), 2131895885, new Object[]{getSecKillDate()}));
        ((TextView) g(2131391366)).setVisibility(0);
        ((LinearLayout) g(2131378849)).setVisibility(8);
        return;
    L27:
        TextView r20 = (TextView) g(2131391366);
        int r21 = g1.a;
        r20.setText(g1.a.c(getContext(), 2131895888, new Object[0]));
        ((LinearLayout) g(2131378849)).setVisibility(0);
        ((TextView) g(2131390757)).setText(r15.c);
        ((TextView) g(2131390954)).setText(r15.d);
        ((TextView) g(2131391365)).setText(r15.e);
        return;
    L12:
        if (r1.getActivityType() == 6) goto L17;
        if (r1.getActivityType() == 14) goto L17;
        r4 = false;
        goto L18
    L5:
        if (r0.getIpActivityInfo() == null) goto L7;
        h(getMActivityVO(), r15);
        ((TextView) g(2131390757)).setText(r15.c);
        ((TextView) g(2131390954)).setText(r15.d);
        ((TextView) g(2131391365)).setText(r15.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View g(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.e.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(ActivityVO r7) {
        int r0 = r7.getSales();
        if (r7.getActivityType() != 3) goto L5;
        r0 = r7.getStickSales();
    L5:
        TextView r1 = (TextView) g(2131362544);
        int r2 = g1.a;
        int r4 = 0;
        r1.setText(g1.a.c(getContext(), 2131913980, new Object[]{k0.a(r0)}));
        TextView r8 = (TextView) g(2131362544);
        PromotionProductStruct r3 = this.g;
        if (r3 == null) goto L10;
        PromotionProductBaseStruct r5 = r3.getBaseInfo();
        if (r5 == null) goto L10;
        Boolean r6 = r5.getHideSales();
    L12:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L14;
        r4 = 8;
    L14:
        r8.setVisibility(r4);
        return;
    L10:
        r6 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPrice(ActivityVO r19) {
        Intrinsics.checkNotNullParameter(r19, "activityVO");
        Long r1 = r19.getMinPrice();
        Long r3 = r19.getMaxPrice();
        if (r1 == null) goto L96;
        boolean r8 = false;
        g(2131388481).setVisibility(0);
        PriceView r7 = g(2131388481);
        int r9 = com.bytedance.android.shopping.utils.g.a;
        r7.setPriceText(com.bytedance.android.shopping.utils.g.d(r1.longValue()));
        String r14 = null;
        if (r1.longValue() > 0) goto L7;
    L10:
        g(2131388481).setExtraText(null);
    L11:
        g(2131367778).post(new b(this));
        int r4 = r19.getActivityType();
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L15;
        int r5 = getContext().getResources().getColor(2131101223);
    L20:
        int r10 = r19.getActivityType();
        if (r10 == 1) goto L25;
        if (r10 != 2) goto L25;
        int r11 = 2131233357;
    L27:
        if (r19.getIpActivityInfo() == null) goto L29;
        int r6 = g1.a;
        r5 = g1.a.a(getContext(), 2131105908);
        r11 = 2131233355;
    L29:
        g(2131390512).setPriceTextColor(r5);
        g(2131390512).setExtraTextColor(r5);
        ((TextView) g(2131390513)).setTextColor(r5);
        int r12 = com.bytedance.android.shopping.anchorv3.utils.y.a;
        if (com.bytedance.android.shopping.anchorv3.utils.y.u(r1, r19.getDiscountPrice(), null) == false) goto L40;
        if (r19.isOnActivity() == false) goto L34;
    L41:
        g(2131367757).setVisibility(0);
        g(2131367757).setBackgroundResource(2131234349);
        if (com.bytedance.android.shopping.anchorv3.utils.y.u(r1, r19.getDiscountPrice(), null) == false) goto L45;
        PromotionDiscountPrice r2 = r19.getDiscountPrice();
    L47:
        ((TextView) g(2131390513)).setText(r2.getHeader());
        ((ImageView) g(2131376180)).setImageResource(r11);
        Long r13 = r2.getMinPrice();
        if (r13 == null) goto L50;
        long r16 = r13.longValue();
    L51:
        String r15 = com.bytedance.android.shopping.utils.g.d(r16);
        g(2131390512).setPriceText(r15);
        StringBuilder r17 = new StringBuilder();
        String r18 = r2.getHeader();
        if (r18 != null) goto L54;
    L55:
        r8 = true;
    L56:
        if (r8 == true) goto L59;
        r18 = null;
    L59:
        if (r18 == null) goto L61;
        r17.append(r18);
    L61:
        r17.append(r15);
        r17.append(th.a.g(getContext(), 2131913847));
        if (com.bytedance.android.shopping.anchorv3.utils.y.v(r2) == false) goto L64;
        g(2131390512).setExtraText(getResources().getString(2131895957));
        r17.append(th.a.g(getContext(), 2131895957));
    L65:
        g(2131380998).setVisibility(8);
        g(2131367757).setFocusable(true);
        ((TextView) g(2131390513)).setImportantForAccessibility(2);
        g(2131390512).setImportantForAccessibility(2);
        g(2131367757).setContentDescription(r17.toString());
        return;
    L64:
        g(2131390512).setExtraText(null);
        goto L65
    L54:
        if (StringsKt.isBlank(r18) == false) goto L56;
    L50:
        r16 = 0;
        goto L51
    L45:
        if (com.bytedance.android.shopping.anchorv3.utils.y.w(r1, r19.getGroupDiscountPrice()) == false) goto L66;
        r2 = r19.getGroupDiscountPrice();
        goto L47
    L66:
        return;
    L34:
        if (r19.isOnActivity() == true) goto L40;
        if (r19.getActivityType() == 1) goto L41;
        if (r19.getActivityType() == 14) goto L41;
    L40:
        if (com.bytedance.android.shopping.anchorv3.utils.y.w(r1, r19.getGroupDiscountPrice()) == true) goto L41;
        g(2131367757).setVisibility(8);
        g(2131367757).setContentDescription(null);
        Long r20 = r19.getMarketPrice();
        if (Intrinsics.areEqual(r19.getActivityName(), "seckill_appointment") == false) goto L78;
        g(2131380998).setVisibility(0);
        PriceView r21 = g(2131380998);
        PromotionProductStruct r22 = this.g;
        if (r22 == null) goto L76;
        PromotionProductPriceStruct r23 = r22.getProductPrice();
        if (r23 == null) goto L76;
        Long r24 = r23.getMinPrice();
        if (r24 == null) goto L76;
        String r25 = com.bytedance.android.shopping.utils.g.d(r24.longValue());
    L77:
        r21.setPriceText(r25);
        g(2131380998).setExtraText(null);
    L84:
        CommonGirdleStruct r26 = r19.getCommonGirdleStruct();
        if (r26 == null) goto L87;
        String r27 = r26.getPriceDesc();
    L89:
        if (k.c(r27) == false) goto L94;
        ((LinearLayout) g(2131362657)).setVisibility(0);
        TextView r28 = (TextView) g(2131362656);
        CommonGirdleStruct r29 = r19.getCommonGirdleStruct();
        if (r29 == null) goto L93;
        r14 = r29.getPriceDesc();
    L93:
        r28.setText(r14);
        return;
    L94:
        ((LinearLayout) g(2131362657)).setVisibility(8);
        return;
    L87:
        r27 = null;
    L76:
        r25 = null;
        goto L77
    L78:
        if (r20 == null) goto L84;
        if ((!Intrinsics.areEqual(r19.getMinPrice(), r19.getMarketPrice())) == false) goto L84;
        if (r20.longValue() <= 0) goto L84;
        g(2131380998).setVisibility(0);
        g(2131380998).setPriceText(com.bytedance.android.shopping.utils.g.d(r20.longValue()));
        g(2131380998).setExtraText(null);
    L25:
        r11 = 2131233358;
        goto L27
    L15:
        if (r4 == 7) goto L17;
        r5 = getContext().getResources().getColor(2131101229);
        goto L20
    L17:
        int r30 = g1.a;
        r5 = g1.a.a(getContext(), 2131105908);
        goto L20
    L19:
        r5 = getContext().getResources().getColor(2131101229);
        goto L20
    L7:
        if ((!Intrinsics.areEqual(r3, r1)) == false) goto L10;
        if (r3 == null) goto L10;
        g(2131388481).setExtraText(getResources().getString(2131895957));
        goto L11
    L96:
        g(2131367778).setVisibility(8);
    }

    public final void setSpecPrice(SpecDetail r11) {
        if (r11 == null) goto L60;
        Long r0 = r11.getEffectivePrice();
        if (r0 == null) goto L6;
        long r3 = r0.longValue();
    L8:
        if (r3 <= 0) goto L65;
        Long r1 = r11.getEffectivePrice();
        if (r1 == null) goto L13;
        long r4 = r1.longValue();
    L14:
        Long r2 = r11.getMarketPrice();
        if (r2 == null) goto L17;
        long r5 = r2.longValue();
    L18:
        Long r12 = r11.getDiscountPrice();
        if (r12 == null) goto L21;
        long r7 = r12.longValue();
    L22:
        g(2131388481).setVisibility(0);
        g(2131388481).setPriceText(com.bytedance.android.shopping.utils.g.d(r4));
        g(2131388481).setExtraText(null);
        AutoResizePriceContainer r13 = g(2131367778);
        if (r13 == null) goto L25;
        r13.post(new c(this));
    L25:
        View r6 = g(2131367757);
        if (r6 == null) goto L28;
        Integer r8 = Integer.valueOf(r6.getVisibility());
    L30:
        if (r8.intValue() == 0) goto L32;
    L42:
        PriceView r9 = g(2131380998);
        if (r9 == null) goto L45;
        Integer r10 = Integer.valueOf(r9.getVisibility());
    L47:
        if (r10.intValue() == 0) goto L49;
        return;
    L49:
        if (r5 <= 0) goto L56;
        PriceView r14 = g(2131380998);
        if (r14 == null) goto L53;
        r14.setPriceText(com.bytedance.android.shopping.utils.g.d(r5));
    L53:
        PriceView r15 = g(2131380998);
        if (r15 == null) goto L62;
        r15.setExtraText(null);
        return;
    L62:
        return;
    L56:
        PriceView r16 = g(2131380998);
        if (r16 == null) goto L64;
        r16.setVisibility(8);
        return;
    L64:
        return;
    L45:
        r10 = null;
        goto L47
    L32:
        if (r7 <= 0) goto L39;
        PriceView r17 = g(2131390512);
        if (r17 == null) goto L36;
        r17.setPriceText(com.bytedance.android.shopping.utils.g.d(r7));
    L36:
        PriceView r18 = g(2131390512);
        if (r18 == null) goto L42;
        r18.setExtraText(null);
        goto L42
    L39:
        View r19 = g(2131367757);
        if (r19 == null) goto L42;
        r19.setVisibility(8);
        goto L42
    L28:
        r8 = null;
        goto L30
    L21:
        r7 = 0;
        goto L22
    L17:
        r5 = 0;
        goto L18
    L13:
        r4 = 0;
        goto L14
    L65:
        return;
    L6:
        r3 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(ActivityVO r7, c2 r8) {
        if (r7 != null) goto L4;
    L6:
        ((LinearLayout) g(2131378849)).setVisibility(0);
        if (r7 == null) goto L9;
        Integer r0 = Integer.valueOf(r7.getActivityType());
    L11:
        if (r0 == null) goto L19;
        if (r0.intValue() != 2) goto L19;
        if (r8.a <= 0) goto L39;
        TextView r9 = (TextView) g(2131362719);
        int r1 = g1.a;
        r9.setText(g1.a.c(getContext(), 2131914068, new Object[]{Integer.valueOf(r8.a)}));
        return;
    L39:
        return;
    L19:
        if (r0 != null) goto L22;
    L31:
        if (r0 != null) goto L34;
        return;
    L34:
        if (r0.intValue() == 7) goto L36;
        return;
    L36:
        if (r8.a <= 0) goto L46;
        TextView r10 = (TextView) g(2131362719);
        int r2 = g1.a;
        r10.setText(g1.a.c(getContext(), 2131914062, new Object[]{Integer.valueOf(r8.a)}));
        return;
    L46:
        return;
    L22:
        if (r0.intValue() != 1) goto L31;
        if (r7.isOnActivity() == false) goto L29;
        if (r8.a <= 0) goto L41;
        TextView r11 = (TextView) g(2131362719);
        int r3 = g1.a;
        r11.setText(g1.a.c(getContext(), 2131914071, new Object[]{Integer.valueOf(r8.a)}));
        return;
    L41:
        return;
    L29:
        if (r8.a <= 0) goto L43;
        TextView r12 = (TextView) g(2131362719);
        int r4 = g1.a;
        r12.setText(g1.a.c(getContext(), 2131914062, new Object[]{Integer.valueOf(r8.a)}));
        return;
    L43:
        return;
    L9:
        r0 = null;
        goto L11
    L4:
        if (r7.getActivityType() != 3) goto L6;
    }

    public ActivityBarShopLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = new LinkedHashMap();
    }

    public /* synthetic */ ActivityBarShopLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(ActivityVO r18, Long r19, PromotionProductStruct r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r18, "activityVO");
        View r2 = this.h;
        if (r2 == null) goto L5;
        r2.setVisibility(8);
    L5:
        this.g = r20;
        setPrice(r18);
        int r3 = r18.getActivityType();
        int r12 = 0;
        if (r3 == 1) goto L43;
        if (r3 != 2) goto L10;
        g(2131384705).setBackgroundResource(2131234348);
        g(2131384705).a(2131233342);
        ((ImageView) g(2131375968)).setImageResource(2131233344);
        ((LinearLayout) g(2131378595)).setBackgroundResource(2131234345);
        ((LinearLayout) g(2131378595)).setPadding(getContext().getResources().getDimensionPixelOffset(2131165706), getContext().getResources().getDimensionPixelOffset(2131165707), getContext().getResources().getDimensionPixelOffset(2131165706), getContext().getResources().getDimensionPixelOffset(2131165707));
        ((TextView) g(2131390105)).setText(r18.getTitle());
        TextView r4 = (TextView) g(2131390105);
        int r5 = g1.a;
        r4.setTextColor(g1.a.a(getContext(), 2131099653));
        ((LinearLayout) g(2131378609)).setVisibility(8);
        i(r18);
        g(2131369185).setVisibility(8);
        if (r18.getIpActivityInfo() != null) goto L41;
        ((TextView) g(2131391140)).setVisibility(0);
        ((TextView) g(2131391140)).setText(g1.a.c(getContext(), 2131895851, new Object[]{getPreSaleDate()}));
        ((LinearLayout) g(2131378848)).setVisibility(8);
    L105:
        if (r18.getActivityType() != 7) goto L107;
    L111:
        if (r20 == null) goto L114;
        r20.setActivityLabel(((TextView) g(2131390105)).getText().toString());
        return;
    L114:
        return;
    L107:
        if (r18.getActivityType() == 12) goto L111;
        if (r18.getActivityType() == 14) goto L111;
        setIPActivity(r18);
        goto L111
    L41:
        ((LinearLayout) g(2131378848)).setVisibility(0);
        ((TextView) g(2131391140)).setVisibility(8);
        goto L105
    L10:
        if (r3 != 3) goto L12;
        g(2131384705).setBackgroundResource(2131234346);
        g(2131384705).a(2131233339);
        g(2131384705).setBackgroundResource(2131234350);
        ((LinearLayout) g(2131378595)).setBackgroundResource(2131234345);
        ((LinearLayout) g(2131378595)).setPadding(getContext().getResources().getDimensionPixelOffset(2131165706), getContext().getResources().getDimensionPixelOffset(2131165707), getContext().getResources().getDimensionPixelOffset(2131165706), getContext().getResources().getDimensionPixelOffset(2131165707));
        ((ImageView) g(2131375968)).setImageResource(2131233338);
        ((TextView) g(2131390105)).setText(r18.getTitle());
        ((TextView) g(2131390105)).setTextColor(ColorProtector.parseColor("#00AE86"));
        ((TextView) g(2131391140)).setVisibility(8);
        ((LinearLayout) g(2131378609)).setVisibility(0);
        ((LinearLayout) g(2131378848)).setVisibility(8);
        ((TextView) g(2131362544)).setVisibility(8);
        g(2131369185).setVisibility(8);
        if (r18.getIpActivityInfo() != null) goto L28;
        ((LinearLayout) g(2131362638)).setVisibility(0);
    L29:
        TextView r6 = (TextView) g(2131390164);
        int r7 = g1.a;
        r6.setText(g1.a.c(getContext(), 2131895841, new Object[]{getAppointDate()}));
        int r8 = r18.getSales();
        if (r8 < 0) goto L33;
        r12 = r8;
    L33:
        TextView r9 = (TextView) g(2131390165);
        int r10 = k0.a;
        if (r12 <= 99999) goto L36;
        String r11 = "99999+";
    L37:
        r9.setText(r11);
        goto L105
    L36:
        r11 = String.valueOf(r12);
        goto L37
    L28:
        ((LinearLayout) g(2131362638)).setVisibility(8);
        goto L29
    L12:
        if (r3 == 6) goto L20;
        if (r3 == 7) goto L19;
        if (r3 == 12) goto L18;
        if (r3 != 14) goto L105;
        setCommonGirdleLayout(r18);
        goto L105
    L18:
        setSubsidizedActivity(r18);
        goto L105
    L19:
        setIPActivity(r18);
        goto L105
    L20:
        if (r21 == true) goto L22;
        return;
    L22:
        g(2131384705).setBackgroundResource(2131234358);
        g(2131384705).a(2131233340);
        ((LinearLayout) g(2131378595)).setBackgroundResource(2131106784);
        ((LinearLayout) g(2131378595)).setPadding(0, 0, 0, 0);
        TextView r13 = (TextView) g(2131390105);
        int r14 = g1.a;
        r13.setText(g1.a.c(getContext(), 2131895844, new Object[0]));
        ((ImageView) g(2131375968)).setVisibility(8);
        ((TextView) g(2131390105)).setTextColor(g1.a.a(getContext(), 2131101865));
        ((TextView) g(2131391140)).setVisibility(8);
        ((LinearLayout) g(2131378609)).setVisibility(8);
        ((LinearLayout) g(2131378848)).setVisibility(0);
        i(r18);
        g(2131369185).setVisibility(8);
        if (r18.isOnActivity() == false) goto L105;
        ((TextView) g(2131391366)).setText(g1.a.c(getContext(), 2131895883, new Object[0]));
        goto L105
    L43:
        if (r18.getCommonGirdleStruct() == null) goto L72;
        CommonGirdleStruct r15 = r18.getCommonGirdleStruct();
        if (r15 == null) goto L49;
        ECUrlModel r16 = r15.getBackground();
        if (r16 == null) goto L49;
        g(2131362696).setVisibility(0);
        y.a(g(2131362696), r16);
    L50:
        CommonGirdleStruct r17 = r18.getCommonGirdleStruct();
        if (r17 == null) goto L66;
        ECUrlModel r22 = r17.getRightBackground();
        if (r22 == null) goto L66;
        g(2131362697).setVisibility(0);
        SimpleDraweeView r110 = g(2131362697);
        ViewGroup.LayoutParams r111 = g(2131362697).getLayoutParams();
        if ((r111 instanceof LinearLayout.LayoutParams) == true) goto L57;
        r111 = null;
    L57:
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r111;
        if (r112 == null) goto L60;
        r112.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r22.getWidth()));
        r112.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r22.getHeight()));
        r112.bottomMargin = com.bytedance.android.shopping.extensions.b.b(0);
        Unit r23 = Unit.INSTANCE;
    L61:
        r110.setLayoutParams(r112);
        GenericDraweeView r24 = g(2131362697);
        CommonGirdleStruct r25 = r18.getCommonGirdleStruct();
        if (r25 == null) goto L64;
        ECUrlModel r26 = r25.getRightBackground();
    L65:
        y.a(r24, r26);
    L67:
        TextView r27 = (TextView) g(2131390105);
        CommonGirdleStruct r28 = r18.getCommonGirdleStruct();
        if (r28 == null) goto L70;
        String r29 = r28.getEffectivePriceDesc();
    L71:
        r27.setText(r29);
        ((TextView) g(2131391366)).setVisibility(8);
        ((TextView) g(2131362719)).setVisibility(0);
    L73:
        ((LinearLayout) g(2131378595)).setBackgroundResource(2131234345);
        ((LinearLayout) g(2131378595)).setPadding(getContext().getResources().getDimensionPixelOffset(2131165706), getContext().getResources().getDimensionPixelOffset(2131165707), getContext().getResources().getDimensionPixelOffset(2131165706), getContext().getResources().getDimensionPixelOffset(2131165707));
        ((ImageView) g(2131375968)).setImageResource(2131233343);
        ((TextView) g(2131390105)).setText(r18.getTitle());
        TextView r30 = (TextView) g(2131390105);
        int r31 = g1.a;
        r30.setTextColor(g1.a.a(getContext(), 2131100000));
        ((TextView) g(2131391140)).setVisibility(8);
        ((LinearLayout) g(2131378609)).setVisibility(8);
        LinearLayout r32 = (LinearLayout) g(2131378848);
        if (r20 == null) goto L82;
        PromotionProductBaseStruct r33 = r20.getBaseInfo();
        if (r33 == null) goto L82;
        if (r33.isSoldOut() != true) goto L82;
        if (r18.isOnActivity() == false) goto L82;
        int r34 = 8;
    L83:
        r32.setVisibility(r34);
        TextView r35 = (TextView) g(2131362544);
        Context r36 = getContext();
        int r37 = k0.a;
        r35.setText(g1.a.c(r36, 2131913980, new Object[]{k0.a(r18.getSales())}));
        TextView r38 = (TextView) g(2131362544);
        if (r20 == null) goto L88;
        PromotionProductBaseStruct r39 = r20.getBaseInfo();
        if (r39 == null) goto L88;
        Boolean r40 = r39.getHideSales();
    L90:
        if (Intrinsics.areEqual(r40, Boolean.TRUE) == false) goto L92;
        int r41 = 8;
    L93:
        r38.setVisibility(r41);
        g(2131369185).setVisibility(8);
        if (r18.isOnActivity() == true) goto L105;
        if (r20 == null) goto L101;
        PromotionProductBaseStruct r42 = r20.getBaseInfo();
        if (r42 == null) goto L101;
        if (r42.isSoldOut() != true) goto L101;
    L102:
        setVisibility(0);
        ((TextView) g(2131390105)).setText(g1.a.c(getContext(), 2131895955, new Object[0]));
    L101:
        if (r18.getIpActivityInfo() != null) goto L102;
        setVisibility(8);
        stopCountDown();
        goto L105
    L92:
        r41 = 0;
    L88:
        r40 = null;
    L82:
        r34 = 0;
        goto L83
    L70:
        r29 = null;
        goto L71
    L64:
        r26 = null;
        goto L65
    L60:
        r112 = null;
    L66:
        g(2131362697).setVisibility(8);
    L49:
        g(2131362696).setVisibility(8);
        goto L50
    L72:
        ((TextView) g(2131391366)).setVisibility(0);
        g(2131384705).setBackgroundResource(2131234347);
        g(2131384705).a(2131233341);
        goto L73
    }
}
