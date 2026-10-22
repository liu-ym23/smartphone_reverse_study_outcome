package com.bytedance.cloudplay.xplay2.api.module;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/module/ModuleTypeEnum;", "", "", "value", "I", "getValue", "()I", "ListenerModule", "InputModule", "ImeModule", "PodControlModule", "EngineControlModule", "StreamParameterModule", "PerformanceModule", "CustomMessageModule", "AlbumModule", "AudioModule", "PermissionModule", "LocationModule", "DelayDetectModule", "EventTrackerModule", "CameraModule", "StreamModule", "PCInputModule", "SensorModule", "MuxingServiceModule", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum ModuleTypeEnum extends Enum<ModuleTypeEnum> {
    public static final ModuleTypeEnum AlbumModule = null;
    public static final ModuleTypeEnum AudioModule = null;
    public static final ModuleTypeEnum CameraModule = null;
    public static final ModuleTypeEnum CustomMessageModule = null;
    public static final ModuleTypeEnum DelayDetectModule = null;
    public static final ModuleTypeEnum EngineControlModule = null;
    public static final ModuleTypeEnum EventTrackerModule = null;
    public static final ModuleTypeEnum ImeModule = null;
    public static final ModuleTypeEnum InputModule = null;
    public static final ModuleTypeEnum ListenerModule = null;
    public static final ModuleTypeEnum LocationModule = null;
    public static final ModuleTypeEnum MuxingServiceModule = null;
    public static final ModuleTypeEnum PCInputModule = null;
    public static final ModuleTypeEnum PerformanceModule = null;
    public static final ModuleTypeEnum PermissionModule = null;
    public static final ModuleTypeEnum PodControlModule = null;
    public static final ModuleTypeEnum SensorModule = null;
    public static final ModuleTypeEnum StreamModule = null;
    public static final ModuleTypeEnum StreamParameterModule = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModuleTypeEnum[] f202795a = null;
    private final int value;

    public static ModuleTypeEnum valueOf(String r100) {
        return (ModuleTypeEnum) a.a(ModuleTypeEnum.class, r100);
    }

    public static ModuleTypeEnum[] values() {
        return (ModuleTypeEnum[]) f202795a.clone();
    }

    static {
        ModuleTypeEnum r100 = new ModuleTypeEnum("ListenerModule", 0, 0);
        ListenerModule = r100;
        ModuleTypeEnum r101 = new ModuleTypeEnum("InputModule", 1, 1);
        InputModule = r101;
        ModuleTypeEnum r102 = new ModuleTypeEnum("ImeModule", 2, 2);
        ImeModule = r102;
        ModuleTypeEnum r103 = new ModuleTypeEnum("PodControlModule", 3, 3);
        PodControlModule = r103;
        ModuleTypeEnum r104 = new ModuleTypeEnum("EngineControlModule", 4, 4);
        EngineControlModule = r104;
        ModuleTypeEnum r105 = new ModuleTypeEnum("StreamParameterModule", 5, 5);
        StreamParameterModule = r105;
        ModuleTypeEnum r110 = new ModuleTypeEnum("PerformanceModule", 6, 6);
        PerformanceModule = r110;
        ModuleTypeEnum r111 = new ModuleTypeEnum("CustomMessageModule", 7, 7);
        CustomMessageModule = r111;
        ModuleTypeEnum r112 = new ModuleTypeEnum("AlbumModule", 8, 8);
        AlbumModule = r112;
        ModuleTypeEnum r113 = new ModuleTypeEnum("AudioModule", 9, 9);
        AudioModule = r113;
        ModuleTypeEnum r114 = new ModuleTypeEnum("PermissionModule", 10, 10);
        PermissionModule = r114;
        ModuleTypeEnum r115 = new ModuleTypeEnum("LocationModule", 11, 11);
        LocationModule = r115;
        ModuleTypeEnum r106 = new ModuleTypeEnum("DelayDetectModule", 12, 12);
        DelayDetectModule = r106;
        ModuleTypeEnum r107 = new ModuleTypeEnum("EventTrackerModule", 13, 13);
        EventTrackerModule = r107;
        ModuleTypeEnum r108 = new ModuleTypeEnum("CameraModule", 14, 14);
        CameraModule = r108;
        ModuleTypeEnum r109 = new ModuleTypeEnum("StreamModule", 15, 15);
        StreamModule = r109;
        ModuleTypeEnum r116 = new ModuleTypeEnum("PCInputModule", 16, 16);
        PCInputModule = r116;
        ModuleTypeEnum r117 = new ModuleTypeEnum("SensorModule", 17, 17);
        SensorModule = r117;
        ModuleTypeEnum r118 = new ModuleTypeEnum("MuxingServiceModule", 18, 18);
        MuxingServiceModule = r118;
        f202795a = new ModuleTypeEnum[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
    }

    public final int getValue() {
        return this.value;
    }

    public ModuleTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
