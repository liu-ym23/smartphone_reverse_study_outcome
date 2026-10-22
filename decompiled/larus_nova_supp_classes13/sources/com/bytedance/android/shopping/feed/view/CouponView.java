package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.shopping.feed.resourcecard.view.countdownview.CouponCountDownViewV2;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/CouponView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponView extends FrameLayout {
    public final TextView a;
    public final ECDraweeView b;
    public final TextView c;
    public final CouponCountDownViewV2 d;
    public final TextView e;
    public final ImageView f;
    public final View g;
    public final ConstraintLayout h;
    public b i;

    public static final class a {
    }

    public interface b {
        void a(String r1);

        void b(String r1);
    }

    public static final class c implements com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a {
        public final /* synthetic */ CouponView a;

        @Override // com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a
        public final void a() {
            ConstraintLayout r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.setVisibility(8);
            return;
        }

        public c(CouponView r1) {
            this.a = r1;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CouponView a;
        public final /* synthetic */ SpannableStringBuilder b;

        public d(CouponView r1, SpannableStringBuilder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.i;
            if (r3 == null) goto L6;
            r3.b(this.b.toString());
            return;
        }
    }

    static {
    }

    public CouponView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CouponView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final SpannableStringBuilder b(String r5) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(getContext().getString(2131896658, new Object[]{r5}));
        r0.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), 2131101749)), 0, r0.toString().length(), 33);
        r0.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), 2131101750)), 2, r0.toString().length() - 3, 33);
        return r0;
    }

    public CouponView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560563, this, true);
        this.a = (TextView) findViewById(2131368103);
        this.b = findViewById(2131368097);
        this.e = (TextView) findViewById(2131368110);
        this.c = (TextView) findViewById(2131368071);
        this.d = (CouponCountDownViewV2) findViewById(2131368107);
        this.f = (ImageView) findViewById(2131368108);
        this.g = findViewById(2131368106);
        this.h = findViewById(2131368065);
    }

    public final void a(CouponUrgeInfo r10, boolean r11, b r12) {
        Intrinsics.checkNotNullParameter(r10, "couponUrgeInfo");
        this.i = r12;
        ECDraweeView r1 = this.b;
        if (r1 == null) goto L5;
        h0.d(r1, r10.getBgImg(), new com.bytedance.android.ec.core.imagex.r("ec_goods_feed", "ec_goods_feed_default"), null, null, null, null, 120);
    L5:
        TextView r0 = this.a;
        if (r0 == null) goto L8;
        r0.setText(com.bytedance.android.shopping.extensions.i.a(Long.valueOf(r10.getPrice())));
    L8:
        SpannableStringBuilder r2 = b(com.bytedance.android.shopping.extensions.i.a(Long.valueOf(r10.getPrice())));
        TextView r3 = this.c;
        if (r3 == null) goto L12;
        r3.setText(r2);
    L12:
        if (r10.getExpireTime() == 1) goto L19;
        LinearLayoutCompat r4 = this.d;
        if (r4 == null) goto L16;
        r4.setVisibility(0);
    L16:
        CouponCountDownViewV2 r5 = this.d;
        if (r5 == null) goto L19;
        long r6 = r10.getExpireTime();
        c r7 = new c(this);
        r5.e = Long.valueOf(r6);
        r5.f = r7;
        r5.d();
    L19:
        if (r11 == false) goto L29;
        TextView r13 = this.e;
        if (r13 == null) goto L23;
        wg.a.f(r13, 0, 0, 0, 0);
    L23:
        ImageView r14 = this.f;
        if (r14 == null) goto L26;
        r14.setVisibility(0);
    L26:
        View r15 = this.g;
        if (r15 == null) goto L35;
        r15.setOnClickListener(new d(this, r2));
    L35:
        ConstraintLayout r16 = this.h;
        if (r16 != null) goto L38;
        return;
    L38:
        if (r16.getVisibility() != 0) goto L42;
        r12.a(b(com.bytedance.android.shopping.extensions.i.a(Long.valueOf(r10.getPrice()))).toString());
        return;
    L42:
        return;
    L29:
        ImageView r17 = this.f;
        if (r17 == null) goto L32;
        r17.setVisibility(8);
    L32:
        TextView r18 = this.e;
        if (r18 == null) goto L35;
        wg.a.f(r18, 0, 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        goto L35
    }

    public /* synthetic */ CouponView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
