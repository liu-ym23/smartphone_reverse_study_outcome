package i75;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public h() {
    }

    public static String a(String r6) {
        if (r6 != null) goto L4;
        r6 = "";
    L4:
        String r1 = "message";
        byte r5 = -1;
        switch(r6.hashCode()) {
            case -907207068: goto L28;
            case 136691587: goto L24;
            case 873376034: goto L20;
            case 926934164: goto L16;
            case 954925063: goto L12;
            case 1666900169: goto L8;
            default: goto L31;
        };
    L31:
        switch(r5) {
            case 0: goto L37;
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L39;
            case 5: goto L33;
            default: goto L32;
        };
    L32:
        r1 = r6;
        goto L39
    L33:
        r1 = "doc_embed";
        goto L39
    L34:
        r1 = "history";
        goto L39
    L35:
        r1 = "docs_feed";
        goto L39
    L36:
        r1 = "thirdparty_attachment";
        goto L39
    L37:
        r1 = "doc_mention";
    L39:
        if (TextUtils.isEmpty(r6) == false) goto L42;
        return "unknown";
    L42:
        return r1;
    L8:
        if (r6.equals("docs_attach") == false) goto L31;
        r5 = 5;
        goto L31
    L12:
        if (r6.equals("message") == false) goto L31;
        r5 = 4;
        goto L31
    L16:
        if (r6.equals("history") == false) goto L31;
        r5 = 3;
        goto L31
    L20:
        if (r6.equals("docs_feed") == false) goto L31;
        r5 = 2;
        goto L31
    L24:
        if (r6.equals("thirdparty_attachment") == false) goto L31;
        r5 = 1;
        goto L31
    L28:
        if (r6.equals("tab_link") == false) goto L31;
        r5 = 0;
        goto L31
    }

    public static boolean b(String r1) {
        if ("zip".equalsIgnoreCase(r1) == false) goto L5;
    L16:
        return true;
    L5:
        if ("rar".equalsIgnoreCase(r1) == true) goto L16;
        if ("tar".equalsIgnoreCase(r1) == true) goto L16;
        if ("tar.gz".equalsIgnoreCase(r1) == true) goto L16;
        if ("tar.bz2".equalsIgnoreCase(r1) == true) goto L16;
        if ("7z".equalsIgnoreCase(r1) == true) goto L16;
        return false;
    }

    public static boolean d(String r1) {
        if ("html".equalsIgnoreCase(r1) == false) goto L5;
    L12:
        return true;
    L5:
        if ("htm".equalsIgnoreCase(r1) == true) goto L12;
        if ("xhtml".equalsIgnoreCase(r1) == true) goto L12;
        if ("xht".equalsIgnoreCase(r1) == true) goto L12;
        return false;
    }

    public static boolean e(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if ("png".equalsIgnoreCase(r2) == false) goto L8;
    L27:
        return true;
    L8:
        if ("jpe".equalsIgnoreCase(r2) == true) goto L27;
        if ("jpg".equalsIgnoreCase(r2) == true) goto L27;
        if ("jpeg".equalsIgnoreCase(r2) == true) goto L27;
        if ("bmp".equalsIgnoreCase(r2) == true) goto L27;
        if ("wbmp".equalsIgnoreCase(r2) == true) goto L27;
        if ("gif".equalsIgnoreCase(r2) == true) goto L27;
        if ("heic".equalsIgnoreCase(r2) == true) goto L27;
        if ("webp".equalsIgnoreCase(r2) == true) goto L27;
        if ("ico".equalsIgnoreCase(r2) == true) goto L27;
        if ("heif".equalsIgnoreCase(r2) == true) goto L27;
        return false;
    }

    public static boolean f(String r1) {
        return "csv".equalsIgnoreCase(r1);
    }

    public static boolean g(String r1) {
        if ("doc".equalsIgnoreCase(r1) == false) goto L5;
    L16:
        return true;
    L5:
        if ("docx".equalsIgnoreCase(r1) == true) goto L16;
        if ("docm".equalsIgnoreCase(r1) == true) goto L16;
        if ("dot".equalsIgnoreCase(r1) == true) goto L16;
        if ("dotx".equalsIgnoreCase(r1) == true) goto L16;
        if ("dotm".equalsIgnoreCase(r1) == true) goto L16;
        return false;
    }

    public static boolean h(String r1) {
        if ("xls".equalsIgnoreCase(r1) == false) goto L5;
    L16:
        return true;
    L5:
        if ("xlsx".equalsIgnoreCase(r1) == true) goto L16;
        if ("xlsm".equalsIgnoreCase(r1) == true) goto L16;
        if ("xlt".equalsIgnoreCase(r1) == true) goto L16;
        if ("xltx".equalsIgnoreCase(r1) == true) goto L16;
        if ("xltm".equalsIgnoreCase(r1) == true) goto L16;
        return false;
    }

    public static boolean i(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (g(r2) == false) goto L8;
    L13:
        return true;
    L8:
        if (h(r2) == true) goto L13;
        if (f(r2) == true) goto L13;
        if (j(r2) == true) goto L13;
        return false;
    }

    public static boolean j(String r1) {
        if ("ppt".equalsIgnoreCase(r1) == false) goto L5;
    L22:
        return true;
    L5:
        if ("pptx".equalsIgnoreCase(r1) == true) goto L22;
        if ("pptm".equalsIgnoreCase(r1) == true) goto L22;
        if ("pps".equalsIgnoreCase(r1) == true) goto L22;
        if ("ppsx".equalsIgnoreCase(r1) == true) goto L22;
        if ("ppsm".equalsIgnoreCase(r1) == true) goto L22;
        if ("pot".equalsIgnoreCase(r1) == true) goto L22;
        if ("potx".equalsIgnoreCase(r1) == true) goto L22;
        if ("potm".equalsIgnoreCase(r1) == true) goto L22;
        return false;
    }

    public static boolean k(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return "pdf".equalsIgnoreCase(r1);
    }

    public static boolean l(String r1) {
        if ("txt".equalsIgnoreCase(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if ("log".equalsIgnoreCase(r1) == true) goto L10;
        if ("csv".equalsIgnoreCase(r1) == true) goto L10;
        return false;
    }

    public static boolean n(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if ("MP4".equalsIgnoreCase(r2) == false) goto L8;
    L21:
        return true;
    L8:
        if ("MKV".equalsIgnoreCase(r2) == true) goto L21;
        if ("M4V".equalsIgnoreCase(r2) == true) goto L21;
        if ("MPG".equalsIgnoreCase(r2) == true) goto L21;
        if ("WEBM".equalsIgnoreCase(r2) == true) goto L21;
        if ("MOV".equalsIgnoreCase(r2) == true) goto L21;
        if ("3GP".equalsIgnoreCase(r2) == true) goto L21;
        if ("3G2".equalsIgnoreCase(r2) == true) goto L21;
        return false;
    }

    public static Map<String, String> o(String r7) {
        HashMap r0 = new HashMap();
        String[] r8 = r7.split("&");     // Catch: Exception -> L11
        int r1 = r8.length;     // Catch: Exception -> L11
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L13;
        String[] r4 = r8[r3].split("=", 2);     // Catch: Exception -> L11
        if (r4.length != 2) goto L10;
        String r5 = r4[0];     // Catch: Exception -> L11
        String r6 = r4[1];     // Catch: Exception -> L11
        if (r0.containsKey(r5) == true) goto L10;
        r0.put(r5, r6);     // Catch: Exception -> L11
    L10:
        r3 = r3 + 1;
    L13:
        return r0;
    L11:
        e = move-exception;
        Log.e("DrivePreviewUtils", "parseFragment error", e);
        goto L13
    }

    public static boolean c(g85.f r1, String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L12:
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L12;
        g85.b r4 = (g85.b) r1;
        if (r4.g(r2) == false) goto L12;
        if (r4.i(r3, null) == false) goto L12;
        return true;
    }

    public static boolean m(g85.f r2, String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        g85.b r5 = (g85.b) r2;
        if (r5.i(r3, null) == false) goto L10;
        return false;
    L10:
        if (r5.i(r4, null) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }
}
