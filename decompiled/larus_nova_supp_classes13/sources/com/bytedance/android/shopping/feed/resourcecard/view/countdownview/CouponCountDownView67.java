package com.bytedance.android.shopping.feed.resourcecard.view.countdownview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/countdownview/CouponCountDownView67;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/countdownview/BaseCountDownView;", "", "getLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponCountDownView67 extends BaseCountDownView {
    public CouponCountDownView67(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CouponCountDownView67(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.countdownview.BaseCountDownView
    public int getLayout() {
        return 2131560557;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.feed.resourcecard.view.countdownview.BaseCountDownView
    public final void e(long r13) {
        long r14 = r13 / 1000;
        if (r14 <= 0) goto L14;
        TextView r0 = getTvHours();
        if (r0 == null) goto L7;
        r0.setText(getContext().getString(2131896692, new Object[]{Long.valueOf(r14 / ((long) 3600))}));
    L7:
        TextView r1 = getTvMins();
        if (r1 == null) goto L10;
        r1.setText(getContext().getString(2131896692, new Object[]{Long.valueOf((r14 % ((long) 3600)) / ((long) 60))}));
    L10:
        TextView r2 = getTvSecs();
        if (r2 == null) goto L15;
        r2.setText(getContext().getString(2131896692, new Object[]{Long.valueOf((r14 % ((long) 3600)) % ((long) 60))}));
        return;
    L15:
        return;
    }

    public CouponCountDownView67(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ CouponCountDownView67(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
