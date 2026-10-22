package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: classes24.dex */
public final enum TagPermissionType extends Enum<TagPermissionType> {
    public static final TagPermissionType Default = null;
    public static final TagPermissionType Private = null;
    public static final TagPermissionType Public = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagPermissionType[] f282987a = null;
    int value;

    static {
        TagPermissionType r100 = new TagPermissionType("Default", 0, 0);
        Default = r100;
        TagPermissionType r101 = new TagPermissionType("Public", 1, 1);
        Public = r101;
        TagPermissionType r102 = new TagPermissionType("Private", 2, 2);
        Private = r102;
        f282987a = new TagPermissionType[]{r100, r101, r102};
    }

    public static TagPermissionType[] values() {
        return (TagPermissionType[]) f282987a.clone();
    }

    public int value() {
        return this.value;
    }

    public static TagPermissionType valueOf(String r100) {
        return (TagPermissionType) r27.a.a(TagPermissionType.class, r100);
    }

    public TagPermissionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
