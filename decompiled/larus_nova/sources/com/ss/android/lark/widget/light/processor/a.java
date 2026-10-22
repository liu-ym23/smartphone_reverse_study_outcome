package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.graphics.DashPathEffect;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements j<AbbreviationInfo> {

    /* JADX INFO: renamed from: com.ss.android.lark.widget.light.processor.a$a, reason: collision with other inner class name */
    public static final class C5396a {
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        AbbreviationInfo r104 = (AbbreviationInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        String r105 = r104.name;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.lingo.message_underline_fix") == false) goto L5;
        r101.b(r105, new com.ss.android.lark.widget.linked_emojicon.widget.b(UIUtils.getColor(r100, R.color.ud_N900_60), new DashPathEffect(new float[]{r104.intervalOn, r104.intervalOff}, 0.0f)), 33);
    L6:
        int r106 = r101.length();
        r101.setSpan(new com.ss.android.lark.widget.light.span.a(r104), r106 - r105.length(), r106, 33);
        return;
    L5:
        r101.b(r105, new com.ss.android.lark.widget.linked_emojicon.widget.a(r105, r100, r104.intervalOff, r104.intervalOn), 33);
        goto L6
    }
}
