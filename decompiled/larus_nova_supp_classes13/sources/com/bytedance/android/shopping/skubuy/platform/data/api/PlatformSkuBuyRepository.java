package com.bytedance.android.shopping.skubuy.platform.data.api;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.buynow.ultimate.data.remote.UltimateBuyNowApi;
import com.bytedance.android.shopping.utils.s;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import q43.a;
import r43.c;
import r43.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PlatformSkuBuyRepository implements a {
    public static final SkuBuyApi a = null;
    public static final PlatformSkuBuyRepository b = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.skubuy.platform.data.api.PlatformSkuBuyRepository$createOrder$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@"}, d2 = {"Lr43/c;", "body", "", "", "", "urlParams", "Lkotlin/coroutines/Continuation;", "Lr43/d;", "continuation", "createOrder"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.skubuy.platform.data.api.PlatformSkuBuyRepository", f = "PlatformSkuBuyRepository.kt", i = {}, l = {21}, m = "createOrder", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PlatformSkuBuyRepository this$0;

        public AnonymousClass1(PlatformSkuBuyRepository r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createOrder(null, null, this);
        }
    }

    public PlatformSkuBuyRepository() {
    }

    public final void a() {
    }

    static {
        b = new PlatformSkuBuyRepository();
        n r0 = n.a;
        UltimateBuyNowApi.a.getClass();
        a = (SkuBuyApi) r0.create(UltimateBuyNowApi.a.a, SkuBuyApi.class);
    }

    public final Object createOrder(c r5, Map<String, ? extends Object> r6, Continuation<? super d> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L21
    L19:
        return (d) ((SsResponse) r8).body();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        SkuBuyApi r9 = a;     // Catch: Exception -> L21
        r0.label = 1;     // Catch: Exception -> L21
        r8 = r9.createOrder(r5, r6, r0);     // Catch: Exception -> L21
        if (r8 != r2) goto L19;
        return r2;
    L21:
        e = move-exception;
        d r10 = new d(0);
        r10.c(s.a(e));
        return r10;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }
}
