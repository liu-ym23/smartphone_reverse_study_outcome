package com.bytedance.bdp.appbase.auth.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/auth/constant/PrivacyScopeAuthorizeStatus;", "", "NEED_AUTHORIZE", "ALREADY_AUTHORIZE", "DO_NOT_NEED_AUTHORIZE", "SCOPE_NOT_IN_PRIVACY_AGREEMENT", "bdp-eco-core_release"}, k = 1, mv = {1, 4, 0})
public final enum PrivacyScopeAuthorizeStatus extends Enum<PrivacyScopeAuthorizeStatus> {
    public static final PrivacyScopeAuthorizeStatus ALREADY_AUTHORIZE = null;
    public static final PrivacyScopeAuthorizeStatus DO_NOT_NEED_AUTHORIZE = null;
    public static final PrivacyScopeAuthorizeStatus NEED_AUTHORIZE = null;
    public static final PrivacyScopeAuthorizeStatus SCOPE_NOT_IN_PRIVACY_AGREEMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrivacyScopeAuthorizeStatus[] f200401a = null;

    static {
        PrivacyScopeAuthorizeStatus r100 = new PrivacyScopeAuthorizeStatus("NEED_AUTHORIZE", 0);
        NEED_AUTHORIZE = r100;
        PrivacyScopeAuthorizeStatus r101 = new PrivacyScopeAuthorizeStatus("ALREADY_AUTHORIZE", 1);
        ALREADY_AUTHORIZE = r101;
        PrivacyScopeAuthorizeStatus r102 = new PrivacyScopeAuthorizeStatus("DO_NOT_NEED_AUTHORIZE", 2);
        DO_NOT_NEED_AUTHORIZE = r102;
        PrivacyScopeAuthorizeStatus r103 = new PrivacyScopeAuthorizeStatus("SCOPE_NOT_IN_PRIVACY_AGREEMENT", 3);
        SCOPE_NOT_IN_PRIVACY_AGREEMENT = r103;
        f200401a = new PrivacyScopeAuthorizeStatus[]{r100, r101, r102, r103};
    }

    public static PrivacyScopeAuthorizeStatus valueOf(String r100) {
        return (PrivacyScopeAuthorizeStatus) a.a(PrivacyScopeAuthorizeStatus.class, r100);
    }

    public static PrivacyScopeAuthorizeStatus[] values() {
        return (PrivacyScopeAuthorizeStatus[]) f200401a.clone();
    }

    public PrivacyScopeAuthorizeStatus(String r100, int r101) {
        super(r100, r101);
    }
}
