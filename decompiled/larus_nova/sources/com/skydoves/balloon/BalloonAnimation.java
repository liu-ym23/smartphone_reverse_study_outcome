package com.skydoves.balloon;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/skydoves/balloon/BalloonAnimation;", "", UserProfileEvent.POSITION_NONE, "ELASTIC", "FADE", "CIRCULAR", "OVERSHOOT", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum BalloonAnimation extends Enum<BalloonAnimation> {
    public static final BalloonAnimation CIRCULAR = null;
    public static final BalloonAnimation ELASTIC = null;
    public static final BalloonAnimation FADE = null;
    public static final BalloonAnimation NONE = null;
    public static final BalloonAnimation OVERSHOOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BalloonAnimation[] f406126a = null;

    public static BalloonAnimation valueOf(String r100) {
        return (BalloonAnimation) r27.a.a(BalloonAnimation.class, r100);
    }

    public static BalloonAnimation[] values() {
        return (BalloonAnimation[]) f406126a.clone();
    }

    static {
        BalloonAnimation r100 = new BalloonAnimation(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        BalloonAnimation r101 = new BalloonAnimation("ELASTIC", 1);
        ELASTIC = r101;
        BalloonAnimation r102 = new BalloonAnimation("FADE", 2);
        FADE = r102;
        BalloonAnimation r103 = new BalloonAnimation("CIRCULAR", 3);
        CIRCULAR = r103;
        BalloonAnimation r104 = new BalloonAnimation("OVERSHOOT", 4);
        OVERSHOOT = r104;
        f406126a = new BalloonAnimation[]{r100, r101, r102, r103, r104};
    }

    public BalloonAnimation(String r100, int r101) {
        super(r100, r101);
    }
}
