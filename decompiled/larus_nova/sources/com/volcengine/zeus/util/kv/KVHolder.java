package com.volcengine.zeus.util.kv;

/* JADX INFO: loaded from: classes.dex */
public class KVHolder<T> {
    private final T defaultValue;
    private final String key;
    private final IKVStore store;
    private final Class<T> type;

    /* JADX WARN: Multi-variable type inference failed */
    public T get() {
        Class<T> r100 = this.type;
        if (r100 != Float.class) goto L7;
        return (T) Float.valueOf(this.store.getFloat(this.key, ((Float) this.defaultValue).floatValue()));
    L7:
        if (r100 != Integer.class) goto L11;
        return (T) Integer.valueOf(this.store.getInt(this.key, ((Integer) this.defaultValue).intValue()));
    L11:
        if (r100 != String.class) goto L15;
        return (T) this.store.getString(this.key, (String) this.defaultValue);
    L15:
        if (r100 != Boolean.class) goto L19;
        return (T) Boolean.valueOf(this.store.getBoolean(this.key, ((Boolean) this.defaultValue).booleanValue()));
    L19:
        if (r100 != Long.class) goto L23;
        return (T) Long.valueOf(this.store.getLong(this.key, ((Long) this.defaultValue).longValue()));
    L23:
        if (r100 != Double.class) goto L27;
        return (T) Double.valueOf(this.store.getDouble(this.key, ((Double) this.defaultValue).doubleValue()));
    L27:
        if (r100 != byte[].class) goto L31;
        return (T) this.store.getBytes(this.key, (byte[]) this.defaultValue);
    L31:
        throw new UnsupportedOperationException("不支持的类型: ".concat(this.type.getName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void set(T r100) {
        Class<T> r101 = this.type;
        if (r101 != Float.class) goto L6;
        this.store.storeFloat(this.key, ((Float) r100).floatValue());
        return;
    L6:
        if (r101 != Integer.class) goto L9;
        this.store.storeInt(this.key, ((Integer) r100).intValue());
        return;
    L9:
        if (r101 != String.class) goto L12;
        this.store.storeString(this.key, (String) r100);
        return;
    L12:
        if (r101 != Boolean.class) goto L15;
        this.store.storeBoolean(this.key, ((Boolean) r100).booleanValue());
        return;
    L15:
        if (r101 != Long.class) goto L18;
        this.store.storeLong(this.key, ((Long) r100).longValue());
        return;
    L18:
        if (r101 != Double.class) goto L21;
        this.store.storeDouble(this.key, ((Double) r100).doubleValue());
        return;
    L21:
        if (r101 != byte[].class) goto L25;
        this.store.storeBytes(this.key, (byte[]) r100);
        return;
    L25:
        throw new UnsupportedOperationException("不支持的类型: ".concat(this.type.getName()));
    }

    public static KVHolder<Boolean> ofBoolean(IKVStore r100, String r101, boolean r102) {
        return new KVHolder(r100, r101, Boolean.valueOf(r102), Boolean.class);
    }

    public static KVHolder<byte[]> ofByteArray(IKVStore r100, String r101, byte[] r102) {
        return new KVHolder(r100, r101, r102, byte[].class);
    }

    public static KVHolder<Double> ofDouble(IKVStore r100, String r101, double r102) {
        return new KVHolder(r100, r101, Double.valueOf(r102), Double.class);
    }

    public static KVHolder<Float> ofFloat(IKVStore r100, String r101, float r102) {
        return new KVHolder(r100, r101, Float.valueOf(r102), Float.class);
    }

    public static KVHolder<Integer> ofInt(IKVStore r100, String r101, int r102) {
        return new KVHolder(r100, r101, Integer.valueOf(r102), Integer.class);
    }

    public static KVHolder<Long> ofLong(IKVStore r100, String r101, long r102) {
        return new KVHolder(r100, r101, Long.valueOf(r102), Long.class);
    }

    public static KVHolder<String> ofString(IKVStore r100, String r101, String r102) {
        return new KVHolder(r100, r101, r102, String.class);
    }

    private KVHolder(IKVStore r100, String r101, T r102, Class<T> r103) {
        this.store = r100;
        this.key = r101;
        this.defaultValue = r102;
        this.type = r103;
    }
}
