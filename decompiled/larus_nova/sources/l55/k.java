package l55;

import com.bytedance.ee.bear.drive.biz.importfile.request.StartImportRequesterManagerImplV2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StartImportRequesterManagerImplV2 f507523a;

    public k(StartImportRequesterManagerImplV2 r100) {
        this.f507523a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        wwc.c r101 = (wwc.c) r100;
        StartImportRequesterManagerImplV2 r102 = this.f507523a;
        r102.f223066d.a(r102.f223068f.f224401a, "start_import_file");
    }
}
