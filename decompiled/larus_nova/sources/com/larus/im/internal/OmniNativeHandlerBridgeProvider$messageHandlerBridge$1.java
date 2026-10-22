package com.larus.im.internal;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.internal.core.cmd.processor.ServerLoadingCmdProcessor;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.delegate.d0;
import com.larus.im.internal.network.chunk.ChunkOperator;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.internal.stream.PendingHandler;
import com.larus.trace.CopyContentTypeString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes4.dex */
public final class OmniNativeHandlerBridgeProvider$messageHandlerBridge$1 implements hd9.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f347165a;

    @Override // hd9.o
    public final void resumeChunk() {
        ChunkOperator r100 = ChunkOperator.f349062a;
        ChunkOperator.c();
    }

    public OmniNativeHandlerBridgeProvider$messageHandlerBridge$1() {
        this.f347165a = LazyKt.lazy(new t());
    }

    @Override // hd9.o
    public final void clearAllServerLoading(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        int r101 = ServerLoadingCmdProcessor.f347526d;
        ServerLoadingCmdProcessor.a.b(r100);
    }

    @Override // hd9.o
    public final List<String> getAllServerLoadingLocalMessageIds(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        int r101 = ServerLoadingCmdProcessor.f347526d;
        List r102 = ServerLoadingCmdProcessor.a.d(r100);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        String r105 = ((ServerLoadingCmdProcessor.a.C4339a) r104.next()).f347529b;
        if (r105 == null) goto L4;
        r103.add(r105);
        goto L4
    L8:
        return r103;
    }

    @Override // hd9.o
    public final void ignoreQuestion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "questionId");
        Object r101 = com.larus.im.internal.core.message.utils.f.f347865a;
        Intrinsics.checkNotNullParameter(r100, "replyFor");
        vt7.b<String> r102 = com.larus.im.internal.core.message.utils.f.f347867c;
        r102.add(r100);
        if (r102.size() <= 100) goto L6;
        r102.remove(CollectionsKt.first(r102));
        return;
    }

    @Override // hd9.o
    public final boolean isMsgPended(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        PendingHandler r101 = PendingHandler.f350084a;
        return CollectionsKt.contains(PendingHandler.f350086c, r100);
    }

    @Override // hd9.o
    public final void handleDeprecatedCmd(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
        com.larus.im.internal.delegate.a.f348188b.w("OmniNativeHandlerBridgeProvider", "handleDeprecatedCmd: " + r100 + ", from: " + r101);
        wt7.c r102 = wt7.a.f561230a;
        juc.d<DownlinkMessage> r103 = DownlinkMessage.Companion.serializer();
        r102.getClass();
        DownlinkMessage r104 = (DownlinkMessage) wt7.c.a(r100, r103);
        if (r104 != null) goto L5;
        return;
    L5:
        com.larus.im.internal.core.cmd.util.c.a(new OmniNativeHandlerBridgeProvider$messageHandlerBridge$1$handleDeprecatedCmd$1(r104, null));
    }

    @Override // hd9.o
    public final void handleSSECmd(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L9;
        wt7.c r102 = wt7.a.f561230a;
        juc.d<DownlinkMessage> r103 = DownlinkMessage.Companion.serializer();
        r102.getClass();
        DownlinkMessage r104 = (DownlinkMessage) wt7.c.a(r100, r103);
        if (r104 != null) goto L7;
        return;
    L7:
        com.larus.im.internal.core.cmd.util.c.a(new OmniNativeHandlerBridgeProvider$messageHandlerBridge$1$handleSSECmd$1(r104, null));
        return;
    }

    @Override // hd9.o
    public final Map<String, String> interruptTypewriter(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "questionId");
        return (Map) BuildersKt.runBlocking$default(null, new OmniNativeHandlerBridgeProvider$messageHandlerBridge$1$interruptTypewriter$1(r100, r101, null), 1, null);
    }

    @Override // hd9.o
    public final boolean isIgnored(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "replyFor");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        return com.larus.im.internal.core.message.utils.f.c(r100, r101);
    }

    @Override // hd9.o
    public final boolean isMsgConvPending(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        PendingHandler r102 = PendingHandler.f350084a;
        return PendingHandler.d(r100);
    }

    @Override // hd9.o
    public final void launchChunk(String r100, MessageEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, CopyContentTypeString.TABLE);
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        wt7.c r102 = wt7.a.f561230a;
        juc.d<TokenHolder> r103 = TokenHolder.Companion.serializer();
        r102.getClass();
        TokenHolder r104 = (TokenHolder) wt7.c.a(r100, r103);
        if (r104 != null) goto L8;
        return;
    L8:
        if (v.a(r104) == false) goto L13;
        BuildersKt.runBlocking$default(null, new OmniNativeHandlerBridgeProvider$messageHandlerBridge$1$launchChunk$1(r104, r101, null), 1, null);
        return;
    }

    @Override // hd9.o
    public final void interruptOldSSE(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "questionId");
        com.larus.im.internal.database.utils.e.c(new OmniNativeHandlerBridgeProvider$messageHandlerBridge$1$interruptOldSSE$1(r101, r102, null));
    }

    @Override // hd9.o
    public final MessageEntity concatChunk(MessageEntity r100, MessageEntity r110, List<Integer> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return (MessageEntity) BuildersKt.runBlocking$default(null, new OmniNativeHandlerBridgeProvider$messageHandlerBridge$1$concatChunk$1(this, r100, r110, r111, r112, null), 1, null);
    }

    @Override // hd9.o
    public final String ftsParseMessage(String r100, String r101, int r102, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r111, "thinkingContent");
        return d0.f348204b.a(r102, r101, r110, r111, null);
    }
}
