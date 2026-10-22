package com.bytedance.keva.ext;

import com.bytedance.keva.Keva;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public class KevaMultiProcessCache extends Keva {
    private static final ConcurrentHashMap<String, Keva> sInstanceMap = null;
    private final CombinedMap<String, Object> mCombinedCache;
    private final Keva mInstance;

    /* JADX INFO: renamed from: com.bytedance.keva.ext.KevaMultiProcessCache$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CombinedMap<K, V> extends AbstractMap<K, V> {
        private final Map<K, V> mCache;
        private final Map<K, V> mNullValuesCache;

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.mCache.clear();
            this.mNullValuesCache.clear();
        }

        private CombinedMap() {
            this.mCache = new ConcurrentHashMap();
            this.mNullValuesCache = new ConcurrentHashMap();
        }

        public /* synthetic */ CombinedMap(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r100) {
            if (this.mCache.containsKey(r100) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mNullValuesCache.containsKey(r100) == true) goto L8;
            return false;
        }

        public V getNotNull(Object r100) {
            return this.mCache.get(r100);
        }

        public boolean isNullValue(V r100) {
            return this.mNullValuesCache.containsKey(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r100) {
            if (this.mCache.containsKey(r100) == false) goto L7;
            return this.mCache.remove(r100);
        L7:
            return this.mNullValuesCache.remove(r100);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r100, V r101) {
            if (r101 == null) goto L5;
            return this.mCache.put(r100, r101);
        L5:
            return this.mNullValuesCache.put(r100, r101);
        }
    }

    static {
        sInstanceMap = new ConcurrentHashMap();
    }

    @Override // com.bytedance.keva.Keva
    public void clear() {
        this.mInstance.clear();
        this.mCombinedCache.clear();
    }

    @Override // com.bytedance.keva.Keva
    public int count() {
        return this.mInstance.count();
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        this.mInstance.dump();
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, ?> getAll() {
        return this.mInstance.getAll();
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mInstance.name();
    }

    private KevaMultiProcessCache(String r100) {
        CombinedMap<String, Object> r101 = new CombinedMap(null);
        this.mCombinedCache = r101;
        Keva r102 = initInstance(r100);
        this.mInstance = r102;
        r102.buildNewMap(r101);
    }

    public static Keva getRepoSync(String r100) {
        ConcurrentHashMap<String, Keva> r101 = sInstanceMap;
        Keva r102 = r101.get(r100);
        if (r102 != null) goto L6;
        KevaMultiProcessCache r103 = new KevaMultiProcessCache(r100);
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }

    private static Keva initInstance(String r100) {
        return Keva.getRepoSync(r100, 1);
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r100) {
        return this.mInstance.buildNewMap(r100);
    }

    @Override // com.bytedance.keva.Keva
    public boolean contains(String r100) {
        return this.mCombinedCache.containsKey(r100);
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r100) {
        this.mInstance.erase(r100);
        this.mCombinedCache.remove(r100);
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r100) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r100) {
        throw new UnsupportedOperationException();
    }

    private Object getBasicTypeValue(String r100, Object r101) {
        Object r102 = this.mCombinedCache.getNotNull(r100);
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102;
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r100, boolean r101) {
        return ((Boolean) getBasicTypeValue(r100, Boolean.valueOf(r101))).booleanValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r101;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r100, byte[] r101) {
        if (this.mCombinedCache.isNullValue(r100) == false) goto L6;
        return null;
    L6:
        Object r102 = this.mCombinedCache.getNotNull(r100);
        if ((r102 instanceof byte[]) == true) goto L9;
        return r101;
    L9:
        return (byte[]) r102;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r100, byte[] r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r100, double r101) {
        return ((Double) getBasicTypeValue(r100, Double.valueOf(r101))).doubleValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r101;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r100, float r101) {
        return ((Float) getBasicTypeValue(r100, Float.valueOf(r101))).floatValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r101;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r100, int r101) {
        return ((Integer) getBasicTypeValue(r100, Integer.valueOf(r101))).intValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r101;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r100, long r101) {
        return ((Long) getBasicTypeValue(r100, Long.valueOf(r101))).longValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r101;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r100, String r101) {
        if (this.mCombinedCache.isNullValue(r100) == false) goto L6;
        return null;
    L6:
        Object r102 = this.mCombinedCache.getNotNull(r100);
        if ((r102 instanceof String) == true) goto L9;
        return r101;
    L9:
        return (String) r102;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r100, String[] r101) {
        if (this.mCombinedCache.isNullValue(r100) == false) goto L6;
        return null;
    L6:
        Object r102 = this.mCombinedCache.getNotNull(r100);
        if ((r102 instanceof String[]) == true) goto L9;
        return r101;
    L9:
        return (String[]) r102;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r100, String[] r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r100, String r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r100, Set<String> r101) {
        if (this.mCombinedCache.isNullValue(r100) == false) goto L6;
        return null;
    L6:
        Object r102 = this.mCombinedCache.getNotNull(r100);
        if ((r102 instanceof Set) == true) goto L9;
        return r101;
    L9:
        return (Set) r102;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r100, Set<String> r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r100, boolean r101) {
        this.mCombinedCache.put(r100, Boolean.valueOf(r101));
        this.mInstance.storeBoolean(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r100, byte[] r101) {
        this.mCombinedCache.put(r100, r101);
        this.mInstance.storeBytes(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r100, byte[] r101) {
        this.mInstance.storeBytesJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r100, double r101) {
        this.mCombinedCache.put(r100, Double.valueOf(r101));
        this.mInstance.storeDouble(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r100, float r101) {
        this.mCombinedCache.put(r100, Float.valueOf(r101));
        this.mInstance.storeFloat(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r100, int r101) {
        this.mCombinedCache.put(r100, Integer.valueOf(r101));
        this.mInstance.storeInt(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r100, long r101) {
        this.mCombinedCache.put(r100, Long.valueOf(r101));
        this.mInstance.storeLong(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r100, String r101) {
        this.mCombinedCache.put(r100, r101);
        this.mInstance.storeString(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r100, String[] r101) {
        this.mCombinedCache.put(r100, r101);
        this.mInstance.storeStringArray(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r100, String[] r101) {
        this.mInstance.storeStringArrayJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r100, String r101) {
        this.mInstance.storeStringJustDisk(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r100, Set<String> r101) {
        this.mCombinedCache.put(r100, r101);
        this.mInstance.storeStringSet(r100, r101);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r100, Set<String> r101) {
        this.mInstance.storeStringSetJustDisk(r100, r101);
    }
}
