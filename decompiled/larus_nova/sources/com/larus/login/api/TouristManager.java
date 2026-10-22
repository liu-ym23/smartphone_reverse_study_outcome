package com.larus.login.api;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.platform.model.TriggerLoginScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0017\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\u0018\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006H\u0016J\u001a\u00101\u001a\u00020\r2\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u00103\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010<\u001a\u00020\rH\u0016J\b\u0010=\u001a\u00020\rH\u0016J\b\u0010>\u001a\u00020\rH\u0016J\u0010\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020\r2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010C\u001a\u00020\r2\u0006\u0010@\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\r2\u0006\u0010@\u001a\u00020DH\u0016J\b\u0010F\u001a\u00020\rH\u0016J\b\u0010G\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R \u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010%¨\u0006H"}, d2 = {"Lcom/larus/login/api/TouristManager;", "Lcom/larus/login/api/ITouristApi;", "<init>", "()V", "impl", "hasSetedImpl", "", "spiImpl", "getSpiImpl", "()Lcom/larus/login/api/ITouristApi;", "spiImpl$delegate", "Lkotlin/Lazy;", "setTouristImpl", "", "tourist", "getImpl", "requestLaunch", "scope", "Lkotlinx/coroutines/CoroutineScope;", "source", "", "markAgeGateError", "code", "", "(Ljava/lang/Long;)V", "baseConstrains", "needSyncFailedMsgWhenLogin", "isMessageLimited", "isCreateBotLimited", "checkAgeGate", "trackerJson", "Lorg/json/JSONObject;", "isHitTouristMode", "revertLimit", "launchAndRiskResult", "Landroidx/lifecycle/LiveData;", "getLaunchAndRiskResult", "()Landroidx/lifecycle/LiveData;", "cvsResult", "Lcom/larus/network/http/Async;", "", "getCvsResult", "markRisk", "value", "getRisk", "openLogin", "scene", "Lcom/larus/platform/model/TriggerLoginScene;", "forceFullScreenLogin", "openHalfLogin", "deepLinkSchema", "checkIfShowRiskDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fm", "Landroidx/fragment/app/FragmentManager;", "handleLimitedState", "handleRiskState", "shark", "msg", "onLoginIn", "onLoginOut", "onLoginFail", "addCallBack", "callBack", "Lcom/larus/login/api/callback/LoginCallBack;", "removeCallBack", "addPanelCallBack", "Lcom/larus/login/api/callback/LoginPanelCallBack;", "removePanelCallBack", "onPanelOpen", "onPanelClose", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouristManager implements ITouristApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TouristManager f357001a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ITouristApi f357002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f357003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f357004d = null;

    private TouristManager() {
    }

    public final ITouristApi e() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (f357003c == false) goto L6;
        ITouristApi r100 = f357002b;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return r100;
    L6:
        f357001a.getClass();     // Catch: Throwable -> L9
        r100 = (ITouristApi) f357004d.getValue();     // Catch: Throwable -> L9
        goto L7
    }

    static {
        f357001a = new TouristManager();
        f357004d = LazyKt.lazy(new l0());
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean a() {
        ITouristApi r100 = e();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.larus.login.api.ITouristApi
    public final void b() {
        ITouristApi r100 = e();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean c() {
        ITouristApi r100 = e();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean f() {
        ITouristApi r100 = e();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f();
    }

    @Override // com.larus.login.api.ITouristApi
    public final void g() {
        ITouristApi r100 = e();
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void h() {
        ITouristApi r100 = e();
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void j() {
        ITouristApi r100 = e();
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void n() {
        ITouristApi r100 = e();
        if (r100 == null) goto L6;
        r100.n();
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean t() {
        ITouristApi r100 = e();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.t();
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean u() {
        ITouristApi r100 = e();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.u();
    }

    @Override // com.larus.login.api.ITouristApi
    public final LiveData<Boolean> w() {
        ITouristApi r100 = e();
        if (r100 == null) goto L7;
        LiveData<Boolean> r101 = r100.w();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new MediatorLiveData();
    }

    @Override // com.larus.login.api.ITouristApi
    public final LiveData<com.larus.network.http.a<Object>> y() {
        ITouristApi r100 = e();
        if (r100 == null) goto L7;
        LiveData<com.larus.network.http.a<Object>> r101 = r100.y();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new MutableLiveData(com.larus.network.http.z.f360206d);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void k(long r100) {
        ITouristApi r101 = e();
        if (r101 == null) goto L6;
        r101.k(r100);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void o(Long r100) {
        ITouristApi r101 = e();
        if (r101 == null) goto L6;
        r101.o(r100);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void p(tj9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        ITouristApi r101 = e();
        if (r101 == null) goto L6;
        r101.p(r100);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void q(JSONObject r100) {
        ITouristApi r101 = e();
        if (r101 == null) goto L6;
        r101.q(r100);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void s(tj9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        ITouristApi r101 = e();
        if (r101 == null) goto L6;
        r101.s(r100);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void v(tj9.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        ITouristApi r101 = e();
        if (r101 == null) goto L6;
        r101.v(r100);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void z(tj9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        ITouristApi r101 = e();
        if (r101 == null) goto L6;
        r101.z(r100);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void d(TriggerLoginScene r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ITouristApi r102 = e();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final boolean i(boolean r100, String r101) {
        ITouristApi r102 = e();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.i(r100, r101);
    }

    @Override // com.larus.login.api.ITouristApi
    public final void m(Context r100, FragmentManager r101) {
        Intrinsics.checkNotNullParameter(r101, "fm");
        ITouristApi r102 = e();
        if (r102 == null) goto L6;
        r102.m(r100, r101);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void r(LifecycleCoroutineScope r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "source");
        ITouristApi r102 = e();
        if (r102 == null) goto L6;
        r102.r(r100, r101);
        return;
    }

    @Override // com.larus.login.api.ITouristApi
    public final void x(TriggerLoginScene r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ITouristApi r102 = e();
        if (r102 == null) goto L6;
        r102.x(r100, r101);
        return;
    }
}
