package com.bytedance.android.shopping.mall.feed.opt;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.data.gecko.HybridForestLoader;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.feed.j;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.feed.opt.ECMallSaasPrefetchService$startPrefetch$scope$1", f = "ECMallSaasPrefetchService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ECMallSaasPrefetchService$startPrefetch$scope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $extraParams;
    final /* synthetic */ String $fetchId;
    final /* synthetic */ String $schema;
    int label;
    final /* synthetic */ ECMallSaasPrefetchService this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallSaasPrefetchService$startPrefetch$scope$1 a;

        public a(ECMallSaasPrefetchService$startPrefetch$scope$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECMallSaasPrefetchService$startPrefetch$scope$1 r0 = this.a;     // Catch: Throwable -> L4
            r0.this$0.c.remove(r0.$fetchId);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECMallSaasPrefetchService$startPrefetch$scope$1(ECMallSaasPrefetchService r1, String r2, String r3, j r4, Continuation r5) {
        this.this$0 = r1;
        this.$fetchId = r2;
        this.$schema = r3;
        this.$extraParams = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "completion");
        return new ECMallSaasPrefetchService$startPrefetch$scope$1(this.this$0, this.$fetchId, this.$schema, this.$extraParams, r8);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r7);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L39
        this.this$0.c.remove(this.$fetchId);     // Catch: Throwable -> L39
        LinkedHashMap r9 = new LinkedHashMap();     // Catch: Throwable -> L39
        String r0 = this.$schema;     // Catch: Throwable -> L39
        if (r0 == null) goto L15;
        String r1 = b0.k(r0);     // Catch: Throwable -> L39
        if (r1 == null) goto L15;
        Uri r2 = UriProtector.parse(r1);     // Catch: Throwable -> L39
        Iterator r3 = UriProtector.getQueryParameterNames(r2).iterator();     // Catch: Throwable -> L39
    L11:
        if (r3.hasNext() == false) goto L15;
        String r4 = (String) r3.next();     // Catch: Throwable -> L39
        String r5 = UriProtector.getQueryParameter(r2, r4);     // Catch: Throwable -> L39
        if (r5 == null) goto L11;
        r9.put(r4, r5);     // Catch: Throwable -> L39
    L15:
        JSONObject r6 = this.$extraParams.c;     // Catch: Throwable -> L39
        if (r6 == null) goto L21;
        Iterator<String> r10 = r6.keys();     // Catch: Throwable -> L39
    L19:
        if (r10.hasNext() == false) goto L21;
        String r11 = r10.next();     // Catch: Throwable -> L39
        r9.put(r11, r6.optString(r11, null));     // Catch: Throwable -> L39
    L21:
        ECMallSaasPrefetchService.d(this.this$0, r9, this.$extraParams.a);     // Catch: Throwable -> L39
        final SaasHomepagePrefetch r12 = new SaasHomepagePrefetch(new SaasHomepagePrefetch.a.C0088a(this.$extraParams.a, r9));     // Catch: Throwable -> L39
        this.this$0.c.put(this.$fetchId, r12);     // Catch: Throwable -> L39
        final String r13 = this.$fetchId;     // Catch: Throwable -> L39
        final String r14 = this.$schema;     // Catch: Throwable -> L39
        Intrinsics.checkNotNullParameter(r13, "uuid");     // Catch: Throwable -> L39
        Lazy r15 = NativeMallGeckoHelper.a;     // Catch: Throwable -> L39
        String r16 = NativeMallGeckoHelper.d(r12.g.a);     // Catch: Throwable -> L39
        if (r16.length() != 0) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == true) goto L30;
        Map r18 = HybridForestLoader.a;     // Catch: Throwable -> L39
        Forest r19 = HybridForestLoader.e();     // Catch: Throwable -> L39
        if (r19 == null) goto L30;
        r19.fetchResourceAsync(r16, new RequestParams(0), new SaasHomepagePrefetch$startPrefetch$1(r12, r13, r14));     // Catch: Throwable -> L39
    L30:
        ECMallSaasPrefetchService r20 = this.this$0;     // Catch: Throwable -> L39
        Double r21 = r20.a.get(this.$extraParams.a);     // Catch: Throwable -> L39
        if (r21 == null) goto L33;
        long r22 = (long) r21.doubleValue();     // Catch: Throwable -> L39
    L35:
        if (r22 <= 0) goto L37;
        this.this$0.b.postDelayed(new a(this), r22);     // Catch: Throwable -> L39
    L37:
        Object r23 = Result.constructor-impl(r12);     // Catch: Throwable -> L39
    L41:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L45;
        r24.printStackTrace();
    L45:
        return Unit.INSTANCE;
    L33:
        r22 = 0;
        goto L35
    L24:
        r17 = false;
    L39:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
