package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/ota/g2/UserChoice;", "", "<init>", "(Ljava/lang/String;I)V", "UNSET", "ON", "OFF", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserChoice extends Enum<UserChoice> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UserChoice[] $VALUES = null;
    public static final UserChoice OFF = null;
    public static final UserChoice ON = null;
    public static final UserChoice UNSET = null;

    public static EnumEntries<UserChoice> getEntries() {
        return $ENTRIES;
    }

    static {
        UserChoice r100 = new UserChoice("UNSET", 0);
        UNSET = r100;
        UserChoice r101 = new UserChoice("ON", 1);
        ON = r101;
        UserChoice r102 = new UserChoice("OFF", 2);
        OFF = r102;
        UserChoice[] r103 = {r100, r101, r102};
        $VALUES = r103;
        $ENTRIES = EnumEntriesKt.enumEntries(r103);
    }

    public static UserChoice[] values() {
        return (UserChoice[]) $VALUES.clone();
    }

    public static UserChoice valueOf(String r100) {
        return (UserChoice) r27.a.a(UserChoice.class, r100);
    }

    public UserChoice(String r100, int r101) {
        super(r100, r101);
    }
}
