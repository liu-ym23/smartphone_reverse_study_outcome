package com.bytedance.ee.bear.bitable.celleditor.editor.rating;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/rating/RatingEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "<init>", "()V", "fieldName", "", "getFieldName", "()Ljava/lang/String;", "setFieldName", "(Ljava/lang/String;)V", "ratingSymbolId", "getRatingSymbolId", "setRatingSymbolId", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "getMin", "()Ljava/lang/Integer;", "setMin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getMax", "setMax", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RatingEditorModel extends CommonEditorModel<Integer> {
    private String fieldName;
    private Integer max;
    private Integer min;
    private String ratingSymbolId;

    public RatingEditorModel() {
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getMin() {
        return this.min;
    }

    public final String getRatingSymbolId() {
        return this.ratingSymbolId;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setMax(Integer r100) {
        this.max = r100;
    }

    public final void setMin(Integer r100) {
        this.min = r100;
    }

    public final void setRatingSymbolId(String r100) {
        this.ratingSymbolId = r100;
    }
}
