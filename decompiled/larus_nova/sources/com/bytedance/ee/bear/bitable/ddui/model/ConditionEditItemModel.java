package com.bytedance.ee.bear.bitable.ddui.model;

import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.e;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001e\u001a\u00020\u001fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/ddui/model/ConditionEditItemModel;", "Lcom/bytedance/ee/bear/bitable/ddui/model/BaseWidgetModel;", "<init>", "()V", "checked", "", "getChecked", "()Ljava/lang/Boolean;", "setChecked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "contentImg", "Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "getContentImg", "()Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;", "setContentImg", "(Lcom/bytedance/ee/bear/bitable/ddui/model/ImageWidgetModel;)V", RXScreenCaptureService.KEY_CONTENT_TEXT, "Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "getContentText", "()Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;", "setContentText", "(Lcom/bytedance/ee/bear/bitable/ddui/model/TextWidgetModel;)V", "rightIcon", "getRightIcon", "setRightIcon", "isSync", "()Z", "setSync", "(Z)V", "intoPanelItem", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelItem;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConditionEditItemModel extends BaseWidgetModel {
    private Boolean checked;
    private ImageWidgetModel contentImg;
    private TextWidgetModel contentText;
    private boolean isSync;
    private ImageWidgetModel rightIcon;

    public final BitablePanelItem intoPanelItem() {
        BitablePanelItem r100 = new BitablePanelItem();
        r100.setId(getOnClick());
        TextWidgetModel r101 = this.contentText;
        if (r101 == null) goto L5;
        String r102 = r101.getText();
    L6:
        r100.setLeftText(r102);
        e.c(r100, Intrinsics.areEqual(this.checked, Boolean.TRUE));
        e.a(r100);
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public ConditionEditItemModel() {
    }

    public final Boolean getChecked() {
        return this.checked;
    }

    public final ImageWidgetModel getContentImg() {
        return this.contentImg;
    }

    public final TextWidgetModel getContentText() {
        return this.contentText;
    }

    public final ImageWidgetModel getRightIcon() {
        return this.rightIcon;
    }

    public final boolean isSync() {
        return this.isSync;
    }

    public final void setChecked(Boolean r100) {
        this.checked = r100;
    }

    public final void setContentImg(ImageWidgetModel r100) {
        this.contentImg = r100;
    }

    public final void setContentText(TextWidgetModel r100) {
        this.contentText = r100;
    }

    public final void setRightIcon(ImageWidgetModel r100) {
        this.rightIcon = r100;
    }

    public final void setSync(boolean r100) {
        this.isSync = r100;
    }
}
