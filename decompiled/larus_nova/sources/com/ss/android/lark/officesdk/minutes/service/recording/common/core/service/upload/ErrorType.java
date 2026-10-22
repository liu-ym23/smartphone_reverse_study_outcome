package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/ErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BIZ_SERVER_ERROR", "GATEWAY_ERROR", "CLIENT_ERROR", FlowDoraWifiScene.OTHER, "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorType extends Enum<ErrorType> {
    public static final ErrorType BIZ_SERVER_ERROR = null;
    public static final ErrorType CLIENT_ERROR = null;
    public static final ErrorType GATEWAY_ERROR = null;
    public static final ErrorType OTHER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorType[] f434468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434469b = null;
    private final int value;

    public static EnumEntries<ErrorType> getEntries() {
        return f434469b;
    }

    static {
        ErrorType r100 = new ErrorType("BIZ_SERVER_ERROR", 0, 0);
        BIZ_SERVER_ERROR = r100;
        ErrorType r101 = new ErrorType("GATEWAY_ERROR", 1, 1);
        GATEWAY_ERROR = r101;
        ErrorType r102 = new ErrorType("CLIENT_ERROR", 2, 2);
        CLIENT_ERROR = r102;
        ErrorType r103 = new ErrorType(FlowDoraWifiScene.OTHER, 3, 3);
        OTHER = r103;
        ErrorType[] r104 = {r100, r101, r102, r103};
        f434468a = r104;
        f434469b = EnumEntriesKt.enumEntries(r104);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) f434468a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ErrorType valueOf(String r100) {
        return (ErrorType) r27.a.a(ErrorType.class, r100);
    }

    public ErrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
