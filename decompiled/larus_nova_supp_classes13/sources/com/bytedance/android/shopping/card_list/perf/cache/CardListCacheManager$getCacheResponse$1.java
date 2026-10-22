package com.bytedance.android.shopping.card_list.perf.cache;

import cb3.b;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.cache.CacheMonitor;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.error.a;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.google.gson.JsonParseException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.card_list.perf.cache.CardListCacheManager$getCacheResponse$1", f = "CardListCacheManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CardListCacheManager$getCacheResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CardListCacheManager this$0;

    public CardListCacheManager$getCacheResponse$1(CardListCacheManager r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new CardListCacheManager$getCacheResponse$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L85;
        ResultKt.throwOnFailure(r12);
        CardListCacheManager r13 = this.this$0;
        int r1 = CardListCacheManager.j;
        if (((Boolean) r13.g.getValue()).booleanValue() == false) goto L7;
        this.this$0.b();
    L7:
        CardListCacheManager r14 = this.this$0;
        String r2 = r14.i;
        String r5 = "";
        e r6 = null;
        if (r14.f == false) goto L74;
        boolean r9 = true;
        if (CardListCacheManager.Companion.a(r14.b, r2, r14.d, r14.e, true) == false) goto L74;
        CardListRepository r4 = CardListRepository.INSTANCE;
        Pair<LauncherBizType, e> r7 = r4.getCacheResponse();
        if (r7 == null) goto L15;
        LauncherBizType r8 = (LauncherBizType) r7.getFirst();
    L17:
        if (r8 != r14.e) goto L24;
        Pair<LauncherBizType, e> r10 = r4.getCacheResponse();
        if (r10 == null) goto L21;
        e r11 = (e) r10.getSecond();
    L22:
        if (r11 == null) goto L24;
    L21:
        r11 = null;
    L24:
        String r15 = r4.getResponseKeva().getStringJustDisk("card_list_query_response" + r14.e.name(), "");
        boolean r16 = false;
    L52:
        e = e;
    L53:
        a r17 = r14.c;     // Catch: Throwable -> L50
        if (r17 == null) goto L60;
        CardListErrorMonitorType r18 = CardListErrorMonitorType.TRANSFORM_TO_DTO;     // Catch: Throwable -> L50
        StringBuilder r19 = new StringBuilder("CardListCacheManager-transformToDTO-");     // Catch: Throwable -> L50
        r19.append(e.getMessage());     // Catch: Throwable -> L50
        r19.append('-');     // Catch: Throwable -> L50
        Throwable r3 = e.getCause();     // Catch: Throwable -> L50
        if (r3 == null) goto L58;
        String r20 = r3.getMessage();     // Catch: Throwable -> L50
    L59:
        r19.append(r20);     // Catch: Throwable -> L50
        String r21 = r19.toString();     // Catch: Throwable -> L50
        Map<String, a> r110 = a.b;     // Catch: Throwable -> L50
        r17.b(r18, r21, null);     // Catch: Throwable -> L50
        goto L60
    L58:
        r20 = null;
    L60:
        ECExceptionMonitor.e(e);     // Catch: Throwable -> L50
        if (r16 == false) goto L74;
        CacheMonitor r22 = r14.b;
        if (r22 == null) goto L74;
        if (r2 != null) goto L66;
        r2 = "";
    L66:
        CacheMonitor.a(r22, "parse response to DownLinkDataResponse error", r2, CardListRepository.INSTANCE.getResponseKeva().getString("card_list_cache_source" + r14.e.name(), ""));
    L50:
        th = th;
    L67:
        if (r16 == false) goto L73;
        CacheMonitor r23 = r14.b;
        if (r23 == null) goto L73;
        if (r2 != null) goto L72;
        r2 = "";
    L72:
        CacheMonitor.a(r23, "parse response to DownLinkDataResponse error", r2, CardListRepository.INSTANCE.getResponseKeva().getString("card_list_cache_source" + r14.e.name(), ""));
    L73:
        throw th;
    L26:
        if (r15.length() != 0) goto L28;
        r16 = true;
    L28:
        e r24 = (e) u0.b(r15, e.class);     // Catch: Throwable -> L50 JsonParseException -> L52
        if (r24 == null) goto L31;
        Integer r111 = r24.a();     // Catch: Throwable -> L50 JsonParseException -> L52
    L32:
        if (r111 == null) goto L89;
        if (r111.intValue() != 0) goto L89;
        r9 = r16;
    L89:
        r4.setCacheResponse(new Pair(r14.e, r24));     // Catch: Throwable -> L46 JsonParseException -> L48
        if (r9 == false) goto L45;
        CacheMonitor r25 = r14.b;
        if (r25 == null) goto L45;
        if (r2 != null) goto L44;
        r2 = "";
    L44:
        CacheMonitor.a(r25, "parse response to DownLinkDataResponse error", r2, r4.getResponseKeva().getString("card_list_cache_source" + r14.e.name(), ""));
    L45:
        r6 = r24;
        goto L74
    L48:
        e = e;
        r16 = r9;
    L46:
        th = th;
        r16 = r9;
        goto L67
    L31:
        r111 = null;
        goto L32
    L15:
        r8 = null;
    L74:
        if (r6 == null) goto L83;
        int r112 = b.a;
        b.a(new Pair(this.this$0.e, r6));
        Map<String, Map<String, Long>> r113 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(this.this$0.h, "GetCacheResponseEnd");
        CardListCacheManager r114 = this.this$0;
        CacheMonitor r0 = r114.b;
        if (r0 == null) goto L83;
        String r26 = r114.i;
        if (r26 == null) goto L81;
        r5 = r26;
    L81:
        CacheMonitor.a(r0, "success", r5, CardListRepository.INSTANCE.getCacheSourceType(r114.e));
    L83:
        return Unit.INSTANCE;
    L85:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
