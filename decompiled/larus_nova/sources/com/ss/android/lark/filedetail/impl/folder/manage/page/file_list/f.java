package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.filedetail.dto.FolderManageLaunchParams;
import com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements FileInfoAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileListView f421766a;

    public f(FileListView r100) {
        this.f421766a = r100;
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter.b
    public final void a(nfb.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        int r101 = pfb.d.f529030a;
        pfb.d.a.e(this.f421766a.f421748k, "single_file", "none", pfb.d.a.a(r100.getType(), r100.f518977c, r100.f518978d));
        FileListView r102 = this.f421766a;
        FolderManageLaunchParams r103 = r102.f421740c;
        pfb.d.a.d(r103.f421495b, r102.f421745h, r103.f421498e);
        this.f421766a.f421739b.d(r100);
    }
}
