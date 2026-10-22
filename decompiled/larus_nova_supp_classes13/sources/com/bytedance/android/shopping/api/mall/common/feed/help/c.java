package com.bytedance.android.shopping.api.mall.common.feed.help;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements ECHybridNetworkTask.a {
    public final /* synthetic */ ECMallCommonImpressionReportHelper a;
    public final /* synthetic */ Function1 b;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b.invoke(Boolean.FALSE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b.invoke(Boolean.TRUE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(ECMallCommonImpressionReportHelper r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
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
        this.a.a.post(new b(this));
    }

    public final void e(String r1, Throwable r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "t");
        Logger.d("puffone-NativeCommerceHomePage.onError()", "common_impression");
        this.a.a.post(new a(this));
    }

    public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "requestVO");
        ECHybridNetworkTask.a.a.b(r1, r2, r3);
    }
}
