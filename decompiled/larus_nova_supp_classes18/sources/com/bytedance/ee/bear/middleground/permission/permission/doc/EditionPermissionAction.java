package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/EditionPermissionAction;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "operate_entity", "", "manage_version", "<init>", "(II)V", "getOperate_entity", "()I", "setOperate_entity", "(I)V", "getManage_version", "canRenameAndCreateEdition", "", "canOperateEntity", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "Companion", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditionPermissionAction extends Result<Serializable> {
    public static final int ACTION_ALLOW = 1;
    public static final int ACTION_DENY = 2;
    public static final int ACTION_NONE = 0;
    public static final a Companion = null;
    private final int manage_version;
    private int operate_entity;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EditionPermissionAction() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ EditionPermissionAction copy$default(EditionPermissionAction r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.operate_entity;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.manage_version;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.operate_entity;
    }

    public final int component2() {
        return this.manage_version;
    }

    public final EditionPermissionAction copy(int r2, int r3) {
        return new EditionPermissionAction(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EditionPermissionAction) == true) goto L8;
        return false;
    L8:
        EditionPermissionAction r6 = (EditionPermissionAction) r5;
        if (this.operate_entity == r6.operate_entity) goto L12;
        return false;
    L12:
        if (this.manage_version == r6.manage_version) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.operate_entity * 31) + this.manage_version;
    }

    public String toString() {
        return "EditionPermissionAction(operate_entity=" + this.operate_entity + ", manage_version=" + this.manage_version + ')';
    }

    public final boolean canOperateEntity() {
        if (this.operate_entity == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canRenameAndCreateEdition() {
        if (this.manage_version == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int getManage_version() {
        return this.manage_version;
    }

    public final int getOperate_entity() {
        return this.operate_entity;
    }

    public final void setOperate_entity(int r1) {
        this.operate_entity = r1;
    }

    public EditionPermissionAction(int r1, int r2) {
        this.operate_entity = r1;
        this.manage_version = r2;
    }

    public /* synthetic */ EditionPermissionAction(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }
}
