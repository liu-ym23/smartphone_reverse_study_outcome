package com.ss.android.lark.auditsdk.v2;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.utils.AuditParamsUtil;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.auditsdk.v2.utils.DownloadAuthorizationEventType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.api.model.filepolicy.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class AuthorizationServiceV2 implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<AuthorizationServiceV2> f409595b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<Boolean> f409596c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<Boolean> f409597d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final owa.c f409598a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/auditsdk/v2/AuthorizationServiceV2$AuthorizationType;", "", "<init>", "(Ljava/lang/String;I)V", "RECEIVE_AUTHORIZATION", "PREVIEW_AUTHORIZATION", "OTHER_AUTHORIZATION", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AuthorizationType extends Enum<AuthorizationType> {
        public static final AuthorizationType OTHER_AUTHORIZATION = null;
        public static final AuthorizationType PREVIEW_AUTHORIZATION = null;
        public static final AuthorizationType RECEIVE_AUTHORIZATION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AuthorizationType[] f409599a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f409600b = null;

        public static EnumEntries<AuthorizationType> getEntries() {
            return f409600b;
        }

        static {
            AuthorizationType r100 = new AuthorizationType("RECEIVE_AUTHORIZATION", 0);
            RECEIVE_AUTHORIZATION = r100;
            AuthorizationType r101 = new AuthorizationType("PREVIEW_AUTHORIZATION", 1);
            PREVIEW_AUTHORIZATION = r101;
            AuthorizationType r102 = new AuthorizationType("OTHER_AUTHORIZATION", 2);
            OTHER_AUTHORIZATION = r102;
            AuthorizationType[] r103 = {r100, r101, r102};
            f409599a = r103;
            f409600b = EnumEntriesKt.enumEntries(r103);
        }

        public static AuthorizationType[] values() {
            return (AuthorizationType[]) f409599a.clone();
        }

        public static AuthorizationType valueOf(String r100) {
            return (AuthorizationType) r27.a.a(AuthorizationType.class, r100);
        }

        public AuthorizationType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a(ValidateResult r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f409601a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f409602b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f409603c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f409604d = null;

        static {
            int[] r100 = new int[DownloadAuthorizationEventType.values().length];
            r100[DownloadAuthorizationEventType.IMAGE_DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L56:
            r100[DownloadAuthorizationEventType.VIDEO_DOWNLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L64:
            r100[DownloadAuthorizationEventType.FILE_DOWNLOAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L42:
            r100[DownloadAuthorizationEventType.FILE_OPEN_IN_3RD_APP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L10:
            f409601a = r100;
            int[] r101 = new int[ValidateResultSource.values().length];
            r101[ValidateResultSource.DOWNGRADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L62:
            r101[ValidateResultSource.FALLBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L13:
            int[] r102 = new int[FileAuthResultFrom.values().length];
            r102[FileAuthResultFrom.COME_FROM_AUTHZ.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L58:
            r102[FileAuthResultFrom.COME_FROM_FILE_POLICY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L66:
            r102[FileAuthResultFrom.COME_FROM_DLP_CONTENT_DETECTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L40:
            r102[FileAuthResultFrom.COME_FROM_DLP_CONTENT_SENSITIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L18:
            f409602b = r102;
            int[] r103 = new int[ResultType.values().length];
            r103[ResultType.DENY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L36
        L60:
            r103[ResultType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L37
        L21:
            f409603c = r103;
            int[] r104 = new int[AuthorizationType.values().length];
            r104[AuthorizationType.RECEIVE_AUTHORIZATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L54:
            r104[AuthorizationType.PREVIEW_AUTHORIZATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L24:
            f409604d = r104;
        }
    }

    static {
        new a();
        f409595b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AuthorizationServiceV2$Companion$instance$2.INSTANCE);
        f409596c = LazyKt.lazy(AuthorizationServiceV2$Companion$isPreviewFGEnable$2.INSTANCE);
        f409597d = LazyKt.lazy(AuthorizationServiceV2$Companion$isReceiveFGEnable$2.INSTANCE);
    }

    @Override // com.ss.android.lark.auditsdk.v2.d
    public final PolicyModel e() {
        int r100 = rwa.a.f539730a;
        return l(rwa.a.C7546a.b().a());
    }

    public final boolean h() {
        int r100 = rwa.a.f539730a;
        Intrinsics.checkNotNullParameter("", "auzEntityId");
        swa.a r101 = rwa.a.C7546a.a();
        Intrinsics.checkNotNullParameter("", "authZEntityId");
        r101.f543740a = "";
        r101.f543741b = 5;
        r101.f543742c = 11;
        Intrinsics.checkNotNullParameter("IM_MSG_FILE_COPY", "entityOperate");
        r101.f543746g = "IM_MSG_FILE_COPY";
        r101.b(EntityDomain.EntityDomainIM);
        Intrinsics.checkNotNullParameter("IM_MSG_FILE", "entityType");
        r101.f543744e = "IM_MSG_FILE";
        r101.c(FileBizDomain.FileBizDomainIM);
        Intrinsics.checkNotNullParameter("PointKey_IM_MSG_FILE_COPY", "pointKey");
        r101.f543743d = "PointKey_IM_MSG_FILE_COPY";
        swa.b r102 = r101.a();
        ValidateConfig r103 = new ValidateConfig();
        r103.setIgnoreSecurityOperate(false);
        r103.setIgnoreReportUserOperate(true);
        Unit r104 = Unit.INSTANCE;
        ValidateResult r105 = n(true, r102, r103);
        a(r105, AuthorizationType.OTHER_AUTHORIZATION);
        return isAuthorizationPassed(r105);
    }

    public AuthorizationServiceV2() {
        this.f409598a = owa.a.d().getSecurityComplianceDependency();
    }

    public static AuthEntity j(swa.b r100) {
        String r101 = r100.f543756a;
        if (r101 != null) goto L5;
        return null;
    L5:
        Integer r102 = r100.f543757b;
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
        Integer r104 = r100.f543758c;
        if (r104 == null) goto L12;
        int r105 = r104.intValue();
        Log.i("AuthorizationServiceV2", "Get authEntity: id = " + r101 + ", type = " + r103 + ", perm = " + r105);
        return new AuthEntity(r105, r103, r101);
    L12:
        return null;
    L11:
        return null;
    }

    public static PolicyModel l(swa.b r210) {
        String r100 = r210.f543760e;
        EntityDomain r101 = r210.f543761f;
        String r102 = r210.f543762g;
        long r103 = r210.f543764i;
        long r104 = r210.f543763h;
        FileBizDomain r105 = r210.f543765j;
        Long r110 = r210.f543766k;
        Long r111 = r210.f543767l;
        String r112 = r210.f543768m;
        String r113 = r210.f543769n;
        String r106 = r210.f543770o;
        if (r106 == null) goto L5;
        Long r107 = StringsKt.toLongOrNull(r106);
    L6:
        IMFileEntity r211 = new IMFileEntity(r100, r101, r102, r104, r103, r105, r110, r111, r112, r113, r107, r210.f543771p, null, null, null, 28672, null);
        return new PolicyModel(r210.f543759d, r211, null, 4, null);
    L5:
        r107 = null;
        goto L6
    }

    @Override // com.ss.android.lark.auditsdk.v2.d
    public final ValidateResult c(boolean r100) {
        if (f409596c.getValue().booleanValue() == false) goto L5;
        int r101 = rwa.a.f539730a;
        swa.b r102 = rwa.a.C7546a.b().a();
        ValidateConfig r103 = new ValidateConfig();
        r103.setIgnoreSecurityOperate(true);
        r103.setIgnoreReportUserOperate(true);
        Unit r104 = Unit.INSTANCE;
        return n(r100, r102, r103);
    L5:
        return new ValidateResult(ResultType.ALLOW);
    }

    public final boolean i(boolean r100) {
        if (f409596c.getValue().booleanValue() == true) goto L7;
        return true;
    L7:
        return isAuthorizationPassed(c(r100));
    }

    @Override // com.ss.android.lark.auditsdk.v2.d
    public final boolean isAuthorizationPassed(ValidateResult r100) {
        Intrinsics.checkNotNullParameter(r100, "validateResult");
        if (r100.getResult() != ResultType.ALLOW) goto L5;
    L8:
        return true;
    L5:
        if (r100.getResult() == ResultType.NULL) goto L8;
        return false;
    }

    public static swa.a k(DownloadAuthorizationEventType r110, String r111) {
        int r112 = c.f409601a[r110.ordinal()];
        if (r112 != 1) goto L5;
        int r113 = rwa.a.f539730a;
        Intrinsics.checkNotNullParameter(r111, "auzEntityId");
        swa.a r114 = rwa.a.C7546a.a();
        Intrinsics.checkNotNullParameter(r111, "authZEntityId");
        r114.f543740a = r111;
        r114.f543741b = 3;
        r114.f543742c = 3;
        Intrinsics.checkNotNullParameter("IM_MSG_FILE_DOWNLOAD", "entityOperate");
        r114.f543746g = "IM_MSG_FILE_DOWNLOAD";
        r114.b(EntityDomain.EntityDomainIM);
        Intrinsics.checkNotNullParameter("IM_MSG_FILE", "entityType");
        r114.f543744e = "IM_MSG_FILE";
        r114.c(FileBizDomain.FileBizDomainIM);
        Intrinsics.checkNotNullParameter("PointKey_IM_MSG_FILE_DOWNLOAD", "pointKey");
        r114.f543743d = "PointKey_IM_MSG_FILE_DOWNLOAD";
        return r114;
    L5:
        if (r112 != 2) goto L7;
        int r115 = rwa.a.f539730a;
        Intrinsics.checkNotNullParameter(r111, "auzEntityId");
        swa.a r116 = rwa.a.C7546a.a();
        Intrinsics.checkNotNullParameter(r111, "authZEntityId");
        r116.f543740a = r111;
        r116.f543741b = 4;
        r116.f543742c = 3;
        Intrinsics.checkNotNullParameter("IM_MSG_FILE_DOWNLOAD", "entityOperate");
        r116.f543746g = "IM_MSG_FILE_DOWNLOAD";
        r116.b(EntityDomain.EntityDomainIM);
        Intrinsics.checkNotNullParameter("IM_MSG_FILE", "entityType");
        r116.f543744e = "IM_MSG_FILE";
        r116.c(FileBizDomain.FileBizDomainIM);
        Intrinsics.checkNotNullParameter("PointKey_IM_MSG_FILE_DOWNLOAD", "pointKey");
        r116.f543743d = "PointKey_IM_MSG_FILE_DOWNLOAD";
        return r116;
    L7:
        if (r112 == 3) goto L12;
        if (r112 != 4) goto L11;
        int r117 = rwa.a.f539730a;
        Intrinsics.checkNotNullParameter(r111, "auzEntityId");
        swa.a r118 = rwa.a.C7546a.a();
        Intrinsics.checkNotNullParameter(r111, "authZEntityId");
        r118.f543740a = r111;
        r118.f543741b = 5;
        r118.f543742c = 6;
        Intrinsics.checkNotNullParameter("IM_MSG_FILE_DOWNLOAD", "entityOperate");
        r118.f543746g = "IM_MSG_FILE_DOWNLOAD";
        r118.b(EntityDomain.EntityDomainIM);
        Intrinsics.checkNotNullParameter("IM_MSG_FILE", "entityType");
        r118.f543744e = "IM_MSG_FILE";
        r118.c(FileBizDomain.FileBizDomainIM);
        Intrinsics.checkNotNullParameter("PointKey_IM_MSG_FILE_DOWNLOAD", "pointKey");
        r118.f543743d = "PointKey_IM_MSG_FILE_DOWNLOAD";
        return r118;
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        int r119 = rwa.a.f539730a;
        Intrinsics.checkNotNullParameter(r111, "auzEntityId");
        swa.a r120 = rwa.a.C7546a.a();
        Intrinsics.checkNotNullParameter(r111, "authZEntityId");
        r120.f543740a = r111;
        r120.f543741b = 5;
        r120.f543742c = 3;
        Intrinsics.checkNotNullParameter("IM_MSG_FILE_DOWNLOAD", "entityOperate");
        r120.f543746g = "IM_MSG_FILE_DOWNLOAD";
        r120.b(EntityDomain.EntityDomainIM);
        Intrinsics.checkNotNullParameter("IM_MSG_FILE", "entityType");
        r120.f543744e = "IM_MSG_FILE";
        r120.c(FileBizDomain.FileBizDomainIM);
        Intrinsics.checkNotNullParameter("PointKey_IM_MSG_FILE_DOWNLOAD", "pointKey");
        r120.f543743d = "PointKey_IM_MSG_FILE_DOWNLOAD";
        return r120;
    }

    @Override // com.ss.android.lark.auditsdk.v2.d
    public final void a(ValidateResult r100, AuthorizationType r101) {
        Intrinsics.checkNotNullParameter(r101, "authorizationType");
        int r102 = c.f409604d[r101.ordinal()];
        boolean r103 = true;
        if (r102 != 1) goto L5;
        r103 = f409597d.getValue().booleanValue();
    L10:
        if (r103 == true) goto L13;
        Log.e("AuthorizationServiceV2", "securityPolicyReportUserOperate returns for authFg is off, validateResult = " + r100 + ", authorizationType = " + r101);
        return;
    L13:
        if (r100 != null) goto L16;
        Log.e("AuthorizationServiceV2", "securityPolicyReportUserOperate returns for validateResult is null, authorizationType = " + r101);
        return;
    L16:
        Log.i("AuthorizationServiceV2", "securityPolicyReportUserOperate, validateResult = " + r100 + ", authorizationType = " + r101);
        r100.reportUserOperate();
        return;
    L5:
        if (r102 != 2) goto L10;
        r103 = f409596c.getValue().booleanValue();
        goto L10
    }

    @Override // com.ss.android.lark.auditsdk.v2.d
    public final void d(ValidateResult r100, PolicyModel r101) {
        if (r100 == null) goto L5;
        Log.i("AuthorizationServiceV2", "showSecurityPolicyHandleAction, validateResult = " + r100);
        r100.handleAction();
        return;
    L5:
        if (r101 == null) goto L7;
        Log.i("AuthorizationServiceV2", "showSecurityPolicyInterceptInteraction for validateResult is null.");
        Intrinsics.checkNotNullParameter(r101, "policyModel");
        owa.a.d().getSecurityComplianceDependency().a(r101);
        return;
    L7:
        Log.e("AuthorizationServiceV2", "showSecurityPolicyInterceptInteraction failed for policyModel is null.");
    }

    public final ValidateResult n(boolean r100, swa.b r101, ValidateConfig r102) {
        PolicyModel r103 = l(r101);
        AuthEntity r104 = j(r101);
        Log.i("AuthorizationServiceV2", "start synchronous check authority, event {" + r101 + '}');
        ValidateResult r105 = this.f409598a.e(r103, r104, r102);
        Log.i("AuthorizationServiceV2", "result = " + r105.getResult() + ", resultPolicy = " + r105.getResultPolicy() + ", policyMethod = " + r105.getPolicyMethod());
        if (r105.getResult() != ResultType.UNKNOWN) goto L8;
        if (r100 == false) goto L6;
        ResultType r106 = ResultType.ALLOW;
    L7:
        r105.setResult(r106);
        goto L8
    L6:
        r106 = ResultType.DENY;
    L8:
        return r105;
    }

    public static final void f(AuthorizationServiceV2 r110, swa.b[] r111, m r112, ValidateConfig r113) {
        r110.getClass();
        if (r111.length != 0) goto L5;
        boolean r114 = true;
    L6:
        if (r114 == true) goto L14;
        AuthEntity r115 = j(r111[0]);
        ArrayList r100 = new ArrayList(r111.length);
        int r101 = r111.length;
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L11;
        r100.add(l(r111[r102]));
        r102 = r102 + 1;
        goto L9
    L11:
        PolicyModel[] r103 = (PolicyModel[]) r100.toArray(new PolicyModel[0]);
        Log.i("AuthorizationServiceV2", "start asynchronous check authority, event length = " + r111.length + ", events = " + ArraysKt.joinToString$default(r111, ", ", null, null, 0, null, AuthorizationServiceV2$asyncCheckAuthority$1.INSTANCE, 30, null));
        owa.a.d().getSecurityComplianceDependency().f((PolicyModel[]) Arrays.copyOf(r103, r103.length), r115, r113, r112);
        return;
    L14:
        return;
    L5:
        r114 = false;
        goto L6
    }

    public static void m(Context r100, Integer r101, String r110, Integer r111, Integer r112, DialogInterface.OnDismissListener r113, boolean r114) {
        if (r114 == false) goto L5;
        Lazy r115 = AuditUtilsV2.f409687a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UICallbackExecutor.execute(new com.ss.android.lark.auditsdk.v2.utils.b(r101, r110, r111, r100));
        return;
    L5:
        Lazy r116 = AuditUtilsV2.f409687a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UICallbackExecutor.execute(new com.ss.android.lark.auditsdk.v2.utils.a(r101, r110, r111, r100, r112, r113));
    }

    @Override // com.ss.android.lark.auditsdk.v2.d
    public final void b(Context r110, ValidateResult r111, Integer r112, String r113, Integer r210, Integer r211, PolicyModel r212, boolean r213, DialogInterface.OnDismissListener r214) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "validateResult");
        FileAuthResultFrom r100 = r111.getResultPolicy();
        int r101 = c.f409603c[r111.getResult().ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L6;
        return;
    L6:
        Log.i("AuthorizationServiceV2", "Result is ERROR, result from = " + r100.name());
        int r102 = c.f409602b[r100.ordinal()];
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L14;
        if (r102 == 3) goto L13;
        if (r102 != 4) goto L34;
        UICallbackExecutor.execute(new com.ss.android.lark.auditsdk.v2.c(r110, R.string.Lark_IM_DLP_OrgSecPolicyCantDownload_Error));
        return;
    L34:
        return;
    L13:
        UICallbackExecutor.execute(new com.ss.android.lark.auditsdk.v2.c(r110, R.string.Lark_IM_DLP_RunningSecurityChecks_Toast));
        return;
    L14:
        d(r111, r212);
        return;
    L15:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        m(r110, Integer.valueOf(R.string.Lark_IM_IPChangedPermissionChangedTryLater_AlertText), null, null, null, r214, false);
        return;
    L16:
        Log.i("AuthorizationServiceV2", "Result is DENY, result from = " + r100.name());
        int r103 = c.f409602b[r100.ordinal()];
        if (r103 == 1) goto L25;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L23;
        if (r103 != 4) goto L35;
        UICallbackExecutor.execute(new com.ss.android.lark.auditsdk.v2.c(r110, R.string.Lark_IM_DLP_OrgSecPolicyCantDownload_Error));
        return;
    L35:
        return;
    L23:
        UICallbackExecutor.execute(new com.ss.android.lark.auditsdk.v2.c(r110, R.string.Lark_IM_DLP_RunningSecurityChecks_Toast));
        return;
    L24:
        d(r111, r212);
        return;
    L25:
        m(r110, r112, r113, r210, r211, r214, r213);
    }

    public final void g(DownloadAuthorizationEventType r110, String r111, String r112, String r113, String r114, String r115, String r116, Context r117, Integer r118, b r210) {
        Intrinsics.checkNotNullParameter(r110, "eventType");
        Intrinsics.checkNotNullParameter(r111, "auzEntityId");
        Intrinsics.checkNotNullParameter(r117, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "callback");
        AuditParamsUtil.b(k(r110, r111), r113, r114, r115, r116, r112, new com.ss.android.lark.auditsdk.v2.b(this, r210, r117, r118));
    }
}
