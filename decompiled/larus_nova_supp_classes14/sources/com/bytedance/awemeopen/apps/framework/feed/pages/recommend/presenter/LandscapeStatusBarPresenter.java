package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LandscapeStatusBarPresenter extends g04.a<jz3.a> {
    public static final /* synthetic */ int q = 0;
    public final Context e;
    public final AoImageView f;
    public final TextView g;
    public final TextView h;
    public final CardView i;
    public final View j;
    public final SimpleDateFormat k;
    public final Lazy l;
    public final b m;
    public final LandscapeStatusBarPresenter$networkReceiver$1 n;
    public final LandscapeStatusBarPresenter$timeReceiver$1 o;
    public final LandscapeStatusBarPresenter$batteryReceiver$1 p;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkUtils.NetworkType.values().length];
            r0[NetworkUtils.NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[NetworkUtils.NetworkType.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ LandscapeStatusBarPresenter a;

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onUnavailable() {
            this.a.p();
        }

        public b(LandscapeStatusBarPresenter r1) {
            this.a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r2) {
            Intrinsics.checkNotNullParameter(r2, "network");
            this.a.p();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r2) {
            Intrinsics.checkNotNullParameter(r2, "network");
            this.a.p();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network r2, NetworkCapabilities r3) {
            Intrinsics.checkNotNullParameter(r2, "network");
            Intrinsics.checkNotNullParameter(r3, "networkCapabilities");
            this.a.p();
        }
    }

    @Override // g04.a
    public final void h() {
        if (Build.VERSION.SDK_INT >= 24) goto L16;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        n(this.e, this.n);     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        n(this.e, this.o);
        n(this.e, this.p);
        return;
    L10:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L16:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        ((ConnectivityManager) this.l.getValue()).unregisterNetworkCallback(this.m);     // Catch: Throwable -> L6
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void p() {
        this.a.post(new g(this));
    }

    public final void q() {
        final String r0 = this.k.format(new Date());
        this.a.post(new e(this, r0));
    }

    @Override // g04.a
    public final void f(jz3.a r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (Build.VERSION.SDK_INT >= 24) goto L17;
        IntentFilter r5 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Result.constructor-impl(m(this.e, this.n, r5));     // Catch: Throwable -> L11
    L13:
        m(this.e, this.o, new IntentFilter("android.intent.action.TIME_TICK"));
        m(this.e, this.p, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        p();
        q();
        o(m(this.e, null, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
        return;
    L11:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L17:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L6
        ((ConnectivityManager) this.l.getValue()).registerDefaultNetworkCallback(this.m);     // Catch: Throwable -> L6
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void o(Intent r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = r5.getIntExtra("level", -1);
        int r2 = r5.getIntExtra("scale", -1);
        final boolean r3 = false;
        if (r0 == (-1)) goto L8;
        if (r2 == (-1)) goto L8;
        final int r1 = (int) ((r0 * 100) / r2);
    L9:
        int r6 = r5.getIntExtra("status", -1);
        if (r6 != 2) goto L12;
    L13:
        r3 = true;
    L14:
        this.a.post(new f(this, r1, r3));
        return;
    L12:
        if (r6 != 5) goto L14;
    L8:
        r1 = 0;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v19, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.LandscapeStatusBarPresenter$networkReceiver$1] */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.LandscapeStatusBarPresenter$timeReceiver$1] */
    /* JADX WARN: Type inference failed for: r2v21, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.LandscapeStatusBarPresenter$batteryReceiver$1] */
    public LandscapeStatusBarPresenter(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "statusBarView");
        super(r3);
        this.e = r2;
        this.f = this.a.findViewById(2131376429);
        this.g = (TextView) this.a.findViewById(2131390470);
        this.h = (TextView) this.a.findViewById(2131390217);
        this.i = this.a.findViewById(2131364011);
        this.j = this.a.findViewById(2131376044);
        this.k = new SimpleDateFormat("HH:mm", Locale.getDefault());
        this.l = LazyKt.lazy(new LandscapeStatusBarPresenter$connectivityManager$2(this));
        this.m = new b(this);
        this.n = new LandscapeStatusBarPresenter$networkReceiver$1(this);
        this.o = new LandscapeStatusBarPresenter$timeReceiver$1(this);
        this.p = new LandscapeStatusBarPresenter$batteryReceiver$1(this);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void n(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent m(Context r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L35
        int r1 = r0.result;     // Catch: Exception -> L35
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L18;
        return r8.registerReceiver(r9, r10);
    L18:
        return r0.intent;
    L20:
        return new Intent();
    L22:
        return r8.registerReceiver(r9, r10);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r8.registerReceiver(r9, r10);
    }
}
