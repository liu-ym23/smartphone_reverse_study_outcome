package com.ss.android.lark.watermark.v2;

import android.app.Activity;
import android.app.Dialog;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class r {
    public static final <T> q<T> a(T r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if ((r100 instanceof Activity) == false) goto L6;
        q<T> r101 = b.f445534a;
    L14:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.watermark.v2.WatermarkBinder<T of com.ss.android.lark.watermark.v2.WatermarkBindersKt.createWatermarkBinderForTarget>");
        return r101;
    L6:
        if ((r100 instanceof Fragment) == false) goto L9;
        r101 = i.f445551a;
        goto L14
    L9:
        if ((r100 instanceof Dialog) == false) goto L12;
        r101 = e.f445543a;
        goto L14
    L12:
        if ((r100 instanceof FrameLayout) == false) goto L17;
        r101 = j.f445552a;
        goto L14
    L17:
        throw new UnsupportedOperationException("Target class " + r100.getClass() + " is not supported");
    }
}
