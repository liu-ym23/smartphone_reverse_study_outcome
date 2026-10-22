package h5a;

import c5a.c;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.clay.embedding.engine.loader.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.clay.embedding.engine.plugins.audio.a f483888a;

    public a(com.lynx.clay.embedding.engine.plugins.audio.a r100) {
        this.f483888a = r100;
    }

    public final void a(String r100) {
        c.d(6, "AudioPlayerSPImpl", r100);
    }

    public final void b(String r100, InputStream r110) {
        PolarisFileOutputStreamWrapper r101 = null;
        if (r100 == null) goto L92;
        if (r100.isEmpty() == true) goto L92;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Exception -> L16
        if (r102.exists() == false) goto L92;
        if (r110 != null) goto L98;
    L14:
        com.lynx.clay.embedding.engine.plugins.audio.a.g(this.f483888a, r102.getPath());     // Catch: Exception -> L16
        return;
    L98:
        r110.close();     // Catch: IOException -> L11 Exception -> L16
    L13:
        r110 = null;
        goto L14
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
    L92:
        if (r110 != null) goto L94;
        c.d(6, "AudioPlayerSPImpl", "Load audio resource failed");
        return;
    L94:
        File r103 = File.createTempFile("sound_pool_temp", null, this.f483888a.f380757a.getFlutterView().getContext().getCacheDir());     // Catch: Throwable -> L42 IOException -> L44
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r103);     // Catch: IOException -> L40 Throwable -> L42
    L86:
        byte[] r105 = new byte[4096];     // Catch: IOException -> L38 Throwable -> L64
    L26:
        int r106 = r110.read(r105);     // Catch: IOException -> L38 Throwable -> L64
        if (r106 == (-1)) goto L76;
        r104.write(r105, 0, r106);     // Catch: IOException -> L38 Throwable -> L64
        goto L26
    L76:
        r110.close();     // Catch: IOException -> L32
    L34:
        r104.close();     // Catch: IOException -> L36
    L91:
    L53:
        if (r103 != null) goto L55;
        return;
    L55:
        if (r103.exists() == false) goto L102;
        com.lynx.clay.embedding.engine.plugins.audio.a.g(this.f483888a, r103.getPath());
    L61:
        e = move-exception;
        c.d(6, "AudioPlayerSPImpl", "failed to delete temp file");
        e.printStackTrace();
        return;
    L58:
        if (r103.delete() == true) goto L103;
        c.d(6, "AudioPlayerSPImpl", "failed to delete temp file");     // Catch: Exception -> L61
        return;
    L103:
        return;
    L102:
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
    L38:
        IOException e100 = e;
    L46:
        e100.printStackTrace();     // Catch: Throwable -> L64
        r110.close();     // Catch: IOException -> L49
    L51:
        if (r104 == null) goto L53;
        r104.close();     // Catch: IOException -> L36
    L49:
        e = move-exception;
        e.printStackTrace();
    L64:
        th = th;
        r101 = r104;
    L96:
        r110.close();     // Catch: IOException -> L68
    L70:
        if (r101 == null) goto L105;
        r101.close();     // Catch: IOException -> L73
        throw th;
    L73:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L105:
        throw th;
    L68:
        e = move-exception;
        e.printStackTrace();
    L40:
        e = move-exception;
        r104 = null;
        e100 = e;
    L44:
        e = move-exception;
        r104 = null;
        e100 = e;
        r103 = null;
    L42:
        th = th;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L53
    }
}
