package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/block/AuthIdentityType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "AUTH_IDENTITY_UNKNOWN", "AUTH_IDENTITY_REAL_NAME_VERIFIED", "AUTH_IDENTITY_TOURIST_LOGIN", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthIdentityType extends Enum<AuthIdentityType> {
    public static final AuthIdentityType AUTH_IDENTITY_REAL_NAME_VERIFIED = null;
    public static final AuthIdentityType AUTH_IDENTITY_TOURIST_LOGIN = null;
    public static final AuthIdentityType AUTH_IDENTITY_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthIdentityType[] f346798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346799b = null;
    private final int type;

    public static EnumEntries<AuthIdentityType> getEntries() {
        return f346799b;
    }

    static {
        AuthIdentityType r100 = new AuthIdentityType("AUTH_IDENTITY_UNKNOWN", 0, 0);
        AUTH_IDENTITY_UNKNOWN = r100;
        AuthIdentityType r101 = new AuthIdentityType("AUTH_IDENTITY_REAL_NAME_VERIFIED", 1, 1);
        AUTH_IDENTITY_REAL_NAME_VERIFIED = r101;
        AuthIdentityType r102 = new AuthIdentityType("AUTH_IDENTITY_TOURIST_LOGIN", 2, 2);
        AUTH_IDENTITY_TOURIST_LOGIN = r102;
        AuthIdentityType[] r103 = {r100, r101, r102};
        f346798a = r103;
        f346799b = EnumEntriesKt.enumEntries(r103);
    }

    public static AuthIdentityType[] values() {
        return (AuthIdentityType[]) f346798a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AuthIdentityType valueOf(String r100) {
        return (AuthIdentityType) a.a(AuthIdentityType.class, r100);
    }

    public AuthIdentityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
