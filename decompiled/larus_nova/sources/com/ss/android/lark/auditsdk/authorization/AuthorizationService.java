package com.ss.android.lark.auditsdk.authorization;

import android.content.Context;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.wrapper.b;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AuthorizationService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<AuthorizationService> f409559a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/auditsdk/authorization/AuthorizationService$UserAuthority;", "", "Companion", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface UserAuthority {
        public static final a Companion = null;
        public static final int LOGIN_USER_DENIED_CODE = 260008;
        public static final int LOGIN_USER_DENIED_REASON = 10;
        public static final int OTHER_USER_DENIED_CODE = 260009;
        public static final int OTHER_USER_DENIED_REASON = 11;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f409560a = null;

            static {
                f409560a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f409560a;
        }
    }

    public static final class a {
    }

    public AuthorizationService() {
    }

    static {
        f409559a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AuthorizationService$Companion$instance$2.INSTANCE);
    }

    public final String a() {
        b.d.f409722a.getClass();
        return UIHelper.mustacheFormat(R.string.Lark_Audit_BlockedActionsDueToPermissionSettings, "BlockedAction", UIHelper.getString(R.string.Lark_Audit_BlockedActionUpload));
    }

    public final void b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b.d.f409722a.getClass();
        UICallbackExecutor.execute(new com.ss.android.lark.auditsdk.authorization.a(r101, r100));
    }
}
