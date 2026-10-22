package y45;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x implements Consumer<Boolean> {
    public x() {
    }

    public final void accept(Object r2) throws Exception {
        if (((Boolean) r2).booleanValue() == false) goto L5;
        tt5.a.h("StreamingCacheUtils", "saveProgressiveSource success!!!");
        return;
    L5:
        tt5.a.h("StreamingCacheUtils", "saveProgressiveSource failure!!!");
    }
}
