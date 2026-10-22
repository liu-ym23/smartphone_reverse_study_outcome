package uz6;

import android.content.Context;
import com.bytedance.lottie.network.FileExtension;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f552191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552192b;

    public final void b(FileExtension r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f552191a.getCacheDir(), a(this.f552192b, r100, true));
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.getAbsolutePath().replace(".temp", ""));
        boolean r103 = r101.renameTo(r102);
        r102.toString();
        Set<String> r104 = com.bytedance.lottie.c.f264422a;
        if (r103 == true) goto L6;
        com.bytedance.lottie.c.b("Unable to rename cache file " + r101.getAbsolutePath() + " to " + r102.getAbsolutePath() + ".");
        return;
    }

    public a(Context r100, String r101) {
        this.f552191a = r100.getApplicationContext();
        this.f552192b = r101;
    }

    public static String a(String r100, FileExtension r101, boolean r102) {
        StringBuilder r103 = new StringBuilder("lottie_cache_");
        r103.append(r100.replaceAll("\\W+", ""));
        if (r102 == false) goto L5;
        String r104 = r101.extension;
    L6:
        r103.append(r104);
        return r103.toString();
    L5:
        r104 = r101.tempExtension();
        goto L6
    }
}
