package px4;

import android.content.Context;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSPath;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w {
    public static final /* synthetic */ int c = 0;
    public final Context a;
    public jx4.u b;

    public static final class a {
        public static void a(VFSPath r5, VFSPath r6) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "srcfile");
            Intrinsics.checkNotNullParameter(r6, "destpath");
            byte[] r0 = new byte[1024];
            TarArchiveInputStream r1 = new TarArchiveInputStream(new GzipCompressorInputStream(new BufferedInputStream(ay4.d.a().l(r5))));
        L3:
            TarArchiveEntry r7 = r1.getNextTarEntry();
            if (r7 == null) goto L19;
            String r2 = r7.getName();
            if (r2 == null) goto L3;
            VFSPath r3 = r6.subPath(r2);
            Intrinsics.checkNotNull(r7);
            if (r7.isDirectory() == true) goto L10;
            VFSPath r8 = r3.getParent();
            Intrinsics.checkNotNull(r8);
            if (com.suite.lark.component.storage.ext.b.b(r8) == true) goto L14;
            com.suite.lark.component.storage.ext.b.d(r8);
        L14:
            BufferedOutputStream r4 = new BufferedOutputStream(ay4.d.a().s(r3, false));
        L15:
            int r9 = r1.read(r0);
            if (r9 == (-1)) goto L18;
            r4.write(r0, 0, r9);
            goto L15
        L18:
            r4.flush();
            r4.close();
            goto L3
        L10:
            com.suite.lark.component.storage.ext.b.d(r3);
            goto L3
        L19:
            r1.close();
        }
    }

    static {
    }

    public w(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void a(Exception r4, VFSPath r5, VFSPath r6) {
        Intrinsics.checkNotNullParameter(r5, "srcDir");
        Intrinsics.checkNotNullParameter(r6, "destDir");
        tt5.a.e("LynxDownloadScmPresenter", "onDownloadError", r4, false);
        FileUtils.m(r5);     // Catch: IOException -> L5
        FileUtils.m(r6);     // Catch: IOException -> L5
    L6:
        com.bytedance.ee.util.ui.j.c(new z(this));
        return;
    L5:
        tt5.a.e("LynxDownloadScmPresenter", "onDownloadError deleteFile ", r4, false);
        goto L6
    }
}
