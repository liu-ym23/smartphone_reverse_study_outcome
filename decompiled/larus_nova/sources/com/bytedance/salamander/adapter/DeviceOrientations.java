package com.bytedance.salamander.adapter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/salamander/adapter/DeviceOrientations;", "", "", "value", "I", "getValue", "()I", "Unknown", "Portrait", "PortraitUpsideDown", "LandscapeLeft", "LandscapeRight", "FaceUp", "FaceDown", "runtime_release"}, k = 1, mv = {1, 7, 1})
public final enum DeviceOrientations extends Enum<DeviceOrientations> {
    public static final DeviceOrientations FaceDown = null;
    public static final DeviceOrientations FaceUp = null;
    public static final DeviceOrientations LandscapeLeft = null;
    public static final DeviceOrientations LandscapeRight = null;
    public static final DeviceOrientations Portrait = null;
    public static final DeviceOrientations PortraitUpsideDown = null;
    public static final DeviceOrientations Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceOrientations[] f267776a = null;
    private final int value;

    public static DeviceOrientations valueOf(String r100) {
        return (DeviceOrientations) r27.a.a(DeviceOrientations.class, r100);
    }

    public static DeviceOrientations[] values() {
        return (DeviceOrientations[]) f267776a.clone();
    }

    static {
        DeviceOrientations r100 = new DeviceOrientations("Unknown", 0, 0);
        Unknown = r100;
        DeviceOrientations r101 = new DeviceOrientations("Portrait", 1, 1);
        Portrait = r101;
        DeviceOrientations r102 = new DeviceOrientations("PortraitUpsideDown", 2, 2);
        PortraitUpsideDown = r102;
        DeviceOrientations r103 = new DeviceOrientations("LandscapeLeft", 3, 3);
        LandscapeLeft = r103;
        DeviceOrientations r104 = new DeviceOrientations("LandscapeRight", 4, 4);
        LandscapeRight = r104;
        DeviceOrientations r105 = new DeviceOrientations("FaceUp", 5, 5);
        FaceUp = r105;
        DeviceOrientations r110 = new DeviceOrientations("FaceDown", 6, 6);
        FaceDown = r110;
        f267776a = new DeviceOrientations[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public DeviceOrientations(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
