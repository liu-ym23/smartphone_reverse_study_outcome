package com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import gp4.h;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import uu5.i;

/* JADX INFO: loaded from: classes15.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.a$a, reason: collision with other inner class name */
    public interface InterfaceC2992a {
        void a(String r100, String r101, String r102, List<AttachmentEntity> r103);
    }

    public interface b {
        void shouldDisableLandscape(boolean r100);
    }

    void addOnUploadedListener(InterfaceC2992a r100);

    void clearAllUploadTasks();

    void clearFileTokenToEntityMap();

    void doCancelClosedTableBindAndResume(String r100, String r101);

    void doCurTableDatabaseInfoResumeAndBind(cp4.b r100);

    String findLocalPathIfAttachmentUploadedManually(String r100);

    PendingUploadAttachmentEntity findPendingUploadAttachmentByFileToken(String r100);

    ArrayList<UploadAttachmentEntity> findUploadingAttachmentList(String r100);

    Flowable<i<ArrayList<UploadAttachmentEntity>>> loadUploadingAttachmentList(dp4.a<List<AttachmentEntity>> r100, boolean r101);

    void pauseAllUploadTasks();

    void registerFileUploadStatusListener(jp4.a r100);

    void registerOrientationControlListener(b r100);

    void removeUploadTaskByRecordId(String r100);

    void removeUploadTasks(UploadAttachmentEntity r100);

    void setBitableCardDelegate(h r100);

    void setOperationUpdater(sq4.b r100);

    void shouldDisableLandscape(boolean r100);

    void unregisterFileUploadStatusListener(jp4.a r100);

    void unregisterOrientationControlListener(b r100);

    ArrayList<UploadAttachmentEntity> uploadPendingMedia(String r100, String r101, String r102);

    void uploadSelectedAttachment(FileBean r100, String r101, String r102, int r103, dp4.a<List<AttachmentEntity>> r104, boolean r105, boolean r106);
}
