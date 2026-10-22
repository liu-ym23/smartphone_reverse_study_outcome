package com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/publicpermset/model/CollaboratorPermissionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "READ_PERM", "EDIT_PERM", "FULL_ACCESS_PERM", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CollaboratorPermissionType extends Enum<CollaboratorPermissionType> {
    public static final CollaboratorPermissionType EDIT_PERM = null;
    public static final CollaboratorPermissionType FULL_ACCESS_PERM = null;
    public static final CollaboratorPermissionType READ_PERM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollaboratorPermissionType[] f234226a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f234227b = null;
    private final int value;

    public static EnumEntries<CollaboratorPermissionType> getEntries() {
        return f234227b;
    }

    static {
        CollaboratorPermissionType r100 = new CollaboratorPermissionType("READ_PERM", 0, 1);
        READ_PERM = r100;
        CollaboratorPermissionType r101 = new CollaboratorPermissionType("EDIT_PERM", 1, 2);
        EDIT_PERM = r101;
        CollaboratorPermissionType r102 = new CollaboratorPermissionType("FULL_ACCESS_PERM", 2, 3);
        FULL_ACCESS_PERM = r102;
        CollaboratorPermissionType[] r103 = {r100, r101, r102};
        f234226a = r103;
        f234227b = EnumEntriesKt.enumEntries(r103);
    }

    public static CollaboratorPermissionType[] values() {
        return (CollaboratorPermissionType[]) f234226a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CollaboratorPermissionType valueOf(String r100) {
        return (CollaboratorPermissionType) a.a(CollaboratorPermissionType.class, r100);
    }

    public CollaboratorPermissionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
