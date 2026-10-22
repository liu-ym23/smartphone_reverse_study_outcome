package com.larus.larkfeed.impl.mixedfeed.pack;

import android.util.LruCache;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.w;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import ic8.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class DouBaoFeedDataProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DouBaoFeedDataProvider f355481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, wh8.a> f355482b = null;

    public DouBaoFeedDataProvider() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.larkfeed.impl.mixedfeed.pack.d] */
    static {
        f355481a = new DouBaoFeedDataProvider();
        f355482b = new LruCache(z2.f365865a.getLarkMixedFeedConfig().c());
        w r100 = ILegacyChatUiServiceDelegate.f297164b.z8();
        if (r100 == 0) goto L5;
        r100.a(new d());
        return;
    L5:
        FLogger.f375446a.w("DouBaoFeedDataProvider", "init: conversationListModel is null, onClearedListener not registered");
    }

    public final Object a(String r210, Continuation<? super wh8.a> r211) {
        String r100 = r210;
        if ((r211 instanceof DouBaoFeedDataProvider$queryConversationData$1) == false) goto L7;
        DouBaoFeedDataProvider$queryConversationData$1 r101 = (DouBaoFeedDataProvider$queryConversationData$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        Message r106 = (Message) r101.L$2;
        wc9.e r107 = (wc9.e) r101.L$1;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Message r110 = r106;
        wc9.e r109 = r107;
    L83:
        wh8.a r111 = new wh8.a(r109, (BotModel) r103, r110, null, null, null, null, null, null, null, null, false, 4088);
        f355482b.put(r108, r111);
        return r111;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        wc9.e r112 = (wc9.e) r101.L$1;
        String r113 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        wc9.e r114 = r112;
        r100 = r113;
    L71:
        Message r115 = (Message) r103;
        r101.L$0 = r100;
        r101.L$1 = r114;
        r101.L$2 = r115;
        r101.label = 3;
        Integer r116 = r114.f559207j;
        if (r116 != null) goto L75;
    L76:
        Object r117 = null;
    L80:
        if (r117 != r104) goto L82;
        return r104;
    L82:
        r108 = r100;
        r110 = r115;
        r109 = r114;
        r103 = r117;
        goto L83
    L75:
        if (r116.intValue() != 3) goto L76;
        kotlinx.coroutines.j r118 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r118.C();
        com.larus.im.d.a().batchGetBotByConversationId(CollectionsKt.listOf(r114.f559198a), new e(r118, r114));
        r117 = r118.B();
        if (r117 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L80;
        DebugProbesKt.probeCoroutineSuspended(r101);
        goto L80
    L17:
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L40:
        wc9.e r119 = (wc9.e) r103;
        if (r119 != null) goto L44;
        FLogger.f375446a.w("DouBaoFeedDataProvider", "queryConversationData: repo miss, conversationId=" + r100);
        return null;
    L44:
        w r120 = ILegacyChatUiServiceDelegate.f297164b.z8();
        if (r120 == null) goto L47;
        boolean r121 = r120.b(r119);
    L48:
        if (r121 == true) goto L51;
        FLogger.f375446a.i("DouBaoFeedDataProvider", "queryConversationData: repo conversation filtered, " + n.F(r119));
        return null;
    L51:
        r101.L$0 = r100;
        r101.L$1 = r119;
        r101.label = 2;
        String r122 = r119.f559211n;
        Integer r123 = r119.f559217t;
        if (r123 != null) goto L55;
    L56:
        if (r122 != null) goto L58;
    L61:
        boolean r124 = true;
    L62:
        if (r124 == true) goto L67;
        kotlinx.coroutines.j r125 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r125.C();
        com.larus.im.d.e().m(r122, new f(r125, r119, r122));
        Object r126 = r125.B();
        if (r126 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L68;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L68:
        if (r126 != r104) goto L70;
        return r104;
    L70:
        Object r212 = r126;
        r114 = r119;
        r103 = r212;
    L67:
        r126 = null;
        goto L68
    L58:
        if (StringsKt.isBlank(r122) == true) goto L61;
        r124 = false;
        goto L62
    L55:
        if (r123.intValue() == 4) goto L67;
    L47:
        r121 = true;
        goto L48
    L18:
        ResultKt.throwOnFailure(r103);
        if (StringsKt.isBlank(r210) == false) goto L22;
        FLogger.f375446a.w("DouBaoFeedDataProvider", "queryConversationData: conversationId is blank");
        return null;
    L22:
        w r127 = ILegacyChatUiServiceDelegate.f297164b.z8();
        if (r127 == null) goto L26;
        com.larus.bmhome.chat.api.h r128 = r127.g(r100);
        if (r128 == null) goto L26;
    L28:
        if ((r128 instanceof com.larus.bmhome.chat.api.h.b) == false) goto L32;
        com.larus.bmhome.chat.api.h.b r129 = (com.larus.bmhome.chat.api.h.b) r128;
        f355482b.put(r100, r129.f297205a);
        return r129.f297205a;
    L32:
        if ((r128 instanceof com.larus.bmhome.chat.api.h.a) == false) goto L36;
        FLogger.f375446a.i("DouBaoFeedDataProvider", "queryConversationData: filtered by list model, conversationId=" + r100 + ", reason=" + ((com.larus.bmhome.chat.api.h.a) r128).f297204b);
        return null;
    L36:
        if (Intrinsics.areEqual(r128, com.larus.bmhome.chat.api.h.c.f297206a) == false) goto L86;
        FLogger.f375446a.i("DouBaoFeedDataProvider", "queryConversationData: list cache miss, query repo, conversationId=" + r100);
        RepoDispatcherDelegate r130 = RepoDispatcherDelegate.f307737b;
        DouBaoFeedDataProvider$queryConversationData$conversation$1 r131 = new DouBaoFeedDataProvider$queryConversationData$conversation$1(r100, null);
        r101.L$0 = r100;
        r101.label = 1;
        r103 = r130.d(r131, r101);
        if (r103 != r104) goto L40;
        return r104;
    L86:
        throw new NoWhenBranchMatchedException();
    L26:
        r128 = com.larus.bmhome.chat.api.h.c.f297206a;
    L7:
        r101 = new DouBaoFeedDataProvider$queryConversationData$1(this, r211);
        goto L8
    }
}
