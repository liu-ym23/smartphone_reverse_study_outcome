package com.bytedance.ee.bear.bitable.panel;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0007R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/GroupInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "groupId", "", "groupName", "(Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getGroupName", "setGroupName", "bottomDesc", "getBottomDesc", "setBottomDesc", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupInfo implements NonProguard {
    private String bottomDesc;
    private String groupId;
    private String groupName;

    public GroupInfo() {
    }

    public final String getBottomDesc() {
        return this.bottomDesc;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setBottomDesc(String r100) {
        this.bottomDesc = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setGroupName(String r100) {
        this.groupName = r100;
    }

    public GroupInfo(String r100, String r101) {
        this.groupId = r100;
        this.groupName = r101;
    }
}
