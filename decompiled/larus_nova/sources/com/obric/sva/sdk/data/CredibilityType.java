package com.obric.sva.sdk.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/sva/sdk/data/CredibilityType;", "", "<init>", "(Ljava/lang/String;I)V", "SUSPECT", "DOUBLE_CHECK", "TRUSTED", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CredibilityType extends Enum<CredibilityType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CredibilityType[] $VALUES = null;
    public static final CredibilityType DOUBLE_CHECK = null;
    public static final CredibilityType SUSPECT = null;
    public static final CredibilityType TRUSTED = null;

    private static final /* synthetic */ CredibilityType[] $values() {
        return new CredibilityType[]{SUSPECT, DOUBLE_CHECK, TRUSTED};
    }

    public static EnumEntries<CredibilityType> getEntries() {
        return $ENTRIES;
    }

    static {
        SUSPECT = new CredibilityType("SUSPECT", 0);
        DOUBLE_CHECK = new CredibilityType("DOUBLE_CHECK", 1);
        TRUSTED = new CredibilityType("TRUSTED", 2);
        CredibilityType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static CredibilityType[] values() {
        return (CredibilityType[]) $VALUES.clone();
    }

    public static CredibilityType valueOf(String r100) {
        return (CredibilityType) a.a(CredibilityType.class, r100);
    }

    private CredibilityType(String r100, int r101) {
        super(r100, r101);
    }
}
