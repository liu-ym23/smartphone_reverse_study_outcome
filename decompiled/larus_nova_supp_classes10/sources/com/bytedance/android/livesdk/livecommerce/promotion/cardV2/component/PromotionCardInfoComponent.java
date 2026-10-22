package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.PromotionCardInfoLineContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/component/PromotionCardInfoComponent;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "arg", "", "setArgument", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/a;", "ability", "setContainerAbility", "", "getInfoAreaContentDescription", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardInfoComponent extends LinearLayout {
    public final List<PromotionCardInfoLineContainer> a;
    public LivePromotionCardArgsV2 b;
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a c;

    public PromotionCardInfoComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromotionCardInfoComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final String getInfoAreaContentDescription() {
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.append(((PromotionCardInfoLineContainer) r1.next()).getLineContentDescription());
        goto L4
    L7:
        return r0.toString();
    }

    public final void setArgument(LivePromotionCardArgsV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "arg");
        this.b = r2;
    }

    public final void setContainerAbility(com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.c = r2;
    }

    public PromotionCardInfoComponent(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
    }

    public /* synthetic */ PromotionCardInfoComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
