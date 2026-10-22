package com.obric.assistant.util;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.AppletService;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.home.obric.ObricChatActivity;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.spi.notification.IObricNotificationIslandService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class OrionChatExtensionUtils implements jga.a, IObserveToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f393639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f393640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f393641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OrionChatExtensionUtils$onBeforeCreate$2 f393642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f393643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f393644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l2 f393645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f393646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k2 f393647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j2 f393648j;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f393649a = null;

        static {
            int[] r100 = new int[KeyguardLockedState.values().length];
            r100[KeyguardLockedState.LOCKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[KeyguardLockedState.UNLOCKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f393649a = r100;
        }
    }

    @Override // jga.a
    public final void a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // jga.a
    public final void d(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public OrionChatExtensionUtils(ObricChatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f393639a = OrionChatExtensionUtils.class.getSimpleName();
        this.f393640b = new String[]{"arg_launch_floating_window", "arg_launch_half_screen", "obric_need_translucent", "all_search", "launch_from_agent", "agent_window_state"};
        this.f393641c = "";
        this.f393643e = AppHost.f326268a.getApplication().getResources().getConfiguration().orientation;
        this.f393644f = new AtomicBoolean(false);
        this.f393645g = new l2(this);
        this.f393646h = LazyKt.lazy(new i2());
        this.f393647i = new k2();
        new WeakReference(r100);
        this.f393648j = new j2(this);
    }

    public static final void l(OrionChatExtensionUtils r100) {
        r100.getClass();
        Object r101 = AppHost.f326268a.getApplication().getSystemService("notification");
        List<String> r102 = null;
        if ((r101 instanceof NotificationManager) == false) goto L5;
        NotificationManager r103 = (NotificationManager) r101;
    L6:
        if (r103 == null) goto L38;
        AppletService r104 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r104 == null) goto L10;
        List<String> r105 = r104.d();
    L11:
        IObricNotificationIslandService r106 = (IObricNotificationIslandService) ServiceManager.get().getService(IObricNotificationIslandService.class);
        if (r106 == null) goto L14;
        r102 = r106.a();
    L14:
        if (r105 != null) goto L16;
        r105 = CollectionsKt.emptyList();
    L16:
        List<String> r107 = r105;
        if (r102 != null) goto L19;
        r102 = CollectionsKt.emptyList();
    L19:
        List r108 = CollectionsKt.distinct(CollectionsKt.plus(r107, r102));
        if (r108.isEmpty() == false) goto L23;
        r103.cancelAll();
        return;
    L23:
        if (Build.VERSION.SDK_INT >= 26) goto L26;
        r103.cancelAll();
        return;
    L26:
        if ((!r108.isEmpty()) == false) goto L33;
        StatusBarNotification[] r109 = r103.getActiveNotifications();
        Intrinsics.checkNotNull(r109);
        int r110 = r109.length;
        int r111 = 0;
    L28:
        if (r111 >= r110) goto L41;
        StatusBarNotification r112 = r109[r111];
        if (r108.contains(r112.getNotification().getChannelId()) == true) goto L32;
        r103.cancel(r112.getId());
    L32:
        r111 = r111 + 1;
        goto L28
    L41:
        return;
    L33:
        r103.cancelAll();
        return;
    L10:
        r105 = null;
        goto L11
    L38:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static Fragment m(FragmentActivity r100) {
        return r100.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    public static laa.d n(FragmentActivity r100) {
        Fragment r101 = m(r100);
        if (r101 == null) goto L7;
        t1a.b r102 = s1a.a.g(r101);
        if (r102 == null) goto L7;
        return (laa.d) r102.getAbility(laa.d.class);
    L7:
        return null;
    }

    public static boolean o(Intent r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L18;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r100.getBooleanExtra("obric_need_translucent", false) != true) goto L13;
        r102 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r100.getBooleanExtra("arg_launch_floating_window", false) != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // jga.a
    public final void b(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        FLogger.f375446a.i(this.f393639a, "onDestroy, hashCode: " + hashCode());
        OrionChatExtensionUtils$onBeforeCreate$2 r101 = this.f393642d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("screenReceiver");
        r101 = null;
    L5:
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L24;
        r100.unregisterReceiver(r101);
    L16:
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionKeyguardLockedState(this);
        KeyguardService.f392886a.unregisterDismissKeyguardChangedListener(this.f393645g);
        AppHost.f326268a.a().c(this.f393648j);
        Fragment r102 = m(r100);
        if (r102 == null) goto L26;
        t1a.b r103 = s1a.a.g(r102);
        if (r103 == null) goto L27;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r104 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r103.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r104 == null) goto L28;
        r104.K8(this.f393647i);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L24:
    L11:
        e = move-exception;
        if (r101 == null) goto L14;
        Npth.addTag("unregisterReceiver", r101.toString());
    L14:
        e.printStackTrace();
        goto L16
    L8:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L11
        goto L16
    }

    @Override // jga.a
    public final Integer e(Intent r100) {
        if (o(r100) == true) goto L5;
        return null;
    L5:
        return Integer.valueOf(R.color.obric_bg_chat_activity_color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.assistant.util.g2] */
    @Override // jga.a
    public final void g(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        boolean r101 = IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
        Fragment r102 = m(r100);
        if (r102 == null) goto L7;
        t1a.b r103 = s1a.a.g(r102);
        if (r103 == null) goto L7;
        maa.e r104 = (maa.e) r103.getAbility(maa.e.class);
    L8:
        FLogger.f375446a.i(this.f393639a, "onResume, hashCode: " + hashCode() + ", isKeyguardLocked: " + r101 + ", isDismissFailed: " + this.f393644f + ", currentKeyguardLockedTime: " + IKeyguardStateKt.getKeyguardState().getKeyguardLockTime() + ", isNeedUpdatePageState: " + ObricInteractDelegate.f392884b.isNeedUpdatePageState() + ", intent.extras: " + r100.getIntent().getExtras());
        if (r104 == 0) goto L11;
        r104.XB(new g2(this));
    L11:
        Fragment r105 = m(r100);
        if (r105 == null) goto L19;
        t1a.b r106 = s1a.a.g(r105);
        if (r106 == null) goto L20;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r107 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r106.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r107 == null) goto L21;
        r107.A4(this.f393647i);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r104 = 0;
        goto L8
    }

    @Override // jga.a
    public final void h(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        FLogger.f375446a.i(this.f393639a, VideoEventOneOutSync.END_TYPE_FINISH);
    }

    @Override // jga.a
    public final boolean i(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        laa.d r101 = n(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.JY() != true) goto L7;
        return true;
    }

    @Override // jga.a
    public final boolean k(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        laa.d r101 = n(r100);
        if (r101 == null) goto L9;
        ObricFloatChatPageState r102 = r101.getPageState();
        if (r102 == null) goto L9;
        ObricFloatChatPageData.Companion.getClass();
        if ((r102 instanceof vda.b) != true) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.obric.assistant.util.OrionChatExtensionUtils$onBeforeCreate$2] */
    @Override // jga.a
    public final void c(final FragmentActivity r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        ObricInteractDelegate.f392884b.notifyRelaunchEvent(r111);
        Intent r100 = r110.getIntent();
        if (r100 != null) goto L6;
    L11:
        Object r101 = r110.getSystemService("keyguard");
        if ((r101 instanceof KeyguardManager) == false) goto L14;
        KeyguardManager r102 = (KeyguardManager) r101;
    L14:
        Iterator<T> r103 = AppHost.f326268a.a().g().iterator();
    L16:
        if (r103.hasNext() == false) goto L20;
        Object r104 = r103.next();
        if (com.obric.assistant.chat.p.e((Activity) r104) == false) goto L16;
    L21:
        Activity r105 = (Activity) r104;
        FLogger r106 = FLogger.f375446a;
        r106.i(this.f393639a, "chatActivityInStack, " + r105 + ", " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked() + ", " + r110.hashCode());
        if (r105 == null) goto L29;
        if (r105.isFinishing() == true) goto L29;
        if (r105.isDestroyed() == true) goto L29;
        r106.w(this.f393639a, "chatActivityInStack is already in stack, " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
    L29:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L38;
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L38;
        if (com.obric.assistant.t1.f393353a.i() == false) goto L38;
        if (Build.VERSION.SDK_INT < 27) goto L40;
        r106.i(this.f393639a, "setShowWhenLocked");
        r110.setShowWhenLocked(true);
        r110.setTurnScreenOn(true);
    L40:
        r106.i(this.f393639a, "onBeforeCreate, isKeyguardLocked: " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked() + ", isRelaunch: " + r111 + ", previousKeyguardLockedTime: " + IKeyguardStateKt.getKeyguardState().getKeyguardLockTime());
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionKeyguardLockedState(this, new h2(this, r110));
        this.f393642d = new OrionChatExtensionUtils$onBeforeCreate$2(this, r110);
        IntentFilter r107 = new IntentFilter();
        r107.addAction("android.intent.action.SCREEN_OFF");
        r107.addAction("android.intent.action.SCREEN_ON");
        OrionChatExtensionUtils$onBeforeCreate$2 r108 = this.f393642d;
        if (r108 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("screenReceiver");
        r108 = null;
    L44:
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L73;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L73:
    L61:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L72;
        ReceiverRegisterCrashOptimizer.registerReceiver(r108, r107, "android.permission.WRITE_SETTINGS", null);
    L65:
        if (r111 == true) goto L67;
        return;
    L67:
        if (r110.getIntent().hasExtra("arg_launch_floating_window") == false) goto L79;
        r110.getIntent().removeExtra("arg_launch_floating_window");
        if (r110.getIntent().hasExtra("obric_need_translucent") == true) goto L80;
        r110.getIntent().putExtra("obric_need_translucent", true);
        return;
    L80:
        return;
    L79:
        return;
    L72:
        throw e;
    L47:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L49;
    L59:
        r110.registerReceiver(r108, r107, "android.permission.WRITE_SETTINGS", null);     // Catch: Exception -> L61
        goto L65
    L49:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r107) == false) goto L59;
        int r109 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r108, r107, 0, "android.permission.WRITE_SETTINGS", null, 4, r110).result;     // Catch: Exception -> L61
        if (r109 != 1) goto L53;
        r110.registerReceiver(r108, r107, "android.permission.WRITE_SETTINGS", null);     // Catch: Exception -> L61
        goto L65
    L53:
        if (r109 != 2) goto L55;
        new Intent();     // Catch: Exception -> L61
        goto L65
    L55:
        if (r109 == 3) goto L65;
        r110.registerReceiver(r108, r107, "android.permission.WRITE_SETTINGS", null);     // Catch: Exception -> L61
    L38:
        if (Build.VERSION.SDK_INT < 27) goto L40;
        r106.i(this.f393639a, "setShowWhenLocked false");
        r110.setShowWhenLocked(false);
        goto L40
    L20:
        r104 = null;
        goto L21
    L6:
        if (r100.getBooleanExtra("argument_restore_full_screen_on_recreate", false) != true) goto L11;
        String[] r112 = this.f393640b;
        int r113 = r112.length;
        int r114 = 0;
    L9:
        if (r114 >= r113) goto L11;
        r100.removeExtra(r112[r114]);
        r114 = r114 + 1;
        goto L9
    }

    @Override // jga.a
    public final void j(FragmentActivity r100, Configuration r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "newConfig");
        laa.d r102 = n(r100);
        int r103 = r101.orientation;
        if (r103 == this.f393643e) goto L8;
        this.f393643e = r103;
        if (r102 == null) goto L9;
        r102.refresh();
        return;
    L9:
        return;
    }

    @Override // jga.a
    public final void f(FragmentActivity r100, Bundle r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        r100.overridePendingTransition(0, 0);
        if (r102 == null) goto L9;
        if (r101 == null) goto L6;
        r101.remove("arg_wakeup");
    L6:
        if (r101 == null) goto L9;
        r101.remove("arg_wakeup_not_auto_reset");
    L9:
        if (o(r100.getIntent()) == false) goto L22;
        Window r103 = r100.getWindow();
        if (r103 == null) goto L19;
        View r104 = r103.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L17;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L17;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L17:
        if (r104 == null) goto L19;
        r104.setBackgroundColor(r100.getResources().getColor(android.R.color.transparent));
    L19:
        Window r106 = r100.getWindow();
        if (r106 == null) goto L22;
        r106.setBackgroundDrawableResource(android.R.color.transparent);
    L22:
        FLogger.f375446a.i(this.f393639a, "onCreate, hashCode: " + hashCode() + ", savedInstanceState: " + r102 + ", extras: " + r101);
        KeyguardService.f392886a.registerDismissKeyguardChangedListener(this.f393645g);
        AppHost.f326268a.a().j(this.f393648j);
    }
}
