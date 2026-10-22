package com.bytedance.ee.bear.bitable.statistic.business.openfile.main;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends tu4.a {
    @Override // tu4.a, com.bytedance.ee.bear.bitable.statistic.common.a
    public final List<String> e() {
        List<String> r0 = CollectionsKt.mutableListOf(new String[]{"OPEN_FILE_SDK_FIRST_PAINT", "BITABLE_SDK_BITABLE_IS_READY"});
        List<String> r1 = super.e();
        if (r1 != null) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        r0.addAll(r1);
        return r0;
    }

    public a() {
    }

    @Override // tu4.a, com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r12, e r13, BitableStatisticEventModel$NormalPointModel r14, List<BitableStatisticEventModel$NormalPointModel> r16) {
        Intrinsics.checkNotNullParameter(r12, "logger");
        Intrinsics.checkNotNullParameter(r13, "trace");
        Intrinsics.checkNotNullParameter(r14, "currPoint");
        Intrinsics.checkNotNullParameter(r16, "allPoints");
        String r0 = r14.getName();
        switch(r0.hashCode()) {
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
        if (r0.equals("LINK_DOCX_TEMPLATE_PRELOAD_START") == false) goto L43;
    L40:
        d(r14, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r12, r13, r14, false, 24);
        return false;
    L9:
        if (r0.equals("OPEN_FILE_SDK_FIRST_PAINT") == true) goto L40;
    L12:
        if (r0.equals("LINK_DOCX_END_RENDER") == true) goto L40;
    L15:
        if (r0.equals("LINK_DOCX_TEMPLATE_PRELOAD_END") == true) goto L40;
    L18:
        if (r0.equals("LINK_DOCX_CREATE_UI_END") == true) goto L40;
    L21:
        if (r0.equals("LINK_DOCX_START_RENDER") == true) goto L40;
    L24:
        if (r0.equals("LINK_DOCX_RENDER_CACHE") == false) goto L43;
    L27:
        if (r0.equals("POINT_VIEW_OR_BLOCK_SWITCH") == false) goto L43;
        d(r14, "OPEN_FILE_CANCEL", null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r12, r13, r14, BitableStatisticConstant$Result.CANCEL, "switchView", null, 96);
        return true;
    L32:
        if (r0.equals("LINK_DOCX_CREATE_UI_START") == true) goto L40;
    L35:
        if (r0.equals("BITABLE_SDK_BITABLE_IS_READY") == true) goto L40;
    L38:
        if (r0.equals("LINK_DOCX_FAIL") == true) goto L40;
    L43:
        return super.k(r12, r13, r14, r16);
    }
}
