package ir4;

import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.celleditor.model.upload.TargetCellInfo;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface i {
    void cancelAttachment(UploadAttachmentEntity r100);

    List<UploadAttachmentEntity> findAttachmentListByCellInfo(TargetCellInfo r100);

    String findLocalPathIfAttachmentUploadedManually(String r100);

    void registerFileUploadStatusListener(jp4.a r100);

    void unregisterFileUploadStatusListener(jp4.a r100);
}
