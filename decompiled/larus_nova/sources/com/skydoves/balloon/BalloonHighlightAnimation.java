package com.skydoves.balloon;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/skydoves/balloon/BalloonHighlightAnimation;", "", UserProfileEvent.POSITION_NONE, "HEARTBEAT", "SHAKE", "BREATH", "ROTATE", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum BalloonHighlightAnimation extends Enum<BalloonHighlightAnimation> {
    public static final BalloonHighlightAnimation BREATH = null;
    public static final BalloonHighlightAnimation HEARTBEAT = null;
    public static final BalloonHighlightAnimation NONE = null;
    public static final BalloonHighlightAnimation ROTATE = null;
    public static final BalloonHighlightAnimation SHAKE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BalloonHighlightAnimation[] f406129a = null;

    public static BalloonHighlightAnimation valueOf(String r100) {
        return (BalloonHighlightAnimation) r27.a.a(BalloonHighlightAnimation.class, r100);
    }

    public static BalloonHighlightAnimation[] values() {
        return (BalloonHighlightAnimation[]) f406129a.clone();
    }

    static {
        BalloonHighlightAnimation r100 = new BalloonHighlightAnimation(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        BalloonHighlightAnimation r101 = new BalloonHighlightAnimation("HEARTBEAT", 1);
        HEARTBEAT = r101;
        BalloonHighlightAnimation r102 = new BalloonHighlightAnimation("SHAKE", 2);
        SHAKE = r102;
        BalloonHighlightAnimation r103 = new BalloonHighlightAnimation("BREATH", 3);
        BREATH = r103;
        BalloonHighlightAnimation r104 = new BalloonHighlightAnimation("ROTATE", 4);
        ROTATE = r104;
        f406129a = new BalloonHighlightAnimation[]{r100, r101, r102, r103, r104};
    }

    public BalloonHighlightAnimation(String r100, int r101) {
        super(r100, r101);
    }
}
