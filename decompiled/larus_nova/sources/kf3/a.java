package kf3;

import com.bytedance.android.shopping.mall.homepage.init.MallInitTaskManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MallInitTaskManager f503194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x93.a f503195b;

    public a(MallInitTaskManager r100, x93.a r101) {
        this.f503194a = r100;
        this.f503195b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        int r102 = this.f503194a.f178175a;
        this.f503195b.I();
        if (r102 < 4) goto L6;
        this.f503195b.run();
        return;
    }
}
