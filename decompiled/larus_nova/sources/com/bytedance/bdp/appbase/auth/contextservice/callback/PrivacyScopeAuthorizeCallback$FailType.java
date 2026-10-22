package com.bytedance.bdp.appbase.auth.contextservice.callback;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/bdp/appbase/auth/contextservice/callback/PrivacyScopeAuthorizeCallback$FailType", "", "Lcom/bytedance/bdp/appbase/auth/contextservice/callback/PrivacyScopeAuthorizeCallback$FailType;", "USER_DENY_PRIVACY_AGREEMENT", "SCOPE_NOT_IN_PRIVACY_AGREEMENT", "bdp-eco-core_release"}, k = 1, mv = {1, 4, 0})
public final enum PrivacyScopeAuthorizeCallback$FailType extends Enum<PrivacyScopeAuthorizeCallback$FailType> {
    public static final PrivacyScopeAuthorizeCallback$FailType SCOPE_NOT_IN_PRIVACY_AGREEMENT = null;
    public static final PrivacyScopeAuthorizeCallback$FailType USER_DENY_PRIVACY_AGREEMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrivacyScopeAuthorizeCallback$FailType[] f200403a = null;

    static {
        PrivacyScopeAuthorizeCallback$FailType r100 = new PrivacyScopeAuthorizeCallback$FailType("USER_DENY_PRIVACY_AGREEMENT", 0);
        USER_DENY_PRIVACY_AGREEMENT = r100;
        PrivacyScopeAuthorizeCallback$FailType r101 = new PrivacyScopeAuthorizeCallback$FailType("SCOPE_NOT_IN_PRIVACY_AGREEMENT", 1);
        SCOPE_NOT_IN_PRIVACY_AGREEMENT = r101;
        f200403a = new PrivacyScopeAuthorizeCallback$FailType[]{r100, r101};
    }

    public static PrivacyScopeAuthorizeCallback$FailType valueOf(String r100) {
        return (PrivacyScopeAuthorizeCallback$FailType) a.a(PrivacyScopeAuthorizeCallback$FailType.class, r100);
    }

    public static PrivacyScopeAuthorizeCallback$FailType[] values() {
        return (PrivacyScopeAuthorizeCallback$FailType[]) f200403a.clone();
    }

    public PrivacyScopeAuthorizeCallback$FailType(String r100, int r101) {
        super(r100, r101);
    }
}
