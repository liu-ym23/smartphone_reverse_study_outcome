package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedVoiceReverbType;", "", "", "value", "I", "Companion", "a", "VOICE_REVERB_ORIGINAL", "VOICE_REVERB_ECHO", "VOICE_REVERB_CONCERT", "VOICE_REVERB_ETHEREAL", "VOICE_REVERB_KTV", "VOICE_REVERB_STUDIO", "VOICE_REVERB_VIRTUAL_STEREO", "VOICE_REVERB_SPACIOUS", "VOICE_REVERB_3D", "VOICE_REVERB_POP", "VOICE_REVERB_DISCO", "VOICE_REVERB_OLDRECORD", "VOICE_REVERB_HARMONY", "VOICE_REVERB_ROCK", "VOICE_REVERB_BLUES", "VOICE_REVERB_JAZZ", "VOICE_REVERB_ELECTRONIC", "VOICE_REVERB_VINYL", "VOICE_REVERB_CHAMBER", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedVoiceReverbType extends Enum<LiveWrappedVoiceReverbType> {
    public static final a Companion = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_3D = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_BLUES = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_CHAMBER = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_CONCERT = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_DISCO = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ECHO = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ELECTRONIC = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ETHEREAL = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_HARMONY = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_JAZZ = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_KTV = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_OLDRECORD = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ORIGINAL = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_POP = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_ROCK = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_SPACIOUS = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_STUDIO = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_VINYL = null;
    public static final LiveWrappedVoiceReverbType VOICE_REVERB_VIRTUAL_STEREO = null;
    public static final /* synthetic */ LiveWrappedVoiceReverbType[] a = null;
    private final int value;

    public static LiveWrappedVoiceReverbType valueOf(String r1) {
        return (LiveWrappedVoiceReverbType) r27.a.a(LiveWrappedVoiceReverbType.class, r1);
    }

    public static LiveWrappedVoiceReverbType[] values() {
        return (LiveWrappedVoiceReverbType[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedVoiceReverbType$a] */
    static {
        LiveWrappedVoiceReverbType r1 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ORIGINAL", 0, 0);
        VOICE_REVERB_ORIGINAL = r1;
        LiveWrappedVoiceReverbType r2 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ECHO", 1, 1);
        VOICE_REVERB_ECHO = r2;
        LiveWrappedVoiceReverbType r3 = new LiveWrappedVoiceReverbType("VOICE_REVERB_CONCERT", 2, 2);
        VOICE_REVERB_CONCERT = r3;
        LiveWrappedVoiceReverbType r4 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ETHEREAL", 3, 3);
        VOICE_REVERB_ETHEREAL = r4;
        LiveWrappedVoiceReverbType r5 = new LiveWrappedVoiceReverbType("VOICE_REVERB_KTV", 4, 4);
        VOICE_REVERB_KTV = r5;
        LiveWrappedVoiceReverbType r6 = new LiveWrappedVoiceReverbType("VOICE_REVERB_STUDIO", 5, 5);
        VOICE_REVERB_STUDIO = r6;
        LiveWrappedVoiceReverbType r7 = new LiveWrappedVoiceReverbType("VOICE_REVERB_VIRTUAL_STEREO", 6, 6);
        VOICE_REVERB_VIRTUAL_STEREO = r7;
        LiveWrappedVoiceReverbType r8 = new LiveWrappedVoiceReverbType("VOICE_REVERB_SPACIOUS", 7, 7);
        VOICE_REVERB_SPACIOUS = r8;
        LiveWrappedVoiceReverbType r9 = new LiveWrappedVoiceReverbType("VOICE_REVERB_3D", 8, 8);
        VOICE_REVERB_3D = r9;
        LiveWrappedVoiceReverbType r10 = new LiveWrappedVoiceReverbType("VOICE_REVERB_POP", 9, 9);
        VOICE_REVERB_POP = r10;
        LiveWrappedVoiceReverbType r11 = new LiveWrappedVoiceReverbType("VOICE_REVERB_DISCO", 10, 10);
        VOICE_REVERB_DISCO = r11;
        LiveWrappedVoiceReverbType r12 = new LiveWrappedVoiceReverbType("VOICE_REVERB_OLDRECORD", 11, 11);
        VOICE_REVERB_OLDRECORD = r12;
        LiveWrappedVoiceReverbType r13 = new LiveWrappedVoiceReverbType("VOICE_REVERB_HARMONY", 12, 12);
        VOICE_REVERB_HARMONY = r13;
        LiveWrappedVoiceReverbType r14 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ROCK", 13, 13);
        VOICE_REVERB_ROCK = r14;
        LiveWrappedVoiceReverbType r15 = new LiveWrappedVoiceReverbType("VOICE_REVERB_BLUES", 14, 14);
        VOICE_REVERB_BLUES = r15;
        LiveWrappedVoiceReverbType r16 = new LiveWrappedVoiceReverbType("VOICE_REVERB_JAZZ", 15, 15);
        VOICE_REVERB_JAZZ = r16;
        LiveWrappedVoiceReverbType r17 = new LiveWrappedVoiceReverbType("VOICE_REVERB_ELECTRONIC", 16, 16);
        VOICE_REVERB_ELECTRONIC = r17;
        LiveWrappedVoiceReverbType r18 = new LiveWrappedVoiceReverbType("VOICE_REVERB_VINYL", 17, 17);
        VOICE_REVERB_VINYL = r18;
        LiveWrappedVoiceReverbType r19 = new LiveWrappedVoiceReverbType("VOICE_REVERB_CHAMBER", 18, 18);
        VOICE_REVERB_CHAMBER = r19;
        a = new LiveWrappedVoiceReverbType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedVoiceReverbType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
