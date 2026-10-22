package s9;

import com.bytedance.android.annie.Annie;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f541042a = null;

    static {
        f541042a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = x8.a.f562881a;
        x8.a.b(Annie.ANNIE_TAG, String.valueOf(((Throwable) r100).getMessage()), false);
    }
}
