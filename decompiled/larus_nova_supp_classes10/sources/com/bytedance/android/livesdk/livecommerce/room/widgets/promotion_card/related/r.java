package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c {
    public final ExplainCardViewModel a;
    public final LifecycleOwner b;

    public final int modelType() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c
    public final QViewModel a() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c
    public final LifecycleOwner getLifecycleOwner() {
        return this.b;
    }

    public r(RelatedCardWidgetController r2) {
        this.a = r2.f;
        this.b = r2.i();
    }
}
