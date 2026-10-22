package retrofit2;

import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements Callback<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletableFuture f537485a;

    public f(e r100) {
        this.f537485a = r100;
    }

    @Override // retrofit2.Callback
    public final void onFailure(Call<Object> r100, Throwable r101) {
        this.f537485a.completeExceptionally(r101);
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call<Object> r100, Response<Object> r101) {
        this.f537485a.complete(r101);
    }
}
