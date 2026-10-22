package x80;

import com.bytedance.android.live.core.verify.strategy.IVerifyStrategyFactory;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    public static b a(int r100) {
        IVerifyStrategyFactory r101 = (IVerifyStrategyFactory) k.f(IVerifyStrategyFactory.class);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.createVerifyStrategy(r100);
    }
}
