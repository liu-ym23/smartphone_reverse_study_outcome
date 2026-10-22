package com.huawei.agconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class LocalBrdMnger {
    private static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final Object M_LOCK = null;
    private static LocalBrdMnger mInstance;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers;

    public static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent r100, ArrayList<ReceiverRecord> r101) {
            this.intent = r100;
            this.receivers = r101;
        }
    }

    public static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        public ReceiverRecord(IntentFilter r100, BroadcastReceiver r101) {
            this.filter = r100;
            this.receiver = r101;
        }

        public String toString() {
            return "Receiver{" + this.receiver + " filter=" + this.filter + i.f25855d;
        }
    }

    static {
        M_LOCK = new Object();
    }

    private LocalBrdMnger(Context r100) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = r100;
        final Looper r101 = r100.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r101);
    }

    public static /* synthetic */ void access$000(LocalBrdMnger r100) {
        r100.executePendingBroadcasts();
    }

    private void executePendingBroadcasts() {
    L2:
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> r100 = this.mReceivers;
        monitor-enter(r100);
        int r101 = this.mPendingBroadcasts.size();     // Catch: Throwable -> L17
        if (r101 <= 0) goto L6;
        BroadcastRecord[] r102 = new BroadcastRecord[r101];     // Catch: Throwable -> L17
        this.mPendingBroadcasts.toArray(r102);     // Catch: Throwable -> L17
        this.mPendingBroadcasts.clear();     // Catch: Throwable -> L17
        monitor-exit(r100);     // Catch: Throwable -> L17
        int r103 = 0;
    L11:
        if (r103 >= r101) goto L2;
        BroadcastRecord r104 = r102[r103];
        int r105 = 0;
    L14:
        if (r105 >= r104.receivers.size()) goto L16;
        ((ReceiverRecord) ListProtector.get(r104.receivers, r105)).receiver.onReceive(this.mAppContext, r104.intent);
        r105 = r105 + 1;
        goto L14
    L16:
        r103 = r103 + 1;
        goto L11
    L6:
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static LocalBrdMnger getInstance(Context r100) {
        Object r101 = M_LOCK;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        mInstance = new LocalBrdMnger(r100.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        LocalBrdMnger r102 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    }

    public void registerReceiver(BroadcastReceiver r100, IntentFilter r101) {
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> r102 = this.mReceivers;
        monitor-enter(r102);
        ReceiverRecord r103 = new ReceiverRecord(r101, r100);     // Catch: Throwable -> L16
        ArrayList<IntentFilter> r104 = this.mReceivers.get(r100);     // Catch: Throwable -> L16
        if (r104 != null) goto L7;
        r104 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mReceivers.put(r100, r104);     // Catch: Throwable -> L16
    L7:
        r104.add(r101);     // Catch: Throwable -> L16
        int r105 = 0;
    L9:
        if (r105 >= r101.countActions()) goto L14;
        String r106 = r101.getAction(r105);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r107 = this.mActions.get(r106);     // Catch: Throwable -> L16
        if (r107 != null) goto L13;
        r107 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mActions.put(r106, r107);     // Catch: Throwable -> L16
    L13:
        r107.add(r103);     // Catch: Throwable -> L16
        r105 = r105 + 1;     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean sendBroadcast(Intent r210) {
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> r100 = this.mReceivers;
        monitor-enter(r100);
        String r110 = r210.getAction();     // Catch: Throwable -> L34
        String r111 = r210.resolveTypeIfNeeded(this.mAppContext.getContentResolver());     // Catch: Throwable -> L34
        Uri r112 = r210.getData();     // Catch: Throwable -> L34
        String r113 = r210.getScheme();     // Catch: Throwable -> L34
        Set<String> r114 = r210.getCategories();     // Catch: Throwable -> L34
        ArrayList<ReceiverRecord> r115 = this.mActions.get(r210.getAction());     // Catch: Throwable -> L34
        if (r115 == null) goto L31;
        ArrayList r101 = null;
        int r102 = 0;
    L8:
        if (r102 >= r115.size()) goto L20;
        ReceiverRecord r103 = r115.get(r102);     // Catch: Throwable -> L34
        if (r103.broadcasting == false) goto L12;
        int r116 = r102;
        String r117 = r110;
        String r118 = r111;
        Uri r211 = r112;
        ArrayList r119 = r101;
    L18:
        r101 = r119;
    L19:
        r102 = r116 + 1;     // Catch: Throwable -> L34
        r110 = r117;
        r111 = r118;
        r112 = r211;
        goto L8
    L12:
        r117 = r110;
        r118 = r111;
        r116 = r102;
        r119 = r101;
        r211 = r112;
        if (r103.filter.match(r110, r111, r113, r112, r114, "LocalBroadcastManager") < 0) goto L18;
        if (r119 != null) goto L16;
        r101 = new ArrayList();     // Catch: Throwable -> L34
    L17:
        r101.add(r103);     // Catch: Throwable -> L34
        r103.broadcasting = true;     // Catch: Throwable -> L34
        goto L19
    L16:
        r101 = r119;
        goto L17
    L20:
        ArrayList r120 = r101;
        boolean r121 = false;
        if (r120 == null) goto L32;
        int r104 = 0;
    L24:
        if (r104 >= r120.size()) goto L26;
        ((ReceiverRecord) r120.get(r104)).broadcasting = false;     // Catch: Throwable -> L34
        r104 = r104 + 1;     // Catch: Throwable -> L34
        goto L24
    L26:
        this.mPendingBroadcasts.add(new BroadcastRecord(r210, r120));     // Catch: Throwable -> L34
        if (this.mHandler.hasMessages(1) == true) goto L29;
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L34
    L29:
        monitor-exit(r100);     // Catch: Throwable -> L34
        return true;
    L32:
        monitor-exit(r100);     // Catch: Throwable -> L34
        return r121;
    L31:
        r121 = false;
    L34:
        th = move-exception;
        throw th;
    }

    public void unregisterReceiver(BroadcastReceiver r110) {
        HashMap<BroadcastReceiver, ArrayList<IntentFilter>> r100 = this.mReceivers;
        monitor-enter(r100);
        ArrayList<IntentFilter> r101 = this.mReceivers.remove(r110);     // Catch: Throwable -> L30
        if (r101 != null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L30
        return;
    L8:
        int r102 = 0;
    L10:
        if (r102 >= r101.size()) goto L28;
        IntentFilter r103 = r101.get(r102);     // Catch: Throwable -> L30
        int r104 = 0;
    L13:
        if (r104 >= r103.countActions()) goto L27;
        String r105 = r103.getAction(r104);     // Catch: Throwable -> L30
        ArrayList<ReceiverRecord> r106 = this.mActions.get(r105);     // Catch: Throwable -> L30
        if (r106 == null) goto L26;
        int r107 = 0;
    L18:
        if (r107 >= r106.size()) goto L24;
        if (r106.get(r107).receiver != r110) goto L22;
        r106.remove(r107);     // Catch: Throwable -> L30
        r107 = r107 - 1;     // Catch: Throwable -> L30
    L22:
        r107 = r107 + 1;     // Catch: Throwable -> L30
        goto L18
    L24:
        if (r106.size() > 0) goto L26;
        this.mActions.remove(r105);     // Catch: Throwable -> L30
    L26:
        r104 = r104 + 1;     // Catch: Throwable -> L30
        goto L13
    L27:
        r102 = r102 + 1;     // Catch: Throwable -> L30
        goto L10
    L28:
        monitor-exit(r100);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    }
}
