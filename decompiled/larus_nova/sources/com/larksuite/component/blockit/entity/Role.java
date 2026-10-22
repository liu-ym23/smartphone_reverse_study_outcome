package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: classes24.dex */
public final enum Role extends Enum<Role> {
    public static final Role Member = null;
    public static final Role None = null;
    public static final Role Owner = null;
    public static final Role Viewer = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Role[] f282985a = null;
    private int value;

    static {
        Role r100 = new Role("None", 0, 0);
        None = r100;
        Role r101 = new Role("Owner", 1, 1);
        Owner = r101;
        Role r102 = new Role("Member", 2, 2);
        Member = r102;
        Role r103 = new Role("Viewer", 3, 3);
        Viewer = r103;
        f282985a = new Role[]{r100, r101, r102, r103};
    }

    public static Role[] values() {
        return (Role[]) f282985a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static Role forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return Viewer;
    L14:
        return Member;
    L16:
        return Owner;
    L18:
        return None;
    }

    public static Role valueOf(String r100) {
        return (Role) r27.a.a(Role.class, r100);
    }

    public static Role valueOf(int r100) {
        return forNumber(r100);
    }

    public Role(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
