package e8a;

import android.content.Context;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.utils.l;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static byte[] a(Context r100, String r101) {
        byte[] r102 = null;
        r102 = null;
        r102 = null;
        InputStream r103 = null;
        r102 = null;
        r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Uri r104 = UriProtector.parse(r101);
        if (r100 == null) goto L27;
        if (r104 == null) goto L27;
        if ("content".equals(r104.getScheme()) == false) goto L27;
        InputStream r105 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r104);     // Catch: Throwable -> L19 Exception -> L24
    L36:
        r102 = l.a(r105);     // Catch: Throwable -> L16 Exception -> L18
        if (r105 == null) goto L27;
    L32:
        r105.close();     // Catch: IOException -> L29
        goto L27
    L16:
        Throwable th10 = th;
        r103 = r105;
    L21:
        if (r103 == null) goto L38;
        r103.close();     // Catch: IOException -> L28
        throw th10;
    L39:
        throw th10;
    L38:
        throw th10;
    L25:
        if (r105 == null) goto L27;
    L24:
        r105 = null;
    L19:
        th = move-exception;
        th10 = th;
    L27:
        return r102;
    }

    public static byte[] b(Context r100, String r101) {
        byte[] r102 = null;
        r102 = null;
        r102 = null;
        PolarisFileInputStreamWrapper r103 = null;
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (r101.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L22;
        if (r101.length() <= 7) goto L22;
        String r104 = r101.substring(7);
        if (r104.startsWith(HTTP.URL_DEFAULT) == false) goto L13;
        String r105 = UriProtector.parse(r101).getPath();
    L14:
        if (r105 == null) goto L22;
        if (r105.length() == 0) goto L22;
        if (r105.startsWith(HTTP.URL_DEFAULT) == false) goto L21;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);
    L23:
        if (r106 != null) goto L46;
    L39:
        return r102;
    L46:
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r106);     // Catch: Throwable -> L32 Exception -> L36
    L48:
        r102 = l.a(r107);     // Catch: Throwable -> L29 Exception -> L31
    L44:
        r107.close();     // Catch: IOException -> L41
        goto L39
    L29:
        th = th;
        r103 = r107;
    L33:
        if (r103 != null) goto L42;
    L35:
        throw th;
    L42:
        r103.close();     // Catch: IOException -> L40
    L37:
        if (r107 == null) goto L39;
    L36:
        r107 = null;
    L32:
        th = th;
        goto L33
    L21:
        r106 = new PolarisFileWrapper(r100.getFilesDir(), r105);
        goto L23
    L13:
        r105 = Uri.decode(r104);
    L22:
        r106 = null;
        goto L23
    }
}
