package t53;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f544626a = null;

    static {
        f544626a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((com.bytedance.android.ec.core.event.a) r100).newPost();
    }
}
