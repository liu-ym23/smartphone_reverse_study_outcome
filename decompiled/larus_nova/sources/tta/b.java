package tta;

import android.content.Context;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f547568b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f547569a;

    public b() {
        String r100 = f547568b;
        if (r100 == null) goto L5;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
    L6:
        this.f547569a = r101;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.exists() == true) goto L13;
        r101.mkdirs();
        return;
    L13:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void a() {
        PolarisFileWrapper r100 = this.f547569a;
        if (r100 != null) goto L24;
        return;
    L24:
        if (r100.isDirectory() == true) goto L7;
        return;
    L7:
        if (r100.exists() == false) goto L28;
        File[] r101 = r100.listFiles();     // Catch: Exception -> L23
        if (r101 == null) goto L11;
        List r102 = ArraysKt.toMutableList(r101);     // Catch: Exception -> L23
    L12:
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.size() > 5) goto L16;
        return;
    L16:
        if (r102.size() <= 1) goto L18;
        CollectionsKt.sortWith(r102, new a());     // Catch: Exception -> L23
    L18:
        int r103 = r102.size() - 5;     // Catch: Exception -> L23
        int r104 = 0;
    L19:
        if (r104 >= r103) goto L32;
        ((File) ListProtector.get(r102, r104)).delete();     // Catch: Exception -> L23
        r104 = r104 + 1;
        goto L19
    L32:
        return;
    L11:
        r102 = null;
        goto L12
    L28:
        return;
    }

    public final Drawable b(String r100) {
        PolarisFileWrapper r101 = this.f547569a;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L17;
        a();
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, com.ss.android.dypay.utils.c.a(r100));
    L11:
        r102.delete();
        return null;
    L8:
        if (r102.exists() == false) goto L18;
        ImageDecoder.Source r103 = ImageDecoder.createSource(r102);     // Catch: Throwable -> L11
        r102.setLastModified(System.currentTimeMillis());     // Catch: Throwable -> L11
        return ImageDecoder.decodeDrawable(r103);
    L18:
        return null;
    L17:
        return null;
    }

    static {
        WeakReference<Context> r100 = com.ss.android.dypay.base.e.f408447a;
        String r101 = null;
        if (r100 == null) goto L7;
        Context r102 = r100.get();
        if (r102 == null) goto L7;
        Context r103 = r102.getApplicationContext();
    L8:
        if (r103 == null) goto L12;
        File r104 = r103.getCacheDir();
        if (r104 == null) goto L12;
        r101 = new PolarisFileWrapper(r104, "DyPayImageLoader").getAbsolutePath();
    L12:
        f547568b = r101;
        return;
    L7:
        r103 = null;
        goto L8
    }
}
