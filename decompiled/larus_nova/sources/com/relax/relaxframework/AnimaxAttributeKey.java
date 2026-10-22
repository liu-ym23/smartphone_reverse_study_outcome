package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/relax/relaxframework/AnimaxAttributeKey;", "", "", "value", "I", "getValue", "()I", "Src", "Json", "Speed", "Autoplay", "StartFrame", "EndFrame", "AutoReverse", "Progress", "Loop", "LoopCount", "ObjectFit", "FpsEventInterval", "MaxFrameRate", "IgnoreAttachStatus", "DynamicResource", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AnimaxAttributeKey extends Enum<AnimaxAttributeKey> {
    public static final AnimaxAttributeKey AutoReverse = null;
    public static final AnimaxAttributeKey Autoplay = null;
    public static final AnimaxAttributeKey DynamicResource = null;
    public static final AnimaxAttributeKey EndFrame = null;
    public static final AnimaxAttributeKey FpsEventInterval = null;
    public static final AnimaxAttributeKey IgnoreAttachStatus = null;
    public static final AnimaxAttributeKey Json = null;
    public static final AnimaxAttributeKey Loop = null;
    public static final AnimaxAttributeKey LoopCount = null;
    public static final AnimaxAttributeKey MaxFrameRate = null;
    public static final AnimaxAttributeKey ObjectFit = null;
    public static final AnimaxAttributeKey Progress = null;
    public static final AnimaxAttributeKey Speed = null;
    public static final AnimaxAttributeKey Src = null;
    public static final AnimaxAttributeKey StartFrame = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimaxAttributeKey[] f404671a = null;
    private final int value;

    public static AnimaxAttributeKey valueOf(String r100) {
        return (AnimaxAttributeKey) r27.a.a(AnimaxAttributeKey.class, r100);
    }

    public static AnimaxAttributeKey[] values() {
        return (AnimaxAttributeKey[]) f404671a.clone();
    }

    static {
        AnimaxAttributeKey r100 = new AnimaxAttributeKey("Src", 0, 20002);
        Src = r100;
        AnimaxAttributeKey r101 = new AnimaxAttributeKey("Json", 1, 20271);
        Json = r101;
        AnimaxAttributeKey r102 = new AnimaxAttributeKey("Speed", 2, 20160);
        Speed = r102;
        AnimaxAttributeKey r103 = new AnimaxAttributeKey("Autoplay", 3, 20043);
        Autoplay = r103;
        AnimaxAttributeKey r104 = new AnimaxAttributeKey("StartFrame", 4, 20272);
        StartFrame = r104;
        AnimaxAttributeKey r105 = new AnimaxAttributeKey("EndFrame", 5, 20273);
        EndFrame = r105;
        AnimaxAttributeKey r110 = new AnimaxAttributeKey("AutoReverse", 6, 20274);
        AutoReverse = r110;
        AnimaxAttributeKey r111 = new AnimaxAttributeKey("Progress", 7, 20268);
        Progress = r111;
        AnimaxAttributeKey r112 = new AnimaxAttributeKey("Loop", 8, 20157);
        Loop = r112;
        AnimaxAttributeKey r113 = new AnimaxAttributeKey("LoopCount", 9, 20158);
        LoopCount = r113;
        AnimaxAttributeKey r114 = new AnimaxAttributeKey("ObjectFit", 10, 20165);
        ObjectFit = r114;
        AnimaxAttributeKey r106 = new AnimaxAttributeKey("FpsEventInterval", 11, 20311);
        FpsEventInterval = r106;
        AnimaxAttributeKey r107 = new AnimaxAttributeKey("MaxFrameRate", 12, 20312);
        MaxFrameRate = r107;
        AnimaxAttributeKey r108 = new AnimaxAttributeKey("IgnoreAttachStatus", 13, 20313);
        IgnoreAttachStatus = r108;
        AnimaxAttributeKey r109 = new AnimaxAttributeKey("DynamicResource", 14, 20314);
        DynamicResource = r109;
        f404671a = new AnimaxAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimaxAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
