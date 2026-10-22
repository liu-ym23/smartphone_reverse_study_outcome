package com.larus.office.plugins.offline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/office/plugins/offline/OfficeCreateDocByMessageActionType;", "", "<init>", "(Ljava/lang/String;I)V", "FORMAL", "COMPENSATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeCreateDocByMessageActionType extends Enum<OfficeCreateDocByMessageActionType> {
    public static final OfficeCreateDocByMessageActionType COMPENSATE = null;
    public static final OfficeCreateDocByMessageActionType FORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeCreateDocByMessageActionType[] f363055a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f363056b = null;

    public static EnumEntries<OfficeCreateDocByMessageActionType> getEntries() {
        return f363056b;
    }

    static {
        OfficeCreateDocByMessageActionType r100 = new OfficeCreateDocByMessageActionType("FORMAL", 0);
        FORMAL = r100;
        OfficeCreateDocByMessageActionType r101 = new OfficeCreateDocByMessageActionType("COMPENSATE", 1);
        COMPENSATE = r101;
        OfficeCreateDocByMessageActionType[] r102 = {r100, r101};
        f363055a = r102;
        f363056b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeCreateDocByMessageActionType[] values() {
        return (OfficeCreateDocByMessageActionType[]) f363055a.clone();
    }

    public static OfficeCreateDocByMessageActionType valueOf(String r100) {
        return (OfficeCreateDocByMessageActionType) r27.a.a(OfficeCreateDocByMessageActionType.class, r100);
    }

    public OfficeCreateDocByMessageActionType(String r100, int r101) {
        super(r100, r101);
    }
}
