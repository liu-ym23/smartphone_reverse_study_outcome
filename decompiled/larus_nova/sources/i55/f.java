package i55;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class f {
    public static int a(String r100) {
        tt5.a.h("DriveImportTypeUtil", "canImport starting...");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return 0;
    L6:
        if (r100.endsWith(".doc") == false) goto L8;
        return 101;
    L8:
        if (r100.endsWith(".docx") == false) goto L11;
        return 101;
    L11:
        if (r100.endsWith(".xls") == false) goto L13;
        return 102;
    L13:
        if (r100.endsWith(".xlsx") == false) goto L15;
        return 102;
    L15:
        if (r100.endsWith(".csv") == false) goto L18;
        return 102;
    L18:
        if (r100.endsWith(".xmind") == false) goto L20;
        return 103;
    L20:
        if (r100.endsWith(".opml") == false) goto L22;
        return 103;
    L22:
        if (r100.endsWith(".mm") == true) goto L32;
        return 0;
    L32:
        return 103;
    }
}
