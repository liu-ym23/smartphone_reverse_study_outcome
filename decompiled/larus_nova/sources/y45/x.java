package y45;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class x implements Consumer<Boolean> {
    public x() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Boolean r100) throws Exception {
        if (r100.booleanValue() == false) goto L5;
        tt5.a.h("StreamingCacheUtils", "saveProgressiveSource success!!!");
        return;
    L5:
        tt5.a.h("StreamingCacheUtils", "saveProgressiveSource failure!!!");
    }
}
