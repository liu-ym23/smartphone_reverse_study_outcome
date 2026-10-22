package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00100\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/GroupHeaderData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "level", "", "getLevel", "()I", "setLevel", "(I)V", "lastLevelGroup", "", "getLastLevelGroup", "()Z", "setLastLevelGroup", "(Z)V", "color", "getColor", "setColor", "showTopDivider", "getShowTopDivider", "setShowTopDivider", "showBottomDivider", "getShowBottomDivider", "setShowBottomDivider", "isCollapsed", "setCollapsed", "groupPosition", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "getGroupPosition", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "setGroupPosition", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;)V", "height", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupHeaderData implements NonProguard {
    private String color;
    private GroupPosition groupPosition;
    private Integer height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f213371id;
    private boolean isCollapsed;
    private boolean lastLevelGroup;
    private int level;
    private String name;
    private boolean showBottomDivider;
    private boolean showTopDivider;

    public String toString() {
        return "GroupHeaderData(id=" + this.f213371id + ", name=" + this.name + ", level=" + this.level + ", isCollapsed=" + this.isCollapsed + ')';
    }

    public GroupHeaderData() {
        this.level = 1;
    }

    public final String getColor() {
        return this.color;
    }

    public final GroupPosition getGroupPosition() {
        return this.groupPosition;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.f213371id;
    }

    public final boolean getLastLevelGroup() {
        return this.lastLevelGroup;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getShowBottomDivider() {
        return this.showBottomDivider;
    }

    public final boolean getShowTopDivider() {
        return this.showTopDivider;
    }

    public final boolean isCollapsed() {
        return this.isCollapsed;
    }

    public final void setCollapsed(boolean r100) {
        this.isCollapsed = r100;
    }

    public final void setColor(String r100) {
        this.color = r100;
    }

    public final void setGroupPosition(GroupPosition r100) {
        this.groupPosition = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setId(String r100) {
        this.f213371id = r100;
    }

    public final void setLastLevelGroup(boolean r100) {
        this.lastLevelGroup = r100;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setShowBottomDivider(boolean r100) {
        this.showBottomDivider = r100;
    }

    public final void setShowTopDivider(boolean r100) {
        this.showTopDivider = r100;
    }
}
