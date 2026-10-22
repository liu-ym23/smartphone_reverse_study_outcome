package ir4;

import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.PendingUploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.upload.UploadAttachmentEntity;
import com.bytedance.ee.bear.bitable.celleditor.model.upload.DocumentInfo;
import com.bytedance.ee.bear.bitable.celleditor.model.upload.TargetCellInfo;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f495453a = 0;

    static {
    }

    public static FileUploadModel c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.MIME_TYPE);
        Intrinsics.checkNotNullParameter(r101, "objToken");
        Intrinsics.checkNotNullParameter(r102, "docUrl");
        Intrinsics.checkNotNullParameter(r103, "baseId");
        FileUploadModel r104 = new FileUploadModel();
        r104.setUploadType(1);
        r104.setUuids(new String[]{UUID.randomUUID().toString()});
        r104.setDoc_url(r102);
        r104.setToken(r101);
        r104.setContentType(r100);
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("token", r101);
        sbb.e r106 = sbb.e.f541298i;
        r105.put("obj_type", String.valueOf(r106.f541317b));
        r104.setMultiparts(r105);
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, "bitable_file");
        r107.put(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN, r103);
        r107.put("obj_type", String.valueOf(r106.f541317b));
        r104.setUploadParams(r107);
        return r104;
    }

    public static Pair a(FileBean r100, DocumentInfo r110, TargetCellInfo r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "fileBean");
        Intrinsics.checkNotNullParameter(r111, "targetCellInfo");
        String r101 = r100.getPath();
        String r102 = r100.getMimeType();
        if (r102 != null) goto L5;
        r102 = FileUtils.D(r100.getPath());
    L5:
        String r103 = r102;
        int r104 = r100.getWidth();
        int r105 = r100.getHeight();
        Intrinsics.checkNotNull(r103);
        String r106 = "";
        if (r110 == null) goto L9;
        String r107 = r110.getToken();
        if (r107 == null) goto L9;
    L10:
        if (r110 == null) goto L15;
        String r114 = r110.getUrl();
        if (r114 == null) goto L15;
        r106 = r114;
    L15:
        FileUploadModel r108 = c(r103, r107, r106, r111.getBaseId());
        Intrinsics.checkNotNull(r101);
        return new Pair(b(r101, r103, r104, r105, r111, r108, r112, r113), r108);
    L9:
        r107 = "";
        goto L10
    }

    public static UploadAttachmentEntity b(String r100, String r101, int r102, int r103, TargetCellInfo r104, FileUploadModel r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, "fileMimeType");
        Intrinsics.checkNotNullParameter(r104, "targetCellInfo");
        Intrinsics.checkNotNullParameter(r105, "fileUploadModel");
        VFSFile r108 = ay4.d.a().i(r100);
        if (r106 == false) goto L5;
        PendingUploadAttachmentEntity r109 = new PendingUploadAttachmentEntity();
        r109.setPendingUpload(true);
        r109.setUploadModel(r105);
        r109.setLocalPath(r100);
        UploadAttachmentEntity r110 = r109;
    L6:
        r110.setMimeType(r101);
        r110.setName(r108.getName());
        r110.setSize(r108.length());
        r110.setWidth(r102);
        r110.setHeight(r103);
        r110.setMountPointType("bitable_file");
        r110.setMountNodeToken(r104.getBaseId());
        r110.setLocalPath(r100);
        r110.setRecordId(r104.getRecordId());
        r110.setFieldId(r104.getFieldId());
        r110.setCameraOnly(r107);
        r110.setCellInfo(r104);
        return r110;
    L5:
        r110 = new UploadAttachmentEntity();
        goto L6
    }
}
