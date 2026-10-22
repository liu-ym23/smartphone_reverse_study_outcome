package wq4;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.barcode.BarcodeEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.c;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends c<BarcodeEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f560692d;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<BarcodeEditorModel> c() {
        return BarcodeEditorModel.class;
    }

    public a(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f560692d = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final g d(CommonEditorModel r100) {
        BarcodeEditorModel r101 = (BarcodeEditorModel) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        return new b(this.f560692d, this.f209381c, r101.getInputType());
    }
}
