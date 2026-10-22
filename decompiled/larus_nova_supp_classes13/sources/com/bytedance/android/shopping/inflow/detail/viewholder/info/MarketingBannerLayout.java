package com.bytedance.android.shopping.inflow.detail.viewholder.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.d;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.CountDown;
import com.bytedance.android.ec.model.response.anchorv3.ElementBlock;
import com.bytedance.android.ec.model.response.anchorv3.MarketingBanner;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.widget.e;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/inflow/detail/viewholder/info/MarketingBannerLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketingBannerLayout extends FrameLayout implements l1.a {
    public static final r e = null;
    public final LinearLayout a;
    public final LinearLayout b;
    public e c;
    public final ECDraweeView d;

    public static final class a {
    }

    public static final class b extends d {
        public final /* synthetic */ MarketingBannerLayout g;
        public final /* synthetic */ MarketingBanner h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ boolean j;

        public final void a(View r5) {
            Intrinsics.checkNotNullParameter(r5, "v");
            if (cg4.a.a(this.h.getJumpUrl()) == false) goto L10;
            p.a.openSchema(r5.getContext(), this.h.getJumpUrl());
            FeedProductEventTracker r6 = FeedProductEventTracker.a;
            Context r0 = this.g.getContext();
            String r1 = ((StringBuilder) this.i.element).toString();
            Integer r2 = this.h.getType();
            if (r2 == null) goto L7;
            int r3 = r2.intValue();
        L8:
            boolean r4 = this.j;
            r6.getClass();
            FeedProductEventTracker.K(r0, r1, r3, true, r4);
            return;
        L7:
            r3 = 0;
            goto L8
        }

        public b(MarketingBannerLayout r1, MarketingBanner r2, Ref.ObjectRef r3, boolean r4) {
            this.g = r1;
            this.h = r2;
            this.i = r3;
            this.j = r4;
            super(null, null, 3);
        }
    }

    public MarketingBannerLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MarketingBannerLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onFinish() {
    }

    static {
        e = new r("ec_goods_feed", "ec_goods_feed_default");
    }

    public final void onStart() {
        dm.a.a("marketing_card").i("countdown on start");
    }

    public final void onTick(long r3) {
        int r0 = c2.h;
        c2 r4 = c2.a.a(getContext(), r3, false);
        e r5 = this.c;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "uiCountDown");
        r5.b.setText(r4.c);
        r5.c.setText(r4.d);
        r5.d.setText(r4.e);
        return;
    }

    public final void a(MarketingBanner r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "marketingBanner");
        this.c = null;
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = new StringBuilder("");
        List r1 = r12.getLeftContent();
        if (r1 == null) goto L10;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = ((ElementBlock) r2.next()).getText();
        if (r3 == null) goto L6;
        StringBuilder r4 = (StringBuilder) r0.element;
        r4.append(r3);
        r0.element = r4;
    L10:
        FeedProductEventTracker r5 = FeedProductEventTracker.a;
        Context r6 = getContext();
        String r7 = ((StringBuilder) r0.element).toString();
        Integer r8 = r12.getType();
        if (r8 == null) goto L13;
        int r9 = r8.intValue();
    L14:
        r5.getClass();
        FeedProductEventTracker.L(r6, r7, r9, true, r13);
        h0.e(this.d, r12.getBgImgUrl(), e, null, null, 120);
        setOnClickListener(new b(this, r12, r0, r13));
        this.d.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(4));
        this.a.removeAllViews();
        this.b.removeAllViews();
        List r14 = r12.getLeftContent();
        if (r14 == null) goto L20;
        Iterator r15 = r14.iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        b((ElementBlock) r15.next(), this.a);
    L20:
        List r16 = r12.getRightContent();
        if (r16 == null) goto L26;
        Iterator r17 = r16.iterator();
    L24:
        if (r17.hasNext() == false) goto L26;
        b((ElementBlock) r17.next(), this.b);
    L26:
        e r18 = this.c;
        if (r18 == null) goto L37;
        Lazy r19 = ActivityCountDownTimer.c;
        ActivityCountDownTimer.a.a().a(System.currentTimeMillis() / 1000, r18.getEndTime(), this, null);
        return;
    L37:
        return;
    L13:
        r9 = 0;
        goto L14
    }

    public final void b(ElementBlock r12, LinearLayout r13) {
        ECDraweeView r0 = new View(getContext());
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(-2, -2);
        int r2 = r12.getType();
        if (r2 != 1) goto L5;
        r0 = new ECDraweeView(getContext(), null, 0, 6, null);
        ECUrlModel r3 = r12.getAvatars();
        if (r3 == null) goto L34;
        int r4 = r3.getWidth();
    L35:
        r1.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r4));
        ECUrlModel r5 = r12.getAvatars();
        if (r5 == null) goto L38;
        int r6 = r5.getHeight();
    L39:
        r1.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6));
        h0.d(r0, r12.getAvatars(), e, null, null, null, null, 120);
    L40:
        r13.addView(r0, r1);
        return;
    L38:
        r6 = 14;
        goto L39
    L34:
        r4 = 38;
        goto L35
    L5:
        if (r2 != 2) goto L7;
        r0 = new TextView(getContext());
        r0.setText(r12.getText());
        r0.setTextSize(12.0f);
        int r7 = s.a;
        Integer r14 = s.b(r12.getTextColor());
        if (r14 == null) goto L40;
        r0.setTextColor(r14.intValue());
        goto L40
    L7:
        if (r2 != 3) goto L9;
        r0 = new View(getContext());
        r1.width = com.bytedance.android.shopping.extensions.b.b(Long.valueOf(r12.getBlankWidth()));
        goto L40
    L9:
        if (r2 != 4) goto L11;
        r0 = new ECDraweeView(getContext(), null, 0, 6, null);
        ECUrlModel r8 = r12.getImage();
        if (r8 == null) goto L21;
        Number r9 = Integer.valueOf(r8.getWidth());
    L22:
        r1.width = com.bytedance.android.shopping.extensions.b.b(r9);
        ECUrlModel r10 = r12.getImage();
        if (r10 == null) goto L25;
        Number r11 = Integer.valueOf(r10.getHeight());
    L26:
        r1.height = com.bytedance.android.shopping.extensions.b.b(r11);
        h0.d(r0, r12.getImage(), e, null, null, null, null, 120);
        goto L40
    L25:
        r11 = Double.valueOf(9.5d);
        goto L26
    L21:
        r9 = Double.valueOf(5.25d);
        goto L22
    L11:
        if (r2 != 5) goto L40;
        CountDown r15 = r12.getCountDown();
        if (r15 == null) goto L16;
        Long r16 = Long.valueOf(r15.getEndTime());
    L17:
        r0 = new e(r16, getContext());
        this.c = r0;
        goto L40
    L16:
        r16 = null;
        goto L17
    }

    public MarketingBannerLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560633, this, true);
        this.a = (LinearLayout) findViewById(2131377764);
        this.b = (LinearLayout) findViewById(2131384573);
        this.d = findViewById(2131364139);
    }

    public /* synthetic */ MarketingBannerLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
