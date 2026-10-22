package com.bytedance.android.shopping.store.search.presenter;

import com.bytedance.android.shopping.store.repository.api.StoreSearchV3Api;
import com.bytedance.android.shopping.store.repository.vo.PromotionSearchSuggestWord;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWordResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.store.search.presenter.ShopSearchHotViewPresenter$fillHotWordsByRequest$1", f = "ShopSearchHotViewPresenter.kt", i = {}, l = {134, 141}, m = "invokeSuspend", n = {}, s = {})
final class ShopSearchHotViewPresenter$fillHotWordsByRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShopSearchHotViewPresenter this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.search.presenter.ShopSearchHotViewPresenter$fillHotWordsByRequest$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.store.search.presenter.ShopSearchHotViewPresenter$fillHotWordsByRequest$1$1", f = "ShopSearchHotViewPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ShopSearchHotViewPresenter$fillHotWordsByRequest$1 this$0;

        public AnonymousClass1(ShopSearchHotViewPresenter$fillHotWordsByRequest$1 r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            ShopSearchHotViewPresenter r3 = this.this$0.this$0;
            int r0 = ShopSearchHotViewPresenter.l;
            r3.I();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ShopSearchHotViewPresenter$fillHotWordsByRequest$1(ShopSearchHotViewPresenter r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new ShopSearchHotViewPresenter$fillHotWordsByRequest$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L41:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L19
    L17:
        SearchSuggestWordResponse r11 = (SearchSuggestWordResponse) r10;     // Catch: Exception -> L19
    L21:
        ShopSearchHotViewPresenter r2 = this.this$0;
        int r6 = ShopSearchHotViewPresenter.l;
        r2.getClass();
        if (r11 == null) goto L37;
        Map r7 = qm.a.a;
        qm.a.a("ec_perf_duration_shop_search", "request_end", System.currentTimeMillis());
        List<PromotionSearchSuggestWord> r12 = r11.getData();
        if (r12 == null) goto L35;
        PromotionSearchSuggestWord r13 = (PromotionSearchSuggestWord) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L35;
        List<SearchSuggestWord> r14 = r13.getWords();
        if (r14 == null) goto L35;
        if ((!r14.isEmpty()) == true) goto L33;
        r14 = null;
    L33:
        if (r14 == null) goto L35;
        List<SearchSuggestWord> r15 = CollectionsKt.toMutableList(r14);
    L36:
        r2.g = r15;
    L35:
        r15 = null;
    L37:
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this, null);
        this.label = 2;
        if (BuildersKt.withContext(r16, r3, this) != r0) goto L41;
        return r0;
    L11:
        ResultKt.throwOnFailure(r10);
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L19
        r17.put("shop_id", this.this$0.E().getMarketId());     // Catch: Exception -> L19
        String r18 = r17.toString();     // Catch: Exception -> L19
        Map r4 = qm.a.a;     // Catch: Exception -> L19
        qm.a.a("ec_perf_duration_shop_search", "request_start", System.currentTimeMillis());     // Catch: Exception -> L19
        StoreSearchV3Api.a.getClass();     // Catch: Exception -> L19
        StoreSearchV3Api r5 = StoreSearchV3Api.a.b;     // Catch: Exception -> L19
        if (r5 == null) goto L20;
        this.label = 1;     // Catch: Exception -> L19
        r10 = r5.getSuggestWords("30073", r18, 48, this);     // Catch: Exception -> L19
        if (r10 != r0) goto L17;
        return r0;
    L20:
        r11 = null;
        goto L21
    }
}
