package com.bytedance.ee.bear.bitable.pro.roledetail;

import com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
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

    public final void setEntityName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entityName = r100;
    }

    public final void setEntityPermission(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.entityPermission = r100;
    }

    public final void setShowPermissionDesc(boolean r100) {
        this.showPermissionDesc = r100;
    }

    public RoleDetailItemData(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "entityName");
        Intrinsics.checkNotNullParameter(r101, "entityPermission");
        Intrinsics.checkNotNullParameter(r102, "groupId");
        super(r102);
        this.entityName = r100;
        this.entityPermission = r101;
        this.showPermissionDesc = r103;
    }

    public /* synthetic */ RoleDetailItemData(String r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = true;
    L5:
        this(r100, r101, r102, r103);
    }
}
