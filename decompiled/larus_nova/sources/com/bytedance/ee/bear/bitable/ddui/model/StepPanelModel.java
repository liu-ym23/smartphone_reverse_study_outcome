package com.bytedance.ee.bear.bitable.ddui.model;

import com.alipay.sdk.m.x.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/StepPanelModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "title", "Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;", "getTitle", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;", d.f25925o, "(Lcom/bytedance/ee/bear/bitable/ddui/model/TitleWidgetModel;)V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "panelStep", "getPanelStep", "setPanelStep", "content", "Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentModel;", "getContent", "()Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentModel;", "setContent", "(Lcom/bytedance/ee/bear/bitable/ddui/model/StepContentModel;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StepPanelModel extends BaseWidgetModel {
    private String action;
    private StepContentModel content;
    private String panelStep;
    private TitleWidgetModel title;

    public StepPanelModel() {
    }

    public final String getAction() {
        return this.action;
    }

    public final StepContentModel getContent() {
        return this.content;
    }

    public final String getPanelStep() {
        return this.panelStep;
    }

    public final TitleWidgetModel getTitle() {
        return this.title;
    }

    public final void setAction(String r100) {
        this.action = r100;
    }

    public final void setContent(StepContentModel r100) {
        this.content = r100;
    }

    public final void setPanelStep(String r100) {
        this.panelStep = r100;
    }

    public final void setTitle(TitleWidgetModel r100) {
        this.title = r100;
    }
}
