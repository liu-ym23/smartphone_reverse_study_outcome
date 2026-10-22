package u4a;

import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;

/* JADX INFO: loaded from: classes32.dex */
public final class n implements e8a.a<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f548738a;

    public n(l r100) {
        this.f548738a = r100;
    }

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<byte[]> r100) {
        byte[] r101 = r100.f383709b;
        if (r101 != null) goto L5;
    L7:
        l r102 = this.f548738a;
        AnimaXLoaderCompletionHandler r103 = (AnimaXLoaderCompletionHandler) r102;
        r103.a(AnimaXLoaderResponse.b(r100.f383710c));
        return;
    L5:
        if (r100.f383708a != LynxResourceResponse.ResponseState.SUCCESS) goto L7;
        l r104 = this.f548738a;
        AnimaXLoaderCompletionHandler r105 = (AnimaXLoaderCompletionHandler) r104;
        r105.a(AnimaXLoaderResponse.a(r101));
    }
}
