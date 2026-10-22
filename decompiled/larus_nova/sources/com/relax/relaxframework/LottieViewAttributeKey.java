package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxframework/LottieViewAttributeKey;", "", "", "value", "I", "getValue", "()I", "Src", "LoopCount", "Loop", "PlayStatus", "Autoplay", "Progress", "Speed", "SrcFormat", "SrcPolyfill", "Json", "StartFrame", "EndFrame", "AutoReverse", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum LottieViewAttributeKey extends Enum<LottieViewAttributeKey> {
    public static final LottieViewAttributeKey AutoReverse = null;
    public static final LottieViewAttributeKey Autoplay = null;
    public static final LottieViewAttributeKey EndFrame = null;
    public static final LottieViewAttributeKey Json = null;
    public static final LottieViewAttributeKey Loop = null;
    public static final LottieViewAttributeKey LoopCount = null;
    public static final LottieViewAttributeKey PlayStatus = null;
    public static final LottieViewAttributeKey Progress = null;
    public static final LottieViewAttributeKey Speed = null;
    public static final LottieViewAttributeKey Src = null;
    public static final LottieViewAttributeKey SrcFormat = null;
    public static final LottieViewAttributeKey SrcPolyfill = null;
    public static final LottieViewAttributeKey StartFrame = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LottieViewAttributeKey[] f404781a = null;
    private final int value;

    public static LottieViewAttributeKey valueOf(String r100) {
        return (LottieViewAttributeKey) r27.a.a(LottieViewAttributeKey.class, r100);
    }

    public static LottieViewAttributeKey[] values() {
        return (LottieViewAttributeKey[]) f404781a.clone();
    }

    static {
        LottieViewAttributeKey r100 = new LottieViewAttributeKey("Src", 0, 20002);
        Src = r100;
        LottieViewAttributeKey r101 = new LottieViewAttributeKey("LoopCount", 1, 20158);
        LoopCount = r101;
        LottieViewAttributeKey r102 = new LottieViewAttributeKey("Loop", 2, 20157);
        Loop = r102;
        LottieViewAttributeKey r103 = new LottieViewAttributeKey("PlayStatus", 3, 20267);
        PlayStatus = r103;
        LottieViewAttributeKey r104 = new LottieViewAttributeKey("Autoplay", 4, 20043);
        Autoplay = r104;
        LottieViewAttributeKey r105 = new LottieViewAttributeKey("Progress", 5, 20268);
        Progress = r105;
        LottieViewAttributeKey r110 = new LottieViewAttributeKey("Speed", 6, 20160);
        Speed = r110;
        LottieViewAttributeKey r111 = new LottieViewAttributeKey("SrcFormat", 7, 20269);
        SrcFormat = r111;
        LottieViewAttributeKey r112 = new LottieViewAttributeKey("SrcPolyfill", 8, 20270);
        SrcPolyfill = r112;
        LottieViewAttributeKey r113 = new LottieViewAttributeKey("Json", 9, 20271);
        Json = r113;
        LottieViewAttributeKey r114 = new LottieViewAttributeKey("StartFrame", 10, 20272);
        StartFrame = r114;
        LottieViewAttributeKey r106 = new LottieViewAttributeKey("EndFrame", 11, 20273);
        EndFrame = r106;
        LottieViewAttributeKey r107 = new LottieViewAttributeKey("AutoReverse", 12, 20274);
        AutoReverse = r107;
        f404781a = new LottieViewAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public final int getValue() {
        return this.value;
    }

    public LottieViewAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
