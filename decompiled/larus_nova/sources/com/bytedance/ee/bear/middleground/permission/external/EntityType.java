package com.bytedance.ee.bear.middleground.permission.external;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/external/EntityType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "COLLABORATOR_READABLE", "COLLABORATOR_EDITABLE", "COLLABORATOR_FULLACCESS", "SWITCH_CLOSE", "SWITCH_OPEN", "LINK_SHARE_INVITED_COLLABORATOR", "LINK_SHARE_ORGANIZATION_READABLE", "LINK_SHARE_ORGANIZATION_EDITABLE", "LINK_SHARE_ANYONE_READABLE", "LINK_SHARE_ANYONE_EDITABLE", "LINK_SHARE_PARTNER_TENANT_READABLE", "LINK_SHARE_PARTNER_TENANT_EDITABLE", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntityType[] f233881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233882b = null;
    private final int value;

    public static EnumEntries<EntityType> getEntries() {
        return f233882b;
    }

    static {
        EntityType r100 = new EntityType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        EntityType r101 = new EntityType("COLLABORATOR_READABLE", 1, 1);
        COLLABORATOR_READABLE = r101;
        EntityType r102 = new EntityType("COLLABORATOR_EDITABLE", 2, 2);
        COLLABORATOR_EDITABLE = r102;
        EntityType r103 = new EntityType("COLLABORATOR_FULLACCESS", 3, 3);
        COLLABORATOR_FULLACCESS = r103;
        EntityType r104 = new EntityType("SWITCH_CLOSE", 4, 4);
        SWITCH_CLOSE = r104;
        EntityType r105 = new EntityType("SWITCH_OPEN", 5, 5);
        SWITCH_OPEN = r105;
        EntityType r110 = new EntityType("LINK_SHARE_INVITED_COLLABORATOR", 6, 6);
        LINK_SHARE_INVITED_COLLABORATOR = r110;
        EntityType r111 = new EntityType("LINK_SHARE_ORGANIZATION_READABLE", 7, 7);
        LINK_SHARE_ORGANIZATION_READABLE = r111;
        EntityType r112 = new EntityType("LINK_SHARE_ORGANIZATION_EDITABLE", 8, 8);
        LINK_SHARE_ORGANIZATION_EDITABLE = r112;
        EntityType r113 = new EntityType("LINK_SHARE_ANYONE_READABLE", 9, 9);
        LINK_SHARE_ANYONE_READABLE = r113;
        EntityType r114 = new EntityType("LINK_SHARE_ANYONE_EDITABLE", 10, 10);
        LINK_SHARE_ANYONE_EDITABLE = r114;
        EntityType r115 = new EntityType("LINK_SHARE_PARTNER_TENANT_READABLE", 11, 11);
        LINK_SHARE_PARTNER_TENANT_READABLE = r115;
        EntityType r106 = new EntityType("LINK_SHARE_PARTNER_TENANT_EDITABLE", 12, 12);
        LINK_SHARE_PARTNER_TENANT_EDITABLE = r106;
        EntityType[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f233881a = r107;
        f233882b = EnumEntriesKt.enumEntries(r107);
    }

    public static EntityType[] values() {
        return (EntityType[]) f233881a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EntityType valueOf(String r100) {
        return (EntityType) a.a(EntityType.class, r100);
    }

    public EntityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
