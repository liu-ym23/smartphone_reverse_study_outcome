package com.obric.sva.sdk.session;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/sva/sdk/session/SessionType;", "", "tag", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "VOICE", "BREATH", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SessionType extends Enum<SessionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SessionType[] $VALUES = null;
    public static final SessionType BREATH = null;
    public static final SessionType VOICE = null;
    private final String tag;

    private static final /* synthetic */ SessionType[] $values() {
        return new SessionType[]{VOICE, BREATH};
    }

    public static EnumEntries<SessionType> getEntries() {
        return $ENTRIES;
    }

    static {
        VOICE = new SessionType("VOICE", 0, "VOICE");
        BREATH = new SessionType("BREATH", 1, "BREATH");
        SessionType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SessionType[] values() {
        return (SessionType[]) $VALUES.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public static SessionType valueOf(String r100) {
        return (SessionType) r27.a.a(SessionType.class, r100);
    }

    private SessionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
