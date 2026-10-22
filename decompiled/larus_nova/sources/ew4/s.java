package ew4;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.celleditor.editor.attachment.AttachmentEditorViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s implements y {
    public s() {
    }

    @Override // ew4.y
    public final void openAlbum(FragmentActivity r100, j r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ((AttachmentEditorViewModel.b) r102).onCancel();
    }

    @Override // ew4.y
    public final void openCamera(FragmentActivity r100, k r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "callback");
        r102.onCancel();
    }

    @Override // ew4.y
    public final void showFileSelector(FragmentActivity r100, n r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ((AttachmentEditorViewModel.b) r102).onCancel();
    }
}
