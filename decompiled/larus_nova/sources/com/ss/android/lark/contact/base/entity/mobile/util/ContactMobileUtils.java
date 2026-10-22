package com.ss.android.lark.contact.base.entity.mobile.util;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.utils.LarkContext;
import h9b.b;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.UByte;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes35.dex */
public final class ContactMobileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Token f418890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PhoneNumberUtil f418891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<Character, Character> f418892c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f418893d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f418894e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f418895f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f418896g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char[] f418897h = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ContactType {
        public static final int ALL = 3;
        public static final int EMAIL = 1;
        public static final int PHONE = 2;
    }

    static {
        new Token("LARK-PSDA-contact_mobile_utils_read_contacts_permission");
        f418890a = new Token("LARK-PSDA-contact_mobile_utils_contact_query");
        f418892c = new HashMap();
        char[] r100 = {21834, 33453, 25830, 25645, 34558, 21457, 22134, 21704, 20987, 21888, 22403, 22920, 25343, 21734, 21866, 26399, 28982, 25746, 22604, 25366, 26132, 21387, 21277};
        f418893d = r100;
        f418894e = new int[r100.length + 1];
        f418895f = 45217;
        f418896g = 63486;
        f418897h = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', OthersPermission.STICKY, 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO};
        int r101 = 0;
    L3:
        char[] r102 = f418893d;
        if (r101 >= r102.length) goto L6;
        f418894e[r101] = b(r102[r101]);
        r101 = r101 + 1;
        goto L3
    L6:
        f418894e[r102.length] = f418896g;
        f418892c.put((char) 36911, Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_LT));
    }

    public static int b(char r100) {
        byte[] r101 = ("" + r100).getBytes("GB2312");     // Catch: Exception -> L9
        if (r101.length >= 2) goto L6;
        return 0;
    L6:
        return ((r101[0] << 8) & 65280) + (r101[1] & UByte.MAX_VALUE);
    L9:
        return 0;
    }

    public static String c(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L8:
        if (r102 >= r100.length()) goto L30;
        char r103 = r100.charAt(r102);
        Character r104 = f418892c.get(Character.valueOf(r103));
        if (r104 == null) goto L13;
        r103 = r104.charValue();
    L28:
        r101.append(r103);
        r102 = r102 + 1;
        goto L8
    L13:
        if (r103 >= 'a') goto L15;
    L17:
        if (r103 >= 'A') goto L19;
    L21:
        int r105 = b(r103);
        if (r105 >= f418895f) goto L24;
    L27:
        r103 = '#';
        goto L28
    L24:
        if (r105 > f418896g) goto L27;
        char[] r106 = f418897h;
        int[] r107 = f418894e;
        r103 = r106[a(r105, r107, 0, r107.length - 1)];
        goto L28
    L19:
        if (r103 > 'Z') goto L21;
    L15:
        if (r103 > 'z') goto L17;
        r103 = (char) ((r103 - 'a') + 65);
        goto L28
    L30:
        return r101.toString();
    L5:
        return "#";
    }

    public static boolean d(Pair<Integer, String> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (((Integer) r100.first).intValue() != 86) goto L10;
        return b.b("^[1]\\d{10}$", (CharSequence) r100.second);
    L10:
        return b.b("^\\d{1,14}$", (CharSequence) r100.second);
    }

    public static Pair<Integer, String> e(int r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        if (r101 != null) goto L8;
        String r102 = "";
    L16:
        if (r102.isEmpty() == false) goto L20;
        return Pair.create(Integer.valueOf(r100), "");
    L20:
        if (r101.trim().startsWith(Marker.ANY_NON_NULL_MARKER) == false) goto L22;
        if (f418891b != null) goto L26;
        f418891b = PhoneNumberUtil.c(LarkContext.getApplication());     // Catch: NumberParseException -> L32
    L26:
        PhoneNumberUtil r103 = f418891b;     // Catch: NumberParseException -> L32
        String r104 = Marker.ANY_NON_NULL_MARKER + r102;     // Catch: NumberParseException -> L32
        r103.getClass();     // Catch: NumberParseException -> L32
        Phonenumber$PhoneNumber r105 = new Phonenumber$PhoneNumber();     // Catch: NumberParseException -> L32
        r103.s(r104, "", false, true, r105);     // Catch: NumberParseException -> L32
        int r106 = r105.getCountryCode();     // Catch: NumberParseException -> L32
        if (r106 != 0) goto L31;
        return Pair.create(Integer.valueOf(r100), r102);
    L31:
        return Pair.create(Integer.valueOf(r106), String.valueOf(r105.getNationalNumber()));
    L33:
        return Pair.create(Integer.valueOf(r100), r102);
    L22:
        return Pair.create(Integer.valueOf(r100), r102);
    L8:
        StringBuilder r107 = new StringBuilder();
        char[] r108 = r101.toCharArray();
        int r109 = r108.length;
        int r110 = 0;
    L9:
        if (r110 >= r109) goto L14;
        char r111 = r108[r110];
        if (Character.isDigit(r111) == false) goto L13;
        r107.append(r111);
    L13:
        r110 = r110 + 1;
        goto L9
    L14:
        r102 = r107.toString();
        goto L16
    L5:
        return Pair.create(Integer.valueOf(r100), "");
    }

    public static int a(int r100, int[] r101, int r102, int r103) {
        int r104 = (r102 + r103) / 2;
        if (r104 == r102) goto L12;
        int r105 = r101[r104];
        if (r105 == r100) goto L12;
        if (r105 <= r100) goto L9;
        r103 = r104;
    L11:
        return a(r100, r101, r102, r103);
    L9:
        r102 = r104;
    L12:
        return r104;
    }
}
