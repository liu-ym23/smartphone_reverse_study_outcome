package com.bytedance.ee.bear.office.export.space;

import com.baidu.platform.comapi.map.MapController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class g {
    public static OfficeSpaceActionResult.NotHandled a(OfficeSpaceItem r100, OfficeSpaceEventSource r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "source");
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    }
}
