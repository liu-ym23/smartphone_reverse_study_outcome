package ia5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f488921a;

    public d(b r100) {
        this.f488921a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("VideoProgressTimerManager", "go to immersive mode failed, instance=" + this.f488921a.f488915a.hashCode() + ", timer exception " + ((Throwable) r100));
    }
}
