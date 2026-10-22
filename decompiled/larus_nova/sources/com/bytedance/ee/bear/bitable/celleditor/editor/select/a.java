package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewItemAdapter.PreviewViewHolder f209460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SelectEditorModel.IEditorOption f209461b;

    public a(PreviewItemAdapter.PreviewViewHolder r100, SelectEditorModel.IEditorOption r101) {
        this.f209460a = r100;
        this.f209461b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PreviewItemAdapter.a r101 = this.f209460a.f209445a.invoke();
        if (r101 == null) goto L6;
        r101.a(this.f209461b.getId());
        return;
    }
}
