package com.bytedance.android.shopping.feed.widget.inflowcardtitle;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBannerStruct;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0013\u0014B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/inflowcardtitle/InFlowCardTitleView;", "Landroid/widget/FrameLayout;", "", "", "color", "", "setTitleTextColor", "", "size", "setTitleTextSize", "weight", "setTitleTextStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InFlowCardTitleView extends FrameLayout {
    public final TextView a;
    public int b;
    public final View c;
    public Disposable d;

    public static final class a {
    }

    public interface b {
        void a();
    }

    static {
    }

    public InFlowCardTitleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InFlowCardTitleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static boolean b(ECUrlModel r2) {
        if (r2.getUri() != null) goto L13;
        List r3 = r2.getUrlList();
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        return false;
    L7:
        if (r3.isEmpty() == true) goto L10;
        r4 = false;
    L13:
        return true;
    }

    public void setTitleTextColor(int r3) {
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        int r1 = g1.a;
        r0.setTextColor(g1.a.a(getContext(), r3));
        return;
    }

    public void setTitleTextSize(float r3) {
        float r0 = se3.a.a;
        se3.a.c(this.a, 2, r3);
    }

    public void setTitleTextStyle(int r3) {
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        ViewExtensionsKt.e(r0, r0.getPaint(), r3);
        return;
    }

    public InFlowCardTitleView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.b = 1;
        if (r6 == null) goto L6;
        TypedArray r8 = getContext().obtainStyledAttributes(r6, new int[]{2130972701});
        this.b = r8.getInt(0, 1);
        r8.recycle();
    L6:
        if (ld3.b.a() == false) goto L8;
        Map r9 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r5).aU(2131560734, this, true);
    L9:
        TextView r10 = (TextView) findViewById(2131383165);
        this.a = r10;
        r10.setMaxLines(this.b);
        View r11 = findViewById(2131383166);
        this.c = r11;
        int r0 = g1.a;
        r10.setTextColor(g1.a.a(r5, 2131100046));
        se3.a.c(r10, 2, 17.0f);
        se3.a.b(r11);
        return;
    L8:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r5).aU(2131560734, this, true);
        goto L9
    }

    public /* synthetic */ InFlowCardTitleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(String r7, ECUrlModel r8, PromotionProductBannerStruct r9, boolean r10, BaseCardDetailView.g r11) {
        ArrayList r0 = new ArrayList();
        if (r8 != null) goto L5;
    L7:
        if (r9 == null) goto L15;
        ECUrlModel r2 = r9.getIcon();
        if (r2 == null) goto L15;
        if (b(r2) != true) goto L15;
        ECUrlModel r1 = r9.getIcon();
        if (r1 == null) goto L15;
        r0.add(r1);
    L15:
        int r3 = 16;
        if (r8 == null) goto L18;
        int r12 = r8.getHeight();
    L19:
        if (r9 == null) goto L23;
        ECUrlModel r13 = r9.getIcon();
        if (r13 == null) goto L23;
        int r14 = r13.getHeight();
    L24:
        int r15 = RangesKt.coerceAtLeast(r12, r14);
        if (r15 <= 0) goto L28;
        r3 = r15;
    L28:
        int r16 = (int) se3.a.a(r3);
        p1 r17 = p1.d;
        TextView r4 = this.a;
        Float r5 = Float.valueOf(4.0f);
        r17.getClass();
        Disposable r18 = p1.a(r0, r7, 4.0f, r16, r4, r5);
        if (r18 == null) goto L31;
        this.d = r18;
    L31:
        setOnLongClickListener(new be3.a(r10, r11));
        return;
    L23:
        r14 = 16;
        goto L24
    L18:
        r12 = 16;
        goto L19
    L5:
        if (b(r8) != true) goto L7;
        r0.add(r8);
        goto L7
    }
}
