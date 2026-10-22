package com.ss.android.lark.filedetail.impl.folder.manage.page.title;

import android.view.View;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.officesdk.integrator.mock.FileDetailModuleDependencyMock;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FolderTitleFragment f421785a;

    public b(FolderTitleFragment r100) {
        this.f421785a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = pfb.d.f529030a;
        pfb.d.a.e(this.f421785a.f421769d.f421495b, "search", "none", null);
        com.ss.android.lark.storage.a r102 = FileDetailModule.f421460a;
        hfb.b r103 = FileDetailModule.a.a();
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.getSearchDependency() == null) goto L9;
        FileDetailModuleDependencyMock.f(this.f421785a.getContext(), this.f421785a.f421769d.f421495b);
        return;
    }
}
