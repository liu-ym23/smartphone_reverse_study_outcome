package zx5;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    static {
        Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
    }

    public static void a(File r100) throws IOException {
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L16;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L10;
        a(r104);
    L10:
        if (r104.delete() == false) goto L13;
        r103 = r103 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: " + r104);
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: " + r100);
    }
}
