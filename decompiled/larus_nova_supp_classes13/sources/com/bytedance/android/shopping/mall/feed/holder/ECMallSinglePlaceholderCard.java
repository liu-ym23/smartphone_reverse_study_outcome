package com.bytedance.android.shopping.mall.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/holder/ECMallSinglePlaceholderCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallSinglePlaceholderCard extends BaseViewHolder {
    public static final /* synthetic */ int p = 0;
    public final SimpleDraweeView o;

    public static final class a {
    }

    static {
    }

    public final boolean C3() {
        return false;
    }

    public ECMallSinglePlaceholderCard(View r5) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        super(r5);
        SimpleDraweeView r0 = new SimpleDraweeView(r5.getContext());
        r0.setScaleType(ImageView.ScaleType.FIT_XY);
        Unit r1 = Unit.INSTANCE;
        this.o = r0;
        ((ViewGroup) r5).addView(r0, new ViewGroup.LayoutParams(-1, -2));
    }

    public final void b4(Object r3, String r4, k.a r5) {
        Intrinsics.checkNotNullParameter(r4, "itemId");
        super.b4(r3, r4, r5);
        if ((r3 instanceof ECMallPlaceholderCardVO) == true) goto L5;
        return;
    L5:
        ECMallPlaceholderCardVO r6 = (ECMallPlaceholderCardVO) r3;
        if (r6.getBackgroundUrl() == null) goto L8;
    L10:
        ECMallDeliveryReduceConfig r7 = r6.getReduceConfig();
        if (r7 == null) goto L13;
        Double r8 = Double.valueOf(r7.getCardRadius());
    L14:
        if (r8 == null) goto L16;
        float r9 = b0.c(r8);
        this.o.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(r9, r9, 0.0f, 0.0f));
    L17:
        String r10 = r6.getBackgroundUrl();
        if (r10 != null) goto L20;
    L23:
        boolean r11 = true;
    L24:
        if (r11 == true) goto L29;
        Float r12 = r6.getBackgroundUrlRatio();
        if (r12 == null) goto L28;
        this.o.setAspectRatio(r12.floatValue());
    L28:
        this.o.setImageURI(r6.getBackgroundUrl());
        return;
    L29:
        Float r13 = r6.getBackgroundResIdRatio();
        if (r13 == null) goto L32;
        this.o.setAspectRatio(r13.floatValue());
    L32:
        SimpleDraweeView r14 = this.o;
        Integer r15 = r6.getBackgroundResId();
        if (r15 == null) goto L35;
        int r16 = r15.intValue();
    L36:
        r14.setImageResource(r16);
        return;
    L35:
        r16 = -1;
        goto L36
    L20:
        if (r10.length() == 0) goto L23;
        r11 = false;
        goto L24
    L16:
        this.o.getHierarchy().setRoundingParams(null);
        goto L17
    L13:
        r8 = null;
        goto L14
    L8:
        if (r6.getBackgroundResId() != null) goto L10;
    }
}
