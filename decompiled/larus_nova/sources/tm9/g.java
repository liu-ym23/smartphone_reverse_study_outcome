package tm9;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.officesdk.OfficeSDK;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.LaunchTaskFlag;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import com.ss.android.lark.officesdk.executor.OfficeSDKRuntime;
import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import com.ss.android.lark.officesdk.launcher.feed.OfficeSDKFeedAppLauncher;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g implements IOfficeSDKLifeCycle, tm9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f546832a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f546833a = null;

        static {
            int[] r100 = new int[LaunchExperiment.values().length];
            r100[LaunchExperiment.LAUNCH_ALL_AFTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[LaunchExperiment.LAUNCH_ONLY_OFFICE_SDK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[LaunchExperiment.LAUNCH_OFFICE_SDK_RUST_INIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[LaunchExperiment.LAUNCH_OFFICE_SDK_ALL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f546833a = r100;
        }
    }

    public g(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "loginInvoke");
        this.f546832a = r100;
    }

    @Override // tm9.a
    public final void X0(boolean r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        OfficeSDKFeedAppLauncher r102 = new OfficeSDKFeedAppLauncher(r101.getApplication());
        Application r103 = r101.getApplication();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((com.ss.android.lark.officesdk.launcher.feed.b) r102.f433441a.getValue()).a(r103);
        AtomicBoolean r104 = OfficeSDK.f433090a;
        OfficeSDKRuntime r105 = OfficeSDK.f433092c;
        if (r100 == false) goto L7;
        if (r105 == null) goto L8;
        r105.runOnUI(new f(this));
        return;
    L8:
        return;
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
        AtomicBoolean r102 = OfficeSDK.f433090a;
        OfficeSDKRuntime r103 = OfficeSDK.f433092c;
        if (r103 == null) goto L29;
        LaunchTaskFlag r104 = r103.getRuntimeFlag();
        if (r104 == null) goto L29;
        r104.getSdkInitReadyFlag().compareAndSet(false, true);
        LaunchExperiment r105 = OfficeSDK.f433091b.f530687a;
        int r106 = a.f546833a[r105.ordinal()];
        if (r106 != 1) goto L10;
        X0(true);
        return;
    L10:
        if (r106 == 2) goto L25;
        if (r106 == 3) goto L22;
        if (r106 != 4) goto L20;
        if (r104.getFirstFeedShowFlag().get() != true) goto L18;
        X0(true);
        return;
    L18:
        r104.getRustLoginFlag().compareAndSet(false, true);
        r100.runOnUI(new e(this));
        return;
    L20:
        throw new NoWhenBranchMatchedException();
    L22:
        if (r104.getFirstFeedShowFlag().get() != true) goto L33;
        X0(true);
        return;
    L33:
        return;
    L25:
        if (r104.getFirstFeedShowFlag().get() != true) goto L35;
        X0(true);
        return;
    L35:
        return;
    L29:
        X0(true);
    }

    @Override // com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle
    public final void onWarmupFailed(OfficeBizType r100, String r101) {
        IOfficeSDKLifeCycle.DefaultImpls.onWarmupFailed(this, r100, r101);
    }
}
