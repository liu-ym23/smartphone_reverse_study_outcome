package com.bytedance.ee.bear.document.export.viewmodel;

import com.bytedance.ee.bear.document.orientation.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SheetExportViewModel extends BaseExportViewModel<a> {

    public interface a extends BaseExportViewModel.a {
        void f();

        boolean h();

        void onOrientationSupportPanelDismiss(p r1);

        void onOrientationSupportPanelShowing(p r1);
    }

    public void onClickSheetLongImage() {
        Delegate r0 = this.delegate;
        if (r0 == 0) goto L6;
        ((a) r0).f();
        return;
    }

    public boolean shouldShowLongImage() {
        Delegate r0 = this.delegate;
        if (r0 != 0) goto L5;
        return false;
    L5:
        return ((a) r0).h();
    }

    public SheetExportViewModel() {
    }

    public void onOrientationSupportPanelDismiss(p r2) {
        Delegate r0 = this.delegate;
        if (r0 == 0) goto L6;
        ((a) r0).onOrientationSupportPanelDismiss(r2);
        return;
    }

    public void onOrientationSupportPanelShowing(p r2) {
        Delegate r0 = this.delegate;
        if (r0 == 0) goto L6;
        ((a) r0).onOrientationSupportPanelShowing(r2);
        return;
    }
}
