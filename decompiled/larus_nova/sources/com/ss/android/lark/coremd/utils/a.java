package com.ss.android.lark.coremd.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f419964a = 0;

    static {
    }

    public static float d(y9b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        if ((r100 instanceof y9b.c) == false) goto L5;
        float r101 = r100.f419934a.f419947j;
        Paint r102 = e.f419972c;
        r102.setTypeface(Typeface.MONOSPACE);
        r102.setTextSize(r101);
        return r102.measureText("•") / 2.0f;
    L5:
        String r103 = r100.e();
        float r104 = r100.f419934a.f419947j;
        Paint r105 = e.f419972c;
        r105.setTypeface(Typeface.MONOSPACE);
        r105.setTextSize(r104);
        return r105.measureText(r103);
    }

    public static int b(Context r100, y9b.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "span");
        if ((r101 instanceof y9b.b) == false) goto L6;
        return UIUtils.getDimens(r100, R.dimen.li_prefix_mark_num_margin);
    L6:
        if ((r101 instanceof y9b.c) == true) goto L11;
        return 0;
    L11:
        return UIUtils.getDimens(r100, R.dimen.li_prefix_mark_ul_left_margin);
    }

    public static int a(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 >= 0) goto L5;
        int r103 = UIUtils.dp2px(r100, 24.0f);
    L7:
        return MathKt.roundToInt(r103 * r102);
    L5:
        r103 = UIUtils.dp2px(r100, r101);
        goto L7
    }

    public static int c(Context r100, y9b.a r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "span");
        if ((r101 instanceof y9b.c) == false) goto L10;
        Paint r103 = e.f419972c;
        r103.setTypeface(Typeface.MONOSPACE);
        r103.setTextSize(UIUtils.getDimens(r100, R.dimen.local_font_size_default));
        if (r102 < 0.0f) goto L7;
        int r104 = UIUtils.dp2px(r100, r102);
    L17:
        return MathKt.roundToInt((((r103.measureText("aa") + UIUtils.getDimens(r100, R.dimen.li_prefix_mark_num_margin)) + r104) - UIUtils.getDimens(r100, R.dimen.li_prefix_mark_common_width)) - UIUtils.getDimens(r100, R.dimen.li_prefix_mark_ul_left_margin));
    L7:
        r104 = UIUtils.getDimens(r100, R.dimen.li_prefix_mark_num_margin);
        goto L17
    L10:
        if ((r101 instanceof y9b.b) == true) goto L12;
        return 0;
    L12:
        if (r102 <= 0.0f) goto L19;
        return UIUtils.dp2px(r100, r102);
    L19:
        return UIUtils.getDimens(r100, R.dimen.li_prefix_mark_num_margin);
    }
}
