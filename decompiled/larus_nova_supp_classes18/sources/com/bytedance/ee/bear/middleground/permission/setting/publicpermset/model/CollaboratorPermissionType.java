package com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/publicpermset/model/CollaboratorPermissionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "READ_PERM", "EDIT_PERM", "FULL_ACCESS_PERM", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CollaboratorPermissionType extends Enum<CollaboratorPermissionType> {
    public static final CollaboratorPermissionType EDIT_PERM = null;
    public static final CollaboratorPermissionType FULL_ACCESS_PERM = null;
    public static final CollaboratorPermissionType READ_PERM = null;
    public static final /* synthetic */ CollaboratorPermissionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<CollaboratorPermissionType> getEntries() {
        return b;
    }

    static {
        CollaboratorPermissionType r0 = new CollaboratorPermissionType("READ_PERM", 0, 1);
        READ_PERM = r0;
        CollaboratorPermissionType r1 = new CollaboratorPermissionType("EDIT_PERM", 1, 2);
        EDIT_PERM = r1;
        CollaboratorPermissionType r4 = new CollaboratorPermissionType("FULL_ACCESS_PERM", 2, 3);
        FULL_ACCESS_PERM = r4;
        CollaboratorPermissionType[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static CollaboratorPermissionType[] values() {
        return (CollaboratorPermissionType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CollaboratorPermissionType valueOf(String r1) {
        return (CollaboratorPermissionType) a.a(CollaboratorPermissionType.class, r1);
    }

    public CollaboratorPermissionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
