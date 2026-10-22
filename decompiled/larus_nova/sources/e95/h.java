package e95;

import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.c f471504a;

    public h(ArchivePreviewView.a r100) {
        this.f471504a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e("ArchiveTreeDataLoader", "load() local file parse failed", r101, false);
        b.c r102 = this.f471504a;
        Intrinsics.checkNotNull(r101);
        ((ArchivePreviewView.a) r102).a(r101);
    }
}
