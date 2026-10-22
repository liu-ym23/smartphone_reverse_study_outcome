package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements bf5.a {
    public q() {
    }

    @Override // bf5.a
    public final gj5.c a(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    }

    @Override // bf5.a
    public final gj5.c b(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    }

    @Override // bf5.a
    public final gj5.c d(String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    }

    @Override // bf5.a
    public final gj5.c e(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    }

    @Override // bf5.a
    public final PermissionResponse c(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.OPT);
        PermissionResponse.Companion.getClass();
        return PermissionResponse.a.b();
    }
}
