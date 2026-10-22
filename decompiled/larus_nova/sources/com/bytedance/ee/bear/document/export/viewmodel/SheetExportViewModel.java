package com.bytedance.ee.bear.document.export.viewmodel;

import com.bytedance.ee.bear.document.orientation.p;

/* JADX INFO: loaded from: classes16.dex */
public class SheetExportViewModel extends BaseExportViewModel<a> {

    public interface a extends BaseExportViewModel.a {
        void f();

        boolean h();

        void onOrientationSupportPanelDismiss(p r100);

        void onOrientationSupportPanelShowing(p r100);
    }

    public void onClickSheetLongImage() {
        Delegate r100 = this.delegate;
        if (r100 == 0) goto L6;
        ((a) r100).f();
        return;
    }

    public boolean shouldShowLongImage() {
        Delegate r100 = this.delegate;
        if (r100 != 0) goto L5;
        return false;
    L5:
        return ((a) r100).h();
    }

    public SheetExportViewModel() {
    }

    public void onOrientationSupportPanelDismiss(p r100) {
        Delegate r101 = this.delegate;
        if (r101 == 0) goto L6;
        ((a) r101).onOrientationSupportPanelDismiss(r100);
        return;
    }

    public void onOrientationSupportPanelShowing(p r100) {
        Delegate r101 = this.delegate;
        if (r101 == 0) goto L6;
        ((a) r101).onOrientationSupportPanelShowing(r100);
        return;
    }
}
