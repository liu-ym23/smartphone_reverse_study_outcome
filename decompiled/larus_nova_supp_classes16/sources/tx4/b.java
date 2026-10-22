package tx4;

import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.ee.util.ui.m;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import jx4.t;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Callback {
    public final /* synthetic */ String a;
    public final /* synthetic */ a.InterfaceC0301a b;

    public b(String r1, t.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(Call r3, IOException r4) {
        Intrinsics.checkNotNullParameter(r3, "call");
        Intrinsics.checkNotNullParameter(r4, "e");
        tt5.a.e("RoasterDownloader", "   downloadFile url: " + du5.b.g(this.a) + "  onFailure: ", r4, false);
        int r5 = a.a;
        m.a(new c(this.b));
    }

    public final void onResponse(Call r17, Response r18) throws IOException {
        Intrinsics.checkNotNullParameter(r17, "call");
        Intrinsics.checkNotNullParameter(r18, "response");
        tt5.a.b("RoasterDownloader", "   downloadFile url: " + du5.b.g(this.a) + "  response: " + r18);
        int r2 = a.a;
        a.InterfaceC0301a r3 = this.b;
        if (r18 != null) goto L5;
    L32:
        tt5.a.d("RoasterDownloader", "download failed!");
        return;
    L5:
        if (r18.isSuccessful() == false) goto L32;
        ResponseBody r0 = r18.body();
        if (r0 == null) goto L42;
        byte[] r4 = new byte[2048];
        Closeable r7 = null;
        OutputStream r8 = null;
        r8 = null;
        r8 = null;
        InputStream r9 = r0.byteStream();     // Catch: Throwable -> L22 Exception -> L25
        long r10 = r0.contentLength();     // Catch: Throwable -> L18 Exception -> L20
        VFSPath r1 = LarkFileStorage.b().b(f.d, new com.ss.android.lark.storage.d(new String[]{"creation_ai_res", "creation_ai_preview"}));     // Catch: Throwable -> L18 Exception -> L20
        FileUtils.n(r1);     // Catch: Throwable -> L18 Exception -> L20
        com.suite.lark.component.storage.ext.b.d(r1);     // Catch: Throwable -> L18 Exception -> L20
        VFSFile r5 = r1.subPath("roaster.zip").toFile();     // Catch: Throwable -> L18 Exception -> L20
        r8 = r5.newOutputStream();     // Catch: Throwable -> L18 Exception -> L20
        int r12 = r9.read(r4);     // Catch: Throwable -> L18 Exception -> L20
        long r13 = 0;
    L14:
        if (r12 == (-1)) goto L16;
        r8.write(r4, 0, r12);     // Catch: Throwable -> L18 Exception -> L20
        r13 = r13 + ((long) r12);     // Catch: Throwable -> L18 Exception -> L20
        m.a(new d(r3, (int) ((r13 * 1.0f) / r10)));     // Catch: Throwable -> L18 Exception -> L20
        r12 = r9.read(r4);     // Catch: Throwable -> L18 Exception -> L20
        goto L14
    L16:
        r8.flush();     // Catch: Throwable -> L18 Exception -> L20
        a.a(r5);     // Catch: Throwable -> L18 Exception -> L20
        m.a(new e(r3));     // Catch: Throwable -> L18 Exception -> L20
        FileUtils.e(new Closeable[]{r9, r8});
        return;
    L20:
        e = e;
    L27:
        tt5.a.e("RoasterDownloader", "download exception!", e, false);     // Catch: Throwable -> L18
        m.a(new c(r3));     // Catch: Throwable -> L18
        FileUtils.e(new Closeable[]{r9, r8});
        return;
    L18:
        th = th;
        Closeable r6 = r8;
        r7 = r9;
    L30:
        FileUtils.e(new Closeable[]{r7, r6});
        throw th;
    L25:
        e = e;
        r9 = null;
    L22:
        th = th;
        r6 = null;
        goto L30
    }
}
