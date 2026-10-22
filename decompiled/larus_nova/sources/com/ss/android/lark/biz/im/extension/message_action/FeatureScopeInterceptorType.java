package com.ss.android.lark.biz.im.extension.message_action;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/message_action/FeatureScopeInterceptorType;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLE_ACTION", "COMMON", "SECRET_CHAT", "RESTRICTED_MESSAGE", "PRIVATE_CHAT", "DLP", "VC_VISITOR", "FROZEN_CHAT", "RECEIVE_AUTHORIZATION", "ON_TIME_DELETE_MESSAGE", "MY_AI", "SINGLE_URL", "GROUP_ANNOUNCEMENT", "RESOURCE_IS_CLEANED", "FAVORITE", "COT", "FLOW_COMMON", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeatureScopeInterceptorType extends Enum<FeatureScopeInterceptorType> {
    public static final FeatureScopeInterceptorType COMMON = null;
    public static final FeatureScopeInterceptorType COT = null;
    public static final FeatureScopeInterceptorType DISABLE_ACTION = null;
    public static final FeatureScopeInterceptorType DLP = null;
    public static final FeatureScopeInterceptorType FAVORITE = null;
    public static final FeatureScopeInterceptorType FLOW_COMMON = null;
    public static final FeatureScopeInterceptorType FROZEN_CHAT = null;
    public static final FeatureScopeInterceptorType GROUP_ANNOUNCEMENT = null;
    public static final FeatureScopeInterceptorType MY_AI = null;
    public static final FeatureScopeInterceptorType ON_TIME_DELETE_MESSAGE = null;
    public static final FeatureScopeInterceptorType PRIVATE_CHAT = null;
    public static final FeatureScopeInterceptorType RECEIVE_AUTHORIZATION = null;
    public static final FeatureScopeInterceptorType RESOURCE_IS_CLEANED = null;
    public static final FeatureScopeInterceptorType RESTRICTED_MESSAGE = null;
    public static final FeatureScopeInterceptorType SECRET_CHAT = null;
    public static final FeatureScopeInterceptorType SINGLE_URL = null;
    public static final FeatureScopeInterceptorType VC_VISITOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeatureScopeInterceptorType[] f410496a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410497b = null;

    public static EnumEntries<FeatureScopeInterceptorType> getEntries() {
        return f410497b;
    }

    static {
        FeatureScopeInterceptorType r100 = new FeatureScopeInterceptorType("DISABLE_ACTION", 0);
        DISABLE_ACTION = r100;
        FeatureScopeInterceptorType r101 = new FeatureScopeInterceptorType("COMMON", 1);
        COMMON = r101;
        FeatureScopeInterceptorType r102 = new FeatureScopeInterceptorType("SECRET_CHAT", 2);
        SECRET_CHAT = r102;
        FeatureScopeInterceptorType r103 = new FeatureScopeInterceptorType("RESTRICTED_MESSAGE", 3);
        RESTRICTED_MESSAGE = r103;
        FeatureScopeInterceptorType r104 = new FeatureScopeInterceptorType("PRIVATE_CHAT", 4);
        PRIVATE_CHAT = r104;
        FeatureScopeInterceptorType r105 = new FeatureScopeInterceptorType("DLP", 5);
        DLP = r105;
        FeatureScopeInterceptorType r110 = new FeatureScopeInterceptorType("VC_VISITOR", 6);
        VC_VISITOR = r110;
        FeatureScopeInterceptorType r111 = new FeatureScopeInterceptorType("FROZEN_CHAT", 7);
        FROZEN_CHAT = r111;
        FeatureScopeInterceptorType r112 = new FeatureScopeInterceptorType("RECEIVE_AUTHORIZATION", 8);
        RECEIVE_AUTHORIZATION = r112;
        FeatureScopeInterceptorType r113 = new FeatureScopeInterceptorType("ON_TIME_DELETE_MESSAGE", 9);
        ON_TIME_DELETE_MESSAGE = r113;
        FeatureScopeInterceptorType r114 = new FeatureScopeInterceptorType("MY_AI", 10);
        MY_AI = r114;
        FeatureScopeInterceptorType r115 = new FeatureScopeInterceptorType("SINGLE_URL", 11);
        SINGLE_URL = r115;
        FeatureScopeInterceptorType r106 = new FeatureScopeInterceptorType("GROUP_ANNOUNCEMENT", 12);
        GROUP_ANNOUNCEMENT = r106;
        FeatureScopeInterceptorType r107 = new FeatureScopeInterceptorType("RESOURCE_IS_CLEANED", 13);
        RESOURCE_IS_CLEANED = r107;
        FeatureScopeInterceptorType r108 = new FeatureScopeInterceptorType("FAVORITE", 14);
        FAVORITE = r108;
        FeatureScopeInterceptorType r109 = new FeatureScopeInterceptorType("COT", 15);
        COT = r109;
        FeatureScopeInterceptorType r116 = new FeatureScopeInterceptorType("FLOW_COMMON", 16);
        FLOW_COMMON = r116;
        FeatureScopeInterceptorType[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116};
        f410496a = r117;
        f410497b = EnumEntriesKt.enumEntries(r117);
    }

    public static FeatureScopeInterceptorType[] values() {
        return (FeatureScopeInterceptorType[]) f410496a.clone();
    }

    public static FeatureScopeInterceptorType valueOf(String r100) {
        return (FeatureScopeInterceptorType) a.a(FeatureScopeInterceptorType.class, r100);
    }

    public FeatureScopeInterceptorType(String r100, int r101) {
        super(r100, r101);
    }
}
