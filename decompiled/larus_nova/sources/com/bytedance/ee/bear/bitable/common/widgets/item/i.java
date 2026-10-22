package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements l {
    public i() {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.l
    public final void a(View r100, BitablePanelItem r101, com.bytedance.ee.bear.bitable.panel.m r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.l
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return new CommonItemView(r100.getContext(), null, 6, 0);
    }
}
