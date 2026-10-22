package i75;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;

/* JADX INFO: loaded from: classes16.dex */
public final class n {
    public static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L8:
        return false;
    L9:
        boolean r101 = JSON.parseObject(r100).getBooleanValue("is_limited");     // Catch: Exception -> L6
        tt5.a.h("PdfEntityUtil", "getIsLimit: " + r101);     // Catch: Exception -> L6
        return r101;
    L6:
        e = move-exception;
        tt5.a.f("PdfEntityUtil", e, false);
        goto L8
    }

    public static void a(v95.a r100, z r101) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        r100.f553780b = r101.f225834b;
        r100.f553779a = r101.f225836d;
    L11:
        e = move-exception;
        tt5.a.f("DRIVE_PREVIEW_FLOW", e, false);
    L13:
        r100.f553781c = b(r101.f225839g);
        return;
    L7:
        if (hu5.a.e(r101.f225838f) == true) goto L13;
        String r102 = r101.f225838f.values().iterator().next();     // Catch: Exception -> L11
    L15:
        tt5.a.d("PdfEntityUtil", "pdfEntityData or fileModel is null");
    }
}
