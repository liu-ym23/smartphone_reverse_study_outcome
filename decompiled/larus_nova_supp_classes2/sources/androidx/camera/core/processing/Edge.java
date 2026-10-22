package androidx.camera.core.processing;

import androidx.core.util.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Edge<T> implements Consumer<T> {
    private Consumer<T> mListener;

    public Edge() {
    }

    public void accept(T r3) {
        Intrinsics.checkNotNull(this.mListener, "Listener is not set.");
        this.mListener.accept(r3);
    }

    public void setListener(Consumer<T> r1) {
        this.mListener = r1;
    }
}
