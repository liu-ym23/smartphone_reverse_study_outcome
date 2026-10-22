package com.larus.audio.call.tracer;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ouc.d0;

/* JADX INFO: loaded from: classes24.dex */
public interface IRealtimeCallTracer extends c {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/audio/call/tracer/IRealtimeCallTracer$EnterCallSessionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INITIAL", "INIT_ENGINE", "CREATE_HANDLE", "CREATE_CONNECTION", "UPDATE_ASR_CONFIG", "UPDATE_TTS_CONFIG", "START_TASK", "START_SESSION", "SOCKET_CONNECTED", "SOCKET_CONNECT_FAILED", "SOCKET_CONNECT_CLOSED", "TASK_STARTED", "TASK_FAILED", "SESSION_STARTED", "SESSION_FAILED", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EnterCallSessionStatus extends Enum<EnterCallSessionStatus> {
        public static final EnterCallSessionStatus CREATE_CONNECTION = null;
        public static final EnterCallSessionStatus CREATE_HANDLE = null;
        public static final a Companion = null;
        public static final EnterCallSessionStatus INITIAL = null;
        public static final EnterCallSessionStatus INIT_ENGINE = null;
        public static final EnterCallSessionStatus SESSION_FAILED = null;
        public static final EnterCallSessionStatus SESSION_STARTED = null;
        public static final EnterCallSessionStatus SOCKET_CONNECTED = null;
        public static final EnterCallSessionStatus SOCKET_CONNECT_CLOSED = null;
        public static final EnterCallSessionStatus SOCKET_CONNECT_FAILED = null;
        public static final EnterCallSessionStatus START_SESSION = null;
        public static final EnterCallSessionStatus START_TASK = null;
        public static final EnterCallSessionStatus TASK_FAILED = null;
        public static final EnterCallSessionStatus TASK_STARTED = null;
        public static final EnterCallSessionStatus UPDATE_ASR_CONFIG = null;
        public static final EnterCallSessionStatus UPDATE_TTS_CONFIG = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnterCallSessionStatus[] f289628a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f289629b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static EnterCallSessionStatus a(int r100) {
                if (r100 == 20) goto L28;
                if (r100 == 21) goto L43;
                if (r100 == 30) goto L42;
                if (r100 == 31) goto L41;
                switch(r100) {
                    case 0: goto L37;
                    case 1: goto L36;
                    case 2: goto L35;
                    case 3: goto L34;
                    case 4: goto L33;
                    case 5: goto L32;
                    case 6: goto L31;
                    case 7: goto L30;
                    default: goto L11;
                };
            L11:
                switch(r100) {
                    case 10: goto L40;
                    case 11: goto L39;
                    case 12: goto L38;
                    default: goto L12;
                };
            L12:
                return null;
            L38:
                return EnterCallSessionStatus.SOCKET_CONNECT_CLOSED;
            L39:
                return EnterCallSessionStatus.SOCKET_CONNECT_FAILED;
            L40:
                return EnterCallSessionStatus.SOCKET_CONNECTED;
            L30:
                return EnterCallSessionStatus.START_SESSION;
            L31:
                return EnterCallSessionStatus.START_TASK;
            L32:
                return EnterCallSessionStatus.UPDATE_TTS_CONFIG;
            L33:
                return EnterCallSessionStatus.UPDATE_ASR_CONFIG;
            L34:
                return EnterCallSessionStatus.CREATE_CONNECTION;
            L35:
                return EnterCallSessionStatus.CREATE_HANDLE;
            L36:
                return EnterCallSessionStatus.INIT_ENGINE;
            L37:
                return EnterCallSessionStatus.INITIAL;
            L41:
                return EnterCallSessionStatus.SESSION_FAILED;
            L42:
                return EnterCallSessionStatus.SESSION_STARTED;
            L43:
                return EnterCallSessionStatus.TASK_FAILED;
            L28:
                return EnterCallSessionStatus.TASK_STARTED;
            }
        }

        public static EnumEntries<EnterCallSessionStatus> getEntries() {
            return f289629b;
        }

        static {
            EnterCallSessionStatus r100 = new EnterCallSessionStatus("INITIAL", 0, 0);
            INITIAL = r100;
            EnterCallSessionStatus r101 = new EnterCallSessionStatus("INIT_ENGINE", 1, 1);
            INIT_ENGINE = r101;
            EnterCallSessionStatus r102 = new EnterCallSessionStatus("CREATE_HANDLE", 2, 2);
            CREATE_HANDLE = r102;
            EnterCallSessionStatus r103 = new EnterCallSessionStatus("CREATE_CONNECTION", 3, 3);
            CREATE_CONNECTION = r103;
            EnterCallSessionStatus r104 = new EnterCallSessionStatus("UPDATE_ASR_CONFIG", 4, 4);
            UPDATE_ASR_CONFIG = r104;
            EnterCallSessionStatus r105 = new EnterCallSessionStatus("UPDATE_TTS_CONFIG", 5, 5);
            UPDATE_TTS_CONFIG = r105;
            EnterCallSessionStatus r110 = new EnterCallSessionStatus("START_TASK", 6, 6);
            START_TASK = r110;
            EnterCallSessionStatus r111 = new EnterCallSessionStatus("START_SESSION", 7, 7);
            START_SESSION = r111;
            EnterCallSessionStatus r112 = new EnterCallSessionStatus("SOCKET_CONNECTED", 8, 10);
            SOCKET_CONNECTED = r112;
            EnterCallSessionStatus r113 = new EnterCallSessionStatus("SOCKET_CONNECT_FAILED", 9, 11);
            SOCKET_CONNECT_FAILED = r113;
            EnterCallSessionStatus r114 = new EnterCallSessionStatus("SOCKET_CONNECT_CLOSED", 10, 12);
            SOCKET_CONNECT_CLOSED = r114;
            EnterCallSessionStatus r106 = new EnterCallSessionStatus("TASK_STARTED", 11, 20);
            TASK_STARTED = r106;
            EnterCallSessionStatus r107 = new EnterCallSessionStatus("TASK_FAILED", 12, 21);
            TASK_FAILED = r107;
            EnterCallSessionStatus r108 = new EnterCallSessionStatus("SESSION_STARTED", 13, 30);
            SESSION_STARTED = r108;
            EnterCallSessionStatus r109 = new EnterCallSessionStatus("SESSION_FAILED", 14, 31);
            SESSION_FAILED = r109;
            EnterCallSessionStatus[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109};
            f289628a = r115;
            f289629b = EnumEntriesKt.enumEntries(r115);
            Companion = new a();
        }

        public static EnterCallSessionStatus[] values() {
            return (EnterCallSessionStatus[]) f289628a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static EnterCallSessionStatus valueOf(String r100) {
            return (EnterCallSessionStatus) r27.a.a(EnterCallSessionStatus.class, r100);
        }

        public EnterCallSessionStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/tracer/IRealtimeCallTracer$HelloStatus;", "", "<init>", "(Ljava/lang/String;I)V", "START_SESSION", "SESSION_SUCCESS", "TRIGGER_HELLO", "PLAY_HELLO", "INTERRUPT", "PLAY_END", "HELLO_RESET", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HelloStatus extends Enum<HelloStatus> {
        public static final HelloStatus HELLO_RESET = null;
        public static final HelloStatus INTERRUPT = null;
        public static final HelloStatus PLAY_END = null;
        public static final HelloStatus PLAY_HELLO = null;
        public static final HelloStatus SESSION_SUCCESS = null;
        public static final HelloStatus START_SESSION = null;
        public static final HelloStatus TRIGGER_HELLO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HelloStatus[] f289630a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f289631b = null;

        public static EnumEntries<HelloStatus> getEntries() {
            return f289631b;
        }

        static {
            HelloStatus r100 = new HelloStatus("START_SESSION", 0);
            START_SESSION = r100;
            HelloStatus r101 = new HelloStatus("SESSION_SUCCESS", 1);
            SESSION_SUCCESS = r101;
            HelloStatus r102 = new HelloStatus("TRIGGER_HELLO", 2);
            TRIGGER_HELLO = r102;
            HelloStatus r103 = new HelloStatus("PLAY_HELLO", 3);
            PLAY_HELLO = r103;
            HelloStatus r104 = new HelloStatus("INTERRUPT", 4);
            INTERRUPT = r104;
            HelloStatus r105 = new HelloStatus("PLAY_END", 5);
            PLAY_END = r105;
            HelloStatus r110 = new HelloStatus("HELLO_RESET", 6);
            HELLO_RESET = r110;
            HelloStatus[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f289630a = r111;
            f289631b = EnumEntriesKt.enumEntries(r111);
        }

        public static HelloStatus[] values() {
            return (HelloStatus[]) f289630a.clone();
        }

        public static HelloStatus valueOf(String r100) {
            return (HelloStatus) r27.a.a(HelloStatus.class, r100);
        }

        public HelloStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/tracer/IRealtimeCallTracer$TotalTimeType;", "", "<init>", "(Ljava/lang/String;I)V", "SCREEN_SHARE_START_TIME", "SCREEN_SHARE_IN_APP", "VIDEO_SHARE_START_TIME", "SUBTITLE", "PAUSE", "USER_SPEAK", "MUTE", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TotalTimeType extends Enum<TotalTimeType> {
        public static final TotalTimeType MUTE = null;
        public static final TotalTimeType PAUSE = null;
        public static final TotalTimeType SCREEN_SHARE_IN_APP = null;
        public static final TotalTimeType SCREEN_SHARE_START_TIME = null;
        public static final TotalTimeType SUBTITLE = null;
        public static final TotalTimeType USER_SPEAK = null;
        public static final TotalTimeType VIDEO_SHARE_START_TIME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TotalTimeType[] f289632a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f289633b = null;

        public static EnumEntries<TotalTimeType> getEntries() {
            return f289633b;
        }

        static {
            TotalTimeType r100 = new TotalTimeType("SCREEN_SHARE_START_TIME", 0);
            SCREEN_SHARE_START_TIME = r100;
            TotalTimeType r101 = new TotalTimeType("SCREEN_SHARE_IN_APP", 1);
            SCREEN_SHARE_IN_APP = r101;
            TotalTimeType r102 = new TotalTimeType("VIDEO_SHARE_START_TIME", 2);
            VIDEO_SHARE_START_TIME = r102;
            TotalTimeType r103 = new TotalTimeType("SUBTITLE", 3);
            SUBTITLE = r103;
            TotalTimeType r104 = new TotalTimeType("PAUSE", 4);
            PAUSE = r104;
            TotalTimeType r105 = new TotalTimeType("USER_SPEAK", 5);
            USER_SPEAK = r105;
            TotalTimeType r110 = new TotalTimeType("MUTE", 6);
            MUTE = r110;
            TotalTimeType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f289632a = r111;
            f289633b = EnumEntriesKt.enumEntries(r111);
        }

        public static TotalTimeType[] values() {
            return (TotalTimeType[]) f289632a.clone();
        }

        public static TotalTimeType valueOf(String r100) {
            return (TotalTimeType) r27.a.a(TotalTimeType.class, r100);
        }

        public TotalTimeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IRealtimeCallTracer r100, long r101, long r110) {
            r100.h0(r101, r110, null, null);
        }
    }

    void A(RealtimeCallParam r100, String r101, String r102, String r103);

    void B(TotalTimeType r100, boolean r101);

    void C(RealtimeCallParam r100);

    void D(boolean r100);

    void E();

    void F(boolean r100);

    void G(boolean r100);

    void H(String r100, String r101);

    void I();

    void J(int r100, String r101, int r102);

    void K(Map<String, ? extends Object> r100);

    void L(RealtimeCallParam r100, int r101, String r102, String r103, Long r104, Long r105, String r106);

    void M(String r100, String r101, String r102, Long r103, String r104);

    void O(String r100, RealtimeCallParam r101);

    void P(RealtimeCallParam r100, Long r101, String r102, String r103, String r104);

    void Q(HelloStatus r100, String r101);

    boolean R();

    void S();

    void T(String r100, String r101);

    void U(int r100, String r101, long r102, RealtimeCallParam r103, Boolean r104, int r105, String r106, String r107);

    void W();

    void Z(RealtimeCallParam r100, int r101);

    void a0(Flow<Integer> r100, CoroutineScope r101, RealtimeCallParam r102);

    void b0(RealtimeCallParam r100);

    void c();

    void c0(long r100);

    void d(h.a r100);

    void d0(RealtimeCallParam r100, int r101, long r102, long r103, boolean r104, String r105, String r106, String r110, Long r111, Long r112, String r113);

    void e(String r100, String r101, String r102, String r103);

    void e0(String r100, String r101, RealtimeCallParam r102, e3a.a r103);

    void f(RealtimeCallParam r100, String r101, boolean r102, EnterCallSessionStatus r103, Integer r104, long r105, boolean r106);

    void f0(boolean r100);

    void g();

    void g0(String r100, String r101, String r102, String r103);

    void h(jd9.c r100);

    void h0(long r100, long r101, String r102, String r103);

    void i(byte[] r100);

    void i0();

    void j(RealtimeCallParam r100, boolean r101, EnterCallSessionStatus r102, long r103, long r104, boolean r105);

    void j0(boolean r100);

    void k(long r100);

    void k0(String r100, RealtimeCallParam r101, boolean r102, e3a.a r103);

    void l(String r100, String r101, String r102, String r103, String r104);

    void l0(RealtimeCallParam r100, String r101);

    void m(RealtimeCallParam r100, boolean r101);

    void m0(String r100);

    void n(RealtimeCallParam r100, String r101);

    void n0();

    void o(String r100, long r101, boolean r102, boolean r103, boolean r104, long r105, long r106, String r110, String r111);

    void o0();

    void p(String r100);

    void p0(RealtimeCallParam r100, EnterCallSessionStatus r101, String r102, int r103, String r104, Boolean r105);

    void q(boolean r100, long r101);

    void r();

    void r0(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107);

    void reportEvent(String r100, Map<String, Object> r101);

    void s(String r100);

    void s0();

    void t();

    void t0();

    void u0();

    void v(boolean r100);

    void w(RealtimeCallParam r100, int r101, boolean r102, String r103, String r104, long r105, String r106);

    d0 x(d0 r100);

    void y(String r100, RealtimeCallParam r101, d0 r102);

    void z(String r100, String r101, String r102, String r103);
}
