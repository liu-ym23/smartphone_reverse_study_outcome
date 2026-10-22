package com.larus.livetutor.impl.rtc.handler;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.larus.livetutor.impl.rtc.TutorRTCServiceImpl;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class RTCMonitor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f356316f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TutorRTCServiceImpl f356317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f356318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PthreadTimer f356319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f356320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super JSONObject, Unit> f356321e;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/livetutor/impl/rtc/handler/RTCMonitor$Companion$BusinessErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RTC_START_CALL_ERROR", "RTC_SERVER_ERROR_OVERTIME", "RTC_SERVER_ERROR_LEAVE", "RTC_JOIN_ROOM_ERROR", "RTC_USER_ERROR", "RTC_SIGNAL_CALL_START_ERROR", "RTC_SIGNAL_MSG_ERROR", "RTC_SIGNAL_CLIENT_SEND_ERROR", "RTC_OTHER_ERROR", "RTC_START_CALL_REQUEST_TIMEOUT", "RTC_USER_JOIN_TIMEOUT", "RTC_SERVER_CALLSTART_SIGNAL_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum BusinessErrorType extends Enum<BusinessErrorType> {
            public static final BusinessErrorType RTC_JOIN_ROOM_ERROR = null;
            public static final BusinessErrorType RTC_OTHER_ERROR = null;
            public static final BusinessErrorType RTC_SERVER_CALLSTART_SIGNAL_TIMEOUT = null;
            public static final BusinessErrorType RTC_SERVER_ERROR_LEAVE = null;
            public static final BusinessErrorType RTC_SERVER_ERROR_OVERTIME = null;
            public static final BusinessErrorType RTC_SIGNAL_CALL_START_ERROR = null;
            public static final BusinessErrorType RTC_SIGNAL_CLIENT_SEND_ERROR = null;
            public static final BusinessErrorType RTC_SIGNAL_MSG_ERROR = null;
            public static final BusinessErrorType RTC_START_CALL_ERROR = null;
            public static final BusinessErrorType RTC_START_CALL_REQUEST_TIMEOUT = null;
            public static final BusinessErrorType RTC_USER_ERROR = null;
            public static final BusinessErrorType RTC_USER_JOIN_TIMEOUT = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ BusinessErrorType[] f356322a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f356323b = null;
            private final String value;

            public static EnumEntries<BusinessErrorType> getEntries() {
                return f356323b;
            }

            static {
                BusinessErrorType r100 = new BusinessErrorType("RTC_START_CALL_ERROR", 0, "rtc_startcall_error");
                RTC_START_CALL_ERROR = r100;
                BusinessErrorType r101 = new BusinessErrorType("RTC_SERVER_ERROR_OVERTIME", 1, "rtc_server_error_overtime");
                RTC_SERVER_ERROR_OVERTIME = r101;
                BusinessErrorType r102 = new BusinessErrorType("RTC_SERVER_ERROR_LEAVE", 2, "rtc_server_error_leave");
                RTC_SERVER_ERROR_LEAVE = r102;
                BusinessErrorType r103 = new BusinessErrorType("RTC_JOIN_ROOM_ERROR", 3, "rtc_join_room_error");
                RTC_JOIN_ROOM_ERROR = r103;
                BusinessErrorType r104 = new BusinessErrorType("RTC_USER_ERROR", 4, "rtc_user_error");
                RTC_USER_ERROR = r104;
                BusinessErrorType r105 = new BusinessErrorType("RTC_SIGNAL_CALL_START_ERROR", 5, "rtc_signal_callstart_error");
                RTC_SIGNAL_CALL_START_ERROR = r105;
                BusinessErrorType r110 = new BusinessErrorType("RTC_SIGNAL_MSG_ERROR", 6, "rtc_signal_msg_error");
                RTC_SIGNAL_MSG_ERROR = r110;
                BusinessErrorType r111 = new BusinessErrorType("RTC_SIGNAL_CLIENT_SEND_ERROR", 7, "rtc_signal_client_send_error");
                RTC_SIGNAL_CLIENT_SEND_ERROR = r111;
                BusinessErrorType r112 = new BusinessErrorType("RTC_OTHER_ERROR", 8, "rtc_other_error");
                RTC_OTHER_ERROR = r112;
                BusinessErrorType r113 = new BusinessErrorType("RTC_START_CALL_REQUEST_TIMEOUT", 9, "rtc_startcall_request_timeout");
                RTC_START_CALL_REQUEST_TIMEOUT = r113;
                BusinessErrorType r114 = new BusinessErrorType("RTC_USER_JOIN_TIMEOUT", 10, "rtc_user_join_timeout");
                RTC_USER_JOIN_TIMEOUT = r114;
                BusinessErrorType r106 = new BusinessErrorType("RTC_SERVER_CALLSTART_SIGNAL_TIMEOUT", 11, "rtc_server_callstart_signal_timeout");
                RTC_SERVER_CALLSTART_SIGNAL_TIMEOUT = r106;
                BusinessErrorType[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
                f356322a = r107;
                f356323b = EnumEntriesKt.enumEntries(r107);
            }

            public static BusinessErrorType[] values() {
                return (BusinessErrorType[]) f356322a.clone();
            }

            public final String getValue() {
                return this.value;
            }

            public static BusinessErrorType valueOf(String r100) {
                return (BusinessErrorType) r27.a.a(BusinessErrorType.class, r100);
            }

            public BusinessErrorType(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/livetutor/impl/rtc/handler/RTCMonitor$Companion$ErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "CREATE_ENGINE_FAIL", "SERVER_ERROR", "CALL_TIME_OUT", "RTC_DISCONNECT", "RTC_JOIN_ROOM_ERROR", "REALTIME_START_API_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ErrorType extends Enum<ErrorType> {
            public static final ErrorType CALL_TIME_OUT = null;
            public static final ErrorType CREATE_ENGINE_FAIL = null;
            public static final ErrorType REALTIME_START_API_ERROR = null;
            public static final ErrorType RTC_DISCONNECT = null;
            public static final ErrorType RTC_JOIN_ROOM_ERROR = null;
            public static final ErrorType SERVER_ERROR = null;
            public static final ErrorType UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ErrorType[] f356324a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f356325b = null;
            private final String value;

            public static EnumEntries<ErrorType> getEntries() {
                return f356325b;
            }

            static {
                ErrorType r100 = new ErrorType("UNKNOWN", 0, "unknown");
                UNKNOWN = r100;
                ErrorType r101 = new ErrorType("CREATE_ENGINE_FAIL", 1, "create_engine_fail");
                CREATE_ENGINE_FAIL = r101;
                ErrorType r102 = new ErrorType("SERVER_ERROR", 2, "server_error");
                SERVER_ERROR = r102;
                ErrorType r103 = new ErrorType("CALL_TIME_OUT", 3, "call_time_out");
                CALL_TIME_OUT = r103;
                ErrorType r104 = new ErrorType("RTC_DISCONNECT", 4, "rtc_disconnect");
                RTC_DISCONNECT = r104;
                ErrorType r105 = new ErrorType("RTC_JOIN_ROOM_ERROR", 5, "rtc_join_room_error");
                RTC_JOIN_ROOM_ERROR = r105;
                ErrorType r110 = new ErrorType("REALTIME_START_API_ERROR", 6, "realtime_start_api_error");
                REALTIME_START_API_ERROR = r110;
                ErrorType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
                f356324a = r111;
                f356325b = EnumEntriesKt.enumEntries(r111);
            }

            public static ErrorType[] values() {
                return (ErrorType[]) f356324a.clone();
            }

            public final String getValue() {
                return this.value;
            }

            public static ErrorType valueOf(String r100) {
                return (ErrorType) r27.a.a(ErrorType.class, r100);
            }

            public ErrorType(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = r102;
            }
        }
    }

    static {
    }

    public final void c() {
        Long r100 = this.f356318b;
        if (r100 == null) goto L9;
        r100.longValue();
        JSONObject r101 = new JSONObject();
        a(r101);
        r101.put("duration", this.f356320d / ((long) 1000));
        Function1<? super JSONObject, Unit> r102 = this.f356321e;
        if (r102 == null) goto L7;
        r102.invoke(r101);
    L7:
        com.larus.platform.service.o.f365780a.reportEvent("rtc_room_duration", r101);
        return;
    }

    public RTCMonitor(TutorRTCServiceImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcService");
        this.f356317a = r100;
        this.f356320d = com.larus.settings.tutor.d.a().getRtcHeartRateIntervalMs();
    }

    public final void a(JSONObject r100) {
        r100.put(DyVerifyEventConstants.EventParam.BIZ_SCENE, this.f356317a.f356259x);
        r100.put("rtc_call_id", this.f356317a.f356258w);
        r100.put("rtc_bot_id", this.f356317a.f356255t);
        r100.put("rtc_room_id", this.f356317a.f356256u);
    }

    public final void b(boolean r100, Companion.ErrorType r101, String r102) {
        JSONObject r103 = new JSONObject();
        a(r103);
        r103.put("finish_reason", !r100 ? 1 : 0);
        if (r101 == null) goto L5;
        String r104 = r101.getValue();
    L6:
        r103.put("error_type", r104);
        r103.put("error_msg", r102);
        com.larus.platform.service.o.f365780a.reportEvent("tutor_rtc_finish", r103);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
