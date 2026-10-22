package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/c;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1", f = "ECMallFavoriteSectionHelper.kt", i = {}, l = {1008}, m = "invokeSuspend", n = {}, s = {})
public final class ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1 extends SuspendLambda implements Function1<Continuation<? super com.bytedance.android.shopping.api.mall.c>, Object> {
    final /* synthetic */ Map $insertParams;
    final /* synthetic */ String $requestKey;
    final /* synthetic */ int $tabId;
    final /* synthetic */ boolean $useNativeDynamicParams;
    Object L$0;
    int label;
    final /* synthetic */ ECMallFavoriteSectionHelper this$0;

    public static final class a implements ECHybridNetworkTask.a {
        public final /* synthetic */ Continuation a;
        public final /* synthetic */ ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1 b;

        public a(SafeContinuation r1, ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void c(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.c(r1, r2, r3);
        }

        public final void d(String r9, String r10, ECHybridNetworkVO r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r9, "apiKey");
            Intrinsics.checkNotNullParameter(r10, "result");
            Intrinsics.checkNotNullParameter(r11, "requestVO");
            Continuation r13 = this.a;
            Result.Companion r0 = Result.Companion;
            r13.resumeWith(Result.constructor-impl(new com.bytedance.android.shopping.api.mall.c(true, r9, r11, this.b.$requestKey, r10, null)));
        }

        public final void e(String r9, Throwable r10, ECHybridNetworkVO r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r9, "apiKey");
            Intrinsics.checkNotNullParameter(r10, "t");
            Continuation r13 = this.a;
            Result.Companion r0 = Result.Companion;
            r13.resumeWith(Result.constructor-impl(new com.bytedance.android.shopping.api.mall.c(false, r9, r11, this.b.$requestKey, null, r10)));
        }

        public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.b(r1, r2, r3);
        }
    }

    public ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1(ECMallFavoriteSectionHelper r1, int r2, boolean r3, Map r4, String r5, Continuation r6) {
        this.this$0 = r1;
        this.$tabId = r2;
        this.$useNativeDynamicParams = r3;
        this.$insertParams = r4;
        this.$requestKey = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "completion");
        return new ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1(this.this$0, this.$tabId, this.$useNativeDynamicParams, this.$insertParams, this.$requestKey, r9);
    }

    public final Object invoke(Object r2) {
        return create((Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1 r2 = (ECMallFavoriteSectionHelper$innerRequestFavoriteFeed$executeJob$1) this.L$0;
        ResultKt.throwOnFailure(r9);
    L17:
        return (com.bytedance.android.shopping.api.mall.c) r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        this.L$0 = this;
        this.label = 1;
        SafeContinuation r10 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        ECHybridDataEngine r3 = this.this$0.w;
        if (r3 == null) goto L11;
        r3.g(String.valueOf(this.$tabId), CollectionsKt.listOf("favorite_feed"), this.$useNativeDynamicParams, this.$insertParams, new a(r10, this));
    L11:
        r9 = r10.getOrThrow();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(this);
    L14:
        if (r9 != r0) goto L17;
        return r0;
    }
}
