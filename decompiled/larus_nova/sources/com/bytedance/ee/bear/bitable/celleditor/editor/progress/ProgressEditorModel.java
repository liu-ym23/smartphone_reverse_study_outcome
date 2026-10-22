package com.bytedance.ee.bear.bitable.celleditor.editor.progress;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/progress/ProgressEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "<init>", "()V", "formatter", "", "getFormatter", "()Ljava/lang/String;", "setFormatter", "(Ljava/lang/String;)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getMax", "()Ljava/lang/Double;", "setMax", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "getMin", "setMin", "color", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "getColor", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "setColor", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProgressEditorModel extends CommonEditorModel<Double> {
    private FieldConfigMetaModel.CommonColor color;
    private String formatter;
    private Double max;
    private Double min;

    public ProgressEditorModel() {
    }

    public final FieldConfigMetaModel.CommonColor getColor() {
        return this.color;
    }

    public final String getFormatter() {
        return this.formatter;
    }

    public final Double getMax() {
        return this.max;
    }

    public final Double getMin() {
        return this.min;
    }

    public final void setColor(FieldConfigMetaModel.CommonColor r100) {
        this.color = r100;
    }

    public final void setFormatter(String r100) {
        this.formatter = r100;
    }

    public final void setMax(Double r100) {
        this.max = r100;
    }

    public final void setMin(Double r100) {
        this.min = r100;
    }
}
