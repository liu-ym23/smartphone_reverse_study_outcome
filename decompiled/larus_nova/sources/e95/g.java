package e95;

import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import com.bytedance.ee.bear.drive.view.preview.archive.ArchiveTree;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f471502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.c f471503b;

    public g(b r100, ArchivePreviewView.a r101) {
        this.f471502a = r100;
        this.f471503b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ArchiveTree r101 = (ArchiveTree) r100;
        z r102 = this.f471502a.f471490a;
        if (r101 == null) goto L5;
        r101.setName(com.bytedance.ee.util.io.a.d(r102.f225833a));
    L5:
        b.c r103 = this.f471503b;
        ArchivePreviewView.a r104 = (ArchivePreviewView.a) r103;
        r104.b(new com.bytedance.ee.bear.drive.view.preview.archive.a(r101));
    }
}
