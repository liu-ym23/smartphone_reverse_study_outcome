package retrofit2;

import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends CompletableFuture<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Call f537479a;

    public b(Call r100) {
        this.f537479a = r100;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean r100) {
        if (r100 == false) goto L5;
        this.f537479a.cancel();
    L5:
        return super.cancel(r100);
    }
}
