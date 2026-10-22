package com.larus.im.internal.core.conversation.bot;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.database.delegate.BotDaoSource;
import com.larus.im.internal.database.entity.BotEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class GetBotsProcessor extends IMActionProcessor<Unit, Map<String, ? extends BotModel>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f347552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f347553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f347554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f347555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f347556e;

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.bot.GetBotsProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.GetBotsProcessor$process$1", f = "GetBotsProcessor.kt", i = {}, l = {36, 48, 50}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $validBotIds;
        int label;
        final /* synthetic */ GetBotsProcessor this$0;

        public AnonymousClass1(GetBotsProcessor r100, List<String> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$validBotIds = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$validBotIds, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L12;
            if (r102 == 1) goto L11;
            if (r102 == 2) goto L10;
            if (r102 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r100);
        L50:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r100);
        L17:
            List r103 = (List) r100;
            if (r103 == null) goto L36;
            List r104 = r103;
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator r106 = r104.iterator();
        L21:
            if (r106.hasNext() == false) goto L23;
            r105.add(d.c((BotEntity) r106.next()));
            goto L21
        L23:
            ArrayList r107 = new ArrayList();
            Iterator r108 = r105.iterator();
        L25:
            if (r108.hasNext() == false) goto L29;
            Object r109 = r108.next();
            if (com.larus.im.internal.utils.e.a((BotModel) r109) == true) goto L25;
            r107.add(r109);
            goto L25
        L29:
            Map r110 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r107, 10)), 16));
            Iterator r111 = r107.iterator();
        L31:
            if (r111.hasNext() == false) goto L37;
            Object r112 = r111.next();
            String r113 = ((BotModel) r112).getBotId();
            if (r113 != null) goto L35;
            r113 = "";
        L35:
            r110.put(r113, r112);
        L37:
            if (r110 != null) goto L39;
            r110 = MapsKt.emptyMap();
        L39:
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347556e, "Local ids = " + r110.keySet());
            List r114 = CollectionsKt.minus(this.$validBotIds, r110.keySet());
            if (r114.isEmpty() == false) goto L43;
            this.this$0.onSuccess(r110);
            return Unit.INSTANCE;
        L43:
            GetBotsProcessor r115 = this.this$0;
            this.label = 2;
            if (r115.c(r114, r110, this) != r101) goto L50;
            return r101;
        L36:
            r110 = null;
            goto L37
        L12:
            ResultKt.throwOnFailure(r100);
            GetBotsProcessor r116 = this.this$0;
            if (r116.f347553b == true) goto L46;
            be9.a r117 = ae9.a.a();
            List<String> r118 = this.this$0.f347552a;
            this.label = 1;
            r100 = ((BotDaoSource) r117).g(r118, this);
            if (r100 != r101) goto L17;
            return r101;
        L46:
            List<String> r119 = this.$validBotIds;
            this.label = 3;
            if (r116.c(r119, MapsKt.emptyMap(), this) != r101) goto L50;
            return r101;
        }
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        List<String> r100 = this.f347552a;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((!StringsKt.isBlank((String) r103)) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        HashSet r104 = new HashSet();
        ArrayList r105 = new ArrayList();
        Iterator r106 = r101.iterator();
    L10:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if (r104.add((String) r107) == false) goto L10;
        r105.add(r107);
        goto L10
    L15:
        if (r105.isEmpty() == false) goto L18;
        com.larus.im.internal.delegate.a.f348188b.e(this.f347556e, "Invalid request.");
        onFailure(new IMError(-2, null, null, null, 14, null));
        return;
    L18:
        BuildersKt.launch$default(getScope(), null, null, new AnonymousClass1(this, r105, null), 3, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347556e;
    }

    public final Object c(List<String> r100, Map<String, BotModel> r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof GetBotsProcessor$fetchNetBots$1) == false) goto L7;
        GetBotsProcessor$fetchNetBots$1 r101 = (GetBotsProcessor$fetchNetBots$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L25:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (Map) r101.L$1;
        r100 = (List) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L19:
        com.larus.im.internal.network.e r113 = (com.larus.im.internal.network.e) r112;
        if ((r113 instanceof com.larus.im.internal.network.e.f) == false) goto L26;
        List r114 = (List) ((com.larus.im.internal.network.e.f) r113).f349185a;
        com.larus.im.internal.delegate.a.f348188b.i(this.f347556e, "Get remote ids = " + r100);
        GetBotsProcessor$fetchNetBots$2 r105 = new GetBotsProcessor$fetchNetBots$2(this, r114, r110, null);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        if (OmniDatabaseExtKt.e(r105, r101) != r103) goto L25;
        return r103;
    L26:
        com.larus.im.internal.delegate.a.f348188b.i(this.f347556e, "Get remote bots error = " + r113.a());
        onFailure(r113.a());
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r112);
        GetBotsProcessor$fetchNetBots$ret$1 r115 = new GetBotsProcessor$fetchNetBots$ret$1(r100, this, null);
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.label = 1;
        r112 = requestServer(r115, r101);
        if (r112 != r103) goto L19;
        return r103;
    L7:
        r101 = new GetBotsProcessor$fetchNetBots$1(this, r111);
        goto L8
    }

    public GetBotsProcessor(List<String> r100, boolean r101, String r102, boolean r103, IIMCallback<Map<String, BotModel>> r104) {
        Intrinsics.checkNotNullParameter(r100, "botIds");
        Intrinsics.checkNotNullParameter(r102, "scene");
        super(Unit.INSTANCE, r104);
        this.f347552a = r100;
        this.f347553b = r101;
        this.f347554c = r102;
        this.f347555d = r103;
        this.f347556e = "GetBotsProcessor";
    }
}
