package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewTabItemData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "tabName", "", "getTabName", "()Ljava/lang/String;", "setTabName", "(Ljava/lang/String;)V", "switchPayload", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getSwitchPayload", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setSwitchPayload", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "equals", "", "other", "", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewTabItemData implements NonProguard {
    private ActionPayload switchPayload;
    private String tabName;

    public int hashCode() {
        int r100 = this.tabName.hashCode() * 31;
        ActionPayload r101 = this.switchPayload;
        int r102 = 0;
        if (r101 == null) goto L7;
        String r103 = r101.getRecordId();
        if (r103 == null) goto L7;
        int r104 = r103.hashCode();
    L8:
        int r105 = r100 + r104;
        ActionPayload r106 = this.switchPayload;
        if (r106 == null) goto L14;
        String r107 = r106.getRenderId();
        if (r107 == null) goto L14;
        r102 = r107.hashCode();
    L14:
        return r105 + r102;
    L7:
        r104 = 0;
        goto L8
    }

    public ItemViewTabItemData() {
        this.tabName = "";
    }

    public final ActionPayload getSwitchPayload() {
        return this.switchPayload;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        String r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ItemViewTabItemData.class, r102) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.itemview.record.ItemViewTabItemData");
        ItemViewTabItemData r103 = (ItemViewTabItemData) r100;
        if (Intrinsics.areEqual(this.tabName, r103.tabName) == true) goto L15;
        return false;
    L15:
        ActionPayload r104 = this.switchPayload;
        if (r104 == null) goto L18;
        String r105 = r104.getRecordId();
    L19:
        ActionPayload r106 = r103.switchPayload;
        if (r106 == null) goto L22;
        String r107 = r106.getRecordId();
    L24:
        if (Intrinsics.areEqual(r105, r107) == true) goto L26;
        return false;
    L26:
        ActionPayload r108 = this.switchPayload;
        if (r108 == null) goto L29;
        String r109 = r108.getRenderId();
    L30:
        ActionPayload r110 = r103.switchPayload;
        if (r110 == null) goto L34;
        r101 = r110.getRenderId();
    L34:
        return Intrinsics.areEqual(r109, r101);
    L29:
        r109 = null;
        goto L30
    L22:
        r107 = null;
        goto L24
    L18:
        r105 = null;
        goto L19
    L8:
        r102 = null;
        goto L10
    }

    public final void setSwitchPayload(ActionPayload r100) {
        this.switchPayload = r100;
    }

    public final void setTabName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabName = r100;
    }
}
