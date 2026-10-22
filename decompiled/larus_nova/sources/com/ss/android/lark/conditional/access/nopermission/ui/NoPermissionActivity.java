package com.ss.android.lark.conditional.access.nopermission.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.conditional.access.databinding.ScsActivityNoPermissionBinding;
import com.ss.android.lark.conditional.access.databinding.ScsActivityNoPermissionDoubaoBinding;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentCustomNoPermissionBinding;
import com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomDisplayPageUiMode;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomNoPermissionFragment;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.h0;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.BaseSwitches;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000±\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001$\b\u0007\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004Z[\\]B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020'J\u0012\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010-\u001a\u00020'H\u0014J\u0012\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020'H\u0016J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020!H\u0002J\u001a\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u000107H\u0002J,\u00108\u001a\u00020'2\u0006\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u001dH\u0002J\b\u0010<\u001a\u00020'H\u0002J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020'2\u0006\u0010A\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010A\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020'2\u000e\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0IH\u0016J\u0018\u0010K\u001a\u00020'2\u000e\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0IH\u0016J\"\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020\u00172\u0006\u0010O\u001a\u00020\u00172\b\u0010P\u001a\u0004\u0018\u000100H\u0014J\b\u0010Q\u001a\u00020'H\u0002J\u0006\u0010R\u001a\u00020'J\u0006\u0010S\u001a\u00020'J\u000e\u0010T\u001a\u00020'2\u0006\u00103\u001a\u00020!J\b\u0010U\u001a\u00020'H\u0002J\u0010\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020\u0017H\u0002J\b\u0010X\u001a\u00020YH\u0016R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006^"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/OnUserSwitchListener;", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/OnUserListChangeListener;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "dependency", "Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;", "getDependency", "()Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;", "setDependency", "(Lcom/ss/android/lark/conditional/access/dependency/IConditionalAccessModuleDependency;)V", "noPermissionModuleManager", "Lcom/ss/android/lark/conditional/access/nopermission/manager/NoPermissionModuleManager;", "getNoPermissionModuleManager", "()Lcom/ss/android/lark/conditional/access/nopermission/manager/NoPermissionModuleManager;", "setNoPermissionModuleManager", "(Lcom/ss/android/lark/conditional/access/nopermission/manager/NoPermissionModuleManager;)V", "viewBinding", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionActivity$NoPermissionPageViews;", "mNoPermissionType", "", "extraBundle", "Landroid/os/Bundle;", "tvSwitchUser", "Landroid/widget/TextView;", "inSwitchProgress", "", "originalNavigationBarColor", "originalSystemUiVisibility", "currentPageUiMode", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", "killSelf", "observer", "com/ss/android/lark/conditional/access/nopermission/ui/NoPermissionActivity$observer$1", "Lcom/ss/android/lark/conditional/access/nopermission/ui/NoPermissionActivity$observer$1;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "updateInnerViewSize", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", LiveCommonConstants.REASON_ON_DEDTROY, "onNewIntent", "intent", "Landroid/content/Intent;", "onBackPressed", "bindPageLayout", "mode", "resolvePageUiMode", "unauthorizedType", "actionExtra", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "setupFragment", "traceId", "", "forceReplace", "showSwitchActionPanel", SendEventContainerMethodParamModel.EventKinds.onClick, BaseSwitches.V, "Landroid/view/View;", "onUserSwitchBegin", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/UserSwitchBeginContext;", "onUserSwitchFailed", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/UserSwitchFailedContext;", "onUserSwitchSuccess", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/UserSwitchSuccessContext;", "onUserListRemoved", "removedUserList", "", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "onUserListChanged", "userList", "onActivityResult", "requestCode", "resultCode", "data", "killSelfAndRelaunch", "adaptFullScreenWebView", "applyCustomDisplayDefaultUiMode", "applyPageUiMode", "restoreNavigationBar", "updateOuterScrollPaddingBottom", "paddingBottom", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "NoPermissionPageViews", "LarkPageViews", "DoubaoPageViews", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoPermissionActivity extends Hilt_NoPermissionActivity implements View.OnClickListener, qzb.a, mzb.a, d0c.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f418237n = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public k8b.c f418238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    public NoPermissionModuleManager f418239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f418240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f418241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f418242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f418243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f418244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f418245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f418246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CustomDisplayPageUiMode f418247k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f418248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g f418249m;

    public static final class a {
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f418250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FrameLayout f418251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final NestedScrollView f418252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f418253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final FrameLayout f418254e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Space f418255f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f418256g;

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final TextView a() {
            return this.f418256g;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final FrameLayout b() {
            return this.f418251b;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final NestedScrollView c() {
            return this.f418252c;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final LinearLayout d() {
            return this.f418253d;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final Space e() {
            return this.f418255f;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final FrameLayout getContainer() {
            return this.f418254e;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final View getRoot() {
            return this.f418250a;
        }

        public b(ScsActivityNoPermissionDoubaoBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            this.f418250a = r100.f417950a;
            this.f418251b = r100.f417951b;
            this.f418252c = r100.f417955f;
            this.f418253d = r100.f417954e;
            this.f418254e = r100.f417952c;
            this.f418255f = r100.f417956g;
            this.f418256g = r100.f417957h;
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f418257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FrameLayout f418258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final NestedScrollView f418259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f418260d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final FrameLayout f418261e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Space f418262f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f418263g;

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final TextView a() {
            return this.f418263g;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final FrameLayout b() {
            return this.f418258b;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final NestedScrollView c() {
            return this.f418259c;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final LinearLayout d() {
            return this.f418260d;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final Space e() {
            return this.f418262f;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final FrameLayout getContainer() {
            return this.f418261e;
        }

        @Override // com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity.d
        public final View getRoot() {
            return this.f418257a;
        }

        public c(ScsActivityNoPermissionBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            this.f418257a = r100.f417943a;
            this.f418258b = r100.f417944b;
            this.f418259c = r100.f417947e;
            this.f418260d = r100.f417946d;
            this.f418261e = r100.f417945c;
            this.f418262f = r100.f417948f;
            this.f418263g = r100.f417949g;
        }
    }

    public interface d {
        TextView a();

        FrameLayout b();

        NestedScrollView c();

        LinearLayout d();

        Space e();

        FrameLayout getContainer();

        View getRoot();
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionActivity f418264a;

        public e(NoPermissionActivity r100) {
            this.f418264a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f418264a.H1();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionActivity f418265a;

        public f(NoPermissionActivity r100) {
            this.f418265a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110) {
            d r108 = this.f418265a.f418240d;
            if (r108 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r108 = null;
        L6:
            if (Intrinsics.areEqual(r108.c(), r100) == true) goto L8;
            return;
        L8:
            if ((r103 - r101) == (r107 - r105)) goto L10;
        L11:
            this.f418265a.H1();
            return;
        L10:
            if ((r104 - r102) != (r110 - r106)) goto L11;
        }
    }

    public static final class g extends com.ss.android.lark.appcontext.applifecycle.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionActivity f418266a;

        public g(NoPermissionActivity r100) {
            this.f418266a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            boolean r101 = r100.getIntent().getBooleanExtra("can_be_covered", true);
            boolean r102 = this.f418266a.C1().getPassportDependency().d(r100);
            boolean r103 = this.f418266a.C1().n(r100);
            this.f418266a.C1().i(r100);
            int r104 = ScsLogger.f440428a;
            ScsLogger.d("SecurityPolicy_NoPermissionActivity", "onActivityStarted, activity: " + r100 + ", cover: " + r101 + ", isPassportActivity: " + r102);
            NoPermissionActivity r105 = this.f418266a;
            if (r105.f418244h == false) goto L5;
            return;
        L5:
            if (r101 == false) goto L10;
            if (r102 == true) goto L11;
            if (r103 == true) goto L12;
            ScsLogger.d("SecurityPolicy_NoPermissionActivity", "killSelfAndRelaunch");
            r105.f418248l = true;
            r105.finish();
            r105.D1().g();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoPermissionActivity f418267a;

        public h(NoPermissionActivity r100) {
            this.f418267a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f418267a.H1();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final k8b.c C1() {
        k8b.c r100 = this.f418238b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
        return null;
    }

    public final NoPermissionModuleManager D1() {
        NoPermissionModuleManager r100 = this.f418239c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("noPermissionModuleManager");
        return null;
    }

    public final void H1() {
        int r100 = ScsLogger.f440428a;
        StringBuilder r101 = new StringBuilder("updateInnerViewSize, outerScrollView height: ");
        d r102 = this.f418240d;
        ScsFragmentCustomNoPermissionBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L5:
        r101.append(r102.c().getHeight());
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", r101.toString());
        Resources r104 = getResources();
        float r105 = TypedValue.applyDimension(1, 400.0f, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()));
        d r106 = this.f418240d;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r106 = null;
    L8:
        FrameLayout r107 = r106.getContainer();
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L108;
        d r109 = this.f418240d;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r109 = null;
    L14:
        if (r109.d().getMeasuredWidth() <= r105) goto L16;
        int r110 = (int) r105;
    L17:
        r108.width = r110;
        r107.setLayoutParams(r108);
        d r111 = this.f418240d;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r111 = null;
    L20:
        int r112 = r111.c().getHeight();
        d r113 = this.f418240d;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r113 = null;
    L23:
        int r114 = r113.getContainer().getHeight();
        if (r112 >= r114) goto L61;
        Fragment r115 = getSupportFragmentManager().findFragmentByTag(String.valueOf(this.f418241e));
        if ((r115 instanceof CustomNoPermissionFragment) == false) goto L61;
        CustomNoPermissionFragment r116 = (CustomNoPermissionFragment) r115;
        int r117 = r114 - r112;
        ScsFragmentCustomNoPermissionBinding r118 = r116.f418306h;
        if (r118 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r118 = null;
    L30:
        r118.f417965g.requestLayout();
        ScsFragmentCustomNoPermissionBinding r119 = r116.f418306h;
        if (r119 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r119 = null;
    L34:
        if (r119.f417961c.getVisibility() == 8) goto L61;
        if (r116.f418313o == CustomDisplayPageUiMode.LARK) goto L39;
        r116.da0();
        goto L61
    L39:
        ScsFragmentCustomNoPermissionBinding r120 = r116.f418306h;
        if (r120 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r120 = null;
    L43:
        if ((r120.f417965g.getHeight() - r117) < UIUtils.dp2px(r116.requireContext(), 110.0f)) goto L54;
        ScsFragmentCustomNoPermissionBinding r121 = r116.f418306h;
        if (r121 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r121 = null;
    L47:
        NestedScrollView r122 = r121.f417965g;
        ScsFragmentCustomNoPermissionBinding r123 = r116.f418306h;
        if (r123 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r123 = null;
    L50:
        ViewGroup.LayoutParams r124 = r123.f417965g.getLayoutParams();
        ScsFragmentCustomNoPermissionBinding r125 = r116.f418306h;
        if (r125 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r125 = null;
    L53:
        r124.height = r125.f417965g.getHeight() - r117;
        r122.setLayoutParams(r124);
        goto L61
    L54:
        ScsFragmentCustomNoPermissionBinding r126 = r116.f418306h;
        if (r126 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r126 = null;
    L57:
        NestedScrollView r127 = r126.f417965g;
        ScsFragmentCustomNoPermissionBinding r128 = r116.f418306h;
        if (r128 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r128 = null;
    L60:
        ViewGroup.LayoutParams r129 = r128.f417965g.getLayoutParams();
        r129.height = UIUtils.dp2px(r116.requireContext(), 110.0f);
        r127.setLayoutParams(r129);
    L61:
        if (r112 <= r114) goto L109;
        Fragment r130 = getSupportFragmentManager().findFragmentByTag(String.valueOf(this.f418241e));
        if ((r130 instanceof CustomNoPermissionFragment) == false) goto L110;
        CustomNoPermissionFragment r131 = (CustomNoPermissionFragment) r130;
        int r132 = r112 - r114;
        ScsFragmentCustomNoPermissionBinding r133 = r131.f418306h;
        if (r133 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r133 = null;
    L67:
        r133.f417965g.requestLayout();
        ScsFragmentCustomNoPermissionBinding r134 = r131.f418306h;
        if (r134 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r134 = null;
    L71:
        if (r134.f417961c.getVisibility() != 8) goto L74;
        return;
    L74:
        if (r131.f418313o == CustomDisplayPageUiMode.LARK) goto L76;
        r131.da0();
        return;
    L76:
        ScsFragmentCustomNoPermissionBinding r135 = r131.f418306h;
        if (r135 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r135 = null;
    L79:
        int r136 = r135.f417965g.getHeight() + r132;
        ScsFragmentCustomNoPermissionBinding r137 = r131.f418306h;
        if (r137 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r137 = null;
    L83:
        if (r136 >= r137.f417961c.getHeight()) goto L95;
        ScsFragmentCustomNoPermissionBinding r138 = r131.f418306h;
        if (r138 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r138 = null;
    L87:
        NestedScrollView r139 = r138.f417965g;
        ScsFragmentCustomNoPermissionBinding r140 = r131.f418306h;
        if (r140 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r140 = null;
    L90:
        ViewGroup.LayoutParams r141 = r140.f417965g.getLayoutParams();
        ScsFragmentCustomNoPermissionBinding r142 = r131.f418306h;
        if (r142 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L94:
        r141.height = r103.f417965g.getHeight() + r132;
        r139.setLayoutParams(r141);
        return;
    L93:
        r103 = r142;
        goto L94
    L95:
        ScsFragmentCustomNoPermissionBinding r143 = r131.f418306h;
        if (r143 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r143 = null;
    L98:
        NestedScrollView r144 = r143.f417965g;
        ScsFragmentCustomNoPermissionBinding r145 = r131.f418306h;
        if (r145 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r145 = null;
    L101:
        ViewGroup.LayoutParams r146 = r145.f417965g.getLayoutParams();
        ScsFragmentCustomNoPermissionBinding r147 = r131.f418306h;
        if (r147 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L105:
        r146.height = r103.f417961c.getHeight();
        r144.setLayoutParams(r146);
        return;
    L104:
        r103 = r147;
        goto L105
    L110:
        return;
    L109:
        return;
    L16:
        r110 = -1;
        goto L17
    L108:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void I1() {
        d r100 = this.f418240d;
        d r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r100 = null;
    L6:
        if (r100.c().getPaddingBottom() != 0) goto L8;
        return;
    L8:
        d r102 = this.f418240d;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L11:
        NestedScrollView r103 = r102.c();
        d r104 = this.f418240d;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L14:
        int r105 = r104.c().getPaddingLeft();
        d r106 = this.f418240d;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r106 = null;
    L17:
        int r107 = r106.c().getPaddingTop();
        d r108 = this.f418240d;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r108 = null;
    L20:
        r103.setPadding(r105, r107, r108.c().getPaddingRight(), 0);
        d r109 = this.f418240d;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L24:
        r101.c().setClipToPadding(true);
        return;
    L23:
        r101 = r109;
        goto L24
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.ss.android.lark.conditional.access.nopermission.ui.Hilt_NoPermissionActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(NoPermissionActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "back button pressed");
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.Hilt_NoPermissionActivity, com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(NoPermissionActivity.class.getName()));
    L5:
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", LiveCommonConstants.REASON_ON_DEDTROY);
        if (this.f418248l == false) goto L8;
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "kill by self, not release");
    L9:
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "unregisterUserSwitchListener");
        C1().getPassportDependency().k(this);
        C1().getPassportDependency().j(this);
        AppLifecycle.a.f408803a.j(this.f418249m);
        super.onDestroy();
        return;
    L8:
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "not kill by self, need release");
        D1().i();
        goto L9
    }

    public NoPermissionActivity() {
        this.f418247k = CustomDisplayPageUiMode.LARK;
        this.f418249m = new g(this);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.c(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        z1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public static View z1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void A1(CustomDisplayPageUiMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f418247k = r100;
        d r101 = this.f418240d;
        d r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r101 = null;
    L5:
        boolean r103 = true;
        r101.b().setFitsSystemWindows(true);
        d r104 = this.f418240d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L8:
        t4c.b.b(r104.e());
        if (r100 != CustomDisplayPageUiMode.LARK) goto L22;
        I1();
        getWindow().setNavigationBarColor(this.f418245i);
        z1(getWindow()).setSystemUiVisibility(this.f418246j);
        d r105 = this.f418240d;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r105 = null;
    L13:
        r105.a().setTextAppearance(this, com.larus.nova.R.style.UDText_Headline);
        d r106 = this.f418240d;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r106 = null;
    L16:
        r106.a().setTextColor(getResources().getColor(com.larus.nova.R.color.primary_fill_default));
        d r107 = this.f418240d;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L20:
        r102.b().setBackgroundResource(com.larus.nova.R.drawable.scs_common_bg);
        return;
    L19:
        r102 = r107;
        goto L20
    L22:
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, com.larus.nova.R.color.doubao_policy_center_bg));
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L26;
        r103 = false;
    L26:
        int r108 = this.f418246j;
        int r109 = Build.VERSION.SDK_INT;
        if (r109 < 23) goto L32;
        if (r103 == false) goto L30;
        r108 = r108 & (-8193);
        goto L32
    L30:
        r108 = r108 | 8192;
    L32:
        if (r109 < 26) goto L36;
        if (r103 == false) goto L35;
        r108 = r108 & (-17);
        goto L36
    L35:
        r108 = r108 | 16;
    L36:
        z1(getWindow()).setSystemUiVisibility(r108);
        d r110 = this.f418240d;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r110 = null;
    L39:
        r110.b().setBackgroundColor(ContextCompat.getColor(this, com.larus.nova.R.color.doubao_policy_center_bg));
        d r111 = this.f418240d;
        if (r111 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r111 = null;
    L42:
        r111.a().setTextAppearance(this, com.larus.nova.R.style.UDText_Body2);
        d r112 = this.f418240d;
        if (r112 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r112 = null;
    L45:
        h0.a(r112.a(), 500);
        d r113 = this.f418240d;
        if (r113 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r113 = null;
    L48:
        r113.a().setTextSize(14.0f);
        d r114 = this.f418240d;
        if (r114 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r114 = null;
    L51:
        r114.a().setTextColor(ContextCompat.getColor(this, com.larus.nova.R.color.doubao_policy_center_text_secondary));
        d r115 = this.f418240d;
        if (r115 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L55:
        r102.c().post(new e(this));
        return;
    L54:
        r102 = r115;
        goto L55
    }

    public final void B1(CustomDisplayPageUiMode r210) {
        this.f418247k = r210;
        CustomDisplayPageUiMode r100 = CustomDisplayPageUiMode.DOUBAO;
        int r101 = com.larus.nova.R.id.tv_switch;
        d r110 = null;
        if (r210 != r100) goto L27;
        View r111 = getLayoutInflater().inflate(com.larus.nova.R.layout.scs_activity_no_permission_doubao, null, false);
        FrameLayout r112 = (FrameLayout) r111;
        FrameLayout r113 = (FrameLayout) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.container);
        if (r113 == null) goto L24;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.footer_container);
        if (r114 == null) goto L23;
        LinearLayout r115 = (LinearLayout) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.outerContainer);
        if (r115 == null) goto L22;
        NestedScrollView r116 = (NestedScrollView) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.outerScrollView);
        if (r116 != null) goto L13;
        r101 = com.larus.nova.R.id.outerScrollView;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r101)));
    L13:
        if (((Space) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.spaceBottom)) == null) goto L20;
        Space r117 = (Space) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.spaceTop);
        if (r117 == null) goto L19;
        TextView r211 = (TextView) ViewBindings.findChildViewById(r111, com.larus.nova.R.id.tv_switch);
        if (r211 == null) goto L26;
        d r102 = new b(new ScsActivityNoPermissionDoubaoBinding(r112, r112, r113, r114, r115, r116, r117, r211));
    L40:
        this.f418240d = r102;
        setContentView(r102.getRoot());
        d r103 = this.f418240d;
        if (r103 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L43:
        TextView r104 = r103.a();
        this.f418243g = r104;
        if (r104 == null) goto L46;
        r104.setOnClickListener(this);
    L46:
        d r105 = this.f418240d;
        if (r105 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L50:
        r110.c().addOnLayoutChangeListener(new f(this));
        A1(r210);
        return;
    L49:
        r110 = r105;
        goto L50
    L19:
        r101 = com.larus.nova.R.id.spaceTop;
        goto L26
    L20:
        r101 = com.larus.nova.R.id.spaceBottom;
        goto L26
    L22:
        r101 = com.larus.nova.R.id.outerContainer;
        goto L26
    L23:
        r101 = com.larus.nova.R.id.footer_container;
        goto L26
    L24:
        r101 = com.larus.nova.R.id.container;
        goto L26
    L27:
        View r118 = getLayoutInflater().inflate(com.larus.nova.R.layout.scs_activity_no_permission, null, false);
        FrameLayout r119 = (FrameLayout) r118;
        FrameLayout r120 = (FrameLayout) ViewBindings.findChildViewById(r118, com.larus.nova.R.id.container);
        if (r120 == null) goto L56;
        LinearLayout r121 = (LinearLayout) ViewBindings.findChildViewById(r118, com.larus.nova.R.id.outerContainer);
        if (r121 == null) goto L55;
        NestedScrollView r122 = (NestedScrollView) ViewBindings.findChildViewById(r118, com.larus.nova.R.id.outerScrollView);
        if (r122 != null) goto L34;
        r101 = com.larus.nova.R.id.outerScrollView;
    L58:
        throw new NullPointerException("Missing required view with ID: ".concat(r118.getResources().getResourceName(r101)));
    L34:
        if (((Space) ViewBindings.findChildViewById(r118, com.larus.nova.R.id.spaceBottom)) == null) goto L53;
        Space r123 = (Space) ViewBindings.findChildViewById(r118, com.larus.nova.R.id.spaceTop);
        if (r123 == null) goto L52;
        TextView r124 = (TextView) ViewBindings.findChildViewById(r118, com.larus.nova.R.id.tv_switch);
        if (r124 == null) goto L58;
        r102 = new c(new ScsActivityNoPermissionBinding(r119, r119, r120, r121, r122, r123, r124));
        goto L40
    L52:
        r101 = com.larus.nova.R.id.spaceTop;
        goto L58
    L53:
        r101 = com.larus.nova.R.id.spaceBottom;
        goto L58
    L55:
        r101 = com.larus.nova.R.id.outerContainer;
        goto L58
    L56:
        r101 = com.larus.nova.R.id.container;
        goto L58
    }

    @Override // mzb.a
    public final void l0(List<? extends User> r100) {
        Intrinsics.checkNotNullParameter(r100, "removedUserList");
        int r101 = ScsLogger.f440428a;
        StringBuilder r102 = new StringBuilder("onUserListRemoved, removed: ");
        List<? extends User> r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        User r106 = (User) r105.next();
        if (r106 == null) goto L8;
        String r107 = r106.userId;
    L9:
        r104.add(r107);
        goto L4
    L8:
        r107 = null;
        goto L9
    L10:
        r102.append(r104);
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", r102.toString());
        this.f418244h = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        if (Intrinsics.areEqual(r100, this.f418243g) == false) goto L6;
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "tvSwitchUser onClick");
        ((UDActionPanelBuilder) ((UDActionPanelBuilder) new UDActionPanelBuilder(this).title(getString(com.larus.nova.R.string.Lark_Conditions_Action))).items(CollectionsKt.listOf(new String[]{getString(com.larus.nova.R.string.Lark_Conditions_SwitchAccount), getString(com.larus.nova.R.string.Lark_Conditions_Return)})).itemClickListener(new u(this)).addActionButton(com.larus.nova.R.id.ud_dialog_btn_cancel, getString(com.larus.nova.R.string.Lark_Conditions_CancelButton), null)).show();
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        d r101 = null;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r102 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r100 == null) goto L8;
        Integer r103 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:NoPermissionActivity portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r103.intValue() == r102) goto L19;
    L8:
        r103 = null;
    L19:
        d r104 = this.f418240d;
        if (r104 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L23:
        r101.getContainer().post(new h(this));
        return;
    L22:
        r101 = r104;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragmentActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L30
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L30
    L8:
        super.onCreate(r110);
        this.f418241e = getIntent().getIntExtra("unauthorized_type", 0);
        Bundle r111 = getIntent().getBundleExtra("biz_extra");
        Context r100 = BadParcelableCrashOptimizer.getContext();
        if (r111 == null) goto L12;
        if (r100 == null) goto L12;
        r111.setClassLoader(r100.getClassLoader());
    L12:
        this.f418242f = r111;
        if (r111 == null) goto L15;
        InternalSecurityAction r112 = (InternalSecurityAction) r111.getParcelable("param_action");
    L16:
        Bundle r101 = this.f418242f;
        String r102 = "";
        if (r101 == null) goto L20;
        String r103 = r101.getString("param_trace_id");
        if (r103 == null) goto L20;
    L31:
        r102 = qqb.a.d();     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r103, "traceId");     // Catch: Throwable -> L27
        qqb.a.g(r103);     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", WidgetCostModule.TYPE_ON_CREATE);     // Catch: Throwable -> L27
        UIUtils.setStatusBarTransparent(this);     // Catch: Throwable -> L27
        this.f418245i = getWindow().getNavigationBarColor();     // Catch: Throwable -> L27
        this.f418246j = z1(getWindow()).getSystemUiVisibility();     // Catch: Throwable -> L27
        this.f418244h = false;     // Catch: Throwable -> L27
        NoPermissionModuleManager r104 = D1();     // Catch: Throwable -> L27
        r104.getClass();     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "release timer");     // Catch: Throwable -> L27
        Handler r105 = r104.f418116p;     // Catch: Throwable -> L27
        if (r105 == null) goto L24;
        r105.removeCallbacks(r104.f418117q);     // Catch: Throwable -> L27
    L24:
        r104.f418116p = null;     // Catch: Throwable -> L27
        r104.f418111k.postValue(Boolean.FALSE);     // Catch: Throwable -> L27
        r104.f418107g = true;     // Catch: Throwable -> L27
        B1(F1(this.f418241e, r112));     // Catch: Throwable -> L27
        overridePendingTransition(0, 0);     // Catch: Throwable -> L27
        G1(this.f418241e, r112, r103, false);     // Catch: Throwable -> L27
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "registerUserSwitchListener");     // Catch: Throwable -> L27
        C1().getPassportDependency().h(this);     // Catch: Throwable -> L27
        C1().getPassportDependency().g(this);     // Catch: Throwable -> L27
        AppLifecycle.a.f408803a.b(this.f418249m);     // Catch: Throwable -> L27
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r102, "traceId");
        qqb.a.g(r102);
        return;
    L27:
        th = move-exception;
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r102, "traceId");
        qqb.a.g(r102);
        throw th;
    L20:
        r103 = "";
        goto L31
    L15:
        r112 = null;
        goto L16
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        boolean r101 = false;
        this.f418244h = false;
        setIntent(r100);
        NoPermissionModuleManager r102 = D1();
        r102.getClass();
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "release timer");
        Handler r103 = r102.f418116p;
        if (r103 == null) goto L5;
        r103.removeCallbacks(r102.f418117q);
    L5:
        InternalSecurityAction r104 = null;
        r102.f418116p = null;
        r102.f418111k.postValue(Boolean.FALSE);
        r102.f418107g = true;
        if (r100 == null) goto L8;
        int r105 = r100.getIntExtra("unauthorized_type", 0);
    L9:
        this.f418241e = r105;
        if (r100 == null) goto L15;
        Bundle r106 = r100.getBundleExtra("biz_extra");
        Context r107 = BadParcelableCrashOptimizer.getContext();
        if (r106 == null) goto L16;
        if (r107 == null) goto L16;
        r106.setClassLoader(r107.getClassLoader());
    L16:
        this.f418242f = r106;
        if (r106 == null) goto L19;
        r104 = (InternalSecurityAction) r106.getParcelable("param_action");
    L19:
        Bundle r108 = this.f418242f;
        if (r108 == null) goto L23;
        String r109 = r108.getString("param_trace_id");
        if (r109 == null) goto L23;
    L24:
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "onNewIntent, type: " + this.f418241e + ", extra: " + r104);
        CustomDisplayPageUiMode r110 = F1(this.f418241e, r104);
        if (r110 == this.f418247k) goto L27;
        r101 = true;
    L27:
        if (r101 == false) goto L29;
        B1(r110);
    L30:
        G1(this.f418241e, r104, r109, r101);
        return;
    L29:
        A1(r110);
    L23:
        r109 = "";
        goto L24
    L15:
        r106 = null;
        goto L16
    L8:
        r105 = 0;
        goto L9
    }

    @Override // mzb.a
    public final void p0(List<? extends User> r100) {
        Intrinsics.checkNotNullParameter(r100, "userList");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(PassportcConvention.c(this).f438138b);     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        String r103 = (String) r102;
        List<? extends User> r104 = r100;
        boolean r105 = true;
        if ((r104 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r106 = r104.iterator();
    L17:
        if (r106.hasNext() == false) goto L25;
        User r107 = (User) r106.next();
        if (r107 == null) goto L21;
        String r108 = r107.userId;
    L23:
        if (Intrinsics.areEqual(r108, r103) == false) goto L17;
        boolean r109 = true;
    L26:
        int r110 = ScsLogger.f440428a;
        StringBuilder r111 = new StringBuilder("onUserListChanged, myUserId: ");
        r111.append(r103);
        r111.append(", stillPresent: ");
        r111.append(r109);
        r111.append(", list: ");
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r113 = r104.iterator();
    L28:
        if (r113.hasNext() == false) goto L34;
        User r114 = (User) r113.next();
        if (r114 == null) goto L32;
        String r115 = r114.userId;
    L33:
        r112.add(r115);
        goto L28
    L32:
        r115 = null;
        goto L33
    L34:
        r111.append(r112);
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", r111.toString());
        if (r103 != null) goto L37;
    L40:
        if (r105 == true) goto L53;
        if (r109 == true) goto L54;
        this.f418244h = false;
        AppLifecycle.a.f408803a.j(this.f418249m);
        D1().i();
        finish();
        return;
    L54:
        return;
    L53:
        return;
    L37:
        if (r103.length() == 0) goto L40;
        r105 = false;
        goto L40
    L21:
        r108 = null;
    L25:
        r109 = false;
        goto L26
    L13:
        if (r104.isEmpty() == false) goto L15;
    L5:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static CustomDisplayPageUiMode F1(int r100, InternalSecurityAction r101) {
        NoPermissionType[] r102 = NoPermissionType.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        NoPermissionType r105 = r102[r104];
        if (r105.getValue() != r100) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L12;
        r104 = r104 + 1;
    L12:
        if (r105 != null) goto L15;
        r105 = NoPermissionType.UNKNOWN;
    L15:
        return com.ss.android.lark.conditional.access.nopermission.ui.custom.d.a(r105, r101);
    L7:
        r106 = false;
        goto L8
    L11:
        r105 = null;
        goto L12
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", "onActivityResult: " + r100 + ", " + r101);
        if (r100 != 9999) goto L10;
        Fragment r104 = getSupportFragmentManager().findFragmentByTag(String.valueOf(this.f418241e));
        if (r104 == null) goto L10;
        if ((r104 instanceof NoPermissionFragment) == false) goto L10;
        ((NoPermissionFragment) r104).W90("device_apply_view_back");
    L10:
        if (r100 == 10000) goto L12;
        return;
    L12:
        if (r101 != (-1)) goto L24;
        Fragment r105 = getSupportFragmentManager().findFragmentByTag(String.valueOf(this.f418241e));
        if (r105 != null) goto L16;
    L18:
        if (r105 != null) goto L20;
        return;
    L20:
        if ((r105 instanceof CustomNoPermissionFragment) == false) goto L26;
        ((CustomNoPermissionFragment) r105).aa0("device_apply_view_back");
        return;
    L26:
        return;
    L16:
        if ((r105 instanceof DeviceOwnerNoPermissionV2Fragment) == false) goto L18;
        ((DeviceOwnerNoPermissionV2Fragment) r105).W90("device_apply_view_back");
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G1(int r100, InternalSecurityAction r101, String r102, boolean r110) {
        int r103 = ScsLogger.f440428a;
        StringBuilder r104 = new StringBuilder("[end show page], setupFragment, type: ");
        r104.append(r100);
        r104.append(", [traceId:");
        Fragment r105 = null;
        if (r101 == null) goto L5;
        String r106 = r101.getTraceId();
    L6:
        r104.append(r106);
        r104.append(']');
        ScsLogger.d("SecurityPolicy_NoPermissionActivity", r104.toString());
        Fragment r107 = getSupportFragmentManager().findFragmentByTag(String.valueOf(r100));
        if (r110 == true) goto L20;
        if (r107 == 0) goto L20;
        if ((r107 instanceof y) == false) goto L20;
        Bundle r108 = r107.getArguments();
        if (r108 == null) goto L14;
        r108.putParcelable("param_action", r101);
    L14:
        Bundle r109 = r107.getArguments();
        if (r109 == null) goto L17;
        r109.putString("param_trace_id", r102);
    L17:
        ((y) r107).onPageUpdate();
        return;
    L20:
        if (r100 != NoPermissionType.DEVICE_OWNER.getValue()) goto L23;
        r105 = new DeviceOwnerNoPermissionFragment();
    L55:
        if (r105 == null) goto L66;
        int r111 = p8b.a.f528276a;
        JSONObject r112 = new JSONObject();
        r112.put("reason", p8b.a.c(r100));     // Catch: Exception -> L59
    L61:
        p8b.a.d("scs_no_access_view", r112);
        Bundle r113 = new Bundle();
        r113.putParcelable("param_action", r101);
        r113.putString("param_trace_id", r102);
        PassportcConvention.h(r113, PassportcConvention.c(this));
        r105.setArguments(r113);
        FragmentTransaction r114 = getSupportFragmentManager().beginTransaction();
        String r115 = String.valueOf(r100);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r114, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r115, com.larus.nova.R.id.container) == true) goto L65;
        r114 = r114.replace(com.larus.nova.R.id.container, r105, r115);
    L65:
        r114.commitNowAllowingStateLoss();
        return;
    L59:
        e = move-exception;
        int r116 = ScsLogger.f440428a;
        ScsLogger.c("scs-tracker", "tracker exception:" + e.getMessage());
        goto L61
    L66:
        ScsLogger.e("SecurityPolicy_NoPermissionActivity", "Unknown No Permission Type !!");
        finish();
        return;
    L23:
        if (r100 != NoPermissionType.DEVICE_STATE.getValue()) goto L26;
        r105 = new DeviceStateNoPermissionFragment();
        goto L55
    L26:
        if (r100 != NoPermissionType.MFA.getValue()) goto L29;
        r105 = new MFANoPermissionFragment();
        goto L55
    L29:
        if (r100 != NoPermissionType.NETWORK.getValue()) goto L32;
        r105 = new NetworkNoPermissionFragment();
        goto L55
    L32:
        if (r100 != NoPermissionType.DEVICE_OWNER_V2.getValue()) goto L35;
        r105 = new DeviceOwnerNoPermissionV2Fragment();
        goto L55
    L35:
        if (r100 != NoPermissionType.DEVICE_CREDIBILITY.getValue()) goto L38;
        r105 = new DeviceCredibilityNoPermissionFragment();
        goto L55
    L38:
        if (r100 != NoPermissionType.DEVICE_OS.getValue()) goto L41;
        r105 = new DeviceOSNoPermissionFragment();
        goto L55
    L41:
        if (r100 != NoPermissionType.DEVICE_TERMINAL.getValue()) goto L44;
        r105 = new DeviceTerminalNoPermissionFragment();
        goto L55
    L44:
        if (r100 != NoPermissionType.DEVICE_AUTHENTICATION.getValue()) goto L46;
        r105 = new DeviceAuthenticationNoPermissionFragment();
        goto L55
    L46:
        NoPermissionType r117 = NoPermissionType.CUSTOM_DISPLAY;
        if (r100 != r117.getValue()) goto L50;
        r105 = new CustomNoPermissionFragment(r117);
        goto L55
    L50:
        if (r100 != NoPermissionType.OAUTH_REAUTHORIZATION.getValue()) goto L53;
        r105 = new OfficeSDKOAuthReauthorizationFragment();
        goto L55
    L53:
        if (r100 != NoPermissionType.UNKNOWN.getValue()) goto L55;
        r105 = new UnknownNoPermissionFragment();
        goto L55
    L5:
        r106 = null;
        goto L6
    }
}
