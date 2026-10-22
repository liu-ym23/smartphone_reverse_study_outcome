package com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload;

import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import cp4.b;
import java.util.Objects;

/* JADX INFO: loaded from: classes15.dex */
public class PendingUploadAttachmentEntity extends UploadAttachmentEntity {
    private boolean isPendingUpload;
    private b table;
    private FileUploadModel uploadModel;

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity, com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Boolean.valueOf(this.isPendingUpload), this.uploadModel, this.table});
    }

    public PendingUploadAttachmentEntity() {
    }

    public b getTable() {
        return this.table;
    }

    public FileUploadModel getUploadModel() {
        return this.uploadModel;
    }

    public boolean isPendingUpload() {
        return this.isPendingUpload;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity, com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PendingUploadAttachmentEntity) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        PendingUploadAttachmentEntity r101 = (PendingUploadAttachmentEntity) r100;
        if (this.isPendingUpload == r101.isPendingUpload) goto L14;
    L18:
        return false;
    L14:
        if (Objects.equals(this.uploadModel, r101.uploadModel) == false) goto L18;
        if (Objects.equals(this.table, r101.table) == false) goto L18;
        return true;
    }

    public void setPendingUpload(boolean r100) {
        this.isPendingUpload = r100;
    }

    public void setTable(b r100) {
        this.table = r100;
    }

    public void setUploadModel(FileUploadModel r100) {
        this.uploadModel = r100;
    }
}
