package kha;

import android.app.Activity;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.view.Window;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.k;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.debug.api.IObricDebugService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.storage.LowStorageBlockActivity;
import com.obric.oui.dialog.v2.alert.g;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f503576a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f503577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicLong f503578c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f503579d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f503580e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f503581f = null;

    public e() {
    }

    static {
        f503576a = new e();
        f503578c = new AtomicLong(0);
        f503579d = new AtomicBoolean(false);
        f503580e = new AtomicBoolean(false);
        f503581f = new AtomicLong(0);
    }

    @JvmStatic
    public static final boolean c() {
        long r100 = SystemClock.elapsedRealtime();
        if ((r100 - f503578c.get()) < 1000) goto L5;
        e r101 = f503576a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
        long r103 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
        int r104 = k.f375427a;     // Catch: Throwable -> L23
        StatFs r105 = new StatFs(Environment.getDataDirectory().getPath());     // Catch: Throwable -> L23
        f503577b = r105.getBlockSizeLong() * r105.getAvailableBlocksLong();     // Catch: Throwable -> L23
        FLogger r106 = FLogger.f375446a;     // Catch: Throwable -> L23
        StringBuilder r107 = new StringBuilder("isLowStorage: check  romAvailableSpace:");     // Catch: Throwable -> L23
        long r110 = f503577b;     // Catch: Throwable -> L23
        r101.getClass();     // Catch: Throwable -> L23
        r107.append(f(r110));     // Catch: Throwable -> L23
        r107.append("MB, cost=");     // Catch: Throwable -> L23
        r107.append(SystemClock.elapsedRealtime() - r103);     // Catch: Throwable -> L23
        r107.append("ms");     // Catch: Throwable -> L23
        r106.d("LowStorageGuard", r107.toString());     // Catch: Throwable -> L23
        boolean r108 = false;
        if (f503577b >= 524288000) goto L10;
        boolean r109 = true;
    L11:
        IObricDebugService r111 = (IObricDebugService) ServiceManager.get().getServiceForReal(IObricDebugService.class);     // Catch: Throwable -> L23
        if (r111 != null) goto L14;
    L16:
        boolean r112 = false;
    L17:
        r106.d("LowStorageGuard", "isLowStorage: realCheckResult=" + r109 + ", debugOpen=" + r112);     // Catch: Throwable -> L23
        if (r109 == true) goto L20;
        if (r112 == true) goto L20;
    L21:
        Object r113 = Result.m9449constructorimpl(Boolean.valueOf(r108));     // Catch: Throwable -> L23
    L25:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L28;
        FLogger.f375446a.w("LowStorageGuard", "isLowStorage error: " + r114.getMessage(), r114);
    L28:
        Boolean r115 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r113) == false) goto L31;
        r113 = r115;
    L31:
        boolean r116 = ((Boolean) r113).booleanValue();
        f503579d.set(r116);
        f503578c.set(r100);
        return r116;
    L20:
        r108 = true;
        goto L21
    L14:
        if (r111.b() != true) goto L16;
        r112 = true;
        goto L17
    L10:
        r109 = false;
    L23:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L5:
        return f503579d.get();
    }

    public static void d() {
        f503581f.set(0);
        f503580e.set(false);
    }

    public static boolean g() {
    L2:
        long r100 = SystemClock.elapsedRealtime();
        AtomicLong r101 = f503581f;
        long r102 = r101.get();
        if (r102 == Long.MAX_VALUE) goto L11;
        if (r102 > r100) goto L17;
        if (r101.compareAndSet(r102, r100 + 5000) == false) goto L2;
        return true;
    L17:
        return false;
    L11:
        return false;
    }

    public static com.obric.oui.dialog.v2.alert.c e(Activity r100) {
        String r101 = "activity";
        Intrinsics.checkNotNullParameter(r100, "activity");
        g r102 = new g(r100);
        r102.f400759w = false;
        String r103 = r100.getString(R.string.obric_low_storage_dialog_title);
        r102.f400746j = false;
        r102.f400744h = r103;
        r102.f400745i = r100.getString(R.string.obric_low_storage_dialog_message);
        r102.g(r100.getString(R.string.obric_low_storage_dialog_confirm), new a(), ButtonStyleController.TextColorType.Negative);
        com.obric.oui.dialog.v2.alert.c r104 = r102.a();
        final d r105 = new d(r100);
        r104.setCancelable(false);
        r104.setCanceledOnTouchOutside(false);
        r104.setOnDismissListener(new b(r105));
        AppHost.f326268a.a().e(r105);
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L28;
        DialogLancet.handleBlockedDialogShow(r104);
    L7:
        f503581f.set(Long.MAX_VALUE);
        if ((r100 instanceof LowStorageBlockActivity) == false) goto L24;
        r101 = LiveEndPageData.TAG_WINDOW;
    L24:
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L13
        r106.put("available_space", f503577b);     // Catch: Exception -> L13
        r106.put("show_from", r101);     // Catch: Exception -> L13
        TrackParams r107 = new TrackParams().merge(r106);     // Catch: Exception -> L13
        by7.a r108 = new by7.a("obric_low_storage_dialog_show");     // Catch: Exception -> L13
        r108.f21463a.merge(r107);     // Catch: Exception -> L13
        r108.b();     // Catch: Exception -> L13
        FLogger.f375446a.i("LowStorageGuard", "report dialog show success, params=" + r106);     // Catch: Exception -> L13
    L26:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L17
        a(r104, r100);     // Catch: Throwable -> L17
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L22;
        FLogger.f375446a.w("LowStorageGuard", "configureDialogWindowForLockscreen failed: " + r111.getMessage(), r111);
    L22:
        return r104;
    L17:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        e = move-exception;
        FLogger.f375446a.e("LowStorageGuard", "report dialog show failed", e);
        goto L26
    L28:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L6:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        goto L7
    }

    public static double f(long r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L4
        return CastDoubleProtector.parseDouble(String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r100 / 1048576)}, 1)));
    L4:
        e = move-exception;
        FLogger.f375446a.e("LowStorageGuard", "toM num=" + r100 + " error " + e);
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static void a(com.obric.oui.dialog.v2.alert.c r100, Activity r101) {
        boolean r102 = false;
        if ((r101 instanceof LowStorageBlockActivity) == false) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        return;
    L11:
        Window r104 = r100.getWindow();
        if (r104 == null) goto L30;
        f503576a.getClass();
        if (Build.VERSION.SDK_INT >= 30) goto L28;
    L24:
        if (r102 == true) goto L26;
        r104.addFlags(524288);
    L26:
        r104.addFlags(2097280);
        return;
    L28:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        Method r106 = r104.getClass().getMethod("setInheritShowWhenLocked", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L18
        Boolean r107 = Boolean.TRUE;     // Catch: Throwable -> L18
        r106.invoke(r104, new Object[]{r107});     // Catch: Throwable -> L18
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L18
    L20:
        Boolean r109 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r108) == false) goto L23;
        r108 = r109;
    L23:
        r102 = ((Boolean) r108).booleanValue();
    L18:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L30:
        return;
    L5:
        if (KeyguardService.f392886a.isKeyguardLocked() == true) goto L8;
        r103 = false;
        goto L9
    }

    public static void b(String r100, Function0 r101) {
        if (f503580e.compareAndSet(false, true) == true) goto L6;
        FLogger.f375446a.i("LowStorageGuard", "exitAppFromDialog: already triggered, trigger=".concat(r100));
        return;
    L6:
        FLogger.f375446a.i("LowStorageGuard", "exitAppFromDialog: trigger=".concat(r100));
        d();
        if (r101 == null) goto L24;
        r101.invoke();
    L24:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        AppHost.f326268a.a().k();     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L22;
        FLogger.f375446a.w("LowStorageGuard", "finishAllActivitiesSafely failed: " + r104.getMessage(), r104);
    L22:
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L19
        r105.put("exit_app_trigger", r100);     // Catch: Exception -> L19
        TrackParams r106 = new TrackParams().merge(r105);     // Catch: Exception -> L19
        by7.a r107 = new by7.a("obric_low_storage_dialog_close_app");     // Catch: Exception -> L19
        r107.f21463a.merge(r106);     // Catch: Exception -> L19
        r107.b();     // Catch: Exception -> L19
        FLogger.f375446a.i("LowStorageGuard", "report button click event success, params=" + r105);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        FLogger.f375446a.e("LowStorageGuard", "report button click event failed", e);
        return;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
