package hd9;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.trace.CopyContentTypeString;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f484622a = null;

    static {
        f484622a = new e();
    }

    public e() {
    }

    @Override // hd9.o
    public final void clearAllServerLoading(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
    }

    @Override // hd9.o
    public final MessageEntity concatChunk(MessageEntity r100, MessageEntity r101, List<Integer> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return r100;
    }

    @Override // hd9.o
    public final String ftsParseMessage(String r100, String r101, int r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r104, "thinkingContent");
        return r103;
    }

    @Override // hd9.o
    public final void handleDeprecatedCmd(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
    }

    @Override // hd9.o
    public final void handleSSECmd(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "cmd");
    }

    @Override // hd9.o
    public final void ignoreQuestion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "questionId");
    }

    @Override // hd9.o
    public final void interruptOldSSE(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "questionId");
    }

    @Override // hd9.o
    public final boolean isIgnored(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "replyFor");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        return false;
    }

    @Override // hd9.o
    public final boolean isMsgConvPending(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        return false;
    }

    @Override // hd9.o
    public final boolean isMsgPended(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        return false;
    }

    @Override // hd9.o
    public final void launchChunk(String r100, MessageEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, CopyContentTypeString.TABLE);
    }

    @Override // hd9.o
    public final void resumeChunk() {
    }

    @Override // hd9.o
    public final List<String> getAllServerLoadingLocalMessageIds(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return CollectionsKt.emptyList();
    }

    @Override // hd9.o
    public final Map<String, String> interruptTypewriter(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "questionId");
        return MapsKt.emptyMap();
    }
}
