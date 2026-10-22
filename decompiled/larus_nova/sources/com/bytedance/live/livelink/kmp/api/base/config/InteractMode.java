package com.bytedance.live.livelink.kmp.api.base.config;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/config/InteractMode;", "", "", "toString", "", "value", "I", "getValue", "()I", "nameStr", "Ljava/lang/String;", "getNameStr", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PK", EffectConstants.NORMAL, "FM", "VIDEO_TALK", "VIDEO_TALK_CAMERA", "MULTI_ANCHOR", "SHARE_VIDEO", "SHARE_VIDEO_PRI", "KTV", "KTV_CAMERA", "KTV_PRI", "EQUAL_TALK_ROOM", "MVP", "GAME_AUDIO", "PK_CROSS", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum InteractMode extends Enum<InteractMode> {
    public static final a Companion = null;
    public static final InteractMode EQUAL_TALK_ROOM = null;
    public static final InteractMode FM = null;
    public static final InteractMode GAME_AUDIO = null;
    public static final InteractMode KTV = null;
    public static final InteractMode KTV_CAMERA = null;
    public static final InteractMode KTV_PRI = null;
    public static final InteractMode MULTI_ANCHOR = null;
    public static final InteractMode MVP = null;
    public static final InteractMode NORMAL = null;
    public static final InteractMode PK = null;
    public static final InteractMode PK_CROSS = null;
    public static final InteractMode SHARE_VIDEO = null;
    public static final InteractMode SHARE_VIDEO_PRI = null;
    public static final InteractMode VIDEO_TALK = null;
    public static final InteractMode VIDEO_TALK_CAMERA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InteractMode[] f255217a = null;
    private final String nameStr;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static InteractMode valueOf(String r100) {
        return (InteractMode) r27.a.a(InteractMode.class, r100);
    }

    public static InteractMode[] values() {
        return (InteractMode[]) f255217a.clone();
    }

    static {
        InteractMode r100 = new InteractMode("PK", 0, 0, PbRequest.SwitchType.PK);
        PK = r100;
        InteractMode r101 = new InteractMode(EffectConstants.NORMAL, 1, 1, "normal");
        NORMAL = r101;
        InteractMode r102 = new InteractMode("FM", 2, 2, "fm");
        FM = r102;
        InteractMode r103 = new InteractMode("VIDEO_TALK", 3, 3, LinkConstant.VIDEO_TALK);
        VIDEO_TALK = r103;
        InteractMode r104 = new InteractMode("VIDEO_TALK_CAMERA", 4, 4, "video_talk_camera");
        VIDEO_TALK_CAMERA = r104;
        InteractMode r105 = new InteractMode("MULTI_ANCHOR", 5, 5, "multi_anchor");
        MULTI_ANCHOR = r105;
        InteractMode r106 = new InteractMode("SHARE_VIDEO", 6, 6, "share_video");
        SHARE_VIDEO = r106;
        InteractMode r107 = new InteractMode("SHARE_VIDEO_PRI", 7, 7, "share_video_pri");
        SHARE_VIDEO_PRI = r107;
        InteractMode r108 = new InteractMode("KTV", 8, 8, "ktv");
        KTV = r108;
        InteractMode r109 = new InteractMode("KTV_CAMERA", 9, 9, "ktv_camera");
        KTV_CAMERA = r109;
        InteractMode r110 = new InteractMode("KTV_PRI", 10, 10, "ktv_pri");
        KTV_PRI = r110;
        InteractMode r111 = new InteractMode("EQUAL_TALK_ROOM", 11, 11, "equal_talk_room");
        EQUAL_TALK_ROOM = r111;
        InteractMode r112 = new InteractMode("MVP", 12, 12, "mvp");
        MVP = r112;
        InteractMode r113 = new InteractMode("GAME_AUDIO", 13, 13, "game_audio");
        GAME_AUDIO = r113;
        InteractMode r114 = new InteractMode("PK_CROSS", 14, 14, "pk_cross");
        PK_CROSS = r114;
        f255217a = new InteractMode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
        Companion = new a();
    }

    public final String getNameStr() {
        return this.nameStr;
    }

    public final int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.nameStr;
    }

    public InteractMode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.nameStr = r103;
    }
}
