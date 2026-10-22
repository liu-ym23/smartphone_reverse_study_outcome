package com.bytedance.ee.bear.bitable.celleditor.editor.signature;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/signature/SignatureEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "fieldName", "getFieldName", "setFieldName", "fileName", "getFileName", "setFileName", "isContentEmpty", "", "()Ljava/lang/Boolean;", "setContentEmpty", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignatureEditorModel extends CommonEditorModel<List<? extends AttachmentEntity>> {
    private String fieldName;
    private String fileName;
    private Boolean isContentEmpty;
    private String mode;

    public SignatureEditorModel() {
        this.mode = "handwriting";
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getMode() {
        return this.mode;
    }

    public final Boolean isContentEmpty() {
        return this.isContentEmpty;
    }

    public final void setContentEmpty(Boolean r100) {
        this.isContentEmpty = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mode = r100;
    }
}
