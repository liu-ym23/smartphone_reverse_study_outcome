package com.ss.bytertc.engine;

import com.ss.bytertc.engine.type.RoomProfile;

/* JADX INFO: loaded from: classes40.dex */
public class RTCRoomConfig {
    public int cacheAudioDataMs;
    public boolean isAutoSubscribeAudio;
    public boolean isAutoSubscribeVideo;
    public boolean isCacheAudioData;
    public boolean isPublishAudio;
    public boolean isPublishVideo;
    public RoomProfile profile;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.RTCRoomConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$RoomProfile = null;

        static {
            int[] r100 = new int[RoomProfile.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile = r100;
            r100[RoomProfile.COMMUNICATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.CLOUD_GAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.GAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.LOW_LATENCY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.CHAT_ROOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.INTERACTIVE_PODCAST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.CHORUS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.GAME_STREAMING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.MEETING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.MEETING_ROOM.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.CLASSROOM.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.CALL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$com$ss$bytertc$engine$type$RoomProfile[RoomProfile.LIVE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    public int getProfile() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$RoomProfile[this.profile.ordinal()]) {
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L20;
            case 7: goto L18;
            case 8: goto L16;
            case 9: goto L14;
            case 10: goto L12;
            case 11: goto L10;
            case 12: goto L8;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 20;
    L8:
        return 19;
    L10:
        return 18;
    L12:
        return 17;
    L14:
        return 16;
    L16:
        return 14;
    L18:
        return 12;
    L20:
        return 10;
    L22:
        return 6;
    L24:
        return 4;
    L26:
        return 2;
    L28:
        return 3;
    }

    public String toString() {
        return "RTCRoomConfig{profile=" + this.profile + ", isPublishAudio=" + this.isPublishAudio + ", isPublishVideo=" + this.isPublishVideo + ", isAutoSubscribeAudio=" + this.isAutoSubscribeAudio + ", isAutoSubscribeVideo=" + this.isAutoSubscribeVideo + ", isCacheAudioData=" + this.isCacheAudioData + ", cacheAudioDataMs=" + this.cacheAudioDataMs + '}';
    }

    public int getCacheAudioDataMs() {
        return this.cacheAudioDataMs;
    }

    public boolean isAutoSubscribeAudio() {
        return this.isAutoSubscribeAudio;
    }

    public boolean isAutoSubscribeVideo() {
        return this.isAutoSubscribeVideo;
    }

    public boolean isCacheAudioData() {
        return this.isCacheAudioData;
    }

    public boolean isPublishAudio() {
        return this.isPublishAudio;
    }

    public boolean isPublishVideo() {
        return this.isPublishVideo;
    }

    public RTCRoomConfig(RoomProfile r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106) {
        this.profile = r100;
        this.isPublishAudio = r101;
        this.isPublishVideo = r102;
        this.isAutoSubscribeAudio = r103;
        this.isAutoSubscribeVideo = r104;
        this.isCacheAudioData = r105;
        this.cacheAudioDataMs = r106;
    }
}
