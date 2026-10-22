package com.google.gson.internal.bind.util;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes6.dex */
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = null;
    private static final String UTC_ID = "UTC";

    public ISO8601Utils() {
    }

    static {
        TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    }

    public static String format(Date r100) {
        return format(r100, false, TIMEZONE_UTC);
    }

    public static String format(Date r100, boolean r101) {
        return format(r100, r101, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String r100, int r101) {
    L3:
        if (r101 >= r100.length()) goto L12;
        char r102 = r100.charAt(r101);
        if (r102 < '0') goto L10;
        if (r102 > '9') goto L10;
        r101 = r101 + 1;
    L10:
        return r101;
    L12:
        return r100.length();
    }

    public static Date parse(String r110, ParsePosition r210) throws ParseException {
        int r100 = r210.getIndex();     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r101 = r100 + 4;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r102 = parseInt(r110, r100, r101);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (checkOffset(r110, r101, '-') == false) goto L6;
        r101 = r101 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L6:
        int r103 = r101 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r104 = parseInt(r110, r101, r103);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (checkOffset(r110, r103, '-') == false) goto L9;
        r103 = r103 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L9:
        int r111 = r103 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r105 = parseInt(r110, r103, r111);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        boolean r112 = checkOffset(r110, r111, OthersPermission.STICKY);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r112 == true) goto L16;
        if (r110.length() > r111) goto L16;
        GregorianCalendar r106 = new GregorianCalendar(r102, r104 - 1, r105);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        r106.setLenient(false);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        r210.setIndex(r111);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        return r106.getTime();
    L16:
        if (r112 == false) goto L46;
        int r113 = r111 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r114 = r113 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r115 = parseInt(r110, r113, r114);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (checkOffset(r110, r114, ':') == false) goto L20;
        r114 = r114 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L20:
        int r116 = r114 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r117 = parseInt(r110, r114, r116);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (checkOffset(r110, r116, ':') == false) goto L24;
        r116 = r116 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L24:
        if (r110.length() <= r116) goto L45;
        char r118 = r110.charAt(r116);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r118 == 'Z') goto L45;
        if (r118 == '+') goto L45;
        if (r118 == '-') goto L45;
        int r119 = r116 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r120 = parseInt(r110, r116, r119);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r120 <= 59) goto L35;
        if (r120 >= 63) goto L35;
        r120 = 59;
    L35:
        if (checkOffset(r110, r119, '.') == false) goto L44;
        int r121 = r119 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r107 = indexOfNonDigit(r110, r121 + 1);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r122 = Math.min(r107, r121 + 3);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r123 = parseInt(r110, r121, r122);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r124 = r122 - r121;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r124 != 1) goto L39;
        r123 = r123 * 100;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L43:
        int r125 = r123;
        r111 = r107;
        int r108 = r115;
    L49:
        if (r110.length() <= r111) goto L90;
        char r126 = r110.charAt(r111);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r126 != 'Z') goto L61;
        TimeZone r109 = TIMEZONE_UTC;     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        int r127 = r111 + 1;     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
    L85:
        GregorianCalendar r128 = new GregorianCalendar(r109);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r128.setLenient(false);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r128.set(1, r102);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r128.set(2, r104 - 1);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r128.set(5, r105);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r128.set(11, r108);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r128.set(12, r117);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r128.set(13, r120);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r128.set(14, r125);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r210.setIndex(r127);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        return r128.getTime();
    L61:
        if (r126 != '+') goto L63;
    L67:
        String r129 = r110.substring(r111);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        if (r129.length() >= 5) goto L71;
        r129 = r129.concat(CustomAlbumViewModel.DEFAULT_TAB_ID);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
    L71:
        r127 = r111 + r129.length();     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        if ("+0000".equals(r129) == false) goto L74;
    L84:
        r109 = TIMEZONE_UTC;     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        goto L85
    L74:
        if ("+00:00".equals(r129) == true) goto L84;
        String r130 = "GMT".concat(r129);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        TimeZone r131 = TimeZone.getTimeZone(r130);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        String r132 = r131.getID();     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        if (r132.equals(r130) == false) goto L79;
    L83:
        r109 = r131;
        goto L85
    L79:
        if (r132.replace(":", "").equals(r130) == true) goto L83;
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + r130 + " given, resolves to " + r131.getID());     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
    L63:
        if (r126 == '-') goto L67;
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + r126 + "'");     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
    L54:
        e = e;
    L96:
        if (r110 != null) goto L98;
        String r133 = null;
    L99:
        String r134 = e.getMessage();
        if (r134 != null) goto L102;
    L103:
        r134 = "(" + e.getClass().getName() + ")";
    L104:
        ParseException r135 = new ParseException("Failed to parse date [" + r133 + "]: " + r134, r210.getIndex());
        r135.initCause(e);
        throw r135;
    L102:
        if (r134.isEmpty() == false) goto L104;
    L98:
        r133 = "\"" + r110 + Typography.quote;
    L58:
        e = e;
    L56:
        e = e;
        goto L96
    L90:
        throw new IllegalArgumentException("No time zone indicator");     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L39:
        if (r124 != 2) goto L43;
        r123 = r123 * 10;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        goto L43
    L44:
        r108 = r115;
        r111 = r119;
        r125 = 0;
    L45:
        r108 = r115;
        r111 = r116;
    L47:
        r125 = 0;
        r120 = 0;
        goto L49
    L46:
        r108 = 0;
        r117 = 0;
    L91:
        e = e;
    L95:
        e = e;
    L93:
        e = e;
        goto L96
    }

    private static boolean checkOffset(String r100, int r101, char r102) {
        if (r101 < r100.length()) goto L5;
    L7:
        return false;
    L5:
        if (r100.charAt(r101) != r102) goto L7;
        return true;
    }

    public static String format(Date r100, boolean r101, TimeZone r102) {
        GregorianCalendar r103 = new GregorianCalendar(r102, Locale.US);
        r103.setTime(r100);
        if (r101 == false) goto L5;
        int r104 = 4;
    L6:
        int r105 = 19 + r104;
        if (r102.getRawOffset() != 0) goto L9;
        int r106 = 1;
    L10:
        StringBuilder r107 = new StringBuilder(r105 + r106);
        padInt(r107, r103.get(1), 4);
        char r108 = '-';
        r107.append('-');
        padInt(r107, r103.get(2) + 1, 2);
        r107.append('-');
        padInt(r107, r103.get(5), 2);
        r107.append(OthersPermission.STICKY);
        padInt(r107, r103.get(11), 2);
        r107.append(':');
        padInt(r107, r103.get(12), 2);
        r107.append(':');
        padInt(r107, r103.get(13), 2);
        if (r101 == false) goto L13;
        r107.append('.');
        padInt(r107, r103.get(14), 3);
    L13:
        int r109 = r102.getOffset(r103.getTimeInMillis());
        if (r109 == 0) goto L20;
        int r110 = r109 / 60000;
        int r111 = Math.abs(r110 / 60);
        int r112 = Math.abs(r110 % 60);
        if (r109 < 0) goto L19;
        r108 = '+';
    L19:
        r107.append(r108);
        padInt(r107, r111, 2);
        r107.append(':');
        padInt(r107, r112, 2);
    L22:
        return r107.toString();
    L20:
        r107.append(Matrix.MATRIX_TYPE_ZERO);
        goto L22
    L9:
        r106 = 6;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    private static void padInt(StringBuilder r100, int r101, int r102) {
        String r103 = Integer.toString(r101);
        int r104 = r102 - r103.length();
    L3:
        if (r104 <= 0) goto L5;
        r100.append('0');
        r104 = r104 - 1;
        goto L3
    L5:
        r100.append(r103);
    }

    private static int parseInt(String r100, int r101, int r102) throws NumberFormatException {
        if (r101 < 0) goto L23;
        if (r102 > r100.length()) goto L23;
        if (r101 > r102) goto L23;
        if (r101 >= r102) goto L13;
        int r103 = r101 + 1;
        int r104 = Character.digit(r100.charAt(r101), 10);
        if (r104 < 0) goto L12;
        int r105 = -r104;
    L14:
        if (r103 >= r102) goto L21;
        int r106 = r103 + 1;
        int r107 = Character.digit(r100.charAt(r103), 10);
        if (r107 < 0) goto L19;
        r105 = (r105 * 10) - r107;
        r103 = r106;
        goto L14
    L19:
        throw new NumberFormatException("Invalid number: " + r100.substring(r101, r102));
    L21:
        return -r105;
    L12:
        throw new NumberFormatException("Invalid number: " + r100.substring(r101, r102));
    L13:
        r105 = 0;
        r103 = r101;
    L23:
        throw new NumberFormatException(r100);
    }
}
