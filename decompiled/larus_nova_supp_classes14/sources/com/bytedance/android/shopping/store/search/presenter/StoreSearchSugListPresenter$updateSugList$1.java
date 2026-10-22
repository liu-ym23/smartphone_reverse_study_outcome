package com.bytedance.android.shopping.store.search.presenter;

import android.os.SystemClock;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.store.search.repository.dto.LogPbDTO;
import com.bytedance.android.shopping.store.repository.api.StoreSearchSugApi;
import com.bytedance.android.shopping.store.repository.dto.StoreSearchSugResponseDTO;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.store.search.presenter.StoreSearchSugListPresenter$updateSugList$1", f = "StoreSearchSugListPresenter.kt", i = {0}, l = {125, 141}, m = "invokeSuspend", n = {"sugResponse"}, s = {"L$0"})
final class StoreSearchSugListPresenter$updateSugList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ StoreSearchSugListPresenter this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.search.presenter.StoreSearchSugListPresenter$updateSugList$1$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.store.search.presenter.StoreSearchSugListPresenter$updateSugList$1$2", f = "StoreSearchSugListPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $sugResponse;
        int label;
        final /* synthetic */ StoreSearchSugListPresenter$updateSugList$1 this$0;

        public AnonymousClass2(StoreSearchSugListPresenter$updateSugList$1 r1, Ref.ObjectRef r2, Continuation r3) {
            this.this$0 = r1;
            this.$sugResponse = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new AnonymousClass2(this.this$0, this.$sugResponse, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L56;
            ResultKt.throwOnFailure(r11);
            StoreSearchSugResponseDTO r12 = (StoreSearchSugResponseDTO) this.$sugResponse.element;
            if (r12 == null) goto L54;
            QLiveData<uj3.g> r0 = this.this$0.this$0.E().getSugListResponseData();
            int r1 = uj3.g.c;
            Intrinsics.checkNotNullParameter(r12, "dto");
            uj3.g r2 = new uj3.g();
            List<sj3.i> r3 = r12.getSugList();
            if (r3 == null) goto L36;
            Iterator<T> r4 = r3.iterator();
        L10:
            if (r4.hasNext() == false) goto L36;
            sj3.i r5 = (sj3.i) r4.next();
            List<uj3.f> r6 = r2.a;
            int r7 = uj3.f.h;
            Intrinsics.checkNotNullParameter(r5, "dto");
            uj3.f r8 = new uj3.f();
            r8.a = r5.c();
            r8.b = r5.a();
            sj3.k r9 = r5.b();
            if (r9 == null) goto L23;
            sj3.m r10 = r9.a();
            if (r10 == null) goto L23;
            String r13 = r10.b();
            if (r13 == null) goto L23;
            Intrinsics.checkNotNullParameter(r13, "<set-?>");
            r8.c = r13;
            Integer r14 = r5.b().a().c();
            if (r14 == null) goto L20;
            r14.intValue();
        L20:
            Integer r15 = r5.b().a().a();
            if (r15 == null) goto L23;
            r15.intValue();
        L23:
            sj3.o r16 = r5.d();
            if (r16 == null) goto L26;
            String r17 = r16.a();
        L27:
            r8.d = r17;
            sj3.o r18 = r5.d();
            if (r18 == null) goto L30;
            Integer r19 = r18.c();
        L31:
            r8.e = r19;
            sj3.o r20 = r5.d();
            if (r20 == null) goto L34;
            String r21 = r20.b();
        L35:
            r8.f = r21;
            ((ArrayList) r6).add(r8);
            goto L10
        L34:
            r21 = null;
            goto L35
        L30:
            r19 = null;
            goto L31
        L26:
            r17 = null;
        L36:
            LogPbDTO r22 = r12.getLogPb();
            if (r22 == null) goto L39;
            String r23 = r22.getImprId();
        L40:
            r2.b = r23;
            r12.getWordsQueryRecord();
            r12.getWordsQueryRecord();
            r0.g(r2);
            ShopSearchViewModel r110 = this.this$0.this$0.E();
            Pair[] r24 = new Pair[7];
            uj3.g r25 = (uj3.g) this.this$0.this$0.E().getSugListResponseData().a();
            if (r25 == null) goto L43;
            String r26 = r25.b;
        L44:
            if (r26 != null) goto L46;
            r26 = "";
        L46:
            r24[0] = TuplesKt.to("impr_id", r26);
            r24[1] = TuplesKt.to("enter_from", "search_store");
            uj3.g r27 = (uj3.g) this.this$0.this$0.E().getSugListResponseData().a();
            if (r27 == null) goto L51;
            List<uj3.f> r28 = r27.a;
            if (r28 == null) goto L51;
            Integer r29 = Boxing.boxInt(((ArrayList) r28).size());
        L52:
            r24[2] = TuplesKt.to("words_num", String.valueOf(r29));
            r24[3] = TuplesKt.to("words_source", "sug");
            r24[4] = TuplesKt.to("raw_query", this.this$0.this$0.E().getSearchContent().a());
            r24[5] = TuplesKt.to("rank", "-1");
            r24[6] = TuplesKt.to("btm_id", new BtmItemBuilder("a1.b8121.c72059.d57789", null, 2, null).withPageFinder(PageFinder.via(this.this$0.this$0.y())).obtainEventBtmParams());
            r110.doEventAction("trending_show", r24);
        L51:
            r29 = null;
            goto L52
        L43:
            r26 = null;
            goto L44
        L39:
            r23 = null;
        L54:
            return Unit.INSTANCE;
        L56:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public StoreSearchSugListPresenter$updateSugList$1(StoreSearchSugListPresenter r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new StoreSearchSugListPresenter$updateSugList$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r21);
    L49:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Ref.ObjectRef r1 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r21);     // Catch: Exception -> L12
        Ref.ObjectRef r16 = r1;
        Object r15 = r14;
        Object r3 = r21;
    L52:
        StoreSearchSugResponseDTO r11 = (StoreSearchSugResponseDTO) r3;     // Catch: Exception -> L34
        Ref.ObjectRef r12 = r16;
        r16 = r2;
    L37:
        r12.element = r11;     // Catch: Exception -> L39
        Object r4 = r15;
        r2 = r16;
    L45:
        List r5 = this.this$0.E().getSugRequestParam().c;
        JSONObject r6 = new JSONObject();
        r6.put("query", String.valueOf(this.this$0.E().getSearchContent().a()));
        r6.put("time", this.this$0.E().getSugRequestParam().d);
        Unit r7 = Unit.INSTANCE;
        ((ArrayList) r5).add(r6);
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass2 r9 = new AnonymousClass2(this, r2, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(r8, r9, this) != r4) goto L49;
        return r4;
    L39:
        e = e;
    L43:
        r2 = r16;
    L44:
        ECExceptionMonitor.e(e);
        r4 = r15;
    L34:
        e = e;
    L12:
        e = e;
        r15 = r14;
        goto L44
    L14:
        ResultKt.throwOnFailure(r21);
        r12 = new Ref.ObjectRef();
        r12.element = null;
        if (this.this$0.E().getSugRequestParam().d.length() != 0) goto L17;
        boolean r10 = true;
    L18:
        if (r10 == false) goto L21;
        dn.a r13 = this.this$0.E().getSugRequestParam();
        String r17 = String.valueOf(SystemClock.elapsedRealtime());
        r13.getClass();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r13.d = r17;
    L21:
        if (this.this$0.E().getPageDuration() != 0) goto L23;
        this.this$0.E().setPageDuration(SystemClock.elapsedRealtime() - this.this$0.E().getMiddlePageStartTime());
    L23:
        this.this$0.E().getSugRequestParam().f = this.this$0.E().getPageDuration();
        StoreSearchSugApi.a.getClass();     // Catch: Exception -> L41
        StoreSearchSugApi r18 = StoreSearchSugApi.a.a;     // Catch: Exception -> L41
        if (r18 == null) goto L36;
        String r19 = String.valueOf(this.this$0.E().getSearchContent().a());     // Catch: Exception -> L41
        this.this$0.E().getSugRequestParam().getClass();     // Catch: Exception -> L41
        this.this$0.E().getSugRequestParam().getClass();     // Catch: Exception -> L41
        int r20 = this.this$0.E().getSugRequestParam().a;     // Catch: Exception -> L41
        int r22 = this.this$0.E().getSugRequestParam().b;     // Catch: Exception -> L41
        List<JSONObject> r23 = this.this$0.E().getSugRequestParam().c;     // Catch: Exception -> L41
        String r24 = this.this$0.E().getSugRequestParam().d;     // Catch: Exception -> L41
        List<JSONObject> r110 = this.this$0.E().getSugRequestParam().e;     // Catch: Exception -> L41
        double r25 = this.this$0.E().getSugRequestParam().f;     // Catch: Exception -> L41
        int r111 = this.this$0.E().getSugRequestParam().g;     // Catch: Exception -> L41
        String r112 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d("ecom_candidate_type", "shop"), JsonDslUtilKt.d("ecom_candidate_value", this.this$0.E().getSearchParam().getShopId())}).toString();     // Catch: Exception -> L41
        this.L$0 = r12;     // Catch: Exception -> L41
        this.L$1 = r12;     // Catch: Exception -> L41
        this.label = 1;     // Catch: Exception -> L41
        r16 = r12;
        r15 = r14;
        r3 = r18.getStoreSearchSugList(r19, "ecom_channel", "ecom_shop", r112, r20, r22, r23, r24, r110, r25, r111, this);     // Catch: Exception -> L39
        if (r3 != r15) goto L31;
        return r15;
    L31:
        r2 = r16;
        goto L52
    L36:
        r16 = r12;
        r15 = r14;
        r11 = null;
    L41:
        e = e;
        r16 = r12;
        r15 = r14;
        goto L43
    L17:
        r10 = false;
        goto L18
    }
}
