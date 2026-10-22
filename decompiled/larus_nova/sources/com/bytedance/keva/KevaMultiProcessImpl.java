package com.bytedance.keva;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KevaMultiProcessImpl extends KevaImpl {
    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L12
        this.mValueMap.clear();     // Catch: Throwable -> L12
        rebuildValueMap(this.mHandle);     // Catch: Throwable -> L7
        KevaImpl.checkReportException(this.mHandle);     // Catch: Throwable -> L7
        int r100 = this.mValueMap.size();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L12
        return r100;
    L7:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), null, null, th);     // Catch: Throwable -> L12
        return 0;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L12
        this.mValueMap.clear();     // Catch: Throwable -> L12
        rebuildValueMap(this.mHandle);     // Catch: Throwable -> L6
        KevaImpl.checkReportException(this.mHandle);     // Catch: Throwable -> L6
    L9:
        Map<String, ?> r100 = buildNewMap(new HashMap());     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r100;
    L6:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), null, null, th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String name() {
        return super.name();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void dump() {
        super.dump();
    }

    @Override // com.bytedance.keva.KevaImpl
    public /* bridge */ /* synthetic */ void dumpNative() {
        super.dumpNative();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Map buildNewMap(Map r100) {
        return super.buildNewMap(r100);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva.ClearMemory
    public /* bridge */ /* synthetic */ void clearMemory(int r100) {
        super.clearMemory(r100);
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r100) {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        KevaImpl.KevaValueWrapper r101 = this.mValueMap.get(r100);     // Catch: Throwable -> L11
        long r102 = this.mHandle;     // Catch: Throwable -> L11
        if (r101 != null) goto L7;
        long r103 = 0;
    L8:
        boolean r104 = contains(r102, r100, r103);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L16
        return r104;
    L7:
        r103 = r101.offset;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        KevaImpl.sMonitor.reportThrowable(2, name(), r100, null, th);     // Catch: Throwable -> L16
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void erase(String r100) {
        super.erase(r100);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void registerChangeListener(Keva.OnChangeListener r100) {
        super.registerChangeListener(r100);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void unRegisterChangeListener(Keva.OnChangeListener r100) {
        super.unRegisterChangeListener(r100);
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r100, boolean r110) {
        KevaImpl.KevaValueWrapper r101 = this.mValueMap.get(r100);
        long r102 = this.mHandle;
        if (r101 != null) goto L5;
        long r103 = 0;
    L7:
        return fetchBoolean(r102, r100, r103, r110);
    L5:
        r103 = r101.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r110, double r111) {
        KevaImpl.KevaValueWrapper r100 = this.mValueMap.get(r110);
        long r101 = this.mHandle;
        if (r100 != null) goto L5;
        long r102 = 0;
    L7:
        return fetchDouble(r101, r110, r102, r111);
    L5:
        r102 = r100.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r100, float r110) {
        KevaImpl.KevaValueWrapper r101 = this.mValueMap.get(r100);
        long r102 = this.mHandle;
        if (r101 != null) goto L5;
        long r103 = 0;
    L7:
        return fetchFloat(r102, r100, r103, r110);
    L5:
        r103 = r101.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r100, int r110) {
        KevaImpl.KevaValueWrapper r101 = this.mValueMap.get(r100);
        long r102 = this.mHandle;
        if (r101 != null) goto L5;
        long r103 = 0;
    L7:
        return fetchInt(r102, r100, r103, r110);
    L5:
        r103 = r101.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r110, long r111) {
        KevaImpl.KevaValueWrapper r100 = this.mValueMap.get(r110);
        long r101 = this.mHandle;
        if (r100 != null) goto L5;
        long r102 = 0;
    L7:
        return fetchLong(r101, r110, r102, r111);
    L5:
        r102 = r100.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ boolean getBoolean(String r100, boolean r101) {
        return super.getBoolean(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytes(String r100, byte[] r101) {
        return super.getBytes(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytesJustDisk(String r100, byte[] r101) {
        return super.getBytesJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ double getDouble(String r100, double r101) {
        return super.getDouble(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ float getFloat(String r100, float r101) {
        return super.getFloat(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ int getInt(String r100, int r101) {
        return super.getInt(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ long getLong(String r100, long r101) {
        return super.getLong(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getString(String r100, String r101) {
        return super.getString(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArray(String r100, String[] r101) {
        return super.getStringArray(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArrayJustDisk(String r100, String[] r101) {
        return super.getStringArrayJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getStringJustDisk(String r100, String r101) {
        return super.getStringJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSet(String r100, Set r101) {
        return super.getStringSet(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSetJustDisk(String r100, Set r101) {
        return super.getStringSetJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBoolean(String r100, boolean r101) {
        super.storeBoolean(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytes(String r100, byte[] r101) {
        super.storeBytes(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytesJustDisk(String r100, byte[] r101) {
        super.storeBytesJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeDouble(String r100, double r101) {
        super.storeDouble(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeFloat(String r100, float r101) {
        super.storeFloat(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeInt(String r100, int r101) {
        super.storeInt(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeLong(String r100, long r101) {
        super.storeLong(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeString(String r100, String r101) {
        super.storeString(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArray(String r100, String[] r101) {
        super.storeStringArray(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArrayJustDisk(String r100, String[] r101) {
        super.storeStringArrayJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringJustDisk(String r100, String r101) {
        super.storeStringJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSet(String r100, Set r101) {
        super.storeStringSet(r100, r101);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSetJustDisk(String r100, Set r101) {
        super.storeStringSetJustDisk(r100, r101);
    }

    public KevaMultiProcessImpl(String r100, String r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r100, String r101, boolean r110) {
        KevaImpl.KevaValueWrapper r111 = this.mValueMap.get(r100);
        long r102 = this.mHandle;
        if (r111 != null) goto L5;
        long r103 = 0;
    L7:
        return fetchString(r102, r100, r103, r101);
    L5:
        r103 = r111.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r100, String[] r110, boolean r111) {
        KevaImpl.KevaValueWrapper r112 = this.mValueMap.get(r100);
        long r101 = this.mHandle;
        if (r112 != null) goto L5;
        long r102 = 0;
    L7:
        return fetchStringArray(r101, r100, r102, r110, 3);
    L5:
        r102 = r112.offset;
        goto L7
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r100, byte[] r110, int r111, boolean r112) {
        KevaImpl.KevaValueWrapper r113 = this.mValueMap.get(r100);
        long r101 = this.mHandle;
        if (r113 != null) goto L5;
        long r102 = 0;
    L7:
        return fetchBytes(r101, r100, r102, r110, r111);
    L5:
        r102 = r113.offset;
        goto L7
    }
}
