package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/HeadsetPromptSource;", "", "<init>", "(Ljava/lang/String;I)V", "AI_ENABLED", "AUDIO_SAVE_CHANGED", "AUDIO_ROUTE_CHANGED", "PLAYBACK_VOLUME_CHANGED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HeadsetPromptSource extends Enum<HeadsetPromptSource> {
    public static final HeadsetPromptSource AI_ENABLED = null;
    public static final HeadsetPromptSource AUDIO_ROUTE_CHANGED = null;
    public static final HeadsetPromptSource AUDIO_SAVE_CHANGED = null;
    public static final HeadsetPromptSource PLAYBACK_VOLUME_CHANGED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeadsetPromptSource[] f434724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434725b = null;

    public static EnumEntries<HeadsetPromptSource> getEntries() {
        return f434725b;
    }

    static {
        HeadsetPromptSource r100 = new HeadsetPromptSource("AI_ENABLED", 0);
        AI_ENABLED = r100;
        HeadsetPromptSource r101 = new HeadsetPromptSource("AUDIO_SAVE_CHANGED", 1);
        AUDIO_SAVE_CHANGED = r101;
        HeadsetPromptSource r102 = new HeadsetPromptSource("AUDIO_ROUTE_CHANGED", 2);
        AUDIO_ROUTE_CHANGED = r102;
        HeadsetPromptSource r103 = new HeadsetPromptSource("PLAYBACK_VOLUME_CHANGED", 3);
        PLAYBACK_VOLUME_CHANGED = r103;
        HeadsetPromptSource[] r104 = {r100, r101, r102, r103};
        f434724a = r104;
        f434725b = EnumEntriesKt.enumEntries(r104);
    }

    public static HeadsetPromptSource[] values() {
        return (HeadsetPromptSource[]) f434724a.clone();
    }

    public static HeadsetPromptSource valueOf(String r100) {
        return (HeadsetPromptSource) r27.a.a(HeadsetPromptSource.class, r100);
    }

    public HeadsetPromptSource(String r100, int r101) {
        super(r100, r101);
    }
}
