package ws7;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.log.RecordService;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.UUID;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static String a(String r100) {
        return Base64.encodeToString(r100.getBytes(), 2);
    L4:
        return "";
    }

    public static String b(byte[] r100) {
        return Base64.encodeToString(r100, 2);
    L5:
        return "";
    }

    public static byte[] c(Bitmap r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Throwable -> L9
        r100.compress(Bitmap.CompressFormat.JPEG, 80, r101);     // Catch: Throwable -> L7
        r101.flush();     // Catch: Throwable -> L7
        byte[] r102 = r101.toByteArray();     // Catch: Throwable -> L7
        j(r101);
        return r102;
    L7:
        th = th;
    L17:
        RecordService.getInstance().recordException(th);     // Catch: Throwable -> L14
        j(r101);
        return null;
    L14:
        th = move-exception;
        j(r101);
        throw th;
    L9:
        th = th;
        r101 = null;
        goto L17
    }

    public static String e(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L17
        if (r101.exists() == true) goto L6;
        return "";
    L6:
        int r102 = (int) r101.length();     // Catch: Throwable -> L17
        byte[] r103 = new byte[r102];     // Catch: Throwable -> L17
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L17
    L15:
        th = th;
    L25:
        RecordService.getInstance().recordException(th);     // Catch: Throwable -> L22
        i(r104);
        return "";
    L22:
        th = move-exception;
        i(r104);
        throw th;
    L9:
        if (r104.read(r103, 0, r102) == r102) goto L12;
        i(r104);
        return "";
    L12:
        String r105 = f(r103);     // Catch: Throwable -> L15
        i(r104);
        return r105;
    L17:
        th = th;
        r104 = null;
        goto L25
    }

    public static String f(byte[] r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L15
        r101.update(r100);     // Catch: Throwable -> L15
        byte[] r102 = r101.digest();     // Catch: Throwable -> L15
        if (r102 == null) goto L23;
        StringBuilder r103 = new StringBuilder("");     // Catch: Throwable -> L15
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L13;
        String r105 = Integer.toHexString(r102[r104] & UByte.MAX_VALUE);     // Catch: Throwable -> L15
        if (r105.length() != 1) goto L12;
        r105 = "0".concat(r105);     // Catch: Throwable -> L15
    L12:
        r103.append(r105);     // Catch: Throwable -> L15
        r104 = r104 + 1;     // Catch: Throwable -> L15
        goto L8
    L13:
        return r103.toString().trim();
    L23:
        return "";
    L15:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        return "";
    }

    public static String g(Context r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L9
        InputStream r102 = r100.getResources().getAssets().open("bid-log-key-public.key");     // Catch: Throwable -> L9
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L9
    L4:
        int r104 = r102.read(r103);     // Catch: Throwable -> L9
        if ((-1) == r104) goto L7;
        r101.append(new String(r103, 0, r104));     // Catch: Throwable -> L9
        goto L4
    L7:
        return r101.toString();
    L9:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        return "";
    }

    public static byte[] h(String r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L13
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L13
    L22:
        int r104 = r103.read(r102, 0, 1024);     // Catch: Throwable -> L17
        if ((-1) == r104) goto L10;
        r101.write(r102, 0, r104);     // Catch: Throwable -> L17
        goto L22
    L10:
        byte[] r105 = r101.toByteArray();     // Catch: Throwable -> L17
        i(r103);
        j(r101);
        return r105;
    L15:
        i(r103);
        j(r101);
        return null;
    L13:
        r103 = null;
    L14:
        r101 = null;
        r103 = null;
        goto L15
    }

    public static void i(PolarisFileInputStreamWrapper r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void j(OutputStream r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static String d(String r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append("_");
        r103.append(r101);
        r103.append("_");
        String r104 = UUID.randomUUID().toString();
        r103.append(r104.substring(r104.length() - 4));
        r103.append(".");
        r103.append(r102);
        return r103.toString();
    }
}
