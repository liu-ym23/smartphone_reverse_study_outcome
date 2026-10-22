package com.larus.doc.impl.offline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/impl/offline/CreateDocByMessageActionType;", "", "<init>", "(Ljava/lang/String;I)V", "FORMAL", "COMPENSATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateDocByMessageActionType extends Enum<CreateDocByMessageActionType> {
    public static final CreateDocByMessageActionType COMPENSATE = null;
    public static final CreateDocByMessageActionType FORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateDocByMessageActionType[] f331206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331207b = null;

    public static EnumEntries<CreateDocByMessageActionType> getEntries() {
        return f331207b;
    }

    static {
        CreateDocByMessageActionType r100 = new CreateDocByMessageActionType("FORMAL", 0);
        FORMAL = r100;
        CreateDocByMessageActionType r101 = new CreateDocByMessageActionType("COMPENSATE", 1);
        COMPENSATE = r101;
        CreateDocByMessageActionType[] r102 = {r100, r101};
        f331206a = r102;
        f331207b = EnumEntriesKt.enumEntries(r102);
    }

    public static CreateDocByMessageActionType[] values() {
        return (CreateDocByMessageActionType[]) f331206a.clone();
    }

    public static CreateDocByMessageActionType valueOf(String r100) {
        return (CreateDocByMessageActionType) r27.a.a(CreateDocByMessageActionType.class, r100);
    }

    public CreateDocByMessageActionType(String r100, int r101) {
        super(r100, r101);
    }
}
