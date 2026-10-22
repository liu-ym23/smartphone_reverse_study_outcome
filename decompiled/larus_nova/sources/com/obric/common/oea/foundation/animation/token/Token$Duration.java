package com.obric.common.oea.foundation.animation.token;

import com.ss.bduploader.UploadKeys;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"com/obric/common/oea/foundation/animation/token/Token$Duration", "", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "", "duration", "I", "getDuration", "()I", "stiffness", "getStiffness", "OUI_ANIMATION_DURATION_SHORT_1", "OUI_ANIMATION_DURATION_SHORT_2", "OUI_ANIMATION_DURATION_SHORT_3", "OUI_ANIMATION_DURATION_SHORT_4", "OUI_ANIMATION_DURATION_MEDIUM_1", "OUI_ANIMATION_DURATION_MEDIUM_2", "OUI_ANIMATION_DURATION_MEDIUM_3", "OUI_ANIMATION_DURATION_MEDIUM_4", "OUI_ANIMATION_DURATION_LONG_1", "OUI_ANIMATION_DURATION_LONG_2", "OUI_ANIMATION_DURATION_LONG_3", "OUI_ANIMATION_DURATION_LONG_4", "OUI_ANIMATION_DURATION_VERY_LONG_1", "OUI_ANIMATION_DURATION_VERY_LONG_2", "OUI_ANIMATION_DURATION_VERY_LONG_3", "OUI_ANIMATION_DURATION_VERY_LONG_4", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum Token$Duration extends Enum<Token$Duration> {
    public static final Token$Duration OUI_ANIMATION_DURATION_LONG_1 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_LONG_2 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_LONG_3 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_LONG_4 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_MEDIUM_1 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_MEDIUM_2 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_MEDIUM_3 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_MEDIUM_4 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_SHORT_1 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_SHORT_2 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_SHORT_3 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_SHORT_4 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_VERY_LONG_1 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_VERY_LONG_2 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_VERY_LONG_3 = null;
    public static final Token$Duration OUI_ANIMATION_DURATION_VERY_LONG_4 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Token$Duration[] f396406a = null;
    private final int duration;
    private final int stiffness;

    public static Token$Duration valueOf(String r100) {
        return (Token$Duration) a.a(Token$Duration.class, r100);
    }

    public static Token$Duration[] values() {
        return (Token$Duration[]) f396406a.clone();
    }

    static {
        Token$Duration r100 = new Token$Duration("OUI_ANIMATION_DURATION_SHORT_1", 0, 50, 15791);
        OUI_ANIMATION_DURATION_SHORT_1 = r100;
        Token$Duration r101 = new Token$Duration("OUI_ANIMATION_DURATION_SHORT_2", 1, 100, 3948);
        OUI_ANIMATION_DURATION_SHORT_2 = r101;
        Token$Duration r102 = new Token$Duration("OUI_ANIMATION_DURATION_SHORT_3", 2, 150, 1755);
        OUI_ANIMATION_DURATION_SHORT_3 = r102;
        Token$Duration r103 = new Token$Duration("OUI_ANIMATION_DURATION_SHORT_4", 3, 200, 987);
        OUI_ANIMATION_DURATION_SHORT_4 = r103;
        Token$Duration r104 = new Token$Duration("OUI_ANIMATION_DURATION_MEDIUM_1", 4, 250, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_OPENED_TIME);
        OUI_ANIMATION_DURATION_MEDIUM_1 = r104;
        Token$Duration r105 = new Token$Duration("OUI_ANIMATION_DURATION_MEDIUM_2", 5, 300, UploadKeys.KeyIsEnd2EndEncryptionOption);
        OUI_ANIMATION_DURATION_MEDIUM_2 = r105;
        Token$Duration r106 = new Token$Duration("OUI_ANIMATION_DURATION_MEDIUM_3", 6, TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG, 322);
        OUI_ANIMATION_DURATION_MEDIUM_3 = r106;
        Token$Duration r107 = new Token$Duration("OUI_ANIMATION_DURATION_MEDIUM_4", 7, 400, 247);
        OUI_ANIMATION_DURATION_MEDIUM_4 = r107;
        Token$Duration r108 = new Token$Duration("OUI_ANIMATION_DURATION_LONG_1", 8, 450, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO);
        OUI_ANIMATION_DURATION_LONG_1 = r108;
        Token$Duration r109 = new Token$Duration("OUI_ANIMATION_DURATION_LONG_2", 9, 500, 158);
        OUI_ANIMATION_DURATION_LONG_2 = r109;
        Token$Duration r110 = new Token$Duration("OUI_ANIMATION_DURATION_LONG_3", 10, 550, 131);
        OUI_ANIMATION_DURATION_LONG_3 = r110;
        Token$Duration r111 = new Token$Duration("OUI_ANIMATION_DURATION_LONG_4", 11, 600, 110);
        OUI_ANIMATION_DURATION_LONG_4 = r111;
        Token$Duration r112 = new Token$Duration("OUI_ANIMATION_DURATION_VERY_LONG_1", 12, 700, 81);
        OUI_ANIMATION_DURATION_VERY_LONG_1 = r112;
        Token$Duration r113 = new Token$Duration("OUI_ANIMATION_DURATION_VERY_LONG_2", 13, 800, 62);
        OUI_ANIMATION_DURATION_VERY_LONG_2 = r113;
        Token$Duration r114 = new Token$Duration("OUI_ANIMATION_DURATION_VERY_LONG_3", 14, 900, 49);
        OUI_ANIMATION_DURATION_VERY_LONG_3 = r114;
        Token$Duration r115 = new Token$Duration("OUI_ANIMATION_DURATION_VERY_LONG_4", 15, 1000, 39);
        OUI_ANIMATION_DURATION_VERY_LONG_4 = r115;
        f396406a = new Token$Duration[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getStiffness() {
        return this.stiffness;
    }

    public Token$Duration(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.duration = r102;
        this.stiffness = r103;
    }
}
