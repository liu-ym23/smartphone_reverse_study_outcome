package i75;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public static boolean b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L9;
    L8:
        return false;
    L9:
        boolean r5 = JSON.parseObject(r4).getBooleanValue("is_limited");     // Catch: Exception -> L6
        tt5.a.h("PdfEntityUtil", "getIsLimit: " + r5);     // Catch: Exception -> L6
        return r5;
    L6:
        e = move-exception;
        tt5.a.f("PdfEntityUtil", e, false);
        goto L8
    }

    public static void a(v95.a r3, z r4) {
        if (r3 == null) goto L15;
        if (r4 == null) goto L15;
        r3.b = r4.b;
        r3.a = r4.d;
    L11:
        e = move-exception;
        tt5.a.f("DRIVE_PREVIEW_FLOW", e, false);
    L13:
        r3.c = b(r4.g);
        return;
    L7:
        if (hu5.a.e(r4.f) == true) goto L13;
        String r0 = r4.f.values().iterator().next();     // Catch: Exception -> L11
    L15:
        tt5.a.d("PdfEntityUtil", "pdfEntityData or fileModel is null");
    }
}
