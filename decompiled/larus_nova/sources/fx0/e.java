package fx0;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f479063a;

    public e(b r100) {
        this.f479063a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        RxUtil.getNoOpThrowable();
        this.f479063a.finishWithResult(new b.c(3, null));
    }
}
