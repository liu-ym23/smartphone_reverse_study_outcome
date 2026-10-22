package ew4;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.celleditor.editor.attachment.AttachmentEditorViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements y {
    public s() {
    }

    @Override // ew4.y
    public final void openAlbum(FragmentActivity r2, j r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((AttachmentEditorViewModel.b) r4).onCancel();
    }

    @Override // ew4.y
    public final void openCamera(FragmentActivity r2, k r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "callback");
        r4.onCancel();
    }

    @Override // ew4.y
    public final void showFileSelector(FragmentActivity r2, n r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "callback");
        ((AttachmentEditorViewModel.b) r4).onCancel();
    }
}
