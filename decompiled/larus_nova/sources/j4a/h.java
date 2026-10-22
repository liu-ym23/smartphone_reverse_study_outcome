package j4a;

import android.util.Base64;
import androidx.collection.SieveCacheKt;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;

/* JADX INFO: loaded from: classes32.dex */
public final class h {
    public static String a(String r100) throws IOException {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r101);
        long r103 = r101.length();
        if (r103 > SieveCacheKt.NodeLinkMask) goto L19;
        int r104 = (int) r103;
        byte[] r105 = new byte[r104];
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L9;
        int r107 = r102.read(r105, r106, r104 - r106);
        if (r107 < 0) goto L9;
        r106 = r106 + r107;
    L9:
        if (r106 < r104) goto L20;
        r102.close();
        return new String(Base64.encode(r105, 0));
    L20:
        r102.close();     // Catch: Exception -> L14
    L17:
        throw new IOException("Could not completely read file " + r101.getName());
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L19:
        throw new IOException("File is too large: " + r101.getName());
    }
}
