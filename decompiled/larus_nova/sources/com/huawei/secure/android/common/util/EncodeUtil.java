package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes23.dex */
public class EncodeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278200a = "EncodeUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f278201b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f278202c = null;

    static {
        f278201b = new char[]{',', '.', '-', '_'};
        f278202c = new String[256];
        char r100 = 0;
    L4:
        if (r100 >= 255) goto L21;
        if (r100 < '0') goto L10;
        if (r100 > '9') goto L10;
    L18:
        f278202c[r100] = null;
    L20:
        r100 = (char) (r100 + 1);
    L10:
        if (r100 < 'A') goto L14;
        if (r100 <= 'Z') goto L18;
    L14:
        if (r100 >= 'a') goto L16;
    L19:
        f278202c[r100] = b(r100).intern();
        goto L20
    L16:
        if (r100 <= 'z') goto L18;
    }

    public EncodeUtil() {
    }

    private static Character a(a r100) {
        r100.c();
        Character r101 = r100.d();
        if (r101 != null) goto L5;
    L13:
        r100.i();
        return null;
    L5:
        if (r101.charValue() != '\\') goto L13;
        Character r102 = r100.d();
        if (r102 != null) goto L12;
        r100.i();
        return null;
    L12:
        return a(r100, r102);
    }

    private static String b(char r100) {
        return Integer.toHexString(r100);
    }

    public static String decodeForJavaScript(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L17;
        return "";
    L17:
        StringBuilder r101 = new StringBuilder();     // Catch: Exception -> L14
        a r102 = new a(r100);     // Catch: Exception -> L14
    L7:
        if (r102.a() == false) goto L12;
        Character r103 = a(r102);     // Catch: Exception -> L14
        if (r103 != null) goto L10;
        r101.append(r102.d());     // Catch: Exception -> L14
        goto L7
    L10:
        r101.append(r103);     // Catch: Exception -> L14
        goto L7
    L12:
        return r101.toString();
    L14:
        e = move-exception;
        e.getMessage();
        return "";
    }

    public static String encodeForJavaScript(String r100) {
        return encodeForJavaScript(r100, f278201b);
    }

    private static String a(char r100) {
        if (r100 >= 255) goto L7;
        return f278202c[r100];
    L7:
        return b(r100);
    }

    private static Character a(a r100, Character r101) {
        if (r101.charValue() != 'b') goto L7;
        return '\b';
    L7:
        if (r101.charValue() != 't') goto L11;
        return '\t';
    L11:
        if (r101.charValue() != 'n') goto L15;
        return '\n';
    L15:
        if (r101.charValue() != 'v') goto L19;
        return 11;
    L19:
        if (r101.charValue() != 'f') goto L23;
        return '\f';
    L23:
        if (r101.charValue() != 'r') goto L27;
        return '\r';
    L27:
        if (r101.charValue() != '\"') goto L31;
        return Character.valueOf(Typography.quote);
    L31:
        if (r101.charValue() != '\'') goto L35;
        return '\'';
    L35:
        if (r101.charValue() != '\\') goto L39;
        return '\\';
    L39:
        if (Character.toLowerCase(r101.charValue()) != 'x') goto L43;
        return d(r100, r101);
    L43:
        if (Character.toLowerCase(r101.charValue()) != 'u') goto L47;
        return c(r100, r101);
    L47:
        if (a.c(r101) == true) goto L49;
        return r101;
    L49:
        return b(r100, r101);
    }

    private static Character b(a r100, Character r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        Character r103 = r100.d();
        if (a.c(r103) == true) goto L5;
        r100.a(r103);
    L16:
        int r104 = CastIntegerProtector.parseInt(r102.toString(), 8);     // Catch: NumberFormatException -> L14
        if (Character.isValidCodePoint(r104) == false) goto L13;
        return Character.valueOf((char) r104);
    L13:
        return r101;
    L14:
        r100.i();
        return null;
    L5:
        r102.append(r103);
        Character r105 = r100.d();
        if (a.c(r105) == true) goto L8;
        r100.a(r105);
        goto L16
    L8:
        r102.append(r105);
        goto L16
    }

    private static Character c(a r100, Character r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L4:
        if (r103 >= 4) goto L17;
        Character r104 = r100.e();
        if (r104 == null) goto L8;
        r102.append(r104);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.i();
        return null;
    L17:
        int r105 = CastIntegerProtector.parseInt(r102.toString(), 16);     // Catch: NumberFormatException -> L15
        if (Character.isValidCodePoint(r105) == false) goto L14;
        return Character.valueOf((char) r105);
    L14:
        return r101;
    L15:
        r100.i();
        return null;
    }

    private static Character d(a r100, Character r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L4:
        if (r103 >= 2) goto L17;
        Character r104 = r100.e();
        if (r104 == null) goto L8;
        r102.append(r104);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.i();
        return null;
    L17:
        int r105 = CastIntegerProtector.parseInt(r102.toString(), 16);     // Catch: NumberFormatException -> L15
        if (Character.isValidCodePoint(r105) == false) goto L14;
        return Character.valueOf((char) r105);
    L14:
        return r101;
    L15:
        r100.i();
        return null;
    }

    public static String encodeForJavaScript(String r100, char[] r101) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return a(r101, r100);
    L7:
        e = move-exception;
        e.getMessage();
        return "";
    }

    private static String a(char[] r100, Character r101) {
        if (a(r101.charValue(), r100) == false) goto L7;
        return "" + r101;
    L7:
        if (a(r101.charValue()) == null) goto L9;
        String r102 = Integer.toHexString(r101.charValue());
        if (r101.charValue() >= 256) goto L15;
        return "\\x" + CustomAlbumViewModel.DEFAULT_TAB_ID.substring(r102.length()) + r102.toUpperCase(Locale.ENGLISH);
    L15:
        return "\\u" + AbsBatteryStrategy.AppFgCombination.APP_FG__CHARGE_IN__NETWORK_WIFI__SCREEN_ON.substring(r102.length()) + r102.toUpperCase(Locale.ENGLISH);
    L9:
        return "" + r101;
    }

    private static String a(char[] r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L4:
        if (r103 >= r101.length()) goto L7;
        r102.append(a(r100, Character.valueOf(r101.charAt(r103))));
        r103 = r103 + 1;
        goto L4
    L7:
        return r102.toString();
    }

    private static boolean a(char r100, char[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r100 == r101[r103]) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
