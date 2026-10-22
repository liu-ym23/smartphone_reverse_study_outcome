package kf3;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.m;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f503196a = null;

    static {
        f503196a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Lazy r101 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(m.a.f47507b, "MallInitTaskManager run task error, msg : " + ((Throwable) r100).getMessage());
    }
}
