package v0b;

import androidx.core.app.NotificationCompat;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f552343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VFSPath f552344b;

    public c(a r100, VFSPath r101) {
        this.f552343a = r100;
        this.f552344b = r101;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call r100, IOException r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, "e");
        f r102 = this.f552343a;
        if (r102 == null) goto L5;
        r102.c(r101);
    L5:
        j.b("CML_TAG_D_DownloadHelper", "onFailure err:" + r101);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call r110, Response r111) {
        Intrinsics.checkNotNullParameter(r110, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r111, "response");
        if (r111.code() == 200) goto L9;
        String r100 = r111.code() + r111.message();
        f r101 = this.f552343a;
        if (r101 == null) goto L7;
        r101.c(new Exception(r100));
    L7:
        j.b("CML_TAG_D_DownloadHelper", "onResponse err response:" + r111);
        return;
    L9:
        String r102 = r111.header("Content-Length");
        if (r102 != null) goto L12;
        r102 = "-1";
    L12:
        long r103 = CastLongProtector.parseLong(r102);
        OutputStream r104 = null;
        InputStream r105 = null;
        VFSPath r106 = this.f552344b;     // Catch: Throwable -> L48 IOException -> L50
        if (r106 == null) goto L19;
        VFSFile r107 = r106.toFile();     // Catch: Throwable -> L48 IOException -> L50
        if (r107 == null) goto L19;
        OutputStream r108 = r107.newOutputStream();     // Catch: Throwable -> L48 IOException -> L50
    L62:
        ResponseBody r109 = r111.body();     // Catch: Throwable -> L44 IOException -> L46
        if (r109 == null) goto L23;
        r105 = r109.byteStream();     // Catch: Throwable -> L44 IOException -> L46
    L23:
        if (r105 == null) goto L40;
        f r112 = this.f552343a;     // Catch: Throwable -> L44 IOException -> L46
        byte[] r113 = new byte[1024];     // Catch: Throwable -> L44 IOException -> L46
        int r114 = 0;
        int r115 = 0;
    L25:
        int r116 = r105.read(r113, 0, 1024);     // Catch: Throwable -> L44 IOException -> L46
        int r117 = -1;
        if (r116 == (-1)) goto L37;
        r114 = r114 + r116;     // Catch: Throwable -> L44 IOException -> L46
        if (r103 == (-1)) goto L31;
        r117 = (int) ((r114 * 100.0f) / r103);     // Catch: Throwable -> L44 IOException -> L46
    L31:
        if (r117 == r115) goto L35;
        if (r112 == null) goto L34;
        r112.a(r117);     // Catch: Throwable -> L44 IOException -> L46
    L34:
        r115 = r117;
    L35:
        if (r108 == null) goto L25;
        r108.write(r113, 0, r116);     // Catch: Throwable -> L44 IOException -> L46
        goto L25
    L37:
        r105.close();     // Catch: Throwable -> L44 IOException -> L46
        if (r108 == null) goto L40;
        r108.close();     // Catch: Throwable -> L44 IOException -> L46
    L40:
        d.a(r108);
        f r118 = this.f552343a;
        if (r118 == null) goto L69;
        r118.b(this.f552344b);
        return;
    L69:
        return;
    L46:
        e = e;
        r104 = r108;
    L51:
        f r119 = this.f552343a;     // Catch: Throwable -> L48
        if (r119 == null) goto L54;
        r119.c(e);     // Catch: Throwable -> L48
    L54:
        j.e("CML_TAG_D_DownloadHelper", "onResponse err:" + e);     // Catch: Throwable -> L48
        d.a(r104);
        return;
    L44:
        th = th;
    L58:
        d.a(r108);
        throw th;
    L19:
        r108 = null;
    L48:
        th = th;
        r108 = null;
    L50:
        e = e;
        goto L51
    }
}
