package yn6;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public class f {
    private WeakReference<e> callbackWr;
    private boolean onlyDiffCallback;

    public final WeakReference<e> a() {
        return this.callbackWr;
    }

    public final boolean b() {
        return this.onlyDiffCallback;
    }

    public f(WeakReference<e> r100) {
        Intrinsics.checkNotNullParameter(r100, "updateCallback");
        this.callbackWr = r100;
    }

    public final void c(boolean r100) {
        this.onlyDiffCallback = r100;
    }
}
