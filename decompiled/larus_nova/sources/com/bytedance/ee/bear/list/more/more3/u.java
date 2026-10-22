package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V1SpaceFolderMoreProvider.b f228797a;

    public u(V1SpaceFolderMoreProvider.b r100) {
        this.f228797a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ShareFolderUserPermission r101 = (ShareFolderUserPermission) r100;
        Intrinsics.checkNotNullParameter(r101, "permission");
        tt5.a.h("V1SpaceFolderMoreProvider", "folderUserPermissionFlow ok");
        oj5.b r102 = this.f228797a.c();
        if (r102 == null) goto L5;
        r102.f523575t = r101;
    L5:
        V1SpaceFolderMoreProvider.b r103 = this.f228797a;
        r103.e(r103.c());
    }
}
