package tm9;

import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d implements IOfficeSDKLifeCycle, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f546829a;

    @Override // tm9.a
    public final void X0(boolean r100) {
    }

    public d(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "loginInvoke");
        this.f546829a = r100;
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
        r100.runOnUI(new c(this));
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onWarmupFailed(OfficeBizType r100, String r101) {
        IOfficeSDKLifeCycle.DefaultImpls.onWarmupFailed(this, r100, r101);
    }
}
