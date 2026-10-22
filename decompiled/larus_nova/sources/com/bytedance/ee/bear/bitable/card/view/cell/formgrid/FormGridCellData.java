package com.bytedance.ee.bear.bitable.card.view.cell.formgrid;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableDataModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001e\u001a\u00020\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridCellData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "formGridUIData", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridUIData;", "getFormGridUIData", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridUIData;", "setFormGridUIData", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridUIData;)V", "recordLimitCount", "", "getRecordLimitCount", "()I", "setRecordLimitCount", "(I)V", "recordsCellData", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableDataModel$RecordsBean;", "Lkotlin/collections/ArrayList;", "getRecordsCellData", "()Ljava/util/ArrayList;", "setRecordsCellData", "(Ljava/util/ArrayList;)V", "canAddMore", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormGridCellData implements NonProguard {
    private FormGridUIData formGridUIData;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f207641id;
    private int recordLimitCount;
    private ArrayList<TableDataModel.RecordsBean> recordsCellData;

    public final boolean canAddMore() {
        if (this.formGridUIData.getRecordCount() >= this.recordLimitCount) goto L5;
        return true;
    L5:
        return false;
    }

    public FormGridCellData() {
        this.f207641id = "";
        this.formGridUIData = new FormGridUIData();
        this.recordLimitCount = 10;
        this.recordsCellData = new ArrayList();
    }

    public final FormGridUIData getFormGridUIData() {
        return this.formGridUIData;
    }

    public final String getId() {
        return this.f207641id;
    }

    public final int getRecordLimitCount() {
        return this.recordLimitCount;
    }

    public final ArrayList<TableDataModel.RecordsBean> getRecordsCellData() {
        return this.recordsCellData;
    }

    public final void setFormGridUIData(FormGridUIData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.formGridUIData = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f207641id = r100;
    }

    public final void setRecordLimitCount(int r100) {
        this.recordLimitCount = r100;
    }

    public final void setRecordsCellData(ArrayList<TableDataModel.RecordsBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordsCellData = r100;
    }
}
