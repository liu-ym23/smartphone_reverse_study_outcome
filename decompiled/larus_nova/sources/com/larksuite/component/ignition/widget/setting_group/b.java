package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f284022a = 0;

    static {
    }

    public static void a(GradientDrawable r100, Context r110, boolean r111, boolean r112, float r113) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r111 == false) goto L7;
        if (r112 == false) goto L7;
        r100.setCornerRadii(new float[]{r113, r113, r113, r113, r113, r113, r113, r113});
        return;
    L7:
        if (r111 == false) goto L9;
        r100.setCornerRadii(new float[]{r113, r113, r113, r113, 0.0f, 0.0f, 0.0f, 0.0f});
        return;
    L9:
        if (r112 == false) goto L11;
        r100.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r113, r113, r113, r113});
        return;
    L11:
        r100.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
    }
}
