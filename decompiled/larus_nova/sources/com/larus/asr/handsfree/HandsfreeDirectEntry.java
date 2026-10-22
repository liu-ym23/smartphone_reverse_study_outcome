package com.larus.asr.handsfree;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/asr/handsfree/HandsfreeDirectEntry;", "", "<init>", "(Ljava/lang/String;I)V", "MIC_ICON_CLICK", "VOICE_INPUT_BUTTON_PRESS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HandsfreeDirectEntry extends Enum<HandsfreeDirectEntry> {
    public static final HandsfreeDirectEntry MIC_ICON_CLICK = null;
    public static final HandsfreeDirectEntry VOICE_INPUT_BUTTON_PRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HandsfreeDirectEntry[] f287293a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287294b = null;

    public static EnumEntries<HandsfreeDirectEntry> getEntries() {
        return f287294b;
    }

    static {
        HandsfreeDirectEntry r100 = new HandsfreeDirectEntry("MIC_ICON_CLICK", 0);
        MIC_ICON_CLICK = r100;
        HandsfreeDirectEntry r101 = new HandsfreeDirectEntry("VOICE_INPUT_BUTTON_PRESS", 1);
        VOICE_INPUT_BUTTON_PRESS = r101;
        HandsfreeDirectEntry[] r102 = {r100, r101};
        f287293a = r102;
        f287294b = EnumEntriesKt.enumEntries(r102);
    }

    public static HandsfreeDirectEntry[] values() {
        return (HandsfreeDirectEntry[]) f287293a.clone();
    }

    public static HandsfreeDirectEntry valueOf(String r100) {
        return (HandsfreeDirectEntry) r27.a.a(HandsfreeDirectEntry.class, r100);
    }

    public HandsfreeDirectEntry(String r100, int r101) {
        super(r100, r101);
    }
}
