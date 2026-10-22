package com.larus.avlink.plugins;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0082\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/plugins/DoraIsolatedEnterCallSessionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INITIAL", "INIT_ENGINE", "CREATE_HANDLE", "CREATE_CONNECTION", "UPDATE_ASR_CONFIG", "UPDATE_TTS_CONFIG", "START_TASK", "START_SESSION", "SOCKET_CONNECTED", "SOCKET_CONNECT_FAILED", "SOCKET_CONNECT_CLOSED", "TASK_STARTED", "TASK_FAILED", "SESSION_STARTED", "SESSION_FAILED", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum DoraIsolatedEnterCallSessionStatus extends Enum<DoraIsolatedEnterCallSessionStatus> {
    public static final DoraIsolatedEnterCallSessionStatus CREATE_CONNECTION = null;
    public static final DoraIsolatedEnterCallSessionStatus CREATE_HANDLE = null;
    public static final a Companion = null;
    public static final DoraIsolatedEnterCallSessionStatus INITIAL = null;
    public static final DoraIsolatedEnterCallSessionStatus INIT_ENGINE = null;
    public static final DoraIsolatedEnterCallSessionStatus SESSION_FAILED = null;
    public static final DoraIsolatedEnterCallSessionStatus SESSION_STARTED = null;
    public static final DoraIsolatedEnterCallSessionStatus SOCKET_CONNECTED = null;
    public static final DoraIsolatedEnterCallSessionStatus SOCKET_CONNECT_CLOSED = null;
    public static final DoraIsolatedEnterCallSessionStatus SOCKET_CONNECT_FAILED = null;
    public static final DoraIsolatedEnterCallSessionStatus START_SESSION = null;
    public static final DoraIsolatedEnterCallSessionStatus START_TASK = null;
    public static final DoraIsolatedEnterCallSessionStatus TASK_FAILED = null;
    public static final DoraIsolatedEnterCallSessionStatus TASK_STARTED = null;
    public static final DoraIsolatedEnterCallSessionStatus UPDATE_ASR_CONFIG = null;
    public static final DoraIsolatedEnterCallSessionStatus UPDATE_TTS_CONFIG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraIsolatedEnterCallSessionStatus[] f293708a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293709b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DoraIsolatedEnterCallSessionStatus> getEntries() {
        return f293709b;
    }

    static {
        DoraIsolatedEnterCallSessionStatus r100 = new DoraIsolatedEnterCallSessionStatus("INITIAL", 0, 0);
        INITIAL = r100;
        DoraIsolatedEnterCallSessionStatus r101 = new DoraIsolatedEnterCallSessionStatus("INIT_ENGINE", 1, 1);
        INIT_ENGINE = r101;
        DoraIsolatedEnterCallSessionStatus r102 = new DoraIsolatedEnterCallSessionStatus("CREATE_HANDLE", 2, 2);
        CREATE_HANDLE = r102;
        DoraIsolatedEnterCallSessionStatus r103 = new DoraIsolatedEnterCallSessionStatus("CREATE_CONNECTION", 3, 3);
        CREATE_CONNECTION = r103;
        DoraIsolatedEnterCallSessionStatus r104 = new DoraIsolatedEnterCallSessionStatus("UPDATE_ASR_CONFIG", 4, 4);
        UPDATE_ASR_CONFIG = r104;
        DoraIsolatedEnterCallSessionStatus r105 = new DoraIsolatedEnterCallSessionStatus("UPDATE_TTS_CONFIG", 5, 5);
        UPDATE_TTS_CONFIG = r105;
        DoraIsolatedEnterCallSessionStatus r110 = new DoraIsolatedEnterCallSessionStatus("START_TASK", 6, 6);
        START_TASK = r110;
        DoraIsolatedEnterCallSessionStatus r111 = new DoraIsolatedEnterCallSessionStatus("START_SESSION", 7, 7);
        START_SESSION = r111;
        DoraIsolatedEnterCallSessionStatus r112 = new DoraIsolatedEnterCallSessionStatus("SOCKET_CONNECTED", 8, 10);
        SOCKET_CONNECTED = r112;
        DoraIsolatedEnterCallSessionStatus r113 = new DoraIsolatedEnterCallSessionStatus("SOCKET_CONNECT_FAILED", 9, 11);
        SOCKET_CONNECT_FAILED = r113;
        DoraIsolatedEnterCallSessionStatus r114 = new DoraIsolatedEnterCallSessionStatus("SOCKET_CONNECT_CLOSED", 10, 12);
        SOCKET_CONNECT_CLOSED = r114;
        DoraIsolatedEnterCallSessionStatus r106 = new DoraIsolatedEnterCallSessionStatus("TASK_STARTED", 11, 20);
        TASK_STARTED = r106;
        DoraIsolatedEnterCallSessionStatus r107 = new DoraIsolatedEnterCallSessionStatus("TASK_FAILED", 12, 21);
        TASK_FAILED = r107;
        DoraIsolatedEnterCallSessionStatus r108 = new DoraIsolatedEnterCallSessionStatus("SESSION_STARTED", 13, 30);
        SESSION_STARTED = r108;
        DoraIsolatedEnterCallSessionStatus r109 = new DoraIsolatedEnterCallSessionStatus("SESSION_FAILED", 14, 31);
        SESSION_FAILED = r109;
        DoraIsolatedEnterCallSessionStatus[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109};
        f293708a = r115;
        f293709b = EnumEntriesKt.enumEntries(r115);
        Companion = new a();
    }

    public static DoraIsolatedEnterCallSessionStatus[] values() {
        return (DoraIsolatedEnterCallSessionStatus[]) f293708a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DoraIsolatedEnterCallSessionStatus valueOf(String r100) {
        return (DoraIsolatedEnterCallSessionStatus) r27.a.a(DoraIsolatedEnterCallSessionStatus.class, r100);
    }

    public DoraIsolatedEnterCallSessionStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
