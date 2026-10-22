package com.larus.shortcuts.impl.pin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.crash.Npth;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.u;
import com.larus.nova.R;
import com.larus.shortcuts.impl.ShortcutCommonUtil;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import t19.s;
import v19.j5;

/* JADX INFO: loaded from: classes31.dex */
public final class PinShortcutProcess {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f369236h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tw9.a f369237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f369238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f369239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PinShortcutLifecycleObserver f369240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ShortcutStatusReceiver f369241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f369242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f369243g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/larus/shortcuts/impl/pin/PinShortcutProcess$PinShortcutLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "(Lcom/larus/shortcuts/impl/pin/PinShortcutProcess;)V", "onPause", "", "onResume", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PinShortcutLifecycleObserver implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinShortcutProcess f369244a;

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public final void onPause() {
            this.f369244a.f369239c = 1;
            this.f369244a.f369242f = AppHost.f326268a.getAppClock().currentTimeMillis();
            FLogger.f375446a.i("PinShortcutUtil", this + ", page onpause, currentTime: " + this.f369244a.f369242f);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            AppHost.Companion r100 = AppHost.f326268a;
            long r101 = r100.getAppClock().currentTimeMillis();
            PinShortcutProcess r102 = this.f369244a;
            long r103 = r102.f369242f;
            long r104 = r101 - r103;
            if (r103 > 0) goto L5;
        L7:
            if (r103 > 0) goto L9;
        L16:
            this.f369244a.f369242f = -1;
            FLogger.f375446a.i("PinShortcutUtil", this + ", page onResume, currentTime: " + r100.getAppClock().currentTimeMillis());
            return;
        L9:
            if (r104 <= 1000) goto L16;
            FLogger.f375446a.i("PinShortcutUtil", this + ", >1000L");
            this.f369244a.getClass();
            FragmentActivity r105 = PinShortcutProcess.d();
            if (r105 == null) goto L15;
            Lifecycle r106 = r105.getLifecycle();
            if (r106 == null) goto L15;
            r106.removeObserver(this.f369244a.f369240d);
        L15:
            PinShortcutProcess r107 = this.f369244a;
            r107.e(r107.f369237a, r107.f369238b, false);
            goto L16
        L5:
            if (r104 >= 100) goto L7;
            r102.f369239c = 0;
            FLogger.f375446a.i("PinShortcutUtil", this + ", <100L");
            goto L16
        }

        public PinShortcutLifecycleObserver(PinShortcutProcess r100) {
            this.f369244a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/shortcuts/impl/pin/PinShortcutProcess$ShortcutStatusReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/larus/shortcuts/impl/pin/PinShortcutProcess;)V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ShortcutStatusReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f369245b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinShortcutProcess f369246a;

