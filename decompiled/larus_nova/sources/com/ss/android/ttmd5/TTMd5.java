package com.ss.android.ttmd5;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.m.u.i;
import com.amap.api.col.s.ce;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;
import kotlin.UByte;
import lgc.b;

/* JADX INFO: loaded from: classes6.dex */
public class TTMd5 {
    private static final int DEFAULT_SAMPLE_COUNT = 9;
    private static final int DEFAULT_SAMPLE_SIZE = 8192;
    private static final char[] HEX_CHARS = null;
    private static final String PROTOCOL = "ttmd5";
    private static final String TAG = "TTMd5";
    private static final int VERSION_MAIN = 1;
    private static final int VERSION_SUB = 1;

    /* JADX INFO: loaded from: classes38.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CHECK_MD5_STATUS {
        public static final int FILE_NOT_EXIST = 5;
        public static final int GET_FILE_MD5_ERROR = 6;
        public static final int MD5_EMPTY = 2;
        public static final int MD5_MATCH = 0;
        public static final int MD5_NOT_MATCH = 1;
        public static final int TTMD5_TAG_PARSER_ERROR = 4;
        public static final int TTMD5_VERSION_NOT_SUPPORT = 3;
        public static final int UNKNOWN_ERROR = 99;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f449821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f449822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f449823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f449824d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f449825e;

        public a() {
        }
    }

    public TTMd5() {
    }

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    private static long decryptNum(String r100) throws RuntimeException {
        return (CastLongProtector.parseLong(r100, 16) - 31) >> 4;
    L7:
        throw new RuntimeException("ttmd5 decryptNum error, num = " + r100);
    }

    private static String encryptionNum(long r100) {
        return Long.toHexString((r100 << 4) + 31);
    }

    public static String md5(File r100) {
        return ttmd5(r100, -1, -1);
    }

    private static a parserTTMd5Args(String r100) throws Exception {
        if (r100.startsWith("ttmd5:") == true) goto L6;
        return null;
    L6:
        String[] r101 = r100.split(i.f25853b);
        String[] r102 = r101[0].split(":");
        a r103 = new a();
        int r104 = CastIntegerProtector.parseInt(r102[1]);
        r103.f449821a = r104;
        if (r104 <= 1) goto L9;
        return r103;
    L9:
        r103.f449822b = CastIntegerProtector.parseInt(r102[2]);
        String[] r105 = r102[3].split(ce.f26391f);
        r103.f449823c = (int) decryptNum(r105[0]);
        r103.f449824d = decryptNum(r105[1]);
        r103.f449825e = r101[1];
        return r103;
    }

    private static String toHexString(byte[] r110) {
        if (r110 == null) goto L9;
        int r100 = r110.length;
        int r101 = r100 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100) goto L7;
        int r105 = r110[r103 + 0] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = HEX_CHARS;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L4
    L7:
        return new String(r102, 0, r101);
    L9:
        throw new NullPointerException("bytes is null");
    }

    public static String ttmd5(File r100) {
        return ttmd5(r100, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(b r100) {
        return ttmd5(r100, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static int checkMd5(File r100, File r101) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L24;
    L17:
        th = move-exception;
        th.printStackTrace();
        return 99;
    L5:
        if (r100.exists() == true) goto L7;
        return 5;
    L7:
        if (r101.exists() == true) goto L10;
        return 5;
    L10:
        if (r100 != r101) goto L12;
        return 0;
    L12:
        if (_ttmd5(r100, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI).equals(_ttmd5(r101, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) == false) goto L15;
        return 0;
    L15:
        return 1;
    L24:
        return 5;
    L20:
        return 5;
    }

    private static String generateTTMd5Tag(int r100, long r101) {
        return "ttmd5:1:1:" + encryptionNum(r100) + ce.f26391f + encryptionNum(r101);
    }

    public static String ttmd5(File r100, int r101) {
        return ttmd5(r100, r101, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static int checkMd5(String r100, File r101) {
        return checkMd5(r100, r101, null);
    }

    public static String ttmd5(b r100, int r101) {
        return ttmd5(r100, r101, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static String _ttmd5(b r210, int r211, long r212) throws Exception {
        int r100 = r211;
        MessageDigest r101 = MessageDigest.getInstance("MD5");
        if (r101 != null) goto L41;
        return "";
    L41:
        lgc.a r102 = (lgc.a) r210;     // Catch: Throwable -> L31
        long r110 = r102.f509217a.length();     // Catch: Throwable -> L31
        if (r100 > 0) goto L9;
    L14:
        long r111 = r110;
        r100 = 1;
    L15:
        byte[] r112 = new byte[8192];     // Catch: Throwable -> L31
        long r113 = 0;
        updateSample(r102, r101, r112, 0, r111);     // Catch: Throwable -> L31
        if (r100 <= 2) goto L20;
        int r103 = r100 - 1;     // Catch: Throwable -> L31
        long r114 = (r110 - (((long) r100) * r111)) / ((long) r103);     // Catch: Throwable -> L31
        int r104 = 1;
    L18:
        if (r104 >= r103) goto L20;
        r113 = r113 + (r111 + r114);     // Catch: Throwable -> L31
        updateSample(r102, r101, r112, r113, r111);     // Catch: Throwable -> L31
        r104 = r104 + 1;     // Catch: Throwable -> L31
        r103 = r103;
    L20:
        if (r100 <= 1) goto L22;
        updateSample(r102, r101, r112, r110 - r111, r111);     // Catch: Throwable -> L31
    L22:
        String r105 = toHexString(r101.digest());     // Catch: Throwable -> L31
        if (r100 == 1) goto L25;
    L28:
        String r106 = generateTTMd5Tag(r100, r111) + i.f25853b + r105;     // Catch: Throwable -> L31
        r102.f509217a.close();     // Catch: Throwable -> L35
    L30:
        return r106;
    L25:
        if (r111 != r110) goto L28;
        r102.f509217a.close();     // Catch: Throwable -> L34
    L27:
        return r105;
    L9:
        if (r212 <= 0) goto L14;
        if ((((long) r100) * r212) > ((8 * r110) / 10)) goto L14;
        r111 = r212;
    L31:
        th = move-exception;
        ((lgc.a) r210).f509217a.close();     // Catch: Throwable -> L36
    L33:
        throw th;
    }

    public static int checkMd5(String r100, File r101, b r102) {
        if (r100 != null) goto L4;
        return 2;
    L4:
        if (r100.length() != 0) goto L78;
        return 2;
    L78:
        if (r102 == null) goto L13;
        lgc.a r103 = (lgc.a) r102;     // Catch: Throwable -> L66
        if (r103.f509217a.length() > 0) goto L76;
        r103.f509217a.close();     // Catch: Throwable -> L71
    L12:
        return 5;
    L76:
        a r104 = parserTTMd5Args(r100);     // Catch: Throwable -> L64
        if (r104 != null) goto L21;
        int r105 = -1;
        long r106 = -1;
    L27:
        a r107 = null;
        if (r102 == null) goto L30;
        String r108 = _ttmd5(r102, r105, r106);     // Catch: Throwable -> L32
    L79:
    L34:
        if (r108 != null) goto L36;
        return 6;
    L36:
        if (r108.length() != 0) goto L39;
        return 6;
    L39:
        if (r104 == null) goto L59;
        if (r104.f449821a != 1) goto L46;
        if (r104.f449822b == 1) goto L59;
    L46:
        if (r104.f449825e != null) goto L72;
    L61:
        return 1;
    L72:
        r107 = parserTTMd5Args(r108);     // Catch: Throwable -> L49
    L50:
        if (r107 == null) goto L61;
        if (r104.f449823c != r107.f449823c) goto L61;
        if (r104.f449824d != r107.f449824d) goto L61;
        if (r104.f449825e.equals(r107.f449825e) == false) goto L61;
        return 0;
    L59:
        if (r108.equals(r100) == false) goto L61;
        return 0;
    L30:
        r108 = _ttmd5(r101, r105, r106);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
        r108 = null;
        goto L34
    L21:
        if (r104.f449821a <= 1) goto L24;
        return 3;
    L24:
        r105 = r104.f449823c;     // Catch: Throwable -> L66
        r106 = r104.f449824d;     // Catch: Throwable -> L66
    L64:
        return 4;
    L13:
        if (r101 != null) goto L15;
    L68:
        return 5;
    L15:
        if (r101.exists() == true) goto L76;
    L66:
        return 99;
    }

    public static String ttmd5(File r100, int r101, long r102) {
        if (r100 != null) goto L12;
    L11:
        return "";
    L12:
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    L5:
        if (r100.exists() == false) goto L11;
        return _ttmd5(r100, r101, r102);
    }

    private static String _ttmd5(File r100, int r101, long r102) throws Exception {
        return _ttmd5(new lgc.a(r100), r101, r102);
    }

    public static String ttmd5(b r100, int r101, long r102) {
        if (r100 != null) goto L10;
        return "";
    L10:
        return _ttmd5(r100, r101, r102);
    L7:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    private static void updateSample(b r100, MessageDigest r101, byte[] r102, long r103, long r104) throws IOException {
        ((lgc.a) r100).f509217a.seek(r103);
        long r105 = 0;
    L4:
        if (r105 >= r104) goto L10;
        int r106 = ((lgc.a) r100).f509217a.read(r102, 0, (int) Math.min(r104 - r105, r102.length));
        if (r106 <= 0) goto L9;
        r101.update(r102, 0, r106);
        r105 = r105 + ((long) r106);
        goto L4
    L9:
        throw new IOException("updateSample unexpected readCount <= 0, readCount = " + r106 + ", readTotalCount = " + r105 + ", sampleSize = " + r104);
    }
}
