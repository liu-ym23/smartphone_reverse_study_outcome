package com.larus.business.arc.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0087\u0081\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001f"}, d2 = {"Lcom/larus/business/arc/api/ArcFrameworkFailure;", "", "code", "", "stage", "Lcom/larus/business/arc/api/ArcStage;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/larus/business/arc/api/ArcStage;)V", "getCode", "()Ljava/lang/String;", "getStage", "()Lcom/larus/business/arc/api/ArcStage;", UserProfileEvent.POSITION_NONE, "PREPARE_INPUT_INVALID", "PREPARE_ROUTE_NOT_FOUND", "PREPARE_PLATFORM_UNSUPPORTED", "PREPARE_REGISTRY_FAILED", "PREPARE_PAYLOAD_INVALID", "PREPARE_RUNTIME_UNAVAILABLE", "PREPARE_RUNTIME_EMPTY_RESULT", "PREPARE_INTERNAL_ERROR", "EXECUTE_TIMEOUT", "EXECUTE_CANCELLED", "EXECUTE_ACTION_EXCEPTION", "EXECUTE_PLATFORM_UNAVAILABLE", "EXECUTE_PLATFORM_CALL_FAILED", "EXECUTE_PLATFORM_INVALID_RESULT", "EXECUTE_INTERNAL_ERROR", "FINALIZE_SERIALIZATION_FAILED", "FINALIZE_INTERNAL_ERROR", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcFrameworkFailure extends Enum<ArcFrameworkFailure> {
    public static final a Companion = null;

    @SerialName("EXECUTE_ACTION_EXCEPTION")
    public static final ArcFrameworkFailure EXECUTE_ACTION_EXCEPTION = null;

    @SerialName("EXECUTE_CANCELLED")
    public static final ArcFrameworkFailure EXECUTE_CANCELLED = null;

    @SerialName("EXECUTE_INTERNAL_ERROR")
    public static final ArcFrameworkFailure EXECUTE_INTERNAL_ERROR = null;

    @SerialName("EXECUTE_PLATFORM_CALL_FAILED")
    public static final ArcFrameworkFailure EXECUTE_PLATFORM_CALL_FAILED = null;

    @SerialName("EXECUTE_PLATFORM_INVALID_RESULT")
    public static final ArcFrameworkFailure EXECUTE_PLATFORM_INVALID_RESULT = null;

    @SerialName("EXECUTE_PLATFORM_UNAVAILABLE")
    public static final ArcFrameworkFailure EXECUTE_PLATFORM_UNAVAILABLE = null;

    @SerialName("EXECUTE_TIMEOUT")
    public static final ArcFrameworkFailure EXECUTE_TIMEOUT = null;

    @SerialName("FINALIZE_INTERNAL_ERROR")
    public static final ArcFrameworkFailure FINALIZE_INTERNAL_ERROR = null;

    @SerialName("FINALIZE_SERIALIZATION_FAILED")
    public static final ArcFrameworkFailure FINALIZE_SERIALIZATION_FAILED = null;

    @SerialName("0")
    public static final ArcFrameworkFailure NONE = null;

    @SerialName("PREPARE_INPUT_INVALID")
    public static final ArcFrameworkFailure PREPARE_INPUT_INVALID = null;

    @SerialName("PREPARE_INTERNAL_ERROR")
    public static final ArcFrameworkFailure PREPARE_INTERNAL_ERROR = null;

    @SerialName("PREPARE_PAYLOAD_INVALID")
    public static final ArcFrameworkFailure PREPARE_PAYLOAD_INVALID = null;

    @SerialName("PREPARE_PLATFORM_UNSUPPORTED")
    public static final ArcFrameworkFailure PREPARE_PLATFORM_UNSUPPORTED = null;

    @SerialName("PREPARE_REGISTRY_FAILED")
    public static final ArcFrameworkFailure PREPARE_REGISTRY_FAILED = null;

    @SerialName("PREPARE_ROUTE_NOT_FOUND")
    public static final ArcFrameworkFailure PREPARE_ROUTE_NOT_FOUND = null;

    @SerialName("PREPARE_RUNTIME_EMPTY_RESULT")
    public static final ArcFrameworkFailure PREPARE_RUNTIME_EMPTY_RESULT = null;

    @SerialName("PREPARE_RUNTIME_UNAVAILABLE")
    public static final ArcFrameworkFailure PREPARE_RUNTIME_UNAVAILABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<juc.d<Object>> f319856a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ArcFrameworkFailure[] f319857b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f319858c = null;
    private final String code;
    private final ArcStage stage;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcFrameworkFailure> serializer() {
            return (juc.d) ArcFrameworkFailure.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcFrameworkFailure> getEntries() {
        return f319858c;
    }

    static {
        ArcFrameworkFailure r100 = new ArcFrameworkFailure(UserProfileEvent.POSITION_NONE, 0, "0", null);
        NONE = r100;
        ArcStage r101 = ArcStage.PREPARE;
        ArcFrameworkFailure r102 = new ArcFrameworkFailure("PREPARE_INPUT_INVALID", 1, "PREPARE_INPUT_INVALID", r101);
        PREPARE_INPUT_INVALID = r102;
        ArcFrameworkFailure r103 = new ArcFrameworkFailure("PREPARE_ROUTE_NOT_FOUND", 2, "PREPARE_ROUTE_NOT_FOUND", r101);
        PREPARE_ROUTE_NOT_FOUND = r103;
        ArcFrameworkFailure r104 = new ArcFrameworkFailure("PREPARE_PLATFORM_UNSUPPORTED", 3, "PREPARE_PLATFORM_UNSUPPORTED", r101);
        PREPARE_PLATFORM_UNSUPPORTED = r104;
        ArcFrameworkFailure r105 = new ArcFrameworkFailure("PREPARE_REGISTRY_FAILED", 4, "PREPARE_REGISTRY_FAILED", r101);
        PREPARE_REGISTRY_FAILED = r105;
        ArcFrameworkFailure r110 = new ArcFrameworkFailure("PREPARE_PAYLOAD_INVALID", 5, "PREPARE_PAYLOAD_INVALID", r101);
        PREPARE_PAYLOAD_INVALID = r110;
        ArcFrameworkFailure r111 = new ArcFrameworkFailure("PREPARE_RUNTIME_UNAVAILABLE", 6, "PREPARE_RUNTIME_UNAVAILABLE", r101);
        PREPARE_RUNTIME_UNAVAILABLE = r111;
        ArcFrameworkFailure r112 = new ArcFrameworkFailure("PREPARE_RUNTIME_EMPTY_RESULT", 7, "PREPARE_RUNTIME_EMPTY_RESULT", r101);
        PREPARE_RUNTIME_EMPTY_RESULT = r112;
        ArcFrameworkFailure r113 = new ArcFrameworkFailure("PREPARE_INTERNAL_ERROR", 8, "PREPARE_INTERNAL_ERROR", r101);
        PREPARE_INTERNAL_ERROR = r113;
        ArcStage r114 = ArcStage.EXECUTE;
        ArcFrameworkFailure r106 = new ArcFrameworkFailure("EXECUTE_TIMEOUT", 9, "EXECUTE_TIMEOUT", r114);
        EXECUTE_TIMEOUT = r106;
        ArcFrameworkFailure r115 = new ArcFrameworkFailure("EXECUTE_CANCELLED", 10, "EXECUTE_CANCELLED", r114);
        EXECUTE_CANCELLED = r115;
        ArcFrameworkFailure r107 = new ArcFrameworkFailure("EXECUTE_ACTION_EXCEPTION", 11, "EXECUTE_ACTION_EXCEPTION", r114);
        EXECUTE_ACTION_EXCEPTION = r107;
        ArcFrameworkFailure r108 = new ArcFrameworkFailure("EXECUTE_PLATFORM_UNAVAILABLE", 12, "EXECUTE_PLATFORM_UNAVAILABLE", r114);
        EXECUTE_PLATFORM_UNAVAILABLE = r108;
        ArcFrameworkFailure r109 = new ArcFrameworkFailure("EXECUTE_PLATFORM_CALL_FAILED", 13, "EXECUTE_PLATFORM_CALL_FAILED", r114);
        EXECUTE_PLATFORM_CALL_FAILED = r109;
        ArcFrameworkFailure r116 = new ArcFrameworkFailure("EXECUTE_PLATFORM_INVALID_RESULT", 14, "EXECUTE_PLATFORM_INVALID_RESULT", r114);
        EXECUTE_PLATFORM_INVALID_RESULT = r116;
        ArcFrameworkFailure r117 = new ArcFrameworkFailure("EXECUTE_INTERNAL_ERROR", 15, "EXECUTE_INTERNAL_ERROR", r114);
        EXECUTE_INTERNAL_ERROR = r117;
        ArcStage r118 = ArcStage.FINALIZE;
        ArcFrameworkFailure r119 = new ArcFrameworkFailure("FINALIZE_SERIALIZATION_FAILED", 16, "FINALIZE_SERIALIZATION_FAILED", r118);
        FINALIZE_SERIALIZATION_FAILED = r119;
        ArcFrameworkFailure r120 = new ArcFrameworkFailure("FINALIZE_INTERNAL_ERROR", 17, "FINALIZE_INTERNAL_ERROR", r118);
        FINALIZE_INTERNAL_ERROR = r120;
        ArcFrameworkFailure[] r121 = {r100, r102, r103, r104, r105, r110, r111, r112, r113, r106, r115, r107, r108, r109, r116, r117, r119, r120};
        f319857b = r121;
        f319858c = EnumEntriesKt.enumEntries(r121);
        Companion = new a();
        f319856a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new n());
    }

    public static ArcFrameworkFailure[] values() {
        return (ArcFrameworkFailure[]) f319857b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f319856a;
    }

    public final String getCode() {
        return this.code;
    }

    public final ArcStage getStage() {
        return this.stage;
    }

    public static ArcFrameworkFailure valueOf(String r100) {
        return (ArcFrameworkFailure) r27.a.a(ArcFrameworkFailure.class, r100);
    }

    public ArcFrameworkFailure(String r100, int r101, String r102, ArcStage r103) {
        super(r100, r101);
        this.code = r102;
        this.stage = r103;
    }
}