        public ShortcutStatusReceiver(PinShortcutProcess r100) {
            this.f369246a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("onReceive: ");
            String r104 = null;
            if (r101 == null) goto L5;
            String r105 = r101.getAction();
        L6:
            r103.append(r105);
            r102.i("PinShortcutUtil", r103.toString());
        L31:
            e = move-exception;
            FLogger.f375446a.i("PinShortcutUtil", "Receive onException: " + e.getMessage());
            return;
        L8:
            if (this.f369246a.f369243g == false) goto L14;
            StringBuilder r106 = new StringBuilder("has accept receive: ");     // Catch: Exception -> L31
            if (r101 == null) goto L12;
            r104 = r101.getAction();     // Catch: Exception -> L31
        L12:
            r106.append(r104);     // Catch: Exception -> L31
            r102.i("PinShortcutUtil", r106.toString());     // Catch: Exception -> L31
            return;
        L14:
            t0.f375468a.postDelayed(new com.larus.shortcuts.impl.pin.b(), 500);     // Catch: Exception -> L31
            this.f369246a.g(AppHost.f326268a.getApplication());     // Catch: Exception -> L31
            this.f369246a.getClass();     // Catch: Exception -> L31
            FragmentActivity r107 = PinShortcutProcess.d();     // Catch: Exception -> L31
            if (r107 == null) goto L19;
            Lifecycle r108 = r107.getLifecycle();     // Catch: Exception -> L31
            if (r108 == null) goto L19;
            r108.removeObserver(this.f369246a.f369240d);     // Catch: Exception -> L31
        L19:
            PinShortcutProcess r109 = this.f369246a;     // Catch: Exception -> L31
            r109.f369243g = true;     // Catch: Exception -> L31
            r109.f369239c = 1;     // Catch: Exception -> L31
            if (r101 == null) goto L37;
            Bundle r110 = r101.getExtras();     // Catch: Exception -> L31
            if (r110 == null) goto L38;
            String r111 = r110.getString("event_params");     // Catch: Exception -> L31
            if (r111 == null) goto L39;
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L27
            tx9.c.b(Boolean.TRUE, new JSONObject(r111));     // Catch: Throwable -> L27
            Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L29:
            Result.m9448boximpl(r113);     // Catch: Exception -> L31
            return;
        L27:
            th = move-exception;
            Result.Companion r114 = Result.Companion;     // Catch: Exception -> L31
            r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L31
            goto L29
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public static final class a {
    }

    public static final class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinShortcutProcess f369247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f369248b;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            this.f369247a.getClass();
            FragmentActivity r100 = PinShortcutProcess.d();
            if (r100 == null) goto L7;
            Lifecycle r101 = r100.getLifecycle();
            if (r101 == null) goto L7;
            r101.removeObserver(this.f369247a.f369240d);
        L7:
            this.f369247a.getClass();
            FragmentActivity r102 = PinShortcutProcess.d();
            if (r102 == null) goto L12;
            Lifecycle r103 = r102.getLifecycle();
            if (r103 == null) goto L12;
            r103.addObserver(this.f369247a.f369240d);
        L12:
            this.f369247a.getClass();
            FragmentActivity r104 = PinShortcutProcess.d();
            if (r104 == null) goto L64;
            String r105 = com.larus.shortcuts.impl.pin.a.f369249a;
            Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
            String r106 = com.larus.shortcuts.impl.pin.a.f369249a;
            boolean r107 = false;
            if (StringsKt.contains$default(r106, DimLocationCheckUtil.XIAOMI, false, 2, null) == false) goto L36;
            String r108 = DeviceUtils.getSystemProperty("ro.miui.ui.version.name");
            if (TextUtils.isEmpty(r108) == false) goto L19;
        L34:
            Intent r109 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            r109.putExtra("extra_pkgname", r104.getPackageName());
        L68:
            r109.putExtra("start_only_for_android", true);     // Catch: Exception -> L60
            r104.startActivity(r109);     // Catch: Exception -> L60
        L60:
            r104.startActivity(com.larus.shortcuts.impl.pin.a.e(r104));     // Catch: Exception -> L62
        L62:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
            FLogger.f375446a.e("ShortcutPermissionUtil", "goSettingPage error, " + e.getMessage());
            goto L64
        L19:
            if (StringsKt.contains$default(r108, "V7", false, 2, null) == true) goto L34;
            if (StringsKt.contains$default(r108, "V8", false, 2, null) == true) goto L34;
            if (TextUtils.isEmpty(r108) == false) goto L26;
        L33:
            r109 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            r109.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
            r109.putExtra("extra_pkgname", r104.getPackageName());
            goto L68
        L26:
            if (StringsKt.contains$default(r108, "V9", false, 2, null) == true) goto L33;
            if (StringsKt.contains$default(r108, "V10", false, 2, null) == true) goto L33;
            if (StringsKt.contains$default(r108, "V11", false, 2, null) == true) goto L33;
            r109 = com.larus.shortcuts.impl.pin.a.e(r104);
            goto L68
        L36:
            if (StringsKt.contains$default(r106, AppConstants.CHANNEL_OPPO, false, 2, null) == false) goto L44;
            r109 = new Intent();
            r109.putExtra("packageName", r104.getPackageName());
            r109.setClassName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity");
            if (r104.getPackageManager().queryIntentActivities(r109, 65536).size() <= 0) goto L40;
            r107 = true;
        L40:
            if (r107 == true) goto L68;
            r109.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
            goto L68
        L44:
            if (StringsKt.contains$default(r106, DimLocationCheckUtil.VIVO, false, 2, null) == false) goto L52;
            r109 = new Intent();
            r109.putExtra("packagename", r104.getPackageName());
            r109.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
            if (r104.getPackageManager().queryIntentActivities(r109, 65536).size() <= 0) goto L48;
            r107 = true;
        L48:
            if (r107 == true) goto L68;
            r109.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
            goto L68
        L52:
            if (StringsKt.contains$default(r106, "meizu", false, 2, null) == true) goto L54;
            r109 = com.larus.shortcuts.impl.pin.a.e(r104);
            goto L68
        L54:
            if (Build.VERSION.SDK_INT < 24) goto L56;
            r109 = com.larus.shortcuts.impl.pin.a.e(r104);
            goto L68
        L56:
            r109 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            r109.putExtra("packageName", r104.getPackageName());
            r109.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        L64:
            JSONObject r110 = this.f369248b;
            if (r110 == null) goto L71;
            Intrinsics.checkNotNullParameter(r110, "params");
            TrackParams r111 = new TrackParams().merge(r110);
            by7.a r112 = new by7.a("add_shortcut_toast_click");
            r112.f21463a.merge(r111);
            r112.b();
            return;
        }

