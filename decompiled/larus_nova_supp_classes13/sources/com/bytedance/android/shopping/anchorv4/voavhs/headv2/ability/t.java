package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t {
    public static final boolean a(s r3, int r4, Number r5, Number r6) {
        Intrinsics.checkNotNullParameter(r3, "$this$isMatchCellRatio");
        AnchorV4HeadV2VO r7 = r3.K10();
        Float r0 = null;
        if (r7 == null) goto L9;
        List<HeaderContentModel> r8 = r7.getCells();
        if (r8 == null) goto L9;
        HeaderContentModel r9 = (HeaderContentModel) CollectionsKt.getOrNull(r8, r4);
        if (r9 == null) goto L9;
        Float r10 = r9.getWHScale(false);
    L10:
        if (r5 == null) goto L15;
        if (r6 == null) goto L15;
        if (r6.floatValue() <= 0) goto L15;
        r0 = Float.valueOf(r5.floatValue() / r6.floatValue());
    L15:
        if (r10 == null) goto L21;
        if (r0 != null) goto L18;
        return false;
    L18:
        if (Math.abs(r10.floatValue() - r0.floatValue()) >= 0.01f) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L9:
        r10 = null;
        goto L10
    }
}
