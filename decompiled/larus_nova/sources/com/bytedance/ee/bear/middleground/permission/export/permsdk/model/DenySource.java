package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenySource;", "", "denyType", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenyType;", "uiType", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiType;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenyType;Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiType;)V", "getDenyType", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenyType;", "setDenyType", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/DenyType;)V", "getUiType", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiType;", "setUiType", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiType;)V", "toString", "", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DenySource {
    private DenyType denyType;
    private UiType uiType;

    public String toString() {
        return "DenySource@" + hashCode() + "{denyType: " + this.denyType + ", uiType: " + this.uiType + '}';
    }

    public final DenyType getDenyType() {
        return this.denyType;
    }

    public final UiType getUiType() {
        return this.uiType;
    }

    public final void setDenyType(DenyType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.denyType = r100;
    }

    public final void setUiType(UiType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uiType = r100;
    }

    public DenySource(DenyType r100, UiType r101) {
        Intrinsics.checkNotNullParameter(r100, "denyType");
        Intrinsics.checkNotNullParameter(r101, "uiType");
        this.denyType = r100;
        this.uiType = r101;
    }
}