        public b(PinShortcutProcess r100, JSONObject r101) {
            this.f369247a = r100;
            this.f369248b = r101;
        }
    }

    static {
    }

    public static FragmentActivity d() {
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if ((r100 instanceof FragmentActivity) == true) goto L7;
        return null;
    L7:
        return (FragmentActivity) r100;
    }

    public final void f(JSONObject r100) {
        FragmentActivity r101 = d();
        if (r101 == null) goto L26;
        FragmentManager r102 = r101.getSupportFragmentManager();
        if (r102 == null) goto L27;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "params");
        TrackParams r103 = new TrackParams().merge(r100);
        by7.a r104 = new by7.a("add_shortcut_toast_show");
        r104.f21463a.merge(r103);
        r104.b();
    L9:
        CommonDialog.a r105 = new CommonDialog.a();
        AppHost.Companion r106 = AppHost.f326268a;
        if (r106.isOversea() == false) goto L12;
        String r107 = j5.a(r106.getApplication(), R.string.app_string_name, R.string.larus_dola_cici_android_addToHomescreen_popup_title_global);
    L13:
        r105.i(r107);
        CommonDialog.a.e(r105, new b(this, r100), r106.getApplication().getString(R.string.larus_android_addToHomescreen_popup_gotosettings), 4);
        if (r106.isOversea() == false) goto L16;
        String r108 = j5.a(r106.getApplication(), R.string.app_string_name, R.string.larus_dola_cici_android_addToHomescreen_popup_description_global);
    L17:
        r105.g(r108);
        r105.f327194w = true;
        CommonDialog r109 = r105.a();
        LandscapeRestrictionOperation r110 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r109, null, r110);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r102, r109, r110) == true) goto L28;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L21:
        r109.show(r102, null);
        return;
    L28:
        return;
    L16:
        r108 = r106.getApplication().getString(R.string.larus_db_android_addToHomescreen_popup_description_cn);
        Intrinsics.checkNotNull(r108);
        goto L17
    L12:
        r107 = r106.getApplication().getString(R.string.larus_db_android_addToHomescreen_popup_title_cn);
        Intrinsics.checkNotNull(r107);
        goto L13
    L27:
        return;
    }

    public final void g(Context r100) {
        ShortcutStatusReceiver r101 = this.f369241e;
        if (r101 == null) goto L18;
        if (r100 == null) goto L14;
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L16;
        r100.unregisterReceiver(r101);
        goto L14
    L16:
    L11:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r101.toString());
        e.printStackTrace();
        goto L14
    L8:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L14;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L11
    L14:
        this.f369241e = null;
        return;
    }

    public PinShortcutProcess(tw9.a r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "flowShortcutInfo");
        this.f369237a = r100;
        this.f369238b = r101;
        this.f369240d = new PinShortcutLifecycleObserver(this);
        FLogger r102 = FLogger.f375446a;
        r102.i("PinShortcutUtil", "start pin, info: " + r100);
        this.f369239c = 0;
        AppHost.Companion r103 = AppHost.f326268a;
        g(r103.getApplication());
        if (((ShortcutManager) e.f369251a.getValue()).isRequestPinShortcutSupported() == true) goto L22;
        f(r101);
    L22:
        String r104 = com.larus.shortcuts.impl.pin.a.f369249a;     // Catch: Throwable -> L7
        int r105 = com.larus.shortcuts.impl.pin.a.d(r103.getApplication());     // Catch: Throwable -> L7
        r102.i("PinShortcutUtil", "tryAddShortCut permission is " + r105);     // Catch: Throwable -> L7
    L9:
        if (r105 != 0) goto L11;
        f(this.f369238b);
    L20:
        this.f369242f = -1;
        return;
    L11:
        if (r105 == 1) goto L18;
        FragmentActivity r106 = d();
        if (r106 == null) goto L17;
        Lifecycle r107 = r106.getLifecycle();
        if (r107 == null) goto L17;
        r107.addObserver(this.f369240d);
    L17:
        e(this.f369237a, this.f369238b, true);
        goto L20
    L18:
        e(this.f369237a, this.f369238b, false);
    L7:
        th = move-exception;
        FLogger.f375446a.e("PinShortcutUtil", "t is " + th.getMessage());
        r105 = 2;
        goto L9
    }

    public static final Object b(PinShortcutProcess r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof PinShortcutProcess$pinAfterCheck$1) == false) goto L7;
        PinShortcutProcess$pinAfterCheck$1 r102 = (PinShortcutProcess$pinAfterCheck$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        boolean r107 = r102.Z$0;
        ResultKt.throwOnFailure(r104);
    L24:
        if (r107 == false) goto L26;
    L28:
        if (r107 == false) goto L30;
    L32:
        if (r107 == false) goto L34;
        FLogger.f375446a.i("PinShortcutUtil", "delay 2000, success");
    L36:
        return Unit.INSTANCE;
    L34:
        FLogger.f375446a.i("PinShortcutUtil", "delay 2000， what?");
        goto L36
    L30:
        if (r100.f369239c != 1) goto L32;
        FLogger.f375446a.i("PinShortcutUtil", "delay 2000, has system dialog");
        goto L36
    L26:
        if (r100.f369239c == 1) goto L28;
        FLogger.f375446a.i("PinShortcutUtil", "delay 2000, no system dialog&fail");
        r100.f(r100.f369238b);
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L19:
        Lazy r108 = e.f369251a;
        boolean r109 = e.a(r100.f369237a.b());
        MainCoroutineDispatcher r110 = Dispatchers.getMain();
        PinShortcutProcess$pinAfterCheck$2 r111 = new PinShortcutProcess$pinAfterCheck$2(r100, null);
        r102.Z$0 = r109;
        r102.label = 2;
        if (BuildersKt.withContext(r110, r111, r102) == r105) goto L38;
        r107 = r109;
        goto L24
    L38:
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        if (DelayKt.delay(1000, r102) != r105) goto L19;
        return r105;
    L7:
        r102 = new PinShortcutProcess$pinAfterCheck$1(r100, r101);
        goto L8
    }

    public static final void c(PinShortcutProcess r110, Context r111) {
        if (r110.f369241e != null) goto L74;
        r110.f369241e = new ShortcutStatusReceiver(r110);
        IntentFilter r100 = new IntentFilter();
        r100.addAction("com.larus.shortcut.action.INSTALL_SHORTCUT");
        if (Build.VERSION.SDK_INT < 33) goto L36;
        if (r111 == null) goto L75;
        ShortcutStatusReceiver r112 = r110.f369241e;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L71;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L71:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.registerReceiver(r112, r100, 2);
        return;
    L35:
        throw e;
    L11:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L22;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r112, r100, 2, null, null, 3, r111).result;     // Catch: Exception -> L31
        if (r101 == 1) goto L20;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L70;
        r111.registerReceiver(r112, r100, 2);     // Catch: Exception -> L31
    L70:
        return;
    L19:
        new Intent();     // Catch: Exception -> L31
        goto L70
    L20:
        r111.registerReceiver(r112, r100, 2);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r111.registerReceiver(r112, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L70
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r111.registerReceiver(r112, r100, 2);     // Catch: Exception -> L31
        goto L70
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r111, r112, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L31
        goto L70
    L75:
        return;
    L36:
        if (r111 == null) goto L77;
        ShortcutStatusReceiver r113 = r110.f369241e;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L61:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.registerReceiver(r113, r100);
        return;
    L65:
        throw e;
    L41:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L52;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L52;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r113, r100, 0, null, null, 2, r111).result;     // Catch: Exception -> L61
        if (r102 == 1) goto L50;
        if (r102 == 2) goto L49;
        if (r102 == 3) goto L67;
        r111.registerReceiver(r113, r100);     // Catch: Exception -> L61
    L67:
        return;
    L49:
        new Intent();     // Catch: Exception -> L61
        goto L67
    L50:
        r111.registerReceiver(r113, r100);     // Catch: Exception -> L61
    L52:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L55;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L61
        r111.registerReceiver(r113, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L61
        goto L67
    L55:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L57;
    L59:
        r111.registerReceiver(r113, r100);     // Catch: Exception -> L61
        goto L67
    L57:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L59;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L61
        ContextCompat.registerReceiver(r111, r113, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L61
        goto L67
    L77:
        return;
    }

    public static final Object a(PinShortcutProcess r100, tw9.a r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof PinShortcutProcess$buildShortcutInfo$1) == false) goto L7;
        PinShortcutProcess$buildShortcutInfo$1 r103 = (PinShortcutProcess$buildShortcutInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (tw9.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L18:
        if (r101.f547801a != null) goto L23;
        if (o0.d(r101.a()) == false) goto L23;
        s.f544207a.g(AppHost.f326268a.getApplication(), R.string.larus_log_in_internet_error, false);
    L39:
        return null;
    L23:
        if (r101.d() == null) goto L39;
        if (r101.g() == null) goto L39;
        Bitmap r109 = r101.f547801a;
        if (r109 != null) goto L30;
    L36:
        Icon r110 = Icon.createWithResource(AppHost.f326268a.getApplication(), R.drawable.larus_common_ui_avatar_placeholder);
    L37:
        Intrinsics.checkNotNull(r110);
        ShortcutInfo.Builder r111 = new ShortcutInfo.Builder(AppHost.f326268a.getApplication(), r101.b());
        String r112 = r101.d();
        Intrinsics.checkNotNull(r112);
        ShortcutInfo.Builder r113 = r111.setShortLabel(r112).setIcon(r110);
        int r114 = ShortcutCommonUtil.f369227a;
        String r115 = r101.g();
        Intrinsics.checkNotNull(r115);
        return r113.setIntent(ShortcutCommonUtil.b(r115)).build();
    L30:
        if (r109.isRecycled() == true) goto L33;
        r108 = false;
    L33:
        if (r108 == true) goto L36;
        r110 = Icon.createWithBitmap(r101.f547801a);
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r116 = Dispatchers.getIO();
        PinShortcutProcess$buildShortcutInfo$2 r117 = new PinShortcutProcess$buildShortcutInfo$2(r101, null);
        r103.L$0 = r101;
        r103.label = 1;
        if (BuildersKt.withContext(r116, r117, r103) != r106) goto L18;
        return r106;
    L7:
        r103 = new PinShortcutProcess$buildShortcutInfo$1(r100, r102);
        goto L8
    }

    public final void e(tw9.a r110, JSONObject r111, boolean r112) {
        if (r110 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new PinShortcutProcess$pinnedShortCut$1(r110, this, r112, r111, null), 2, null);
    }
}
