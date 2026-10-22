package com.bytedance.ee.bear.document;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: classes16.dex */
public final class g5 {
    public static int[] a(VFSPath r100) {
        if (r100 != null) goto L6;
        tt5.a.d("ImageUtil", "getSize(): path is null");
        return new int[]{0, 0};
    L6:
        BitmapFactory.Options r101 = new BitmapFactory.Options();
        r101.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100.getRealPath(), r101);
        return new int[]{r101.outWidth, r101.outHeight};
    }

    public static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
    L14:
        return false;
    L15:
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L12
        if (r101 == null) goto L14;
        String r102 = r101.getPath();     // Catch: Exception -> L12
        if (r102 == null) goto L14;
        if (r102.contains("/api/box/stream/download/v2/cover/") == false) goto L14;
        return true;
    L12:
        e = move-exception;
        tt5.a.f("ImageUtil", e, false);
        goto L14
    }

    public static boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L17;
    L16:
        return false;
    L17:
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L14
        if (r101 == null) goto L16;
        if ("image".equalsIgnoreCase(UriProtector.getQueryParameter(r101, "type")) == false) goto L9;
        return true;
    L9:
        String r102 = r101.getPath();     // Catch: Exception -> L14
        if (r102 == null) goto L16;
        if (r102.contains("/api/box/stream/download/all/") == false) goto L16;
        return true;
    L14:
        e = move-exception;
        tt5.a.f("ImageUtil", e, false);
        goto L16
    }

    public static boolean d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r100.startsWith("docsource://com.bytedance.net/file/f/") == false) goto L10;
        return true;
    L10:
        return false;
    }
}
