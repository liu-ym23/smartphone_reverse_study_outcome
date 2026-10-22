package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoViewForVideo;", "Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomInfoViewForVideo extends BottomInfoView {
    @Override // com.bytedance.android.shopping.mall.homepage.card.common.BottomInfoView
    public final void R5() {
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.i() == false) goto L5;
        getNameView().setTextColor(ColorProtector.parseColor("#333333"));
        return;
    L5:
        getNameView().setTextColor(ColorProtector.parseColor("#3E3E3E"));
    }

    public BottomInfoViewForVideo(Context r1) {
        super(r1);
    }

    public BottomInfoViewForVideo(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public BottomInfoViewForVideo(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
