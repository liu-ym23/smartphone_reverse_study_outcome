package ea5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m0 implements Consumer<Throwable> {
    public m0() {
    }

    public final void accept(Object r4) throws Exception {
        tt5.a.e("DRIVE_VideoPlayer", "progress bar update timer failed ", (Throwable) r4, false);
    }
}
