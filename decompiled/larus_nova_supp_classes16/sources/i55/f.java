package i55;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static int a(String r2) {
        tt5.a.h("DriveImportTypeUtil", "canImport starting...");
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return 0;
    L6:
        if (r2.endsWith(".doc") == false) goto L8;
        return VersionPayLoadData.OPERATION_UPDATE;
    L8:
        if (r2.endsWith(".docx") == false) goto L11;
        return VersionPayLoadData.OPERATION_UPDATE;
    L11:
        if (r2.endsWith(".xls") == false) goto L13;
        return VersionPayLoadData.OPERATION_DELETE;
    L13:
        if (r2.endsWith(".xlsx") == false) goto L15;
        return VersionPayLoadData.OPERATION_DELETE;
    L15:
        if (r2.endsWith(".csv") == false) goto L18;
        return VersionPayLoadData.OPERATION_DELETE;
    L18:
        if (r2.endsWith(".xmind") == false) goto L20;
        return 103;
    L20:
        if (r2.endsWith(".opml") == false) goto L22;
        return 103;
    L22:
        if (r2.endsWith(".mm") == true) goto L32;
        return 0;
    L32:
        return 103;
    }
}
