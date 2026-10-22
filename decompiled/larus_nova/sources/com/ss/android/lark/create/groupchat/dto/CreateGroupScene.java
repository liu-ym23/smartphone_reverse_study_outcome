package com.ss.android.lark.create.groupchat.dto;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/create/groupchat/dto/CreateGroupScene;", "", "<init>", "(Ljava/lang/String;I)V", "P2P", "ADD_GROUP_MEMBER", "PLUS_MENU", "FORWARD", "CREATE_SECRET_CHAT", "CREATE_DEPARTMENT_CHAT", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupScene extends Enum<CreateGroupScene> {
    public static final CreateGroupScene ADD_GROUP_MEMBER = null;
    public static final CreateGroupScene CREATE_DEPARTMENT_CHAT = null;
    public static final CreateGroupScene CREATE_SECRET_CHAT = null;
    public static final CreateGroupScene FORWARD = null;
    public static final CreateGroupScene P2P = null;
    public static final CreateGroupScene PLUS_MENU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateGroupScene[] f420176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420177b = null;

    public static EnumEntries<CreateGroupScene> getEntries() {
        return f420177b;
    }

    static {
        CreateGroupScene r100 = new CreateGroupScene("P2P", 0);
        P2P = r100;
        CreateGroupScene r101 = new CreateGroupScene("ADD_GROUP_MEMBER", 1);
        ADD_GROUP_MEMBER = r101;
        CreateGroupScene r102 = new CreateGroupScene("PLUS_MENU", 2);
        PLUS_MENU = r102;
        CreateGroupScene r103 = new CreateGroupScene("FORWARD", 3);
        FORWARD = r103;
        CreateGroupScene r104 = new CreateGroupScene("CREATE_SECRET_CHAT", 4);
        CREATE_SECRET_CHAT = r104;
        CreateGroupScene r105 = new CreateGroupScene("CREATE_DEPARTMENT_CHAT", 5);
        CREATE_DEPARTMENT_CHAT = r105;
        CreateGroupScene[] r110 = {r100, r101, r102, r103, r104, r105};
        f420176a = r110;
        f420177b = EnumEntriesKt.enumEntries(r110);
    }

    public static CreateGroupScene[] values() {
        return (CreateGroupScene[]) f420176a.clone();
    }

    public static CreateGroupScene valueOf(String r100) {
        return (CreateGroupScene) a.a(CreateGroupScene.class, r100);
    }

    public CreateGroupScene(String r100, int r101) {
        super(r100, r101);
    }
}
