package com.larus.login.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/login/api/DismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "Confirm", "Cancel", "Close", "Unknown", "NOT_HANDLED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DismissReason extends Enum<DismissReason> {
    public static final DismissReason Cancel = null;
    public static final DismissReason Close = null;
    public static final DismissReason Confirm = null;
    public static final DismissReason NOT_HANDLED = null;
    public static final DismissReason Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DismissReason[] f356976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f356977b = null;

    public static EnumEntries<DismissReason> getEntries() {
        return f356977b;
    }

    static {
        DismissReason r100 = new DismissReason("Confirm", 0);
        Confirm = r100;
        DismissReason r101 = new DismissReason("Cancel", 1);
        Cancel = r101;
        DismissReason r102 = new DismissReason("Close", 2);
        Close = r102;
        DismissReason r103 = new DismissReason("Unknown", 3);
        Unknown = r103;
        DismissReason r104 = new DismissReason("NOT_HANDLED", 4);
        NOT_HANDLED = r104;
        DismissReason[] r105 = {r100, r101, r102, r103, r104};
        f356976a = r105;
        f356977b = EnumEntriesKt.enumEntries(r105);
    }

    public static DismissReason[] values() {
        return (DismissReason[]) f356976a.clone();
    }

    public static DismissReason valueOf(String r100) {
        return (DismissReason) r27.a.a(DismissReason.class, r100);
    }

    public DismissReason(String r100, int r101) {
        super(r100, r101);
    }
}
