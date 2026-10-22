package com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/proxy/WebProxyErrorCode;", "", "value", "", "message", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getMessage", "()Ljava/lang/String;", "SUCCESS", "INVALID_COMMAND", "INVALID_REQUEST_FORMAT", "DECODE_REQUEST_FAILED", "NETWORK_ERROR", "UNKNOWN_ERROR", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WebProxyErrorCode extends Enum<WebProxyErrorCode> {
    public static final a Companion = null;
    public static final WebProxyErrorCode DECODE_REQUEST_FAILED = null;
    public static final WebProxyErrorCode INVALID_COMMAND = null;
    public static final WebProxyErrorCode INVALID_REQUEST_FORMAT = null;
    public static final WebProxyErrorCode NETWORK_ERROR = null;
    public static final WebProxyErrorCode SUCCESS = null;
    public static final WebProxyErrorCode UNKNOWN_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebProxyErrorCode[] f433963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433964b = null;
    private final String message;
    private final int value;

    public static EnumEntries<WebProxyErrorCode> getEntries() {
        return f433964b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.officesdk.minutes.service.foundation.network.proxy.WebProxyErrorCode$a] */
    static {
        WebProxyErrorCode r100 = new WebProxyErrorCode("SUCCESS", 0, 0, "Success");
        SUCCESS = r100;
        WebProxyErrorCode r101 = new WebProxyErrorCode("INVALID_COMMAND", 1, 1001, "Invalid or unsupported command");
        INVALID_COMMAND = r101;
        WebProxyErrorCode r102 = new WebProxyErrorCode("INVALID_REQUEST_FORMAT", 2, 1002, "Invalid request format");
        INVALID_REQUEST_FORMAT = r102;
        WebProxyErrorCode r103 = new WebProxyErrorCode("DECODE_REQUEST_FAILED", 3, 1003, "Failed to decode request base64");
        DECODE_REQUEST_FAILED = r103;
        WebProxyErrorCode r104 = new WebProxyErrorCode("NETWORK_ERROR", 4, 1004, "Network request failed");
        NETWORK_ERROR = r104;
        WebProxyErrorCode r105 = new WebProxyErrorCode("UNKNOWN_ERROR", 5, -1, "Unknown error");
        UNKNOWN_ERROR = r105;
        WebProxyErrorCode[] r110 = {r100, r101, r102, r103, r104, r105};
        f433963a = r110;
        f433964b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static WebProxyErrorCode[] values() {
        return (WebProxyErrorCode[]) f433963a.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getValue() {
        return this.value;
    }

    public static WebProxyErrorCode valueOf(String r100) {
        return (WebProxyErrorCode) r27.a.a(WebProxyErrorCode.class, r100);
    }

    public WebProxyErrorCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.message = r103;
    }
}
