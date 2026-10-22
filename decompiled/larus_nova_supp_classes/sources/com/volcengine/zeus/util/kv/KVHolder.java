package com.volcengine.zeus.util.kv;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class KVHolder<T> {
    private final T defaultValue;
    private final String key;
    private final IKVStore store;
    private final Class<T> type;

    /* JADX WARN: Multi-variable type inference failed */
    public T get() {
        Class<T> r0 = this.type;
        if (r0 != Float.class) goto L7;
        return (T) Float.valueOf(this.store.getFloat(this.key, ((Float) this.defaultValue).floatValue()));
    L7:
        if (r0 != Integer.class) goto L11;
        return (T) Integer.valueOf(this.store.getInt(this.key, ((Integer) this.defaultValue).intValue()));
    L11:
        if (r0 != String.class) goto L15;
        return (T) this.store.getString(this.key, (String) this.defaultValue);
    L15:
        if (r0 != Boolean.class) goto L19;
        return (T) Boolean.valueOf(this.store.getBoolean(this.key, ((Boolean) this.defaultValue).booleanValue()));
    L19:
        if (r0 != Long.class) goto L23;
        return (T) Long.valueOf(this.store.getLong(this.key, ((Long) this.defaultValue).longValue()));
    L23:
        if (r0 != Double.class) goto L27;
        return (T) Double.valueOf(this.store.getDouble(this.key, ((Double) this.defaultValue).doubleValue()));
    L27:
        if (r0 != byte[].class) goto L31;
        return (T) this.store.getBytes(this.key, (byte[]) this.defaultValue);
    L31:
        throw new UnsupportedOperationException("不支持的类型: ".concat(this.type.getName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void set(T r5) {
        Class<T> r0 = this.type;
        if (r0 != Float.class) goto L6;
        this.store.storeFloat(this.key, ((Float) r5).floatValue());
        return;
    L6:
        if (r0 != Integer.class) goto L9;
        this.store.storeInt(this.key, ((Integer) r5).intValue());
        return;
    L9:
        if (r0 != String.class) goto L12;
        this.store.storeString(this.key, (String) r5);
        return;
    L12:
        if (r0 != Boolean.class) goto L15;
        this.store.storeBoolean(this.key, ((Boolean) r5).booleanValue());
        return;
    L15:
        if (r0 != Long.class) goto L18;
        this.store.storeLong(this.key, ((Long) r5).longValue());
        return;
    L18:
        if (r0 != Double.class) goto L21;
        this.store.storeDouble(this.key, ((Double) r5).doubleValue());
        return;
    L21:
        if (r0 != byte[].class) goto L25;
        this.store.storeBytes(this.key, (byte[]) r5);
        return;
    L25:
        throw new UnsupportedOperationException("不支持的类型: ".concat(this.type.getName()));
    }

    public static KVHolder<Boolean> ofBoolean(IKVStore r2, String r3, boolean r4) {
        return new KVHolder(r2, r3, Boolean.valueOf(r4), Boolean.class);
    }

    public static KVHolder<byte[]> ofByteArray(IKVStore r2, String r3, byte[] r4) {
        return new KVHolder(r2, r3, r4, byte[].class);
    }

    public static KVHolder<Double> ofDouble(IKVStore r1, String r2, double r3) {
        return new KVHolder(r1, r2, Double.valueOf(r3), Double.class);
    }

    public static KVHolder<Float> ofFloat(IKVStore r2, String r3, float r4) {
        return new KVHolder(r2, r3, Float.valueOf(r4), Float.class);
    }

    public static KVHolder<Integer> ofInt(IKVStore r2, String r3, int r4) {
        return new KVHolder(r2, r3, Integer.valueOf(r4), Integer.class);
    }

    public static KVHolder<Long> ofLong(IKVStore r1, String r2, long r3) {
        return new KVHolder(r1, r2, Long.valueOf(r3), Long.class);
    }

    public static KVHolder<String> ofString(IKVStore r2, String r3, String r4) {
        return new KVHolder(r2, r3, r4, String.class);
    }

    private KVHolder(IKVStore r1, String r2, T r3, Class<T> r4) {
        this.store = r1;
        this.key = r2;
        this.defaultValue = r3;
        this.type = r4;
    }
}
