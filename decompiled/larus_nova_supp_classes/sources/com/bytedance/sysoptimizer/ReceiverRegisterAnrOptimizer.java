package com.bytedance.sysoptimizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ReceiverRegisterAnrOptimizer {
    private static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    private static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    public static final int BLOCK_FALLBACK = 2;
    public static final int FIVE_PARAM_REGISTER = 5;
    public static final int FOUR_PARAM_REGISTER = 4;
    public static final int ORIGINAL_FALLBACK = 1;
    public static String TAG = "ReceiverRegisterAnrOptimizer";
    public static final int THREE_PARAM_REGISTER = 3;
    public static final int TWO_PARAM_REGISTER = 2;
    public static final int WRAPPED_RESULT = 3;
    static boolean enableScreenReceiverOptimize;
    private static final Handler mMainHandler = null;
    private static final Object sMasterLock = null;
    private static volatile boolean sMasterReceiverRegistered;
    private static BroadcastReceiver sMasterScreenReceiver;
    private static final List<ScreenReceiverInfo> sScreenReceivers = null;

    public ReceiverRegisterAnrOptimizer() {
    }

    static {
        sMasterLock = new Object();
        mMainHandler = new Handler(Looper.getMainLooper());
        sScreenReceivers = new CopyOnWriteArrayList();
    }

    public static /* synthetic */ List access$000() {
        return sScreenReceivers;
    }

    public static /* synthetic */ Handler access$100() {
        return mMainHandler;
    }

    public static boolean isEnableScreenReceiverOptimize() {
        return enableScreenReceiverOptimize;
    }

    public static boolean hasScreenActions(IntentFilter r4) {
        int r1 = 0;
    L4:
        if (r1 >= r4.countActions()) goto L13;
        String r2 = r4.getAction(r1);
        if (ACTION_SCREEN_ON.equals(r2) == true) goto L11;
        if (ACTION_SCREEN_OFF.equals(r2) == true) goto L17;
        r1 = r1 + 1;
        goto L4
    L17:
        return true;
    L11:
        return true;
    L13:
        return false;
    }

    private static IntentFilter removeScreenActions(IntentFilter r5) {
        IntentFilter r0 = new IntentFilter();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r5.countActions()) goto L12;
        String r3 = r5.getAction(r2);
        if (ACTION_SCREEN_ON.equals(r3) == true) goto L10;
        if (ACTION_SCREEN_OFF.equals(r3) == true) goto L10;
        r0.addAction(r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (r1 >= r5.countCategories()) goto L14;
        r0.addCategory(r5.getCategory(r1));
        r1 = r1 + 1;
        goto L12
    L14:
        r0.setPriority(r5.getPriority());
        return r0;
    }

    public static void setEnableScreenReceiverOptimize(boolean r0) {
        enableScreenReceiverOptimize = r0;
    }

    private static void registerMasterScreenReceiverIfNeeded(IntentFilter r3, Context r4) {
        Object r0 = sMasterLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sMasterReceiverRegistered == true) goto L11;
        sMasterScreenReceiver = new 1();     // Catch: Throwable -> L13
        if (Build.VERSION.SDK_INT < 34) goto L9;
        r4.registerReceiver(sMasterScreenReceiver, r3, 2);     // Catch: Throwable -> L13
    L10:
        sMasterReceiverRegistered = true;     // Catch: Throwable -> L13
        goto L11
    L9:
        r4.registerReceiver(sMasterScreenReceiver, r3);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public static boolean unregisterReceiverHasNonScreenFilter(BroadcastReceiver r4, Context r5) {
        ArrayList r0 = new ArrayList();
        Iterator<ScreenReceiverInfo> r1 = sScreenReceivers.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        ScreenReceiverInfo r2 = r1.next();
        if (r2.receiver != r4) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List<ScreenReceiverInfo> r6 = sScreenReceivers;
        r6.removeAll(r0);
        if (r6.isEmpty() == false) goto L21;
        if (sMasterReceiverRegistered == false) goto L21;
        Object r7 = sMasterLock;
        monitor-enter(r7);
        r5.unregisterReceiver(sMasterScreenReceiver);     // Catch: Throwable -> L17
        sMasterReceiverRegistered = false;     // Catch: Throwable -> L17
        sMasterScreenReceiver = null;     // Catch: Throwable -> L17
        monitor-exit(r7);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L21:
        if (r0.size() != 0) goto L24;
        return true;
    L24:
        if (r0.size() > 0) goto L26;
    L30:
        return false;
    L26:
        if (((ScreenReceiverInfo) ListProtector.get(r0, 0)).nonScreenFilter == null) goto L30;
        if (((ScreenReceiverInfo) ListProtector.get(r0, 0)).nonScreenFilter.countActions() <= 0) goto L30;
        return true;
    }

    public static ResultWrapper handleScreenActionRegistration(BroadcastReceiver r9, IntentFilter r10, int r11, String r12, Handler r13, int r14, Context r15) {
        IntentFilter r0 = new IntentFilter();
        r0.addAction(ACTION_SCREEN_ON);
        r0.addAction(ACTION_SCREEN_OFF);
        IntentFilter r4 = removeScreenActions(r10);
        ScreenReceiverInfo r16 = new ScreenReceiverInfo(r9, r0, r4, r13);
        sScreenReceivers.add(r16);
        registerMasterScreenReceiverIfNeeded(r0, r15);
        if (r4.countActions() <= 0) goto L39;
        StringBuffer r1 = new StringBuffer();
        int r5 = 0;
    L6:
        if (r5 >= r4.countActions()) goto L8;
        r1.append(r4.getAction(r5));
        r1.append(",");
        r5 = r5 + 1;
        goto L6
    L8:
        Objects.toString(r9);
        if (r15 != null) goto L13;
        sScreenReceivers.remove(r16);
        return new ResultWrapper(1, null);
    L13:
        if (r14 == 2) goto L37;
        if (r14 == 3) goto L31;
        if (r14 == 4) goto L29;
        if (r14 == 5) goto L23;
        sScreenReceivers.remove(r16);
        return new ResultWrapper(1, null);
    L23:
        if (Build.VERSION.SDK_INT < 26) goto L27;
        return new ResultWrapper(3, r15.registerReceiver(r9, r4, r12, r13, r11));
    L27:
        return new ResultWrapper(3, r15.registerReceiver(r9, r4, r12, r13));
    L29:
        return new ResultWrapper(3, r15.registerReceiver(r9, r4, r12, r13));
    L31:
        if (Build.VERSION.SDK_INT < 26) goto L35;
        return new ResultWrapper(3, r15.registerReceiver(r9, r4, 0));
    L35:
        return new ResultWrapper(3, r15.registerReceiver(r9, r4));
    L37:
        return new ResultWrapper(3, r15.registerReceiver(r9, r4));
    L39:
        return new ResultWrapper(2, null);
    }
}
