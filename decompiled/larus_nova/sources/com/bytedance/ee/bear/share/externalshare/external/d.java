package com.bytedance.ee.bear.share.externalshare.external;

import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FolderShareExternalPresenter f237054a;

    public d(FolderShareExternalPresenter r100) {
        this.f237054a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        ShareFolderPermission r100 = (ShareFolderPermission) r110;
        Intrinsics.checkNotNullParameter(r100, "it");
        return new ShareFolderInfo(this.f237054a.f237037i.getType(), this.f237054a.f237037i.getUrl(), this.f237054a.f237037i.getToken(), this.f237054a.f237037i.getOwnerUid(), this.f237054a.f237037i.getCreateTime(), this.f237054a.f237037i.getSpaceId(), this.f237054a.f237037i.getOwnerTenantId(), this.f237054a.f237037i.getFolderVersion(), r100, false);
    }
}
