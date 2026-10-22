package com.bytedance.ee.bear.bitable.itemview.cell.link;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.uikit.ContextField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010@\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u001fR&\u0010-\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\nR$\u00101\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR$\u00105\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R$\u00109\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTableCellValue;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/model/LinkTableAttachParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "linkBaseId", "", "getLinkBaseId", "()Ljava/lang/String;", "setLinkBaseId", "(Ljava/lang/String;)V", "linkTableId", "getLinkTableId", "setLinkTableId", "linkViewId", "getLinkViewId", "setLinkViewId", "fieldId", "getFieldId", "setFieldId", "recordId", "getRecordId", "setRecordId", "tableId", "getTableId", "setTableId", "mode", "", "getMode", "()Ljava/lang/Integer;", "setMode", "(I)V", "tableVisible", "", "getTableVisible", "()Z", "setTableVisible", "(Z)V", "tableAddable", "getTableAddable", "setTableAddable", "visibleRecordSize", "getVisibleRecordSize", "()I", "setVisibleRecordSize", "renderId", "getRenderId$annotations", "getRenderId", "setRenderId", "fieldName", "getFieldName$annotations", "getFieldName", "setFieldName", "editable", "getEditable$annotations", "getEditable", "setEditable", "fieldUIType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "getFieldUIType$annotations", "getFieldUIType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "setFieldUIType", "(Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;)V", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LinkTableCellValue implements tp4.c, NonProguard {
    private boolean editable;
    private String fieldId;
    private String fieldName;
    private EFieldUIType fieldUIType;
    private String linkBaseId;
    private String linkTableId;
    private String linkViewId;
    private int mode;
    private String recordId;
    private String renderId;
    private boolean tableAddable;
    private String tableId;
    private boolean tableVisible;
    private int visibleRecordSize;

    @ContextField
    public static /* synthetic */ void getEditable$annotations() {
    }

    @ContextField
    public static /* synthetic */ void getFieldName$annotations() {
    }

    @ContextField
    public static /* synthetic */ void getFieldUIType$annotations() {
    }

    @ContextField
    public static /* synthetic */ void getRenderId$annotations() {
    }

    @Override // tp4.c
    public Integer getMode() {
        return Integer.valueOf(this.mode);
    }

    public String toString() {
        return "LinkTableCellValue(tableId='" + getTableId() + "', recordId='" + getRecordId() + "', fieldId='" + getFieldId() + "')";
    }

    public LinkTableCellValue() {
        this.linkBaseId = "";
        this.linkTableId = "";
        this.linkViewId = "";
        this.fieldId = "";
        this.recordId = "";
        this.tableId = "";
        this.renderId = "";
        this.fieldName = "";
        this.fieldUIType = EFieldUIType.SINGLE_LINK;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    @Override // tp4.c
    public String getFieldId() {
        return this.fieldId;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final EFieldUIType getFieldUIType() {
        return this.fieldUIType;
    }

    @Override // tp4.c
    public String getLinkBaseId() {
        return this.linkBaseId;
    }

    @Override // tp4.c
    public String getLinkTableId() {
        return this.linkTableId;
    }

    @Override // tp4.c
    public String getLinkViewId() {
        return this.linkViewId;
    }

    @Override // tp4.c
    public String getRecordId() {
        return this.recordId;
    }

    @Override // tp4.c
    public String getRenderId() {
        return this.renderId;
    }

    public final boolean getTableAddable() {
        return this.tableAddable;
    }

    @Override // tp4.c
    public String getTableId() {
        return this.tableId;
    }

    public final boolean getTableVisible() {
        return this.tableVisible;
    }

    public final int getVisibleRecordSize() {
        return this.visibleRecordSize;
    }

    public final void setEditable(boolean r100) {
        this.editable = r100;
    }

    public void setFieldId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldId = r100;
    }

    public final void setFieldName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldName = r100;
    }

    public final void setFieldUIType(EFieldUIType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldUIType = r100;
    }

    public void setLinkBaseId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.linkBaseId = r100;
    }

    public void setLinkTableId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.linkTableId = r100;
    }

    public void setLinkViewId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.linkViewId = r100;
    }

    public void setMode(int r100) {
        this.mode = r100;
    }

    public void setRecordId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordId = r100;
    }

    public void setRenderId(String r100) {
        this.renderId = r100;
    }

    public final void setTableAddable(boolean r100) {
        this.tableAddable = r100;
    }

    public void setTableId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tableId = r100;
    }

    public final void setTableVisible(boolean r100) {
        this.tableVisible = r100;
    }

    public final void setVisibleRecordSize(int r100) {
        this.visibleRecordSize = r100;
    }
}
