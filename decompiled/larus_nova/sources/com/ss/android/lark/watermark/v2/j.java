package com.ss.android.lark.watermark.v2;

import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements q<FrameLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f445552a = null;

    static {
        f445552a = new j();
    }

    public j() {
    }

    @Override // com.ss.android.lark.watermark.v2.q
    public final void a(FrameLayout r100) {
        FrameLayout r101 = r100;
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        r101.setForeground(null);
    }

    @Override // com.ss.android.lark.watermark.v2.q
    public final boolean b(u r100, FrameLayout r101) {
        FrameLayout r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        r102.setForeground(r100);
        Log.i("watermark", "FrameLayoutForegroundViewBinder.bind:true");
        return true;
    }
}
