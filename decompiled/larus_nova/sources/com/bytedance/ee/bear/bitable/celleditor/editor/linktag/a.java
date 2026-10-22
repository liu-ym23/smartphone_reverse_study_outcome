package com.bytedance.ee.bear.bitable.celleditor.editor.linktag;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends com.bytedance.ee.bear.bitable.celleditor.editor.c<LinkTagEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f209402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b f209403e;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<LinkTagEditorModel> c() {
        return LinkTagEditorModel.class;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b e() {
        return this.f209403e;
    }

    public a(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f209402d = r100;
        this.f209403e = new com.bytedance.ee.bear.bitable.celleditor.editor.b();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final g d(CommonEditorModel r100) {
        Intrinsics.checkNotNullParameter((LinkTagEditorModel) r100, "data");
        return new c(this.f209402d, this.f209403e);
    }
}
