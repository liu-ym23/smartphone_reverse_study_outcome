package com.bytedance.ee.bear.bitable.card.view.cell.formgrid;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableMetaModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/TableQuestionConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "tableQuestionFields", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableMetaModel$FieldBean;", "Lkotlin/collections/ArrayList;", "getTableQuestionFields", "()Ljava/util/ArrayList;", "setTableQuestionFields", "(Ljava/util/ArrayList;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableQuestionConfig implements NonProguard {
    private ArrayList<TableMetaModel.FieldBean> tableQuestionFields;

    public TableQuestionConfig() {
    }

    public final ArrayList<TableMetaModel.FieldBean> getTableQuestionFields() {
        return this.tableQuestionFields;
    }

    public final void setTableQuestionFields(ArrayList<TableMetaModel.FieldBean> r100) {
        this.tableQuestionFields = r100;
    }
}
