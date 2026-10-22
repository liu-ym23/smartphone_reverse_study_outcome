package kf3;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.m;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r4) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.b(m.a.b, "MallInitTaskManager run task error, msg : " + ((Throwable) r4).getMessage());
    }
}
