package com.skydoves.balloon.overlay;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonOverlayAnimation;", "", UserProfileEvent.POSITION_NONE, "FADE", "balloon_release"}, k = 1, mv = {1, 7, 1})
public final enum BalloonOverlayAnimation extends Enum<BalloonOverlayAnimation> {
    public static final BalloonOverlayAnimation FADE = null;
    public static final BalloonOverlayAnimation NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BalloonOverlayAnimation[] f406187a = null;

    public static BalloonOverlayAnimation valueOf(String r100) {
        return (BalloonOverlayAnimation) a.a(BalloonOverlayAnimation.class, r100);
    }

    public static BalloonOverlayAnimation[] values() {
        return (BalloonOverlayAnimation[]) f406187a.clone();
    }

    static {
        BalloonOverlayAnimation r100 = new BalloonOverlayAnimation(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        BalloonOverlayAnimation r101 = new BalloonOverlayAnimation("FADE", 1);
        FADE = r101;
        f406187a = new BalloonOverlayAnimation[]{r100, r101};
    }

    public BalloonOverlayAnimation(String r100, int r101) {
        super(r100, r101);
    }
}
