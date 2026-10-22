package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowBottomMemberView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "", "getJumpUrl", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowBottomMemberView extends AppCompatTextView {
    public PromotionProductStruct a;
    public PromotionProductButtonStruct b;
    public ti.j c;
    public rd3.a d;

    public InflowBottomMemberView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowBottomMemberView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public String getJumpUrl() {
        PromotionProductButtonStruct r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOrderUrl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        ti.j r0 = this.c;
        if (r0 == null) goto L6;
        ECLiveHybridUtil.p("shop_member_open_success", r0);
        return;
    }

    public PromotionProductStruct getPromotion() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InflowBottomMemberView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setTextSize(15.0f);
        setTypeface(Typeface.defaultFromStyle(1));
        setTextColor(-1);
        setGravity(17);
        setBackgroundResource(2131233445);
        setMaxLines(1);
        setHeight(com.bytedance.android.shopping.extensions.b.b(36));
    }

    public /* synthetic */ InflowBottomMemberView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(PromotionProductStruct r2, PromotionProductButtonStruct r3, final View.OnClickListener r4, rd3.a r5) {
        Intrinsics.checkNotNullParameter(r2, "promotion");
        this.a = r2;
        this.b = r3;
        if (ld3.c.f() == false) goto L5;
        this.d = r5;
    L5:
        if (r3 == null) goto L9;
        String r6 = r3.getText();
        if (r6 == null) goto L9;
    L10:
        setText(r6);
        boolean r7 = com.bytedance.android.shopping.feed.utils.t.a;
        PromotionProductExtraStruct r8 = r2.getExtraInfo();
        if (r8 == null) goto L15;
        PromotionProductButtonStruct r9 = r8.getBuyButton();
        if (r9 == null) goto L15;
        String r10 = r9.getExtra();
    L16:
        com.bytedance.android.shopping.feed.utils.s r11 = com.bytedance.android.shopping.feed.utils.t.a(r10);
        if (r11 == null) goto L31;
        Intrinsics.checkNotNullParameter(r11, "data");
        if (r11.a != 2) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L31;
        if (com.bytedance.android.shopping.feed.utils.t.a == true) goto L31;
        setText(r11.b);
        if (com.bytedance.android.shopping.feed.utils.t.a == true) goto L31;
        if (this.c != null) goto L31;
        l r13 = new l(this);
        this.c = r13;
        ECLiveHybridUtil.m("shop_member_open_success", r13);
        goto L31
    L22:
        r12 = false;
    L31:
        com.bytedance.android.ec.core.widget.f.c(this, null, null, new InflowBottomMemberView$bind$1(r4), 3);
        return;
    L15:
        r10 = null;
    L9:
        r6 = ag4.a.d(2131895762);
        goto L10
    }
}
