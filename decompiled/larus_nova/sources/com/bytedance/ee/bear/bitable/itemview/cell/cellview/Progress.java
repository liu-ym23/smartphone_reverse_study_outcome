package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/Progress;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "color", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "getColor", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "setColor", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Progress implements NonProguard {
    private FieldConfigMetaModel.CommonColor color;

    public Progress() {
        this.color = new FieldConfigMetaModel.CommonColor();
    }

    public final FieldConfigMetaModel.CommonColor getColor() {
        return this.color;
    }

    public final void setColor(FieldConfigMetaModel.CommonColor r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.color = r100;
    }
}
