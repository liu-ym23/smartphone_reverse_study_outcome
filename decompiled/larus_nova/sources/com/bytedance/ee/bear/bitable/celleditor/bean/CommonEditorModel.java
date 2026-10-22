package com.bytedance.ee.bear.bitable.celleditor.bean;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "Value", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", WikiFolderPushPlugin.OPT, "", "getOperation", "()I", "setOperation", "(I)V", "location", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorLocation;", "getLocation", "()Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorLocation;", "setLocation", "(Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditorLocation;)V", "fieldUIType", "", "getFieldUIType", "()Ljava/lang/String;", "setFieldUIType", "(Ljava/lang/String;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nativeAction", "getNativeAction", "setNativeAction", "disableSyncData", "", "getDisableSyncData", "()Ljava/lang/Boolean;", "setDisableSyncData", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonEditorModel<Value> implements NonProguard {
    private Boolean disableSyncData;
    private String fieldUIType;
    private EditorLocation location;
    private String nativeAction;
    private int operation;
    private Value value;

    public CommonEditorModel() {
        this.operation = -1;
        this.disableSyncData = Boolean.FALSE;
    }

    public final Boolean getDisableSyncData() {
        return this.disableSyncData;
    }

    public final String getFieldUIType() {
        return this.fieldUIType;
    }

    public final EditorLocation getLocation() {
        return this.location;
    }

    public final String getNativeAction() {
        return this.nativeAction;
    }

    public final int getOperation() {
        return this.operation;
    }

    public final Value getValue() {
        return this.value;
    }

    public final void setDisableSyncData(Boolean r100) {
        this.disableSyncData = r100;
    }

    public final void setFieldUIType(String r100) {
        this.fieldUIType = r100;
    }

    public final void setLocation(EditorLocation r100) {
        this.location = r100;
    }

    public final void setNativeAction(String r100) {
        this.nativeAction = r100;
    }

    public final void setOperation(int r100) {
        this.operation = r100;
    }

    public final void setValue(Value r100) {
        this.value = r100;
    }
}
