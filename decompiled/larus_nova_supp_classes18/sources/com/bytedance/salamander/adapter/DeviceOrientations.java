package com.bytedance.salamander.adapter;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/salamander/adapter/DeviceOrientations;", "", "", "value", "I", "getValue", "()I", "Unknown", "Portrait", "PortraitUpsideDown", "LandscapeLeft", "LandscapeRight", "FaceUp", "FaceDown", "runtime_release"}, k = 1, mv = {1, 7, 1})
public final enum DeviceOrientations extends Enum<DeviceOrientations> {
    public static final DeviceOrientations FaceDown = null;
    public static final DeviceOrientations FaceUp = null;
    public static final DeviceOrientations LandscapeLeft = null;
    public static final DeviceOrientations LandscapeRight = null;
    public static final DeviceOrientations Portrait = null;
    public static final DeviceOrientations PortraitUpsideDown = null;
    public static final DeviceOrientations Unknown = null;
    public static final /* synthetic */ DeviceOrientations[] a = null;
    private final int value;

    public static DeviceOrientations valueOf(String r1) {
        return (DeviceOrientations) r27.a.a(DeviceOrientations.class, r1);
    }

    public static DeviceOrientations[] values() {
        return (DeviceOrientations[]) a.clone();
    }

    static {
        DeviceOrientations r0 = new DeviceOrientations("Unknown", 0, 0);
        Unknown = r0;
        DeviceOrientations r1 = new DeviceOrientations("Portrait", 1, 1);
        Portrait = r1;
        DeviceOrientations r3 = new DeviceOrientations("PortraitUpsideDown", 2, 2);
        PortraitUpsideDown = r3;
        DeviceOrientations r5 = new DeviceOrientations("LandscapeLeft", 3, 3);
        LandscapeLeft = r5;
        DeviceOrientations r7 = new DeviceOrientations("LandscapeRight", 4, 4);
        LandscapeRight = r7;
        DeviceOrientations r9 = new DeviceOrientations("FaceUp", 5, 5);
        FaceUp = r9;
        DeviceOrientations r11 = new DeviceOrientations("FaceDown", 6, 6);
        FaceDown = r11;
        a = new DeviceOrientations[]{r0, r1, r3, r5, r7, r9, r11};
    }

    public final int getValue() {
        return this.value;
    }

    public DeviceOrientations(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
