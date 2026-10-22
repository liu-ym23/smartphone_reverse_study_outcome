package u4a;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements k {
    public d() {
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.FILE;
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
        String r109 = r108.getPath();
        PolarisFileInputStreamWrapper r110 = new PolarisFileInputStreamWrapper(r109);     // Catch: IOException -> L20
        r104 = y4a.b.c(r110, r110.available());     // Catch: IOException -> L20
    L22:
        if (r104 == null) goto L24;
        AnimaXLoaderResponse r111 = AnimaXLoaderResponse.a(r104);
    L25:
        ((AnimaXLoaderCompletionHandler) r101).a(r111);
        return;
    L24:
        r111 = AnimaXLoaderResponse.b(new Throwable("load file failed, getByteArrayFromFile returned null."));
    L20:
        e = move-exception;
        AnimaXLog.a("ResourceUtil", "Failed to open local file:" + r109 + " , reason: " + e);
        goto L22
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
