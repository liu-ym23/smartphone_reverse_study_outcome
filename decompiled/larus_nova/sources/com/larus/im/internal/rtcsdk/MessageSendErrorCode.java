package com.larus.im.internal.rtcsdk;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.bytertc.engine.aigc.AIGCSessionErrorCode;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/im/internal/rtcsdk/MessageSendErrorCode;", "", "code", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDesc", "()Ljava/lang/String;", "UNKNOWN", "MESSAGE_BUILD_FAILED", "EMPTY_MESSAGE", "ENGINE_NOT_INITIALIZED", "CONNECTION_NOT_READY", "NOT_LOGIN_BY_RTS", "UNSUPPORTED_MESSAGE_TYPE", "CLIENT_NOT_READY", "SESSION_DESTROYED", "SERIALIZATION_FAILED", "RTC_SERVICE_NOT_READY", "PSEUDO_CONNECTED", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageSendErrorCode extends Enum<MessageSendErrorCode> {
    public static final MessageSendErrorCode CLIENT_NOT_READY = null;
    public static final MessageSendErrorCode CONNECTION_NOT_READY = null;
    public static final MessageSendErrorCode EMPTY_MESSAGE = null;
    public static final MessageSendErrorCode ENGINE_NOT_INITIALIZED = null;
    public static final MessageSendErrorCode MESSAGE_BUILD_FAILED = null;
    public static final MessageSendErrorCode NOT_LOGIN_BY_RTS = null;
    public static final MessageSendErrorCode PSEUDO_CONNECTED = null;
    public static final MessageSendErrorCode RTC_SERVICE_NOT_READY = null;
    public static final MessageSendErrorCode SERIALIZATION_FAILED = null;
    public static final MessageSendErrorCode SESSION_DESTROYED = null;
    public static final MessageSendErrorCode UNKNOWN = null;
    public static final MessageSendErrorCode UNSUPPORTED_MESSAGE_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageSendErrorCode[] f349820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349821b = null;
    private final int code;
    private final String desc;

    public static EnumEntries<MessageSendErrorCode> getEntries() {
        return f349821b;
    }

    static {
        MessageSendErrorCode r100 = new MessageSendErrorCode("UNKNOWN", 0, -1000, "Unknown error");
        UNKNOWN = r100;
        MessageSendErrorCode r101 = new MessageSendErrorCode("MESSAGE_BUILD_FAILED", 1, -1100, "Failed to build valid message");
        MESSAGE_BUILD_FAILED = r101;
        MessageSendErrorCode r102 = new MessageSendErrorCode("EMPTY_MESSAGE", 2, SpeechEngineDefines.ERR_AUTHENTICATION_FAILED, "Message is empty");
        EMPTY_MESSAGE = r102;
        MessageSendErrorCode r103 = new MessageSendErrorCode("ENGINE_NOT_INITIALIZED", 3, -1200, "RTC engine not initialized");
        ENGINE_NOT_INITIALIZED = r103;
        MessageSendErrorCode r104 = new MessageSendErrorCode("CONNECTION_NOT_READY", 4, AIGCSessionErrorCode.AIGC_SESSION_ERROR_TIMEOUT_NO_BOT_JOIN_ROOM, "Connection not ready");
        CONNECTION_NOT_READY = r104;
        MessageSendErrorCode r105 = new MessageSendErrorCode("NOT_LOGIN_BY_RTS", 5, -1202, "Connection not ready");
        NOT_LOGIN_BY_RTS = r105;
        MessageSendErrorCode r110 = new MessageSendErrorCode("UNSUPPORTED_MESSAGE_TYPE", 6, -1300, "Unsupported message type");
        UNSUPPORTED_MESSAGE_TYPE = r110;
        MessageSendErrorCode r111 = new MessageSendErrorCode("CLIENT_NOT_READY", 7, -1400, "Client not ready");
        CLIENT_NOT_READY = r111;
        MessageSendErrorCode r112 = new MessageSendErrorCode("SESSION_DESTROYED", 8, -1401, "Session already destroyed");
        SESSION_DESTROYED = r112;
        MessageSendErrorCode r106 = new MessageSendErrorCode("SERIALIZATION_FAILED", 9, -1500, "Message serialization failed");
        SERIALIZATION_FAILED = r106;
        MessageSendErrorCode r113 = new MessageSendErrorCode("RTC_SERVICE_NOT_READY", 10, -1600, "RTC service not ready");
        RTC_SERVICE_NOT_READY = r113;
        MessageSendErrorCode r107 = new MessageSendErrorCode("PSEUDO_CONNECTED", 11, -1700, "Pseudo connected");
        PSEUDO_CONNECTED = r107;
        MessageSendErrorCode[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r106, r113, r107};
        f349820a = r108;
        f349821b = EnumEntriesKt.enumEntries(r108);
    }

    public static MessageSendErrorCode[] values() {
        return (MessageSendErrorCode[]) f349820a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDesc() {
        return this.desc;
    }

    public static MessageSendErrorCode valueOf(String r100) {
        return (MessageSendErrorCode) a.a(MessageSendErrorCode.class, r100);
    }

    public MessageSendErrorCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.desc = r103;
    }
}
