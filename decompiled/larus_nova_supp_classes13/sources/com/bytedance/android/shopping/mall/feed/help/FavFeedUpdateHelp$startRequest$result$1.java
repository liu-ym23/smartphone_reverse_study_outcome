package com.bytedance.android.shopping.mall.feed.help;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/c;", "response", "", "invoke", "(Lcom/bytedance/android/shopping/api/mall/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class FavFeedUpdateHelp$startRequest$result$1 extends Lambda implements Function1<com.bytedance.android.shopping.api.mall.c, Unit> {
    final /* synthetic */ String $updateId;
    final /* synthetic */ d this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ FavFeedUpdateHelp$startRequest$result$1 a;

        public a(FavFeedUpdateHelp$startRequest$result$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r0 = this.a.this$0;     // Catch: Throwable -> L4
            int r1 = d.i;     // Catch: Throwable -> L4
            r0.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public FavFeedUpdateHelp$startRequest$result$1(d r1, String r2) {
        this.this$0 = r1;
        this.$updateId = r2;
        super(1);
    }

    public final void invoke(com.bytedance.android.shopping.api.mall.c r9) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.e.b, "refresh from lynx, request end");
        if (r9 != null) goto L5;
        d r10 = this.this$0;
        int r1 = d.i;
        r10.a();
        return;
    L5:
        Handler r2 = new Handler(Looper.getMainLooper());
        Long r3 = this.this$0.b;
        if (r3 == null) goto L10;
        long r4 = r3.longValue();
        if (r4 <= 0) goto L10;
        r2.postDelayed(new a(this), r4);
    L10:
        int r5 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(this.this$0.a) == true) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(this.this$0.a, this.$updateId) == true) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(this.this$0.d, this.$updateId) == false) goto L20;
        d r6 = this.this$0;
        r6.a();
        ECMallFeed r7 = r6.h;
        if (r7.Q > 0) goto L26;
        r7.H(0, r9, false, null, null, null);
        return;
    L26:
        return;
    L20:
        this.this$0.c = r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.shopping.api.mall.c) r1);
        return Unit.INSTANCE;
    }
}
