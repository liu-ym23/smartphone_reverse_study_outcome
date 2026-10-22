package tx4;

import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f547817a = 0;

    /* JADX INFO: renamed from: tx4.a$a, reason: collision with other inner class name */
    public interface InterfaceC7790a {
    }

    static {
    }

    public static void a(VFSFile r110) {
        File r100 = r110.getParentFile();
        if (r100.exists() == false) goto L5;
    L65:
        PolarisZipFileWrapper r101 = new PolarisZipFileWrapper(r110);     // Catch: IOException -> L63
        Enumeration<? extends ZipEntry> r102 = r101.entries();     // Catch: IOException -> L63
        byte[] r103 = new byte[4096];     // Catch: IOException -> L63
    L11:
        if (r102.hasMoreElements() == false) goto L47;
        ZipEntry r104 = r102.nextElement();     // Catch: IOException -> L63
        String r105 = r104.getName();     // Catch: IOException -> L63
        if (r105 != null) goto L15;
    L19:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100, r105);     // Catch: IOException -> L63
        if (r104.isDirectory() == true) goto L21;
        if (r106.getParentFile().exists() == true) goto L26;
        r106.getParentFile().mkdirs();     // Catch: IOException -> L63
    L26:
        if (r106.exists() == true) goto L28;
        r106.createNewFile();     // Catch: IOException -> L63
    L28:
        BufferedOutputStream r107 = null;
        BufferedInputStream r108 = new BufferedInputStream(r101.getInputStream(r104));     // Catch: Throwable -> L40
        BufferedOutputStream r109 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r106));     // Catch: Throwable -> L38
    L66:
        int r111 = r108.read(r103);     // Catch: Throwable -> L36
        if (r111 == (-1)) goto L34;
        r109.write(r103, 0, r111);     // Catch: Throwable -> L36
        goto L66
    L34:
        r109.flush();     // Catch: Throwable -> L36
        r109.close();     // Catch: IOException -> L63
        r108.close();     // Catch: IOException -> L63
    L36:
        th = th;
        r107 = r109;
    L42:
        if (r107 == null) goto L44;
        r107.close();     // Catch: IOException -> L63
    L44:
        if (r108 == null) goto L46;
        r108.close();     // Catch: IOException -> L63
    L46:
        throw th;     // Catch: IOException -> L63
    L38:
        th = th;
    L40:
        th = th;
        r108 = null;
        goto L42
    L21:
        r106.mkdirs();     // Catch: IOException -> L63
        goto L11
    L15:
        if (r105.contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L19;
        throw new SecurityException("android_framework_utils#ZipUtils: unzip slip");     // Catch: IOException -> L63
    L47:
        r110.delete();
        File r112 = r110.getParentFile();
        if (r112 != null) goto L50;
        return;
    L50:
        FileUtils.n(VFSFiles.f444819b.H(r112, "__MACOSX"));
        File[] r113 = r112.listFiles();
        if (r113 == null) goto L61;
        int r114 = r113.length;
        int r115 = 0;
    L53:
        if (r115 >= r114) goto L61;
        VFSFile r116 = VFSFiles.f444819b.D(r112, r113[r115].getName());
        if (r116.isDirectory() == false) goto L60;
        VFSFile[] r117 = r116.listFiles();
        int r118 = r117.length;
        int r119 = 0;
    L57:
        if (r119 >= r118) goto L59;
        VFSFile r120 = r117[r119];
        r120.renameTo(VFSFiles.f444819b.D(r112, r120.getName()));
        r119 = r119 + 1;
        goto L57
    L59:
        r116.delete();
    L60:
        r115 = r115 + 1;
    L61:
        PolarisFileWriterWrapper r121 = new PolarisFileWriterWrapper(VFSFiles.f444819b.D(r112, "creation_ai_revision"));
        r121.write("version:999");
        r121.flush();
        r121.close();
        return;
    L63:
        e = move-exception;
        throw e;
    L5:
        if (r100.mkdirs() == true) goto L65;
        throw new IOException(String.format("create directory %s fail", new Object[]{r100.getPath()}));
    }
}
