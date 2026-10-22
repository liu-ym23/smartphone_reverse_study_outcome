package a35;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0 {
    public final ml5.b a;
    public final ReadWriteLock b;

    public b0() {
        this.a = new ml5.b("sync_offline_retry_recorder");
        this.b = new ReentrantReadWriteLock();
    }

    public final void a(OfflineDoc r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r6.getObj_token()) == true) goto L15;
        AccountService$Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        String r1 = d(r0, r6.getObj_token());
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return;
    L9:
        g(r1, r6.getObj_token(), true, -1);
        if (c(r1, r6) != 1) goto L14;
        h(e(r0, r6.getObj_token()), System.currentTimeMillis(), r6.getObj_token());
        return;
    L14:
        return;
    }

    public final com.bytedance.apm.util.n<Boolean, Integer> b(OfflineDoc r21) {
        Boolean r0 = Boolean.FALSE;
        com.bytedance.apm.util.n<Boolean, Integer> r4 = new com.bytedance.apm.util.n(r0, 0);
        if (r21 != null) goto L5;
    L33:
        r4.a = r0;
        return r4;
    L5:
        if (TextUtils.isEmpty(r21.getObj_token()) == true) goto L33;
        AccountService$Account r6 = ((h0) org.koin.java.a.a(h0.class)).G2();
        String r7 = d(r6, r21.getObj_token());
        if (TextUtils.isEmpty(r7) == false) goto L11;
        r4.a = r0;
        return r4;
    L11:
        int r8 = c(r7, r21);
        boolean r9 = true;
        if (r8 > 2) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == true) goto L30;
        String r1 = e(r6, r21.getObj_token());
        ((ReentrantReadWriteLock) this.b).readLock().lock();     // Catch: Throwable -> L19 Exception -> L21
        tt5.a.b("SyncOfflineRecorder", "fetchLastSyncTimeStamp... for doc : " + r21.getObj_token());     // Catch: Throwable -> L19 Exception -> L21
        long r14 = this.a.a.getLong(r1, 0);     // Catch: Throwable -> L19 Exception -> L21
        tt5.a.b("SyncOfflineRecorder", "fetchLastSyncTimeStamp... target doc : " + r21.getObj_token() + " last sync time : " + r14);     // Catch: Throwable -> L19 Exception -> L21
        ((ReentrantReadWriteLock) this.b).readLock().unlock();
    L24:
        long r11 = System.currentTimeMillis();
        tt5.a.h("SyncOfflineRecorder", "can`t sync, last sync time = " + r14);
        if (Math.abs(r11 - r14) < 259200000) goto L27;
        tt5.a.h("SyncOfflineRecorder", "last sync time is one day ago from: " + r14 + "to : " + r11);
        f(r21.getObj_token());
        h(e(r6, r21.getObj_token()), 0, r21.getObj_token());
        int r5 = 0;
    L31:
        r4.a = Boolean.valueOf(r9);
        r4.b = Integer.valueOf(r5);
        return r4;
    L27:
        tt5.a.d("SyncOfflineRecorder", "too many trials within one day, shall be reject");
        goto L30
    L19:
        th = move-exception;
        ((ReentrantReadWriteLock) this.b).readLock().unlock();
        throw th;
    L21:
        e = move-exception;
        tt5.a.e("SyncOfflineRecorder", "fetchLastSyncTimeStamp... err happens", e, false);     // Catch: Throwable -> L19
        ((ReentrantReadWriteLock) this.b).readLock().unlock();
        r14 = 0;
    L30:
        r5 = r8;
        r9 = r10;
        goto L31
    L14:
        r10 = false;
        goto L15
    }

    public final void f(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        AccountService$Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        String r1 = d(r0, r4);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return;
    L8:
        g(r1, r4, false, 0);
        h(e(r0, r4), 0, r4);
    }

    public static String d(AccountService$Account r2, String r3) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (TextUtils.isEmpty(r2.uid) == false) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r2.token) == false) goto L8;
        return "";
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return "";
    L11:
        return r2.uid + "-" + r2.token + "-" + r3;
    }

    public static String e(AccountService$Account r1, String r2) {
        String r3 = d(r1, r2);
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return "";
    L7:
        return "last_sync_time_" + r3;
    }

    public final int c(String r6, OfflineDoc r7) {
        ((ReentrantReadWriteLock) this.b).readLock().lock();     // Catch: Exception -> L6 Throwable -> L8
        tt5.a.b("SyncOfflineRecorder", "fetchRetryTimes... for doc : " + r7.getObj_token());     // Catch: Exception -> L6 Throwable -> L8
        int r8 = this.a.a.getInt(r6, 0);     // Catch: Exception -> L6 Throwable -> L8
        tt5.a.b("SyncOfflineRecorder", "fetchRetryTimes... target doc : " + r7.getObj_token() + " retry times : " + r8);     // Catch: Exception -> L6 Throwable -> L8
        ((ReentrantReadWriteLock) this.b).readLock().unlock();
        return r8;
    L8:
        th = move-exception;
        ((ReentrantReadWriteLock) this.b).readLock().unlock();
        throw th;
    L6:
        e = move-exception;
        tt5.a.e("SyncOfflineRecorder", "fetchRetryTimes... err happens", e, false);     // Catch: Throwable -> L8
        ((ReentrantReadWriteLock) this.b).readLock().unlock();
        return 0;
    }

    public final void h(String r6, long r7, String r9) {
        ((ReentrantReadWriteLock) this.b).writeLock().lock();     // Catch: Throwable -> L6 Exception -> L8
        tt5.a.b("SyncOfflineRecorder", "writeLastSyncTimeStamp... for doc : " + r9);     // Catch: Throwable -> L6 Exception -> L8
        if (r7 != 0) goto L10;
        ml5.b r2 = this.a;     // Catch: Throwable -> L6 Exception -> L8
        r2.getClass();     // Catch: Throwable -> L6 Exception -> L8
        Intrinsics.checkNotNullParameter(r6, "key");     // Catch: Throwable -> L6 Exception -> L8
        String r8 = r6.toString();     // Catch: Throwable -> L6 Exception -> L8
        ml5.b.a r3 = r2.a;     // Catch: Throwable -> L6 Exception -> L8
        r3.getClass();     // Catch: Throwable -> L6 Exception -> L8
        r3.remove(r8);     // Catch: Throwable -> L6 Exception -> L8
    L11:
        tt5.a.b("SyncOfflineRecorder", "writeLastSyncTimeStamp... target doc : " + r9 + " last sync time : " + r7);     // Catch: Throwable -> L6 Exception -> L8
    L14:
        ((ReentrantReadWriteLock) this.b).writeLock().unlock();
        return;
    L10:
        this.a.b(r6, Long.valueOf(r7));     // Catch: Throwable -> L6 Exception -> L8
    L8:
        e = move-exception;
        tt5.a.e("SyncOfflineRecorder", "writeLastSyncTimeStamp... err happens", e, false);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.b).writeLock().unlock();
        throw th;
    }

    public final void g(String r6, String r7, boolean r8, int r9) {
        ((ReentrantReadWriteLock) this.b).writeLock().lock();     // Catch: Throwable -> L10 Exception -> L12
        tt5.a.b("SyncOfflineRecorder", "updateRetryTimes... for doc : " + r7);     // Catch: Throwable -> L10 Exception -> L12
        int r1 = ((Integer) this.a.a(r6, 0)).intValue();     // Catch: Throwable -> L10 Exception -> L12
        if (r8 == false) goto L8;
        int r2 = r1 + 1;
        this.a.b(r6, Integer.valueOf(r2));     // Catch: Throwable -> L10 Exception -> L12
        tt5.a.b("SyncOfflineRecorder", "updateRetryTimes... target doc : " + r7 + " retry times set to be : " + r2);     // Catch: Throwable -> L10 Exception -> L12
    L23:
    L17:
        ((ReentrantReadWriteLock) this.b).writeLock().unlock();
        return;
    L8:
        if (r9 != 0) goto L14;
        ml5.b r10 = this.a;     // Catch: Throwable -> L10 Exception -> L12
        r10.getClass();     // Catch: Throwable -> L10 Exception -> L12
        Intrinsics.checkNotNullParameter(r6, "key");     // Catch: Throwable -> L10 Exception -> L12
        String r11 = r6.toString();     // Catch: Throwable -> L10 Exception -> L12
        ml5.b.a r12 = r10.a;     // Catch: Throwable -> L10 Exception -> L12
        r12.getClass();     // Catch: Throwable -> L10 Exception -> L12
        r12.remove(r11);     // Catch: Throwable -> L10 Exception -> L12
        tt5.a.b("SyncOfflineRecorder", "updateRetryTimes... target doc : " + r7 + " retry times shall be removed");     // Catch: Throwable -> L10 Exception -> L12
        goto L23
    L14:
        this.a.b(r6, Integer.valueOf(r9));     // Catch: Throwable -> L10 Exception -> L12
        tt5.a.b("SyncOfflineRecorder", "updateRetryTimes... target doc : " + r7 + " retry times set to be : " + r9);     // Catch: Throwable -> L10 Exception -> L12
    L10:
        th = move-exception;
        ((ReentrantReadWriteLock) this.b).writeLock().unlock();
        throw th;
    L12:
        e = move-exception;
        tt5.a.e("SyncOfflineRecorder", "updateRetryTimes... err happens : ", e, false);     // Catch: Throwable -> L10
        goto L17
    }
}
