package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import com.bytedance.ee.bear.bitable.common.model.field.OriginStageOptionItem;
import com.bytedance.ee.bear.bitable.uikit.ContextField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemCellData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "editable", "", "getEditable$annotations", "getEditable", "()Z", "setEditable", "(Z)V", "dataOptionId", "", "getDataOptionId", "()Ljava/lang/String;", "setDataOptionId", "(Ljava/lang/String;)V", "stages", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/common/model/field/OriginStageOptionItem;", "Lkotlin/collections/ArrayList;", "getStages", "()Ljava/util/ArrayList;", "setStages", "(Ljava/util/ArrayList;)V", "currentDataIndex", "", "getStageItemList", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageOptionItem;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageTabItemCellData implements NonProguard {
    private String dataOptionId;
    private boolean editable;
    private ArrayList<OriginStageOptionItem> stages;

    @ContextField
    public static /* synthetic */ void getEditable$annotations() {
    }

    public final int currentDataIndex() {
        Iterator<OriginStageOptionItem> r100 = this.stages.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r100.next().getId(), this.dataOptionId) == true) goto L13;
        r101 = r101 + 1;
        goto L4
    L13:
        return r101;
    L9:
        return -1;
    }

    public final List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> getStageItemList() {
        ArrayList<OriginStageOptionItem> r100 = this.stages;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(new com.bytedance.ee.bear.bitable.card.model.stmodel.field.d((OriginStageOptionItem) r102.next()));
        goto L4
    L6:
        return r101;
    }

    public StageTabItemCellData() {
        this.editable = true;
        this.dataOptionId = "";
        this.stages = new ArrayList();
    }

    public final String getDataOptionId() {
        return this.dataOptionId;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final ArrayList<OriginStageOptionItem> getStages() {
        return this.stages;
    }

    public final void setDataOptionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dataOptionId = r100;
    }

    public final void setEditable(boolean r100) {
        this.editable = r100;
    }

    public final void setStages(ArrayList<OriginStageOptionItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stages = r100;
    }
}
