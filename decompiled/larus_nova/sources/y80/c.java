package y80;

import com.bytedance.android.live.core.verify.strategy.IVerifyStrategyFactory;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f566659a = 0;

    public static b a() {
        IVerifyStrategyFactory r100 = (IVerifyStrategyFactory) k.f(IVerifyStrategyFactory.class);
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.createRechargeVerifyStrategy(1);
    }

    static {
    }
}
