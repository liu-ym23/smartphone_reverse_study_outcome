package tt1;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f547526a = null;

    static {
        f547526a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f2.c("当前网络不佳，请稍后重试", 0);
        x8.a.c("anchor_highlight", (Throwable) r100, false);
    }
}
