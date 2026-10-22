package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.response.BannerInfo;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.b;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/widget/ECProductBottomGeneralView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECProductBottomGeneralView extends FrameLayout {
    public final ECDraweeView a;
    public final ECCustomizedElementView b;
    public final ECCustomizedElementView c;

    public interface a {
        void onClick();
    }

    public ECProductBottomGeneralView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECProductBottomGeneralView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(BannerInfo r8, final b r9) {
        Intrinsics.checkNotNullParameter(r8, "data");
        h0.e(this.a, r8.getBgImageUrl(), null, null, null, 120);
        List<com.bytedance.android.ec.model.live.b> r0 = r8.getLeftContent();
        if (r0 == null) goto L5;
        this.b.setVisibility(0);
        ECCustomizedElementView r3 = this.b;
        int r4 = ECCustomizedElementView.k;
        r3.b(r0, false);
    L6:
        List<com.bytedance.android.ec.model.live.b> r10 = r8.getRightContent();
        if (r10 == null) goto L9;
        this.c.setVisibility(0);
        ECCustomizedElementView r1 = this.c;
        int r2 = ECCustomizedElementView.k;
        r1.b(r10, false);
    L10:
        f.c(this, null, null, new ECProductBottomGeneralView$bind$5(r9), 3);
        return;
    L9:
        this.c.setVisibility(8);
        goto L10
    L5:
        this.b.setVisibility(8);
        goto L6
    }

    public ECProductBottomGeneralView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131564743, this, true);
        this.a = findViewById(2131370421);
        this.b = (ECCustomizedElementView) findViewById(2131365441);
        this.c = (ECCustomizedElementView) findViewById(2131365442);
    }

    public /* synthetic */ ECProductBottomGeneralView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
