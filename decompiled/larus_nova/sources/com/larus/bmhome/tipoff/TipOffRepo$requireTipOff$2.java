package com.larus.bmhome.tipoff;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;
import tx9.z1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.tipoff.TipOffRepo$requireTipOff$2", f = "TipOffRepo.kt", i = {1}, l = {32, 54}, m = "invokeSuspend", n = {"success"}, s = {"I$0"})
public final class TipOffRepo$requireTipOff$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<String> $batchIds;
    final /* synthetic */ Function1<Integer, Unit> $callback;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $entityId;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ String $reasonDetail;
    final /* synthetic */ ArrayList<Integer> $reasonIds;
    final /* synthetic */ int $reportSource;
    final /* synthetic */ int $reportType;
    final /* synthetic */ String $serverIndex;
    int I$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.tipoff.TipOffRepo$requireTipOff$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.tipoff.TipOffRepo$requireTipOff$2$1", f = "TipOffRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Integer, Unit> $callback;
        final /* synthetic */ com.larus.network.http.a<Object> $resultAsync;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(com.larus.network.http.a<? extends Object> r100, Function1<? super Integer, Unit> r101, Continuation<? super AnonymousClass1> r102) {
            this.$resultAsync = r100;
            this.$callback = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$resultAsync, this.$callback, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r100);
            com.larus.network.http.a<Object> r101 = this.$resultAsync;
            if ((r101 instanceof y) == false) goto L11;
            Function1<Integer, Unit> r102 = this.$callback;
            Long r103 = ((y) r101).f360205g;
            if (r103 == null) goto L9;
            int r104 = (int) r103.longValue();
        L10:
            r102.invoke(Boxing.boxInt(r104));
            goto L11
        L9:
            r104 = 0;
        L11:
            com.larus.network.http.a<Object> r105 = this.$resultAsync;
            if ((r105 instanceof com.larus.network.http.f) == false) goto L15;
            this.$callback.invoke(Boxing.boxInt((int) ((com.larus.network.http.f) r105).f360157d.getCode()));
        L15:
            return Unit.INSTANCE;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TipOffRepo$requireTipOff$2(String r100, String r101, int r102, ArrayList<Integer> r103, String r104, String r105, int r106, List<String> r107, Map<String, String> r108, Function1<? super Integer, Unit> r110, Continuation<? super TipOffRepo$requireTipOff$2> r111) {
        this.$conversationId = r100;
        this.$entityId = r101;
        this.$reportType = r102;
        this.$reasonIds = r103;
        this.$reasonDetail = r104;
        this.$serverIndex = r105;
        this.$reportSource = r106;
        this.$batchIds = r107;
        this.$extra = r108;
        this.$callback = r110;
        super(2, r111);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new TipOffRepo$requireTipOff$2(this.$conversationId, this.$entityId, this.$reportType, this.$reasonIds, this.$reasonDetail, this.$serverIndex, this.$reportSource, this.$batchIds, this.$extra, this.$callback, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((TipOffRepo$requireTipOff$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r100 = this.label;
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L9;
        if (r100 != 2) goto L8;
        int r101 = this.I$0;
        ResultKt.throwOnFailure(r110);
    L22:
        String r102 = this.$conversationId;
        String r103 = this.$entityId;
        if (r101 == 0) goto L25;
        boolean r104 = true;
    L26:
        z1.a(r102, r103, "tipoff", Boxing.boxBoolean(r104));
        if (r101 == 0) goto L29;
        boolean r112 = true;
    L31:
        return Boxing.boxBoolean(r112);
    L29:
        r112 = false;
        goto L31
    L25:
        r104 = false;
        goto L26
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r110);
        Object r105 = r110;
    L18:
        com.larus.network.http.a r106 = (com.larus.network.http.a) r105;
        FLogger.f375446a.d("RESULTASYNC", "RESULT ASYNC " + r106);
        boolean r107 = r106 instanceof y;
        MainCoroutineDispatcher r108 = Dispatchers.getMain();
        AnonymousClass1 r109 = new AnonymousClass1(r106, this.$callback, null);
        this.I$0 = r107 ? 1 : 0;
        this.label = 2;
        if (BuildersKt.withContext(r108, r109, this) != r111) goto L21;
        return r111;
    L21:
        r101 = r107 ? 1 : 0;
        goto L22
    L10:
        ResultKt.throwOnFailure(r110);
        JSONObject r113 = new JSONObject();
        int r114 = this.$reportType;
        String r115 = this.$entityId;
        ArrayList<Integer> r116 = this.$reasonIds;
        String r117 = this.$reasonDetail;
        String r118 = this.$serverIndex;
        String r119 = this.$conversationId;
        int r120 = this.$reportSource;
        List<String> r121 = this.$batchIds;
        Map<String, String> r122 = this.$extra;
        r113.put("report_type", r114);
        r113.put(PickerReporterConstants.KEY.ENTITY_ID, r115);
        r113.put("reason_ids", new JSONArray(r116));
        r113.put("reason_detail", r117);
        r113.put("index_in_conversation", r118);
        r113.put("conversation_id", r119);
        r113.put("report_source", r120);
        if (r121 == null) goto L13;
        r113.put("batch_message_ids", new JSONArray(r121));
    L13:
        if (r122 == null) goto L15;
        r113.put("extra", new JSONObject(r122));
    L15:
        Unit r123 = Unit.INSTANCE;
        this.label = 1;
        r105 = HttpExtKt.k(ServiceType.UGC, Object.class, "/alice/report/create", r113, null, null, false, null, null, null, this, 1008);
        if (r105 != r111) goto L18;
        return r111;
    }
}
