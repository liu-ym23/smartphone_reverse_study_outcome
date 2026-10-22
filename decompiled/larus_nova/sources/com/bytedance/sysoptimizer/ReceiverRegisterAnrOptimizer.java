package com.bytedance.sysoptimizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: renamed from: com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes22.dex */
    public static class AnonymousClass1 extends BroadcastReceiver {
        public static /* synthetic */ void a(ScreenReceiverInfo r100, Context r101, Intent r102) {
            lambda$onReceive$0(r100, r101, r102);
        }

        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context r100, final Intent r101) {
            String r102 = r101.getAction();
            if (TextUtils.isEmpty(r102) == false) goto L5;
            return;
        L5:
            Iterator r103 = new ArrayList(ReceiverRegisterAnrOptimizer.access$000()).iterator();
        L7:
            if (r103.hasNext() == false) goto L20;
            final ScreenReceiverInfo r104 = (ScreenReceiverInfo) r103.next();
            String r105 = ReceiverRegisterAnrOptimizer.TAG;
            Objects.toString(r104.receiver);
            IntentFilter r106 = r104.screenFilter;     // Catch: Exception -> L19
            if (r106 == null) goto L7;
            if (r106.hasAction(r102) == false) goto L7;
            Handler r107 = r104.scheduler;     // Catch: Exception -> L19
            if (r107 != null) goto L17;
            r107 = ReceiverRegisterAnrOptimizer.access$100();     // Catch: Exception -> L19
        L17:
            r107.post(new i(r104, r100, r101));     // Catch: Exception -> L19
        L19:
            String r108 = ReceiverRegisterAnrOptimizer.TAG;
            Objects.toString(r104.receiver);
            goto L7
        }

        private static /* synthetic */ void lambda$onReceive$0(ScreenReceiverInfo r100, Context r101, Intent r102) {
            r100.receiver.onReceive(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final enum RegistrationResult extends Enum<RegistrationResult> {
        private static final /* synthetic */ RegistrationResult[] $VALUES = null;
        public static final RegistrationResult BLOCK_FALLBACK = null;
        public static final RegistrationResult ORIGINAL_FALLBACK = null;
        public static final RegistrationResult WRAPPED_RESULT = null;

        static {
            RegistrationResult r100 = new RegistrationResult("ORIGINAL_FALLBACK", 0);
            ORIGINAL_FALLBACK = r100;
            RegistrationResult r101 = new RegistrationResult("BLOCK_FALLBACK", 1);
            BLOCK_FALLBACK = r101;
            RegistrationResult r102 = new RegistrationResult("WRAPPED_RESULT", 2);
            WRAPPED_RESULT = r102;
            $VALUES = new RegistrationResult[]{r100, r101, r102};
        }

        public static RegistrationResult[] values() {
            return (RegistrationResult[]) $VALUES.clone();
        }

        public static RegistrationResult valueOf(String r100) {
            return (RegistrationResult) r27.a.a(RegistrationResult.class, r100);
        }

        private RegistrationResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class ResultWrapper {
        public Intent intent;
        public int result;

        public ResultWrapper(int r100, Intent r101) {
            this.result = r100;
            this.intent = r101;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class ScreenReceiverInfo {
        IntentFilter nonScreenFilter;
        BroadcastReceiver receiver;
        Handler scheduler;
        IntentFilter screenFilter;

        public ScreenReceiverInfo(BroadcastReceiver r100, IntentFilter r101, IntentFilter r102, Handler r103) {
            this.receiver = r100;
            this.screenFilter = r101;
            this.scheduler = r103;
            this.nonScreenFilter = r102;
        }
    }

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

    public static boolean hasScreenActions(IntentFilter r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.countActions()) goto L13;
        String r102 = r100.getAction(r101);
        if (ACTION_SCREEN_ON.equals(r102) == true) goto L11;
        if (ACTION_SCREEN_OFF.equals(r102) == true) goto L17;
        r101 = r101 + 1;
        goto L4
    L17:
        return true;
    L11:
        return true;
    L13:
        return false;
    }

    private static IntentFilter removeScreenActions(IntentFilter r100) {
        IntentFilter r101 = new IntentFilter();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= r100.countActions()) goto L12;
        String r104 = r100.getAction(r103);
        if (ACTION_SCREEN_ON.equals(r104) == true) goto L10;
        if (ACTION_SCREEN_OFF.equals(r104) == true) goto L10;
        r101.addAction(r104);
    L10:
        r103 = r103 + 1;
    L12:
        if (r102 >= r100.countCategories()) goto L14;
        r101.addCategory(r100.getCategory(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r101.setPriority(r100.getPriority());
        return r101;
    }

    public static void setEnableScreenReceiverOptimize(boolean r100) {
        enableScreenReceiverOptimize = r100;
    }

    private static void registerMasterScreenReceiverIfNeeded(IntentFilter r100, Context r101) {
        Object r102 = sMasterLock;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sMasterReceiverRegistered == true) goto L11;
        sMasterScreenReceiver = new AnonymousClass1();     // Catch: Throwable -> L13
        if (Build.VERSION.SDK_INT < 34) goto L9;
        r101.registerReceiver(sMasterScreenReceiver, r100, 2);     // Catch: Throwable -> L13
    L10:
        sMasterReceiverRegistered = true;     // Catch: Throwable -> L13
        goto L11
    L9:
        r101.registerReceiver(sMasterScreenReceiver, r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
    }

    public static boolean unregisterReceiverHasNonScreenFilter(BroadcastReceiver r100, Context r101) {
        ArrayList r102 = new ArrayList();
        Iterator<ScreenReceiverInfo> r103 = sScreenReceivers.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        ScreenReceiverInfo r104 = r103.next();
        if (r104.receiver != r100) goto L4;
        r102.add(r104);
        goto L4
    L8:
        List<ScreenReceiverInfo> r105 = sScreenReceivers;
        r105.removeAll(r102);
        if (r105.isEmpty() == false) goto L21;
        if (sMasterReceiverRegistered == false) goto L21;
        Object r106 = sMasterLock;
        monitor-enter(r106);
        r101.unregisterReceiver(sMasterScreenReceiver);     // Catch: Throwable -> L17
        sMasterReceiverRegistered = false;     // Catch: Throwable -> L17
        sMasterScreenReceiver = null;     // Catch: Throwable -> L17
        monitor-exit(r106);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L21:
        if (r102.size() != 0) goto L24;
        return true;
    L24:
        if (r102.size() > 0) goto L26;
    L30:
        return false;
    L26:
        if (((ScreenReceiverInfo) ListProtector.get(r102, 0)).nonScreenFilter == null) goto L30;
        if (((ScreenReceiverInfo) ListProtector.get(r102, 0)).nonScreenFilter.countActions() <= 0) goto L30;
        return true;
    }

    public static ResultWrapper handleScreenActionRegistration(BroadcastReceiver r100, IntentFilter r110, int r111, String r112, Handler r113, int r114, Context r115) {
        IntentFilter r101 = new IntentFilter();
        r101.addAction(ACTION_SCREEN_ON);
        r101.addAction(ACTION_SCREEN_OFF);
        IntentFilter r102 = removeScreenActions(r110);
        ScreenReceiverInfo r116 = new ScreenReceiverInfo(r100, r101, r102, r113);
        sScreenReceivers.add(r116);
        registerMasterScreenReceiverIfNeeded(r101, r115);
        if (r102.countActions() <= 0) goto L39;
        StringBuffer r103 = new StringBuffer();
        int r104 = 0;
    L6:
        if (r104 >= r102.countActions()) goto L8;
        r103.append(r102.getAction(r104));
        r103.append(",");
        r104 = r104 + 1;
        goto L6
    L8:
        Objects.toString(r100);
        if (r115 != null) goto L13;
        sScreenReceivers.remove(r116);
        return new ResultWrapper(1, null);
    L13:
        if (r114 == 2) goto L37;
        if (r114 == 3) goto L31;
        if (r114 == 4) goto L29;
        if (r114 == 5) goto L23;
        sScreenReceivers.remove(r116);
        return new ResultWrapper(1, null);
    L23:
        if (Build.VERSION.SDK_INT < 26) goto L27;
        return new ResultWrapper(3, r115.registerReceiver(r100, r102, r112, r113, r111));
    L27:
        return new ResultWrapper(3, r115.registerReceiver(r100, r102, r112, r113));
    L29:
        return new ResultWrapper(3, r115.registerReceiver(r100, r102, r112, r113));
    L31:
        if (Build.VERSION.SDK_INT < 26) goto L35;
        return new ResultWrapper(3, r115.registerReceiver(r100, r102, 0));
    L35:
        return new ResultWrapper(3, r115.registerReceiver(r100, r102));
    L37:
        return new ResultWrapper(3, r115.registerReceiver(r100, r102));
    L39:
        return new ResultWrapper(2, null);
    }
}
