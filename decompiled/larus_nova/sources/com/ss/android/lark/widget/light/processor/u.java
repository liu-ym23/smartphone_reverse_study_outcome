package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.NumberTagInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class u implements j<NumberTagInfo> {

    public static final class a {
    }

    static {
    }

    public u() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r110, ncc.g r210, SpanInfo r211, com.ss.android.lark.widget.light.e r212) {
        NumberTagInfo r100 = (NumberTagInfo) r211;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "spanBuilder");
        Intrinsics.checkNotNullParameter(r100, "spanInfo");
        Intrinsics.checkNotNullParameter(r212, "params");
        String r101 = r100.text;
        if (r100.getDisableStyle() == false) goto L5;
        r210.a(r101);
        r210.setSpan(new ncc.h(r100), r210.length() - r100.text.length(), r210.length(), 33);
        return;
    L5:
        Map r111 = new ArrayMap();
        r111.put(pcc.a.class.getSimpleName(), new pcc.a(r110, r100.getTagBgColor(), r100.textColor, r100.getCircleSize(), r100.textSize, r100.getOriginalTextSize(), r110.getResources().getDimensionPixelSize(R.dimen.number_tag_background_white_padding_start), r110.getResources().getDimensionPixelSize(R.dimen.number_tag_background_white_padding_end), "", r100.textStyle));
        r210.c(r101, r111, 33);
        String r102 = r100.getUrl();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.length() <= 0) goto L10;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L20;
        UrlInfo r104 = new UrlInfo();
        r104.href = r102;
        Unit r105 = Unit.INSTANCE;
        r210.setSpan(new com.ss.android.lark.widget.light.span.d(new mcc.d.a("number_tag", null, r104, 2)), r210.length() - r101.length(), r210.length(), 33);
        return;
    L20:
        return;
    L10:
        r103 = false;
        goto L12
    }
}
