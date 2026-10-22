package com.larus.network.util;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScreenStateManager f360254a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<b> f360255b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f360256c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/network/util/ScreenStateManager$ScreenState;", "", "<init>", "(Ljava/lang/String;I)V", "SCREEN_ON", "SCREEN_OFF", "USER_PRESENT", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScreenState extends Enum<ScreenState> {
        public static final ScreenState SCREEN_OFF = null;
        public static final ScreenState SCREEN_ON = null;
        public static final ScreenState USER_PRESENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScreenState[] f360257a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f360258b = null;

        public static EnumEntries<ScreenState> getEntries() {
            return f360258b;
        }

        static {
            ScreenState r100 = new ScreenState("SCREEN_ON", 0);
            SCREEN_ON = r100;
            ScreenState r101 = new ScreenState("SCREEN_OFF", 1);
            SCREEN_OFF = r101;
            ScreenState r102 = new ScreenState("USER_PRESENT", 2);
            USER_PRESENT = r102;
            ScreenState[] r103 = {r100, r101, r102};
            f360257a = r103;
            f360258b = EnumEntriesKt.enumEntries(r103);
        }

        public static ScreenState[] values() {
            return (ScreenState[]) f360257a.clone();
        }

        public static ScreenState valueOf(String r100) {
            return (ScreenState) r27.a.a(ScreenState.class, r100);
        }

        public ScreenState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 == null) goto L4;
            String r102 = r101.getAction();
        L5:
            if (r102 == null) goto L42;
            int r103 = r102.hashCode();
            if (r103 == (-2128145023)) goto L33;
            if (r103 == (-1454123155)) goto L24;
            if (r103 == 823795052) goto L14;
            return;
        L14:
            if (r102.equals("android.intent.action.USER_PRESENT") == false) goto L63;
            Iterator<b> r104 = ScreenStateManager.f360255b.iterator();
        L18:
            if (r104.hasNext() == false) goto L65;
            b r105 = r104.next();
            Intrinsics.checkNotNull(r105);     // Catch: Exception -> L22
            Intrinsics.checkNotNullParameter(r105, "it");     // Catch: Exception -> L22
            r105.onUserPresent();     // Catch: Exception -> L22
            Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L22
            goto L18
        L65:
            return;
        L63:
            return;
        L24:
            if (r102.equals("android.intent.action.SCREEN_ON") == false) goto L61;
            Iterator<b> r107 = ScreenStateManager.f360255b.iterator();
        L27:
            if (r107.hasNext() == false) goto L66;
            b r108 = r107.next();
            Intrinsics.checkNotNull(r108);     // Catch: Exception -> L31
            Intrinsics.checkNotNullParameter(r108, "it");     // Catch: Exception -> L31
            r108.onScreenOn();     // Catch: Exception -> L31
            Unit r109 = Unit.INSTANCE;     // Catch: Exception -> L31
            goto L27
        L66:
            return;
        L61:
            return;
        L33:
            if (r102.equals("android.intent.action.SCREEN_OFF") == false) goto L64;
            Iterator<b> r110 = ScreenStateManager.f360255b.iterator();
        L37:
            if (r110.hasNext() == false) goto L67;
            b r111 = r110.next();
            Intrinsics.checkNotNull(r111);     // Catch: Exception -> L41
            Intrinsics.checkNotNullParameter(r111, "it");     // Catch: Exception -> L41
            r111.onScreenOff();     // Catch: Exception -> L41
            Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L41
            goto L37
        L67:
            return;
        L64:
            return;
        L42:
            return;
        L4:
            r102 = null;
            goto L5
        }
    }

    public interface b {
        void onScreenOff();

        void onScreenOn();

        void onUserPresent();
    }

    public ScreenStateManager() {
    }

    static {
        f360254a = new ScreenStateManager();
        f360255b = new CopyOnWriteArraySet();
    }

    private final void unregisterReceiver() {
        a r100 = f360256c;
        if (r100 == null) goto L17;
        Application r101 = AppHost.f326268a.getApplication();
        ReceiverRegisterLancet.loge(r100, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L15;
        r101.unregisterReceiver(r100);
    L13:
        f360256c = null;
        return;
    L15:
    L10:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r100.toString());
        e.printStackTrace();
        goto L13
    L7:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r100, r101) == false) goto L13;
        r101.unregisterReceiver(r100);     // Catch: Exception -> L10
        goto L13
    }

    public static void a(b r110) {
        Intrinsics.checkNotNullParameter(r110, "screenStateListener");
        if (f360255b.isEmpty() == true) goto L5;
    L37:
        f360255b.add(r110);
        return;
    L5:
        if (f360256c != null) goto L37;
        f360256c = new a();
        IntentFilter r100 = new IntentFilter();
        r100.addAction("android.intent.action.SCREEN_OFF");
        r100.addAction("android.intent.action.SCREEN_ON");
        r100.addAction("android.intent.action.USER_PRESENT");
        Application r101 = AppHost.f326268a.getApplication();
        a r102 = f360256c;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L32:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.registerReceiver(r102, r100);
        goto L37
    L36:
        throw e;
    L10:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L23;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r102, r100, 0, null, null, 2, r101).result;     // Catch: Exception -> L32
        if (r103 != 1) goto L16;
        r101.registerReceiver(r102, r100);     // Catch: Exception -> L32
    L39:
        goto L37
    L16:
        if (r103 != 2) goto L18;
        new Intent();     // Catch: Exception -> L32
        goto L39
    L18:
        if (r103 == 3) goto L39;
        r101.registerReceiver(r102, r100);     // Catch: Exception -> L32
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L32
        r101.registerReceiver(r102, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L32
        goto L39
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L30:
        r101.registerReceiver(r102, r100);     // Catch: Exception -> L32
        goto L39
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L30;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L32
        ContextCompat.registerReceiver(r101, r102, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L32
        goto L39
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "screenStateListener");
        CopyOnWriteArraySet<b> r101 = f360255b;
        r101.remove(r100);
        if (r101.isEmpty() == false) goto L6;
        unregisterReceiver();
        return;
    }
}
