package retrofit2;

import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements Callback<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletableFuture f537480a;

    public c(b r100) {
        this.f537480a = r100;
    }

    @Override // retrofit2.Callback
    public final void onFailure(Call<Object> r100, Throwable r101) {
        this.f537480a.completeExceptionally(r101);
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call<Object> r100, Response<Object> r101) {
        if (r101.isSuccessful() == false) goto L5;
        this.f537480a.complete(r101.body());
        return;
    L5:
        this.f537480a.completeExceptionally(new HttpException(r101));
    }
}
