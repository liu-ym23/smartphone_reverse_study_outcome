package com.bytedance.locallife.live.goodsshelves.manager;

import com.bytedance.keva.Keva;
import com.bytedance.locallife.live.util.a0;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class ShelfGuessLikeTabPriorityStrategy implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f259683a;

    @Override // com.bytedance.locallife.live.goodsshelves.manager.m
    public final int getTabId() {
        Integer r100 = a0.a(((Keva) this.f259683a.getValue()).getString("live_life_shelf_tab_strategy", "5"), 5);
        if (r100 != null) goto L5;
        return 5;
    L5:
        return r100.intValue();
    }

    public ShelfGuessLikeTabPriorityStrategy() {
        this.f259683a = LazyKt.lazy(ShelfGuessLikeTabPriorityStrategy$localStorage$2.INSTANCE);
    }
}
