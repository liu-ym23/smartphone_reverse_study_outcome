package com.ss.android.lark.audio.voiceinput.utils;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import java.util.regex.Pattern;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f409445a = 0;

    static {
    }

    public static String a(String r110) {
        StringBuilder r100 = new StringBuilder();
        if (r110 == null) goto L91;
        int r101 = 0;
    L6:
        if (r101 >= r110.length()) goto L91;
        char r102 = r110.charAt(r101);
        boolean r103 = true;
        if (r102 > 127) goto L62;
        if ('a' <= r102) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L18;
        r102 = 'a';
    L89:
        r100.append(r102);
        r101 = r101 + 1;
        goto L6
    L18:
        if ('A' <= r102) goto L20;
    L22:
        boolean r105 = false;
    L23:
        if (r105 == false) goto L26;
        r102 = 'A';
        goto L89
    L26:
        if ('0' > r102) goto L29;
        if (r102 >= ':') goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L33;
        r102 = '0';
        goto L89
    L33:
        if (r102 == '\r') goto L89;
        if (r102 == '\t') goto L89;
        if (r102 == ' ') goto L89;
        if (r102 == '\n') goto L89;
        if (' ' > r102) goto L43;
        if (r102 >= '0') goto L43;
        boolean r107 = true;
    L44:
        if (r107 == true) goto L58;
        if (':' > r102) goto L48;
        if (r102 >= 'A') goto L48;
        boolean r108 = true;
    L49:
        if (r108 == true) goto L58;
        if (Character.isWhitespace(r102) == true) goto L58;
        if (Character.isLetterOrDigit(r102) == false) goto L58;
        if (Pattern.matches(".*\\p{Punct}.*", String.valueOf(r102)) == true) goto L58;
        r103 = false;
    L48:
        r108 = false;
    L58:
        if (r103 == true) goto L89;
        r102 = Permission.EXECUTE;
    L43:
        r107 = false;
    L29:
        r106 = false;
        goto L30
    L20:
        if (r102 >= '[') goto L22;
        r105 = true;
        goto L23
    L12:
        if (r102 >= '{') goto L14;
        r104 = true;
        goto L15
    L62:
        if (19968 <= r102) goto L64;
    L66:
        boolean r109 = false;
    L67:
        if (r109 == false) goto L70;
        r102 = 'C';
        goto L89
    L70:
        if (12352 <= r102) goto L72;
    L74:
        boolean r111 = false;
    L75:
        if (r111 == false) goto L78;
        r102 = 'J';
        goto L89
    L78:
        if (44032 <= r102) goto L80;
    L82:
        r103 = false;
    L83:
        if (r103 == false) goto L86;
        r102 = 'K';
        goto L89
    L86:
        if (StringsKt.contains$default("“。，”？！、《》；：’‘【】", String.valueOf(r102), false, 2, null) == true) goto L89;
        r102 = 'X';
        goto L89
    L80:
        if (r102 >= 55204) goto L82;
    L72:
        if (r102 >= 12544) goto L74;
        r111 = true;
        goto L75
    L64:
        if (r102 >= 40960) goto L66;
        r109 = true;
    L91:
        return r100.toString();
    }
}
