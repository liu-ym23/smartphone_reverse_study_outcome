package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/service/audio/AvAudioKitMode;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "PURE_RTC", "PURE_BIZ", "PURE_AV", "MIX_SPEECH_BIZ", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvAudioKitMode extends Enum<AvAudioKitMode> {
    public static final AvAudioKitMode MIX_SPEECH_BIZ = null;
    public static final AvAudioKitMode PURE_AV = null;
    public static final AvAudioKitMode PURE_BIZ = null;
    public static final AvAudioKitMode PURE_RTC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvAudioKitMode[] f350633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350634b = null;
    private final String type;

    public static EnumEntries<AvAudioKitMode> getEntries() {
        return f350634b;
    }

    static {
        AvAudioKitMode r100 = new AvAudioKitMode("PURE_RTC", 0, "pure_rtc");
        PURE_RTC = r100;
        AvAudioKitMode r101 = new AvAudioKitMode("PURE_BIZ", 1, "pure_biz");
        PURE_BIZ = r101;
        AvAudioKitMode r102 = new AvAudioKitMode("PURE_AV", 2, "pure_av");
        PURE_AV = r102;
        AvAudioKitMode r103 = new AvAudioKitMode("MIX_SPEECH_BIZ", 3, "mix_speech_biz");
        MIX_SPEECH_BIZ = r103;
        AvAudioKitMode[] r104 = {r100, r101, r102, r103};
        f350633a = r104;
        f350634b = EnumEntriesKt.enumEntries(r104);
    }

    public static AvAudioKitMode[] values() {
        return (AvAudioKitMode[]) f350633a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static AvAudioKitMode valueOf(String r100) {
        return (AvAudioKitMode) r27.a.a(AvAudioKitMode.class, r100);
    }

    public AvAudioKitMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
