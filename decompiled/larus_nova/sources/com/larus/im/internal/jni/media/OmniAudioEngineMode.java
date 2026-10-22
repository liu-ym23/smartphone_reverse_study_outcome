package com.larus.im.internal.jni.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioEngineMode;", "", "<init>", "(Ljava/lang/String;I)V", "RECORD_AND_PLAY", "RECORD_ONLY", "PLAY_ONLY", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniAudioEngineMode extends Enum<OmniAudioEngineMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OmniAudioEngineMode[] $VALUES = null;
    public static final OmniAudioEngineMode PLAY_ONLY = null;
    public static final OmniAudioEngineMode RECORD_AND_PLAY = null;
    public static final OmniAudioEngineMode RECORD_ONLY = null;

    private static final /* synthetic */ OmniAudioEngineMode[] $values() {
        return new OmniAudioEngineMode[]{RECORD_AND_PLAY, RECORD_ONLY, PLAY_ONLY};
    }

    public static EnumEntries<OmniAudioEngineMode> getEntries() {
        return $ENTRIES;
    }

    static {
        RECORD_AND_PLAY = new OmniAudioEngineMode("RECORD_AND_PLAY", 0);
        RECORD_ONLY = new OmniAudioEngineMode("RECORD_ONLY", 1);
        PLAY_ONLY = new OmniAudioEngineMode("PLAY_ONLY", 2);
        OmniAudioEngineMode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OmniAudioEngineMode[] values() {
        return (OmniAudioEngineMode[]) $VALUES.clone();
    }

    public static OmniAudioEngineMode valueOf(String r100) {
        return (OmniAudioEngineMode) a.a(OmniAudioEngineMode.class, r100);
    }

    private OmniAudioEngineMode(String r100, int r101) {
        super(r100, r101);
    }
}
