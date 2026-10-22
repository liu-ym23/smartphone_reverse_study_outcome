package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.activities.view.AbsActivitiesBarView;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/PresaleActivityBarLayout;", "Lcom/bytedance/android/shopping/anchorv3/activities/view/AbsActivitiesBarView;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "getLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PresaleActivityBarLayout extends AbsActivitiesBarView implements com.bytedance.android.shopping.feed.view.c {
    public Map<Integer, View> e;
    public final ArrayList<String> f;

    public PresaleActivityBarLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PresaleActivityBarLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final void c(c2 r2) {
        Intrinsics.checkNotNullParameter(r2, "uiCountDown");
    }

    public int getLayout() {
        return 2131560619;
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
    public final void onMeasure(int r6, int r7) {
        super/*android.widget.FrameLayout*/.onMeasure(r6, r7);
        int r8 = g(2131383479).getMeasuredWidth();
        int r9 = g(2131383480).getMeasuredWidth();
        int r0 = ((LinearLayout) g(2131378664)).getMeasuredWidth();
        int r2 = ((TextView) g(2131390245)).getMeasuredWidth();
        int r3 = getMeasuredWidth();
        int r4 = (((r3 - r8) - r9) - r0) - r2;
        if ((r4 - com.bytedance.android.shopping.extensions.b.b(27)) <= com.bytedance.android.shopping.extensions.b.b(8)) goto L5;
        ((TextView) g(2131390245)).setVisibility(0);
        return;
    L5:
        ((TextView) g(2131390245)).setVisibility(8);
    }

    public PresaleActivityBarLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = new LinkedHashMap();
        this.f = new ArrayList();
    }

    public /* synthetic */ PresaleActivityBarLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(ActivityVO r18, Long r19, final PromotionProductStruct r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r18, "activityVO");
        PromotionDepositPresaleActivity r2 = r18.getDepositPresaleActivity();
        if (r2 != null) goto L5;
        return;
    L5:
        this.f.clear();
        ECUrlModel r4 = r2.getBgPicture();
        if (r4 == null) goto L8;
        y.a(g(2131362654), r4);
    L8:
        String r5 = r2.getPrefix();
        if (r5 == null) goto L12;
        ((TextView) g(2131391641)).setText(r5);
        this.f.add(r5);
    L12:
        if (r19 == null) goto L24;
        long r7 = r19.longValue();
        if (r7 > 0) goto L18;
        TextView r8 = (TextView) g(2131391643);
        if (r8 == null) goto L24;
        r8.setVisibility(8);
        goto L24
    L18:
        TextView r9 = (TextView) g(2131391643);
        if (r9 == null) goto L21;
        r9.setVisibility(0);
    L21:
        TextView r10 = (TextView) g(2131391643);
        if (r10 == null) goto L24;
        int r11 = g1.a;
        r10.setText(g1.a.c(getContext(), 2131896521, new Object[]{Long.valueOf(r7)}));
    L24:
        ECUrlModel r3 = r2.getBgLogoPicture();
        if (r3 == null) goto L28;
        y.a(g(2131362655), r3);
    L28:
        if (r20 == null) goto L34;
        PromotionProductPriceStruct r12 = r20.getProductPrice();
        if (r12 == null) goto L34;
        PromotionDiscountPrice r13 = r12.getDiscountPrice();
        if (r13 == null) goto L34;
        Long r14 = r13.getMinPrice();
    L35:
        if (r20 == null) goto L39;
        PromotionProductPriceStruct r15 = r20.getProductPrice();
        if (r15 == null) goto L39;
        Long r16 = r15.getMinPrice();
    L41:
        if (r14 == null) goto L71;
        if (r16 == null) goto L71;
        if (r14.longValue() >= r16.longValue()) goto L71;
        final long r17 = r14.longValue();
        g(2131383477).C(new PresaleActivityBarLayout$updateActivity$$inlined$let$lambda$1(r17, this, r20));
        LinearLayout r22 = (LinearLayout) g(2131378664);
        if (r22 == null) goto L48;
        r22.setVisibility(0);
    L48:
        if (r20 == null) goto L55;
        PromotionProductPriceStruct r23 = r20.getProductPrice();
        if (r23 == null) goto L55;
        PromotionDiscountPrice r24 = r23.getDiscountPrice();
        if (r24 == null) goto L55;
        String r25 = r24.getHeader();
        if (r25 == null) goto L55;
    L60:
        if (r25 == null) goto L65;
        TextView r26 = (TextView) g(2131390510);
        if (r26 == null) goto L64;
        r26.setText(r25);
    L64:
        this.f.add(r25);
    L65:
        final long r27 = r16.longValue();
        g(2131383479).C(new PresaleActivityBarLayout$updateActivity$$inlined$let$lambda$2(r27, this));
        PriceView r28 = g(2131383479);
        if (r28 == null) goto L68;
        r28.setVisibility(0);
    L68:
        PriceView r29 = g(2131383480);
        if (r29 == null) goto L89;
        r29.setVisibility(8);
    L89:
        if ((!this.f.isEmpty()) == false) goto L114;
        String r30 = "";
        if (CollectionsKt.getOrNull(this.f, 0) == null) goto L94;
        r30 = "" + ((String) CollectionsKt.getOrNull(this.f, 0));
    L94:
        if (CollectionsKt.getOrNull(this.f, 1) != null) goto L96;
    L102:
        if (r20 == null) goto L114;
        r20.setActivityLabel(r30);
        goto L114
    L96:
        if (r30.length() <= 0) goto L98;
        boolean r6 = true;
    L99:
        if (r6 == false) goto L101;
        r30 = r30.concat(",");
    L101:
        r30 = r30 + ((String) CollectionsKt.getOrNull(this.f, 1));
        goto L102
    L98:
        r6 = false;
    L114:
        PromotionDepositPresaleActivity r1 = r18.getDepositPresaleActivity();     // Catch: Exception -> L108
        if (r1 == null) goto L116;
        long r31 = r1.getEndTime();     // Catch: Exception -> L108
        int r32 = g1.a;     // Catch: Exception -> L108
        ((TextView) g(2131390245)).setText(g1.a.c(getContext(), 2131896520, new Object[]{new SimpleDateFormat(g1.a.c(getContext(), 2131896522, new Object[0])).format(new Date(r31 * ((long) 1000)))}));     // Catch: Exception -> L108
        ((TextView) g(2131390245)).setVisibility(0);     // Catch: Exception -> L108
        return;
    L116:
        return;
    L108:
        dm.a.b r33 = dm.a.a("PresaleActivityBarLayout");
        StringBuilder r34 = new StringBuilder("updateRightBottomBanner format error: ");
        PromotionDepositPresaleActivity r35 = r18.getDepositPresaleActivity();
        if (r35 == null) goto L111;
        Long r36 = Long.valueOf(r35.getEndTime());
    L112:
        r34.append(r36);
        r33.b(r34.toString(), null);
        return;
    L111:
        r36 = null;
    L55:
        if (r20 == null) goto L59;
        PromotionProductPriceStruct r37 = r20.getProductPrice();
        if (r37 == null) goto L59;
        r25 = r37.getHeader();
    L59:
        r25 = null;
    L71:
        if (r16 == null) goto L75;
        final long r38 = r16.longValue();
        g(2131383479).C(new PresaleActivityBarLayout$updateActivity$$inlined$let$lambda$3(r38, this));
        PriceView r39 = g(2131383479);
        if (r39 == null) goto L75;
        r39.setVisibility(0);
    L75:
        if (r20 == null) goto L79;
        PromotionProductPriceStruct r40 = r20.getProductPrice();
        if (r40 == null) goto L79;
        final Long r41 = r40.getRegularPrice();
    L80:
        if (r41 == null) goto L84;
        g(2131383480).C(new PresaleActivityBarLayout$updateActivity$8(this, r41));
        PriceView r42 = g(2131383480);
        if (r42 == null) goto L87;
        r42.setVisibility(0);
    L87:
        ((LinearLayout) g(2131378664)).setVisibility(8);
        goto L89
    L84:
        PriceView r43 = g(2131383480);
        if (r43 == null) goto L87;
        r43.setVisibility(8);
    L79:
        r41 = null;
    L39:
        r16 = null;
    L34:
        r14 = null;
        goto L35
    }
}
