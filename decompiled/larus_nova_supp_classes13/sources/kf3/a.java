package kf3;

import com.bytedance.android.shopping.mall.homepage.init.MallInitTaskManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ MallInitTaskManager a;
    public final /* synthetic */ x93.a b;

    public a(MallInitTaskManager r1, x93.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Integer r3 = (Integer) r2;
        int r4 = this.a.a;
        this.b.I();
        if (r4 < 4) goto L6;
        this.b.run();
        return;
    }
}
