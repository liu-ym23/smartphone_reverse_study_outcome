package com.bytedance.flow_audio.api.business.asr.error;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/flow_audio/api/business/asr/error/FlowAsrErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "UNSUPPORTED", "SOURCE_PREPARE_FAILED", "SOURCE_START_FAILED", "SOURCE_STOP_FAILED", "SOURCE_RELEASE_FAILED", "CLIENT_ERROR", "NETWORK_ERROR", "SERVER_ERROR", "TIMEOUT", "EMPTY_RESULT", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowAsrErrorType extends Enum<FlowAsrErrorType> {
    public static final FlowAsrErrorType CLIENT_ERROR = null;
    public static final FlowAsrErrorType EMPTY_RESULT = null;
    public static final FlowAsrErrorType NETWORK_ERROR = null;
    public static final FlowAsrErrorType SERVER_ERROR = null;
    public static final FlowAsrErrorType SOURCE_PREPARE_FAILED = null;
    public static final FlowAsrErrorType SOURCE_RELEASE_FAILED = null;
    public static final FlowAsrErrorType SOURCE_START_FAILED = null;
    public static final FlowAsrErrorType SOURCE_STOP_FAILED = null;
    public static final FlowAsrErrorType TIMEOUT = null;
    public static final FlowAsrErrorType UNKNOWN = null;
    public static final FlowAsrErrorType UNSUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowAsrErrorType[] f243673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243674b = null;

    public static EnumEntries<FlowAsrErrorType> getEntries() {
        return f243674b;
    }

    static {
        FlowAsrErrorType r100 = new FlowAsrErrorType("UNKNOWN", 0);
        UNKNOWN = r100;
        FlowAsrErrorType r101 = new FlowAsrErrorType("UNSUPPORTED", 1);
        UNSUPPORTED = r101;
        FlowAsrErrorType r102 = new FlowAsrErrorType("SOURCE_PREPARE_FAILED", 2);
        SOURCE_PREPARE_FAILED = r102;
        FlowAsrErrorType r103 = new FlowAsrErrorType("SOURCE_START_FAILED", 3);
        SOURCE_START_FAILED = r103;
        FlowAsrErrorType r104 = new FlowAsrErrorType("SOURCE_STOP_FAILED", 4);
        SOURCE_STOP_FAILED = r104;
        FlowAsrErrorType r105 = new FlowAsrErrorType("SOURCE_RELEASE_FAILED", 5);
        SOURCE_RELEASE_FAILED = r105;
        FlowAsrErrorType r110 = new FlowAsrErrorType("CLIENT_ERROR", 6);
        CLIENT_ERROR = r110;
        FlowAsrErrorType r111 = new FlowAsrErrorType("NETWORK_ERROR", 7);
        NETWORK_ERROR = r111;
        FlowAsrErrorType r112 = new FlowAsrErrorType("SERVER_ERROR", 8);
        SERVER_ERROR = r112;
        FlowAsrErrorType r113 = new FlowAsrErrorType("TIMEOUT", 9);
        TIMEOUT = r113;
        FlowAsrErrorType r114 = new FlowAsrErrorType("EMPTY_RESULT", 10);
        EMPTY_RESULT = r114;
        FlowAsrErrorType[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f243673a = r115;
        f243674b = EnumEntriesKt.enumEntries(r115);
    }

    public static FlowAsrErrorType[] values() {
        return (FlowAsrErrorType[]) f243673a.clone();
    }

    public static FlowAsrErrorType valueOf(String r100) {
        return (FlowAsrErrorType) a.a(FlowAsrErrorType.class, r100);
    }

    public FlowAsrErrorType(String r100, int r101) {
        super(r100, r101);
    }
}
