package com.ss.android.lark.conditional.access.network.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.security.v1.SubmitMFATokenRequest;
import com.bytedance.lark.pb.security.v1.SubmitMFATokenResponse;
import com.bytedance.lark.pb.security.v1.UserConfirmRequest;
import com.bytedance.lark.pb.security.v1.UserConfirmResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceApplySwitchData;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.g;
import com.ss.android.lark.security.compliance.infra.network.h;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class ConditionalAccessNetDependency {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NoPermissionModuleManager f418076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.security.compliance.infra.network.userscpoe.a f418077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f418078c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency$DeviceApplyStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "NoApply", "Processing", "Pass", "Reject", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DeviceApplyStatus extends Enum<DeviceApplyStatus> {
        public static final DeviceApplyStatus NoApply = null;
        public static final DeviceApplyStatus Pass = null;
        public static final DeviceApplyStatus Processing = null;
        public static final DeviceApplyStatus Reject = null;
        public static final DeviceApplyStatus Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DeviceApplyStatus[] f418079a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f418080b = null;
        private final int value;

        public static EnumEntries<DeviceApplyStatus> getEntries() {
            return f418080b;
        }

        static {
            DeviceApplyStatus r100 = new DeviceApplyStatus("Unknown", 0, 0);
            Unknown = r100;
            DeviceApplyStatus r101 = new DeviceApplyStatus("NoApply", 1, 1);
            NoApply = r101;
            DeviceApplyStatus r102 = new DeviceApplyStatus("Processing", 2, 2);
            Processing = r102;
            DeviceApplyStatus r103 = new DeviceApplyStatus("Pass", 3, 3);
            Pass = r103;
            DeviceApplyStatus r104 = new DeviceApplyStatus("Reject", 4, 4);
            Reject = r104;
            DeviceApplyStatus[] r105 = {r100, r101, r102, r103, r104};
            f418079a = r105;
            f418080b = EnumEntriesKt.enumEntries(r105);
        }

        public static DeviceApplyStatus[] values() {
            return (DeviceApplyStatus[]) f418079a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DeviceApplyStatus valueOf(String r100) {
            return (DeviceApplyStatus) r27.a.a(DeviceApplyStatus.class, r100);
        }

        public DeviceApplyStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/service/ConditionalAccessNetDependency$DeviceOwnership;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Company", "Personal", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DeviceOwnership extends Enum<DeviceOwnership> {
        public static final DeviceOwnership Company = null;
        public static final DeviceOwnership Personal = null;
        public static final DeviceOwnership Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DeviceOwnership[] f418081a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f418082b = null;
        private final int value;

        public static EnumEntries<DeviceOwnership> getEntries() {
            return f418082b;
        }

        static {
            DeviceOwnership r100 = new DeviceOwnership("Unknown", 0, 0);
            Unknown = r100;
            DeviceOwnership r101 = new DeviceOwnership("Company", 1, 1);
            Company = r101;
            DeviceOwnership r102 = new DeviceOwnership("Personal", 2, 2);
            Personal = r102;
            DeviceOwnership[] r103 = {r100, r101, r102};
            f418081a = r103;
            f418082b = EnumEntriesKt.enumEntries(r103);
        }

        public static DeviceOwnership[] values() {
            return (DeviceOwnership[]) f418081a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DeviceOwnership valueOf(String r100) {
            return (DeviceOwnership) r27.a.a(DeviceOwnership.class, r100);
        }

        public DeviceOwnership(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.userscpoe.a f418083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f418084b;

        public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter f418085a;

            @Override // com.ss.android.lark.security.compliance.infra.network.d
            public final Type b() {
                return GetDeviceApplySwitchData.class;
            }

            public a(ObservableEmitter r100) {
                this.f418085a = r100;
            }

            @Override // com.ss.android.lark.security.compliance.infra.network.d
            public final void a(NetworkErrorResult r100) {
                Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
                if (this.f418085a.isDisposed() == true) goto L6;
                this.f418085a.onError(new NetworkErrorResultException(r100));
                return;
            }

            @Override // com.ss.android.lark.security.compliance.infra.network.d
            public final void c(h<T> r100) {
                Intrinsics.checkNotNullParameter(r100, "data");
                if (this.f418085a.isDisposed() == true) goto L6;
                this.f418085a.onNext(r100);
                this.f418085a.onComplete();
                return;
            }
        }

        public b(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r100, com.ss.android.lark.security.compliance.infra.network.a r101) {
            this.f418083a = r100;
            this.f418084b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<h<T>> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f418083a.a(this.f418084b, new a(r100));
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.userscpoe.a f418086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f418087b;

        public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter f418088a;

            @Override // com.ss.android.lark.security.compliance.infra.network.d
            public final Type b() {
                return GetDeviceInfoData.class;
            }

            public a(ObservableEmitter r100) {
                this.f418088a = r100;
            }

            @Override // com.ss.android.lark.security.compliance.infra.network.d
            public final void a(NetworkErrorResult r100) {
                Intrinsics.checkNotNullParameter(r100, "networkErrorResult");
                if (this.f418088a.isDisposed() == true) goto L6;
                this.f418088a.onError(new NetworkErrorResultException(r100));
                return;
            }

            @Override // com.ss.android.lark.security.compliance.infra.network.d
            public final void c(h<T> r100) {
                Intrinsics.checkNotNullParameter(r100, "data");
                if (this.f418088a.isDisposed() == true) goto L6;
                this.f418088a.onNext(r100);
                this.f418088a.onComplete();
                return;
            }
        }

        public c(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r100, com.ss.android.lark.security.compliance.infra.network.a r101) {
            this.f418086a = r100;
            this.f418087b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<h<T>> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f418086a.a(this.f418087b, new a(r100));
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T, R> f418089a = null;

        static {
            f418089a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            s r101 = (s) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if ((r101 instanceof x) == false) goto L6;
            return Single.just(((x) r101).f253935c);
        L6:
            if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L18;
            com.bytedance.lark.rustclient.api.c r102 = (com.bytedance.lark.rustclient.api.c) r101;
            p r103 = r102.f253907c;
            LarkError r104 = r103.f253922b;
            Integer r105 = null;
            if (r104 == null) goto L12;
            LarkError.ErrorDetails r106 = r104.details;
            if (r106 == null) goto L12;
            String r107 = r106.x_tt_logid;
        L13:
            if (r104 == null) goto L15;
            r105 = r104.code;
        L15:
            String r108 = r103.c();
            int r109 = ScsLogger.f440428a;
            ScsLogger.c("ConditionalAccessNetDependency", "submitMFAToken error, logId: " + r107 + ", errorCode: " + r105 + ", error is " + r108);
            return Single.error(r102.f253907c.b());
        L12:
            r107 = null;
            goto L13
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T, R> f418090a = null;

        static {
            f418090a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            s r101 = (s) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if ((r101 instanceof x) == false) goto L6;
            return Single.just(((x) r101).f253935c);
        L6:
            if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L18;
            com.bytedance.lark.rustclient.api.c r102 = (com.bytedance.lark.rustclient.api.c) r101;
            p r103 = r102.f253907c;
            LarkError r104 = r103.f253922b;
            Integer r105 = null;
            if (r104 == null) goto L12;
            LarkError.ErrorDetails r106 = r104.details;
            if (r106 == null) goto L12;
            String r107 = r106.x_tt_logid;
        L13:
            if (r104 == null) goto L15;
            r105 = r104.code;
        L15:
            String r108 = r103.c();
            int r109 = ScsLogger.f440428a;
            ScsLogger.c("ConditionalAccessNetDependency", "userConfirm error, logId: " + r107 + ", errorCode: " + r105 + ", error is " + r108);
            return Single.error(r102.f253907c.b());
        L12:
            r107 = null;
            goto L13
        L18:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public final Single<h<GetDeviceApplySwitchData>> a() {
        HttpMethod r100 = HttpMethod.GET;
        HttpParams r101 = new HttpParams();
        HttpHeaders r102 = new HttpHeaders();
        LinkedHashMap r103 = new LinkedHashMap();
        HttpMethod r104 = HttpMethod.GET;
        Intrinsics.checkNotNullParameter(r104, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/device/apply_switch/", "path");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r105 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/device/apply_switch/", r104, r101, r102, new JSONObject(r103), true);
        r105.c("");
        return Observable.create(new b(this.f418077b, r105)).singleOrError();
    }

    public final Single<h<GetDeviceInfoData>> b() {
        HttpMethod r100 = HttpMethod.GET;
        HttpParams r101 = new HttpParams();
        HttpHeaders r102 = new HttpHeaders();
        LinkedHashMap r103 = new LinkedHashMap();
        HttpMethod r104 = HttpMethod.GET;
        Intrinsics.checkNotNullParameter(r104, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter("/lark/scs/compliance/device/info/", "path");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        com.ss.android.lark.security.compliance.infra.network.a r105 = new com.ss.android.lark.security.compliance.infra.network.a("/lark/scs/compliance/device/info/", r104, r101, r102, new JSONObject(r103), true);
        r105.c("");
        return Observable.create(new c(this.f418077b, r105)).singleOrError();
    }

    public final Single<UserConfirmResponse> d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "userConfirmParams");
        UserConfirmRequest.Builder r100 = new UserConfirmRequest.Builder().user_confirm_params(r110);
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r111 = new com.bytedance.lark.rustclient.api.d(r100, UserConfirmResponse.ADAPTER, Command.POLICY_CENTER_USER_CONFIRM, null, null, null, null, 248);
        return this.f418078c.h(r111).a().singleOrError().flatMap(e.f418090a);
    }

    public final Single<SubmitMFATokenResponse> c(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r111, "mfaParams");
        SubmitMFATokenRequest.Builder r100 = new SubmitMFATokenRequest.Builder().mfa_token(r110).mfa_params(r111);
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r112 = new com.bytedance.lark.rustclient.api.d(r100, SubmitMFATokenResponse.ADAPTER, Command.POLICY_CENTER_SUBMIT_MFA_TOKEN, null, null, null, null, 248);
        return this.f418078c.h(r112).a().singleOrError().flatMap(d.f418089a);
    }

    @Inject
    public ConditionalAccessNetDependency(NoPermissionModuleManager r100, com.ss.android.lark.security.compliance.infra.network.userscpoe.a r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "noPermissionModuleManager");
        Intrinsics.checkNotNullParameter(r101, "requestService");
        Intrinsics.checkNotNullParameter(r102, "userClient");
        this.f418076a = r100;
        this.f418077b = r101;
        this.f418078c = r102;
    }
}
