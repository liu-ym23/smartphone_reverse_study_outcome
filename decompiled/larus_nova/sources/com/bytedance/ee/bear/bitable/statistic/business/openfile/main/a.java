package com.bytedance.ee.bear.bitable.statistic.business.openfile.main;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends tu4.a {
    @Override // tu4.a, com.bytedance.ee.bear.bitable.statistic.common.a
    public final List<String> e() {
        List<String> r100 = CollectionsKt.mutableListOf(new String[]{"OPEN_FILE_SDK_FIRST_PAINT", "BITABLE_SDK_BITABLE_IS_READY"});
        List<String> r101 = super.e();
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        r100.addAll(r101);
        return r100;
    }

    public a() {
    }

    @Override // tu4.a, com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r110, e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r100 = r112.getName();
        switch(r100.hashCode()) {
            case -1811396680: goto L38;
            case -1262924125: goto L35;
            case -1183222304: goto L32;
            case -792632841: goto L27;
            case 42894867: goto L24;
            case 662681293: goto L21;
            case 695961049: goto L18;
            case 878072250: goto L15;
            case 1454410420: goto L12;
            case 1749406524: goto L9;
            case 2026950017: goto L6;
            default: goto L43;
        };
    L6:
        if (r100.equals("LINK_DOCX_TEMPLATE_PRELOAD_START") == false) goto L43;
    L40:
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    L9:
        if (r100.equals("OPEN_FILE_SDK_FIRST_PAINT") == true) goto L40;
    L12:
        if (r100.equals("LINK_DOCX_END_RENDER") == true) goto L40;
    L15:
        if (r100.equals("LINK_DOCX_TEMPLATE_PRELOAD_END") == true) goto L40;
    L18:
        if (r100.equals("LINK_DOCX_CREATE_UI_END") == true) goto L40;
    L21:
        if (r100.equals("LINK_DOCX_START_RENDER") == true) goto L40;
    L24:
        if (r100.equals("LINK_DOCX_RENDER_CACHE") == false) goto L43;
    L27:
        if (r100.equals("POINT_VIEW_OR_BLOCK_SWITCH") == false) goto L43;
        d(r112, "OPEN_FILE_CANCEL", null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.CANCEL, "switchView", null, 96);
        return true;
    L32:
        if (r100.equals("LINK_DOCX_CREATE_UI_START") == true) goto L40;
    L35:
        if (r100.equals("BITABLE_SDK_BITABLE_IS_READY") == true) goto L40;
    L38:
        if (r100.equals("LINK_DOCX_FAIL") == true) goto L40;
    L43:
        return super.k(r110, r111, r112, r113);
    }
}
