package mqc;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes41.dex */
public final class l {
    public static void a(String r100, String r101) throws IOException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L24;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L10;
        return;
    L10:
        if (r102.isFile() == true) goto L12;
        return;
    L12:
        if (r102.canRead() == true) goto L15;
        return;
    L15:
        if (r103.getParentFile() != null) goto L17;
    L19:
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r101);
        FileChannel r106 = r104.getChannel();
        FileChannel r107 = r105.getChannel();
        r107.write(r106.map(FileChannel.MapMode.READ_ONLY, 0, r106.size()));
        r106.close();
        r107.close();
        r104.close();
        r105.close();
        return;
    L17:
        if (r103.getParentFile().exists() == true) goto L19;
        r103.getParentFile().mkdirs();
        goto L19
    }
}
