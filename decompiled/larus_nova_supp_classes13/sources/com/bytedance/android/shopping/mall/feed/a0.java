package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.shopping.api.mall.model.ImpressionItem;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 implements ECHybridNetworkTask.a {
    public final /* synthetic */ ECMallFeed a;

    public static final class a implements Runnable {
        public final /* synthetic */ a0 a;

        public a(a0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECMallFeed r0 = this.a.a;     // Catch: Throwable -> L4
            List<ImpressionItem> r1 = r0.Z;     // Catch: Throwable -> L4
            CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) r1;     // Catch: Throwable -> L4
            r2.removeAll(r0.a0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a0(ECMallFeed r1) {
        this.a = r1;
    }

    public final void c(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "requestVO");
        ECHybridNetworkTask.a.a.c(r1, r2, r3);
    }

    public final void d(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "requestVO");
        Logger.d("puffone-NativeCommerceHomePage.onSuccess()", "common_impression");
        this.a.i.post(new a(this));
    }

    public final void e(String r1, Throwable r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "t");
        Logger.d("puffone-NativeCommerceHomePage.onError()", "common_impression");
    }

    public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "requestVO");
        ECHybridNetworkTask.a.a.b(r1, r2, r3);
    }
}
