package z55;

import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements c {
    public b() {
    }

    @Override // z55.c
    public final void a(ViewOwner r2) {
        if (r2 == null) goto L7;
        DriveBlockPreviewVM r3 = (DriveBlockPreviewVM) r2.viewModel(DriveBlockPreviewVM.class);
        if (r3 == null) goto L8;
        r3.removeAllBlockClickInterceptor();
        return;
    L8:
        return;
    }
}
