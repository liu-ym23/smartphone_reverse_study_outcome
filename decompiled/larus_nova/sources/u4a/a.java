package u4a;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
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
public final class a implements k {
    public a() {
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.ASSET;
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
        Context r109 = AnimaX.e().f380466c;
        if (r109 == null) goto L20;
        AssetManager r110 = r109.getAssets();
    L21:
        if (r110 == null) goto L27;
        String r111 = r108.getPath().substring(1);
        InputStream r112 = r110.open(r111);     // Catch: IOException -> L25
        r104 = y4a.b.c(r112, r112.available());     // Catch: IOException -> L25
    L25:
        e = move-exception;
        AnimaXLog.a("ResourceUtil", "Failed to open asset: " + r111 + " , reason: " + e);
    L27:
        if (r104 != null) goto L29;
        AnimaXLoaderResponse r113 = AnimaXLoaderResponse.b(new Throwable("failed to load asset"));
    L30:
        ((AnimaXLoaderCompletionHandler) r101).a(r113);
        return;
    L29:
        r113 = AnimaXLoaderResponse.a(r104);
        goto L30
    L20:
        r110 = null;
        goto L21
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
