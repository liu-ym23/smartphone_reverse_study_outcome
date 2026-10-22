package com.ss.android.lark.passport.flow.mfa;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_ARGUMENT", "BUSY", "USER_CANCEL", "UNSUPPORTED_THIRD_PARTY_MFA", "UNSUPPORTED_STEP", "NO_SUPPORTED_VERIFY_FACTOR", "UNSUPPORTED_IDP_CHANNEL", "PASSWORD_ENCRYPT_FAILED", "PROCESS_RECREATED", "USER_CHANGED", "AUTH_EXPIRED", HTTP.SERVER, "NETWORK", "INTERNAL", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowMfaErrorCategory extends Enum<FlowMfaErrorCategory> {
    public static final FlowMfaErrorCategory AUTH_EXPIRED = null;
    public static final FlowMfaErrorCategory BUSY = null;
    public static final FlowMfaErrorCategory INTERNAL = null;
    public static final FlowMfaErrorCategory INVALID_ARGUMENT = null;
    public static final FlowMfaErrorCategory NETWORK = null;
    public static final FlowMfaErrorCategory NO_SUPPORTED_VERIFY_FACTOR = null;
    public static final FlowMfaErrorCategory PASSWORD_ENCRYPT_FAILED = null;
    public static final FlowMfaErrorCategory PROCESS_RECREATED = null;
    public static final FlowMfaErrorCategory SERVER = null;
    public static final FlowMfaErrorCategory UNSUPPORTED_IDP_CHANNEL = null;
    public static final FlowMfaErrorCategory UNSUPPORTED_STEP = null;
    public static final FlowMfaErrorCategory UNSUPPORTED_THIRD_PARTY_MFA = null;
    public static final FlowMfaErrorCategory USER_CANCEL = null;
    public static final FlowMfaErrorCategory USER_CHANGED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowMfaErrorCategory[] f437825a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437826b = null;

    public static EnumEntries<FlowMfaErrorCategory> getEntries() {
        return f437826b;
    }

    static {
        FlowMfaErrorCategory r100 = new FlowMfaErrorCategory("INVALID_ARGUMENT", 0);
        INVALID_ARGUMENT = r100;
        FlowMfaErrorCategory r101 = new FlowMfaErrorCategory("BUSY", 1);
        BUSY = r101;
        FlowMfaErrorCategory r102 = new FlowMfaErrorCategory("USER_CANCEL", 2);
        USER_CANCEL = r102;
        FlowMfaErrorCategory r103 = new FlowMfaErrorCategory("UNSUPPORTED_THIRD_PARTY_MFA", 3);
        UNSUPPORTED_THIRD_PARTY_MFA = r103;
        FlowMfaErrorCategory r104 = new FlowMfaErrorCategory("UNSUPPORTED_STEP", 4);
        UNSUPPORTED_STEP = r104;
        FlowMfaErrorCategory r105 = new FlowMfaErrorCategory("NO_SUPPORTED_VERIFY_FACTOR", 5);
        NO_SUPPORTED_VERIFY_FACTOR = r105;
        FlowMfaErrorCategory r110 = new FlowMfaErrorCategory("UNSUPPORTED_IDP_CHANNEL", 6);
        UNSUPPORTED_IDP_CHANNEL = r110;
        FlowMfaErrorCategory r111 = new FlowMfaErrorCategory("PASSWORD_ENCRYPT_FAILED", 7);
        PASSWORD_ENCRYPT_FAILED = r111;
        FlowMfaErrorCategory r112 = new FlowMfaErrorCategory("PROCESS_RECREATED", 8);
        PROCESS_RECREATED = r112;
        FlowMfaErrorCategory r113 = new FlowMfaErrorCategory("USER_CHANGED", 9);
        USER_CHANGED = r113;
        FlowMfaErrorCategory r114 = new FlowMfaErrorCategory("AUTH_EXPIRED", 10);
        AUTH_EXPIRED = r114;
        FlowMfaErrorCategory r115 = new FlowMfaErrorCategory(HTTP.SERVER, 11);
        SERVER = r115;
        FlowMfaErrorCategory r106 = new FlowMfaErrorCategory("NETWORK", 12);
        NETWORK = r106;
        FlowMfaErrorCategory r107 = new FlowMfaErrorCategory("INTERNAL", 13);
        INTERNAL = r107;
        FlowMfaErrorCategory[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        f437825a = r108;
        f437826b = EnumEntriesKt.enumEntries(r108);
    }

    public static FlowMfaErrorCategory[] values() {
        return (FlowMfaErrorCategory[]) f437825a.clone();
    }

    public static FlowMfaErrorCategory valueOf(String r100) {
        return (FlowMfaErrorCategory) r27.a.a(FlowMfaErrorCategory.class, r100);
    }

    public FlowMfaErrorCategory(String r100, int r101) {
        super(r100, r101);
    }
}
