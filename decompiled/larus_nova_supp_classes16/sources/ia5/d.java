package ia5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.d("VideoProgressTimerManager", "go to immersive mode failed, instance=" + this.a.a.hashCode() + ", timer exception " + ((Throwable) r3));
    }
}
