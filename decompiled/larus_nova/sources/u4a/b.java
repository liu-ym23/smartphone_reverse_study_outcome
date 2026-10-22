package u4a;

import android.graphics.BitmapFactory;
import android.util.Base64;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements k {
    public b() {
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.DATA_URL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u4a.k
    public final void a(m r100, l r101) {
        AnimaXLoaderRequest r102 = (AnimaXLoaderRequest) r100;     // Catch: Exception -> L5 Throwable -> L9
        String r103 = r102.b();     // Catch: Exception -> L5 Throwable -> L9
        byte[] r104 = Base64.decode(r103.substring(r103.indexOf("base64,") + 7), 0);     // Catch: Exception -> L5 Throwable -> L9
        if (r102.a() == null) goto L7;
        q r105 = new q(BitmapFactory.decodeByteArray(r104, 0, r104.length));     // Catch: Exception -> L5 Throwable -> L9
        AnimaXLoaderResponse r106 = new AnimaXLoaderResponse(AnimaXLoaderResponse.Type.BITMAP, r105);     // Catch: Exception -> L5 Throwable -> L9
    L16:
    L12:
        ((AnimaXLoaderCompletionHandler) r101).a(r106);
        return;
    L7:
        r106 = AnimaXLoaderResponse.a(r104);     // Catch: Exception -> L5 Throwable -> L9
    L5:
        e = move-exception;
        r106 = AnimaXLoaderResponse.b(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ((AnimaXLoaderCompletionHandler) r101).a(null);
        throw th;
    }
}
