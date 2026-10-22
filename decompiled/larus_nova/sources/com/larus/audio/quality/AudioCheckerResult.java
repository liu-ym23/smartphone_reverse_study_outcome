package com.larus.audio.quality;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/quality/AudioCheckerResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "INTERNAL_ERROR", "NETWORK_ERROR", "PASSED", "SNR_FAILED", "WER_FAILED", "INIT_CONFIG_ERROR", "INIT_METRIC_ERROR", "AUDIO_RECORD_SILENCED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioCheckerResult extends Enum<AudioCheckerResult> {
    public static final AudioCheckerResult AUDIO_RECORD_SILENCED = null;
    public static final AudioCheckerResult INIT_CONFIG_ERROR = null;
    public static final AudioCheckerResult INIT_METRIC_ERROR = null;
    public static final AudioCheckerResult INTERNAL_ERROR = null;
    public static final AudioCheckerResult NETWORK_ERROR = null;
    public static final AudioCheckerResult PASSED = null;
    public static final AudioCheckerResult SNR_FAILED = null;
    public static final AudioCheckerResult WER_FAILED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioCheckerResult[] f289774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289775b = null;

    public static EnumEntries<AudioCheckerResult> getEntries() {
        return f289775b;
    }

    static {
        AudioCheckerResult r100 = new AudioCheckerResult("INTERNAL_ERROR", 0);
        INTERNAL_ERROR = r100;
        AudioCheckerResult r101 = new AudioCheckerResult("NETWORK_ERROR", 1);
        NETWORK_ERROR = r101;
        AudioCheckerResult r102 = new AudioCheckerResult("PASSED", 2);
        PASSED = r102;
        AudioCheckerResult r103 = new AudioCheckerResult("SNR_FAILED", 3);
        SNR_FAILED = r103;
        AudioCheckerResult r104 = new AudioCheckerResult("WER_FAILED", 4);
        WER_FAILED = r104;
        AudioCheckerResult r105 = new AudioCheckerResult("INIT_CONFIG_ERROR", 5);
        INIT_CONFIG_ERROR = r105;
        AudioCheckerResult r110 = new AudioCheckerResult("INIT_METRIC_ERROR", 6);
        INIT_METRIC_ERROR = r110;
        AudioCheckerResult r111 = new AudioCheckerResult("AUDIO_RECORD_SILENCED", 7);
        AUDIO_RECORD_SILENCED = r111;
        AudioCheckerResult[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f289774a = r112;
        f289775b = EnumEntriesKt.enumEntries(r112);
    }

    public static AudioCheckerResult[] values() {
        return (AudioCheckerResult[]) f289774a.clone();
    }

    public static AudioCheckerResult valueOf(String r100) {
        return (AudioCheckerResult) a.a(AudioCheckerResult.class, r100);
    }

    public AudioCheckerResult(String r100, int r101) {
        super(r100, r101);
    }
}
