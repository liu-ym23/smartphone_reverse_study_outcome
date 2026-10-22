package com.larus.audio.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/tts/DowngradeType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TTS_SOFT_DOWNGRADE", "TTS_AUTOPLAY_DOWNGRADE", "TTS_MANUALPLAY_DOWNGRADE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum DowngradeType extends Enum<DowngradeType> {
    public static final DowngradeType TTS_AUTOPLAY_DOWNGRADE = null;
    public static final DowngradeType TTS_MANUALPLAY_DOWNGRADE = null;
    public static final DowngradeType TTS_SOFT_DOWNGRADE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DowngradeType[] f289825a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289826b = null;
    private final String type;

    public static EnumEntries<DowngradeType> getEntries() {
        return f289826b;
    }

    static {
        DowngradeType r100 = new DowngradeType("TTS_SOFT_DOWNGRADE", 0, "tts_soft_downgrade");
        TTS_SOFT_DOWNGRADE = r100;
        DowngradeType r101 = new DowngradeType("TTS_AUTOPLAY_DOWNGRADE", 1, "tts_autoplay_downgrade");
        TTS_AUTOPLAY_DOWNGRADE = r101;
        DowngradeType r102 = new DowngradeType("TTS_MANUALPLAY_DOWNGRADE", 2, "tts_manualplay_downgrade");
        TTS_MANUALPLAY_DOWNGRADE = r102;
        DowngradeType[] r103 = {r100, r101, r102};
        f289825a = r103;
        f289826b = EnumEntriesKt.enumEntries(r103);
    }

    public static DowngradeType[] values() {
        return (DowngradeType[]) f289825a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static DowngradeType valueOf(String r100) {
        return (DowngradeType) r27.a.a(DowngradeType.class, r100);
    }

    public DowngradeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
