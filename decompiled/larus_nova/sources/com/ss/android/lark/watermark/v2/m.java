package com.ss.android.lark.watermark.v2;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.larksuite.framework.utils.RomUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements q<Activity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f445553a = null;

    static {
        f445553a = new m();
    }

    public m() {
    }

    @Override // com.ss.android.lark.watermark.v2.q
    public final void a(Activity r100) {
        Activity r101 = r100;
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (RomUtils.h() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 29) goto L13;
        View r102 = r101.findViewById(R.id.action_bar_root);
        if (r102 != null) goto L9;
        return;
    L9:
        if ((r102.getForeground() instanceof u) == false) goto L15;
        r102.setForeground(null);
        return;
    L15:
        return;
    }

    @Override // com.ss.android.lark.watermark.v2.q
    public final /* bridge */ /* synthetic */ boolean b(u r100, Activity r101) {
        return c(r100, r101);
    }

    public final boolean c(u r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (RomUtils.h() == true) goto L5;
    L10:
        Log.i("watermark", "MiuiCaptionViewWorkaroundBinder.bind:false");
        return false;
    L5:
        if (Build.VERSION.SDK_INT <= 29) goto L10;
        View r102 = r101.findViewById(R.id.action_bar_root);
        if (r102 == null) goto L10;
        r102.setForeground(r100);
        Log.i("watermark", "MiuiCaptionViewWorkaroundBinder.bind:true");
        return true;
    }
}
