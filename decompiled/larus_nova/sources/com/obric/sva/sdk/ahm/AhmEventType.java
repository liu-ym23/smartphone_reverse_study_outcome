package com.obric.sva.sdk.ahm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/sva/sdk/ahm/AhmEventType;", "", "eventType", "", "<init>", "(Ljava/lang/String;II)V", "getEventType", "()I", "SOUND_TRIGGER", "BACK_TRACE", "AAD_DETECTION", "OTHER_REC", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AhmEventType extends Enum<AhmEventType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AhmEventType[] $VALUES = null;
    public static final AhmEventType AAD_DETECTION = null;
    public static final AhmEventType BACK_TRACE = null;
    public static final AhmEventType OTHER_REC = null;
    public static final AhmEventType SOUND_TRIGGER = null;
    private final int eventType;

    private static final /* synthetic */ AhmEventType[] $values() {
        return new AhmEventType[]{SOUND_TRIGGER, BACK_TRACE, AAD_DETECTION, OTHER_REC};
    }

    public static EnumEntries<AhmEventType> getEntries() {
        return $ENTRIES;
    }

    static {
        SOUND_TRIGGER = new AhmEventType("SOUND_TRIGGER", 0, 1);
        BACK_TRACE = new AhmEventType("BACK_TRACE", 1, 2);
        AAD_DETECTION = new AhmEventType("AAD_DETECTION", 2, 3);
        OTHER_REC = new AhmEventType("OTHER_REC", 3, 4);
        AhmEventType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static AhmEventType[] values() {
        return (AhmEventType[]) $VALUES.clone();
    }

    public final int getEventType() {
        return this.eventType;
    }

    public static AhmEventType valueOf(String r100) {
        return (AhmEventType) a.a(AhmEventType.class, r100);
    }

    private AhmEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.eventType = r102;
    }
}
