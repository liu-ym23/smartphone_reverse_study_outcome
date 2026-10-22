package com.bytedance.ee.bear.bitable.share.permission;

import com.bytedance.ee.bear.contract.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/permission/BitableShareUserPermission;", "Lcom/bytedance/ee/bear/bitable/share/permission/IBitableShareUserPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "", "permitted", "<init>", "(Z)V", "getPermitted", "()Z", "canShare", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareUserPermission extends Result<Boolean> implements IBitableShareUserPermission {
    private final boolean permitted;

    public BitableShareUserPermission() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ BitableShareUserPermission copy$default(BitableShareUserPermission r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.permitted;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.permitted;
    }

    public final BitableShareUserPermission copy(boolean r2) {
        return new BitableShareUserPermission(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof BitableShareUserPermission) == true) goto L9;
        return false;
    L9:
        if (this.permitted == ((BitableShareUserPermission) r4).permitted) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.permitted == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "BitableShareUserPermission(permitted=" + this.permitted + ')';
    }

    @Override // com.bytedance.ee.bear.bitable.share.permission.IBitableShareUserPermission
    public boolean canShare() {
        return this.permitted;
    }

    public final boolean getPermitted() {
        return this.permitted;
    }

    public BitableShareUserPermission(boolean r1) {
        this.permitted = r1;
    }

    public /* synthetic */ BitableShareUserPermission(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
