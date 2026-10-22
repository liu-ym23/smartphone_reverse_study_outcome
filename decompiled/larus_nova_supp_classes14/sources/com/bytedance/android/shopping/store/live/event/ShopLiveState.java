package com.bytedance.android.shopping.store.live.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopLiveState {
    public final PlayState a;
    public final LiveScene b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/live/event/ShopLiveState$LiveScene;", "", "PREVIEW", "FLOAT_WINDOW", "LIVE_TAB", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveScene extends Enum<LiveScene> {
        public static final LiveScene FLOAT_WINDOW = null;
        public static final LiveScene LIVE_TAB = null;
        public static final LiveScene PREVIEW = null;
        public static final /* synthetic */ LiveScene[] a = null;

        static {
            LiveScene r1 = new LiveScene("PREVIEW", 0);
            PREVIEW = r1;
            LiveScene r2 = new LiveScene("FLOAT_WINDOW", 1);
            FLOAT_WINDOW = r2;
            LiveScene r3 = new LiveScene("LIVE_TAB", 2);
            LIVE_TAB = r3;
            a = new LiveScene[]{r1, r2, r3};
        }

        public static LiveScene valueOf(String r1) {
            return (LiveScene) a.a(LiveScene.class, r1);
        }

        public static LiveScene[] values() {
            return (LiveScene[]) a.clone();
        }

        public LiveScene(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/live/event/ShopLiveState$PlayState;", "", "INIT", "ENTER_LIVE", "START_PLAY", "PLAYING", "STOP_PLAY", "STOP_SUCCESS", "RELEASE", "RESUMABLE_ERROR", "ERROR", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlayState extends Enum<PlayState> {
        public static final PlayState ENTER_LIVE = null;
        public static final PlayState ERROR = null;
        public static final PlayState INIT = null;
        public static final PlayState PLAYING = null;
        public static final PlayState RELEASE = null;
        public static final PlayState RESUMABLE_ERROR = null;
        public static final PlayState START_PLAY = null;
        public static final PlayState STOP_PLAY = null;
        public static final PlayState STOP_SUCCESS = null;
        public static final /* synthetic */ PlayState[] a = null;

        static {
            PlayState r1 = new PlayState("INIT", 0);
            INIT = r1;
            PlayState r2 = new PlayState("ENTER_LIVE", 1);
            ENTER_LIVE = r2;
            PlayState r3 = new PlayState("START_PLAY", 2);
            START_PLAY = r3;
            PlayState r4 = new PlayState("PLAYING", 3);
            PLAYING = r4;
            PlayState r5 = new PlayState("STOP_PLAY", 4);
            STOP_PLAY = r5;
            PlayState r6 = new PlayState("STOP_SUCCESS", 5);
            STOP_SUCCESS = r6;
            PlayState r7 = new PlayState("RELEASE", 6);
            RELEASE = r7;
            PlayState r8 = new PlayState("RESUMABLE_ERROR", 7);
            RESUMABLE_ERROR = r8;
            PlayState r9 = new PlayState("ERROR", 8);
            ERROR = r9;
            a = new PlayState[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
        }

        public static PlayState valueOf(String r1) {
            return (PlayState) a.a(PlayState.class, r1);
        }

        public static PlayState[] values() {
            return (PlayState[]) a.clone();
        }

        public PlayState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShopLiveState) == false) goto L10;
        ShopLiveState r4 = (ShopLiveState) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        PlayState r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LiveScene r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopLiveState(playState=" + this.a + ", liveScene=" + this.b + ")";
    }

    public ShopLiveState(PlayState r2, LiveScene r3) {
        Intrinsics.checkNotNullParameter(r2, "playState");
        Intrinsics.checkNotNullParameter(r3, "liveScene");
        this.a = r2;
        this.b = r3;
    }
}
