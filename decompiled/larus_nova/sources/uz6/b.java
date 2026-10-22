package uz6;

import androidx.core.util.Pair;
import com.bytedance.lottie.d;
import com.bytedance.lottie.e;
import com.bytedance.lottie.network.FileExtension;
import com.bytedance.lottie.o;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import wz6.h;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Callable<o<d>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f552193a;

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    public o<d> call() throws Exception {
        c r100 = this.f552193a;
        a r101 = r100.f552196c;
        r101.getClass();
        d r102 = null;
        String r103 = r101.f552192b;     // Catch: FileNotFoundException -> L17
        File r104 = r101.f552191a.getCacheDir();     // Catch: FileNotFoundException -> L17
        FileExtension r105 = FileExtension.Json;     // Catch: FileNotFoundException -> L17
        PolarisFileWrapper r106 = new PolarisFileWrapper(r104, a.a(r103, r105, false));     // Catch: FileNotFoundException -> L17
        if (r106.exists() == true) goto L10;
        r106 = new PolarisFileWrapper(r101.f552191a.getCacheDir(), a.a(r103, FileExtension.Zip, false));     // Catch: FileNotFoundException -> L17
        if (r106.exists() == true) goto L10;
        r106 = null;
    L10:
        if (r106 == null) goto L18;
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r106);     // Catch: FileNotFoundException -> L17
        if (r106.getAbsolutePath().endsWith(".zip") == false) goto L16;
        r105 = FileExtension.Zip;
    L16:
        r106.getAbsolutePath();
        Set<String> r108 = com.bytedance.lottie.c.f264422a;
        Pair r109 = new Pair(r105, r107);
    L19:
        if (r109 == null) goto L33;
        FileExtension r110 = (FileExtension) r109.first;
        InputStream r111 = (InputStream) r109.second;
        if (r110 != FileExtension.Zip) goto L29;
        ZipInputStream r112 = new ZipInputStream(r111);
        o<d> r113 = e.d(r112, r100.f552195b);     // Catch: Throwable -> L26
        h.c(r112);
    L30:
        d r114 = r113.f264578a;
        if (r114 == null) goto L33;
        r102 = r114;
    L26:
        th = move-exception;
        h.c(r112);
        throw th;
    L29:
        r113 = e.b(r111, r100.f552195b, true);
    L33:
        if (r102 != null) goto L47;
        Set<String> r115 = com.bytedance.lottie.c.f264422a;
        return r100.a();
    L38:
        e = move-exception;
        return new o(e);
    L47:
        return new o(r102);
    L18:
        r109 = null;
        goto L19
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ o<d> call() throws Exception {
        return call();
    }

    public b(c r100) {
        this.f552193a = r100;
    }
}
