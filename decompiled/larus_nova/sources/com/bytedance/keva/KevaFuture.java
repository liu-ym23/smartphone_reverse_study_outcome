package com.bytedance.keva;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
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
        KevaMonitor r100 = KevaImpl.sMonitor;
        r100.logDebug("fail to obtain keva future instance");
        r100.reportThrowable(5, this.mName, null, null, e);
        if (this.mFallBackInstance != null) goto L28;
        KevaImpl r101 = KevaImpl.getEmptyRepoImpl(this.mName, null, this.mMode);
        this.mFallBackInstance = r101;
        r101.init(false);
    L28:
        return this.mFallBackInstance;
    L3:
        if (this.mFuture.isDone() == true) goto L5;
        long r102 = System.currentTimeMillis();     // Catch: InterruptedException -> L21 Throwable -> L23
        int r103 = KevaImpl.sInitRepoOpt;     // Catch: InterruptedException -> L21 Throwable -> L23
        if (this.mFuture.isDone() == true) goto L17;
        if (r103 == 0) goto L17;
        if (r103 != 1) goto L15;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L15;
        this.mFuture.run();     // Catch: InterruptedException -> L21 Throwable -> L23
    L15:
        if (r103 != 2) goto L17;
        this.mFuture.run();     // Catch: InterruptedException -> L21 Throwable -> L23
    L17:
        KevaImpl r104 = this.mFuture.get();     // Catch: InterruptedException -> L21 Throwable -> L23
        KevaInnerPreloader r105 = KevaImpl.sPreloader;     // Catch: InterruptedException -> L21 Throwable -> L23
        if (r105 == null) goto L20;
        long r106 = System.currentTimeMillis() - r102;     // Catch: InterruptedException -> L21 Throwable -> L23
        r105.onObtain(this.mName, this.mMode, System.currentTimeMillis() - KevaImpl.sInitStamp, r106);     // Catch: InterruptedException -> L21 Throwable -> L23
    L20:
        return r104;
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

    public static KevaImpl com_bytedance_keva_KevaFuture_com_bytedance_keva_KevaPrivateImplLancet_obtain(KevaFuture r100) {
        KevaImpl r101 = r100.com_bytedance_keva_KevaFuture__obtain$___twin___();
        if (KevaPreloadHolder.fetchEnable == true) goto L5;
    L9:
        return r101;
    L5:
        if (Looper.myLooper() != KevaPrivateImplLancet.sMainLooper) goto L9;
        int r102 = KevaPrivateImplLancet.getKevaMode(r101);
        if (r102 == (-1)) goto L9;
        KevaPreloadHolder.tryPutPreloadMap(r101.name(), r102);
        goto L9
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r100) {
        return obtain().buildNewMap(r100);
    }

    public void checkMode(int r100) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().checkMode(r100);
        return;
    }

    @Override // com.bytedance.keva.Keva.ClearMemory
    public void clearMemory(int r100) {
        if (this.mFuture.isDone() == false) goto L6;
        obtain().clearMemory(r100);
        return;
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r100) {
        return obtain().contains(r100);
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r100) {
        obtain().erase(r100);
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r100) {
        obtain().registerChangeListener(r100);
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r100) {
        obtain().unRegisterChangeListener(r100);
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r100, boolean r101) {
        return obtain().getBoolean(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r100, byte[] r101) {
        return obtain().getBytes(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r100, byte[] r101) {
        return obtain().getBytesJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r100, double r101) {
        return obtain().getDouble(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r100, float r101) {
        return obtain().getFloat(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r100, int r101) {
        return obtain().getInt(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r100, long r101) {
        return obtain().getLong(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r100, String r101) {
        return obtain().getString(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r100, String[] r101) {
        return obtain().getStringArray(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r100, String[] r101) {
        return obtain().getStringArrayJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r100, String r101) {
        return obtain().getStringJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r100, Set<String> r101) {
        return obtain().getStringSet(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r100, Set<String> r101) {
        return obtain().getStringSetJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r100, boolean r101) {
        obtain().storeBoolean(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r100, byte[] r101) {
        obtain().storeBytes(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r100, byte[] r101) {
        obtain().storeBytesJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r100, double r101) {
        obtain().storeDouble(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r100, float r101) {
        obtain().storeFloat(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r100, int r101) {
        obtain().storeInt(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r100, long r101) {
        obtain().storeLong(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r100, String r101) {
        obtain().storeString(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r100, String[] r101) {
        obtain().storeStringArray(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r100, String[] r101) {
        obtain().storeStringArrayJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r100, String r101) {
        obtain().storeStringJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r100, Set<String> r101) {
        obtain().storeStringSet(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r100, Set<String> r101) {
        obtain().storeStringSetJustDisk(r100, r101);
    }

    public KevaFuture(String r100, int r101, Callable<KevaImpl> r102) {
        this.mName = r100;
        this.mMode = r101;
        FutureTask<KevaImpl> r103 = new FutureTask(r102);
        this.mFuture = r103;
        if (KevaImpl.sEnableExecutorOpt == true) goto L5;
        KevaImpl.sExecutor.execute(r103);
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        this.mFuture.run();
        return;
    L7:
        KevaImpl.sExecutor.execute(this.mFuture);
    }
}
