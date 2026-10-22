package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponNodeViewStyle4;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponNodeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponNodeViewStyle4 extends CouponNodeView {
    public static final /* synthetic */ int g = 0;
    public final TextView a;
    public final ECDraweeView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public boolean f;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CouponNodeViewStyle4 a;
        public final /* synthetic */ rd3.a b;
        public final /* synthetic */ yd3.b c;

        public b(CouponNodeViewStyle4 r1, rd3.a r2, yd3.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            rd3.a r1 = this.b;
            if (r1 == null) goto L9;
            FeedProductEventTracker r0 = FeedProductEventTracker.a;
            if (this.a.f == false) goto L7;
            String r11 = "button";
        L8:
            FeedProductEventTracker.m(r0, r1, r11, null, null, null, null, null, 124);
            goto L9
        L7:
            r11 = "coupon_get";
        L9:
            com.bytedance.android.ec.sdk.helper.p r12 = com.bytedance.android.ec.sdk.helper.p.a;
            Context r2 = this.a.getContext();
            yd3.g r3 = this.c.h();
            if (r3 == null) goto L12;
            String r4 = r3.c();
        L13:
            r12.openSchema(r2, r4);
            this.a.b();
            this.a.f = true;
            return;
        L12:
            r4 = null;
            goto L13
        }
    }

    static {
    }

    public CouponNodeViewStyle4(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CouponNodeViewStyle4(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        TextView r0 = this.e;
        if (r0 == null) goto L5;
        r0.setText(getContext().getString(2131896490));
    L5:
        TextView r1 = this.e;
        if (r1 == null) goto L8;
        r1.setBackgroundResource(2131247910);
    L8:
        TextView r2 = this.e;
        if (r2 == null) goto L12;
        r2.setTextColor(ColorProtector.parseColor("#FE496A"));
        return;
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.CouponNodeView
    public final void a(rd3.a r7) {
        Intrinsics.checkNotNullParameter(r7, "anchorInflowFeedItem");
        yd3.p r0 = r7.i();
        if (r0 == null) goto L28;
        yd3.b r1 = r0.d();
        if (r1 == null) goto L29;
        TextView r2 = this.a;
        if (r2 == null) goto L10;
        r2.setText(com.bytedance.android.shopping.extensions.i.a(r1.i()));
    L10:
        TextView r3 = this.c;
        if (r3 == null) goto L13;
        r3.setText(r1.f());
    L13:
        TextView r4 = this.d;
        if (r4 == null) goto L16;
        r4.setText(r1.j());
    L16:
        y.a(this.b, r1.c());
        TextView r5 = this.e;
        if (r5 == null) goto L19;
        ViewExtensionsKt.g(r5, com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
    L19:
        TextView r6 = this.e;
        if (r6 == null) goto L26;
        yd3.g r8 = r1.h();
        if (r8 == null) goto L24;
        String r9 = r8.d();
    L25:
        r6.setText(r9);
        goto L26
    L24:
        r9 = null;
    L26:
        setOnClickListener(new b(this, r7, r1));
        return;
    L29:
        return;
    }

    public CouponNodeViewStyle4(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560559, this, true);
        this.a = (TextView) findViewById(2131368130);
        this.b = findViewById(2131368124);
        this.c = (TextView) findViewById(2131368126);
        this.d = (TextView) findViewById(2131368132);
        this.e = (TextView) findViewById(2131368125);
    }

    public /* synthetic */ CouponNodeViewStyle4(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
