package com.bytedance.geckox.utils;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.gkfs.io.GkFSFileInputStream;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import ez5.b;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000bJ\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000bJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0007J\"\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/geckox/utils/MD5Utils;", "", "()V", "HEX_CHARS", "", "check", "", "file", "Ljava/io/File;", "md5", "", "check$geckox_noasanRelease", "inputStream", "Ljava/io/InputStream;", "getHash", "hashType", "inStream", "getMD5", "getMD5$geckox_noasanRelease", "stringToMd5", "str", "toHexString", HTTP.CONTENT_RANGE_BYTES, "", "off", "", "len", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class MD5Utils {
    private static final char[] HEX_CHARS = null;
    public static final MD5Utils INSTANCE = null;

    private MD5Utils() {
    }

    static {
        INSTANCE = new MD5Utils();
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    @JvmStatic
    public static final String stringToMd5(String r100) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        MessageDigest r101 = MessageDigest.getInstance("MD5");
        r101.update(r100.getBytes(Charsets.UTF_8));
        byte[] r102 = r101.digest();
        return INSTANCE.toHexString(r102, 0, r102.length);
    }

    public final String getMD5(InputStream r100) throws Exception {
        return getHash(r100, "MD5");
    }

    public final String getMD5$geckox_noasanRelease(File r100) throws Exception {
        return getHash(r100, "MD5");
    }

    private final String getHash(InputStream r100, String r101) throws Exception {
        byte[] r102 = new byte[8192];
        MessageDigest r103 = MessageDigest.getInstance(r101);     // Catch: Throwable -> L10 Exception -> L12
    L4:
        int r104 = r100.read(r102);     // Catch: Throwable -> L10 Exception -> L12
        if (r104 == (-1)) goto L7;
        r103.update(r102, 0, r104);     // Catch: Throwable -> L10 Exception -> L12
        goto L4
    L7:
        byte[] r105 = r103.digest();     // Catch: Throwable -> L10 Exception -> L12
        String r106 = toHexString(r105, 0, r105.length);     // Catch: Throwable -> L10 Exception -> L12
        b.a(r100);
        return r106;
    L10:
        th = move-exception;
        b.a(r100);
        throw th;
    L12:
        e = move-exception;
        throw new RuntimeException("getHash error: " + e.getMessage());     // Catch: Throwable -> L10
    }

    public final void check$geckox_noasanRelease(File r100, String r101) throws Exception {
        if (r100.isFile() == false) goto L11;
        if (r101 == null) goto L11;
        String r102 = getMD5$geckox_noasanRelease(r100);
        if ((!Intrinsics.areEqual(r102, r101)) == true) goto L9;
        return;
    L9:
        throw new RuntimeException("md5 check failed file:" + r100.getPath() + ", local md5:" + r102 + ", expect md5:" + r101);
    L11:
        throw new RuntimeException("md5 check failed: file.isFile() == false || md5 == null");
    }

    private final String getHash(File r100, String r101) throws Exception {
        InputStream r102 = null;
        List<Function0<Unit>> r103 = GkFSUtils.f245072a;     // Catch: Throwable -> L10
        if (GkFSUtils.g(r100.getPath()) == false) goto L6;
        InputStream r104 = new GkFSFileInputStream(r100, false);     // Catch: Throwable -> L10
    L7:
        r102 = r104;
        String r105 = getHash(r102, r101);     // Catch: Throwable -> L10
        b.a(r102);
        return r105;
    L6:
        r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        b.a(r102);
        throw th;
    }

    public final void check$geckox_noasanRelease(InputStream r100, String r101) throws Exception {
        if (r101 == null) goto L9;
        String r102 = getMD5(r100);
        if ((!Intrinsics.areEqual(r102, r101)) == true) goto L7;
        return;
    L7:
        throw new RuntimeException("md5 check failed file: local md5:" + r102 + " expect md5:" + r101);
    L9:
        throw new RuntimeException("md5 check failed: md5 == null");
    }

    private final String toHexString(byte[] r110, int r111, int r112) {
        if (r110 == null) goto L14;
        if (r111 < 0) goto L12;
        if ((r111 + r112) > r110.length) goto L12;
        int r100 = r112 * 2;
        char[] r101 = new char[r100];
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r102 >= r112) goto L10;
        int r104 = r110[r102 + r111] & UByte.MAX_VALUE;
        int r105 = r103 + 1;
        char[] r106 = HEX_CHARS;
        r101[r103] = r106[r104 >> 4];
        r103 = r105 + 1;
        r101[r105] = r106[r104 & 15];
        r102 = r102 + 1;
        goto L7
    L10:
        return new String(r101, 0, r100);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }
}
