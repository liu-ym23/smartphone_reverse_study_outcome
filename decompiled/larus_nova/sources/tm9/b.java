package tm9;

import com.larus.office.base.q;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import com.ss.android.lark.officesdk.api.init.RuntimeStrategy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements IOfficeSDKLifeCycle, tm9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f546825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IOfficeSDKLifeCycle f546826b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f546827a = null;

        static {
            int[] r100 = new int[RuntimeStrategy.values().length];
            r100[RuntimeStrategy.ASYNC_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f546827a = r100;
        }
    }

    public b(q r100) {
        Intrinsics.checkNotNullParameter(r100, "loginInvoke");
        this.f546825a = r100;
    }

    @Override // tm9.a
    public final void X0(boolean r100) {
        IOfficeSDKLifeCycle r101 = this.f546826b;
        if ((r101 instanceof tm9.a) == false) goto L5;
        tm9.a r102 = (tm9.a) r101;
    L6:
        if (r102 == null) goto L9;
        r102.X0(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onLoadFailed(OfficeBizType r100) {
        IOfficeSDKLifeCycle.DefaultImpls.onLoadFailed(this, r100);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onLoadReady(OfficeBizType r100) {
        IOfficeSDKLifeCycle.DefaultImpls.onLoadReady(this, r100);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onLoginSuccess(OfficeSDKUserApi r100) {
        IOfficeSDKLifeCycle.DefaultImpls.onLoginSuccess(this, r100);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onLogoutSuccess(String r100) {
        IOfficeSDKLifeCycle.DefaultImpls.onLogoutSuccess(this, r100);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onUserComponentReady(OfficeSDKUserApi r100) {
        IOfficeSDKLifeCycle.DefaultImpls.onUserComponentReady(this, r100);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onWarmupReady(OfficeBizType r100) {
        IOfficeSDKLifeCycle.DefaultImpls.onWarmupReady(this, r100);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onInitReady(IOfficeSDKRuntime r100, OfficeSDKGlobalApi r101) {
        Intrinsics.checkNotNullParameter(r100, "officeSDKRuntime");
        Intrinsics.checkNotNullParameter(r101, "officeSDKGlobalApi");
        RuntimeStrategy r102 = r100.getStrategy();
        if (a.f546827a[r102.ordinal()] != 1) goto L5;
        IOfficeSDKLifeCycle r103 = new g(this.f546825a);
    L6:
        this.f546826b = r103;
        r103.onInitReady(r100, r101);
        return;
    L5:
        r103 = new d(this.f546825a);
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onWarmupFailed(OfficeBizType r100, String r101) {
        IOfficeSDKLifeCycle.DefaultImpls.onWarmupFailed(this, r100, r101);
    }
}
