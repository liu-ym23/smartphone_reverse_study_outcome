package com.bytedance.ee.bear.document;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g5 {
    public static int[] a(VFSPath r4) {
        if (r4 != null) goto L6;
        tt5.a.d("ImageUtil", "getSize(): path is null");
        return new int[]{0, 0};
    L6:
        BitmapFactory.Options r1 = new BitmapFactory.Options();
        r1.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r4.getRealPath(), r1);
        return new int[]{r1.outWidth, r1.outHeight};
    }

    public static boolean b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L15;
    L14:
        return false;
    L15:
        Uri r3 = UriProtector.parse(r2);     // Catch: Exception -> L12
        if (r3 == null) goto L14;
        String r4 = r3.getPath();     // Catch: Exception -> L12
        if (r4 == null) goto L14;
        if (r4.contains("/api/box/stream/download/v2/cover/") == false) goto L14;
        return true;
    L12:
        e = move-exception;
        tt5.a.f("ImageUtil", e, false);
        goto L14
    }

    public static boolean c(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L17;
    L16:
        return false;
    L17:
        Uri r4 = UriProtector.parse(r3);     // Catch: Exception -> L14
        if (r4 == null) goto L16;
        if ("image".equalsIgnoreCase(UriProtector.getQueryParameter(r4, "type")) == false) goto L9;
        return true;
    L9:
        String r5 = r4.getPath();     // Catch: Exception -> L14
        if (r5 == null) goto L16;
        if (r5.contains("/api/box/stream/download/all/") == false) goto L16;
        return true;
    L14:
        e = move-exception;
        tt5.a.f("ImageUtil", e, false);
        goto L16
    }

    public static boolean d(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        if (r1.startsWith("docsource://com.bytedance.net/file/f/") == false) goto L10;
        return true;
    L10:
        return false;
    }
}
