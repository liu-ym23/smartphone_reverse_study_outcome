package com.bytedance.live.livelink.kmp.impl.base.liveclient;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/base/liveclient/VideoMixerDescriptionType;", "", EffectConstants.NORMAL, "FILL", "LEFT_HALF", "RIGHT_HALF", "LEFT_UP", "LEFT_DOWN", "RIGHT_UP", "RIGHT_DOWN", "CENTER", "INVISIABLE", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VideoMixerDescriptionType extends Enum<VideoMixerDescriptionType> {
    public static final VideoMixerDescriptionType CENTER = null;
    public static final VideoMixerDescriptionType FILL = null;
    public static final VideoMixerDescriptionType INVISIABLE = null;
    public static final VideoMixerDescriptionType LEFT_DOWN = null;
    public static final VideoMixerDescriptionType LEFT_HALF = null;
    public static final VideoMixerDescriptionType LEFT_UP = null;
    public static final VideoMixerDescriptionType NORMAL = null;
    public static final VideoMixerDescriptionType RIGHT_DOWN = null;
    public static final VideoMixerDescriptionType RIGHT_HALF = null;
    public static final VideoMixerDescriptionType RIGHT_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoMixerDescriptionType[] f255283a = null;

    static {
        VideoMixerDescriptionType r100 = new VideoMixerDescriptionType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        VideoMixerDescriptionType r101 = new VideoMixerDescriptionType("FILL", 1);
        FILL = r101;
        VideoMixerDescriptionType r102 = new VideoMixerDescriptionType("LEFT_HALF", 2);
        LEFT_HALF = r102;
        VideoMixerDescriptionType r103 = new VideoMixerDescriptionType("RIGHT_HALF", 3);
        RIGHT_HALF = r103;
        VideoMixerDescriptionType r104 = new VideoMixerDescriptionType("LEFT_UP", 4);
        LEFT_UP = r104;
        VideoMixerDescriptionType r105 = new VideoMixerDescriptionType("LEFT_DOWN", 5);
        LEFT_DOWN = r105;
        VideoMixerDescriptionType r106 = new VideoMixerDescriptionType("RIGHT_UP", 6);
        RIGHT_UP = r106;
        VideoMixerDescriptionType r107 = new VideoMixerDescriptionType("RIGHT_DOWN", 7);
        RIGHT_DOWN = r107;
        VideoMixerDescriptionType r108 = new VideoMixerDescriptionType("CENTER", 8);
        CENTER = r108;
        VideoMixerDescriptionType r109 = new VideoMixerDescriptionType("INVISIABLE", 9);
        INVISIABLE = r109;
        f255283a = new VideoMixerDescriptionType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static VideoMixerDescriptionType valueOf(String r100) {
        return (VideoMixerDescriptionType) a.a(VideoMixerDescriptionType.class, r100);
    }

    public static VideoMixerDescriptionType[] values() {
        return (VideoMixerDescriptionType[]) f255283a.clone();
    }

    public VideoMixerDescriptionType(String r100, int r101) {
        super(r100, r101);
    }
}
