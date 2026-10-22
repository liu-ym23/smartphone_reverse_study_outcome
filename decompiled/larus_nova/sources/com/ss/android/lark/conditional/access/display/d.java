package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelByKeyRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayPageListRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayPageListResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class d implements com.ss.android.lark.conditional.access.display.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f418056a;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f418057a;

        public b(String r100) {
            this.f418057a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            s r101 = (s) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            String r102 = "";
            if ((r101 instanceof x) == false) goto L11;
            String r103 = this.f418057a;
            r102 = qqb.a.d();     // Catch: Throwable -> L7
            qqb.a.f(r103);     // Catch: Throwable -> L7
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayByKeyRust success.");     // Catch: Throwable -> L7
            Single r104 = Single.just(((x) r101).f253935c);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
        L24:
            return r104;
        L7:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
            throw th;
        L11:
            if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L29;
            String r105 = this.f418057a;
            r102 = qqb.a.d();     // Catch: Throwable -> L25
            qqb.a.f(r105);     // Catch: Throwable -> L25
            LarkError r106 = ((com.bytedance.lark.rustclient.api.c) r101).f253907c.f253922b;     // Catch: Throwable -> L25
            Integer r107 = null;
            if (r106 == null) goto L18;
            LarkError.ErrorDetails r108 = r106.details;     // Catch: Throwable -> L25
            if (r108 == null) goto L18;
            String r109 = r108.x_tt_logid;     // Catch: Throwable -> L25
        L19:
            LarkError r110 = ((com.bytedance.lark.rustclient.api.c) r101).f253907c.f253922b;     // Catch: Throwable -> L25
            if (r110 == null) goto L22;
            r107 = r110.code;     // Catch: Throwable -> L25
        L22:
            String r111 = ((com.bytedance.lark.rustclient.api.c) r101).f253907c.c();     // Catch: Throwable -> L25
            int r112 = ScsLogger.f440428a;     // Catch: Throwable -> L25
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayByKeyRust error. logId is " + r109 + ", code is " + r107 + ", message is " + r111);     // Catch: Throwable -> L25
            r104 = Single.error(((com.bytedance.lark.rustclient.api.c) r101).f253907c.b());     // Catch: Throwable -> L25
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
        L18:
            r109 = null;
        L25:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
            throw th;
        L29:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f418058a;

        public c(String r100) {
            this.f418058a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            s r101 = (s) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            String r102 = "";
            if ((r101 instanceof x) == false) goto L11;
            String r103 = this.f418058a;
            r102 = qqb.a.d();     // Catch: Throwable -> L7
            qqb.a.f(r103);     // Catch: Throwable -> L7
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayByRust success.");     // Catch: Throwable -> L7
            Single r104 = Single.just(((x) r101).f253935c);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
        L24:
            return r104;
        L7:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
            throw th;
        L11:
            if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L29;
            String r105 = this.f418058a;
            r102 = qqb.a.d();     // Catch: Throwable -> L25
            qqb.a.f(r105);     // Catch: Throwable -> L25
            LarkError r106 = ((com.bytedance.lark.rustclient.api.c) r101).f253907c.f253922b;     // Catch: Throwable -> L25
            Integer r107 = null;
            if (r106 == null) goto L18;
            LarkError.ErrorDetails r108 = r106.details;     // Catch: Throwable -> L25
            if (r108 == null) goto L18;
            String r109 = r108.x_tt_logid;     // Catch: Throwable -> L25
        L19:
            LarkError r110 = ((com.bytedance.lark.rustclient.api.c) r101).f253907c.f253922b;     // Catch: Throwable -> L25
            if (r110 == null) goto L22;
            r107 = r110.code;     // Catch: Throwable -> L25
        L22:
            String r111 = ((com.bytedance.lark.rustclient.api.c) r101).f253907c.c();     // Catch: Throwable -> L25
            int r112 = ScsLogger.f440428a;     // Catch: Throwable -> L25
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayByRust error. logId is " + r109 + ", code is " + r107 + ", message is " + r111);     // Catch: Throwable -> L25
            r104 = Single.error(((com.bytedance.lark.rustclient.api.c) r101).f253907c.b());     // Catch: Throwable -> L25
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
        L18:
            r109 = null;
        L25:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r102, "traceId");
            qqb.a.g(r102);
            throw th;
        L29:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.display.d$d, reason: collision with other inner class name */
    public static final class C4917d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f418059a;

        public C4917d(long r100) {
            this.f418059a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            long r100 = System.currentTimeMillis() - this.f418059a;
            FileAuthMonitor.UpdateTrigger[] r101 = FileAuthMonitor.f418450a;
            FileAuthMonitor.g("pageList", 1, r100, null, 999, ((Throwable) r110).getMessage());
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f418060a;

        public e(long r100) {
            this.f418060a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            s r111 = (s) r110;
            Intrinsics.checkNotNullParameter(r111, "it");
            if ((r111 instanceof x) == false) goto L6;
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayPageList success.");
            FileAuthMonitor.h("pageList", System.currentTimeMillis() - this.f418060a);
            return Single.just(((x) r111).f253935c);
        L6:
            if ((r111 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L19;
            long r100 = System.currentTimeMillis() - this.f418060a;
            com.bytedance.lark.rustclient.api.c r112 = (com.bytedance.lark.rustclient.api.c) r111;
            p r101 = r112.f253907c;
            LarkError r102 = r101.f253922b;
            if (r102 == null) goto L12;
            LarkError.ErrorDetails r103 = r102.details;
            if (r103 == null) goto L12;
            String r113 = r103.x_tt_logid;
        L13:
            if (r102 == null) goto L15;
            Integer r114 = r102.code;
        L16:
            String r115 = r101.c();
            int r104 = ScsLogger.f440428a;
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplayPageList error. logId is " + r113 + ", code is " + r114 + ", message is " + r115);
            FileAuthMonitor.UpdateTrigger[] r105 = FileAuthMonitor.f418450a;
            FileAuthMonitor.g("pageList", 1, r100, r113, r114, r115);
            return Single.error(r112.f253907c.b());
        L15:
            r114 = null;
        L12:
            r113 = null;
            goto L13
        L19:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f418061a;

        public f(long r100) {
            this.f418061a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            long r100 = System.currentTimeMillis() - this.f418061a;
            FileAuthMonitor.UpdateTrigger[] r101 = FileAuthMonitor.f418450a;
            FileAuthMonitor.g("mGet", 1, r100, null, 999, ((Throwable) r110).getMessage());
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f418062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f418063b;

        public g(String r100, long r101) {
            this.f418062a = r100;
            this.f418063b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            s r100 = (s) r110;
            Intrinsics.checkNotNullParameter(r100, "it");
            String r101 = "";
            if ((r100 instanceof x) == false) goto L11;
            String r102 = this.f418062a;
            long r103 = this.f418063b;
            r101 = qqb.a.d();     // Catch: Throwable -> L7
            qqb.a.f(r102);     // Catch: Throwable -> L7
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplaySpecifiedIds success.");     // Catch: Throwable -> L7
            FileAuthMonitor.h("mGet", System.currentTimeMillis() - r103);     // Catch: Throwable -> L7
            Single r104 = Single.just(((x) r100).f253935c);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r101, "traceId");
            qqb.a.g(r101);
        L25:
            return r104;
        L7:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r101, "traceId");
            qqb.a.g(r101);
            throw th;
        L11:
            if ((r100 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L30;
            String r105 = this.f418062a;
            long r106 = this.f418063b;
            r101 = qqb.a.d();     // Catch: Throwable -> L26
            qqb.a.f(r105);     // Catch: Throwable -> L26
            long r111 = System.currentTimeMillis() - r106;     // Catch: Throwable -> L26
            LarkError r107 = ((com.bytedance.lark.rustclient.api.c) r100).f253907c.f253922b;     // Catch: Throwable -> L26
            if (r107 == null) goto L18;
            LarkError.ErrorDetails r108 = r107.details;     // Catch: Throwable -> L26
            if (r108 == null) goto L18;
            String r112 = r108.x_tt_logid;     // Catch: Throwable -> L26
        L19:
            LarkError r109 = ((com.bytedance.lark.rustclient.api.c) r100).f253907c.f253922b;     // Catch: Throwable -> L26
            if (r109 == null) goto L22;
            Integer r113 = r109.code;     // Catch: Throwable -> L26
        L23:
            String r114 = ((com.bytedance.lark.rustclient.api.c) r100).f253907c.c();     // Catch: Throwable -> L26
            int r115 = ScsLogger.f440428a;     // Catch: Throwable -> L26
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "fetchCustomDisplaySpecifiedIds error. logId is " + r112 + ", code is " + r113 + ", message is " + r114);     // Catch: Throwable -> L26
            FileAuthMonitor.UpdateTrigger[] r116 = FileAuthMonitor.f418450a;     // Catch: Throwable -> L26
            FileAuthMonitor.g("mGet", 1, r111, r112, r113, r114);     // Catch: Throwable -> L26
            r104 = Single.error(((com.bytedance.lark.rustclient.api.c) r100).f253907c.b());     // Catch: Throwable -> L26
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r101, "traceId");
            qqb.a.g(r101);
            goto L25
        L22:
            r113 = null;
        L18:
            r112 = null;
        L26:
            th = move-exception;
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r101, "traceId");
            qqb.a.g(r101);
            throw th;
        L30:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomDisplayMGetRequest.Builder f418064a;

        public h(CustomDisplayMGetRequest.Builder r100) {
            this.f418064a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (this.f418064a.id_list.size() == ((CustomDisplayMGetResponse) r100).config_list.size()) goto L6;
            FileAuthMonitor.e(102, "");
            return;
        }
    }

    public static final class i<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i<T, R> f418065a = null;

        static {
            f418065a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r110) {
            s r100 = (s) r110;
            Intrinsics.checkNotNullParameter(r100, "it");
            if ((r100 instanceof x) == false) goto L6;
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "queryBlockAction success.");
            return Single.just(((x) r100).f253935c);
        L6:
            if ((r100 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L18;
            com.bytedance.lark.rustclient.api.c r101 = (com.bytedance.lark.rustclient.api.c) r100;
            p r102 = r101.f253907c;
            LarkError r103 = r102.f253922b;
            Integer r104 = null;
            if (r103 == null) goto L12;
            LarkError.ErrorDetails r105 = r103.details;
            if (r105 == null) goto L12;
            String r106 = r105.x_tt_logid;
        L13:
            if (r103 == null) goto L15;
            r104 = r103.code;
        L15:
            String r107 = r102.c();
            SecurityPolicyDialogActionManager r108 = SecurityPolicyDialogActionManager.f418129a;
            r108.getClass();
            InternalSecurityAction r109 = new InternalSecurityAction(new SecurityAction("", null, 0, 0, 14, null), new DecisionData.Action(), CollectionsKt.emptyList());
            Map<String, Object> r111 = r109.getInternalParams();
            CustomDisplayTemplate.Builder r112 = new CustomDisplayTemplate.Builder();
            LarkAppContext.Companion.getClass();
            r111.put("displayModel", r112.title(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), R.string.Lark_PolicyCenter_OperationNotPossible_PopupTitle)).text(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), R.string.Lark_PolicyCenter_ContactOrganizationAdministrator_PopupBody)).handler_list(CollectionsKt.listOf(new CustomDisplayHandler(UIUtils.getString(LarkAppContext.access$getInstance$cp().getContext(), R.string.Lark_PolicyCenter_IUnderstand_Button), "Cancel", "", MapsKt.emptyMap(), MapsKt.emptyMap()))).build());
            Unit r113 = Unit.INSTANCE;
            SecurityPolicyDialogActionManager.e(r108, 92, r109);
            int r114 = ScsLogger.f440428a;
            ScsLogger.d("SecurityPolicy_CustomDisplayNetworkRepository", "queryBlockAction error. logId is " + r106 + ", code is " + r104 + ", message is " + r107);
            return Single.error(r101.f253907c.b());
        L12:
            r106 = null;
            goto L13
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    @Inject
    public d(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f418056a = r100;
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, QueryPolicyCenterResourceBlockActionResponse.ADAPTER, Command.POLICY_CENTER_QUERY_BLOCK_ACTION, null, null, null, null, 248);
        return this.f418056a.h(r100).a().singleOrError().flatMap(i.f418065a);
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<CustomDisplayPageListResponse> a(CustomDisplayPageListRequest.Builder r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        long r100 = System.currentTimeMillis();
        com.bytedance.lark.rustclient.api.d r111 = new com.bytedance.lark.rustclient.api.d(r110, CustomDisplayPageListResponse.ADAPTER, Command.CUSTOM_DISPLAY_PAGE_LIST, null, null, null, null, 248);
        return this.f418056a.h(r111).a().singleOrError().doOnError(new C4917d(r100)).flatMap(new e(r100));
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<CustomDisplayMGetResponse> b(CustomDisplayMGetRequest.Builder r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        String r100 = qqb.a.d();
        long r101 = System.currentTimeMillis();
        com.bytedance.lark.rustclient.api.d r111 = new com.bytedance.lark.rustclient.api.d(r110, CustomDisplayMGetResponse.ADAPTER, Command.CUSTOM_DISPLAY_M_GET, null, null, null, null, 248);
        return this.f418056a.h(r111).a().singleOrError().doOnError(new f(r101)).flatMap(new g(r100, r101)).doOnSuccess(new h(r110));
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<CustomDisplayModelResponse> c(CustomDisplayModelByKeyRequest.Builder r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        String r100 = qqb.a.d();
        com.bytedance.lark.rustclient.api.d r111 = new com.bytedance.lark.rustclient.api.d(r110, CustomDisplayModelResponse.ADAPTER, Command.GET_POLICY_SDK_DISPLAY_CONFIG_BY_KEY, null, null, null, null, 248);
        return this.f418056a.h(r111).a().singleOrError().flatMap(new b(r100));
    }

    @Override // com.ss.android.lark.conditional.access.display.h
    public final Single<CustomDisplayModelResponse> d(CustomDisplayModelRequest.Builder r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        String r100 = qqb.a.d();
        com.bytedance.lark.rustclient.api.d r111 = new com.bytedance.lark.rustclient.api.d(r110, CustomDisplayModelResponse.ADAPTER, Command.GET_POLICY_SDK_DISPLAY_CONFIG, null, null, null, null, 248);
        return this.f418056a.h(r111).a().singleOrError().flatMap(new c(r100));
    }
}
