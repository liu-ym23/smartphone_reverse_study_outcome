package com.bytedance.ee.bear.bitable.pro.roledetail;

import com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/RoleDetailItemData;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel;", "entityName", "", "entityPermission", "groupId", "showPermissionDesc", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "getEntityPermission", "setEntityPermission", "getShowPermissionDesc", "()Z", "setShowPermissionDesc", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoleDetailItemData extends GroupMultiItemModel {
    private String entityName;
    private String entityPermission;
    private boolean showPermissionDesc;

    public final String getEntityName() {
        return this.entityName;
    }

    public final String getEntityPermission() {
        return this.entityPermission;
    }

    public final boolean getShowPermissionDesc() {
        return this.showPermissionDesc;
    }

    public final void setEntityName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityName = r2;
    }

    public final void setEntityPermission(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityPermission = r2;
    }

    public final void setShowPermissionDesc(boolean r1) {
        this.showPermissionDesc = r1;
    }

    public RoleDetailItemData(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "entityName");
        Intrinsics.checkNotNullParameter(r3, "entityPermission");
        Intrinsics.checkNotNullParameter(r4, "groupId");
        super(r4);
        this.entityName = r2;
        this.entityPermission = r3;
        this.showPermissionDesc = r5;
    }

    public /* synthetic */ RoleDetailItemData(String r1, String r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = true;
    L5:
        this(r1, r2, r3, r4);
    }
}
