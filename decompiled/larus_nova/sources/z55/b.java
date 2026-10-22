package z55;

import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements c {
    public b() {
    }

    @Override // z55.c
    public final void a(ViewOwner r100) {
        if (r100 == null) goto L7;
        DriveBlockPreviewVM r101 = (DriveBlockPreviewVM) r100.viewModel(DriveBlockPreviewVM.class);
        if (r101 == null) goto L8;
        r101.removeAllBlockClickInterceptor();
        return;
    L8:
        return;
    }
}
