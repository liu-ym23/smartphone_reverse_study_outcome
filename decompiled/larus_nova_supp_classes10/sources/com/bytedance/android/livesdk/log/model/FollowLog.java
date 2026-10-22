package com.bytedance.android.livesdk.log.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class FollowLog {
    public String a;
    public String b;
    public String c;
    public int d;
    public Scene e;
    public String f;
    public String g;
    public String h;

    public static final enum Scene extends Enum<Scene> {
        public static final Scene EndRoomWidget = null;
        public static final Scene JoinFansClubAutoFollow = null;
        public static final Scene LeftTop = null;
        public static final Scene LongPressPanel = null;
        public static final Scene MEDIA_ANCHOR = null;
        public static final Scene MULTI_ANCHOR = null;
        public static final Scene MicRoomLeftTop = null;
        public static final Scene PK = null;
        public static final Scene ProfileCard = null;
        public static final /* synthetic */ Scene[] a = null;
        private final String description;
        private final String followEntrancePage;

        static {
            Scene r0 = new Scene("LeftTop", 0, "普通直播间左上角关注", "left_up");
            LeftTop = r0;
            Scene r1 = new Scene("ProfileCard", 1, "资料卡关注", "personal_card");
            ProfileCard = r1;
            Scene r2 = new Scene("LongPressPanel", 2, "长按面板关注", "in_room_long_press");
            LongPressPanel = r2;
            Scene r3 = new Scene("EndRoomWidget", 3, "关播页关注主播", "live_end_head");
            EndRoomWidget = r3;
            Scene r5 = new Scene("JoinFansClubAutoFollow", 4, "加入粉丝团自动关注", "fansgroup");
            JoinFansClubAutoFollow = r5;
            Scene r7 = new Scene("MicRoomLeftTop", 5, "麦序房关注当前上麦主播", "mic_on");
            MicRoomLeftTop = r7;
            Scene r9 = new Scene("PK", 6, "pk关注对面主播", "pk_button");
            PK = r9;
            Scene r11 = new Scene("MULTI_ANCHOR", 7, "主播连线关注对面主播", "multi_window");
            MULTI_ANCHOR = r11;
            Scene r13 = new Scene("MEDIA_ANCHOR", 8, "媒体连线关注对面主播", "media_window");
            MEDIA_ANCHOR = r13;
            a = new Scene[]{r0, r1, r2, r3, r5, r7, r9, r11, r13};
        }

        public static Scene[] values() {
            return (Scene[]) a.clone();
        }

        public String getFollowEntrancePage() {
            return this.followEntrancePage;
        }

        public static Scene valueOf(String r1) {
            return (Scene) a.a(Scene.class, r1);
        }

        public Scene(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.description = r3;
            this.followEntrancePage = r4;
        }
    }

    public FollowLog(int r1) {
        this.d = r1;
    }

    public FollowLog(String r2, String r3) {
        this.d = -1;
        this.a = r2;
        this.b = r3;
    }

    public FollowLog(String r2, String r3, int r4) {
        this.d = -1;
        this.a = r2;
        this.b = String.valueOf(r3);
        this.d = r4;
    }
}
