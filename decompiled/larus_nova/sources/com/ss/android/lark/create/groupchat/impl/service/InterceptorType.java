package com.ss.android.lark.create.groupchat.impl.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/service/InterceptorType;", "", "<init>", "(Ljava/lang/String;I)V", "HIT_POINT", "GROUP_MEMBER_LIMIT", "EXCEED_GROUP_LIMIT", "EXCEED_GROUP_LIMIT_NEED_APPLY", "BILLING", "DLP", "DEFAULT", "SECRET_CHAT_BANNED", "STRANGER", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InterceptorType extends Enum<InterceptorType> {
    public static final InterceptorType BILLING = null;
    public static final InterceptorType DEFAULT = null;
    public static final InterceptorType DLP = null;
    public static final InterceptorType EXCEED_GROUP_LIMIT = null;
    public static final InterceptorType EXCEED_GROUP_LIMIT_NEED_APPLY = null;
    public static final InterceptorType GROUP_MEMBER_LIMIT = null;
    public static final InterceptorType HIT_POINT = null;
    public static final InterceptorType SECRET_CHAT_BANNED = null;
    public static final InterceptorType STRANGER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterceptorType[] f420193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420194b = null;

    public static EnumEntries<InterceptorType> getEntries() {
        return f420194b;
    }

    static {
        InterceptorType r100 = new InterceptorType("HIT_POINT", 0);
        HIT_POINT = r100;
        InterceptorType r101 = new InterceptorType("GROUP_MEMBER_LIMIT", 1);
        GROUP_MEMBER_LIMIT = r101;
        InterceptorType r102 = new InterceptorType("EXCEED_GROUP_LIMIT", 2);
        EXCEED_GROUP_LIMIT = r102;
        InterceptorType r103 = new InterceptorType("EXCEED_GROUP_LIMIT_NEED_APPLY", 3);
        EXCEED_GROUP_LIMIT_NEED_APPLY = r103;
        InterceptorType r104 = new InterceptorType("BILLING", 4);
        BILLING = r104;
        InterceptorType r105 = new InterceptorType("DLP", 5);
        DLP = r105;
        InterceptorType r110 = new InterceptorType("DEFAULT", 6);
        DEFAULT = r110;
        InterceptorType r111 = new InterceptorType("SECRET_CHAT_BANNED", 7);
        SECRET_CHAT_BANNED = r111;
        InterceptorType r112 = new InterceptorType("STRANGER", 8);
        STRANGER = r112;
        InterceptorType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f420193a = r113;
        f420194b = EnumEntriesKt.enumEntries(r113);
    }

    public static InterceptorType[] values() {
        return (InterceptorType[]) f420193a.clone();
    }

    public static InterceptorType valueOf(String r100) {
        return (InterceptorType) r27.a.a(InterceptorType.class, r100);
    }

    public InterceptorType(String r100, int r101) {
        super(r100, r101);
    }
}
