package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/chat/gallery/api/SelectResultReason;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "LIMIT_REACHED", "ITEM_NOT_FOUND", "NOT_SUPPORTED", "REJECTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectResultReason extends Enum<SelectResultReason> {
    public static final SelectResultReason ITEM_NOT_FOUND = null;
    public static final SelectResultReason LIMIT_REACHED = null;
    public static final SelectResultReason NOT_SUPPORTED = null;
    public static final SelectResultReason OK = null;
    public static final SelectResultReason REJECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectResultReason[] f324122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324123b = null;

    public static EnumEntries<SelectResultReason> getEntries() {
        return f324123b;
    }

    static {
        SelectResultReason r100 = new SelectResultReason("OK", 0);
        OK = r100;
        SelectResultReason r101 = new SelectResultReason("LIMIT_REACHED", 1);
        LIMIT_REACHED = r101;
        SelectResultReason r102 = new SelectResultReason("ITEM_NOT_FOUND", 2);
        ITEM_NOT_FOUND = r102;
        SelectResultReason r103 = new SelectResultReason("NOT_SUPPORTED", 3);
        NOT_SUPPORTED = r103;
        SelectResultReason r104 = new SelectResultReason("REJECTED", 4);
        REJECTED = r104;
        SelectResultReason[] r105 = {r100, r101, r102, r103, r104};
        f324122a = r105;
        f324123b = EnumEntriesKt.enumEntries(r105);
    }

    public static SelectResultReason[] values() {
        return (SelectResultReason[]) f324122a.clone();
    }

    public static SelectResultReason valueOf(String r100) {
        return (SelectResultReason) r27.a.a(SelectResultReason.class, r100);
    }

    public SelectResultReason(String r100, int r101) {
        super(r100, r101);
    }
}
