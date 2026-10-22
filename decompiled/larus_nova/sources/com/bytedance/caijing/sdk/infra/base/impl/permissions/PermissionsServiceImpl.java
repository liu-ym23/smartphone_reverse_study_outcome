package com.bytedance.caijing.sdk.infra.base.impl.permissions;

import be4.a;
import com.bytedance.caijing.sdk.infra.base.api.permissions.PermissionsService;
import com.bytedance.permissions.annotation.PermissionsRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/permissions/PermissionsServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/permissions/PermissionsService;", "Lbe4/a;", "callBack", "", "rpSceneUploadIdCard", "rpSceneCJJsbPickFile", "", "scene", "permissionsRequest", "<init>", "()V", "cj-host-service-impl-permissions_release"}, k = 1, mv = {1, 6, 0})
public final class PermissionsServiceImpl implements PermissionsService {
    public PermissionsServiceImpl() {
    }

    @PermissionsRequest(forceAllPermissionsRequest = true, scene = "cj_jsb_pick_file")
    private final void rpSceneCJJsbPickFile(a r100) {
        if (r100 == null) goto L5;
        r100.execute();
        return;
    }

    @PermissionsRequest(forceAllPermissionsRequest = true, scene = "upload_id_card")
    private final void rpSceneUploadIdCard(a r100) {
        if (r100 == null) goto L5;
        r100.execute();
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.permissions.PermissionsService
    public void permissionsRequest(String r100, a r101) {
        if (Intrinsics.areEqual(r100, "upload_id_card") == false) goto L6;
        rpSceneUploadIdCard(r101);
        return;
    L6:
        if (Intrinsics.areEqual(r100, "cj_jsb_pick_file") == false) goto L10;
        rpSceneCJJsbPickFile(r101);
        return;
    }
}
