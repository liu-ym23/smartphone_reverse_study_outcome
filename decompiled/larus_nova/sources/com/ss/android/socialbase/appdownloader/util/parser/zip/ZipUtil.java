package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes38.dex */
public abstract class ZipUtil {
    private static final byte[] DOS_TIME_MIN = null;

    public ZipUtil() {
    }

    public static long adjustToLong(int r100) {
        if (r100 >= 0) goto L6;
        return ((long) r100) + 4294967296L;
    L6:
        return r100;
    }

    static {
        DOS_TIME_MIN = ZipLong.getBytes(8448);
    }

    public static boolean canHandleEntryData(ZipEntry r100) {
        if (supportsEncryptionOf(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (supportsMethodOf(r100) == false) goto L7;
        return true;
    }

    public static void checkRequestedFeatures(ZipEntry r100) throws UnsupportedZipFeatureException {
        if (supportsEncryptionOf(r100) == false) goto L10;
        if (supportsMethodOf(r100) == false) goto L8;
        return;
    L8:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.METHOD, r100);
    L10:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.ENCRYPTION, r100);
    }

    public static byte[] copy(byte[] r100) {
        if (r100 == null) goto L5;
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    L5:
        return null;
    }

    public static long dosToJavaTime(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.set(1, ((int) ((r100 >> 25) & 127)) + 1980);
        r101.set(2, ((int) ((r100 >> 21) & 15)) - 1);
        r101.set(5, ((int) (r100 >> 16)) & 31);
        r101.set(11, ((int) (r100 >> 11)) & 31);
        r101.set(12, ((int) (r100 >> 5)) & 63);
        r101.set(13, ((int) (r100 << 1)) & 62);
        r101.set(14, 0);
        return r101.getTime().getTime();
    }

    public static Date fromDosTime(ZipLong r100) {
        return new Date(dosToJavaTime(r100.getValue()));
    }

    private static boolean supportsEncryptionOf(ZipEntry r100) {
        return !r100.getGeneralPurposeBit().usesEncryption();
    }

    private static boolean supportsMethodOf(ZipEntry r100) {
        if (r100.getMethod() != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100.getMethod() == 8) goto L8;
        return false;
    }

    public static ZipLong toDosTime(Date r100) {
        return new ZipLong(toDosTime(r100.getTime()));
    }

    public static byte[] toDosTime(long r100) {
        byte[] r101 = new byte[4];
        toDosTime(r100, r101, 0);
        return r101;
    }

    private static String getUnicodeStringIfOriginalMatches(AbstractUnicodeExtraField r100, byte[] r101) {
        if (r100 == null) goto L8;
        CRC32 r102 = new CRC32();
        r102.update(r101);
        if (r102.getValue() != r100.getNameCRC32()) goto L8;
        return ZipEncodingHelper.UTF8_ZIP_ENCODING.decode(r100.getUnicodeName());
    L8:
        return null;
    }

    public static void setNameAndCommentFromExtraFields(ZipEntry r100, byte[] r101, byte[] r102) {
        UnicodePathExtraField r103 = (UnicodePathExtraField) r100.getExtraField(UnicodePathExtraField.UPATH_ID);
        String r104 = r100.getName();
        String r105 = getUnicodeStringIfOriginalMatches(r103, r101);
        if (r105 != null) goto L5;
    L7:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.length <= 0) goto L15;
        String r106 = getUnicodeStringIfOriginalMatches((UnicodeCommentExtraField) r100.getExtraField(UnicodeCommentExtraField.UCOM_ID), r102);
        if (r106 == null) goto L16;
        r100.setComment(r106);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r104.equals(r105) == true) goto L7;
        r100.setName(r105);
        goto L7
    }

    public static void toDosTime(long r100, byte[] r101, int r102) {
        toDosTime(Calendar.getInstance(), r100, r101, r102);
    }

    public static void toDosTime(Calendar r100, long r101, byte[] r102, int r103) {
        r100.setTimeInMillis(r101);
        int r104 = r100.get(1);
        if (r104 >= 1980) goto L6;
        byte[] r105 = DOS_TIME_MIN;
        System.arraycopy(r105, 0, r102, r103, r105.length);
        return;
    L6:
        ZipLong.putLong((r100.get(13) >> 1) | ((((((r104 - 1980) << 25) | ((r100.get(2) + 1) << 21)) | (r100.get(5) << 16)) | (r100.get(11) << 11)) | (r100.get(12) << 5)), r102, r103);
    }
}
