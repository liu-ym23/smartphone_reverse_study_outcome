package com.volcengine.zeus.util.kv;

import com.bytedance.keva.Keva;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a implements IKVStore {
    public final ConcurrentHashMap<IKVStore.a, Keva.OnChangeListener> a;
    public final Keva b;
    public final Function0<String> c;

    public final String a(String r3) {
        Function0<String> r0 = this.c;
        if (r0 == null) goto L10;
        String r1 = r0.invoke();
        if (r1 == null) goto L11;
        String r2 = r1 + r3;
        if (r2 != null) goto L9;
        return r3;
    L9:
        return r2;
    L11:
        return r3;
    L10:
        return r3;
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void erase(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.b.erase(a(r2));
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void registerChangeListener(IKVStore.a r3) {
        Intrinsics.checkNotNullParameter(null, "listener");
        Keva.OnChangeListener r4 = new a(this);
        if (this.a.putIfAbsent(null, r4) == null) goto L5;
        return;
    L5:
        this.b.registerChangeListener(r4);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void unRegisterChangeListener(IKVStore.a r2) {
        Intrinsics.checkNotNullParameter(null, "listener");
        Keva.OnChangeListener r3 = this.a.remove(null);
        if (r3 == null) goto L6;
        this.b.unRegisterChangeListener(r3);
        return;
    }

    public a(Keva r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "keva");
        this.b = r2;
        this.c = r3;
        this.a = new ConcurrentHashMap();
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final boolean getBoolean(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.b.getBoolean(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final byte[] getBytes(String r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defValue");
        return this.b.getBytes(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final double getDouble(String r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.b.getDouble(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final float getFloat(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.b.getFloat(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final int getInt(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.b.getInt(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final long getLong(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.b.getLong(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final String getString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.b.getString(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final String[] getStringArray(String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defValue");
        return this.b.getStringArray(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final Set<String> getStringSet(String r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defValues");
        return this.b.getStringSet(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeBoolean(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.b.storeBoolean(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeBytes(String r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.b.storeBytes(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeDouble(String r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.b.storeDouble(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeFloat(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.b.storeFloat(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeInt(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.b.storeInt(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeLong(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.b.storeLong(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.b.storeString(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeStringArray(String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.b.storeStringArray(a(r2), r3);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeStringSet(String r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "values");
        this.b.storeStringSet(a(r2), r3);
    }
}
