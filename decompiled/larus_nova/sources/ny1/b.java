package ny1;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f521186a = null;

    static {
        f521186a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof CustomApiServerException) == false) goto L6;
        int r102 = ToastUtil.f90810a;
        ToastUtil.b(((CustomApiServerException) r101).getPrompt(), 0);
        return;
    }
}
