package zq4;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.c;
import com.bytedance.ee.bear.bitable.celleditor.editor.date.DateEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends c<DateEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f573335d;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<DateEditorModel> c() {
        return DateEditorModel.class;
    }

    public a(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f573335d = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final g d(CommonEditorModel r100) {
        Intrinsics.checkNotNullParameter((DateEditorModel) r100, "data");
        return new b(this.f573335d, this.f209381c);
    }
}
