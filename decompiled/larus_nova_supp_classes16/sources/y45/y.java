package y45;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y implements Consumer<Throwable> {
    public y() {
    }

    public final void accept(Object r3) throws Exception {
        tt5.a.d("StreamingCacheUtils", "saveProgressiveSource error!!!, e = " + ((Throwable) r3).getMessage());
    }
}
