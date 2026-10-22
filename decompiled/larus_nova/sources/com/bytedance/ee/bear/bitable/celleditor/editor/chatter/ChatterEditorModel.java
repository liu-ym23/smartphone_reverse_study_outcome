package com.bytedance.ee.bear.bitable.celleditor.editor.chatter;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010%J\u0006\u0010&\u001a\u00020\rJ\u0006\u0010'\u001a\u00020\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/chatter/ChatterEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/chatter/ChatterEditorValue;", "<init>", "()V", "chatterType", "", "getChatterType", "()Ljava/lang/Integer;", "setChatterType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "notifiesEnable", "", "getNotifiesEnable", "()Ljava/lang/Boolean;", "setNotifiesEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showNotifyBarStyle", "getShowNotifyBarStyle", "setShowNotifyBarStyle", "canShowCreateGroup", "getCanShowCreateGroup", "setCanShowCreateGroup", "canShowChatterInfoIcon", "getCanShowChatterInfoIcon", "setCanShowChatterInfoIcon", "maxSelectCount", "getMaxSelectCount", "setMaxSelectCount", "fieldName", "", "getFieldName", "()Ljava/lang/String;", "setFieldName", "(Ljava/lang/String;)V", "Lcom/bytedance/ee/bear/bitable/celleditor/editor/chatter/ChatterType;", "canShowNotifyBar", "canShowCheckBox", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterEditorModel extends CommonEditorModel<ChatterEditorValue> {
    private Boolean canShowChatterInfoIcon;
    private Boolean canShowCreateGroup;
    private Integer chatterType;
    private String fieldName;
    private Integer maxSelectCount;
    private Boolean notifiesEnable;
    private Integer showNotifyBarStyle;

    public final boolean canShowCheckBox() {
        Integer r100 = this.showNotifyBarStyle;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 3) goto L8;
        return true;
    }

    public final boolean canShowNotifyBar() {
        Integer r100 = this.showNotifyBarStyle;
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.intValue() != 1) goto L11;
        return false;
    L11:
        return true;
    }

    public final ChatterType getChatterType() {
        ChatterType[] r100 = ChatterType.values();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        ChatterType r103 = r100[r102];
        int r104 = r103.getValue();
        Integer r105 = this.chatterType;
        if (r105 != null) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == true) goto L18;
        r102 = r102 + 1;
        goto L3
    L18:
        return r103;
    L8:
        if (r104 != r105.intValue()) goto L10;
        r106 = true;
        goto L11
    L14:
        return null;
    }

    public ChatterEditorModel() {
    }

    public final Boolean getCanShowChatterInfoIcon() {
        return this.canShowChatterInfoIcon;
    }

    public final Boolean getCanShowCreateGroup() {
        return this.canShowCreateGroup;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final Integer getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final Boolean getNotifiesEnable() {
        return this.notifiesEnable;
    }

    public final Integer getShowNotifyBarStyle() {
        return this.showNotifyBarStyle;
    }

    /* JADX INFO: renamed from: getChatterType, reason: collision with other method in class */
    public final Integer m8309getChatterType() {
        return this.chatterType;
    }

    public final void setCanShowChatterInfoIcon(Boolean r100) {
        this.canShowChatterInfoIcon = r100;
    }

    public final void setCanShowCreateGroup(Boolean r100) {
        this.canShowCreateGroup = r100;
    }

    public final void setChatterType(Integer r100) {
        this.chatterType = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setMaxSelectCount(Integer r100) {
        this.maxSelectCount = r100;
    }

    public final void setNotifiesEnable(Boolean r100) {
        this.notifiesEnable = r100;
    }

    public final void setShowNotifyBarStyle(Integer r100) {
        this.showNotifyBarStyle = r100;
    }
}
