package l5a;

import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl;
import u4a.i;
import u4a.k;
import u4a.l;
import u4a.m;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceLoaderImpl f507573a;

    /* JADX INFO: renamed from: l5a.a$a, reason: collision with other inner class name */
    public class C6651a extends ResourceLoaderCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f507574a;

        @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback
        public final void destroy() {
        }

        public C6651a(l r100) {
            this.f507574a = r100;
            super(0);
        }

        @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback
        public final void onFailed(String r100) {
            ((AnimaXLoaderCompletionHandler) this.f507574a).a(AnimaXLoaderResponse.b(new Throwable("LottieLoader failed with error: " + r100)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback
        public final void onSucceeded(byte[] r100) {
            if (r100 == null) goto L4;
            AnimaXLoaderResponse r101 = AnimaXLoaderResponse.a(r100);
        L5:
            ((AnimaXLoaderCompletionHandler) this.f507574a).a(r101);
            return;
        L4:
            r101 = AnimaXLoaderResponse.b(new Throwable("Failed to load raw data with LottieLoader"));
            goto L5
        }
    }

    public a() {
        this.f507573a = ResourceLoaderImpl.create();
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.HTTP;
    }

    @Override // u4a.k
    public final void a(m r100, l r101) {
        AnimaXLoaderRequest r102 = (AnimaXLoaderRequest) r100;
        String r103 = r102.b();
        if (r102.a() == null) goto L6;
        i.a(new AnimaXLoaderRequest(r103, r102.f380306c), r101);
        return;
    L6:
        C6651a r104 = new C6651a(r101);
        this.f507573a.load(2, r103, r104, false, false);
    }
}
