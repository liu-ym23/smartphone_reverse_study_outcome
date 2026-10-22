package com.bytedance.ee.bear.bitable.ddui.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/ConjunctionModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "left", "Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "getLeft", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "setLeft", "(Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;)V", "center", "Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionCellModel;", "getCenter", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionCellModel;", "setCenter", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionCellModel;)V", "right", "getRight", "setRight", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConjunctionModel extends BaseWidgetModel {
    private ConditionCellModel center;
    private TextWidgetModel left;
    private TextWidgetModel right;

    public ConjunctionModel() {
    }

    public final ConditionCellModel getCenter() {
        return this.center;
    }

    public final TextWidgetModel getLeft() {
        return this.left;
    }

    public final TextWidgetModel getRight() {
        return this.right;
    }

    public final void setCenter(ConditionCellModel r100) {
        this.center = r100;
    }

    public final void setLeft(TextWidgetModel r100) {
        this.left = r100;
    }

    public final void setRight(TextWidgetModel r100) {
        this.right = r100;
    }
}
