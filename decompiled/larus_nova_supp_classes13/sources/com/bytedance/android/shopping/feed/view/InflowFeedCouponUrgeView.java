package com.bytedance.android.shopping.feed.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.ec.model.response.anchorv3.InnerFlowCouponExtra;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.feed.event.t1;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u000b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowFeedCouponUrgeView;", "Landroid/widget/LinearLayout;", "Ln83/j;", "", "getCurrentDate", "", "style", "", "setUrgeViewStyle", "Lkotlin/Function0;", "onCountDownFinish", "setCountDownFinishCallback", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedCouponUrgeView extends LinearLayout implements n83.j {
    public static final Lazy g = null;
    public static String h;
    public int a;
    public l1 b;
    public Function0<Unit> c;
    public boolean d;
    public final TextView e;
    public final TextView f;

    public static final class a {
        public static final ArrayMap a() {
            Lazy r0 = InflowFeedCouponUrgeView.g;
            return (ArrayMap) InflowFeedCouponUrgeView.g.getValue();
        }

        public a() {
        }
    }

    public static final class b implements l1.a {
        public final /* synthetic */ InflowFeedCouponUrgeView a;

        public final void onStart() {
        }

        public final void onFinish() {
            InflowFeedCouponUrgeView r0 = this.a;
            Lazy r1 = InflowFeedCouponUrgeView.g;
            r0.d(0);
            InflowFeedCouponUrgeView r2 = this.a;
            r2.getClass();
            ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, LinearLayout.ALPHA, new float[]{1.0f, 0.0f});
            r3.setDuration(200);
            r3.addListener(new h(r2));
            r3.start();
            Function0<Unit> r4 = this.a.c;
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke();
            return;
        }

        public b(InflowFeedCouponUrgeView r1) {
            this.a = r1;
        }

        public final void onTick(long r3) {
            InflowFeedCouponUrgeView r0 = this.a;
            Lazy r1 = InflowFeedCouponUrgeView.g;
            r0.d(r3);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ InflowFeedCouponUrgeView a;
        public final /* synthetic */ CouponUrgeInfo b;

        public c(InflowFeedCouponUrgeView r1, CouponUrgeInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InflowFeedCouponUrgeView.c(this.a, this.b.getCouponMetaId());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public InflowFeedCouponUrgeView(Context r7) {
        this(r7, null, 0, 0, 14);
    }

    public InflowFeedCouponUrgeView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 0, 12);
    }

    public InflowFeedCouponUrgeView(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, 0, 8);
    }

    @Override // n83.j
    public final InflowFeedCouponUrgeView i() {
        return this;
    }

    static {
        new a();
        g = LazyKt.lazy(InflowFeedCouponUrgeView$Companion$urgeShowCountMap$2.INSTANCE);
        int r0 = pi3.a.a;
        h = com.bytedance.android.ec.sdk.helper.q.a.getString("inner_flow_coupon_urge_last_show_date", "");
    }

    private final String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }

    @Override // n83.j
    public final void b() {
        l1 r0 = this.b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void d(long r9) {
        int r2 = (int) (r9 / ((long) 3600000));
        long r10 = r9 - ((long) (3600000 * r2));
        int r1 = (int) (r10 / ((long) 60000));
        long r11 = (r10 - ((long) (60000 * r1))) / ((long) 1000);
        if (this.a != 1) goto L5;
        int r0 = 2131913882;
    L6:
        this.f.setText(getContext().getString(r0, new Object[]{Integer.valueOf(r2), Integer.valueOf(r1), Long.valueOf(r11)}));
        return;
    L5:
        r0 = 2131913881;
        goto L6
    }

    @Override // n83.j
    public void setCountDownFinishCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onCountDownFinish");
        this.c = r2;
    }

    public void setUrgeViewStyle(int r3) {
        this.a = r3;
        if (r3 != 1) goto L5;
        int r4 = com.bytedance.android.shopping.extensions.b.b(8);
        setPadding(r4, 0, r4, 0);
        setBackgroundResource(2131248128);
        this.e.setTypeface(Typeface.DEFAULT);
        this.f.setTypeface(Typeface.DEFAULT);
        return;
    L5:
        if (r3 != 2) goto L11;
        int r5 = com.bytedance.android.shopping.extensions.b.b(12);
        setPadding(r5, 0, r5, 0);
        setBackgroundResource(2131248127);
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
        this.f.setTypeface(Typeface.DEFAULT_BOLD);
        return;
    }

    public static final void c(InflowFeedCouponUrgeView r5, long r6) {
        String r0 = r5.getCurrentDate();
        if ((!Intrinsics.areEqual(r0, h)) == false) goto L5;
        h = r0;
        int r1 = pi3.a.a;
        Intrinsics.checkNotNullParameter(r0, "jsonString");
        com.bytedance.android.ec.sdk.helper.q.a.putString("inner_flow_coupon_urge_last_show_date", r0);
        a.a().clear();
    L5:
        Integer r2 = (Integer) a.a().get(Long.valueOf(r6));
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        a.a().put(Long.valueOf(r6), Integer.valueOf(r3 + 1));
        int r7 = pi3.a.a;
        String r8 = GsonProtectorUtils.toJson(new Gson(), a.a());
        Intrinsics.checkNotNullParameter(r8, "jsonString");
        com.bytedance.android.ec.sdk.helper.q.a.putString("inner_flow_coupon_urge_show_count_map", r8);
        r5.d = true;
        return;
    L8:
        r3 = 0;
        goto L9
    }

    @Override // n83.j
    public final void a(PromotionProductCouponsStruct r18, AnchorV3Param r19) {
        Intrinsics.checkNotNullParameter(r18, "couponInfo");
        InnerFlowCouponExtra r1 = r18.getInnerFlowCouponExtra();
        if (r1 == null) goto L5;
        CouponUrgeInfo r2 = r1.getCouponUrgeInfo();
    L7:
        if (r2 != null) goto L9;
    L50:
        setVisibility(8);
        return;
    L9:
        if (Intrinsics.areEqual(h, getCurrentDate()) == false) goto L16;
        Integer r4 = (Integer) a.a().get(Long.valueOf(r2.getCouponMetaId()));
        if (r4 == null) goto L16;
        if (r4.intValue() <= r2.getShowTimePerDay()) goto L16;
        boolean r5 = false;
    L17:
        if (r5 == false) goto L50;
        long r12 = (r2.getExpireTime() * ((long) 1000)) - System.currentTimeMillis();
        if (r12 > 0) goto L23;
        setVisibility(8);
        return;
    L23:
        setVisibility(0);
        TextView r3 = this.e;
        if (this.a != 1) goto L26;
        String r7 = r2.getDesc();
    L27:
        r3.setText(r7);
        if (r12 >= 259200000) goto L30;
        d(r12);
        l1 r6 = new l1(r12, 1000, new b(this));
        this.b = r6;
        r6.d();
    L32:
        if (this.a != 2) goto L37;
        if (this.d == true) goto L37;
        post(new c(this, r2));
    L37:
        if (this.a != 1) goto L52;
        t1 r8 = new t1();
        if (r19 == null) goto L41;
        String r9 = r19.getProductId();
    L42:
        r8.b = r9;
        r8.c = 1000;
        r8.a = "product_flow_page";
        if (r19 == null) goto L47;
        AnchorV3PromotionRequestParam r10 = r19.getRequestParam();
        if (r10 == null) goto L47;
        String r11 = r10.getItemId();
    L48:
        r8.d = r11;
        com.bytedance.android.shopping.feed.event.g.c(r8, getContext(), null);
        return;
    L47:
        r11 = null;
        goto L48
    L41:
        r9 = null;
        goto L42
    L52:
        return;
    L30:
        this.f.setText(getContext().getString(2131913883, new Object[]{Integer.valueOf((int) (r12 / ((long) 86400000)))}));
        goto L32
    L26:
        r7 = r2.getDescShort();
    L16:
        r5 = true;
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    public InflowFeedCouponUrgeView(Context r3, AttributeSet r4, int r5, int r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = 1;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = -1;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(r3).inflate(2131564702, this);
        this.e = (TextView) findViewById(2131391943);
        this.f = (TextView) findViewById(2131391944);
        setUrgeViewStyle(r6);
        setOnClickListener(new g(r3));
    }
}
