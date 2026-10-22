package org.apache.commons.compress.archivers.dump;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum DumpArchiveEntry$PERMISSION extends Enum<DumpArchiveEntry$PERMISSION> {
    private static final /* synthetic */ DumpArchiveEntry$PERMISSION[] $VALUES = null;
    public static final DumpArchiveEntry$PERMISSION GROUP_EXEC = null;
    public static final DumpArchiveEntry$PERMISSION GROUP_READ = null;
    public static final DumpArchiveEntry$PERMISSION GROUP_WRITE = null;
    public static final DumpArchiveEntry$PERMISSION SETGUI = null;
    public static final DumpArchiveEntry$PERMISSION SETUID = null;
    public static final DumpArchiveEntry$PERMISSION STICKY = null;
    public static final DumpArchiveEntry$PERMISSION USER_EXEC = null;
    public static final DumpArchiveEntry$PERMISSION USER_READ = null;
    public static final DumpArchiveEntry$PERMISSION USER_WRITE = null;
    public static final DumpArchiveEntry$PERMISSION WORLD_EXEC = null;
    public static final DumpArchiveEntry$PERMISSION WORLD_READ = null;
    public static final DumpArchiveEntry$PERMISSION WORLD_WRITE = null;
    private int code;

    static {
        DumpArchiveEntry$PERMISSION r100 = new DumpArchiveEntry$PERMISSION("SETUID", 0, 2048);
        SETUID = r100;
        DumpArchiveEntry$PERMISSION r101 = new DumpArchiveEntry$PERMISSION("SETGUI", 1, 1024);
        SETGUI = r101;
        DumpArchiveEntry$PERMISSION r102 = new DumpArchiveEntry$PERMISSION("STICKY", 2, 512);
        STICKY = r102;
        DumpArchiveEntry$PERMISSION r103 = new DumpArchiveEntry$PERMISSION("USER_READ", 3, 256);
        USER_READ = r103;
        DumpArchiveEntry$PERMISSION r104 = new DumpArchiveEntry$PERMISSION("USER_WRITE", 4, 128);
        USER_WRITE = r104;
        DumpArchiveEntry$PERMISSION r105 = new DumpArchiveEntry$PERMISSION("USER_EXEC", 5, 64);
        USER_EXEC = r105;
        DumpArchiveEntry$PERMISSION r110 = new DumpArchiveEntry$PERMISSION("GROUP_READ", 6, 32);
        GROUP_READ = r110;
        DumpArchiveEntry$PERMISSION r111 = new DumpArchiveEntry$PERMISSION("GROUP_WRITE", 7, 16);
        GROUP_WRITE = r111;
        DumpArchiveEntry$PERMISSION r112 = new DumpArchiveEntry$PERMISSION("GROUP_EXEC", 8, 8);
        GROUP_EXEC = r112;
        DumpArchiveEntry$PERMISSION r113 = new DumpArchiveEntry$PERMISSION("WORLD_READ", 9, 4);
        WORLD_READ = r113;
        DumpArchiveEntry$PERMISSION r114 = new DumpArchiveEntry$PERMISSION("WORLD_WRITE", 10, 2);
        WORLD_WRITE = r114;
        DumpArchiveEntry$PERMISSION r106 = new DumpArchiveEntry$PERMISSION("WORLD_EXEC", 11, 1);
        WORLD_EXEC = r106;
        $VALUES = new DumpArchiveEntry$PERMISSION[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
    }

    public static DumpArchiveEntry$PERMISSION[] values() {
        return (DumpArchiveEntry$PERMISSION[]) $VALUES.clone();
    }

    public static Set<DumpArchiveEntry$PERMISSION> find(int r100) {
        HashSet r101 = new HashSet();
        DumpArchiveEntry$PERMISSION[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        DumpArchiveEntry$PERMISSION r105 = r102[r104];
        int r106 = r105.code;
        if ((r100 & r106) != r106) goto L7;
        r101.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L9:
        if (r101.isEmpty() == false) goto L13;
        return Collections.emptySet();
    L13:
        return EnumSet.copyOf(r101);
    }

    public static DumpArchiveEntry$PERMISSION valueOf(String r100) {
        return (DumpArchiveEntry$PERMISSION) a.a(DumpArchiveEntry$PERMISSION.class, r100);
    }

    private DumpArchiveEntry$PERMISSION(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
