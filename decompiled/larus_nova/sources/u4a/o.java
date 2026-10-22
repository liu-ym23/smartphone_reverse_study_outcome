package u4a;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class o implements d8a.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f548739a;

    public o(l r100) {
        this.f548739a = r100;
    }

    @Override // d8a.g
    public final void onFailed(d8a.i r100) {
        ((AnimaXLoaderCompletionHandler) this.f548739a).a(AnimaXLoaderResponse.b(new Throwable("LynxResRequest failed with error: " + r100.f467442b + "status code: " + r100.f467441a)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d8a.g
    public final void onSuccess(d8a.i r100) {
        InputStream r101 = r100.f467444d;
        int r102 = 0;
        if (r101 != null) goto L26;
    L20:
        byte[] r103 = y4a.b.c(r101, r102);
        if (r103 == null) goto L23;
        AnimaXLoaderResponse r104 = AnimaXLoaderResponse.a(r103);
    L24:
        ((AnimaXLoaderCompletionHandler) this.f548739a).a(r104);
        return;
    L23:
        r104 = AnimaXLoaderResponse.b(new Throwable("Failed to load raw data with LynxResRequest"));
        goto L24
    L26:
        int r105 = r101.available();     // Catch: IOException -> L7
    L8:
        Map<String, List<String>> r106 = r100.f467443c;
        if (r106 == null) goto L15;
        List<String> r107 = r106.get("content-length");
        if (r107 == null) goto L15;
        if (r107.isEmpty() == true) goto L15;
        r102 = CastIntegerProtector.parseInt((String) ListProtector.get(r107, 0));
    L15:
        if (r105 > 0) goto L19;
        AnimaXLog.b("LynxResourceUtil", "no length from stream, responseContentLength = " + r102);
        if (r102 > 0) goto L20;
    L19:
        r102 = r105;
    L7:
        r105 = 0;
        goto L8
    }
}
