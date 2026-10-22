package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.bitable.common.model.field.OriginStageOptionItem;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemRenderData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "selectOptionId", "", "getSelectOptionId", "()Ljava/lang/String;", "setSelectOptionId", "(Ljava/lang/String;)V", WsConstants.KEY_PAYLOAD, "Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageActionPayload;", "getPayload", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageActionPayload;", "setPayload", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageActionPayload;)V", "switchPayload", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getSwitchPayload", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setSwitchPayload", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "currentButtonColor", "getCurrentButtonColor", "setCurrentButtonColor", "currentViewIndex", "", "stages", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/common/model/field/OriginStageOptionItem;", "Lkotlin/collections/ArrayList;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageTabItemRenderData implements NonProguard {
    private String currentButtonColor;
    private StageActionPayload payload;
    private String selectOptionId;
    private ActionPayload switchPayload;

    public StageTabItemRenderData() {
        this.selectOptionId = "";
    }

    public final String getCurrentButtonColor() {
        return this.currentButtonColor;
    }

    public final StageActionPayload getPayload() {
        return this.payload;
    }

    public final String getSelectOptionId() {
        return this.selectOptionId;
    }

    public final ActionPayload getSwitchPayload() {
        return this.switchPayload;
    }

    public final int currentViewIndex(ArrayList<OriginStageOptionItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "stages");
        Iterator<OriginStageOptionItem> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r101.next().getId(), this.selectOptionId) == true) goto L13;
        r102 = r102 + 1;
        goto L4
    L13:
        return r102;
    L9:
        return -1;
    }

    public final void setCurrentButtonColor(String r100) {
        this.currentButtonColor = r100;
    }

    public final void setPayload(StageActionPayload r100) {
        this.payload = r100;
    }

    public final void setSelectOptionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectOptionId = r100;
    }

    public final void setSwitchPayload(ActionPayload r100) {
        this.switchPayload = r100;
    }
}
