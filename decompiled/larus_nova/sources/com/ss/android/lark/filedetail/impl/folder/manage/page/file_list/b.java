package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.larksuite.framework.callback.UIGetDataCallback;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f421761a;

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j.a
    public final int M() {
        return this.f421761a.getModel().M();
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j.a
    public final boolean o0() {
        return this.f421761a.getModel().w2();
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j.a
    public final void onLoadMore() {
        this.f421761a.getModel().m6(new UIGetDataCallback(this.f421761a.f421760d));
    }

    public b(a r100) {
        this.f421761a = r100;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.page.file_list.j.a
    public final void U(int r100) {
        this.f421761a.getModel().U(r100);
    }
}
