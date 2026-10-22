package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IEditionUserPermission;", "Lcom/bytedance/ee/util/io/NonProguard;", "canRenameAndCreateEdition", "", "canOperateEntity", "getOwnerInfo", "Lcom/bytedance/ee/bear/share/export/OwnerInfo;", "getPermissionStatusCode", "", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IEditionUserPermission extends NonProguard {
    boolean canOperateEntity();

    boolean canRenameAndCreateEdition();

    OwnerInfo getOwnerInfo();

    int getPermissionStatusCode();
}
