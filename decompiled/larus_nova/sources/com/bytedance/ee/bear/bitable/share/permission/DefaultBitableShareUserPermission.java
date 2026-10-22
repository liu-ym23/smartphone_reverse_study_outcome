package com.bytedance.ee.bear.bitable.share.permission;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/permission/DefaultBitableShareUserPermission;", "Lcom/bytedance/ee/bear/bitable/share/permission/IBitableShareUserPermission;", "<init>", "()V", "canShare", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultBitableShareUserPermission implements IBitableShareUserPermission {
    public DefaultBitableShareUserPermission() {
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableShareUserPermission
    public boolean canShare() {
        return false;
    }
}
