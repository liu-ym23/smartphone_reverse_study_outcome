package com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.celleditor.model.upload.TargetCellInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes15.dex */
public class UploadAttachmentEntity extends AttachmentEntity {
    private long bytesTransferred;
    private TargetCellInfo cellInfo;
    private String docUrl;
    private String fieldId;
    private boolean isCameraOnly;
    private String localPath;
    private long primaryId;
    private String recordId;
    private int uploadProgress;
    private String uploadTaskKey;

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.uploadProgress), this.recordId, this.fieldId, this.uploadTaskKey, this.localPath, Boolean.valueOf(this.isCameraOnly), Long.valueOf(this.bytesTransferred), this.docUrl, Long.valueOf(this.primaryId)});
    }

    public UploadAttachmentEntity() {
        this.bytesTransferred = 0;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public TargetCellInfo getCellInfo() {
        return this.cellInfo;
    }

    public String getDocUrl() {
        return this.docUrl;
    }

    public String getFieldId() {
        return this.fieldId;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public long getPrimaryId() {
        return this.primaryId;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public int getUploadProgress() {
        return this.uploadProgress;
    }

    public String getUploadTaskKey() {
        return this.uploadTaskKey;
    }

    public boolean isCameraOnly() {
        return this.isCameraOnly;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UploadAttachmentEntity) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        UploadAttachmentEntity r101 = (UploadAttachmentEntity) r100;
        if (this.uploadProgress == r101.uploadProgress) goto L14;
    L30:
        return false;
    L14:
        if (this.isCameraOnly != r101.isCameraOnly) goto L30;
        if (this.bytesTransferred != r101.bytesTransferred) goto L30;
        if (TextUtils.equals(this.recordId, r101.recordId) == false) goto L30;
        if (TextUtils.equals(this.fieldId, r101.fieldId) == false) goto L30;
        if (TextUtils.equals(this.uploadTaskKey, r101.uploadTaskKey) == false) goto L30;
        if (TextUtils.equals(this.localPath, r101.localPath) == false) goto L30;
        if (TextUtils.equals(this.docUrl, r101.docUrl) == false) goto L30;
        if (this.primaryId != r101.primaryId) goto L30;
        return true;
    }

    public void setBytesTransferred(long r100) {
        this.bytesTransferred = r100;
    }

    public void setCameraOnly(boolean r100) {
        this.isCameraOnly = r100;
    }

    public void setCellInfo(TargetCellInfo r100) {
        this.cellInfo = r100;
    }

    public void setDocUrl(String r100) {
        this.docUrl = r100;
    }

    public void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public void setLocalPath(String r100) {
        this.localPath = r100;
    }

    public void setPrimaryId(long r100) {
        this.primaryId = r100;
    }

    public void setRecordId(String r100) {
        this.recordId = r100;
    }

    public void setUploadProgress(int r100) {
        this.uploadProgress = r100;
    }

    public void setUploadTaskKey(String r100) {
        this.uploadTaskKey = r100;
    }
}
