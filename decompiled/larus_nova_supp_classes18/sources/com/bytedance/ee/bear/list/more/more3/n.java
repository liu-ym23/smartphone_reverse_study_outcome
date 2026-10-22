package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ SpaceFolderMoreProvider.b a;

    public n(SpaceFolderMoreProvider.b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ShareFolderUserPermission r4 = (ShareFolderUserPermission) r3;
        Intrinsics.checkNotNullParameter(r4, "permission");
        tt5.a.h("SpaceFolderMoreProvider", "folderUserPermissionFlow ok");
        oj5.b r0 = this.a.c();
        if (r0 == null) goto L5;
        r0.t = r4;
    L5:
        SpaceFolderMoreProvider.b r5 = this.a;
        r5.e(r5.c());
    }
}
