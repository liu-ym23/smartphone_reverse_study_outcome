package com.larus.bmhome;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.presentation.UiPresentationChannel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hq9.n3;
import hq9.p3;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f311775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f311776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<nr8.b> f311777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f311778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArraySet<p3> f311779e = null;

    public static final class a implements nr8.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f311780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f311781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ nr8.b f311782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n3 f311783d;

        @Override // nr8.s
        public final void a() {
            FLogger.f375446a.i("NotificationControlManager", "system window dialog detached, windowType=" + this.f311780a);
            i0.b(this.f311781b, this.f311782c, 2);
            Function0<Unit> r100 = this.f311783d.f486722t;
            if (r100 == null) goto L6;
            r100.invoke();
            return;
        }

        public a(int r100, i0 r101, nr8.b r102, n3 r103) {
            this.f311780a = r100;
            this.f311781b = r101;
            this.f311782c = r102;
            this.f311783d = r103;
        }
    }

    public i0() {
    }

    static {
        f311775a = new i0();
        f311779e = new CopyOnWriteArraySet();
    }

    public static void a(nr8.b r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static boolean c(final n3 r100) {
        Activity r101 = r100.f486718p;
        if (r101 != null) goto L5;
        AppHost.Companion r102 = AppHost.f326268a;
        if ((r102.a().getCurrentActivity() instanceof AppCompatActivity) == true) goto L11;
        return false;
    L11:
        Activity r103 = r102.a().getCurrentActivity();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity r104 = (AppCompatActivity) r103;
    L12:
        String r105 = "";
        if ((r104 instanceof FlowCommonAppCompatActivity) == false) goto L15;
        String r106 = ((FlowCommonAppCompatActivity) r104).k();
    L16:
        List<String> r107 = r100.f486711i;
        if (r107 != null) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == true) goto L33;
        List<String> r109 = r100.f486711i;
        if (r109 != null) goto L27;
    L29:
        boolean r110 = false;
    L30:
        if (r110 == true) goto L33;
        boolean r111 = false;
    L88:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L53
        if (StringsKt.isBlank(r106) == false) goto L51;
        if (r111 == true) goto L51;
        if ((!r104.getSupportFragmentManager().getFragments().isEmpty()) == false) goto L51;
        Fragment r113 = (Fragment) ListProtector.get(r104.getSupportFragmentManager().getFragments(), 0);     // Catch: Throwable -> L53
        if ((!r113.getChildFragmentManager().getFragments().isEmpty()) == false) goto L51;
        ActivityResultCaller r114 = (Fragment) ListProtector.get(r113.getChildFragmentManager().getFragments(), 0);     // Catch: Throwable -> L53
        if ((r114 instanceof com.larus.trace.tracknode.a) == false) goto L44;
        com.larus.trace.tracknode.a r115 = (com.larus.trace.tracknode.a) r114;     // Catch: Throwable -> L53
    L45:
        if (r115 == null) goto L50;
        String r116 = r115.k();     // Catch: Throwable -> L53
        if (r116 == null) goto L50;
        r105 = r116;
    L50:
        r106 = r105;
        goto L51
    L44:
        r115 = null;
    L51:
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L58;
        FLogger.f375446a.i("NotificationControlManager", "error: " + r118.getMessage());
    L58:
        boolean r119 = AppHost.f326268a.a().isAppBackground();
        if (r100.f486719q == true) goto L78;
        List<String> r120 = r100.f486711i;
        if (r120 != null) goto L64;
    L67:
        boolean r121 = true;
    L68:
        if (r121 == true) goto L78;
        List<String> r122 = r100.f486711i;
        if (r122 != null) goto L72;
    L74:
        boolean r123 = false;
    L75:
        if (r123 == true) goto L78;
        boolean r124 = false;
    L79:
        if (r119 == false) goto L81;
    L87:
        return false;
    L81:
        if (r104.isFinishing() == true) goto L87;
        if (r104.isDestroyed() == true) goto L87;
        if (r124 == false) goto L87;
        f311775a.getClass();
        FLogger.f375446a.i("NotificationControlManager", "buildNotificationAndShow, type " + r100.getType() + ", business:" + r100.f486710h);
        t0.f375468a.post(new f0(r104, r100));
        return true;
    L72:
        if (r122.contains(r106) != true) goto L74;
        r123 = true;
        goto L75
    L64:
        if (r120.isEmpty() == true) goto L67;
        r121 = false;
    L78:
        r124 = true;
    L53:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    L27:
        if (r109.contains(r106) != true) goto L29;
        r110 = true;
    L33:
        r111 = true;
        goto L88
    L19:
        if (r107.isEmpty() == true) goto L22;
        r108 = false;
        goto L23
    L15:
        r106 = "";
        goto L16
    L5:
        if ((r101 instanceof AppCompatActivity) == true) goto L7;
        return false;
    L7:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        r104 = (AppCompatActivity) r101;
        goto L12
    }

    public static boolean d(final n3 r100) {
        if (r100.f486721s == true) goto L6;
        FLogger.f375446a.i("NotificationControlManager", "triggerSystemWindowFallback skipped, disabled, type=" + r100.getType() + ", business=" + r100.f486710h);
        return false;
    L6:
        final Application r101 = AppHost.f326268a.getApplication();
        Object r102 = r101.getSystemService("keyguard");
        if ((r102 instanceof KeyguardManager) == false) goto L9;
        KeyguardManager r103 = (KeyguardManager) r102;
    L11:
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L18;
    L23:
        if (r104 == false) goto L26;
        final int r105 = 2009;
    L29:
        FLogger.f375446a.i("NotificationControlManager", "triggerSystemWindowFallback, isKeyguardLocked=" + r104 + ", windowType=" + r105 + ", type=" + r100.getType() + ", business=" + r100.f486710h);
        t0.f375468a.post(new e0(r100, r101, r105));
        return true;
    L26:
        if (Build.VERSION.SDK_INT < 26) goto L28;
        r105 = 2038;
        goto L29
    L28:
        r105 = 2002;
        goto L29
    L18:
        if (Build.VERSION.SDK_INT < 23) goto L23;
        if (Settings.canDrawOverlays(r101) == true) goto L23;
        FLogger.f375446a.w("NotificationControlManager", "triggerSystemWindowFallback skipped, overlay permission denied, type=" + r100.getType() + ", business=" + r100.f486710h);
        return false;
    L13:
        if (r103.isKeyguardLocked() != true) goto L15;
        r104 = true;
        goto L16
    L9:
        r103 = null;
        goto L11
    }

    public static void b(i0 r100, nr8.b r101, int r102) {
        String r103 = null;
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        boolean r104 = false;
        if ((r102 & 2) == 0) goto L8;
        boolean r105 = true;
    L9:
        monitor-enter(r100);
        if (r101 == null) goto L18;
        WeakReference<nr8.b> r106 = f311777c;     // Catch: Throwable -> L39
        if (r106 == null) goto L14;
        nr8.b r107 = r106.get();     // Catch: Throwable -> L39
    L15:
        if (r107 == r101) goto L18;
    L21:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(r100);
        if (r104 == false) goto L38;
        if (r103 == null) goto L26;
        n19.a.f516677a.e(UiPresentationChannel.LEGACY_ACTIVITY_NOTIFICATION, r103);
    L26:
        if (r105 == false) goto L51;
        Iterator<p3> r109 = f311779e.iterator();
    L29:
        if (r109.hasNext() == false) goto L52;
        p3 r110 = r109.next();
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L33
        r110.a();     // Catch: Throwable -> L33
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L29;
        FLogger.f375446a.e("NotificationControlManager", "notify slot idle failed", r113);
    L33:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L52:
        return;
    L51:
        return;
    L38:
        return;
    L14:
        r107 = null;
    L39:
        th = move-exception;
        throw th;
    L18:
        if (f311776b == false) goto L21;
        f311776b = false;     // Catch: Throwable -> L39
        f311777c = null;     // Catch: Throwable -> L39
        String r115 = f311778d;     // Catch: Throwable -> L39
        f311778d = null;     // Catch: Throwable -> L39
        r103 = r115;
        r104 = true;
        goto L21
    L8:
        r105 = false;
        goto L9
    }
}
