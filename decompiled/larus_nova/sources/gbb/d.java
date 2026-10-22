package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f480770a;

    @Override // gbb.g
    public File c(String r100) throws IOException {
        return null;
    }

    @Override // gbb.g
    public final File b() {
        e r100 = this.f480770a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.e();
    }

    @Override // gbb.g
    public void delete() throws IOException {
        e r100 = this.f480770a;
        if (r100 == null) goto L6;
        r100.delete();
        return;
    }

    public d() {
    }

    @Override // gbb.g
    public PolarisFileWrapper a(String r100) throws IOException, DecryptException {
        e r101 = this.f480770a;
        if (r101 == null) goto L8;
        e.C6005e r102 = r101.d(r100);
        if (r102 == null) goto L10;
        PolarisFileWrapper r103 = r102.f480797b.a(0);
        r102.close();
        return r103;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // gbb.g
    public final void remove(String r100) throws IOException {
        e r101 = this.f480770a;
        if (r101 == null) goto L6;
        r101.l(r100);
        return;
    }

    @Override // gbb.g
    public void d(String r100, g.a r101) throws IOException {
        e r102 = this.f480770a;
        if (r102 != null) goto L6;
        Log.w("DiskCacheWrapperBase", "put mLruCache is null");
        return;
    L6:
        e.c r103 = r102.c(r100);
        if (r103 != null) goto L9;
        Log.e("DiskCacheWrapperBase", "editor is null, key:" + r100);
        return;
    L9:
        if (r101.write(r103.b()) == false) goto L11;
        e.a(r103.f480790c, r103, true);
        return;
    L11:
        Log.e("DiskCacheWrapperBase", "write file failed");
    }
}
