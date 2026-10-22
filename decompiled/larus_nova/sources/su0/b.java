package su0;

import com.bytedance.android.live.profit.miniplay.SupportLiveMode;
import com.bytedance.android.live.profit.miniplay.SupportLiveScene;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final int a(int r110, int r111) {
        if (r110 != SupportLiveMode.VIDEO.getValue()) goto L24;
        if (r111 == 0) goto L105;
        if (r111 == 1) goto L104;
        if (r111 == 2) goto L103;
        if (r111 == 4) goto L102;
        if (r111 == 12) goto L101;
        if (r111 == 7) goto L100;
        if (r111 == 8) goto L99;
        if (r111 == 16) goto L98;
        if (r111 == 17) goto L97;
        return SupportLiveScene.VIDEO_SINGLE_BROADCAST.getValue();
    L97:
        return SupportLiveScene.VIDEO_MEDIA_MULTI_ANCHOR.getValue();
    L98:
        return SupportLiveScene.VIDEO_LINK_ROOM.getValue();
    L99:
        return SupportLiveScene.VIDEO_CHAT_ROOM.getValue();
    L100:
        return SupportLiveScene.VIDEO_MULTI_ANCHOR_LINK.getValue();
    L101:
        return SupportLiveScene.VIDEO_EQUAL_CHAT_ROOM.getValue();
    L102:
        return SupportLiveScene.VIDEO_AUDIENCE_LINK.getValue();
    L103:
        return SupportLiveScene.VIDEO_DOUBLE_PLAYERS_PK.getValue();
    L104:
        return SupportLiveScene.VIDEO_DOUBLE_PLAYERS_PK.getValue();
    L105:
        return SupportLiveScene.VIDEO_SINGLE_BROADCAST.getValue();
    L24:
        if (r110 != SupportLiveMode.OBS.getValue()) goto L49;
        if (r111 == 0) goto L117;
        if (r111 == 1) goto L116;
        if (r111 == 2) goto L115;
        if (r111 == 4) goto L114;
        if (r111 == 5) goto L113;
        if (r111 == 7) goto L112;
        if (r111 == 8) goto L111;
        if (r111 == 9) goto L110;
        if (r111 == 12) goto L109;
        if (r111 == 16) goto L108;
        if (r111 == 17) goto L107;
        return SupportLiveScene.OBS_BROADCAST.getValue();
    L107:
        return SupportLiveScene.OBS_MEDIA_MULTI_ANCHOR.getValue();
    L108:
        return SupportLiveScene.OBS_LINK_ROOM.getValue();
    L109:
        return SupportLiveScene.OBS_EQUAL_CHAT_ROOM.getValue();
    L110:
        return SupportLiveScene.OBS_KTV_ROOM.getValue();
    L111:
        return SupportLiveScene.OBS_AUDIO_CHAT_ROOM.getValue();
    L112:
        return SupportLiveScene.OBS_MULTI_ANCHOR_LINK.getValue();
    L113:
        return SupportLiveScene.OBS_VIDEO_CHAT_ROOM.getValue();
    L114:
        return SupportLiveScene.OBS_AUDIENCE_LINK.getValue();
    L115:
        return SupportLiveScene.OBS_DOUBLE_PLAYERS_PK.getValue();
    L116:
        return SupportLiveScene.OBS_DOUBLE_PLAYERS_PK.getValue();
    L117:
        return SupportLiveScene.OBS_BROADCAST.getValue();
    L49:
        if (r110 != SupportLiveMode.AUDIO.getValue()) goto L64;
        if (r111 == 0) goto L124;
        if (r111 == 1) goto L123;
        if (r111 == 2) goto L122;
        if (r111 == 5) goto L121;
        if (r111 == 9) goto L120;
        if (r111 == 16) goto L119;
        return SupportLiveScene.AUDIO_SINGLE_BROADCAST.getValue();
    L119:
        return SupportLiveScene.AUDIO_LINK_ROOM.getValue();
    L120:
        return SupportLiveScene.AUDIO_KTV_ROOM.getValue();
    L121:
        return SupportLiveScene.AUDIO_CHAT_ROOM.getValue();
    L122:
        return SupportLiveScene.AUDIO_DOUBLE_PLAYERS_PK.getValue();
    L123:
        return SupportLiveScene.AUDIO_DOUBLE_PLAYERS_PK.getValue();
    L124:
        return SupportLiveScene.AUDIO_SINGLE_BROADCAST.getValue();
    L64:
        if (r110 != SupportLiveMode.SCREEN_RECORD.getValue()) goto L80;
        if (r111 == 0) goto L128;
        if (r111 == 1) goto L127;
        if (r111 == 2) goto L127;
        if (r111 == 4) goto L127;
        if (r111 == 5) goto L127;
        if (r111 == 7) goto L127;
        if (r111 == 8) goto L127;
        if (r111 == 9) goto L127;
        if (r111 == 14) goto L126;
        return SupportLiveScene.SCREEN_RECORD.getValue();
    L126:
        return SupportLiveScene.SCREEN_RECORD_LINK.getValue();
    L127:
        return SupportLiveScene.UNKNOWN_SCENE.getValue();
    L128:
        return SupportLiveScene.SCREEN_RECORD.getValue();
    L80:
        if (r110 != SupportLiveMode.MEDIA.getValue()) goto L95;
        if (r111 == 0) goto L132;
        if (r111 == 1) goto L131;
        if (r111 == 2) goto L131;
        if (r111 == 4) goto L131;
        if (r111 == 5) goto L131;
        if (r111 == 7) goto L131;
        if (r111 == 8) goto L131;
        if (r111 == 9) goto L131;
        if (r111 == 17) goto L130;
        return SupportLiveScene.MEDIA_BROADCAST.getValue();
    L130:
        return SupportLiveScene.MEDIA_MULTI_ANCHOR.getValue();
    L131:
        return SupportLiveScene.UNKNOWN_SCENE.getValue();
    L132:
        return SupportLiveScene.MEDIA_BROADCAST.getValue();
    L95:
        return SupportLiveScene.UNKNOWN_SCENE.getValue();
    }
}
