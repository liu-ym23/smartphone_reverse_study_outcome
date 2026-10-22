package com.obric.sva.sdk.sami;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/sva/sdk/sami/WakeupBusinessType;", "", "includeModelInfo", "", "uploadFilePrefix", "", "<init>", "(Ljava/lang/String;IZLjava/lang/String;)V", "getIncludeModelInfo", "()Z", "getUploadFilePrefix", "()Ljava/lang/String;", "VOICE", "BREATH", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WakeupBusinessType extends Enum<WakeupBusinessType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WakeupBusinessType[] $VALUES = null;
    public static final WakeupBusinessType BREATH = null;
    public static final WakeupBusinessType VOICE = null;
    private final boolean includeModelInfo;
    private final String uploadFilePrefix;

    private static final /* synthetic */ WakeupBusinessType[] $values() {
        return new WakeupBusinessType[]{VOICE, BREATH};
    }

    public static EnumEntries<WakeupBusinessType> getEntries() {
        return $ENTRIES;
    }

    static {
        VOICE = new WakeupBusinessType("VOICE", 0, true, "voice_wakeup_");
        BREATH = new WakeupBusinessType("BREATH", 1, false, "breath_wakeup_");
        WakeupBusinessType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static WakeupBusinessType[] values() {
        return (WakeupBusinessType[]) $VALUES.clone();
    }

    public final boolean getIncludeModelInfo() {
        return this.includeModelInfo;
    }

    public final String getUploadFilePrefix() {
        return this.uploadFilePrefix;
    }

    public static WakeupBusinessType valueOf(String r100) {
        return (WakeupBusinessType) r27.a.a(WakeupBusinessType.class, r100);
    }

    private WakeupBusinessType(String r100, int r101, boolean r102, String r103) {
        super(r100, r101);
        this.includeModelInfo = r102;
        this.uploadFilePrefix = r103;
    }
}
