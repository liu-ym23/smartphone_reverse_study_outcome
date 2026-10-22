package er4;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.c;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import com.bytedance.ee.bear.bitable.celleditor.editor.rating.RatingEditorModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends c<RatingEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f473583d;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<RatingEditorModel> c() {
        return RatingEditorModel.class;
    }

    public a(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f473583d = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final g d(CommonEditorModel r100) {
        Intrinsics.checkNotNullParameter((RatingEditorModel) r100, "data");
        return new b(this.f473583d, this.f209381c);
    }
}
