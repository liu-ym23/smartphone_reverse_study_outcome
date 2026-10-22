package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class r implements bf5.a {
    public r() {
    }

    @Override // bf5.a
    public final gj5.c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return f("CCM_ATTACHMENT_UPLOAD", 12, r100);
    }

    @Override // bf5.a
    public final gj5.c b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return f("CCM_FILE_PREVIEW", 12, r100);
    }

    @Override // bf5.a
    public final gj5.c d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return f("CCM_ATTACHMENT_DOWNLOAD", 12, r100);
    }

    @Override // bf5.a
    public final gj5.c e(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        return f("CCM_CONTENT_COPY", r100, r101);
    }

    public static gj5.c f(@EntityOperate String r100, int r101, String r102) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(r100, FileBizDomain.FileBizDomainCCM, r101, r102);
    }

    @Override // bf5.a
    public final PermissionResponse c(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        BaseEntity r103 = new BaseEntity(r101, sbb.e.d(r100), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r103, r102), null);
    }
}
