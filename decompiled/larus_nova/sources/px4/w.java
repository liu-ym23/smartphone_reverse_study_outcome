package px4;

import android.content.Context;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

/* JADX INFO: loaded from: classes16.dex */
public final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f530920c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f530921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jx4.u f530922b;

    public static final class a {
        public static void a(VFSPath r100, VFSPath r101) throws IOException {
            Intrinsics.checkNotNullParameter(r100, "srcfile");
            Intrinsics.checkNotNullParameter(r101, "destpath");
            byte[] r102 = new byte[1024];
            TarArchiveInputStream r103 = new TarArchiveInputStream(new GzipCompressorInputStream(new BufferedInputStream(ay4.d.a().l(r100))));
        L3:
            TarArchiveEntry r104 = r103.getNextTarEntry();
            if (r104 == null) goto L19;
            String r105 = r104.getName();
            if (r105 == null) goto L3;
            VFSPath r106 = r101.subPath(r105);
            Intrinsics.checkNotNull(r104);
            if (r104.isDirectory() == true) goto L10;
            VFSPath r107 = r106.getParent();
            Intrinsics.checkNotNull(r107);
            if (com.suite.lark.component.storage.ext.b.b(r107) == true) goto L14;
            com.suite.lark.component.storage.ext.b.d(r107);
        L14:
            BufferedOutputStream r108 = new BufferedOutputStream(ay4.d.a().s(r106, false));
        L15:
            int r109 = r103.read(r102);
            if (r109 == (-1)) goto L18;
            r108.write(r102, 0, r109);
            goto L15
        L18:
            r108.flush();
            r108.close();
            goto L3
        L10:
            com.suite.lark.component.storage.ext.b.d(r106);
            goto L3
        L19:
            r103.close();
        }
    }

    static {
    }

    public w(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f530921a = r100;
    }

    public final void a(Exception r100, VFSPath r101, VFSPath r102) {
        Intrinsics.checkNotNullParameter(r101, "srcDir");
        Intrinsics.checkNotNullParameter(r102, "destDir");
        tt5.a.e("LynxDownloadScmPresenter", "onDownloadError", r100, false);
        FileUtils.m(r101);     // Catch: IOException -> L5
        FileUtils.m(r102);     // Catch: IOException -> L5
    L6:
        com.bytedance.ee.util.ui.j.c(new z(this));
        return;
    L5:
        tt5.a.e("LynxDownloadScmPresenter", "onDownloadError deleteFile ", r100, false);
        goto L6
    }
}
