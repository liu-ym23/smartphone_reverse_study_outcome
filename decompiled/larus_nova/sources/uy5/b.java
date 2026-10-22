package uy5;

import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GkFSUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f552133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f552134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f552135c;

    public b(File r100) {
        this.f552133a = r100;
    }

    public final File a(File r100, String r101) throws IOException {
        StringBuilder r102 = new StringBuilder("res");
        String r103 = File.separator;
        r102.append(r103);
        r102.append(r101);
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100, r102.toString());
        if (r104.getCanonicalPath().startsWith(r100.getCanonicalPath()) == false) goto L20;
        if (GkFSUtils.g(r101) == false) goto L7;
    L11:
        AppSettingsManager r105 = AppSettingsManager.b.f245071a;
        if (r104.exists() == false) goto L18;
        ez5.c.a(r104);     // Catch: Throwable -> L15
    L15:
        int r106 = ez5.c.f474884a;
        ez5.c.e(this.f552134b, this.f552135c, r104, r101);
        ez5.c.delete(r100);
        throw new IOException("file was broken");
    L18:
        return r104.getCanonicalFile();
    L7:
        if (r104.exists() == true) goto L11;
        String r107 = GkFSUtils.d(this.f552134b, this.f552135c, r101);
        if (r107 == null) goto L11;
        r104 = new PolarisFileWrapper(r100, "res" + r103 + r107);
        goto L11
    L20:
        throw new IOException("file not found");
    }
}
