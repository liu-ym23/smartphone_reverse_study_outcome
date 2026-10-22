package u4a;

import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderResponse;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class g implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f548735a;

    public /* synthetic */ g(l r100) {
        this.f548735a = r100;
    }

    public final void a(j r100, String r101) {
        l r102 = this.f548735a;
        if (r100 != null) goto L5;
    L8:
        AnimaXLoaderResponse<Throwable> r103 = AnimaXLoaderResponse.b(new Throwable(r101));
    L9:
        ((AnimaXLoaderCompletionHandler) r102).a(r103);
        return;
    L5:
        if (r101.isEmpty() == false) goto L8;
        r103 = new AnimaXLoaderResponse(AnimaXLoaderResponse.Type.BITMAP, r100);
        goto L9
    }
}
