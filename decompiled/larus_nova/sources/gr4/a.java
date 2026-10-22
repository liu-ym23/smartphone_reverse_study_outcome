package gr4;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.c;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import com.bytedance.ee.bear.bitable.celleditor.editor.voiceinput.VoiceInputEditorModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends c<VoiceInputEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f482364d;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<VoiceInputEditorModel> c() {
        return VoiceInputEditorModel.class;
    }

    public a(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f482364d = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final g d(CommonEditorModel r100) {
        Intrinsics.checkNotNullParameter((VoiceInputEditorModel) r100, "data");
        return new b(this.f482364d, this.f209381c);
    }
}
