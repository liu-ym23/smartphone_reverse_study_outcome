package com.bytedance.android.shopping.inflow.detail.viewholder.info;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.shopping.extensions.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/inflow/detail/viewholder/info/BenefitGroupLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BenefitGroupLayout extends FrameLayout implements l1.a {
    public TextView a;
    public ImageView b;
    public String c;
    public final boolean d;

    public static final class a {
    }

    static {
    }

    public final void onFinish() {
    }

    public final void onStart() {
    }

    public BenefitGroupLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = d.e(d.b());
        a(r2);
    }

    public final void a(Context r4) {
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).aU(2131560521, this, true);
        this.a = (TextView) findViewById(2131390479);
        this.b = (ImageView) findViewById(2131376558);
        TextView r5 = this.a;
        if (r5 == null) goto L5;
        se3.a.c(r5, 2, 12.0f);
    L5:
        ImageView r6 = this.b;
        if (r6 == null) goto L9;
        se3.a.b(r6);
    L9:
        if (this.d == false) goto L12;
        setPadding(b.b(4), b.b(4), b.b(4), b.b(4));
        return;
    }

    public final void onTick(long r6) {
        int r0 = c2.h;
        c2 r7 = c2.a.a(getContext(), r6, false);
        TextView r8 = this.a;
        if (r8 == null) goto L10;
        String r1 = this.c;
        if (r1 == null) goto L7;
        String r9 = String.format(r1, Arrays.copyOf(new Object[]{r7.c, r7.d, r7.e}, 3));
    L8:
        r8.setText(r9);
        return;
    L7:
        r9 = null;
        goto L8
    }

    public BenefitGroupLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3);
        this.d = d.e(d.b());
        a(r2);
    }

    public BenefitGroupLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3, r4);
        this.d = d.e(d.b());
        a(r2);
    }
}
