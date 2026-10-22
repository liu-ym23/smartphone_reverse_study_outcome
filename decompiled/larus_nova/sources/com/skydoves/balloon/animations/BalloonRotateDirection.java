package com.skydoves.balloon.animations;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/skydoves/balloon/animations/BalloonRotateDirection;", "", "", "value", "I", "getValue", "()I", "RIGHT", "LEFT", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum BalloonRotateDirection extends Enum<BalloonRotateDirection> {
    public static final BalloonRotateDirection LEFT = null;
    public static final BalloonRotateDirection RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BalloonRotateDirection[] f406132a = null;
    private final int value;

    public static BalloonRotateDirection valueOf(String r100) {
        return (BalloonRotateDirection) a.a(BalloonRotateDirection.class, r100);
    }

    public static BalloonRotateDirection[] values() {
        return (BalloonRotateDirection[]) f406132a.clone();
    }

    static {
        BalloonRotateDirection r100 = new BalloonRotateDirection("RIGHT", 0, 1);
        RIGHT = r100;
        BalloonRotateDirection r101 = new BalloonRotateDirection("LEFT", 1, -1);
        LEFT = r101;
        f406132a = new BalloonRotateDirection[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public BalloonRotateDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
