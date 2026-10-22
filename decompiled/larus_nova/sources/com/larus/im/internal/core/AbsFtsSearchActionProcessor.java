package com.larus.im.internal.core;

import com.alipay.sdk.m.u.i;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.core.conversation.FtsSearchParam;
import com.larus.im.internal.core.conversation.FtsSearchResult;
import com.ss.android.dypay.api.DyPayConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes29.dex */
public abstract class AbsFtsSearchActionProcessor<T> extends IMActionProcessor<FtsSearchParam, FtsSearchResult<T>> {
    private final IIMCallback<FtsSearchResult<T>> callback;

    /* JADX INFO: renamed from: com.larus.im.internal.core.AbsFtsSearchActionProcessor$execute$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.AbsFtsSearchActionProcessor", f = "AbsFtsSearchActionProcessor.kt", i = {0, 1, 1, 2, 2}, l = {47, 54, 55}, m = "execute", n = {DyPayConstant.KEY_START_TIME, "resultList", DyPayConstant.KEY_START_TIME, "resultList", DyPayConstant.KEY_START_TIME}, s = {"J$0", "L$0", "J$0", "L$0", "J$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbsFtsSearchActionProcessor<T> this$0;

        public AnonymousClass1(AbsFtsSearchActionProcessor<T> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return AbsFtsSearchActionProcessor.access$execute(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.AbsFtsSearchActionProcessor$process$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.AbsFtsSearchActionProcessor$process$1", f = "AbsFtsSearchActionProcessor.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AbsFtsSearchActionProcessor<T> this$0;

        public C114561(AbsFtsSearchActionProcessor<T> r100, Continuation<? super C114561> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114561(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114561) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            AbsFtsSearchActionProcessor<T> r103 = this.this$0;
            this.label = 1;
            if (AbsFtsSearchActionProcessor.access$execute(r103, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.AbsFtsSearchActionProcessor$process$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.AbsFtsSearchActionProcessor$process$2", f = "AbsFtsSearchActionProcessor.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AbsFtsSearchActionProcessor<T> this$0;

        public AnonymousClass2(AbsFtsSearchActionProcessor<T> r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            AbsFtsSearchActionProcessor<T> r103 = this.this$0;
            this.label = 1;
            if (AbsFtsSearchActionProcessor.access$execute(r103, this) != r101) goto L12;
            return r101;
        }
    }

    public Object generateHasMore(List<? extends T> r100, Continuation<? super Boolean> r101) {
        return generateHasMore$suspendImpl(this, r100, r101);
    }

    public abstract Object generateNewCursor(List<? extends T> r100, Continuation<? super Long> r101);

    public abstract Object search(Continuation<? super List<? extends T>> r100);

    private final String queryLogMeta() {
        return "queryLen=" + ((FtsSearchParam) getRequest()).getQuery().length() + ", queryHash=" + ((FtsSearchParam) getRequest()).getQuery().hashCode();
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public void process() {
        if (((FtsSearchParam) getRequest()).getAsync() == false) goto L5;
        BuildersKt.launch$default(getScope(), null, null, new C114561(this, null), 3, null);
        return;
    L5:
        BuildersKt.runBlocking$default(null, new AnonymousClass2(this, null), 1, null);
    }

    public final IIMCallback<FtsSearchResult<T>> getCallback() {
        return this.callback;
    }

    private final Object execute(Continuation<? super Unit> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Integer r104 = null;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        long r105 = r100.J$1;
        long r106 = r100.J$0;
        List<? extends T> r107 = (List) r100.L$1;
        List<? extends T> r108 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L35:
        FtsSearchResult r109 = new FtsSearchResult(r107, r105, ((Boolean) r111).booleanValue());
        com.larus.im.internal.delegate.a r112 = com.larus.im.internal.delegate.a.f348188b;
        String r113 = getTAG();
        StringBuilder r114 = new StringBuilder("fts execute before onSuccess, ");
        r114.append(queryLogMeta());
        r114.append(", size=");
        r114.append(r108.size());
        r114.append(", cost=");
        com.larus.im.internal.delegate.c r115 = com.larus.im.internal.delegate.c.f348197a;
        r114.append(r115.elapsedRealtime() - r106);
        r112.i(r113, r114.toString());
        onSuccess(r109);
        r112.i(getTAG(), "fts execute after onSuccess, " + queryLogMeta() + ", cost=" + (r115.elapsedRealtime() - r106));
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r116 = r100.J$0;
        r107 = (List) r100.L$1;
        List<? extends T> r117 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L31:
        long r118 = ((Number) r111).longValue();
        r100.L$0 = r117;
        r100.L$1 = r107;
        r100.J$0 = r116;
        r100.J$1 = r118;
        r100.label = 3;
        r111 = generateHasMore(r117, r100);
        if (r111 != r102) goto L34;
        return r102;
    L34:
        r106 = r116;
        r108 = r117;
        r105 = r118;
        goto L35
    L17:
        long r119 = r100.J$0;
        ResultKt.throwOnFailure(r111);
    L21:
        List<? extends T> r120 = (List) r111;
        com.larus.im.internal.delegate.a r121 = com.larus.im.internal.delegate.a.f348188b;
        String r122 = getTAG();
        StringBuilder r123 = new StringBuilder("fts execute search return, ");
        r123.append(queryLogMeta());
        r123.append(", searchListSize=");
        if (r120 == null) goto L24;
        r104 = Boxing.boxInt(r120.size());
    L24:
        r123.append(r104);
        r123.append(", cost=");
        r123.append(com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r119);
        r121.i(r122, r123.toString());
        if (r120 != null) goto L27;
        r120 = CollectionsKt.emptyList();
    L27:
        r100.L$0 = r120;
        r100.L$1 = r120;
        r100.J$0 = r119;
        r100.label = 2;
        Object r124 = generateNewCursor(r120, r100);
        if (r124 != r102) goto L30;
        return r102;
    L30:
        r107 = r120;
        r117 = r107;
        r111 = r124;
        r116 = r119;
        goto L31
    L18:
        ResultKt.throwOnFailure(r111);
        r119 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        com.larus.im.internal.delegate.a.f348188b.i(getTAG(), "fts execute start, " + queryLogMeta() + ", cursor=" + ((FtsSearchParam) getRequest()).getCursor() + ", limit=" + ((FtsSearchParam) getRequest()).getLimit() + ", async=" + ((FtsSearchParam) getRequest()).getAsync());
        AbsFtsSearchActionProcessor$execute$searchList$1 r125 = new AbsFtsSearchActionProcessor$execute$searchList$1(this, null);
        r100.J$0 = r119;
        r100.label = 1;
        r111 = TimeoutKt.c(30000, r125, r100);
        if (r111 != r102) goto L21;
        return r102;
    L7:
        r100 = new AnonymousClass1(this, r110);
        goto L8
    }

    public final String escapeSpecialCharacters(String r210) {
        Intrinsics.checkNotNullParameter(r210, "query");
        String[] r100 = {"$", "(", ")", "*", Marker.ANY_NON_NULL_MARKER, "-", ".", ":", "<", ">", "[", "]", "{", i.f25855d, "\"", "\\", "^", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, Constants.WAVE_SEPARATOR};
        int r101 = 0;
        String r102 = r210;
    L4:
        if (r101 >= 19) goto L6;
        r102 = StringsKt.replace$default(r102, r100[r101], " ", false, 4, null);
        r101 = r101 + 1;
        goto L4
    L6:
        return r102;
    }

    public AbsFtsSearchActionProcessor(FtsSearchParam r100, IIMCallback<FtsSearchResult<T>> r101) {
        Intrinsics.checkNotNullParameter(r100, "query");
        super(r100, r101);
        this.callback = r101;
    }

    public static final /* synthetic */ Object access$execute(AbsFtsSearchActionProcessor r100, Continuation r101) {
        return r100.execute(r101);
    }

    public static /* synthetic */ <T> Object generateHasMore$suspendImpl(AbsFtsSearchActionProcessor<T> r100, List<? extends T> r101, Continuation<? super Boolean> r102) {
        if (r101.size() < ((FtsSearchParam) r100.getRequest()).getLimit()) goto L5;
        boolean r103 = true;
    L7:
        return Boxing.boxBoolean(r103);
    L5:
        r103 = false;
        goto L7
    }

    public /* synthetic */ AbsFtsSearchActionProcessor(FtsSearchParam r100, IIMCallback r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
