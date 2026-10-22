package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.PendingUploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.card.viewmodel.y1;

/* JADX INFO: loaded from: classes15.dex */
public interface p {
    void b1(int r100);

    PendingUploadAttachmentEntity findPendingUploadAttachmentByFileToken(String r100);

    y1 getMembraneManager();
}
