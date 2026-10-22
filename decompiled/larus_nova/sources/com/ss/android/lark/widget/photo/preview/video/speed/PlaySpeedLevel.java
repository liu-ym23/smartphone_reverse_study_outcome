package com.ss.android.lark.widget.photo.preview.video.speed;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/video/speed/PlaySpeedLevel;", "", SocialConstants.PARAM_APP_DESC, "", "speed", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;F)V", "getDesc", "()Ljava/lang/String;", "getSpeed", "()F", "LEVEL_VERY_SLOW", "LEVEL_SLOW", "LEVEL_NORMAL", "LEVEL_FAST", "LEVEL_VERY_FAST", "LEVEL_2X", "LEVEL_3X", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlaySpeedLevel extends Enum<PlaySpeedLevel> {
    public static final PlaySpeedLevel LEVEL_2X = null;
    public static final PlaySpeedLevel LEVEL_3X = null;
    public static final PlaySpeedLevel LEVEL_FAST = null;
    public static final PlaySpeedLevel LEVEL_NORMAL = null;
    public static final PlaySpeedLevel LEVEL_SLOW = null;
    public static final PlaySpeedLevel LEVEL_VERY_FAST = null;
    public static final PlaySpeedLevel LEVEL_VERY_SLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlaySpeedLevel[] f447427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f447428b = null;
    private final String desc;
    private final float speed;

    public static EnumEntries<PlaySpeedLevel> getEntries() {
        return f447428b;
    }

    static {
        PlaySpeedLevel r100 = new PlaySpeedLevel("LEVEL_VERY_SLOW", 0, "0.5x", 0.5f);
        LEVEL_VERY_SLOW = r100;
        PlaySpeedLevel r101 = new PlaySpeedLevel("LEVEL_SLOW", 1, "0.75x", 0.75f);
        LEVEL_SLOW = r101;
        PlaySpeedLevel r102 = new PlaySpeedLevel("LEVEL_NORMAL", 2, "1x", 1.0f);
        LEVEL_NORMAL = r102;
        PlaySpeedLevel r103 = new PlaySpeedLevel("LEVEL_FAST", 3, "1.25x", 1.25f);
        LEVEL_FAST = r103;
        PlaySpeedLevel r104 = new PlaySpeedLevel("LEVEL_VERY_FAST", 4, "1.5x", 1.5f);
        LEVEL_VERY_FAST = r104;
        PlaySpeedLevel r105 = new PlaySpeedLevel("LEVEL_2X", 5, "2x", 2.0f);
        LEVEL_2X = r105;
        PlaySpeedLevel r106 = new PlaySpeedLevel("LEVEL_3X", 6, "3x", 3.0f);
        LEVEL_3X = r106;
        PlaySpeedLevel[] r110 = {r100, r101, r102, r103, r104, r105, r106};
        f447427a = r110;
        f447428b = EnumEntriesKt.enumEntries(r110);
    }

    public static PlaySpeedLevel[] values() {
        return (PlaySpeedLevel[]) f447427a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public static PlaySpeedLevel valueOf(String r100) {
        return (PlaySpeedLevel) a.a(PlaySpeedLevel.class, r100);
    }

    public PlaySpeedLevel(String r100, int r101, String r102, float r103) {
        super(r100, r101);
        this.desc = r102;
        this.speed = r103;
    }
}
