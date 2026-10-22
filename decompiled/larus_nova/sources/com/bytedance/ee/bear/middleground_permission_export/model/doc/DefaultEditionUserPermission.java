package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import com.bytedance.ee.bear.share.export.OwnerInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DefaultEditionUserPermission;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IEditionUserPermission;", "<init>", "()V", "canOperateEntity", "", "getPermissionStatusCode", "", "getOwnerInfo", "Lcom/bytedance/ee/bear/share/export/OwnerInfo;", "canRenameAndCreateEdition", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DefaultEditionUserPermission implements IEditionUserPermission {
    public DefaultEditionUserPermission() {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission
    public boolean canOperateEntity() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission
    public boolean canRenameAndCreateEdition() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission
    public OwnerInfo getOwnerInfo() {
        return null;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission
    public int getPermissionStatusCode() {
        return 0;
    }
}
