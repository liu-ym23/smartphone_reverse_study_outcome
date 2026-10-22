package com.larus.account.saas.security.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes24.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/security/model/AccountRiskAppealAction;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface AccountRiskAppealAction {
    public static final a Companion = null;
    public static final int JUMP_TO_H5 = 2;
    public static final int SUBMIT_DIRECT = 1;
    public static final int TOAST = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f286513a = null;

        static {
            f286513a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f286513a;
    }
}
