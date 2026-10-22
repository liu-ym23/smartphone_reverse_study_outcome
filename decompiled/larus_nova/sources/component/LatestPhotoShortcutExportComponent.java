package component;

import com.larus.bmhome.chat.component.bottom.multimodal.latest.LatestPhotoShortcutComponent;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcomponent/LatestPhotoShortcutExportComponent;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutComponent;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LatestPhotoShortcutExportComponent extends LatestPhotoShortcutComponent {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f464590y;

    public LatestPhotoShortcutExportComponent() {
        this.f464590y = R.id.stub_latest_photo_shortcut;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f464590y;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f464590y = r100;
    }
}
