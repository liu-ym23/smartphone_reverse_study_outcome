package com.bytedance.ee.bear.share.externalshare.external;

import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ FolderShareExternalPresenter a;

    public d(FolderShareExternalPresenter r1) {
        this.a = r1;
    }

    public final Object apply(Object r12) {
        ShareFolderPermission r9 = (ShareFolderPermission) r12;
        Intrinsics.checkNotNullParameter(r9, "it");
        return new ShareFolderInfo(this.a.i.getType(), this.a.i.getUrl(), this.a.i.getToken(), this.a.i.getOwnerUid(), this.a.i.getCreateTime(), this.a.i.getSpaceId(), this.a.i.getOwnerTenantId(), this.a.i.getFolderVersion(), r9, false);
    }
}
