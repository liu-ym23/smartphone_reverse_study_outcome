package e95;

import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import com.bytedance.ee.bear.drive.view.preview.archive.ArchiveTree;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ b.c b;

    public g(b r1, ArchivePreviewView.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        ArchiveTree r4 = (ArchiveTree) r3;
        z r0 = this.a.a;
        if (r4 == null) goto L5;
        r4.setName(com.bytedance.ee.util.io.a.d(r0.a));
    L5:
        b.c r1 = this.b;
        ArchivePreviewView.a r2 = (ArchivePreviewView.a) r1;
        r2.b(new com.bytedance.ee.bear.drive.view.preview.archive.a(r4));
    }
}
