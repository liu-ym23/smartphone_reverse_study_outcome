package i75;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class h {
    public h() {
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        String r101 = "message";
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -907207068: goto L28;
            case 136691587: goto L24;
            case 873376034: goto L20;
            case 926934164: goto L16;
            case 954925063: goto L12;
            case 1666900169: goto L8;
            default: goto L31;
        };
    L31:
        switch(r102) {
            case 0: goto L37;
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L39;
            case 5: goto L33;
            default: goto L32;
        };
    L32:
        r101 = r100;
        goto L39
    L33:
        r101 = "doc_embed";
        goto L39
    L34:
        r101 = "history";
        goto L39
    L35:
        r101 = "docs_feed";
        goto L39
    L36:
        r101 = "thirdparty_attachment";
        goto L39
    L37:
        r101 = "doc_mention";
    L39:
        if (TextUtils.isEmpty(r100) == false) goto L42;
        return "unknown";
    L42:
        return r101;
    L8:
        if (r100.equals("docs_attach") == false) goto L31;
        r102 = 5;
        goto L31
    L12:
        if (r100.equals("message") == false) goto L31;
        r102 = 4;
        goto L31
    L16:
        if (r100.equals("history") == false) goto L31;
        r102 = 3;
        goto L31
    L20:
        if (r100.equals("docs_feed") == false) goto L31;
        r102 = 2;
        goto L31
    L24:
        if (r100.equals("thirdparty_attachment") == false) goto L31;
        r102 = 1;
        goto L31
    L28:
        if (r100.equals("tab_link") == false) goto L31;
        r102 = 0;
        goto L31
    }

    public static boolean b(String r100) {
        if ("zip".equalsIgnoreCase(r100) == false) goto L5;
    L16:
        return true;
    L5:
        if ("rar".equalsIgnoreCase(r100) == true) goto L16;
        if ("tar".equalsIgnoreCase(r100) == true) goto L16;
        if ("tar.gz".equalsIgnoreCase(r100) == true) goto L16;
        if ("tar.bz2".equalsIgnoreCase(r100) == true) goto L16;
        if ("7z".equalsIgnoreCase(r100) == true) goto L16;
        return false;
    }

    public static boolean d(String r100) {
        if ("html".equalsIgnoreCase(r100) == false) goto L5;
    L12:
        return true;
    L5:
        if ("htm".equalsIgnoreCase(r100) == true) goto L12;
        if ("xhtml".equalsIgnoreCase(r100) == true) goto L12;
        if ("xht".equalsIgnoreCase(r100) == true) goto L12;
        return false;
    }

    public static boolean e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (LoadParams.ImageFormat.PNG.equalsIgnoreCase(r100) == false) goto L8;
    L27:
        return true;
    L8:
        if ("jpe".equalsIgnoreCase(r100) == true) goto L27;
        if ("jpg".equalsIgnoreCase(r100) == true) goto L27;
        if (LoadParams.ImageFormat.JPEG.equalsIgnoreCase(r100) == true) goto L27;
        if ("bmp".equalsIgnoreCase(r100) == true) goto L27;
        if ("wbmp".equalsIgnoreCase(r100) == true) goto L27;
        if ("gif".equalsIgnoreCase(r100) == true) goto L27;
        if ("heic".equalsIgnoreCase(r100) == true) goto L27;
        if ("webp".equalsIgnoreCase(r100) == true) goto L27;
        if ("ico".equalsIgnoreCase(r100) == true) goto L27;
        if ("heif".equalsIgnoreCase(r100) == true) goto L27;
        return false;
    }

    public static boolean f(String r100) {
        return "csv".equalsIgnoreCase(r100);
    }

    public static boolean g(String r100) {
        if ("doc".equalsIgnoreCase(r100) == false) goto L5;
    L16:
        return true;
    L5:
        if (DocumentType.DOCX_NAME.equalsIgnoreCase(r100) == true) goto L16;
        if ("docm".equalsIgnoreCase(r100) == true) goto L16;
        if ("dot".equalsIgnoreCase(r100) == true) goto L16;
        if ("dotx".equalsIgnoreCase(r100) == true) goto L16;
        if ("dotm".equalsIgnoreCase(r100) == true) goto L16;
        return false;
    }

    public static boolean h(String r100) {
        if ("xls".equalsIgnoreCase(r100) == false) goto L5;
    L16:
        return true;
    L5:
        if ("xlsx".equalsIgnoreCase(r100) == true) goto L16;
        if ("xlsm".equalsIgnoreCase(r100) == true) goto L16;
        if ("xlt".equalsIgnoreCase(r100) == true) goto L16;
        if ("xltx".equalsIgnoreCase(r100) == true) goto L16;
        if ("xltm".equalsIgnoreCase(r100) == true) goto L16;
        return false;
    }

    public static boolean i(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (g(r100) == false) goto L8;
    L13:
        return true;
    L8:
        if (h(r100) == true) goto L13;
        if (f(r100) == true) goto L13;
        if (j(r100) == true) goto L13;
        return false;
    }

    public static boolean j(String r100) {
        if ("ppt".equalsIgnoreCase(r100) == false) goto L5;
    L22:
        return true;
    L5:
        if (ExportFileExtension.PPTX.equalsIgnoreCase(r100) == true) goto L22;
        if ("pptm".equalsIgnoreCase(r100) == true) goto L22;
        if ("pps".equalsIgnoreCase(r100) == true) goto L22;
        if ("ppsx".equalsIgnoreCase(r100) == true) goto L22;
        if ("ppsm".equalsIgnoreCase(r100) == true) goto L22;
        if ("pot".equalsIgnoreCase(r100) == true) goto L22;
        if ("potx".equalsIgnoreCase(r100) == true) goto L22;
        if ("potm".equalsIgnoreCase(r100) == true) goto L22;
        return false;
    }

    public static boolean k(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return ExportFileExtension.PDF.equalsIgnoreCase(r100);
    }

    public static boolean l(String r100) {
        if ("txt".equalsIgnoreCase(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if ("log".equalsIgnoreCase(r100) == true) goto L10;
        if ("csv".equalsIgnoreCase(r100) == true) goto L10;
        return false;
    }

    public static boolean n(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if ("MP4".equalsIgnoreCase(r100) == false) goto L8;
    L21:
        return true;
    L8:
        if ("MKV".equalsIgnoreCase(r100) == true) goto L21;
        if ("M4V".equalsIgnoreCase(r100) == true) goto L21;
        if ("MPG".equalsIgnoreCase(r100) == true) goto L21;
        if ("WEBM".equalsIgnoreCase(r100) == true) goto L21;
        if ("MOV".equalsIgnoreCase(r100) == true) goto L21;
        if ("3GP".equalsIgnoreCase(r100) == true) goto L21;
        if ("3G2".equalsIgnoreCase(r100) == true) goto L21;
        return false;
    }

    public static Map<String, String> o(String r100) {
        HashMap r101 = new HashMap();
        String[] r102 = r100.split("&");     // Catch: Exception -> L11
        int r103 = r102.length;     // Catch: Exception -> L11
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L13;
        String[] r105 = r102[r104].split(ContainerUtils.KEY_VALUE_DELIMITER, 2);     // Catch: Exception -> L11
        if (r105.length != 2) goto L10;
        String r106 = r105[0];     // Catch: Exception -> L11
        String r107 = r105[1];     // Catch: Exception -> L11
        if (r101.containsKey(r106) == true) goto L10;
        r101.put(r106, r107);     // Catch: Exception -> L11
    L10:
        r104 = r104 + 1;
    L13:
        return r101;
    L11:
        e = move-exception;
        Log.e("DrivePreviewUtils", "parseFragment error", e);
        goto L13
    }

    public static boolean c(g85.f r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L12:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        g85.b r103 = (g85.b) r100;
        if (r103.g(r101) == false) goto L12;
        if (r103.i(r102, null) == false) goto L12;
        return true;
    }

    public static boolean m(g85.f r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L16;
        g85.b r103 = (g85.b) r100;
        if (r103.i(r101, null) == false) goto L10;
        return false;
    L10:
        if (r103.i(r102, null) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }
}
