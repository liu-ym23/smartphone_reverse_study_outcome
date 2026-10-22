package vq4;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.aipolish.TextAiPolishEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.c;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends c<TextAiPolishEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f556770d;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<TextAiPolishEditorModel> c() {
        return TextAiPolishEditorModel.class;
    }

    public a(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f556770d = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final g d(CommonEditorModel r100) {
        Intrinsics.checkNotNullParameter((TextAiPolishEditorModel) r100, "data");
        return new b(this.f556770d, this.f209381c);
    }
}
