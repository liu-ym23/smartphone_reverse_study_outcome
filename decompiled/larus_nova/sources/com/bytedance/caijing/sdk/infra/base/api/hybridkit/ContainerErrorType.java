package com.bytedance.caijing.sdk.infra.base.api.hybridkit;

import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/hybridkit/ContainerErrorType;", "", "", "", "isTimeout", "", "errorCode", "errorMsg", "Ljava/lang/String;", "Failed", "TIMEOUT", "LYNX_KIT_SERVICE_IS_NULL", "ENGINE_CONTEXT_IS_NULL", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum ContainerErrorType extends Enum<ContainerErrorType> {
    public static final ContainerErrorType ENGINE_CONTEXT_IS_NULL = null;
    public static final ContainerErrorType Failed = null;
    public static final ContainerErrorType LYNX_KIT_SERVICE_IS_NULL = null;
    public static final ContainerErrorType TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerErrorType[] f202227a = null;
    private final String errorCode;
    private final String errorMsg;

    public static ContainerErrorType valueOf(String r100) {
        return (ContainerErrorType) a.a(ContainerErrorType.class, r100);
    }

    public static ContainerErrorType[] values() {
        return (ContainerErrorType[]) f202227a.clone();
    }

    static {
        ContainerErrorType r100 = new ContainerErrorType("Failed", 0, null, null, 3, null);
        Failed = r100;
        ContainerErrorType r101 = new ContainerErrorType("TIMEOUT", 1, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF, "load timeout!");
        TIMEOUT = r101;
        ContainerErrorType r102 = new ContainerErrorType("LYNX_KIT_SERVICE_IS_NULL", 2, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M, "lynx kit service is null!");
        LYNX_KIT_SERVICE_IS_NULL = r102;
        ContainerErrorType r103 = new ContainerErrorType("ENGINE_CONTEXT_IS_NULL", 3, "1003", "engine context is null!");
        ENGINE_CONTEXT_IS_NULL = r103;
        f202227a = new ContainerErrorType[]{r100, r101, r102, r103};
    }

    public final boolean isTimeout() {
        if (this != TIMEOUT) goto L5;
        return true;
    L5:
        return false;
    }

    public String errorCode() {
        return this.errorCode;
    }

    public String errorMsg() {
        return this.errorMsg;
    }

    public ContainerErrorType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.errorCode = r102;
        this.errorMsg = r103;
    }

    public /* synthetic */ ContainerErrorType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 2) == 0) goto L8;
        r103 = "";
    L8:
        this(r100, r101, r102, r103);
    }
}
