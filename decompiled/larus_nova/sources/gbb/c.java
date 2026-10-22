package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends d {
    @Override // gbb.d, gbb.g
    public final PolarisFileWrapper a(String r100) throws IOException, DecryptException {
        e r101 = this.f480770a;
        if (r101 == null) goto L14;
        e.C6005e r102 = r101.d(r100);
        if (r102 == null) goto L18;
        PolarisFileWrapper r103 = r102.f480797b.a(0);
        r102.close();
        String r104 = f.b(r103);     // Catch: DecryptException -> L9
        PolarisFileWrapper r105 = CipherManager.e(r103, false);     // Catch: DecryptException -> L9
        e(r104, f.b(r103), r100, r103);     // Catch: DecryptException -> L9
        return r105;
    L9:
        e = move-exception;
        Log.e("CipherDiskCacheWrapper", "decrypt file failed! code: " + e.getErrorCode() + ", key: " + r100 + ", path: " + r103.getAbsolutePath());
        if (e.getErrorCode() != 20327) goto L13;
        this.f480770a.l(r100);
        return null;
    L13:
        throw e;
    L18:
        return null;
    L14:
        return null;
    }

    @Override // gbb.d, gbb.g
    public final void d(String r100, g.a r101) throws IOException {
        e r102 = this.f480770a;
        if (r102 != null) goto L6;
        Log.w("CipherDiskCacheWrapper", "put mLruCache is null");
        return;
    L6:
        e.c r103 = r102.c(r100);
        if (r103 == null) goto L12;
        PolarisFileWrapper r104 = r103.b();
        if (r101.write(r104) == false) goto L11;
        String r105 = f.b(r104);
        com.ss.android.lark.vfs.d.a().o(r104);
        e(r105, f.b(r104), r100, r104);
        e.a(r103.f480790c, r103, true);
        return;
    L11:
        r103.a();
        Log.e("CipherDiskCacheWrapper", "write file failed, key:" + r100);
        return;
    L12:
        Log.e("CipherDiskCacheWrapper", "editor is null, key:" + r100);
    }

    public c(PolarisFileWrapper r100, int r101, long r102) {
        this.f480770a = e.g(r100, r101, r102);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void e(String r100, String r101, String r102, PolarisFileWrapper r103) {
        if (r100.equals(r101) == true) goto L6;
        Log.i("CipherDiskCacheWrapper", "getFile header changed:" + r100 + "->" + r101 + ", key:" + r102 + ", file:" + r103.getAbsolutePath());
        return;
    }
}
