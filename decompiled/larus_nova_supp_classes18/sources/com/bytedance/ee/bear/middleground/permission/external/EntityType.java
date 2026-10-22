package com.bytedance.ee.bear.middleground.permission.external;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/external/EntityType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "COLLABORATOR_READABLE", "COLLABORATOR_EDITABLE", "COLLABORATOR_FULLACCESS", "SWITCH_CLOSE", "SWITCH_OPEN", "LINK_SHARE_INVITED_COLLABORATOR", "LINK_SHARE_ORGANIZATION_READABLE", "LINK_SHARE_ORGANIZATION_EDITABLE", "LINK_SHARE_ANYONE_READABLE", "LINK_SHARE_ANYONE_EDITABLE", "LINK_SHARE_PARTNER_TENANT_READABLE", "LINK_SHARE_PARTNER_TENANT_EDITABLE", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntityType extends Enum<EntityType> {
    public static final EntityType COLLABORATOR_EDITABLE = null;
    public static final EntityType COLLABORATOR_FULLACCESS = null;
    public static final EntityType COLLABORATOR_READABLE = null;
    public static final EntityType LINK_SHARE_ANYONE_EDITABLE = null;
    public static final EntityType LINK_SHARE_ANYONE_READABLE = null;
    public static final EntityType LINK_SHARE_INVITED_COLLABORATOR = null;
    public static final EntityType LINK_SHARE_ORGANIZATION_EDITABLE = null;
    public static final EntityType LINK_SHARE_ORGANIZATION_READABLE = null;
    public static final EntityType LINK_SHARE_PARTNER_TENANT_EDITABLE = null;
    public static final EntityType LINK_SHARE_PARTNER_TENANT_READABLE = null;
    public static final EntityType NONE = null;
    public static final EntityType SWITCH_CLOSE = null;
    public static final EntityType SWITCH_OPEN = null;
    public static final /* synthetic */ EntityType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<EntityType> getEntries() {
        return b;
    }

    static {
        EntityType r0 = new EntityType("NONE", 0, 0);
        NONE = r0;
        EntityType r1 = new EntityType("COLLABORATOR_READABLE", 1, 1);
        COLLABORATOR_READABLE = r1;
        EntityType r3 = new EntityType("COLLABORATOR_EDITABLE", 2, 2);
        COLLABORATOR_EDITABLE = r3;
        EntityType r5 = new EntityType("COLLABORATOR_FULLACCESS", 3, 3);
        COLLABORATOR_FULLACCESS = r5;
        EntityType r7 = new EntityType("SWITCH_CLOSE", 4, 4);
        SWITCH_CLOSE = r7;
        EntityType r9 = new EntityType("SWITCH_OPEN", 5, 5);
        SWITCH_OPEN = r9;
        EntityType r11 = new EntityType("LINK_SHARE_INVITED_COLLABORATOR", 6, 6);
        LINK_SHARE_INVITED_COLLABORATOR = r11;
        EntityType r13 = new EntityType("LINK_SHARE_ORGANIZATION_READABLE", 7, 7);
        LINK_SHARE_ORGANIZATION_READABLE = r13;
        EntityType r15 = new EntityType("LINK_SHARE_ORGANIZATION_EDITABLE", 8, 8);
        LINK_SHARE_ORGANIZATION_EDITABLE = r15;
        EntityType r14 = new EntityType("LINK_SHARE_ANYONE_READABLE", 9, 9);
        LINK_SHARE_ANYONE_READABLE = r14;
        EntityType r12 = new EntityType("LINK_SHARE_ANYONE_EDITABLE", 10, 10);
        LINK_SHARE_ANYONE_EDITABLE = r12;
        EntityType r10 = new EntityType("LINK_SHARE_PARTNER_TENANT_READABLE", 11, 11);
        LINK_SHARE_PARTNER_TENANT_READABLE = r10;
        EntityType r8 = new EntityType("LINK_SHARE_PARTNER_TENANT_EDITABLE", 12, 12);
        LINK_SHARE_PARTNER_TENANT_EDITABLE = r8;
        EntityType[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static EntityType[] values() {
        return (EntityType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EntityType valueOf(String r1) {
        return (EntityType) a.a(EntityType.class, r1);
    }

    public EntityType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
