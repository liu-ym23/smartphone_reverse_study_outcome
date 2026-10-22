package com.larus.im.internal.trace.manager.definition;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/trace/manager/definition/AVMediaDeviceError;", "", "code", "", "msg", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "NOPERMISSION", "DEVICEBUSY", "DEVICEFAILURE", "DEVICENOTFOUND", "DEVICEDISCONNECTED", "DEVICENOCALLBACK", "UNSUPPORTFORMAT", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AVMediaDeviceError extends Enum<AVMediaDeviceError> {
    public static final AVMediaDeviceError DEVICEBUSY = null;
    public static final AVMediaDeviceError DEVICEDISCONNECTED = null;
    public static final AVMediaDeviceError DEVICEFAILURE = null;
    public static final AVMediaDeviceError DEVICENOCALLBACK = null;
    public static final AVMediaDeviceError DEVICENOTFOUND = null;
    public static final AVMediaDeviceError NOPERMISSION = null;
    public static final AVMediaDeviceError UNSUPPORTFORMAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AVMediaDeviceError[] f350147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350148b = null;
    private final int code;
    private final String msg;

    public static EnumEntries<AVMediaDeviceError> getEntries() {
        return f350148b;
    }

    static {
        AVMediaDeviceError r100 = new AVMediaDeviceError("NOPERMISSION", 0, 1, "No Permission");
        NOPERMISSION = r100;
        AVMediaDeviceError r101 = new AVMediaDeviceError("DEVICEBUSY", 1, 2, "Device Busy");
        DEVICEBUSY = r101;
        AVMediaDeviceError r102 = new AVMediaDeviceError("DEVICEFAILURE", 2, 3, "Device Failure");
        DEVICEFAILURE = r102;
        AVMediaDeviceError r103 = new AVMediaDeviceError("DEVICENOTFOUND", 3, 4, "Device Not Found");
        DEVICENOTFOUND = r103;
        AVMediaDeviceError r104 = new AVMediaDeviceError("DEVICEDISCONNECTED", 4, 5, "Device Disconnected");
        DEVICEDISCONNECTED = r104;
        AVMediaDeviceError r105 = new AVMediaDeviceError("DEVICENOCALLBACK", 5, 6, "Device No Callback");
        DEVICENOCALLBACK = r105;
        AVMediaDeviceError r110 = new AVMediaDeviceError("UNSUPPORTFORMAT", 6, 7, "Unsupport Format");
        UNSUPPORTFORMAT = r110;
        AVMediaDeviceError[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f350147a = r111;
        f350148b = EnumEntriesKt.enumEntries(r111);
    }

    public static AVMediaDeviceError[] values() {
        return (AVMediaDeviceError[]) f350147a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public static AVMediaDeviceError valueOf(String r100) {
        return (AVMediaDeviceError) a.a(AVMediaDeviceError.class, r100);
    }

    public AVMediaDeviceError(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
    }
}
