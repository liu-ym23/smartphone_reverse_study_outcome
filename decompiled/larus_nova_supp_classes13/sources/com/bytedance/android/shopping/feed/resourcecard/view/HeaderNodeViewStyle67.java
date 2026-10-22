package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yd3.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeViewStyle67;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyle67 extends HeaderNodeView {
    public static final /* synthetic */ int e = 0;
    public final ECDraweeView c;
    public final TextView d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ HeaderNodeViewStyle67 a;
        public final /* synthetic */ Context b;

        public a(HeaderNodeViewStyle67 r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            rd3.a r1 = this.a.getAnchorInflowFeedItem();
            if (r1 == null) goto L5;
            FeedProductEventTracker.m(FeedProductEventTracker.a, r1, "button", null, null, null, null, null, 124);
        L5:
            yd3.f r11 = this.a.getHeaderNode();
            if (r11 == null) goto L11;
            yd3.g r12 = r11.c();
            if (r12 == null) goto L12;
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, r12.c());
            return;
        L12:
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public HeaderNodeViewStyle67(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HeaderNodeViewStyle67(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r11) {
        Intrinsics.checkNotNullParameter(r11, "anchorInflowFeedItem");
        super.a(r11);
        TextView r12 = this.d;
        yd3.f r0 = getHeaderNode();
        ECUrlModel r1 = null;
        if (r0 == null) goto L7;
        yd3.g r2 = r0.c();
        if (r2 == null) goto L7;
        String r3 = r2.d();
    L8:
        r12.setText(r3);
        ECDraweeView r4 = this.c;
        yd3.f r13 = getHeaderNode();
        if (r13 == null) goto L13;
        t r14 = r13.f();
        if (r14 == null) goto L13;
        r1 = r14.b();
    L13:
        h0.d(r4, r1, null, null, null, null, null, 120);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public HeaderNodeViewStyle67(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560581, this, true);
        this.c = findViewById(2131374258);
        this.d = (TextView) findViewById(2131374264);
        ((LinearLayout) findViewById(2131374263)).setOnClickListener(new a(this, r2));
    }

    public /* synthetic */ HeaderNodeViewStyle67(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
