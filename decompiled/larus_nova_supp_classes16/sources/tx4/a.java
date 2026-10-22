package tx4;

import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: tx4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0301a {
    }

    static {
    }

    public static void a(VFSFile r11) {
        File r0 = r11.getParentFile();
        if (r0.exists() == false) goto L5;
    L65:
        PolarisZipFileWrapper r1 = new PolarisZipFileWrapper(r11);     // Catch: IOException -> L63
        Enumeration<? extends ZipEntry> r3 = r1.entries();     // Catch: IOException -> L63
        byte[] r4 = new byte[4096];     // Catch: IOException -> L63
    L11:
        if (r3.hasMoreElements() == false) goto L47;
        ZipEntry r5 = r3.nextElement();     // Catch: IOException -> L63
        String r6 = r5.getName();     // Catch: IOException -> L63
        if (r6 != null) goto L15;
    L19:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r0, r6);     // Catch: IOException -> L63
        if (r5.isDirectory() == true) goto L21;
        if (r7.getParentFile().exists() == true) goto L26;
        r7.getParentFile().mkdirs();     // Catch: IOException -> L63
    L26:
        if (r7.exists() == true) goto L28;
        r7.createNewFile();     // Catch: IOException -> L63
    L28:
        BufferedOutputStream r8 = null;
        BufferedInputStream r9 = new BufferedInputStream(r1.getInputStream(r5));     // Catch: Throwable -> L40
        BufferedOutputStream r10 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r7));     // Catch: Throwable -> L38
    L66:
        int r12 = r9.read(r4);     // Catch: Throwable -> L36
        if (r12 == (-1)) goto L34;
        r10.write(r4, 0, r12);     // Catch: Throwable -> L36
        goto L66
    L34:
        r10.flush();     // Catch: Throwable -> L36
        r10.close();     // Catch: IOException -> L63
        r9.close();     // Catch: IOException -> L63
    L36:
        th = th;
        r8 = r10;
    L42:
        if (r8 == null) goto L44;
        r8.close();     // Catch: IOException -> L63
    L44:
        if (r9 == null) goto L46;
        r9.close();     // Catch: IOException -> L63
    L46:
        throw th;     // Catch: IOException -> L63
    L38:
        th = th;
    L40:
        th = th;
        r9 = null;
        goto L42
    L21:
        r7.mkdirs();     // Catch: IOException -> L63
        goto L11
    L15:
        if (r6.contains("..") == false) goto L19;
        throw new SecurityException("android_framework_utils#ZipUtils: unzip slip");     // Catch: IOException -> L63
    L47:
        r11.delete();
        File r13 = r11.getParentFile();
        if (r13 != null) goto L50;
        return;
    L50:
        FileUtils.n(VFSFiles.b.H(r13, "__MACOSX"));
        File[] r2 = r13.listFiles();
        if (r2 == null) goto L61;
        int r14 = r2.length;
        int r16 = 0;
    L53:
        if (r16 >= r14) goto L61;
        VFSFile r17 = VFSFiles.b.D(r13, r2[r16].getName());
        if (r17.isDirectory() == false) goto L60;
        File[] r18 = r17.listFiles();
        int r19 = r18.length;
        int r20 = 0;
    L57:
        if (r20 >= r19) goto L59;
        File r21 = r18[r20];
        r21.renameTo(VFSFiles.b.D(r13, r21.getName()));
        r20 = r20 + 1;
        goto L57
    L59:
        r17.delete();
    L60:
        r16 = r16 + 1;
    L61:
        PolarisFileWriterWrapper r22 = new PolarisFileWriterWrapper(VFSFiles.b.D(r13, "creation_ai_revision"));
        r22.write("version:999");
        r22.flush();
        r22.close();
        return;
    L63:
        e = move-exception;
        throw e;
    L5:
        if (r0.mkdirs() == true) goto L65;
        throw new IOException(String.format("create directory %s fail", new Object[]{r0.getPath()}));
    }
}
