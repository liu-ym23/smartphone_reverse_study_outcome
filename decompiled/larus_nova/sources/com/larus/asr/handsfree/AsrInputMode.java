package com.larus.asr.handsfree;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/asr/handsfree/AsrInputMode;", "", "<init>", "(Ljava/lang/String;I)V", "LONG_PRESS", "HANDSFREE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrInputMode extends Enum<AsrInputMode> {
    public static final AsrInputMode HANDSFREE = null;
    public static final AsrInputMode LONG_PRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrInputMode[] f287291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f287292b = null;

    public static EnumEntries<AsrInputMode> getEntries() {
        return f287292b;
    }

    static {
        AsrInputMode r100 = new AsrInputMode("LONG_PRESS", 0);
        LONG_PRESS = r100;
        AsrInputMode r101 = new AsrInputMode("HANDSFREE", 1);
        HANDSFREE = r101;
        AsrInputMode[] r102 = {r100, r101};
        f287291a = r102;
        f287292b = EnumEntriesKt.enumEntries(r102);
    }

    public static AsrInputMode[] values() {
        return (AsrInputMode[]) f287291a.clone();
    }

    public static AsrInputMode valueOf(String r100) {
        return (AsrInputMode) r27.a.a(AsrInputMode.class, r100);
    }

    public AsrInputMode(String r100, int r101) {
        super(r100, r101);
    }
}
