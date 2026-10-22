package com.bytedance.ee.bear.bitable.celleditor.editor.select;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h extends com.bytedance.ee.bear.bitable.celleditor.editor.c<SelectEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f209472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f209473e;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<SelectEditorModel> c() {
        return SelectEditorModel.class;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b e() {
        return this.f209473e;
    }

    public h(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f209472d = r100;
        this.f209473e = new e();
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final com.bytedance.ee.bear.bitable.celleditor.editor.g d(CommonEditorModel r100) {
        SelectEditorModel r101 = (SelectEditorModel) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        hr4.a r102 = this.f209472d;
        e r103 = this.f209473e;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.celleditor.editor.select.SelectEditorActionHandler");
        i r104 = new i(r102, r103);
        r104.f209477s = new f(this, r101);
        r104.f486402f = new g(this, r101);
        return r104;
    }
}
