package com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalAudioSourceMode;", "", "<init>", "(Ljava/lang/String;I)V", "PCM_PULL", "PCM_PUSH", "ENCODED_PULL", "ENCODED_PUSH", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExternalAudioSourceMode extends Enum<ExternalAudioSourceMode> {
    public static final ExternalAudioSourceMode ENCODED_PULL = null;
    public static final ExternalAudioSourceMode ENCODED_PUSH = null;
    public static final ExternalAudioSourceMode PCM_PULL = null;
    public static final ExternalAudioSourceMode PCM_PUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalAudioSourceMode[] f433563a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433564b = null;

    public static EnumEntries<ExternalAudioSourceMode> getEntries() {
        return f433564b;
    }

    static {
        ExternalAudioSourceMode r100 = new ExternalAudioSourceMode("PCM_PULL", 0);
        PCM_PULL = r100;
        ExternalAudioSourceMode r101 = new ExternalAudioSourceMode("PCM_PUSH", 1);
        PCM_PUSH = r101;
        ExternalAudioSourceMode r102 = new ExternalAudioSourceMode("ENCODED_PULL", 2);
        ENCODED_PULL = r102;
        ExternalAudioSourceMode r103 = new ExternalAudioSourceMode("ENCODED_PUSH", 3);
        ENCODED_PUSH = r103;
        ExternalAudioSourceMode[] r104 = {r100, r101, r102, r103};
        f433563a = r104;
        f433564b = EnumEntriesKt.enumEntries(r104);
    }

    public static ExternalAudioSourceMode[] values() {
        return (ExternalAudioSourceMode[]) f433563a.clone();
    }

    public static ExternalAudioSourceMode valueOf(String r100) {
        return (ExternalAudioSourceMode) a.a(ExternalAudioSourceMode.class, r100);
    }

    public ExternalAudioSourceMode(String r100, int r101) {
        super(r100, r101);
    }
}
