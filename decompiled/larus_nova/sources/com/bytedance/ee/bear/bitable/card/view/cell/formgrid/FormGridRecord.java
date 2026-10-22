package com.bytedance.ee.bear.bitable.card.view.cell.formgrid;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridCellData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridRecord;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "recordId", "", "getRecordId", "()Ljava/lang/String;", "setRecordId", "(Ljava/lang/String;)V", SlcCommonAction.KEY_PARAMS, "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridCellData;", "Lkotlin/collections/ArrayList;", "getFields", "()Ljava/util/ArrayList;", "setFields", "(Ljava/util/ArrayList;)V", "textIndex", "", "getTextIndex", "()Ljava/lang/Integer;", "setTextIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormGridRecord implements NonProguard {
    private ArrayList<GridCellData> fields;
    private String recordId;
    private Integer textIndex;

    public FormGridRecord() {
    }

    public final ArrayList<GridCellData> getFields() {
        return this.fields;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final Integer getTextIndex() {
        return this.textIndex;
    }

    public final void setFields(ArrayList<GridCellData> r100) {
        this.fields = r100;
    }

    public final void setRecordId(String r100) {
        this.recordId = r100;
    }

    public final void setTextIndex(Integer r100) {
        this.textIndex = r100;
    }
}
