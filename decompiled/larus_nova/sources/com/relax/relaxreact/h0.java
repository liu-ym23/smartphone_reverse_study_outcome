package com.relax.relaxreact;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h0 {
    public static final ArrayList<SnapshotInstance> b(SnapshotInstance r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ArrayList<SnapshotInstance> r101 = com.bytedance.rts.kmp.foundation.i.b(new SnapshotInstance[0]);
        SnapshotInstance r102 = r100.f405450n;
    L3:
        if (r102 == null) goto L5;
        com.bytedance.rts.kmp.foundation.i.f(r101, r102);
        r102 = r102.f405453q;
        goto L3
    L5:
        return r101;
    }

    public static final void a(Map<String, Object> r100, String r101, String r102, Boolean r103, Boolean r104, Boolean r105, Double r106, Double r107, Double r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("item-key", r101);
    L5:
        if (r102 == null) goto L7;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("reuse-identifier", r102);
    L7:
        if (r103 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("sticky-top", r103);
    L9:
        if (r104 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("sticky-bottom", r104);
    L11:
        if (r105 == null) goto L13;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("full-span", r105);
    L13:
        if (r106 == null) goto L15;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("estimated-height", r106);
    L15:
        if (r107 == null) goto L17;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("estimated-height-px", r107);
    L17:
        if (r110 == null) goto L19;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("estimated-main-axis-size-px", r110);
    L19:
        if (r111 == null) goto L22;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("recyclable", r111);
        return;
    }
}
