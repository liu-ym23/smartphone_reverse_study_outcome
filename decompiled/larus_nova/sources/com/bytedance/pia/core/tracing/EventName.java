package com.bytedance.pia.core.tracing;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes21.dex */
public final enum EventName extends Enum<EventName> {

    @SerializedName("6")
    public static final EventName HTMLRequestStart = null;

    @SerializedName("8")
    public static final EventName HTMLResponseEnd = null;

    @SerializedName("7")
    public static final EventName HTMLResponseStart = null;

    @SerializedName("0")
    public static final EventName NavigateStart = null;

    @SerializedName("12")
    public static final EventName PreloadResourceEnd = null;

    @SerializedName("11")
    public static final EventName PreloadResourceStart = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final EventName ResourceInterceptEnd = null;

    @SerializedName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final EventName ResourceInterceptStart = null;

    @SerializedName("2")
    public static final EventName WorkerEnvironmentInitializeEnd = null;

    @SerializedName("1")
    public static final EventName WorkerEnvironmentInitializeStart = null;

    @SerializedName("5")
    public static final EventName WorkerExecuteStart = null;

    @SerializedName("4")
    public static final EventName WorkerScriptRequestEnd = null;

    @SerializedName("3")
    public static final EventName WorkerScriptRequestStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventName[] f266315a = null;

    static {
        EventName r100 = new EventName("NavigateStart", 0);
        NavigateStart = r100;
        EventName r101 = new EventName("WorkerEnvironmentInitializeStart", 1);
        WorkerEnvironmentInitializeStart = r101;
        EventName r102 = new EventName("WorkerEnvironmentInitializeEnd", 2);
        WorkerEnvironmentInitializeEnd = r102;
        EventName r103 = new EventName("WorkerScriptRequestStart", 3);
        WorkerScriptRequestStart = r103;
        EventName r104 = new EventName("WorkerScriptRequestEnd", 4);
        WorkerScriptRequestEnd = r104;
        EventName r105 = new EventName("WorkerExecuteStart", 5);
        WorkerExecuteStart = r105;
        EventName r110 = new EventName("HTMLRequestStart", 6);
        HTMLRequestStart = r110;
        EventName r111 = new EventName("HTMLResponseStart", 7);
        HTMLResponseStart = r111;
        EventName r112 = new EventName("HTMLResponseEnd", 8);
        HTMLResponseEnd = r112;
        EventName r113 = new EventName("ResourceInterceptStart", 9);
        ResourceInterceptStart = r113;
        EventName r114 = new EventName("ResourceInterceptEnd", 10);
        ResourceInterceptEnd = r114;
        EventName r115 = new EventName("PreloadResourceStart", 11);
        PreloadResourceStart = r115;
        EventName r106 = new EventName("PreloadResourceEnd", 12);
        PreloadResourceEnd = r106;
        f266315a = new EventName[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public static EventName[] values() {
        return (EventName[]) f266315a.clone();
    }

    public static EventName valueOf(String r100) {
        return (EventName) r27.a.a(EventName.class, r100);
    }

    public EventName(String r100, int r101) {
        super(r100, r101);
    }
}
