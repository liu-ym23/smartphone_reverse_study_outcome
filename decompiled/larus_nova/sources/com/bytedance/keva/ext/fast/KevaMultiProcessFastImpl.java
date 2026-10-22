package com.bytedance.keva.ext.fast;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.keva.Keva;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
class KevaMultiProcessFastImpl extends Keva {
    private static final Object LOCK = null;
    private static final int MAX_RETRY_TIMES = 6;
    private static volatile KevaMultiProcessFastAIDL sAIDL;
    private final List<Keva.OnChangeListener> mChangeListeners;
    private final boolean sFromSp;
    private final String sRepoName;
    private final boolean sSync;

    @Override // com.bytedance.keva.Keva
    public void clear() {
        clearSafely(1);
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        return countSafely(1);
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        dumpSafely(1);
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        return getAllSafely(1);
    }

    static {
        LOCK = new Object();
    }

    private static KevaMultiProcessFastAIDL checkAIDL() {
        Object r100 = LOCK;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAIDL == null) goto L14;
    L7:
        KevaMultiProcessFastAIDL r101 = sAIDL;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L14:
        Bundle r102 = com_bytedance_keva_ext_fast_KevaMultiProcessFastImpl_android_content_ContentResolver_query(KevaMultiProcessFast.getContext().getContentResolver(), KevaMultiProcessFast.CALL_URI, null, null, null, null).getExtras();     // Catch: Exception -> L13 Throwable -> L10
        r102.setClassLoader(StubParcelable.class.getClassLoader());     // Catch: Exception -> L13 Throwable -> L10
        sAIDL = KevaMultiProcessFastAIDL.Stub.asInterface(((StubParcelable) r102.getParcelable(KevaMultiProcessFastConstant.KEY_BINDER)).binder);     // Catch: Exception -> L13 Throwable -> L10
        goto L7
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.sRepoName;
    }

    private void clearSafely(int r100) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        r101.clear(this.sRepoName, this.sFromSp, this.sSync);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r100 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<clearSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r101);
        clearSafely(r100 + 1);
    }

    private int countSafely(int r100) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        return r101.count(this.sRepoName, this.sFromSp, this.sSync);
    L5:
        e = move-exception;
        if (r100 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<countSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return 0;
    L10:
        resetAIDL(r101);
        return countSafely(r100 + 1);
    }

    private void dumpSafely(int r100) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        r101.dump(this.sRepoName, this.sFromSp, this.sSync);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r100 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<dumpSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r101);
        dumpSafely(r100 + 1);
    }

    private Map<String, ?> getAllSafely(int r110) {
        KevaMultiProcessFastAIDL r100 = checkAIDL();
        ValueWrapper[] r101 = r100.getAll(this.sRepoName, this.sFromSp, this.sSync);     // Catch: Exception -> L28
        if (r101 != null) goto L6;
    L27:
        return null;
    L6:
        if (r101.length <= 0) goto L27;
        HashMap r102 = new HashMap();     // Catch: Exception -> L28
        int r103 = r101.length;     // Catch: Exception -> L28
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L26;
        ValueWrapper r105 = r101[r104];     // Catch: Exception -> L28
        int r106 = r105.valueType;     // Catch: Exception -> L28
        if (r106 == 55) goto L24;
        switch(r106) {
            case 1: goto L23;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L25;
        };     // Catch: Exception -> L28
    L13:
        r102.put(r105.key, r105.bArrayValue);     // Catch: Exception -> L28
        goto L25
    L14:
        r102.put(r105.key, r105.sValue);     // Catch: Exception -> L28
        goto L25
    L15:
        r102.put(r105.key, Double.valueOf(r105.numValue));     // Catch: Exception -> L28
        goto L25
    L16:
        r102.put(r105.key, Float.valueOf((float) r105.numValue));     // Catch: Exception -> L28
        goto L25
    L17:
        r102.put(r105.key, Long.valueOf((long) r105.numValue));     // Catch: Exception -> L28
        goto L25
    L18:
        String r107 = r105.key;     // Catch: Exception -> L28
        if (r105.numValue != 1.0d) goto L21;
        boolean r108 = true;
    L22:
        r102.put(r107, Boolean.valueOf(r108));     // Catch: Exception -> L28
        goto L25
    L21:
        r108 = false;
        goto L22
    L23:
        r102.put(r105.key, Integer.valueOf((int) r105.numValue));     // Catch: Exception -> L28
    L25:
        r104 = r104 + 1;
        goto L8
    L24:
        r102.put(r105.key, r105.sArrayValue);     // Catch: Exception -> L28
        goto L25
    L26:
        return r102;
    L28:
        e = move-exception;
        if (r110 < 6) goto L33;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getAllSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return null;
    L33:
        resetAIDL(r100);
        return getAllSafely(r110 + 1);
    }

    private void notifyDataChange(String r100) {
        if (this.mChangeListeners.isEmpty() == false) goto L5;
        return;
    L5:
        List<Keva.OnChangeListener> r101 = this.mChangeListeners;
        monitor-enter(r101);
        Iterator<Keva.OnChangeListener> r102 = this.mChangeListeners.iterator();     // Catch: Throwable -> L13
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().onChanged(this, r100);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private static void resetAIDL(KevaMultiProcessFastAIDL r100) {
        Object r101 = LOCK;
        monitor-enter(r101);
        sAIDL = null;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r100) {
        return buildNewMapSafely(r100, 1);
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r100) {
        return containsSafely(r100, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r100) {
        eraseSafely(r100, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r100) {
        List<Keva.OnChangeListener> r101 = this.mChangeListeners;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mChangeListeners.contains(r100) == true) goto L7;
        this.mChangeListeners.add(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r100) {
        List<Keva.OnChangeListener> r101 = this.mChangeListeners;
        monitor-enter(r101);
        this.mChangeListeners.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Map<String, Object> buildNewMapSafely(Map<String, Object> r110, int r111) {
        KevaMultiProcessFastAIDL r100 = checkAIDL();
        ValueWrapper[] r101 = r100.buildNewMap(this.sRepoName, this.sFromSp, this.sSync);     // Catch: Exception -> L32
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.length <= 0) goto L47;
        int r102 = r101.length;     // Catch: Exception -> L32
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L29;
        ValueWrapper r104 = r101[r103];     // Catch: Exception -> L32
        int r105 = r104.valueType;     // Catch: Exception -> L32
        if (r105 != 2) goto L12;
        String r106 = r104.key;     // Catch: Exception -> L32
        if (r104.numValue != 1.0d) goto L26;
        boolean r107 = true;
    L27:
        r110.put(r106, Boolean.valueOf(r107));     // Catch: Exception -> L32
    L28:
        r103 = r103 + 1;
        goto L8
    L26:
        r107 = false;
        goto L27
    L12:
        if (r105 != 55) goto L14;
        r110.put(r104.key, r104.sArrayValue);     // Catch: Exception -> L32
        goto L28
    L14:
        if (r105 == 5) goto L21;
        if (r105 != 6) goto L17;
        r110.put(r104.key, r104.sValue);     // Catch: Exception -> L32
        goto L28
    L17:
        if (r105 != 7) goto L28;
        r110.put(r104.key, r104.bArrayValue);     // Catch: Exception -> L32
        goto L28
    L21:
        r110.put(r104.key, Double.valueOf(r104.numValue));     // Catch: Exception -> L32
        goto L28
    L29:
        return r110;
    L47:
        return null;
    L32:
        e = move-exception;
        if (r111 < 6) goto L36;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<buildNewMapSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r110;
    L36:
        resetAIDL(r100);
        return buildNewMapSafely(r110, r111 + 1);
    }

    private boolean containsSafely(String r100, int r101) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.contains(this.sRepoName, this.sFromSp, this.sSync, r100);
    L5:
        e = move-exception;
        if (r101 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<containsSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return false;
    L10:
        resetAIDL(r102);
        return containsSafely(r100, r101 + 1);
    }

    private void eraseSafely(String r100, int r101) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.erase(this.sRepoName, this.sFromSp, this.sSync, r100);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r101 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<eraseSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        eraseSafely(r100, r101 + 1);
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r100, boolean r101) {
        return getBooleanSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r100, byte[] r101) {
        return getBytesSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r100, byte[] r101) {
        return getBytesJustDiskSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r100, double r101) {
        return getDoubleSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r100, float r101) {
        return getFloatSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r100, int r101) {
        return getIntSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r100, long r101) {
        return getLongSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r100, String r101) {
        return getStringSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r100, String[] r101) {
        return getStringArraySafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r100, String[] r101) {
        return getStringArrayJustDiskSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r100, String r101) {
        return getStringJustDiskSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r100, Set<String> r101) {
        return getStringSetSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r100, Set<String> r101) {
        return getStringSetJustDiskSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r100, boolean r101) {
        storeBooleanSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r100, byte[] r101) {
        storeBytesSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r100, byte[] r101) {
        storeBytesJustDiskSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r100, double r101) {
        storeDoubleSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r100, float r101) {
        storeFloatSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r100, int r101) {
        storeIntSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r100, long r101) {
        storeLongSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r100, String r101) {
        storeStringSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r100, String[] r101) {
        storeStringArraySafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r100, String[] r101) {
        storeStringArrayJustDiskSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r100, String r101) {
        storeStringJustDiskSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r100, Set<String> r101) {
        storeStringSetSafely(r100, r101, 1);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r100, Set<String> r101) {
        storeStringSetJustDiskSafely(r100, r101, 1);
    }

    public KevaMultiProcessFastImpl(String r100, boolean r101, boolean r102) {
        this.mChangeListeners = new ArrayList();
        this.sRepoName = r100;
        this.sFromSp = r101;
        this.sSync = r102;
        init(r100, r101, r102);
        String.format("<KevaMultiProcessFastImpl>初始化 fromSp=%s sync=%s repoName=%s", new Object[]{Boolean.valueOf(r101), Boolean.valueOf(r102), r100});
    }

    private boolean getBooleanSafely(String r100, boolean r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getBoolean(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getBooleanSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getBooleanSafely(r100, r101, r110 + 1);
    }

    private byte[] getBytesJustDiskSafely(String r100, byte[] r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getBytesJustDisk(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getBytesJustDiskSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getBytesJustDiskSafely(r100, r101, r110 + 1);
    }

    private byte[] getBytesSafely(String r100, byte[] r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getBytes(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getBytesSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getBytesSafely(r100, r101, r110 + 1);
    }

    private double getDoubleSafely(String r100, double r110, int r111) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        return r101.getDouble(this.sRepoName, this.sFromSp, this.sSync, r100, r110);
    L5:
        e = move-exception;
        if (r111 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getDoubleSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r110;
    L10:
        resetAIDL(r101);
        return getDoubleSafely(r100, r110, r111 + 1);
    }

    private float getFloatSafely(String r100, float r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getFloat(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getFloatSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getFloatSafely(r100, r101, r110 + 1);
    }

    private int getIntSafely(String r100, int r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getInt(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getIntSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getIntSafely(r100, r101, r110 + 1);
    }

    private long getLongSafely(String r100, long r110, int r111) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        return r101.getLong(this.sRepoName, this.sFromSp, this.sSync, r100, r110);
    L5:
        e = move-exception;
        if (r111 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getLongSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r110;
    L10:
        resetAIDL(r101);
        return getLongSafely(r100, r110, r111 + 1);
    }

    private String[] getStringArrayJustDiskSafely(String r100, String[] r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getStringArrayJustDisk(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getStringArrayJustDiskSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getStringArrayJustDiskSafely(r100, r101, r110 + 1);
    }

    private String[] getStringArraySafely(String r100, String[] r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getStringArray(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getStringArraySafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getStringArraySafely(r100, r101, r110 + 1);
    }

    private String getStringJustDiskSafely(String r100, String r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getStringJustDisk(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getStringJustDiskSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getStringJustDiskSafely(r100, r101, r110 + 1);
    }

    private String getStringSafely(String r100, String r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        return r102.getString(this.sRepoName, this.sFromSp, this.sSync, r100, r101);
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getStringSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r101;
    L10:
        resetAIDL(r102);
        return getStringSafely(r100, r101, r110 + 1);
    }

    private Set<String> getStringSetJustDiskSafely(String r100, Set<String> r110, int r111) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        return new HashSet(r101.getStringSetJustDisk(this.sRepoName, this.sFromSp, this.sSync, r100, new ArrayList(r110)));
    L5:
        e = move-exception;
        if (r111 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getStringSetJustDiskSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r110;
    L10:
        resetAIDL(r101);
        return getStringSetJustDiskSafely(r100, r110, r111 + 1);
    }

    private Set<String> getStringSetSafely(String r100, Set<String> r110, int r111) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        return new HashSet(r101.getStringSet(this.sRepoName, this.sFromSp, this.sSync, r100, new ArrayList(r110)));
    L5:
        e = move-exception;
        if (r111 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<getStringSetSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return r110;
    L10:
        resetAIDL(r101);
        return getStringSetSafely(r100, r110, r111 + 1);
    }

    private void init(String r100, boolean r101, boolean r102) {
        initSafely(r100, r101, r102, 1);
    }

    private void storeBooleanSafely(String r100, boolean r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeBoolean(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeBooleanSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeBooleanSafely(r100, r101, r110 + 1);
    }

    private void storeBytesJustDiskSafely(String r100, byte[] r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeBytesJustDisk(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeBytesJustDiskSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeBytesJustDiskSafely(r100, r101, r110 + 1);
    }

    private void storeBytesSafely(String r100, byte[] r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeBytes(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeBytesSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeBytesSafely(r100, r101, r110 + 1);
    }

    private void storeDoubleSafely(String r100, double r110, int r111) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        r101.storeDouble(this.sRepoName, this.sFromSp, this.sSync, r100, r110);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r111 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeDoubleSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r101);
        storeDoubleSafely(r100, r110, r111 + 1);
    }

    private void storeFloatSafely(String r100, float r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeFloat(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeFloatSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeFloatSafely(r100, r101, r110 + 1);
    }

    private void storeIntSafely(String r100, int r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeInt(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeIntSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeIntSafely(r100, r101, r110 + 1);
    }

    private void storeLongSafely(String r100, long r110, int r111) {
        KevaMultiProcessFastAIDL r101 = checkAIDL();
        r101.storeLong(this.sRepoName, this.sFromSp, this.sSync, r100, r110);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r111 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeLongSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r101);
        storeLongSafely(r100, r110, r111 + 1);
    }

    private void storeStringArrayJustDiskSafely(String r100, String[] r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeStringArrayJustDisk(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeStringArrayJustDiskSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeStringArrayJustDiskSafely(r100, r101, r110 + 1);
    }

    private void storeStringArraySafely(String r100, String[] r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeStringArray(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeStringArraySafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeStringArraySafely(r100, r101, r110 + 1);
    }

    private void storeStringJustDiskSafely(String r100, String r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeStringJustDisk(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeStringJustDiskSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeStringJustDiskSafely(r100, r101, r110 + 1);
    }

    private void storeStringSafely(String r100, String r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeString(this.sRepoName, this.sFromSp, this.sSync, r100, r101);     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeStringSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeStringSafely(r100, r101, r110 + 1);
    }

    private void storeStringSetJustDiskSafely(String r100, Set<String> r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeStringSetJustDisk(this.sRepoName, this.sFromSp, this.sSync, r100, new ArrayList(r101));     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeStringSetJustDiskSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeStringSetJustDiskSafely(r100, r101, r110 + 1);
    }

    private void storeStringSetSafely(String r100, Set<String> r101, int r110) {
        KevaMultiProcessFastAIDL r102 = checkAIDL();
        r102.storeStringSet(this.sRepoName, this.sFromSp, this.sSync, r100, new ArrayList(r101));     // Catch: Exception -> L5
        notifyDataChange(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r110 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<storeStringSetSafely>重试次数超限%s", new Object[]{this.sRepoName}), e);
        return;
    L10:
        resetAIDL(r102);
        storeStringSetSafely(r100, r101, r110 + 1);
    }

    private void initSafely(String r100, boolean r101, boolean r102, int r103) {
        KevaMultiProcessFastAIDL r104 = checkAIDL();
        r104.init(r100, r101, r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r103 < 6) goto L10;
        KevaMultiProcessFast.getMonitor().monitor(KevaMultiProcessFastConstant.TAG, String.format("<initSafely>重试次数超限%s", new Object[]{r100}), e);
        return;
    L10:
        resetAIDL(r104);
        initSafely(r100, r101, r102, r103 + 1);
    }

    private static Cursor com_bytedance_keva_ext_fast_KevaMultiProcessFastImpl_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
