package com.bytedance.keva;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class KevaPrivateImpl extends KevaImpl {
    @Override // com.bytedance.keva.Keva
    public int count() {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L11
        Iterator<Map.Entry<String, KevaImpl.KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L11
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().getValue().offset == 0) goto L5;
        r1 = r1 + 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L6
        Map<String, ?> r0 = buildNewMap(new HashMap());     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
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
    public /* bridge */ /* synthetic */ Map buildNewMap(Map r1) {
        return super.buildNewMap(r1);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva.ClearMemory
    public /* bridge */ /* synthetic */ void clearMemory(int r1) {
        super.clearMemory(r1);
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r5) {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L11
        KevaImpl.KevaValueWrapper r6 = this.mValueMap.get(r5);     // Catch: Throwable -> L11
        if (r6 != null) goto L6;
    L8:
        boolean r7 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r7;
    L6:
        if (r6.offset == 0) goto L8;
        r7 = true;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void erase(String r1) {
        super.erase(r1);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void registerChangeListener(Keva.OnChangeListener r1) {
        super.registerChangeListener(r1);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void unRegisterChangeListener(Keva.OnChangeListener r1) {
        super.unRegisterChangeListener(r1);
    }

    private Object fetchObject(String r6, Object r7) {
        KevaImpl.KevaValueWrapper r8 = this.mValueMap.get(r6);
        if (r8 != null) goto L5;
        return r7;
    L5:
        if (r8.offset != 0) goto L8;
        return r7;
    L8:
        return r8.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public boolean fetchBoolean(String r1, boolean r2) {
        return ((Boolean) fetchObject(r1, Boolean.valueOf(r2))).booleanValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public double fetchDouble(String r1, double r2) {
        return ((Double) fetchObject(r1, Double.valueOf(r2))).doubleValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public float fetchFloat(String r1, float r2) {
        return ((Float) fetchObject(r1, Float.valueOf(r2))).floatValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public int fetchInt(String r1, int r2) {
        return ((Integer) fetchObject(r1, Integer.valueOf(r2))).intValue();
    }

    @Override // com.bytedance.keva.KevaImpl
    public long fetchLong(String r1, long r2) {
        return ((Long) fetchObject(r1, Long.valueOf(r2))).longValue();
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ boolean getBoolean(String r1, boolean r2) {
        return super.getBoolean(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytes(String r1, byte[] r2) {
        return super.getBytes(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ byte[] getBytesJustDisk(String r1, byte[] r2) {
        return super.getBytesJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ double getDouble(String r1, double r2) {
        return super.getDouble(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ float getFloat(String r1, float r2) {
        return super.getFloat(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ int getInt(String r1, int r2) {
        return super.getInt(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ long getLong(String r1, long r2) {
        return super.getLong(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getString(String r1, String r2) {
        return super.getString(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArray(String r1, String[] r2) {
        return super.getStringArray(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String[] getStringArrayJustDisk(String r1, String[] r2) {
        return super.getStringArrayJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ String getStringJustDisk(String r1, String r2) {
        return super.getStringJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSet(String r1, Set r2) {
        return super.getStringSet(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ Set getStringSetJustDisk(String r1, Set r2) {
        return super.getStringSetJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBoolean(String r1, boolean r2) {
        super.storeBoolean(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytes(String r1, byte[] r2) {
        super.storeBytes(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeBytesJustDisk(String r1, byte[] r2) {
        super.storeBytesJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeDouble(String r1, double r2) {
        super.storeDouble(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeFloat(String r1, float r2) {
        super.storeFloat(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeInt(String r1, int r2) {
        super.storeInt(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeLong(String r1, long r2) {
        super.storeLong(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeString(String r1, String r2) {
        super.storeString(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArray(String r1, String[] r2) {
        super.storeStringArray(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringArrayJustDisk(String r1, String[] r2) {
        super.storeStringArrayJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringJustDisk(String r1, String r2) {
        super.storeStringJustDisk(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSet(String r1, Set r2) {
        super.storeStringSet(r1, r2);
    }

    @Override // com.bytedance.keva.KevaImpl, com.bytedance.keva.Keva
    public /* bridge */ /* synthetic */ void storeStringSetJustDisk(String r1, Set r2) {
        super.storeStringSetJustDisk(r1, r2);
    }

    public KevaPrivateImpl(String r1, String r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.bytedance.keva.KevaImpl
    public String fetchString(String r11, String r12, boolean r13) {
        KevaImpl.KevaValueWrapper r0 = this.mValueMap.get(r11);
        if (r0 != null) goto L5;
    L17:
        return r12;
    L5:
        if (r0.offset == 0) goto L17;
        int r1 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r1;
        r0.accessIndex = r1;
        if (r0.loaded == true) goto L16;
        String r14 = fetchString(this.mHandle, r11, r0.offset, r12);
        if (r13 == true) goto L13;
        if (r14 == r12) goto L14;
        r0.value = r14;
        r0.loaded = true;
    L14:
        return r14;
    L13:
        r0.value = null;
        r0.loaded = false;
        goto L14
    L16:
        return (String) r0.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public String[] fetchStringArray(String r12, String[] r13, boolean r14) {
        KevaImpl.KevaValueWrapper r0 = this.mValueMap.get(r12);
        if (r0 != null) goto L5;
    L17:
        return r13;
    L5:
        if (r0.offset == 0) goto L17;
        int r1 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r1;
        r0.accessIndex = r1;
        if (r0.loaded == true) goto L16;
        String[] r15 = fetchStringArray(this.mHandle, r12, r0.offset, r13, 3);
        if (r14 == true) goto L13;
        if (r15 == r13) goto L14;
        r0.value = r15;
        r0.loaded = true;
    L14:
        return r15;
    L13:
        r0.value = null;
        r0.loaded = false;
        goto L14
    L16:
        return (String[]) r0.value;
    }

    @Override // com.bytedance.keva.KevaImpl
    public byte[] fetchBytes(String r12, byte[] r13, int r14, boolean r15) {
        KevaImpl.KevaValueWrapper r0 = this.mValueMap.get(r12);
        if (r0 != null) goto L5;
    L17:
        return r13;
    L5:
        if (r0.offset == 0) goto L17;
        int r1 = this.mBigValueAccessIndex + 1;
        this.mBigValueAccessIndex = r1;
        r0.accessIndex = r1;
        if (r0.loaded == true) goto L16;
        byte[] r16 = fetchBytes(this.mHandle, r12, r0.offset, r13, r14);
        if (r15 == true) goto L13;
        if (r16 == r13) goto L14;
        r0.value = r16;
        r0.loaded = true;
    L14:
        return r16;
    L13:
        r0.value = null;
        r0.loaded = false;
        goto L14
    L16:
        return (byte[]) r0.value;
    }
}
