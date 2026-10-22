package com.larus.im.internal.jni.adapter;

import com.alipay.sdk.m.p.e;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.delegate.h1;
import com.larus.trace.CopyContentTypeString;
import hd9.o;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J3\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J1\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0096\u0001J\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000eH\u0096\u0001J \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0096\u0001¢\u0006\u0002\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0007H\u0096\u0001J!\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0096\u0001J%\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\tH\u0096\u0001J\t\u0010-\u001a\u00020\u0005H\u0096\u0001¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/adapter/NativeMessageHandlerAdapter;", "Lcom/larus/im/dependency/IOmniMessageHandlerBridge;", "<init>", "()V", "clearAllServerLoading", "", "conversationId", "", "concatChunk", "Lcom/larus/im/internal/database/entity/MessageEntity;", "message", "localMessage", "appendFields", "", "", "useCache", "", "ftsParseMessage", e.f25671s, "messageId", "type", "content", "thinkingContent", "getAllServerLoadingLocalMessageIds", "handleDeprecatedCmd", "cmd", "from", "handleSSECmd", "isPushEvent", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "ignoreQuestion", "questionId", "interruptOldSSE", "interruptTypewriter", "", "cvsId", "isIgnored", "replyFor", "chatId", "isMsgConvPending", RemoteMessageConst.MSGID, "isMsgPended", "launchChunk", "token", CopyContentTypeString.TABLE, "resumeChunk", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeMessageHandlerAdapter implements o {
    private final /* synthetic */ o $$delegate_0;

    @Override // hd9.o
    public void clearAllServerLoading(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.$$delegate_0.clearAllServerLoading(r100);
    }

    @Override // hd9.o
    public MessageEntity concatChunk(MessageEntity r100, MessageEntity r101, List<Integer> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return this.$$delegate_0.concatChunk(r100, r101, r102, r103);
    }

    @Override // hd9.o
    public String ftsParseMessage(String r100, String r101, int r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r112, "thinkingContent");
        return this.$$delegate_0.ftsParseMessage(r100, r101, r110, r111, r112);
    }

    @Override // hd9.o
    public List<String> getAllServerLoadingLocalMessageIds(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return this.$$delegate_0.getAllServerLoadingLocalMessageIds(r100);
    }

    @Override // hd9.o
    public void handleDeprecatedCmd(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
        this.$$delegate_0.handleDeprecatedCmd(r100, r101);
    }

    @Override // hd9.o
    public void handleSSECmd(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
        this.$$delegate_0.handleSSECmd(r100, r101);
    }

    @Override // hd9.o
    public void ignoreQuestion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "questionId");
        this.$$delegate_0.ignoreQuestion(r100);
    }

    @Override // hd9.o
    public void interruptOldSSE(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "questionId");
        this.$$delegate_0.interruptOldSSE(r100, r101, r102);
    }

    @Override // hd9.o
    public Map<String, String> interruptTypewriter(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "questionId");
        return this.$$delegate_0.interruptTypewriter(r100, r101);
    }

    @Override // hd9.o
    public boolean isIgnored(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "replyFor");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        return this.$$delegate_0.isIgnored(r100, r101);
    }

    @Override // hd9.o
    public boolean isMsgConvPending(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        return this.$$delegate_0.isMsgConvPending(r100, r101);
    }

    @Override // hd9.o
    public boolean isMsgPended(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        return this.$$delegate_0.isMsgPended(r100);
    }

    @Override // hd9.o
    public void launchChunk(String r100, MessageEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, CopyContentTypeString.TABLE);
        this.$$delegate_0.launchChunk(r100, r101);
    }

    @Override // hd9.o
    public void resumeChunk() {
        this.$$delegate_0.resumeChunk();
    }

    public NativeMessageHandlerAdapter() {
        this.$$delegate_0 = h1.f348237b.b();
    }
}
