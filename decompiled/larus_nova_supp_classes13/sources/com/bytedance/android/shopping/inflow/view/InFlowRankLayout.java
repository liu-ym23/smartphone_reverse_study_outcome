package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/InFlowRankLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Lkotlin/Function0;", "", "onClickCallBack", "setOnClickCallBack", "", "size", "setTextSize", "(Ljava/lang/Float;)V", "", "weight", "setTextStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowRankLayout extends FrameLayout implements com.bytedance.android.shopping.feed.view.c {
    public String a;
    public Float b;
    public int c;
    public Function0<Unit> d;

    public InFlowRankLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InFlowRankLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final void b(TextView r3) {
        Float r0 = this.b;
        if (r0 == null) goto L5;
        r3.setTextSize(r0.floatValue());
    L5:
        Integer r1 = Integer.valueOf(this.c);
        if (r1.intValue() < 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        int r4 = r1.intValue();
        ViewExtensionsKt.e(r3, r3.getPaint(), r4);
    L14:
        float r5 = se3.a.a;
        Float r6 = this.b;
        if (r6 == null) goto L17;
        float r7 = r6.floatValue();
    L18:
        se3.a.c(r3, 2, r7);
        return;
    L17:
        r7 = 13.0f;
        goto L18
    L8:
        r2 = false;
        goto L9
    }

    public final void setOnClickCallBack(Function0<Unit> r1) {
        this.d = r1;
    }

    public final void setTextSize(Float r1) {
        this.b = r1;
    }

    public final void setTextStyle(int r1) {
        this.c = r1;
    }

    public InFlowRankLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = -1;
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r2).aU(2131560744, this, true);
        return;
    L5:
        u63.a.a(r2, 2131560744, this, true);
    }

    public /* synthetic */ InFlowRankLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
