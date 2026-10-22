package com.bytedance.ee.bear.bitable.celleditor.editor.link;

import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.data.BitableLinkTableUpdateData;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/link/LinkEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "", "<init>", "()V", "title", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "status", "", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "emptyModel", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getEmptyModel", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setEmptyModel", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "addable", "", "getAddable", "()Ljava/lang/Boolean;", "setAddable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showAddRecordText", "getShowAddRecordText", "setShowAddRecordText", "showNoPermissionRecordTip", "getShowNoPermissionRecordTip", "setShowNoPermissionRecordTip", "viewData", "Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/data/BitableLinkTableUpdateData;", "getViewData", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/data/BitableLinkTableUpdateData;", "setViewData", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/data/BitableLinkTableUpdateData;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkEditorModel extends CommonEditorModel<List<? extends String>> {
    private Boolean addable;
    private SimpleItemModel emptyModel;
    private Boolean showAddRecordText;
    private Boolean showNoPermissionRecordTip;
    private Integer status;
    private String title;
    private BitableLinkTableUpdateData viewData;

    public LinkEditorModel() {
    }

    public final Boolean getAddable() {
        return this.addable;
    }

    public final SimpleItemModel getEmptyModel() {
        return this.emptyModel;
    }

    public final Boolean getShowAddRecordText() {
        return this.showAddRecordText;
    }

    public final Boolean getShowNoPermissionRecordTip() {
        return this.showNoPermissionRecordTip;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final BitableLinkTableUpdateData getViewData() {
        return this.viewData;
    }

    public final void setAddable(Boolean r100) {
        this.addable = r100;
    }

    public final void setEmptyModel(SimpleItemModel r100) {
        this.emptyModel = r100;
    }

    public final void setShowAddRecordText(Boolean r100) {
        this.showAddRecordText = r100;
    }

    public final void setShowNoPermissionRecordTip(Boolean r100) {
        this.showNoPermissionRecordTip = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setViewData(BitableLinkTableUpdateData r100) {
        this.viewData = r100;
    }
}
