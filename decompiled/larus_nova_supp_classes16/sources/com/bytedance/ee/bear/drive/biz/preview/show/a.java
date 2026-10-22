package com.bytedance.ee.bear.drive.biz.preview.show;

import com.bytedance.ee.bear.drive.biz.preview.DrivePreviewContentPlugin;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements Runnable {
    public final /* synthetic */ DrivePreviewShowResultPlugin a;

    public a(DrivePreviewShowResultPlugin r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrivePreviewContentPlugin r0 = (DrivePreviewContentPlugin) DrivePreviewShowResultPlugin.access$findPlugin(this.a, DrivePreviewContentPlugin.class);     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.updateShowingContentVisibility(8);     // Catch: Throwable -> L7
    L5:
        ((PreviewViewModel) DrivePreviewShowResultPlugin.access$viewModel(this.a, PreviewViewModel.class)).liveInnerReload().setValue(null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
