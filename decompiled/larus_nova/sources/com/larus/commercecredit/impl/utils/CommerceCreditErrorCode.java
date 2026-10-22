package com.larus.commercecredit.impl.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/larus/commercecredit/impl/utils/CommerceCreditErrorCode;", "", "code", "", "description", "", "<init>", "(Ljava/lang/String;IJLjava/lang/String;)V", "getCode", "()J", "getDescription", "()Ljava/lang/String;", "CAMPAIGN_NOT_FOUND", "CAMPAIGN_EXPIRED", "CAMPAIGN_NOT_BEGIN", "INVITE_CODE_INVALID", "NO_ELIGIBILITY", "NOT_NEW_USER", "ALREADY_PARTICIPATED", "SELF_JOIN_FORBIDDEN", "REFERRER_REWARD_LIMIT_REACHED", "CREDIT_GET_SHARK_REJECT", "ALICE_SHARK_BLOCK", "ALICE_API_COMMON_SYSTEM_ERROR", "ALICE_API_COMMON_INVALID_PARAM", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommerceCreditErrorCode extends Enum<CommerceCreditErrorCode> {
    public static final CommerceCreditErrorCode ALICE_API_COMMON_INVALID_PARAM = null;
    public static final CommerceCreditErrorCode ALICE_API_COMMON_SYSTEM_ERROR = null;
    public static final CommerceCreditErrorCode ALICE_SHARK_BLOCK = null;
    public static final CommerceCreditErrorCode ALREADY_PARTICIPATED = null;
    public static final CommerceCreditErrorCode CAMPAIGN_EXPIRED = null;
    public static final CommerceCreditErrorCode CAMPAIGN_NOT_BEGIN = null;
    public static final CommerceCreditErrorCode CAMPAIGN_NOT_FOUND = null;
    public static final CommerceCreditErrorCode CREDIT_GET_SHARK_REJECT = null;
    public static final a Companion = null;
    public static final CommerceCreditErrorCode INVITE_CODE_INVALID = null;
    public static final CommerceCreditErrorCode NOT_NEW_USER = null;
    public static final CommerceCreditErrorCode NO_ELIGIBILITY = null;
    public static final CommerceCreditErrorCode REFERRER_REWARD_LIMIT_REACHED = null;
    public static final CommerceCreditErrorCode SELF_JOIN_FORBIDDEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommerceCreditErrorCode[] f325804a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f325805b = null;
    private final long code;
    private final String description;

    public static final class a {
        public a() {
        }

        public static String a(long r100) {
            CommerceCreditErrorCode[] r101 = CommerceCreditErrorCode.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            CommerceCreditErrorCode r104 = r101[r103];
            if (r104.getCode() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L15;
            String r106 = r104.getDescription();
            if (r106 == null) goto L15;
            return r106;
        L15:
            return "invalid error";
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<CommerceCreditErrorCode> getEntries() {
        return f325805b;
    }

    static {
        CommerceCreditErrorCode r100 = new CommerceCreditErrorCode("CAMPAIGN_NOT_FOUND", 0, 611100000, "campaign not found");
        CAMPAIGN_NOT_FOUND = r100;
        CommerceCreditErrorCode r101 = new CommerceCreditErrorCode("CAMPAIGN_EXPIRED", 1, 611100001, "campaign expired");
        CAMPAIGN_EXPIRED = r101;
        CommerceCreditErrorCode r102 = new CommerceCreditErrorCode("CAMPAIGN_NOT_BEGIN", 2, 611100002, "campaign not begin");
        CAMPAIGN_NOT_BEGIN = r102;
        CommerceCreditErrorCode r103 = new CommerceCreditErrorCode("INVITE_CODE_INVALID", 3, 611100010, "invite code invalid");
        INVITE_CODE_INVALID = r103;
        CommerceCreditErrorCode r104 = new CommerceCreditErrorCode("NO_ELIGIBILITY", 4, 611100020, "no eligibility");
        NO_ELIGIBILITY = r104;
        CommerceCreditErrorCode r105 = new CommerceCreditErrorCode("NOT_NEW_USER", 5, 611100021, "not new user");
        NOT_NEW_USER = r105;
        CommerceCreditErrorCode r106 = new CommerceCreditErrorCode("ALREADY_PARTICIPATED", 6, 611100022, "already participated in the campaign");
        ALREADY_PARTICIPATED = r106;
        CommerceCreditErrorCode r110 = new CommerceCreditErrorCode("SELF_JOIN_FORBIDDEN", 7, 611100023, "cannot join oneself");
        SELF_JOIN_FORBIDDEN = r110;
        CommerceCreditErrorCode r107 = new CommerceCreditErrorCode("REFERRER_REWARD_LIMIT_REACHED", 8, 611100024, "referrer reward limit reached");
        REFERRER_REWARD_LIMIT_REACHED = r107;
        CommerceCreditErrorCode r108 = new CommerceCreditErrorCode("CREDIT_GET_SHARK_REJECT", 9, 611010201, "get credit shark reject");
        CREDIT_GET_SHARK_REJECT = r108;
        CommerceCreditErrorCode r109 = new CommerceCreditErrorCode("ALICE_SHARK_BLOCK", 10, 710022002, "shark block");
        ALICE_SHARK_BLOCK = r109;
        CommerceCreditErrorCode r111 = new CommerceCreditErrorCode("ALICE_API_COMMON_SYSTEM_ERROR", 11, 710010702, "system error");
        ALICE_API_COMMON_SYSTEM_ERROR = r111;
        CommerceCreditErrorCode r112 = new CommerceCreditErrorCode("ALICE_API_COMMON_INVALID_PARAM", 12, 710010202, "common invalid param");
        ALICE_API_COMMON_INVALID_PARAM = r112;
        CommerceCreditErrorCode[] r113 = {r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112};
        f325804a = r113;
        f325805b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static CommerceCreditErrorCode[] values() {
        return (CommerceCreditErrorCode[]) f325804a.clone();
    }

    public final long getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public static CommerceCreditErrorCode valueOf(String r100) {
        return (CommerceCreditErrorCode) r27.a.a(CommerceCreditErrorCode.class, r100);
    }

    public CommerceCreditErrorCode(String r100, int r101, long r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.description = r103;
    }
}
