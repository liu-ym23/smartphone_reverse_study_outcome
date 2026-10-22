package i75;

import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.PreviewStatus;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public static final List<Integer> a = null;

    static {
        a = CollectionsKt.listOf(new Integer[]{Integer.valueOf(PreviewStatus.UNEXPECTED_COMPRESS_FORMAT), 90001041, 90003041, 90001044, 90003044, 90001043, 90003043, 11001, 13001, 233527007, Integer.valueOf(ImportResult.STATUS_SHEET_IMPORT_IMAGE_UPLOAD_ERROR), 1039});
    }

    @JvmStatic
    public static final boolean a(int r3) {
        boolean r0 = !a.contains(Integer.valueOf(r3));
        tt5.a.h("DriveTransmissionCheckerManager", "canRetryUpload: errorCode=" + r3 + ", result=" + r0);
        return r0;
    }
}
