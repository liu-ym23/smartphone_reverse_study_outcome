package w92;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f558742a = null;

    static {
        f558742a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = ga2.e.a((Throwable) r100);
        if (r101 == null) goto L6;
        f2.c(r101, 0);
        return;
    }
}
