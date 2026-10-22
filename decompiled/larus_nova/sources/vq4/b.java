package vq4;

import com.bytedance.ee.bear.bitable.anniex.holder.BitableLynxViewHolder;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.aipolish.TextAiPolishEditorModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import ko4.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends com.bytedance.ee.bear.bitable.celleditor.editor.a<TextAiPolishEditorModel> {

    public final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f556771a;

        @Override // ko4.e
        public final void closePage() {
            this.f556771a.dismiss();
        }

        public a(b r100) {
            this.f556771a = r100;
        }
    }

    /* JADX INFO: renamed from: vq4.b$b, reason: collision with other inner class name */
    public static final class C8033b {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, hp4.g
    public final void dismiss() {
        tt5.a.h("TextAiPolishEditorPanel", "[BTAiTextPolishDebug] native polishPanel dismiss");
        super.dismiss();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.a, com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        tt5.a.h("TextAiPolishEditorPanel", "[BTAiTextPolishDebug] native polishPanel show");
        this.f486407k = true;
        super.show();
        BitableLynxViewHolder r100 = this.f209344s;
        if (r100 == null) goto L5;
        r100.i(e.class, new a(this));
    L5:
        this.f209345t.f210670b.setTitleBarVisible(false);
        this.f209345t.f210670b.m(false);
    }

    public b(hr4.a r100, com.bytedance.ee.bear.bitable.celleditor.editor.b r101) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        super(r100, r101, 12);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.a, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r101) {
        TextAiPolishEditorModel r102 = (TextAiPolishEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        super.b(r102, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.a, com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void g(CommonEditorModel r100, String r101) {
        TextAiPolishEditorModel r102 = (TextAiPolishEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        super.g(r102, r101);
    }
}
