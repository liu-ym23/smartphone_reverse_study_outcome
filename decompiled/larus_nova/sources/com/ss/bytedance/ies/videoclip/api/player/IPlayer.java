package com.ss.bytedance.ies.videoclip.api.player;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public interface IPlayer {

    public static final enum PlayerStatus extends Enum<PlayerStatus> {
        public static final PlayerStatus ERROR = null;
        public static final PlayerStatus FINISHED = null;
        public static final PlayerStatus IDLE = null;
        public static final PlayerStatus PAUSED = null;
        public static final PlayerStatus PLAYING = null;
        public static final PlayerStatus READY = null;
        public static final PlayerStatus REPLAY = null;
        public static final PlayerStatus STOPPED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlayerStatus[] f456077a = null;

        static {
            PlayerStatus r100 = new PlayerStatus("IDLE", 0);
            IDLE = r100;
            PlayerStatus r101 = new PlayerStatus("READY", 1);
            READY = r101;
            PlayerStatus r102 = new PlayerStatus("PLAYING", 2);
            PLAYING = r102;
            PlayerStatus r103 = new PlayerStatus("STOPPED", 3);
            STOPPED = r103;
            PlayerStatus r104 = new PlayerStatus("PAUSED", 4);
            PAUSED = r104;
            PlayerStatus r105 = new PlayerStatus("FINISHED", 5);
            FINISHED = r105;
            PlayerStatus r110 = new PlayerStatus("ERROR", 6);
            ERROR = r110;
            PlayerStatus r111 = new PlayerStatus("REPLAY", 7);
            REPLAY = r111;
            f456077a = new PlayerStatus[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static PlayerStatus[] values() {
            return (PlayerStatus[]) f456077a.clone();
        }

        public static PlayerStatus valueOf(String r100) {
            return (PlayerStatus) a.a(PlayerStatus.class, r100);
        }

        public PlayerStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a();

    void b();

    boolean isPlaying();

    void pause();

    void play();

    void stop();
}
