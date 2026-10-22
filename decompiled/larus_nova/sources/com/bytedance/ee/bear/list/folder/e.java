package com.bytedance.ee.bear.list.folder;

import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;

/* JADX INFO: loaded from: classes18.dex */
public interface e extends com.bytedance.ee.bear.list.list.f<a> {

    public interface a extends com.bytedance.ee.bear.list.list.f.a, ForbiddenBannerView.a {
        void k(rf5.d r100);
    }

    void F7(ShareFolderUserPermission r100);

    void Z0();

    void f0(ForbiddenBannerView.ForbiddenState r100);

    void j();

    void u(Document r100);

    boolean x();
}
