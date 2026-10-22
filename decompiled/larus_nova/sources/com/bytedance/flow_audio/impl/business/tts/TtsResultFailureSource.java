package com.bytedance.flow_audio.impl.business.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/flow_audio/impl/business/tts/TtsResultFailureSource;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE_TERMINAL_CALLBACK", "LOCAL_OPERATION", "flow_audio_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum TtsResultFailureSource extends Enum<TtsResultFailureSource> {
    public static final TtsResultFailureSource LOCAL_OPERATION = null;
    public static final TtsResultFailureSource NATIVE_TERMINAL_CALLBACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsResultFailureSource[] f244079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f244080b = null;

    public static EnumEntries<TtsResultFailureSource> getEntries() {
        return f244080b;
    }

    static {
        TtsResultFailureSource r100 = new TtsResultFailureSource("NATIVE_TERMINAL_CALLBACK", 0);
        NATIVE_TERMINAL_CALLBACK = r100;
        TtsResultFailureSource r101 = new TtsResultFailureSource("LOCAL_OPERATION", 1);
        LOCAL_OPERATION = r101;
        TtsResultFailureSource[] r102 = {r100, r101};
        f244079a = r102;
        f244080b = EnumEntriesKt.enumEntries(r102);
    }

    public static TtsResultFailureSource[] values() {
        return (TtsResultFailureSource[]) f244079a.clone();
    }

    public static TtsResultFailureSource valueOf(String r100) {
        return (TtsResultFailureSource) r27.a.a(TtsResultFailureSource.class, r100);
    }

    public TtsResultFailureSource(String r100, int r101) {
        super(r100, r101);
    }
}
