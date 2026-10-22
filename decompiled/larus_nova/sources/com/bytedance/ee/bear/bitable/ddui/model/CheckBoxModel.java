package com.bytedance.ee.bear.bitable.ddui.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/CheckBoxModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "checked", "", "getChecked", "()Ljava/lang/Boolean;", "setChecked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CheckBoxModel extends BaseWidgetModel {
    private Boolean checked;

    public CheckBoxModel() {
    }

    public final Boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(Boolean r100) {
        this.checked = r100;
    }
}
