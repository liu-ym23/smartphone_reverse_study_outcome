package com.ss.android.lark.officesdk.minutes.service.recording.common.core.data;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/TerminateReason;", "", "<init>", "(Ljava/lang/String;I)V", "MEETING_ID_EMPTY", "MINUTES_TOKEN_EMPTY", "RTC_INIT_FAILED", "DIR_CREATE_FAILED", "ALREADY_RECORDING", "MEETING_CREATED_FAILED", "UPLOAD_COMPLETED", "NON_RECORDING_TYPE", "REACH_MAX_DURATION", "UPLOAD_COMPLETED_SERVER", "OBJECT_DELETED", "NOT_LOGGED_IN", "UNAUTHORIZED", "TENANT_KEY_DELETED", "SAVE_ARTIFACT_DISABLED", "HARDWARE_DISCONNECTED", "PRIORITY_REPLACED", "HARDWARE_STOPPED", AccountType.OTHERS, "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TerminateReason extends Enum<TerminateReason> {
    public static final TerminateReason ALREADY_RECORDING = null;
    public static final TerminateReason DIR_CREATE_FAILED = null;
    public static final TerminateReason HARDWARE_DISCONNECTED = null;
    public static final TerminateReason HARDWARE_STOPPED = null;
    public static final TerminateReason MEETING_CREATED_FAILED = null;
    public static final TerminateReason MEETING_ID_EMPTY = null;
    public static final TerminateReason MINUTES_TOKEN_EMPTY = null;
    public static final TerminateReason NON_RECORDING_TYPE = null;
    public static final TerminateReason NOT_LOGGED_IN = null;
    public static final TerminateReason OBJECT_DELETED = null;
    public static final TerminateReason OTHERS = null;
    public static final TerminateReason PRIORITY_REPLACED = null;
    public static final TerminateReason REACH_MAX_DURATION = null;
    public static final TerminateReason RTC_INIT_FAILED = null;
    public static final TerminateReason SAVE_ARTIFACT_DISABLED = null;
    public static final TerminateReason TENANT_KEY_DELETED = null;
    public static final TerminateReason UNAUTHORIZED = null;
    public static final TerminateReason UPLOAD_COMPLETED = null;
    public static final TerminateReason UPLOAD_COMPLETED_SERVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TerminateReason[] f434191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434192b = null;

    public static EnumEntries<TerminateReason> getEntries() {
        return f434192b;
    }

    static {
        TerminateReason r100 = new TerminateReason("MEETING_ID_EMPTY", 0);
        MEETING_ID_EMPTY = r100;
        TerminateReason r101 = new TerminateReason("MINUTES_TOKEN_EMPTY", 1);
        MINUTES_TOKEN_EMPTY = r101;
        TerminateReason r102 = new TerminateReason("RTC_INIT_FAILED", 2);
        RTC_INIT_FAILED = r102;
        TerminateReason r103 = new TerminateReason("DIR_CREATE_FAILED", 3);
        DIR_CREATE_FAILED = r103;
        TerminateReason r104 = new TerminateReason("ALREADY_RECORDING", 4);
        ALREADY_RECORDING = r104;
        TerminateReason r105 = new TerminateReason("MEETING_CREATED_FAILED", 5);
        MEETING_CREATED_FAILED = r105;
        TerminateReason r110 = new TerminateReason("UPLOAD_COMPLETED", 6);
        UPLOAD_COMPLETED = r110;
        TerminateReason r111 = new TerminateReason("NON_RECORDING_TYPE", 7);
        NON_RECORDING_TYPE = r111;
        TerminateReason r112 = new TerminateReason("REACH_MAX_DURATION", 8);
        REACH_MAX_DURATION = r112;
        TerminateReason r113 = new TerminateReason("UPLOAD_COMPLETED_SERVER", 9);
        UPLOAD_COMPLETED_SERVER = r113;
        TerminateReason r114 = new TerminateReason("OBJECT_DELETED", 10);
        OBJECT_DELETED = r114;
        TerminateReason r115 = new TerminateReason("NOT_LOGGED_IN", 11);
        NOT_LOGGED_IN = r115;
        TerminateReason r106 = new TerminateReason("UNAUTHORIZED", 12);
        UNAUTHORIZED = r106;
        TerminateReason r107 = new TerminateReason("TENANT_KEY_DELETED", 13);
        TENANT_KEY_DELETED = r107;
        TerminateReason r108 = new TerminateReason("SAVE_ARTIFACT_DISABLED", 14);
        SAVE_ARTIFACT_DISABLED = r108;
        TerminateReason r109 = new TerminateReason("HARDWARE_DISCONNECTED", 15);
        HARDWARE_DISCONNECTED = r109;
        TerminateReason r116 = new TerminateReason("PRIORITY_REPLACED", 16);
        PRIORITY_REPLACED = r116;
        TerminateReason r117 = new TerminateReason("HARDWARE_STOPPED", 17);
        HARDWARE_STOPPED = r117;
        TerminateReason r118 = new TerminateReason(AccountType.OTHERS, 18);
        OTHERS = r118;
        TerminateReason[] r119 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
        f434191a = r119;
        f434192b = EnumEntriesKt.enumEntries(r119);
    }

    public static TerminateReason[] values() {
        return (TerminateReason[]) f434191a.clone();
    }

    public static TerminateReason valueOf(String r100) {
        return (TerminateReason) a.a(TerminateReason.class, r100);
    }

    public TerminateReason(String r100, int r101) {
        super(r100, r101);
    }
}
