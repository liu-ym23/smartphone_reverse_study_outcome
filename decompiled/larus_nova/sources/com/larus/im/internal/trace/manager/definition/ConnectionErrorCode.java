package com.larus.im.internal.trace.manager.definition;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/trace/manager/definition/ConnectionErrorCode;", "", "code", "", "msg", "", "<init>", "(Ljava/lang/String;IJLjava/lang/String;)V", "getCode", "()J", "getMsg", "()Ljava/lang/String;", "GET_ROOM_ID_ERROR", "JOIN_ROOM_ERROR", "USER_LEAVE_ERROR", "SIGNAL_ERROR", "RTC_ABNORMAL", "TIMEOUT", AccountType.OTHERS, "OApp.flowSDK.baseSDK.common.avsdk-flow-impl"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConnectionErrorCode extends Enum<ConnectionErrorCode> {
    public static final ConnectionErrorCode GET_ROOM_ID_ERROR = null;
    public static final ConnectionErrorCode JOIN_ROOM_ERROR = null;
    public static final ConnectionErrorCode OTHERS = null;
    public static final ConnectionErrorCode RTC_ABNORMAL = null;
    public static final ConnectionErrorCode SIGNAL_ERROR = null;
    public static final ConnectionErrorCode TIMEOUT = null;
    public static final ConnectionErrorCode USER_LEAVE_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConnectionErrorCode[] f350157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350158b = null;
    private final long code;
    private final String msg;

    public static EnumEntries<ConnectionErrorCode> getEntries() {
        return f350158b;
    }

    static {
        ConnectionErrorCode r100 = new ConnectionErrorCode("GET_ROOM_ID_ERROR", 0, -1000000, "get room id failed.");
        GET_ROOM_ID_ERROR = r100;
        ConnectionErrorCode r101 = new ConnectionErrorCode("JOIN_ROOM_ERROR", 1, -1001000, "user join room failed.");
        JOIN_ROOM_ERROR = r101;
        ConnectionErrorCode r102 = new ConnectionErrorCode("USER_LEAVE_ERROR", 2, -1002000, "user leave room.");
        USER_LEAVE_ERROR = r102;
        ConnectionErrorCode r103 = new ConnectionErrorCode("SIGNAL_ERROR", 3, -1006000, "send signal failed.");
        SIGNAL_ERROR = r103;
        ConnectionErrorCode r104 = new ConnectionErrorCode("RTC_ABNORMAL", 4, -1007000, "rtc component abnormal.");
        RTC_ABNORMAL = r104;
        ConnectionErrorCode r105 = new ConnectionErrorCode("TIMEOUT", 5, -1008000, "rtc component abnormal.");
        TIMEOUT = r105;
        ConnectionErrorCode r106 = new ConnectionErrorCode(AccountType.OTHERS, 6, -1009000, "others.");
        OTHERS = r106;
        ConnectionErrorCode[] r107 = {r100, r101, r102, r103, r104, r105, r106};
        f350157a = r107;
        f350158b = EnumEntriesKt.enumEntries(r107);
    }

    public static ConnectionErrorCode[] values() {
        return (ConnectionErrorCode[]) f350157a.clone();
    }

    public final long getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public static ConnectionErrorCode valueOf(String r100) {
        return (ConnectionErrorCode) a.a(ConnectionErrorCode.class, r100);
    }

    public ConnectionErrorCode(String r100, int r101, long r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
    }
}
