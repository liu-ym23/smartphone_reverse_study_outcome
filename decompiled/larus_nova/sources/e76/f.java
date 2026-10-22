package e76;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes19.dex */
public final class f {
    public static String a(PolarisFileWrapper r100, String r101) throws IOException {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L5;
        r102.mkdir();
    L5:
        ZipInputStream r103 = new ZipInputStream(new PolarisFileInputStreamWrapper(r100));
        ZipEntry r104 = r103.getNextEntry();
        Boolean r105 = Boolean.FALSE;
        String r106 = "";
    L6:
        if (r104 == null) goto L25;
        String r107 = r101 + File.separator + r104.getName();
        if (r104.getName().contains("__MACOSX") == true) goto L24;
        if (r104.getName().contains(".DS_Store") == true) goto L24;
        if (r104.getName().contains("../") == true) goto L24;
        if (r104.isDirectory() == true) goto L20;
        BufferedOutputStream r108 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r107));
        byte[] r109 = new byte[4096];
    L16:
        int r110 = r103.read(r109);
        if (r110 == (-1)) goto L19;
        r108.write(r109, 0, r110);
        goto L16
    L19:
        r108.close();
        goto L24
    L20:
        PolarisFileWrapper r111 = new PolarisFileWrapper(r107);
        if (r105.booleanValue() == true) goto L23;
        r105 = Boolean.TRUE;
        r106 = r104.getName();
    L23:
        r111.mkdirs();
    L24:
        r103.closeEntry();
        r104 = r103.getNextEntry();
        goto L6
    L25:
        r103.close();
        return r106;
    }
}
