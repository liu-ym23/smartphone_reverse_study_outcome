package com.obric.miniapp.utils;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.LruCache;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f398448a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f398449b = null;

    public b() {
    }

    static {
        f398448a = new b();
        f398449b = LazyKt.lazy(new a());
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        String r101 = (String) ((LruCache) f398449b.getValue()).get(r100);
        if (r101 == null) goto L27;
        return r101;
    L27:
        Bitmap r102 = b(this, AppHost.f326268a.getApplication().getPackageManager().getApplicationIcon(r100));     // Catch: PackageManager.NameNotFoundException -> L17
        if (r102 == null) goto L19;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: PackageManager.NameNotFoundException -> L17
        r102.compress(Bitmap.CompressFormat.PNG, 100, r103);     // Catch: Throwable -> L12
        String r104 = Base64.encodeToString(r103.toByteArray(), 2);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r103, null);     // Catch: PackageManager.NameNotFoundException -> L17
    L20:
        if (r104 == null) goto L28;
        ((LruCache) f398449b.getValue()).put(r100, r104);
        return r104;
    L28:
        return null;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: PackageManager.NameNotFoundException -> L17
        throw th;     // Catch: PackageManager.NameNotFoundException -> L17
    L19:
        r104 = null;
    L17:
        e = move-exception;
        FLogger.f375446a.e("AppIconManager", e.getMessage());
        goto L19
    }

    public static Bitmap b(b r100, Drawable r101) {
        int r102 = r101.getIntrinsicWidth();
        int r103 = r101.getIntrinsicHeight();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        boolean r104 = r101 instanceof BitmapDrawable;
        if (r104 == true) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r104 == false) goto L19;
        BitmapDrawable r105 = (BitmapDrawable) r101;
        if (r105.getBitmap() == null) goto L18;
        if (r102 != r105.getBitmap().getWidth()) goto L23;
        if (r103 != r105.getBitmap().getHeight()) goto L23;
        return r105.getBitmap();
    L23:
        return Bitmap.createScaledBitmap(r105.getBitmap(), r102, r103, true);
    L18:
        throw new IllegalArgumentException("bitmap is null");
    L19:
        int r106 = r101.getBounds().left;
        int r107 = r101.getBounds().top;
        int r108 = r101.getBounds().right;
        int r109 = r101.getBounds().bottom;
        Bitmap r110 = Bitmap.createBitmap(r102, r103, Bitmap.Config.ARGB_8888);
        r101.setBounds(0, 0, r102, r103);
        r101.draw(new Canvas(r110));
        r101.setBounds(r106, r107, r108, r109);
        return r110;
    L5:
        if (((BitmapDrawable) r101).getBitmap() != null) goto L7;
        return null;
    }
}
