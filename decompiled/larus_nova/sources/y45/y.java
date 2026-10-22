package y45;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class y implements Consumer<Throwable> {
    public y() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.d("StreamingCacheUtils", "saveProgressiveSource error!!!, e = " + r100.getMessage());
    }
}
