package com.larus.commercecredit.impl.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/commercecredit/impl/trace/CommerceCreditEventType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "CREDIT_NUM_AND_TASK", "USER_ACTIVE", "GET_CREDIT_TIP", "GET_CAMPAIGN_INFO", "GET_INVITE_INFO", "JOIN_GROUP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommerceCreditEventType extends Enum<CommerceCreditEventType> {
    public static final CommerceCreditEventType CREDIT_NUM_AND_TASK = null;
    public static final CommerceCreditEventType GET_CAMPAIGN_INFO = null;
    public static final CommerceCreditEventType GET_CREDIT_TIP = null;
    public static final CommerceCreditEventType GET_INVITE_INFO = null;
    public static final CommerceCreditEventType JOIN_GROUP = null;
    public static final CommerceCreditEventType USER_ACTIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommerceCreditEventType[] f325799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325800b = null;
    private final String type;

    public static EnumEntries<CommerceCreditEventType> getEntries() {
        return f325800b;
    }

    static {
        CommerceCreditEventType r100 = new CommerceCreditEventType("CREDIT_NUM_AND_TASK", 0, "credit_num_and_task");
        CREDIT_NUM_AND_TASK = r100;
        CommerceCreditEventType r101 = new CommerceCreditEventType("USER_ACTIVE", 1, "user_active");
        USER_ACTIVE = r101;
        CommerceCreditEventType r102 = new CommerceCreditEventType("GET_CREDIT_TIP", 2, "get_credit_tip");
        GET_CREDIT_TIP = r102;
        CommerceCreditEventType r103 = new CommerceCreditEventType("GET_CAMPAIGN_INFO", 3, "get_campaign_info");
        GET_CAMPAIGN_INFO = r103;
        CommerceCreditEventType r104 = new CommerceCreditEventType("GET_INVITE_INFO", 4, "get_invite_info");
        GET_INVITE_INFO = r104;
        CommerceCreditEventType r105 = new CommerceCreditEventType("JOIN_GROUP", 5, "join_group");
        JOIN_GROUP = r105;
        CommerceCreditEventType[] r110 = {r100, r101, r102, r103, r104, r105};
        f325799a = r110;
        f325800b = EnumEntriesKt.enumEntries(r110);
    }

    public static CommerceCreditEventType[] values() {
        return (CommerceCreditEventType[]) f325799a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static CommerceCreditEventType valueOf(String r100) {
        return (CommerceCreditEventType) a.a(CommerceCreditEventType.class, r100);
    }

    public CommerceCreditEventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
