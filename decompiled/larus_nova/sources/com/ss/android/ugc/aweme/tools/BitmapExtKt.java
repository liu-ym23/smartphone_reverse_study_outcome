package com.ss.android.ugc.aweme.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import bytedance.io.BdFileSystem;
import com.ss.android.ugc.aweme.utils.FileMetaInfoQueryManager;
import com.ss.android.ugc.tools.utils.FileAdapterUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"lib-api_release"}, k = 2, mv = {1, 4, 1})
public final class BitmapExtKt {
    public static final Pair<Integer, Integer> c(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L6:
        r101 = true;
    L7:
        if (r101 == true) goto L9;
        BitmapFactory.Options r102 = new BitmapFactory.Options();     // Catch: Exception -> L36
        r102.inJustDecodeBounds = true;     // Catch: Exception -> L36
        FileAdapterUtils.c();     // Catch: Exception -> L36
        if (FileAdapterUtils.b(r100) == false) goto L39;
        ParcelFileDescriptor r103 = null;
        ParcelFileDescriptor r104 = BdFileSystem.getFileDescriptor(FileAdapterUtils.f454856e.a(), Uri.parse(r100), "r");     // Catch: Throwable -> L19 Exception -> L23
        BitmapFactory.decodeFileDescriptor(r104.getFileDescriptor(), null, r102);     // Catch: Throwable -> L16 Exception -> L18
    L26:
        r104.close();     // Catch: Exception -> L36
    L29:
        int r105 = FileMetaInfoQueryManager.b(r100);     // Catch: Exception -> L36
        if (r105 == 90) goto L47;
        if (r105 == 270) goto L47;
        return new Pair(Integer.valueOf(r102.outWidth), Integer.valueOf(r102.outHeight));
    L47:
        return new Pair(Integer.valueOf(r102.outHeight), Integer.valueOf(r102.outWidth));
    L18:
        r103 = r104;
    L16:
        th = th;
        r103 = r104;
    L20:
        if (r103 == null) goto L22;
        r103.close();     // Catch: Exception -> L36
    L22:
        throw th;     // Catch: Exception -> L36
    L19:
        th = th;
    L24:
        if (r103 == null) goto L29;
        r104 = r103;
        goto L26
    L39:
        BitmapFactory.decodeFile(r100, r102);     // Catch: Exception -> L38
        goto L29
    L37:
        return new Pair(0, 0);
    L9:
        return new Pair(0, 0);
    L5:
        if (r100.length() != 0) goto L7;
        goto L6
    }

    public static final int a(BitmapFactory.Options r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "options");
        Pair r103 = TuplesKt.to(Integer.valueOf(r100.outHeight), Integer.valueOf(r100.outWidth));
        int r104 = ((Number) r103.component1()).intValue();
        int r105 = ((Number) r103.component2()).intValue();
        int r106 = 1;
        if (r104 > r102) goto L5;
        if (r105 > r101) goto L5;
    L11:
        return r106;
    L5:
        int r107 = r104 / 2;
        int r108 = r105 / 2;
    L7:
        if ((r107 / r106) < r102) goto L11;
        if ((r108 / r106) < r101) goto L11;
        r106 = r106 * 2;
        goto L7
    }

    public static final Bitmap b(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;     // Catch: Exception -> L5
        BitmapFactory.decodeFile(r100, r103);     // Catch: Exception -> L5
        r103.inSampleSize = a(r103, r101, r102);     // Catch: Exception -> L5
        r103.inJustDecodeBounds = false;     // Catch: Exception -> L5
        return BitmapFactory.decodeFile(r100, r103);
    L5:
        return null;
    }
}
