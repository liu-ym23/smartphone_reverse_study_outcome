package com.bytedance.keva;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class KevaPrivateImpl extends KevaImpl {
    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L11
        Iterator<Map.Entry<String, KevaImpl.KevaValueWrapper>> r100 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L11
        int r101 = 0;
    L5:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().getValue().offset == 0) goto L5;
        r101 = r101 + 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L6
        Map<String, ?> r100 = buildNewMap(new HashMap());     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r100;
    L6:
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
        onRepoAccessLocked();     // Catch: Throwable -> L11
        KevaImpl.KevaValueWrapper r101 = this.mValueMap.get(r100);     // Catch: Throwable -> L11
        if (r101 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r102;
    L6:
        if (r101.offset == 0) goto L8;
        r102 = true;
    L11:
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

    private Object fetchObject(String r100, Object r101) {
        KevaImpl.KevaValueWrapper r102 = this.mValueMap.get(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        if (r102.offset != 0) goto L8;
        return r101;
    L8:
        return r102.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r100, boolean r101) {
        return ((Boolean) fetchObject(r100, Boolean.valueOf(r101))).booleanValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r100, double r101) {
        return ((Double) fetchObject(r100, Double.valueOf(r101))).doubleValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r100, float r101) {
        return ((Float) fetchObject(r100, Float.valueOf(r101))).floatValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r100, int r101) {
        return ((Integer) fetchObject(r100, Integer.valueOf(r101))).intValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r100, long r101) {
        return ((Long) fetchObject(r100, Long.valueOf(r101))).longValue();
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

    public KevaPrivateImpl(String r100, String r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r110, String r111, boolean r112) {
        KevaImpl.KevaValueWrapper r100 = this.mValueMap.get(r110);
        if (r100 != null) goto L5;
    L17:
        return r111;
    L5:
        if (r100.offset == 0) goto L17;
        int r101 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r101;
        r100.accessIndex = r101;
        if (r100.loaded == true) goto L16;
        String r113 = fetchString(this.mHandle, r110, r100.offset, r111);
        if (r112 == true) goto L13;
        if (r113 == r111) goto L14;
        r100.value = r113;
        r100.loaded = true;
    L14:
        return r113;
    L13:
        r100.value = null;
        r100.loaded = false;
        goto L14
    L16:
        return (String) r100.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r110, String[] r111, boolean r112) {
        KevaImpl.KevaValueWrapper r100 = this.mValueMap.get(r110);
        if (r100 != null) goto L5;
    L17:
        return r111;
    L5:
        if (r100.offset == 0) goto L17;
        int r101 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r101;
        r100.accessIndex = r101;
        if (r100.loaded == true) goto L16;
        String[] r113 = fetchStringArray(this.mHandle, r110, r100.offset, r111, 3);
        if (r112 == true) goto L13;
        if (r113 == r111) goto L14;
        r100.value = r113;
        r100.loaded = true;
    L14:
        return r113;
    L13:
        r100.value = null;
        r100.loaded = false;
        goto L14
    L16:
        return (String[]) r100.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r110, byte[] r111, int r112, boolean r113) {
        KevaImpl.KevaValueWrapper r100 = this.mValueMap.get(r110);
        if (r100 != null) goto L5;
    L17:
        return r111;
    L5:
        if (r100.offset == 0) goto L17;
        int r101 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r101;
        r100.accessIndex = r101;
        if (r100.loaded == true) goto L16;
        byte[] r114 = fetchBytes(this.mHandle, r110, r100.offset, r111, r112);
        if (r113 == true) goto L13;
        if (r114 == r111) goto L14;
        r100.value = r114;
        r100.loaded = true;
    L14:
        return r114;
    L13:
        r100.value = null;
        r100.loaded = false;
        goto L14
    L16:
        return (byte[]) r100.value;
    }
}
