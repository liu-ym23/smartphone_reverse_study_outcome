package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements bf5.a {
    public r() {
    }

    @Override // bf5.a
    public final gj5.c a(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return f("CCM_ATTACHMENT_UPLOAD", 12, r3);
    }

    @Override // bf5.a
    public final gj5.c b(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return f("CCM_FILE_PREVIEW", 12, r3);
    }

    @Override // bf5.a
    public final gj5.c d(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return f("CCM_ATTACHMENT_DOWNLOAD", 12, r3);
    }

    @Override // bf5.a
    public final gj5.c e(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return f("CCM_CONTENT_COPY", r2, r3);
    }

    public static gj5.c f(@EntityOperate String r3, int r4, String r5) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(r3, FileBizDomain.FileBizDomainCCM, r4, r5);
    }

    @Override // bf5.a
    public final PermissionResponse c(int r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.OPT);
        BaseEntity r1 = new BaseEntity(r5, sbb.e.d(r4), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r1, r6), null);
    }
}
