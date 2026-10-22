package px4;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static String a;

    static {
    }

    @JvmStatic
    public static final String b(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        VFSFile r10 = VFSFiles.b.z(com.ss.android.lark.storage.f.d.a(r9, null)).subPath(((zm4.b) org.koin.java.a.c(zm4.b.class, null, null, 6)).a().c()).subPath("current_revision").toFile();
        tt5.a.b("BitableSCMResourceDownloader", "getDownloadedLynxVersion, revisionPath:" + r10.getAbsolutePath());
        if (r10.exists() == true) goto L38;
        return "";
    L38:
        BufferedReader r4 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r10)));     // Catch: IOException -> L35
        Ref.ObjectRef r11 = new Ref.ObjectRef();     // Catch: Throwable -> L30
    L8:
        String r5 = r4.readLine();     // Catch: Throwable -> L30
        r11.element = r5;     // Catch: Throwable -> L30
        if (r5 == null) goto L28;
        tt5.a.h("BitableSCMResourceDownloader", "getDownloadedLynxVersion, read line:" + ((String) r11.element));     // Catch: Throwable -> L30
        String r6 = (String) r11.element;     // Catch: Throwable -> L30
        if (r6 == null) goto L16;
        boolean r8 = true;
        if (StringsKt.startsWith$default(r6, "version:", false, 2, null) != true) goto L16;
    L17:
        if (r8 == false) goto L8;
        String r12 = (String) r11.element;     // Catch: Throwable -> L30
        if (r12 == null) goto L24;
        String r13 = StringsKt.substringAfter$default(r12, "version:", null, 2, null);     // Catch: Throwable -> L30
        if (r13 == null) goto L24;
        String r14 = StringsKt.trim(r13).toString();     // Catch: Throwable -> L30
        if (r14 == null) goto L24;
    L25:
        a = r14;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r4, null);     // Catch: IOException -> L35
        return r14;
    L24:
        r14 = "";
    L16:
        r8 = false;
        goto L17
    L28:
        CloseableKt.closeFinally(r4, null);     // Catch: IOException -> L35
    L37:
        return "";
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: IOException -> L35
        throw th;     // Catch: IOException -> L35
    L35:
        e = move-exception;
        tt5.a.e("BitableSCMResourceDownloader", "getDownloadedLynxVersion, error", e, false);
        goto L37
    }

    public static void a(Exception r4, VFSPath r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "srcDir");
        Intrinsics.checkNotNullParameter(r6, "context");
        StringBuilder r0 = new StringBuilder("download failed:");
        if (r4 == null) goto L5;
        String r2 = r4.getMessage();
    L6:
        r0.append(r2);
        Toast.showFailureText(r6, r0.toString());
        tt5.a.e("BitableSCMResourceDownloader", "onDownloadError", r4, false);
        FileUtils.m(r5);     // Catch: IOException -> L9
        FileUtils.m(VFSFiles.b.z(com.ss.android.lark.storage.f.d.a(r6, null)).subPath("gecko_build_in"));     // Catch: IOException -> L9
        a = null;     // Catch: IOException -> L9
        return;
    L9:
        tt5.a.e("BitableSCMResourceDownloader", "onDownloadError deleteFile ", r4, false);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
