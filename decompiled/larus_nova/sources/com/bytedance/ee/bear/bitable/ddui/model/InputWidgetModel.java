package com.bytedance.ee.bear.bitable.ddui.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/InputWidgetModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "<init>", "()V", "leftIcon", "Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "getLeftIcon", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "setLeftIcon", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;)V", "onInputChanged", "", "getOnInputChanged", "()Ljava/lang/String;", "setOnInputChanged", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputWidgetModel extends TextWidgetModel {
    private ImageWidgetModel leftIcon;
    private String onInputChanged;

    public InputWidgetModel() {
    }

    public final ImageWidgetModel getLeftIcon() {
        return this.leftIcon;
    }

    public final String getOnInputChanged() {
        return this.onInputChanged;
    }

    public final void setLeftIcon(ImageWidgetModel r100) {
        this.leftIcon = r100;
    }

    public final void setOnInputChanged(String r100) {
        this.onInputChanged = r100;
    }
}
