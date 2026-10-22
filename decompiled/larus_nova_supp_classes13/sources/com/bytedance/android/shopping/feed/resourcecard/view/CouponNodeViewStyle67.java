package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.resourcecard.view.countdownview.CouponCountDownView67;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponNodeViewStyle67;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponNodeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponNodeViewStyle67 extends CouponNodeView {
    public static final /* synthetic */ int i = 0;
    public final TextView a;
    public final ECDraweeView b;
    public final TextView c;
    public final TextView d;
    public final CouponCountDownView67 e;
    public final ImageView f;
    public final View g;
    public final ConstraintLayout h;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a {
        public final /* synthetic */ CouponNodeViewStyle67 a;

        @Override // com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a
        public final void a() {
            LinearLayoutCompat r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.setVisibility(8);
        L5:
            ImageView r1 = this.a.f;
            if (r1 == null) goto L8;
            r1.setVisibility(8);
        L8:
            CouponNodeViewStyle67 r2 = this.a;
            TextView r3 = r2.d;
            if (r3 == null) goto L11;
            r3.setText(th.a.g(r2.getContext(), 2131896423));
        L11:
            TextView r4 = this.a.d;
            if (r4 == null) goto L15;
            wg.a.f(r4, 0, 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
            return;
        }

        public b(CouponNodeViewStyle67 r1) {
            this.a = r1;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CouponNodeViewStyle67 a;
        public final /* synthetic */ rd3.a b;
        public final /* synthetic */ yd3.b c;

        public c(CouponNodeViewStyle67 r1, rd3.a r2, yd3.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            FeedProductEventTracker.m(FeedProductEventTracker.a, this.b, "button", null, null, null, null, null, 124);
            com.bytedance.android.ec.sdk.helper.p r11 = com.bytedance.android.ec.sdk.helper.p.a;
            Context r0 = this.a.getContext();
            yd3.g r1 = this.c.h();
            if (r1 == null) goto L5;
            String r2 = r1.c();
        L6:
            r11.openSchema(r0, r2);
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    public CouponNodeViewStyle67(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CouponNodeViewStyle67(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.CouponNodeView
    public final void a(rd3.a r14) {
        Intrinsics.checkNotNullParameter(r14, "anchorInflowFeedItem");
        Intrinsics.checkNotNullParameter(r14, "anchorInflowFeedItem");
        yd3.p r0 = r14.i();
        if (r0 == null) goto L89;
        yd3.b r1 = r0.d();
        if (r1 == null) goto L91;
        int r2 = r1.b();
        if (r2 != 6) goto L10;
    L11:
        ConstraintLayout r3 = this.h;
        if (r3 == null) goto L14;
        wg.a.f(r3, com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(3), com.bytedance.android.shopping.extensions.b.b(12), 0);
    L14:
        TextView r4 = this.a;
        if (r4 == null) goto L17;
        r4.setText(com.bytedance.android.shopping.extensions.i.a(r1.i()));
    L17:
        ECDraweeView r5 = this.b;
        if (r5 == null) goto L20;
        h0.d(r5, r1.c(), null, null, null, null, null, 120);
    L20:
        TextView r6 = this.c;
        String r7 = "";
        if (r6 == null) goto L48;
        String r8 = r1.f();
        String r9 = r1.j();
        if (com.bytedance.android.shopping.extensions.k.c(r8) == true) goto L25;
    L27:
        boolean r10 = true;
        if (com.bytedance.android.shopping.extensions.k.c(r8) == false) goto L37;
        if (r9 != null) goto L31;
    L34:
        boolean r11 = true;
    L35:
        if (r11 == false) goto L37;
        String r12 = String.valueOf(r8);
    L47:
        r6.setText(r12);
        goto L48
    L31:
        if (r9.length() == 0) goto L34;
        r11 = false;
    L37:
        if (r8 != null) goto L39;
    L42:
        if (r10 == true) goto L44;
    L46:
        r12 = "";
        goto L47
    L44:
        if (com.bytedance.android.shopping.extensions.k.c(r9) == false) goto L46;
        r12 = String.valueOf(r9);
        goto L47
    L39:
        if (r8.length() == 0) goto L42;
        r10 = false;
        goto L42
    L25:
        if (com.bytedance.android.shopping.extensions.k.c(r9) == false) goto L27;
        r12 = r8 + 183 + r9;
    L48:
        TextView r13 = this.d;
        if (r13 == null) goto L56;
        yd3.g r15 = r1.h();
        if (r15 == null) goto L55;
        String r16 = r15.d();
        if (r16 == null) goto L55;
        r7 = r16;
    L55:
        r13.setText(r7);
    L56:
        ImageView r17 = this.f;
        if (r17 == null) goto L59;
        r17.setVisibility(0);
    L59:
        yd3.s r18 = r1.k();
        if (r18 == null) goto L62;
        Long r19 = r18.a();
    L63:
        if (r19 != null) goto L70;
        LinearLayoutCompat r20 = this.e;
        if (r20 == null) goto L67;
        r20.setVisibility(8);
    L67:
        TextView r21 = this.d;
        if (r21 == null) goto L85;
        wg.a.f(r21, 0, 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
    L85:
        View r22 = this.g;
        if (r22 == null) goto L90;
        r22.setOnClickListener(new c(this, r14, r1));
        return;
    L90:
        return;
    L70:
        LinearLayoutCompat r23 = this.e;
        if (r23 == null) goto L73;
        r23.setVisibility(0);
    L73:
        TextView r24 = this.d;
        if (r24 == null) goto L76;
        r24.setText(th.a.g(getContext(), 2131896892));
    L76:
        ImageView r25 = this.f;
        if (r25 == null) goto L79;
        r25.setVisibility(0);
    L79:
        TextView r26 = this.d;
        if (r26 == null) goto L82;
        wg.a.f(r26, 0, 0, com.bytedance.android.shopping.extensions.b.b(6), 0);
    L82:
        CouponCountDownView67 r27 = this.e;
        if (r27 == null) goto L85;
        long r28 = r19.longValue();
        b r29 = new b(this);
        r27.e = Long.valueOf(r28);
        r27.f = r29;
        r27.d();
        goto L85
    L62:
        r19 = null;
        goto L63
    L10:
        if (r2 != 7) goto L14;
    L91:
        return;
    }

    public CouponNodeViewStyle67(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560561, this, true);
        this.h = findViewById(2131368065);
        this.a = (TextView) findViewById(2131368103);
        this.b = findViewById(2131368097);
        this.c = (TextView) findViewById(2131368071);
        this.d = (TextView) findViewById(2131368110);
        this.e = (CouponCountDownView67) findViewById(2131368107);
        this.g = findViewById(2131368106);
        this.f = (ImageView) findViewById(2131368108);
    }

    public /* synthetic */ CouponNodeViewStyle67(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
