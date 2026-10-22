package e95;

import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ b.c a;

    public h(ArchivePreviewView.a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("ArchiveTreeDataLoader", "load() local file parse failed", r5, false);
        b.c r0 = this.a;
        Intrinsics.checkNotNull(r5);
        ((ArchivePreviewView.a) r0).a(r5);
    }
}
