package com.ss.android.lark.chameleonv2.debug;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.SwitchPreference;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/debug/ChameleonDebugActivity;", "Landroid/preference/PreferenceActivity;", "<init>", "()V", "manager", "Lcom/ss/android/lark/chameleonv2/debug/CmlDebugManager;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "setStatusBarHeight", "setupOpenUrl", "setupIpProxy", "updateIpProxySummary", "preference", "Landroid/preference/Preference;", "setDisableProxy", "setSpecificRes", "updateOfflineResSummary", "isTos", "", "setSpecificResByTos", "setDisableOfflineRes", "setDisableDebugInfoView", "setHeaderDownloadAuth", "Companion", "chameleon-debug_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonDebugActivity extends PreferenceActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f411364b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f411365a;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0110 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ChameleonDebugActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L51;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    public ChameleonDebugActivity() {
        this.f411365a = new f();
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        a(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(Preference r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = CmlDebugSettingUtil.a("chameleon_ip_proxy_bizname", "");
        String r102 = CmlDebugSettingUtil.a("chameleon_ip_proxy_url", "");
        boolean r103 = false;
        if (r101.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L10;
    L14:
        r100.setSummary("设置bizName和调试地址");
        return;
    L10:
        if (r102.length() <= 0) goto L12;
        r103 = true;
    L12:
        if (r103 == false) goto L14;
        r100.setSummary("设置" + r101 + "\n代理地址为:" + r102);
        return;
    L7:
        r104 = false;
        goto L8
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r110);
        if (com.ss.android.lark.chameleonv2.container.webcontainer.util.b.a() == true) goto L13;
        finish();
        return;
    L13:
        addPreferencesFromResource(com.larus.nova.R.xml.chameleon_debug_layout);
        int r111 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        boolean r100 = false;
        if (r111 <= 0) goto L16;
        int r112 = getResources().getDimensionPixelSize(r111);
    L17:
        ((ViewGroup) a(getWindow()).findViewById(R.id.content)).setPadding(0, r112, 0, 0);
        Preference r113 = findPreference("open_url");
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.preference.EditTextPreference");
        EditTextPreference r114 = (EditTextPreference) r113;
        r114.setEnabled(true);
        r114.setOnPreferenceChangeListener(new e(this));
        final Preference r115 = findPreference("cml_debug_ip_proxy");
        b(r115);
        if (r115 == null) goto L20;
        r115.setOnPreferenceClickListener(new ChameleonDebugActivity$setupIpProxy$1(this, r115));
    L20:
        Preference r116 = findPreference("cml_debug_disable_ip_proxy");
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type android.preference.SwitchPreference");
        SwitchPreference r117 = (SwitchPreference) r116;
        r117.setEnabled(true);
        com.ss.android.lark.storage.a r101 = CmlDebugSettingUtil.f411374a;
        Intrinsics.checkNotNullParameter("chameleon_disable_ip_proxy", "key");
        Lazy r102 = CmlDebugSettingUtil.f411375b;
        r117.setChecked(((KVRepo) r102.getValue()).getBoolean("chameleon_disable_ip_proxy", false));
        r117.setOnPreferenceChangeListener(new c(this));
        final Preference r103 = findPreference("cml_debug_offline_res_info");
        final Preference r104 = findPreference("cml_debug_offline_res_info_tos");
        c(r103, false);
        if (r103 == null) goto L23;
        r103.setOnPreferenceClickListener(new ChameleonDebugActivity$setSpecificRes$1(this, r103, r104));
    L23:
        final Preference r105 = findPreference("cml_debug_offline_res_info_tos");
        final Preference r118 = findPreference("cml_debug_offline_res_info");
        c(r105, true);
        if (r105 == null) goto L26;
        r105.setOnPreferenceClickListener(new ChameleonDebugActivity$setSpecificResByTos$1(this, r105, r118));
    L26:
        Preference r119 = findPreference("cml_debug_disable_offline_res");
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.preference.SwitchPreference");
        SwitchPreference r120 = (SwitchPreference) r119;
        r120.setEnabled(true);
        Intrinsics.checkNotNullParameter("chameleon_disable_offline_res", "key");
        r120.setChecked(((KVRepo) r102.getValue()).getBoolean("chameleon_disable_offline_res", false));
        r120.setOnPreferenceChangeListener(new b(this));
        Preference r121 = findPreference("cml_debug_disable_debug_info_view");
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.preference.SwitchPreference");
        SwitchPreference r122 = (SwitchPreference) r121;
        r122.setEnabled(true);
        int r106 = com.ss.android.lark.officesdk.utils.di.e.f437221a;
        DependencyContainer r107 = DependencyContainer.f433166a;
        ntb.f r108 = (ntb.f) DependencyContainer.a(ntb.f.class, null);
        if (r108 == null) goto L29;
        r108.e0();
        r100 = true;
    L29:
        Intrinsics.checkNotNullParameter("chameleon_disable_debug_view", "key");
        r122.setChecked(((KVRepo) r102.getValue()).getBoolean("chameleon_disable_debug_view", !r100));
        r122.setOnPreferenceChangeListener(new com.ss.android.lark.chameleonv2.debug.a(this));
        Preference r123 = findPreference("cml_debug_header_auth");
        if (r123 == null) goto L36;
        r123.setOnPreferenceClickListener(new d(this));
        return;
    L36:
        return;
    L16:
        r112 = 0;
        goto L17
    }

    public final void c(Preference r100, boolean r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = CmlDebugSettingUtil.a("chameleon_specific_bizname", "");
        if (r110 == false) goto L7;
        String r111 = "chameleon_specific_download_url_tos";
    L8:
        String r112 = CmlDebugSettingUtil.a(r111, "");
        String r102 = CmlDebugSettingUtil.a("chameleon_app_name", "");
        String r103 = StringsKt.trimEnd(StringsKt.removeSuffix(r100.getTitle().toString(), "（未启用）")).toString();
        boolean r104 = false;
        if (r101.length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
    L23:
        r100.setTitle(r103 + "（未启用）");
        r100.setSummary("");
        return;
    L14:
        if (r112.length() <= 0) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L23;
        if (r102.length() <= 0) goto L21;
        r104 = true;
    L21:
        if (r104 == false) goto L23;
        r100.setTitle(r103);
        StringBuilder r107 = new StringBuilder("设置");
        r107.append(r101);
        r107.append("\n资源版本为:");
        this.f411365a.getClass();
        r107.append(f.b(r112));
        r100.setSummary(r107.toString());
        return;
    L16:
        r106 = false;
        goto L17
    L11:
        r105 = false;
        goto L12
    L7:
        r111 = "chameleon_specific_download_url_scm";
        goto L8
    }
}
