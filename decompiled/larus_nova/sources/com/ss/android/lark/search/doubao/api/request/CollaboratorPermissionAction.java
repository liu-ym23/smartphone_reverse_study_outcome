package com.ss.android.lark.search.doubao.api.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/search/doubao/api/request/CollaboratorPermissionAction;", "", "<init>", "(Ljava/lang/String;I)V", "CHECK_BLOCK", "INVITE_SAME_CHAT", "INVITE_SAME_CRYPTO_CHAT", "INVITE_SAME_CROSS_TENANT_CHAT", "search-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CollaboratorPermissionAction extends Enum<CollaboratorPermissionAction> {
    public static final CollaboratorPermissionAction CHECK_BLOCK = null;
    public static final CollaboratorPermissionAction INVITE_SAME_CHAT = null;
    public static final CollaboratorPermissionAction INVITE_SAME_CROSS_TENANT_CHAT = null;
    public static final CollaboratorPermissionAction INVITE_SAME_CRYPTO_CHAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CollaboratorPermissionAction[] f439940a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f439941b = null;

    public static EnumEntries<CollaboratorPermissionAction> getEntries() {
        return f439941b;
    }

    static {
        CollaboratorPermissionAction r100 = new CollaboratorPermissionAction("CHECK_BLOCK", 0);
        CHECK_BLOCK = r100;
        CollaboratorPermissionAction r101 = new CollaboratorPermissionAction("INVITE_SAME_CHAT", 1);
        INVITE_SAME_CHAT = r101;
        CollaboratorPermissionAction r102 = new CollaboratorPermissionAction("INVITE_SAME_CRYPTO_CHAT", 2);
        INVITE_SAME_CRYPTO_CHAT = r102;
        CollaboratorPermissionAction r103 = new CollaboratorPermissionAction("INVITE_SAME_CROSS_TENANT_CHAT", 3);
        INVITE_SAME_CROSS_TENANT_CHAT = r103;
        CollaboratorPermissionAction[] r104 = {r100, r101, r102, r103};
        f439940a = r104;
        f439941b = EnumEntriesKt.enumEntries(r104);
    }

    public static CollaboratorPermissionAction[] values() {
        return (CollaboratorPermissionAction[]) f439940a.clone();
    }

    public static CollaboratorPermissionAction valueOf(String r100) {
        return (CollaboratorPermissionAction) r27.a.a(CollaboratorPermissionAction.class, r100);
    }

    public CollaboratorPermissionAction(String r100, int r101) {
        super(r100, r101);
    }
}
