package com.bytedance.ies.ugc.aweme.plugin.entrance;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum EntryType extends Enum<EntryType> {
    public static final EntryType FROM_JS_BRIDGE = null;
    public static final EntryType FROM_ROUTER = null;
    public static final EntryType FROM_SCHEMA = null;
    public static final EntryType ON_CLICK_EVENT = null;
    public static final EntryType ON_PAGE_CREATE = null;
    public static final EntryType OTHERS = null;
    public static final EntryType PASSIVE_DISPLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntryType[] f248938a = null;

    static {
        EntryType r100 = new EntryType("ON_CLICK_EVENT", 0);
        ON_CLICK_EVENT = r100;
        EntryType r101 = new EntryType("ON_PAGE_CREATE", 1);
        ON_PAGE_CREATE = r101;
        EntryType r102 = new EntryType("FROM_JS_BRIDGE", 2);
        FROM_JS_BRIDGE = r102;
        EntryType r103 = new EntryType("FROM_SCHEMA", 3);
        FROM_SCHEMA = r103;
        EntryType r104 = new EntryType("FROM_ROUTER", 4);
        FROM_ROUTER = r104;
        EntryType r105 = new EntryType("PASSIVE_DISPLAY", 5);
        PASSIVE_DISPLAY = r105;
        EntryType r110 = new EntryType(AccountType.OTHERS, 6);
        OTHERS = r110;
        f248938a = new EntryType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static EntryType[] values() {
        return (EntryType[]) f248938a.clone();
    }

    public static EntryType valueOf(String r100) {
        return (EntryType) a.a(EntryType.class, r100);
    }

    public EntryType(String r100, int r101) {
        super(r100, r101);
    }
}
