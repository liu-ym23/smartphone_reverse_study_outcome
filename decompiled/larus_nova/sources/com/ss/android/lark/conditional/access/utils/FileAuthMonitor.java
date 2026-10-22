package com.ss.android.lark.conditional.access.utils;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.RegulateDispatcher;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.h;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class FileAuthMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UpdateTrigger[] f418450a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/FileAuthMonitor$AccessControlScene;", "", "<init>", "(Ljava/lang/String;I)V", "OpenBindWebDidPage", "OpenDeviceDeclarePage", "OpenNoPermissionPage", "ModuleInit", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AccessControlScene extends Enum<AccessControlScene> {
        public static final AccessControlScene ModuleInit = null;
        public static final AccessControlScene OpenBindWebDidPage = null;
        public static final AccessControlScene OpenDeviceDeclarePage = null;
        public static final AccessControlScene OpenNoPermissionPage = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AccessControlScene[] f418451a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f418452b = null;

        public static EnumEntries<AccessControlScene> getEntries() {
            return f418452b;
        }

        static {
            AccessControlScene r100 = new AccessControlScene("OpenBindWebDidPage", 0);
            OpenBindWebDidPage = r100;
            AccessControlScene r101 = new AccessControlScene("OpenDeviceDeclarePage", 1);
            OpenDeviceDeclarePage = r101;
            AccessControlScene r102 = new AccessControlScene("OpenNoPermissionPage", 2);
            OpenNoPermissionPage = r102;
            AccessControlScene r103 = new AccessControlScene("ModuleInit", 3);
            ModuleInit = r103;
            AccessControlScene[] r104 = {r100, r101, r102, r103};
            f418451a = r104;
            f418452b = EnumEntriesKt.enumEntries(r104);
        }

        public static AccessControlScene[] values() {
            return (AccessControlScene[]) f418451a.clone();
        }

        public static AccessControlScene valueOf(String r100) {
            return (AccessControlScene) r27.a.a(AccessControlScene.class, r100);
        }

        public AccessControlScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/FileAuthMonitor$CheckType;", "", "<init>", "(Ljava/lang/String;I)V", "CacheCheck", "AsyncCheck", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CheckType extends Enum<CheckType> {
        public static final CheckType AsyncCheck = null;
        public static final CheckType CacheCheck = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CheckType[] f418453a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f418454b = null;

        public static EnumEntries<CheckType> getEntries() {
            return f418454b;
        }

        static {
            CheckType r100 = new CheckType("CacheCheck", 0);
            CacheCheck = r100;
            CheckType r101 = new CheckType("AsyncCheck", 1);
            AsyncCheck = r101;
            CheckType[] r102 = {r100, r101};
            f418453a = r102;
            f418454b = EnumEntriesKt.enumEntries(r102);
        }

        public static CheckType[] values() {
            return (CheckType[]) f418453a.clone();
        }

        public static CheckType valueOf(String r100) {
            return (CheckType) r27.a.a(CheckType.class, r100);
        }

        public CheckType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/FileAuthMonitor$NoPermissionEvent;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MFA_CHECK_STATUS", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NoPermissionEvent extends Enum<NoPermissionEvent> {
        public static final NoPermissionEvent MFA_CHECK_STATUS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NoPermissionEvent[] f418455a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f418456b = null;
        private final String value;

        public static EnumEntries<NoPermissionEvent> getEntries() {
            return f418456b;
        }

        static {
            NoPermissionEvent r100 = new NoPermissionEvent();
            MFA_CHECK_STATUS = r100;
            NoPermissionEvent[] r101 = {r100};
            f418455a = r101;
            f418456b = EnumEntriesKt.enumEntries(r101);
        }

        public NoPermissionEvent() {
            super("MFA_CHECK_STATUS", 0);
            this.value = "mfa_check_status";
        }

        public static NoPermissionEvent[] values() {
            return (NoPermissionEvent[]) f418455a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static NoPermissionEvent valueOf(String r100) {
            return (NoPermissionEvent) r27.a.a(NoPermissionEvent.class, r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/FileAuthMonitor$UpdateTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "ColdBoot", "BackToFront", "NetworkChange", "PushNotification", "UIdChange", "NoCacheRetry", "BusinessCheck", "Retry", "DocScene", "DeviceChange", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UpdateTrigger extends Enum<UpdateTrigger> {
        public static final UpdateTrigger BackToFront = null;
        public static final UpdateTrigger BusinessCheck = null;
        public static final UpdateTrigger ColdBoot = null;
        public static final UpdateTrigger DeviceChange = null;
        public static final UpdateTrigger DocScene = null;
        public static final UpdateTrigger NetworkChange = null;
        public static final UpdateTrigger NoCacheRetry = null;
        public static final UpdateTrigger PushNotification = null;
        public static final UpdateTrigger Retry = null;
        public static final UpdateTrigger UIdChange = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UpdateTrigger[] f418457a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f418458b = null;

        public static EnumEntries<UpdateTrigger> getEntries() {
            return f418458b;
        }

        static {
            UpdateTrigger r100 = new UpdateTrigger("ColdBoot", 0);
            ColdBoot = r100;
            UpdateTrigger r101 = new UpdateTrigger("BackToFront", 1);
            BackToFront = r101;
            UpdateTrigger r102 = new UpdateTrigger("NetworkChange", 2);
            NetworkChange = r102;
            UpdateTrigger r103 = new UpdateTrigger("PushNotification", 3);
            PushNotification = r103;
            UpdateTrigger r104 = new UpdateTrigger("UIdChange", 4);
            UIdChange = r104;
            UpdateTrigger r105 = new UpdateTrigger("NoCacheRetry", 5);
            NoCacheRetry = r105;
            UpdateTrigger r110 = new UpdateTrigger("BusinessCheck", 6);
            BusinessCheck = r110;
            UpdateTrigger r111 = new UpdateTrigger("Retry", 7);
            Retry = r111;
            UpdateTrigger r112 = new UpdateTrigger("DocScene", 8);
            DocScene = r112;
            UpdateTrigger r113 = new UpdateTrigger("DeviceChange", 9);
            DeviceChange = r113;
            UpdateTrigger[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f418457a = r114;
            f418458b = EnumEntriesKt.enumEntries(r114);
        }

        public static UpdateTrigger[] values() {
            return (UpdateTrigger[]) f418457a.clone();
        }

        public static UpdateTrigger valueOf(String r100) {
            return (UpdateTrigger) r27.a.a(UpdateTrigger.class, r100);
        }

        public UpdateTrigger(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UpdateTrigger f418459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f418460b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f418459a == r101.f418459a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f418460b, r101.f418460b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f418459a.hashCode() * 31;
            Object r101 = this.f418460b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "UpdateInfo(trigger=" + this.f418459a + ", info=" + this.f418460b + ')';
        }

        public a(UpdateTrigger r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "trigger");
            this.f418459a = r100;
            this.f418460b = r101;
        }
    }

    public FileAuthMonitor() {
    }

    static {
        f418450a = new UpdateTrigger[]{UpdateTrigger.Retry, UpdateTrigger.BusinessCheck, UpdateTrigger.NoCacheRetry, UpdateTrigger.DocScene};
    }

    public static String a(InternalSecurityAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Object r101 = r100.getInternalParams().get("SDK_MONITOR_TT_LOG_ID");
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L15;
        r102 = r100.getTraceId();
        boolean r103 = true;
        if (r100.getSource() == 1) goto L10;
    L12:
        r103 = false;
    L13:
        if (r103 == true) goto L15;
        return null;
    L10:
        if ((!StringsKt.isBlank(r102)) == false) goto L12;
    L15:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static void b(AccessControlScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        String r101 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_ac_hit_userscope", MapsKt.mapOf(TuplesKt.to("scene", r100.name())), null, null, 0, 28);
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        String r101 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_dlp_engine_error", MapsKt.mapOf(TuplesKt.to("errorType", r100)), null, null, 0, 28);
    }

    public static void e(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        String r102 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_custom_display_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("code", Integer.valueOf(r100)), TuplesKt.to("reason", r101)}), null, null, 0, 28);
    }

    public static /* synthetic */ void h(String r100, long r101) {
        g(r100, 0, r101, null, null, null);
    }

    public static void k(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "pointKey");
        String r102 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_dynamic_capacity", MapsKt.mapOf(TuplesKt.to("pointKey", r100)), MapsKt.mapOf(TuplesKt.to("current_capacity", Long.valueOf(r101))), null, 0, 24);
    }

    public static void l(String r100, InternalSecurityAction r101) {
        Intrinsics.checkNotNullParameter(r100, "fallbackType");
        String r102 = u4c.a.f548750a;
        Pair[] r103 = new Pair[2];
        r103[0] = TuplesKt.to("fallbackType", r100);
        if (r101 == null) goto L7;
        DecisionData.Action r104 = r101.getCurrentAction();
        if (r104 == null) goto L7;
        String r105 = r104.toString();
    L8:
        r103[1] = TuplesKt.to("rawAction", r105);
        u4c.a.a("scs_fallback_view", MapsKt.mapOf(r103), null, null, 0, 28);
        return;
    L7:
        r105 = null;
        goto L8
    }

    public static void n(@RegulateDispatcher.ActionFrom String r110, InternalSecurityAction r111) {
        Intrinsics.checkNotNullParameter(r110, "actionSource");
        Intrinsics.checkNotNullParameter(r111, "action");
        String r100 = r111.getCurrentAction().getName();
        String r101 = r111.getCurrentAction().getParams().get("style");
        String r102 = a(r111);
        String r103 = r111.getCurrentAction().getParams().get("policyType");
        String r104 = r111.getCurrentAction().getParams().get("containerType");
        m8b.c r112 = com.ss.android.lark.conditional.access.network.model.response.a.b(r111.getCurrentAction());
        boolean r105 = false;
        HashMap r113 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("actionSource", r110), TuplesKt.to("actionName", r100)});
        if (r101 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == true) goto L11;
        r113.put("actionStyle", r101);
    L11:
        if (r102 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == true) goto L19;
        r113.put("logId", r102);
    L19:
        if (r103 != null) goto L21;
    L24:
        boolean r108 = true;
    L25:
        if (r108 == true) goto L27;
        r113.put("policyType", r103);
    L27:
        if (r104 != null) goto L29;
    L30:
        r105 = true;
    L31:
        if (r105 == true) goto L33;
        r113.put("containerType", r104);
    L33:
        Integer r109 = r112.f512539a;
        if (r109 == null) goto L36;
        r113.put("challengeType", r109);
    L36:
        String r114 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_handle_action", r113, null, MapsKt.mapOf(TuplesKt.to("actionInfo", r111.toString())), 0, 20);
        return;
    L29:
        if (r104.length() != 0) goto L31;
    L21:
        if (r103.length() == 0) goto L24;
        r108 = false;
        goto L25
    L13:
        if (r102.length() == 0) goto L16;
        r107 = false;
        goto L17
    L5:
        if (r101.length() == 0) goto L8;
        r106 = false;
        goto L9
    }

    public static void s(List r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "factors");
        String r102 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_factor_query", MapsKt.mapOf(TuplesKt.to("factors", r100)), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r101))), null, 0, 24);
    }

    public static void c(InternalSecurityAction r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "pingSource");
        if (r100 != null) goto L5;
        return;
    L5:
        HashMap r103 = new HashMap();
        if (r102 <= 0) goto L8;
        r103.put("duration", Long.valueOf(r102));
    L8:
        String r104 = a(r100);
        m8b.c r110 = com.ss.android.lark.conditional.access.network.model.response.a.b(r100.getCurrentAction());
        String r105 = u4c.a.f548750a;
        u4c.a.a("scs_access_control", MapsKt.mapOf(new Pair[]{TuplesKt.to("event", "ping"), TuplesKt.to("name", r100.getCurrentAction().getName()), TuplesKt.to("policy_type", r100.getCurrentAction().getParams().get("policyType")), TuplesKt.to("challenge_type", r110.f512539a), TuplesKt.to("raw_actions", r100.getRawActions()), TuplesKt.to("ping_source", r101)}), r103, MapsKt.mapOf(TuplesKt.to("log_id", r104)), 0, 16);
    }

    public static void d(InternalSecurityAction r100, String r110, NoPermissionType r111) {
        Intrinsics.checkNotNullParameter(r110, "pageEvent");
        Intrinsics.checkNotNullParameter(r111, "noPermissionType");
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = a(r100);
        m8b.c r102 = com.ss.android.lark.conditional.access.network.model.response.a.b(r100.getCurrentAction());
        String r103 = u4c.a.f548750a;
        u4c.a.a("scs_access_control", MapsKt.mapOf(new Pair[]{TuplesKt.to("event", "access_control_view"), TuplesKt.to("page_event", r110), TuplesKt.to("name", r100.getCurrentAction().getName()), TuplesKt.to("policy_type", r100.getCurrentAction().getParams().get("policyType")), TuplesKt.to("challenge_type", r102.f512539a), TuplesKt.to("raw_actions", r100.getRawActions()), TuplesKt.to("access_control_type", r111.name())}), MapsKt.emptyMap(), MapsKt.mapOf(TuplesKt.to("log_id", r101)), 0, 16);
    }

    public static void j(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "containerType");
        Intrinsics.checkNotNullParameter(r111, "code");
        boolean r100 = false;
        HashMap r101 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("handlerType", "DeviceTokenClaimsChallenge"), TuplesKt.to("containerType", r110), TuplesKt.to("result", "failure"), TuplesKt.to("errorCode", r111)});
        if (r112 != null) goto L5;
    L6:
        r100 = true;
    L7:
        if (r100 == true) goto L9;
        r101.put("errorMsg", r112);
    L9:
        u4c.a.a("scs_security_policy_center_action_button", r101, null, null, 0, 28);
        return;
    L5:
        if (r112.length() != 0) goto L7;
        goto L6
    }

    public static void o(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "actionSource");
        Intrinsics.checkNotNullParameter(r111, "actionInfo");
        Intrinsics.checkNotNullParameter(r112, "errorType");
        String r100 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_handle_action_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("actionSource", r110), TuplesKt.to("errorType", r112)}), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("actionInfo", r111), TuplesKt.to("errorMsg", "")}), 0, 20);
    }

    public static void p(String r100, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "handlerType");
        Intrinsics.checkNotNullParameter(r110, "containerType");
        String r101 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_center_action_button", MapsKt.mapOf(new Pair[]{TuplesKt.to("handlerType", r100), TuplesKt.to("containerType", r110), TuplesKt.to("errorInfo", r111)}), null, null, 0, 28);
    }

    public static void f(int r100, long r110, Integer r111, String r112) {
        if (r110 > 0) goto L5;
        return;
    L5:
        HashMap r101 = new HashMap();
        r101.put("event", "rustAsyncGetConfig");
        r101.put("state", Integer.valueOf(r100));
        if (r111 == null) goto L8;
        r101.put("errorCode", r111);
    L8:
        if (r112 == null) goto L10;
        r101.put("errorMsg", r112);
    L10:
        String r102 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_custom_display", r101, MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r110))), null, 0, 24);
    }

    public static void m(PolicyModel r100, com.ss.android.lark.conditional.access.auth.v2.c r101, CheckType r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        Intrinsics.checkNotNullParameter(r101, "filePolicyResult");
        Intrinsics.checkNotNullParameter(r110, "checkType");
        if (r111 >= 0) goto L5;
        return;
    L5:
        String r102 = u4c.a.f548750a;
        u4c.a.a("lark_scs_file_strategy_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", r101.h().name()), TuplesKt.to("source", r101.g().name()), TuplesKt.to(WikiFolderPushPlugin.OPT, r100.getEntity().getEntityOperate()), TuplesKt.to("entityType", r100.getEntity().getEntityType()), TuplesKt.to("entityDomain", r100.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r100.getPointKey()), TuplesKt.to("fileSourceDomain", h.d(r100.getEntity())), TuplesKt.to("isCredible", Boolean.valueOf(com.ss.android.lark.conditional.access.auth.v2.g.c(r101))), TuplesKt.to("checkType", r110.name())}), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r111))), MapsKt.mapOf(TuplesKt.to("info", r100.toString())), 0, 16);
    }

    public static void q(PolicyModel r110, com.ss.android.lark.conditional.access.auth.v2.c r111, CheckType r112, long r113) {
        Intrinsics.checkNotNullParameter(r110, "policyModel");
        Intrinsics.checkNotNullParameter(r111, "filePolicyResult");
        Intrinsics.checkNotNullParameter(r112, "checkType");
        if (r113 >= 0) goto L5;
        return;
    L5:
        String r100 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", r111.h().name()), TuplesKt.to("source", r111.g().name()), TuplesKt.to(WikiFolderPushPlugin.OPT, r110.getEntity().getEntityOperate()), TuplesKt.to("entityType", r110.getEntity().getEntityType()), TuplesKt.to("entityDomain", r110.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r110.getPointKey()), TuplesKt.to("fileSourceDomain", h.d(r110.getEntity())), TuplesKt.to("isCredible", Boolean.valueOf(com.ss.android.lark.conditional.access.auth.v2.g.c(r111))), TuplesKt.to("checkType", r112.name()), TuplesKt.to("policySetKeys", SequencesKt.joinToString$default(SequencesKt.flatMapIterable(CollectionsKt.asSequence(r111.i()), FileAuthMonitor$reportPolicyResultMergedResult$1.INSTANCE), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null))}), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r113))), MapsKt.mapOf(TuplesKt.to("info", r110.toString())), 0, 16);
    }

    public static void t(PolicyModel r100, ValidateResult r101, CheckType r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        Intrinsics.checkNotNullParameter(r101, "validateResult");
        Intrinsics.checkNotNullParameter(r110, "checkType");
        if (r111 >= 0) goto L5;
        return;
    L5:
        String r102 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_validate_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", r101.getResult().name()), TuplesKt.to("source", r101.getPolicyMethod().name()), TuplesKt.to(WikiFolderPushPlugin.OPT, r100.getEntity().getEntityOperate()), TuplesKt.to("entityType", r100.getEntity().getEntityType()), TuplesKt.to("entityDomain", r100.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r100.getPointKey()), TuplesKt.to("fileSourceDomain", h.d(r100.getEntity())), TuplesKt.to("isCredible", Boolean.valueOf(r101.isCredible())), TuplesKt.to("checkType", r110.name())}), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r111))), MapsKt.mapOf(TuplesKt.to("info", r100.toString())), 0, 16);
    }

    public static void r(String r110, String r111, UpdateTrigger r112, Set r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r111, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r112, "trigger");
        Intrinsics.checkNotNullParameter(r113, "pointKeys");
        Intrinsics.checkNotNullParameter(r114, "notifyType");
        String r100 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_refresh_center_notify", MapsKt.mapOf(new Pair[]{TuplesKt.to("refreshableScene", r110), TuplesKt.to(LocationMonitorConst.IDENTIFIER, r111), TuplesKt.to("trigger", r112.name()), TuplesKt.to("pointKeys", r113), TuplesKt.to("notifyType", r114)}), null, null, 0, 28);
    }

    public static void g(String r100, int r101, long r102, String r103, Integer r104, String r110) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (r102 > 0) goto L5;
        return;
    L5:
        HashMap r105 = new HashMap();
        r105.put("event", "network");
        r105.put("path", r100);
        r105.put("status", Integer.valueOf(r101));
        if (r103 == null) goto L8;
        r105.put("logId", r103);
    L8:
        if (r104 == null) goto L10;
        r105.put("errorCode", r104);
    L10:
        if (r110 == null) goto L12;
        r105.put("errorMsg", r110);
    L12:
        String r106 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_custom_display", r105, MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r102))), null, 0, 24);
    }
}
