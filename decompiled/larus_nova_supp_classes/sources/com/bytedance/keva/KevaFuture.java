package com.bytedance.keva;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class KevaFuture extends Keva implements Keva.ClearMemory {
    private KevaImpl mFallBackInstance;
    private FutureTask<KevaImpl> mFuture;
    private int mMode;
    private String mName;

    private KevaImpl obtain() {
        return com_bytedance_keva_KevaFuture_com_bytedance_keva_KevaPrivateImplLancet_obtain(this);
    }

    public KevaImpl com_bytedance_keva_KevaFuture__obtain$___twin___() {
    L23:
        e = move-exception;
        KevaMonitor r1 = KevaImpl.sMonitor;
        r1.logDebug("fail to obtain keva future instance");
        r1.reportThrowable(5, this.mName, null, null, e);
        if (this.mFallBackInstance != null) goto L28;
        KevaImpl r0 = KevaImpl.getEmptyRepoImpl(this.mName, null, this.mMode);
        this.mFallBackInstance = r0;
        r0.init(false);
    L28:
        return this.mFallBackInstance;
    L3:
        if (this.mFuture.isDone() == true) goto L5;
        long r2 = System.currentTimeMillis();     // Catch: InterruptedException -> L21 Throwable -> L23
        int r3 = KevaImpl.sInitRepoOpt;     // Catch: InterruptedException -> L21 Throwable -> L23
        if (this.mFuture.isDone() == true) goto L17;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L15;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L15;
        this.mFuture.run();     // Catch: InterruptedException -> L21 Throwable -> L23
    L15:
        if (r3 != 2) goto L17;
        this.mFuture.run();     // Catch: InterruptedException -> L21 Throwable -> L23
    L17:
        KevaImpl r4 = this.mFuture.get();     // Catch: InterruptedException -> L21 Throwable -> L23
        KevaInnerPreloader r5 = KevaImpl.sPreloader;     // Catch: InterruptedException -> L21 Throwable -> L23
        if (r5 == null) goto L20;
        long r8 = System.currentTimeMillis() - r2;     // Catch: InterruptedException -> L21 Throwable -> L23
        r5.onObtain(this.mName, this.mMode, System.currentTimeMillis() - KevaImpl.sInitStamp, r8);     // Catch: InterruptedException -> L21 Throwable -> L23
    L20:
        return r4;
    L5:
        return this.mFuture.get();
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        obtain().clear();
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        return obtain().count();
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        obtain().dump();
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        return obtain().getAll();
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return obtain().name();
    }

    public static KevaImpl com_bytedance_keva_KevaFuture_com_bytedance_keva_KevaPrivateImplLancet_obtain(KevaFuture r2) {
        KevaImpl r3 = r2.com_bytedance_keva_KevaFuture__obtain$___twin___();
        if (KevaPreloadHolder.fetchEnable == true) goto L5;
    L9:
        return r3;
    L5:
        if (Looper.myLooper() != KevaPrivateImplLancet.sMainLooper) goto L9;
        int r0 = KevaPrivateImplLancet.getKevaMode(r3);
        if (r0 == (-1)) goto L9;
        KevaPreloadHolder.tryPutPreloadMap(r3.name(), r0);
        goto L9
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r2) {
        return obtain().buildNewMap(r2);
    }

    public void checkMode(int r2) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().checkMode(r2);
        return;
    }

    @Override // com.bytedance.keva.Keva.ClearMemory
    public void clearMemory(int r2) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().clearMemory(r2);
        return;
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r2) {
        return obtain().contains(r2);
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r2) {
        obtain().erase(r2);
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r2) {
        obtain().registerChangeListener(r2);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r2) {
        obtain().unRegisterChangeListener(r2);
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r2, boolean r3) {
        return obtain().getBoolean(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r2, byte[] r3) {
        return obtain().getBytes(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r2, byte[] r3) {
        return obtain().getBytesJustDisk(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r2, double r3) {
        return obtain().getDouble(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r2, float r3) {
        return obtain().getFloat(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r2, int r3) {
        return obtain().getInt(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r2, long r3) {
        return obtain().getLong(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r2, String r3) {
        return obtain().getString(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r2, String[] r3) {
        return obtain().getStringArray(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r2, String[] r3) {
        return obtain().getStringArrayJustDisk(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r2, String r3) {
        return obtain().getStringJustDisk(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r2, Set<String> r3) {
        return obtain().getStringSet(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r2, Set<String> r3) {
        return obtain().getStringSetJustDisk(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r2, boolean r3) {
        obtain().storeBoolean(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r2, byte[] r3) {
        obtain().storeBytes(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r2, byte[] r3) {
        obtain().storeBytesJustDisk(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r2, double r3) {
        obtain().storeDouble(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r2, float r3) {
        obtain().storeFloat(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r2, int r3) {
        obtain().storeInt(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r2, long r3) {
        obtain().storeLong(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r2, String r3) {
        obtain().storeString(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r2, String[] r3) {
        obtain().storeStringArray(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r2, String[] r3) {
        obtain().storeStringArrayJustDisk(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r2, String r3) {
        obtain().storeStringJustDisk(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r2, Set<String> r3) {
        obtain().storeStringSet(r2, r3);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r2, Set<String> r3) {
        obtain().storeStringSetJustDisk(r2, r3);
    }

    public KevaFuture(String r1, int r2, Callable<KevaImpl> r3) {
        this.mName = r1;
        this.mMode = r2;
        FutureTask<KevaImpl> r4 = new FutureTask(r3);
        this.mFuture = r4;
        if (KevaImpl.sEnableExecutorOpt == true) goto L5;
        KevaImpl.sExecutor.execute(r4);
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        this.mFuture.run();
        return;
    L7:
        KevaImpl.sExecutor.execute(this.mFuture);
    }
}
