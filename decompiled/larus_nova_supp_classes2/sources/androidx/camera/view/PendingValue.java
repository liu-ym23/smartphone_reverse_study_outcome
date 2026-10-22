package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class PendingValue<T> {
    private Pair<CallbackToFutureAdapter.Completer<Void>, T> mCompleterAndValue;

    public PendingValue() {
    }

    public static /* synthetic */ Object a(PendingValue r0, Object r1, CallbackToFutureAdapter.Completer r2) {
        return r0.lambda$setValue$0(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void propagateIfHasValue(Function<T, ListenableFuture<Void>> r3) {
        Threads.checkMainThread();
        Pair<CallbackToFutureAdapter.Completer<Void>, T> r0 = this.mCompleterAndValue;
        if (r0 == null) goto L6;
        ListenableFuture r4 = (ListenableFuture) r3.apply(r0.second);
        CallbackToFutureAdapter.Completer r1 = (CallbackToFutureAdapter.Completer) this.mCompleterAndValue.first;
        Objects.requireNonNull(r1);
        Futures.propagate(r4, r1);
        this.mCompleterAndValue = null;
        return;
    }

    public ListenableFuture<Void> setValue(final T r2) {
        Threads.checkMainThread();
        return CallbackToFutureAdapter.getFuture(new k(this, r2));
    }

    private /* synthetic */ Object lambda$setValue$0(Object r3, CallbackToFutureAdapter.Completer r4) throws Exception {
        Pair<CallbackToFutureAdapter.Completer<Void>, T> r0 = this.mCompleterAndValue;
        if (r0 == null) goto L5;
        CallbackToFutureAdapter.Completer r1 = (CallbackToFutureAdapter.Completer) r0.first;
        Objects.requireNonNull(r1);
        r1.setCancelled();
    L5:
        this.mCompleterAndValue = new Pair(r4, r3);
        return "PendingValue " + r3;
    }
}
