package com.ss.android.lark.image.api;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum DataSource extends Enum<DataSource> {
    public static final DataSource DATA_DISK_CACHE = null;
    public static final DataSource LOCAL = null;
    public static final DataSource MEMORY_CACHE = null;
    public static final DataSource REMOTE = null;
    public static final DataSource RESOURCE_DISK_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataSource[] f426215a = null;

    static {
        DataSource r100 = new DataSource(AccountType.LOCAL, 0);
        LOCAL = r100;
        DataSource r101 = new DataSource("REMOTE", 1);
        REMOTE = r101;
        DataSource r102 = new DataSource("DATA_DISK_CACHE", 2);
        DATA_DISK_CACHE = r102;
        DataSource r103 = new DataSource("RESOURCE_DISK_CACHE", 3);
        RESOURCE_DISK_CACHE = r103;
        DataSource r104 = new DataSource("MEMORY_CACHE", 4);
        MEMORY_CACHE = r104;
        f426215a = new DataSource[]{r100, r101, r102, r103, r104};
    }

    public static DataSource[] values() {
        return (DataSource[]) f426215a.clone();
    }

    public static DataSource fromOrdinal(int r100) {
        DataSource[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        DataSource r104 = r101[r103];
        if (r104.ordinal() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return LOCAL;
    }

    public static DataSource valueOf(String r100) {
        return (DataSource) a.a(DataSource.class, r100);
    }

    public DataSource(String r100, int r101) {
        super(r100, r101);
    }
}
