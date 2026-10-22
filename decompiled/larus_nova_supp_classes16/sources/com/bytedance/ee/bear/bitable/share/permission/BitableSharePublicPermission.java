package com.bytedance.ee.bear.bitable.share.permission;

import com.bytedance.ee.bear.contract.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/permission/BitableSharePublicPermission;", "Lcom/bytedance/ee/bear/bitable/share/permission/IBitableSharePublicPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "", "linkShareEntity", "reportJson", "", "<init>", "(ILjava/lang/String;)V", "isLinkShareClose", "", "isLinkShareInternalEdit", "isLinkShareAnyoneEdit", "isLinkShareInternalRead", "isLinkShareAnyoneRead", "getlinkShareEntry", "getReportJson", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSharePublicPermission extends Result<Integer> implements IBitableSharePublicPermission {
    private final int linkShareEntity;
    private final String reportJson;

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareAnyoneEdit() {
        if (this.linkShareEntity != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareAnyoneRead() {
        if (this.linkShareEntity != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareClose() {
        if (this.linkShareEntity != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareInternalEdit() {
        if (this.linkShareEntity != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public boolean isLinkShareInternalRead() {
        if (this.linkShareEntity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public String getReportJson() {
        return this.reportJson;
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableSharePublicPermission
    public int getlinkShareEntry() {
        return this.linkShareEntity;
    }

    public BitableSharePublicPermission(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reportJson");
        this.linkShareEntity = r2;
        this.reportJson = r3;
    }
}
