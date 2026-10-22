package com.bytedance.ee.bear.bitable.infoarch.nativeview.performance;

import com.bytedance.ee.bear.bitable.core.infoarch.arch.SceneModel;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.SubViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends com.bytedance.ee.bear.bitable.statistic.common.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f213673e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final String f() {
        return "CardViewFpsConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final boolean b() {
        return !Intrinsics.areEqual(this.f213673e, SubViewType.LynxCalendar.getValue());
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.b
    public final String e() {
        String r100 = this.f213673e;
        if (Intrinsics.areEqual(r100, SceneModel.NativeCard) == false) goto L6;
        return "native_grid_card_scroll";
    L6:
        if (Intrinsics.areEqual(r100, SceneModel.NativeGrid) == false) goto L9;
        return "native_grid_scroll";
    L9:
        if (Intrinsics.areEqual(r100, SceneModel.NativeGallery) == false) goto L12;
        return "native_gallery_scroll";
    L12:
        if (Intrinsics.areEqual(r100, SubViewType.LynxCalendar.getValue()) == false) goto L17;
        return "calendar_lynx_view_open_30_sec";
    L17:
        return "native_grid_card_scroll";
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewType");
        this.f213673e = r100;
    }
}
