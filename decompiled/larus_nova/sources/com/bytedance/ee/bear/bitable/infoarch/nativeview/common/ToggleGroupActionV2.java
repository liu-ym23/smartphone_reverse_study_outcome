package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import com.bytedance.ee.bear.bitable.uikit.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ToggleGroupActionV2;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "groupPosition", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "<init>", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;)V", "getGroupPosition", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "setGroupPosition", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToggleGroupActionV2 extends Action {
    private GroupPosition groupPosition;

    public final GroupPosition getGroupPosition() {
        return this.groupPosition;
    }

    public ToggleGroupActionV2(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "groupPosition");
        super(null, "toggleGroup");
        this.groupPosition = r100;
    }

    public final void setGroupPosition(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupPosition = r100;
    }
}
