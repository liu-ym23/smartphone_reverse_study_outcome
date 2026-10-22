package ws7;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.dtf.face.log.RecordService;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class f {
    public static List<String> a(File r100) {
        List<String> r101 = new ArrayList();
        if (r100 != null) goto L5;
    L11:
        return r101;
    L5:
        if (r100.exists() == false) goto L11;
        if (r100.isDirectory() == false) goto L11;
        r101 = d(r100.getAbsolutePath());     // Catch: Throwable -> L12
        if (r100.delete() == true) goto L11;
        r101.add(r100.getAbsolutePath());     // Catch: Throwable -> L12
        goto L11
    }

    public static List<String> d(String r100) {
        ArrayList r101 = new ArrayList();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r101.add(r100);
        return r101;
    L5:
        return c(new PolarisFileWrapper(r100), null);
    }

    public static void e(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        f(new PolarisFileWrapper(r100));
        return;
    }

    public static boolean f(File r100) {
        if (r100.exists() == true) goto L5;
        return false;
    L5:
        if (r100.isFile() == false) goto L13;
        return r100.delete();
    L14:
        return false;
    L13:
        return false;
    }

    public static byte[] g(File r100) {
        if (r100 != null) goto L5;
    L11:
        return null;
    L5:
        if (r100.exists() == false) goto L11;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L9
        byte[] r102 = new byte[(int) r100.length()];     // Catch: Throwable -> L9
        r101.read(r102);     // Catch: Throwable -> L9
        r101.close();     // Catch: Throwable -> L9
        return r102;
    L9:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L11
    }

    public static List c(PolarisFileWrapper r100, List r101) {
        ArrayList r102 = new ArrayList();
        if (r100.exists() == true) goto L5;
    L30:
        return r102;
    L5:
        if (r100.isDirectory() == false) goto L30;
        File[] r103 = r100.listFiles();
        if (r103 == null) goto L30;
        if (r103.length <= 0) goto L30;
        int r104 = r103.length;
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L30;
        File r106 = r103[r105];
        if (r106 == null) goto L29;
        if (r106.exists() == false) goto L29;
        if (r106.isFile() == false) goto L25;
        if (r101 == null) goto L22;
        ArrayList r107 = (ArrayList) r101;
        if (r107.contains(r106.getName()) == true) goto L25;
    L22:
        if (f(r106) == true) goto L29;
        r102.add(r106.getAbsolutePath());
    L25:
        if (r106.isDirectory() == false) goto L29;
        List<String> r108 = a(r106);
        if (r108.size() <= 0) goto L29;
        r102.addAll(r108);
    L29:
        r105 = r105 + 1;
        goto L11
    }

    public static void h(PolarisFileWrapper r100, String r101) {
        f(r100);
        BufferedWriter r102 = null;
        r100.createNewFile();     // Catch: Throwable -> L12
        PolarisFileWriterWrapper r103 = new PolarisFileWriterWrapper(r100);     // Catch: Throwable -> L12
        BufferedWriter r104 = new BufferedWriter(r103);     // Catch: Throwable -> L10
        r104.write(r101);     // Catch: Throwable -> L8
        r104.flush();     // Catch: Throwable -> L8
        r104.close();     // Catch: Throwable -> L8
        r103.close();     // Catch: Throwable -> L8
        r104.close();     // Catch: Exception -> L26
        r103.close();     // Catch: Exception -> L26
        return;
    L8:
        Throwable th10 = th;
        r102 = r104;
    L36:
        RecordService.getInstance().recordException(th10);     // Catch: Throwable -> L20
        if (r102 == null) goto L17;
        r102.close();     // Catch: Exception -> L26
    L17:
        if (r103 == null) goto L38;
        r103.close();     // Catch: Exception -> L26
        return;
    L38:
        return;
    L20:
        th = move-exception;
        if (r102 != null) goto L31;
    L23:
        if (r103 == null) goto L25;
        r103.close();     // Catch: Exception -> L27
    L25:
        throw th;
    L31:
        r102.close();     // Catch: Exception -> L27
    L10:
        th = move-exception;
        th10 = th;
    L12:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L36
    }

    public static void b(PolarisFileWrapper r110, String r111, String r112) {
        if (r110.exists() == true) goto L5;
        return;
    L5:
        if (r110.isDirectory() == false) goto L41;
        File[] r100 = r110.listFiles();
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.length <= 0) goto L43;
        int r101 = r100.length;
        int r102 = 0;
    L11:
        if (r102 >= r101) goto L44;
        File r103 = r100[r102];
        if (r103 == null) goto L30;
        if (r103.exists() == false) goto L30;
        if (r112 == null) goto L24;
        if (r103.getName().contains(r112) == false) goto L24;
        if (f(r103) == true) goto L30;
        RecordService.getInstance().recordEvent(2, "fileDeleteError", new String[]{"msg", r110.getAbsolutePath()});
    L24:
        if (TextUtils.isEmpty(r111) == true) goto L30;
        if (r111.equals(i.e(r103.getAbsolutePath())) == false) goto L30;
        if (f(r103) == true) goto L30;
        RecordService.getInstance().recordEvent(2, "fileDeleteError", new String[]{"msg", r110.getAbsolutePath()});
    L30:
        r102 = r102 + 1;
        goto L11
    L44:
        return;
    L43:
        return;
    }
}
