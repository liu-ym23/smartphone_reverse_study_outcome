package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/InflowBottomCommonButton;", "Landroidx/appcompat/widget/AppCompatButton;", "", "", "getJumpUrl", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "getPromotion", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class InflowBottomCommonButton extends AppCompatButton {
    public PromotionProductStruct a;
    public PromotionProductButtonStruct b;

    public InflowBottomCommonButton(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InflowBottomCommonButton(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public String getJumpUrl() {
        PromotionProductButtonStruct r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOrderUrl();
    }

    public PromotionProductStruct getPromotion() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InflowBottomCommonButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setText(ag4.a.d(2131895762));
        setGravity(17);
        setTextColor(getResources().getColor(2131109391));
        setBackgroundResource(2131234577);
    }

    public /* synthetic */ InflowBottomCommonButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(PromotionProductStruct r1, PromotionProductButtonStruct r2, final View.OnClickListener r3, rd3.a r4) {
        Intrinsics.checkNotNullParameter(r1, "promotion");
        this.a = r1;
        this.b = r2;
        if (r2 == null) goto L7;
        String r5 = r2.getText();
        if (r5 == null) goto L7;
    L8:
        setText(r5);
        if (r2 != null) goto L11;
    L13:
        com.bytedance.android.ec.core.widget.f.c(this, null, null, new InflowBottomCommonButton$bind$1(r3), 3);
        return;
    L11:
        if (r2.getGrayButton() != true) goto L13;
        setAlpha(0.5f);
        setOnClickListener(null);
        return;
    L7:
        r5 = ag4.a.d(2131895762);
        goto L8
    }
}
