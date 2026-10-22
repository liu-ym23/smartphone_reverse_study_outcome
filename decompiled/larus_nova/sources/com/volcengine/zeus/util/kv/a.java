package com.volcengine.zeus.util.kv;

import com.bytedance.keva.Keva;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class a implements IKVStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<IKVStore.a, Keva.OnChangeListener> f462923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Keva f462924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f462925c;

    /* JADX INFO: renamed from: com.volcengine.zeus.util.kv.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static final class C5558a implements Keva.OnChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f462926a;

        public C5558a(a r100) {
            this.f462926a = r100;
        }

        @Override // com.bytedance.keva.Keva.OnChangeListener
        public final void onChanged(Keva r100, String r101) {
            if ((!Intrinsics.areEqual(r100, this.f462926a.f462924b)) == false) goto L5;
            return;
        L5:
            Function0<String> r102 = this.f462926a.f462925c;
            if (r102 == null) goto L10;
            String r103 = r102.invoke();
            if (r103 == null) goto L10;
        L11:
            if (r101 != null) goto L13;
            return;
        L13:
            if (StringsKt.startsWith$default(r101, r103, false, 2, null) == false) goto L18;
            StringsKt.removePrefix(r101, r103);
            throw null;
        L18:
            return;
        L10:
            r103 = "";
            goto L11
        }
    }

    public final String a(String r100) {
        Function0<String> r101 = this.f462925c;
        if (r101 == null) goto L10;
        String r102 = r101.invoke();
        if (r102 == null) goto L11;
        String r103 = r102 + r100;
        if (r103 != null) goto L9;
        return r100;
    L9:
        return r103;
    L11:
        return r100;
    L10:
        return r100;
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void erase(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f462924b.erase(a(r100));
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void registerChangeListener(IKVStore.a r100) {
        Intrinsics.checkNotNullParameter(null, "listener");
        C5558a r101 = new C5558a(this);
        if (this.f462923a.putIfAbsent(null, r101) == null) goto L5;
        return;
    L5:
        this.f462924b.registerChangeListener(r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void unRegisterChangeListener(IKVStore.a r100) {
        Intrinsics.checkNotNullParameter(null, "listener");
        Keva.OnChangeListener r101 = this.f462923a.remove(null);
        if (r101 == null) goto L6;
        this.f462924b.unRegisterChangeListener(r101);
        return;
    }

    public a(Keva r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "keva");
        this.f462924b = r100;
        this.f462925c = r101;
        this.f462923a = new ConcurrentHashMap();
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f462924b.getBoolean(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final byte[] getBytes(String r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        return this.f462924b.getBytes(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final double getDouble(String r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f462924b.getDouble(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final float getFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f462924b.getFloat(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f462924b.getInt(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f462924b.getLong(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f462924b.getString(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final String[] getStringArray(String r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        return this.f462924b.getStringArray(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValues");
        return this.f462924b.getStringSet(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f462924b.storeBoolean(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeBytes(String r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f462924b.storeBytes(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeDouble(String r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f462924b.storeDouble(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeFloat(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f462924b.storeFloat(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f462924b.storeInt(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f462924b.storeLong(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f462924b.storeString(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeStringArray(String r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f462924b.storeStringArray(a(r100), r101);
    }

    @Override // com.volcengine.zeus.util.kv.IKVStore
    public final void storeStringSet(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "values");
        this.f462924b.storeStringSet(a(r100), r101);
    }
}
