package com.bytedance.creativex.mediaimport.view.internal.validator;

import android.app.Application;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.tools.BitmapExtKt;
import com.ss.android.ugc.aweme.utils.FileMetaInfoQueryManager;
import com.ss.android.ugc.tools.utils.FileAdapterUtils;
import ki4.r;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static final void a(r r100) {
        FileAdapterUtils.f454854c = new a();
        if (com.bytedance.creativex.mediaimport.repository.api.a.d(r100) == false) goto L32;
        String r101 = r100.getUri().toString();
        int[] r102 = {0, 0};
        FileMetaInfoQueryManager.f454347a.getClass();
        FileAdapterUtils.c();
        MediaMetadataRetriever r103 = new MediaMetadataRetriever();
        if (FileAdapterUtils.b(r101) == false) goto L8;
        r103.setDataSource(FileAdapterUtils.f454856e.a(), UriProtector.parse(r101));     // Catch: Exception -> L57
    L70:
        goto L59
    L8:
        r103.setDataSource(r101);     // Catch: Exception -> L57
    L59:
        String r104 = FileMetaInfoQueryManager.a(r103, 18);     // Catch: Throwable -> L17 Exception -> L19
        if (r104 == null) goto L13;
        r102[0] = Integer.parseInt(r104);     // Catch: Throwable -> L17 Exception -> L19
    L13:
        String r105 = FileMetaInfoQueryManager.a(r103, 19);     // Catch: Throwable -> L17 Exception -> L19
        if (r105 == null) goto L66;
        r102[1] = Integer.parseInt(r105);     // Catch: Throwable -> L17 Exception -> L19
    L66:
        r103.release();     // Catch: Exception -> L23
    L25:
        r100.setWidth(r102[0]);
        r100.setHeight(r102[1]);
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r103.release();     // Catch: Exception -> L28
    L30:
        throw th;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L32:
        if (ri4.b.b() == false) goto L54;
        Application r106 = AppHost.f326268a.getApplication();
        Uri r107 = r100.getUri();
        Intrinsics.checkNotNullParameter(r106, "$this$getBitmapSize");
        if (r107 != null) goto L36;
        Pair<Integer, Integer> r108 = new Pair(0, 0);
        ?? r109 = "$this$getBitmapSize";
    L55:
        int r110 = r108.component1().intValue();
        int r111 = r108.component2().intValue();
        r100.setWidth(r110);
        r100.setHeight(r111);
        return;
    L45:
        Throwable th10 = th;
        ?? r112 = r109;
    L51:
        if (r112 == 0) goto L53;
        r112.close();
    L53:
        throw th10;
    L36:
        r109 = 0;
        ?? r113 = 0;
        BitmapFactory.Options r114 = new BitmapFactory.Options();     // Catch: Throwable -> L45 Exception -> L58
        r114.inJustDecodeBounds = true;     // Catch: Throwable -> L45 Exception -> L58
        r112 = ContentResolverWrapper.openInputStream(r106.getContentResolver(), r107);     // Catch: Throwable -> L45 Exception -> L58
        BitmapFactory.decodeStream(r112, null, r114);     // Catch: Throwable -> L42 Exception -> L44
        Integer r115 = Integer.valueOf(r114.outWidth);     // Catch: Throwable -> L42 Exception -> L44
        Integer r116 = Integer.valueOf(r114.outHeight);     // Catch: Throwable -> L42 Exception -> L44
        Pair<Integer, Integer> r117 = new Pair(r115, r116);     // Catch: Throwable -> L42 Exception -> L44
        if (r112 == 0) goto L41;
        r112.close();
    L41:
        r108 = r117;
        r109 = r116;
        goto L55
    L44:
        r113 = r112;
    L42:
        th10 = th;
    L47:
        r108 = new Pair(0, 0);     // Catch: Throwable -> L45
        r109 = r113;
        if (r113 == 0) goto L55;
        r113.close();
        r109 = r113;
        goto L55
    L54:
        r108 = BitmapExtKt.c(r100.getPath());
        goto L55
    }
}
