package ir4;

import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface h extends i {
    void destroy();

    List<UploadAttachmentEntity> findAttachmentListByRecordId(String r100, String r101, String r102);

    void resumeAttachmentFromDB(boolean r100, String r101, String r102);
}
