package com.bytedance.ee.bear.middleground.comment.uitls;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements bf5.a {
    public q() {
    }

    @Override // bf5.a
    public final gj5.c a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    }

    @Override // bf5.a
    public final gj5.c b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    }

    @Override // bf5.a
    public final gj5.c d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    }

    @Override // bf5.a
    public final gj5.c e(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        return new gj5.c(true, FileAuthResultFrom.COME_FROM_AUTHZ);
    }

    @Override // bf5.a
    public final PermissionResponse c(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.OPT);
        PermissionResponse.Companion.getClass();
        return PermissionResponse.a.b();
    }
}
