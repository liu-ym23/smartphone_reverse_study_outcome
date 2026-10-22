package u4a;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements k {
    public c() {
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.CONTENT_URI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u4a.k
    public final void a(m r100, l r101) {
        w4a.a r102 = w4a.a.b();
        r102.getClass();
        Map r103 = (Map) ((ConcurrentHashMap) r102.f558278a).get(w4a.e.f558281b);
        byte[] r104 = null;
        if (r103 != null) goto L5;
    L7:
        IAnimaXService r105 = null;
    L8:
        IAnimaXImageService r106 = (IAnimaXImageService) r105;
        if (r106 != null) goto L11;
    L13:
        String r107 = ((AnimaXLoaderRequest) r100).b();
        if (r107 != null) goto L16;
        Uri r108 = null;
    L17:
        if (r108 == null) goto L33;
        Context r109 = AnimaX.e().f380466c;
        if (r109 != null) goto L38;
        AnimaXLog.a("ResourceUtil", "Context is null");
        goto L33
    L38:
        InputStream r110 = ContentResolverWrapper.openInputStream(r109.getContentResolver(), r108);     // Catch: Exception -> L31
        if (r110 != null) goto L39;
        AnimaXLog.a("ResourceUtil", "inputStream is null");     // Catch: Exception -> L31
        goto L33
    L39:
        int r111 = r110.available();     // Catch: IOException -> L28 Exception -> L31
    L29:
        r104 = y4a.b.c(r110, r111);     // Catch: Exception -> L31
    L28:
        r111 = 0;
    L31:
        e = move-exception;
        AnimaXLog.a("ResourceUtil", "readUriFile has Exception:" + e.getMessage());
    L33:
        if (r104 == null) goto L35;
        AnimaXLoaderResponse r112 = AnimaXLoaderResponse.a(r104);
    L36:
        ((AnimaXLoaderCompletionHandler) r101).a(r112);
        return;
    L35:
        r112 = AnimaXLoaderResponse.b(new Throwable("load file failed, getByteArrayFromContentUri returned null."));
        goto L36
    L16:
        r108 = UriProtector.parse(r107);
        goto L17
    L11:
        if (r106.loadImage(r100, r101) == false) goto L13;
        return;
    L5:
        if (r103.containsKey(IAnimaXImageService.class) == false) goto L7;
        r105 = (IAnimaXService) r103.get(IAnimaXImageService.class);
        goto L8
    }
}
