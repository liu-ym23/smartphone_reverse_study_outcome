package com.ss.android.lark.inline.ai.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f427703a = 0;

    static {
    }

    public static GradientDrawable a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{UDColorUtils.getAlphaColor(r100, R.color.bg_mask, 0.0f), UDColorUtils.getAlphaColor(r100, R.color.bg_mask, 0.2f)});
    }

    public static ColorDrawable b(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ColorDrawable(UDColorUtils.getAlphaColor(r100, R.color.bg_mask, 0.4f));
    }
}
