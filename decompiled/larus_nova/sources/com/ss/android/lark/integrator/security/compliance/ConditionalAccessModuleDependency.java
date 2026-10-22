package com.ss.android.lark.integrator.security.compliance;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class ConditionalAccessModuleDependency implements k8b.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f428039c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConditionalAccessModuleDependency$passportDependency$1 f428040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f428041b;

    public static final class a {
    }

    public static final class b {
        public b() {
        }

        public final void a(Context r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "bundle");
            String r102 = r101.getString("url");
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            ScsLogger.c("OfficeSDKCondAccessDep", "openH5Url url is null or blank, skip");
            return;
        L12:
            f.f428092a.getClass();
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "url");
            if (StringsKt.isBlank(r102) == false) goto L23;
            ScsLogger.c("OfficeSDKSecWebCtn", "openUrl url is blank, skip");
            return;
        L23:
        L20:
            th = move-exception;
            int r104 = ScsLogger.f440428a;
            ScsLogger.c("OfficeSDKSecWebCtn", "openUrl Chameleon.open failed: " + ExceptionsKt.stackTraceToString(th));
            return;
        L16:
            if (f.b(r100, r102) == true) goto L26;
            Chameleon r105 = Chameleon.f411115a;     // Catch: Throwable -> L20
            Chameleon.b(r100, f.a(r102), null);     // Catch: Throwable -> L20
            return;
        L26:
            return;
        L5:
            if (StringsKt.isBlank(r102) == true) goto L8;
            r103 = false;
            goto L9
        }
    }

    public static final class c<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rwb.a f428042a;

        public static final class a implements rwb.a.InterfaceC7547a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SingleEmitter<Unit> f428043a;

            @Override // rwb.a.InterfaceC7547a
            public final void onSuccess() {
                if (this.f428043a.isDisposed() == true) goto L6;
                this.f428043a.onSuccess(Unit.INSTANCE);
                return;
            }

            public a(SingleEmitter<Unit> r100) {
                this.f428043a = r100;
            }

            @Override // rwb.a.InterfaceC7547a
            public final void onError(int r100, String r101) {
                if (this.f428043a.isDisposed() == true) goto L9;
                SingleEmitter<Unit> r102 = this.f428043a;
                StringBuilder r103 = new StringBuilder("Flow conditional access ping failed, code=");
                r103.append(r100);
                r103.append(", message=");
                if (r101 != null) goto L7;
                r101 = "";
            L7:
                r103.append(r101);
                r102.onError(new IllegalStateException(r103.toString()));
                return;
            }
        }

        public c(rwb.a r100) {
            this.f428042a = r100;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            this.f428042a.T0(new a(r100));
        }
    }

    static {
    }

    @Override // k8b.c
    public final void b(Context r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userSession");
    }

    @Override // k8b.c
    public final void i(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // k8b.c
    public final void k(Context r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userSession");
    }

    @Override // k8b.c
    public final void l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // k8b.c
    public final void m(FragmentActivity r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userSession");
    }

    @Override // k8b.c
    public final Single<Boolean> c() {
        return Single.just(Boolean.FALSE);
    }

    @Override // k8b.c
    public final List<PolicyModel> f() {
        IIMApi r100 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r100 == null) goto L5;
        List<IMFileEntity> r101 = r100.getCurrentPageAuthEntities();
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        IMFileEntity r104 = (IMFileEntity) r103.next();
        Intrinsics.checkNotNull(r104);
        r102.add(new PolicyModel("PointKey_IM_MSG_FILE_READ", r104, null, 4, null));
        goto L8
    L10:
        return r102;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // k8b.c
    public final Single<Unit> g() {
        rwb.a r100 = (rwb.a) OfficeSDKManager.getHostGlobalService(rwb.a.class);
        if (r100 != null) goto L7;
        return Single.error(new IllegalStateException("External source ping service is unavailable"));
    L7:
        return Single.create(new c(r100));
    }

    @Inject
    public ConditionalAccessModuleDependency() {
        this.f428040a = new ConditionalAccessModuleDependency$passportDependency$1(this);
        this.f428041b = new b();
    }

    @Override // k8b.c
    public final b e() {
        return this.f428041b;
    }

    @Override // k8b.c
    public final ConditionalAccessModuleDependency$passportDependency$1 getPassportDependency() {
        return this.f428040a;
    }

    @Override // k8b.c
    public final boolean n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r101 = (Activity) r100;
    L6:
        if (r101 == null) goto L12;
        String r102 = r101.getClass().getName();
        List<String> r103 = w4c.c.a().n0();
        if (r103 != null) goto L11;
        r103 = CollectionsKt.emptyList();
    L11:
        return r103.contains(r102);
    L12:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    @Override // k8b.c
    public final void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "userId");
        Toast.makeText(r100, R.string.Lark_PolicyCenter_ContactUnavailable_Toast, 0).show();
    }

    @Override // k8b.c
    public final Single<k8b.a> d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "type");
        return Single.just(new k8b.a());
    }

    @Override // k8b.c
    public final Single h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "nonce");
        return Single.just(new k8b.a());
    }

    @Override // k8b.c
    public final Single<k8b.a> j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "type");
        return Single.just(new k8b.a());
    }
}
