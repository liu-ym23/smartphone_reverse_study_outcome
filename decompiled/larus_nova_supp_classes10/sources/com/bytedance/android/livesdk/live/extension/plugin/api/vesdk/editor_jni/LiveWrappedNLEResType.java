package com.bytedance.android.livesdk.live.extension.plugin.api.vesdk.editor_jni;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b;\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/vesdk/editor_jni/LiveWrappedNLEResType;", "", "", "swigValue", "I", "a", "NONE", "DRAFT", "VIDEO", "AUDIO", "IMAGE", "TRANSITION", "EFFECT", "FILTER", "STICKER", "FLOWER", "FONT", "SRT", "ADJUST", "ANIMATION_STICKER", "ANIMATION_VIDEO", "MASK", "PIN", "INFO_STICKER", "IMAGE_STICKER", "TEXT_STICKER", "SUBTITLE_STICKER", "EMOJI_STICKER", "TIME_EFFECT", "CHER_EFFECT", "CHROMA", "ANIMATION_TEXT", "LYRIC_STICKER", "COMPOSER", "AUTOSUBTITLE_STICKER", "TEXT_TEMPLATE", "MIX_MODE", "BUBBLE", "TEXT_SHAPE", "BEAUTY", "SOUND", "RECORD", "ALGORITHM_MV_AUDIO", "MUSIC_MV_AUDIO", "NORMAL_MV_AUDIO", "VOICE_CHANGER_FILTER", "KARAOKE_USER_AUDIO", "ALGORITHM_AUDIO", "AUDIO_DSP_FILTER", "IMAGE_RAW", "EFFECT_STICKER", "AI_MATTING", "AUTO_FILL_FRAME", "CHART_DATA", "COMPOSITE", "ANIMATION_VIDEO_IN", "ANIMATION_VIDEO_OUT", "ANIMATION_VIDEO_COMBO", "PREFAB_STICKER", "NEW_TEXT_TEMPLATE", "TEXT_EMPHASIS", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedNLEResType extends Enum<LiveWrappedNLEResType> {
    public static final LiveWrappedNLEResType ADJUST = null;
    public static final LiveWrappedNLEResType AI_MATTING = null;
    public static final LiveWrappedNLEResType ALGORITHM_AUDIO = null;
    public static final LiveWrappedNLEResType ALGORITHM_MV_AUDIO = null;
    public static final LiveWrappedNLEResType ANIMATION_STICKER = null;
    public static final LiveWrappedNLEResType ANIMATION_TEXT = null;
    public static final LiveWrappedNLEResType ANIMATION_VIDEO = null;
    public static final LiveWrappedNLEResType ANIMATION_VIDEO_COMBO = null;
    public static final LiveWrappedNLEResType ANIMATION_VIDEO_IN = null;
    public static final LiveWrappedNLEResType ANIMATION_VIDEO_OUT = null;
    public static final LiveWrappedNLEResType AUDIO = null;
    public static final LiveWrappedNLEResType AUDIO_DSP_FILTER = null;
    public static final LiveWrappedNLEResType AUTOSUBTITLE_STICKER = null;
    public static final LiveWrappedNLEResType AUTO_FILL_FRAME = null;
    public static final LiveWrappedNLEResType BEAUTY = null;
    public static final LiveWrappedNLEResType BUBBLE = null;
    public static final LiveWrappedNLEResType CHART_DATA = null;
    public static final LiveWrappedNLEResType CHER_EFFECT = null;
    public static final LiveWrappedNLEResType CHROMA = null;
    public static final LiveWrappedNLEResType COMPOSER = null;
    public static final LiveWrappedNLEResType COMPOSITE = null;
    public static final LiveWrappedNLEResType DRAFT = null;
    public static final LiveWrappedNLEResType EFFECT = null;
    public static final LiveWrappedNLEResType EFFECT_STICKER = null;
    public static final LiveWrappedNLEResType EMOJI_STICKER = null;
    public static final LiveWrappedNLEResType FILTER = null;
    public static final LiveWrappedNLEResType FLOWER = null;
    public static final LiveWrappedNLEResType FONT = null;
    public static final LiveWrappedNLEResType IMAGE = null;
    public static final LiveWrappedNLEResType IMAGE_RAW = null;
    public static final LiveWrappedNLEResType IMAGE_STICKER = null;
    public static final LiveWrappedNLEResType INFO_STICKER = null;
    public static final LiveWrappedNLEResType KARAOKE_USER_AUDIO = null;
    public static final LiveWrappedNLEResType LYRIC_STICKER = null;
    public static final LiveWrappedNLEResType MASK = null;
    public static final LiveWrappedNLEResType MIX_MODE = null;
    public static final LiveWrappedNLEResType MUSIC_MV_AUDIO = null;
    public static final LiveWrappedNLEResType NEW_TEXT_TEMPLATE = null;
    public static final LiveWrappedNLEResType NONE = null;
    public static final LiveWrappedNLEResType NORMAL_MV_AUDIO = null;
    public static final LiveWrappedNLEResType PIN = null;
    public static final LiveWrappedNLEResType PREFAB_STICKER = null;
    public static final LiveWrappedNLEResType RECORD = null;
    public static final LiveWrappedNLEResType SOUND = null;
    public static final LiveWrappedNLEResType SRT = null;
    public static final LiveWrappedNLEResType STICKER = null;
    public static final LiveWrappedNLEResType SUBTITLE_STICKER = null;
    public static final LiveWrappedNLEResType TEXT_EMPHASIS = null;
    public static final LiveWrappedNLEResType TEXT_SHAPE = null;
    public static final LiveWrappedNLEResType TEXT_STICKER = null;
    public static final LiveWrappedNLEResType TEXT_TEMPLATE = null;
    public static final LiveWrappedNLEResType TIME_EFFECT = null;
    public static final LiveWrappedNLEResType TRANSITION = null;
    public static final LiveWrappedNLEResType VIDEO = null;
    public static final LiveWrappedNLEResType VOICE_CHANGER_FILTER = null;
    public static final /* synthetic */ LiveWrappedNLEResType[] a = null;
    private final int swigValue;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static LiveWrappedNLEResType valueOf(String r1) {
        return (LiveWrappedNLEResType) r27.a.a(LiveWrappedNLEResType.class, r1);
    }

    public static LiveWrappedNLEResType[] values() {
        return (LiveWrappedNLEResType[]) a.clone();
    }

    static {
        LiveWrappedNLEResType r1 = new LiveWrappedNLEResType("NONE", 0, 0);
        NONE = r1;
        LiveWrappedNLEResType r2 = new LiveWrappedNLEResType("DRAFT", 1, 1);
        DRAFT = r2;
        LiveWrappedNLEResType r3 = new LiveWrappedNLEResType("VIDEO", 2, 2);
        VIDEO = r3;
        LiveWrappedNLEResType r4 = new LiveWrappedNLEResType("AUDIO", 3, 3);
        AUDIO = r4;
        LiveWrappedNLEResType r5 = new LiveWrappedNLEResType("IMAGE", 4, 4);
        IMAGE = r5;
        LiveWrappedNLEResType r6 = new LiveWrappedNLEResType("TRANSITION", 5, 5);
        TRANSITION = r6;
        LiveWrappedNLEResType r7 = new LiveWrappedNLEResType("EFFECT", 6, 6);
        EFFECT = r7;
        LiveWrappedNLEResType r8 = new LiveWrappedNLEResType("FILTER", 7, 7);
        FILTER = r8;
        LiveWrappedNLEResType r9 = new LiveWrappedNLEResType("STICKER", 8, 8);
        STICKER = r9;
        LiveWrappedNLEResType r10 = new LiveWrappedNLEResType("FLOWER", 9, 9);
        FLOWER = r10;
        LiveWrappedNLEResType r11 = new LiveWrappedNLEResType("FONT", 10, 10);
        FONT = r11;
        LiveWrappedNLEResType r12 = new LiveWrappedNLEResType("SRT", 11, 11);
        SRT = r12;
        LiveWrappedNLEResType r13 = new LiveWrappedNLEResType("ADJUST", 12, 12);
        ADJUST = r13;
        LiveWrappedNLEResType r14 = new LiveWrappedNLEResType("ANIMATION_STICKER", 13, 15);
        ANIMATION_STICKER = r14;
        LiveWrappedNLEResType r15 = new LiveWrappedNLEResType("ANIMATION_VIDEO", 14, 16);
        ANIMATION_VIDEO = r15;
        LiveWrappedNLEResType r16 = new LiveWrappedNLEResType("MASK", 15, 17);
        MASK = r16;
        LiveWrappedNLEResType r17 = new LiveWrappedNLEResType("PIN", 16, 18);
        PIN = r17;
        LiveWrappedNLEResType r18 = new LiveWrappedNLEResType("INFO_STICKER", 17, 19);
        INFO_STICKER = r18;
        LiveWrappedNLEResType r19 = new LiveWrappedNLEResType("IMAGE_STICKER", 18, 20);
        IMAGE_STICKER = r19;
        LiveWrappedNLEResType r20 = new LiveWrappedNLEResType("TEXT_STICKER", 19, 21);
        TEXT_STICKER = r20;
        LiveWrappedNLEResType r21 = new LiveWrappedNLEResType("SUBTITLE_STICKER", 20, 22);
        SUBTITLE_STICKER = r21;
        LiveWrappedNLEResType r22 = new LiveWrappedNLEResType("EMOJI_STICKER", 21, 23);
        EMOJI_STICKER = r22;
        LiveWrappedNLEResType r23 = new LiveWrappedNLEResType("TIME_EFFECT", 22, 24);
        TIME_EFFECT = r23;
        LiveWrappedNLEResType r24 = new LiveWrappedNLEResType("CHER_EFFECT", 23, 25);
        CHER_EFFECT = r24;
        LiveWrappedNLEResType r25 = new LiveWrappedNLEResType("CHROMA", 24, 26);
        CHROMA = r25;
        LiveWrappedNLEResType r26 = new LiveWrappedNLEResType("ANIMATION_TEXT", 25, 27);
        ANIMATION_TEXT = r26;
        LiveWrappedNLEResType r27 = new LiveWrappedNLEResType("LYRIC_STICKER", 26, 28);
        LYRIC_STICKER = r27;
        LiveWrappedNLEResType r28 = new LiveWrappedNLEResType("COMPOSER", 27, 29);
        COMPOSER = r28;
        LiveWrappedNLEResType r29 = new LiveWrappedNLEResType("AUTOSUBTITLE_STICKER", 28, 30);
        AUTOSUBTITLE_STICKER = r29;
        LiveWrappedNLEResType r30 = new LiveWrappedNLEResType("TEXT_TEMPLATE", 29, 31);
        TEXT_TEMPLATE = r30;
        LiveWrappedNLEResType r31 = new LiveWrappedNLEResType("MIX_MODE", 30, 32);
        MIX_MODE = r31;
        LiveWrappedNLEResType r32 = new LiveWrappedNLEResType("BUBBLE", 31, 33);
        BUBBLE = r32;
        LiveWrappedNLEResType r33 = new LiveWrappedNLEResType("TEXT_SHAPE", 32, 34);
        TEXT_SHAPE = r33;
        LiveWrappedNLEResType r34 = new LiveWrappedNLEResType("BEAUTY", 33, 35);
        BEAUTY = r34;
        LiveWrappedNLEResType r35 = new LiveWrappedNLEResType("SOUND", 34, 36);
        SOUND = r35;
        LiveWrappedNLEResType r36 = new LiveWrappedNLEResType("RECORD", 35, 37);
        RECORD = r36;
        LiveWrappedNLEResType r37 = new LiveWrappedNLEResType("ALGORITHM_MV_AUDIO", 36, 38);
        ALGORITHM_MV_AUDIO = r37;
        LiveWrappedNLEResType r38 = new LiveWrappedNLEResType("MUSIC_MV_AUDIO", 37, 39);
        MUSIC_MV_AUDIO = r38;
        LiveWrappedNLEResType r39 = new LiveWrappedNLEResType("NORMAL_MV_AUDIO", 38, 40);
        NORMAL_MV_AUDIO = r39;
        LiveWrappedNLEResType r40 = new LiveWrappedNLEResType("VOICE_CHANGER_FILTER", 39, 41);
        VOICE_CHANGER_FILTER = r40;
        LiveWrappedNLEResType r41 = new LiveWrappedNLEResType("KARAOKE_USER_AUDIO", 40, 42);
        KARAOKE_USER_AUDIO = r41;
        LiveWrappedNLEResType r42 = new LiveWrappedNLEResType("ALGORITHM_AUDIO", 41, 43);
        ALGORITHM_AUDIO = r42;
        LiveWrappedNLEResType r43 = new LiveWrappedNLEResType("AUDIO_DSP_FILTER", 42, 44);
        AUDIO_DSP_FILTER = r43;
        LiveWrappedNLEResType r44 = new LiveWrappedNLEResType("IMAGE_RAW", 43, 45);
        IMAGE_RAW = r44;
        LiveWrappedNLEResType r45 = new LiveWrappedNLEResType("EFFECT_STICKER", 44, 46);
        EFFECT_STICKER = r45;
        LiveWrappedNLEResType r46 = new LiveWrappedNLEResType("AI_MATTING", 45, 47);
        AI_MATTING = r46;
        LiveWrappedNLEResType r47 = new LiveWrappedNLEResType("AUTO_FILL_FRAME", 46, 48);
        AUTO_FILL_FRAME = r47;
        LiveWrappedNLEResType r48 = new LiveWrappedNLEResType("CHART_DATA", 47, 49);
        CHART_DATA = r48;
        LiveWrappedNLEResType r49 = new LiveWrappedNLEResType("COMPOSITE", 48, 50);
        COMPOSITE = r49;
        LiveWrappedNLEResType r50 = new LiveWrappedNLEResType("ANIMATION_VIDEO_IN", 49, 51);
        ANIMATION_VIDEO_IN = r50;
        LiveWrappedNLEResType r51 = new LiveWrappedNLEResType("ANIMATION_VIDEO_OUT", 50, 52);
        ANIMATION_VIDEO_OUT = r51;
        LiveWrappedNLEResType r52 = new LiveWrappedNLEResType("ANIMATION_VIDEO_COMBO", 51, 53);
        ANIMATION_VIDEO_COMBO = r52;
        LiveWrappedNLEResType r53 = new LiveWrappedNLEResType("PREFAB_STICKER", 52, 54);
        PREFAB_STICKER = r53;
        LiveWrappedNLEResType r54 = new LiveWrappedNLEResType("NEW_TEXT_TEMPLATE", 53, 55);
        NEW_TEXT_TEMPLATE = r54;
        LiveWrappedNLEResType r55 = new LiveWrappedNLEResType("TEXT_EMPHASIS", 54, 56);
        TEXT_EMPHASIS = r55;
        a = new LiveWrappedNLEResType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55};
    }

    public LiveWrappedNLEResType(String r1, int r2, int r3) {
        super(r1, r2);
        this.swigValue = r3;
        int r4 = a.a;
    }
}
