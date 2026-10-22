package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.ArrayMap;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.linked_emojicon.roundspan.RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum;
import com.ss.android.lark.widget.span.LabelInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements j<LabelInfo> {
    public p() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r110, ncc.g r210, SpanInfo r211, com.ss.android.lark.widget.light.e r212) {
        LabelInfo r100 = (LabelInfo) r211;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "spanBuilder");
        Intrinsics.checkNotNullParameter(r100, "spanInfo");
        Intrinsics.checkNotNullParameter(r212, "params");
        String r101 = r100.text;
        Map r111 = new ArrayMap();
        int r102 = r100.mRadiusInDP;
        int r112 = r100.textSize;
        Typeface r103 = r100.textStyle;
        int r104 = r100.tagTextSize;
        int r105 = r100.textColor;
        int r106 = r100.textBgColor;
        RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum r113 = r100.mPADDING;
        int r114 = r100.mLeftMargin;
        int r107 = r100.index;
        if (r113 != RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum.LARGE) goto L5;
        int r115 = R.dimen.table_tag_horizontal_padding;
        int r116 = R.dimen.tag_background_white_padding_start_large;
        int r117 = R.dimen.tag_background_white_padding_end_large;
    L9:
        qcc.a r108 = new qcc.a(r110, r102, r106, r105, r103, r104, r115, r116, r117, r112, r113, r114);
        r111.put(qcc.a.class.getSimpleName(), r108);
        r210.c(r101, r111, 33);
        r210.setSpan(new ncc.h(r100), r210.length() - r101.length(), r210.length(), 33);
        return;
    L5:
        if (r107 != 0) goto L7;
        int r109 = R.dimen.first_header_tag_padding_start;
    L8:
        r115 = R.dimen.tag_horizontal_padding;
        r116 = r109;
        r117 = R.dimen.tag_background_white_padding_end;
        goto L9
    L7:
        r109 = R.dimen.tag_background_white_padding_start;
        goto L8
    }
}
