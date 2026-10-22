package com.larus.ugc.feed.impl.quickmenu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/ugc/feed/impl/quickmenu/DismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL_BUTTON", "ITEM_CLICK", "OUTSIDE_TOUCH", "BACK_PRESS", "PROGRAMMATIC", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DismissReason extends Enum<DismissReason> {
    public static final DismissReason BACK_PRESS = null;
    public static final DismissReason CANCEL_BUTTON = null;
    public static final DismissReason ITEM_CLICK = null;
    public static final DismissReason OUTSIDE_TOUCH = null;
    public static final DismissReason PROGRAMMATIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DismissReason[] f374852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f374853b = null;

    public static EnumEntries<DismissReason> getEntries() {
        return f374853b;
    }

    static {
        DismissReason r100 = new DismissReason("CANCEL_BUTTON", 0);
        CANCEL_BUTTON = r100;
        DismissReason r101 = new DismissReason("ITEM_CLICK", 1);
        ITEM_CLICK = r101;
        DismissReason r102 = new DismissReason("OUTSIDE_TOUCH", 2);
        OUTSIDE_TOUCH = r102;
        DismissReason r103 = new DismissReason("BACK_PRESS", 3);
        BACK_PRESS = r103;
        DismissReason r104 = new DismissReason("PROGRAMMATIC", 4);
        PROGRAMMATIC = r104;
        DismissReason[] r105 = {r100, r101, r102, r103, r104};
        f374852a = r105;
        f374853b = EnumEntriesKt.enumEntries(r105);
    }

    public static DismissReason[] values() {
        return (DismissReason[]) f374852a.clone();
    }

    public static DismissReason valueOf(String r100) {
        return (DismissReason) r27.a.a(DismissReason.class, r100);
    }

    public DismissReason(String r100, int r101) {
        super(r100, r101);
    }
}
