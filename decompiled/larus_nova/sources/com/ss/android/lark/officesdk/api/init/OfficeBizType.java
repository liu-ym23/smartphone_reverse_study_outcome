package com.ss.android.lark.officesdk.api.init;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeBizType;", "", "<init>", "(Ljava/lang/String;I)V", "BASE", "IM", "CCM", "MINUTES", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeBizType extends Enum<OfficeBizType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OfficeBizType[] $VALUES = null;
    public static final OfficeBizType BASE = null;
    public static final OfficeBizType CCM = null;
    public static final OfficeBizType IM = null;
    public static final OfficeBizType MINUTES = null;

    private static final /* synthetic */ OfficeBizType[] $values() {
        return new OfficeBizType[]{BASE, IM, CCM, MINUTES};
    }

    public static EnumEntries<OfficeBizType> getEntries() {
        return $ENTRIES;
    }

    static {
        BASE = new OfficeBizType("BASE", 0);
        IM = new OfficeBizType("IM", 1);
        CCM = new OfficeBizType("CCM", 2);
        MINUTES = new OfficeBizType("MINUTES", 3);
        OfficeBizType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OfficeBizType[] values() {
        return (OfficeBizType[]) $VALUES.clone();
    }

    public static OfficeBizType valueOf(String r100) {
        return (OfficeBizType) a.a(OfficeBizType.class, r100);
    }

    private OfficeBizType(String r100, int r101) {
        super(r100, r101);
    }
}
