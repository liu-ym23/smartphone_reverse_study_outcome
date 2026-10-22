package com.bytedance.android.shopping.new_cart.container;

import android.os.Handler;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListCartSliceRenderInfoManager {
    public final a a;
    public final Lazy b;

    public static final class a extends HandlerExecutorServiceImpl {
        public a(Handler r1) {
            super(r1);
        }

        public final void execute(Runnable r2) {
            if (r2 == null) goto L8;
            Lazy r0 = UIUtils.a;
            if (UIUtils.d() == false) goto L6;
            r2.run();
            return;
        L6:
            UIUtils.c().postAtFrontOfQueue(r2);
            return;
        }
    }

    public CardListCartSliceRenderInfoManager() {
        Lazy r1 = UIUtils.a;
        this.a = new a(UIUtils.c());
        this.b = LazyKt.lazy(CardListCartSliceRenderInfoManager$fieldUIExecutor$2.INSTANCE);
    }
}
