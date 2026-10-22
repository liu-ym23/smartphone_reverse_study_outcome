package l55;

import com.bytedance.ee.bear.drive.biz.importfile.request.StartImportRequesterManagerImplV2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ StartImportRequesterManagerImplV2 a;

    public k(StartImportRequesterManagerImplV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        wwc.c r4 = (wwc.c) r3;
        StartImportRequesterManagerImplV2 r5 = this.a;
        r5.d.a(r5.f.a, "start_import_file");
    }
}
