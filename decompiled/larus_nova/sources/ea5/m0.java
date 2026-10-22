package ea5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class m0 implements Consumer<Throwable> {
    public m0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        tt5.a.e("DRIVE_VideoPlayer", "progress bar update timer failed ", r100, false);
    }
}
