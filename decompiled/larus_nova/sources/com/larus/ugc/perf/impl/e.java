package com.larus.ugc.perf.impl;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b5\u0018\u0000 N2\u00020\u0001:\u0001NBõ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012$\b\u0002\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0016j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0017\u0012\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0019j\b\u0012\u0004\u0012\u00020\u0003`\u001a¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001e\"\u0004\b1\u0010 R\"\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\"\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b4\u0010\"\"\u0004\b5\u0010$R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010$R\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R\u001e\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001e\"\u0004\bA\u0010 R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER6\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0016j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0019j\b\u0012\u0004\u0012\u00020\u0003`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/larus/ugc/perf/impl/MessageLruSourceData;", "", "messageId", "", DyPayConstant.KEY_START_TIME, "", "botId", "botType", "chatType", RemoteMessageConst.INPUT_TYPE, "", "isRegen", "modelId", "receiveSendAck", "messageSentEnd", "expectCount", "realCount", "messageContentType", "replyId", "message", "Lcom/larus/im/bean/message/Message;", "customMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "taskIdSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;IIILjava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/util/HashMap;Ljava/util/HashSet;)V", "getMessageId", "()Ljava/lang/String;", "setMessageId", "(Ljava/lang/String;)V", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBotId", "setBotId", "getBotType", "setBotType", "getChatType", "setChatType", "getInputType", "()Ljava/lang/Integer;", "setInputType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setRegen", "getModelId", "setModelId", "getReceiveSendAck", "setReceiveSendAck", "getMessageSentEnd", "setMessageSentEnd", "getExpectCount", "()I", "setExpectCount", "(I)V", "getRealCount", "setRealCount", "getMessageContentType", "setMessageContentType", "getReplyId", "setReplyId", "getMessage", "()Lcom/larus/im/bean/message/Message;", "setMessage", "(Lcom/larus/im/bean/message/Message;)V", "getCustomMap", "()Ljava/util/HashMap;", "setCustomMap", "(Ljava/util/HashMap;)V", "getTaskIdSet", "()Ljava/util/HashSet;", "setTaskIdSet", "(Ljava/util/HashSet;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Message f375104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient HashMap<String, Object> f375105b;

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("bot_type")
    private String botType;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient HashSet<String> f375106c;

    @SerializedName("chat_type")
    private String chatType;

    @SerializedName("expect_count")
    private int expectCount;

    @SerializedName("input_type")
    private Integer inputType;

    @SerializedName("is_regen")
    private String isRegen;

    @SerializedName("message_content_type")
    private int messageContentType;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private String messageId;

    @SerializedName("message_sent_end")
    private Long messageSentEnd;

    @SerializedName("model_id")
    private Long modelId;

    @SerializedName("real_count")
    private int realCount;

    @SerializedName("receive_sent_ack")
    private Long receiveSendAck;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private Long startTime;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null);
    }

    public final int a() {
        return this.expectCount;
    }

    public final String b() {
        return this.messageId;
    }

    public final Long c() {
        return this.receiveSendAck;
    }

    public final Long d() {
        return this.startTime;
    }

    public e(Object r100) {
        HashMap<String, Object> r101 = new HashMap();
        HashSet<String> r102 = new HashSet();
        Intrinsics.checkNotNullParameter(r101, "customMap");
        Intrinsics.checkNotNullParameter(r102, "taskIdSet");
        this.messageId = null;
        this.startTime = null;
        this.botId = null;
        this.botType = null;
        this.chatType = null;
        this.inputType = null;
        this.isRegen = null;
        this.modelId = null;
        this.receiveSendAck = null;
        this.messageSentEnd = null;
        this.expectCount = 0;
        this.realCount = 0;
        this.messageContentType = -1;
        this.f375104a = null;
        this.f375105b = r101;
        this.f375106c = r102;
    }

    public final void e(String r100) {
        this.botId = r100;
    }

    public final void f(String r100) {
        this.botType = r100;
    }

    public final void g(String r100) {
        this.chatType = r100;
    }

    public final void h(int r100) {
        this.expectCount = r100;
    }

    public final void i(Integer r100) {
        this.inputType = r100;
    }

    public final void j(int r100) {
        this.messageContentType = r100;
    }

    public final void k(String r100) {
        this.messageId = r100;
    }

    public final void l(Long r100) {
        this.messageSentEnd = r100;
    }

    public final void m(Long r100) {
        this.modelId = r100;
    }

    public final void n(Long r100) {
        this.receiveSendAck = r100;
    }

    public final void o(String r100) {
        this.isRegen = r100;
    }

    public final void p(Long r100) {
        this.startTime = r100;
    }
}
