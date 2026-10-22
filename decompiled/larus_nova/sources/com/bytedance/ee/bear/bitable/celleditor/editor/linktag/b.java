package com.bytedance.ee.bear.bitable.celleditor.editor.linktag;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends BaseEditorPanel<LinkTagEditorModel> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinkTagEditorModel f209404p;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void f(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        throw null;
    }

    @Override // hp4.g
    public final View q(Context r100) {
        return this.f486399c;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r101) {
        LinkTagEditorModel r102 = (LinkTagEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        this.f209404p = r102;
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void g(CommonEditorModel r100, String r101) {
        LinkTagEditorModel r102 = (LinkTagEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        this.f209404p = r102;
        throw null;
    }
}
