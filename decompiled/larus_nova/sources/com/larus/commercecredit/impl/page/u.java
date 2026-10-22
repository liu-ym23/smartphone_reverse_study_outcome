package com.larus.commercecredit.impl.page;

import android.view.View;
import android.webkit.WebView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommerceCreditWebFragment f325788a;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
    }

    public u(CommerceCreditWebFragment r100) {
        this.f325788a = r100;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        FLogger.f375446a.d("CommerceCreditWebFragment", "BottomSheet state changed: " + r101);
        WebView r102 = this.f325788a.f325736g;
        if (r102 == null) goto L6;
        r102.setTag(R.id.tag_web_view_scroll_top, Boolean.FALSE);
    L6:
        if (r101 != 5) goto L9;
        this.f325788a.y();
        return;
    }
}
