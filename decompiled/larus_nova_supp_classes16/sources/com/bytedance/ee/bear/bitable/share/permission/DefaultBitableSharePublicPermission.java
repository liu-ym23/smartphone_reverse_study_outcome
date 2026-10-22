package com.bytedance.ee.bear.bitable.share.permission;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/permission/DefaultBitableSharePublicPermission;", "Lcom/bytedance/ee/bear/bitable/share/permission/IBitableSharePublicPermission;", "<init>", "()V", "isLinkShareClose", "", "isLinkShareInternalEdit", "isLinkShareAnyoneEdit", "isLinkShareInternalRead", "isLinkShareAnyoneRead", "getlinkShareEntry", "", "getReportJson", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultBitableSharePublicPermission implements IBitableSharePublicPermission {
    public DefaultBitableSharePublicPermission() {
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public String getReportJson() {
        return "";
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public int getlinkShareEntry() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareAnyoneEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareAnyoneRead() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareClose() {
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareInternalEdit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareInternalRead() {
        return false;
    }
}
