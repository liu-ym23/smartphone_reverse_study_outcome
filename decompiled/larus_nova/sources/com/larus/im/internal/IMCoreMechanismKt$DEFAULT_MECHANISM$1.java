package com.larus.im.internal;

import android.os.SystemClock;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.jni.OmniSDKHelper;
import com.larus.im.internal.network.chunk.ChunkOperator;
import com.larus.im.internal.network.chunk.cache.SseHeaderCache;
import com.larus.im.internal.protocol.bean.FetchChunkMessageUplinkBody;
import com.larus.im.internal.protocol.bean.MixedTokens;
import com.larus.im.internal.protocol.bean.UplinkMessageChannel;
import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "token", "Lcom/larus/im/internal/TokenHolder;", "message", "Lcom/larus/im/internal/database/entity/MessageEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.IMCoreMechanismKt$DEFAULT_MECHANISM$1", f = "IMCoreMechanism.kt", i = {0}, l = {145, 147}, m = "invokeSuspend", n = {"config"}, s = {"L$0"})
public final class IMCoreMechanismKt$DEFAULT_MECHANISM$1 extends SuspendLambda implements Function3<TokenHolder, MessageEntity, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public IMCoreMechanismKt$DEFAULT_MECHANISM$1(Continuation<? super IMCoreMechanismKt$DEFAULT_MECHANISM$1> r100) {
        super(3, r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TokenHolder r100, MessageEntity r101, Continuation<? super Unit> r102) {
        IMCoreMechanismKt$DEFAULT_MECHANISM$1 r103 = new IMCoreMechanismKt$DEFAULT_MECHANISM$1(r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(TokenHolder r100, MessageEntity r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        ResultKt.throwOnFailure(r210);
    L108:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        com.larus.im.internal.network.chunk.e r102 = (com.larus.im.internal.network.chunk.e) this.L$0;
        ResultKt.throwOnFailure(r210);
    L103:
        com.larus.im.internal.network.chunk.e r103 = r102;
    L104:
        ChunkOperator r104 = ChunkOperator.f349062a;
        this.L$0 = null;
        this.label = 2;
        if (r104.a(r103, false, this) != r100) goto L108;
        return r100;
    L10:
        ResultKt.throwOnFailure(r210);
        final TokenHolder r105 = (TokenHolder) this.L$0;
        final MessageEntity r106 = (MessageEntity) this.L$1;
        String r107 = r106.getMessageId();
        String r108 = r106.getConversationId();
        String r110 = r106.getThreadId();
        com.larus.im.internal.delegate.a r111 = com.larus.im.internal.delegate.a.f348188b;
        r111.i("IMCoreMechanism", "enable sse protocol v2 " + com.larus.im.internal.network.stragery.f.a() + ",msgId:" + r107 + ",conversationId:" + r108 + ",threadId:" + r110);
        if (r107 != null) goto L13;
    L16:
        boolean r112 = true;
    L17:
        if (r112 == true) goto L112;
        if (r105 == null) goto L112;
        if (v.a(r105) == false) goto L112;
        if (r108 != null) goto L23;
    L26:
        boolean r113 = true;
    L27:
        if (r113 == false) goto L36;
        if (r110 != null) goto L30;
    L33:
        boolean r114 = true;
    L34:
        if (r114 == false) goto L36;
    L30:
        if (StringsKt.isBlank(r110) == true) goto L33;
        r114 = false;
    L36:
        ReentrantReadWriteLock r115 = com.larus.im.internal.utils.g.f350539a;
        String r116 = r106.getLocalMessageId();
        String r117 = r106.getMessageId();
        String r118 = "";
        if (r117 != null) goto L40;
        r117 = "";
    L40:
        if (com.larus.im.internal.utils.g.a(r116, CollectionsKt.listOf(r117)) == true) goto L42;
    L45:
        String r119 = r106.getExt();
        if (r119 == null) goto L50;
        Map<String, String> r120 = com.flow.kmp.common.util.k.d(r119);
        if (r120 == null) goto L50;
        final String r121 = r120.get("reply_unique_key");
    L52:
        if (com.flow.kmp.common.util.f.a(r121) == true) goto L54;
    L57:
        String r122 = r105.getTokenV1();
        if (r122 != null) goto L60;
        r122 = "";
    L60:
        MixedTokens r109 = r105.getTokenV2();
        if (r109 == null) goto L63;
        String r123 = r109.sseToken;
    L64:
        if (r123 != null) goto L67;
        r123 = "";
    L67:
        if ((!StringsKt.isBlank(r123)) == false) goto L86;
        if (com.larus.im.internal.network.stragery.f.a() == false) goto L86;
        int r124 = com.larus.im.internal.network.chunk.cache.a.b(r123);
        if (r124 > Integer.MIN_VALUE) goto L73;
    L76:
        int r125 = 0;
    L78:
        if (r108 == null) goto L81;
        r118 = r108;
    L81:
        if (r125 > 0) goto L83;
        me9.b r126 = new me9.b.a(SystemClock.elapsedRealtime());
    L84:
        r103 = new com.larus.im.internal.network.chunk.e.b(r118, r123, r126, null, new FetchChunkMessageUplinkBody(r123, r125, null, 4, null));
    L98:
        if (r103.f349106a != UplinkMessageChannel.SSE) goto L104;
        SseHeaderCache r127 = SseHeaderCache.f349082a;
        this.L$0 = r103;
        this.label = 1;
        if (r127.b(r106, r123, this) != r100) goto L102;
        return r100;
    L102:
        r102 = r103;
        goto L103
    L83:
        r126 = new me9.b.c(SystemClock.elapsedRealtime());
        goto L84
    L73:
        if (r106.getStatus() == 24) goto L76;
        r125 = r124 + 1;
    L86:
        if (com.larus.im.internal.database.utils.o.a(r106) == true) goto L110;
        if (com.larus.im.internal.database.utils.k.i(r106) == false) goto L110;
        int r128 = com.larus.im.internal.network.chunk.cache.a.b(r122);
        if (r106.getStatus() != 24) goto L93;
        int r129 = 0;
    L96:
        r103 = new com.larus.im.internal.network.chunk.e.a(r107, r122, r106, new FetchChunkMessageUplinkBody(r122, r129, null, 4, null));
        goto L98
    L93:
        if (r128 > Integer.MIN_VALUE) goto L95;
        r129 = 1;
        goto L96
    L95:
        r129 = r128 + 1;
    L110:
        return Unit.INSTANCE;
    L63:
        r123 = null;
        goto L64
    L54:
        if (com.larus.im.internal.database.utils.k.h(r106) == true) goto L57;
        r111.i("IMCoreMechanism", "launchChunk, conversation id = " + r108 + ", threadId = " + r110 + " msgId = " + r107 + " replyUniqueKey = " + r121);
        OmniSDKHelper.getOmniSDK$default(OmniSDKHelper.INSTANCE, com.larus.im.internal.delegate.b.f348193b.getUserId(), false, 2, null).withMessageService(new j(r105, r106, r121));
        return Unit.INSTANCE;
    L50:
        r121 = null;
        goto L52
    L42:
        if (com.larus.im.internal.database.utils.k.h(r106) == true) goto L45;
        r111.i("IMCoreMechanism", "is new chat sse streaming msgId = " + r107 + "  local msg id = " + r106.getLocalMessageId());
        return Unit.INSTANCE;
    L23:
        if (StringsKt.isBlank(r108) == true) goto L26;
        r113 = false;
    L112:
        return Unit.INSTANCE;
    L13:
        if (StringsKt.isBlank(r107) == true) goto L16;
        r112 = false;
        goto L17
    }
}
