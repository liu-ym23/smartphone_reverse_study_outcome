package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: classes24.dex */
public final enum GrantRecordType extends Enum<GrantRecordType> {
    public static final GrantRecordType AppAdmin = null;
    public static final GrantRecordType Brother = null;
    public static final GrantRecordType Department = null;
    public static final GrantRecordType Entity = null;
    public static final GrantRecordType Group = null;
    public static final GrantRecordType Leader = null;
    public static final GrantRecordType None = null;
    public static final GrantRecordType TenantAdmin = null;
    public static final GrantRecordType User = null;
    public static final GrantRecordType VGroup = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrantRecordType[] f282984a = null;
    private int value;

    static {
        GrantRecordType r100 = new GrantRecordType("None", 0, 0);
        None = r100;
        GrantRecordType r101 = new GrantRecordType("User", 1, 1);
        User = r101;
        GrantRecordType r102 = new GrantRecordType("Department", 2, 2);
        Department = r102;
        GrantRecordType r103 = new GrantRecordType("Leader", 3, 3);
        Leader = r103;
        GrantRecordType r104 = new GrantRecordType("Brother", 4, 4);
        Brother = r104;
        GrantRecordType r105 = new GrantRecordType("TenantAdmin", 5, 5);
        TenantAdmin = r105;
        GrantRecordType r110 = new GrantRecordType("AppAdmin", 6, 6);
        AppAdmin = r110;
        GrantRecordType r111 = new GrantRecordType("VGroup", 7, 7);
        VGroup = r111;
        GrantRecordType r112 = new GrantRecordType("Group", 8, 101);
        Group = r112;
        GrantRecordType r113 = new GrantRecordType("Entity", 9, 102);
        Entity = r113;
        f282984a = new GrantRecordType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static GrantRecordType[] values() {
        return (GrantRecordType[]) f282984a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static GrantRecordType forNumber(int r100) {
        if (r100 == 101) goto L28;
        if (r100 == 102) goto L26;
        switch(r100) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            default: goto L7;
        };
    L7:
        return null;
    L10:
        return VGroup;
    L12:
        return AppAdmin;
    L14:
        return TenantAdmin;
    L16:
        return Brother;
    L18:
        return Leader;
    L20:
        return Department;
    L22:
        return User;
    L24:
        return None;
    L26:
        return Entity;
    L28:
        return Group;
    }

    public static GrantRecordType valueOf(String r100) {
        return (GrantRecordType) r27.a.a(GrantRecordType.class, r100);
    }

    public static GrantRecordType valueOf(int r100) {
        return forNumber(r100);
    }

    public GrantRecordType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
