package com.bytedance.android.livesdk.livecommerce.room.widgets.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/CustomIconTemplate;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/BaseIconTemplate;", "Landroid/view/View;", "value", "e", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CustomIconTemplate extends BaseIconTemplate {
    public View e;

    public CustomIconTemplate(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomIconTemplate(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View getContentView() {
        return this.e;
    }

    public final void setContentView(View r3) {
        if ((!Intrinsics.areEqual(r3, this.e)) == false) goto L15;
        getContentContainer().removeView(r3);
        if (r3 == null) goto L13;
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L9;
        r0 = null;
    L9:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L12;
        r1.removeView(r3);
    L12:
        getContentContainer().addView(r3);
    L13:
        this.e = r3;
        return;
    }

    public CustomIconTemplate(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ CustomIconTemplate(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
