package com.bytedance.ee.bear.bitable.celleditor.editor;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements hp4.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c<CommonEditorModel<?>> f209386a;

    public e(c<CommonEditorModel<?>> r100) {
        this.f209386a = r100;
    }

    @Override // hp4.g.a
    public final void onDismiss() {
        c.b(this.f209386a, true);
    }
}
