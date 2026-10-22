package ug7;

import com.bytedance.keva.Keva;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IStoreRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f550036a;

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void clear() {
        this.f550036a.clear();
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final Map<String, ?> getAll() {
        return this.f550036a.getAll();
    }

    public a(Keva r100) {
        this.f550036a = r100;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final boolean contains(String r100) {
        return this.f550036a.contains(r100);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void remove(String r100) {
        this.f550036a.erase(r100);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final boolean getBoolean(String r100, boolean r101) {
        return this.f550036a.getBoolean(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final byte[] getBytes(String r100, byte[] r101) {
        return this.f550036a.getBytes(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final float getFloat(String r100, float r101) {
        return this.f550036a.getFloat(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final int getInt(String r100, int r101) {
        return this.f550036a.getInt(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final long getLong(String r100, long r101) {
        return this.f550036a.getLong(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final String getString(String r100, String r101) {
        String r102 = this.f550036a.getString(r100, r101);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final String[] getStringArray(String r100, String[] r101) {
        return this.f550036a.getStringArray(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        return this.f550036a.getStringSet(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putBoolean(String r100, boolean r101) {
        this.f550036a.storeBoolean(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putBytes(String r100, byte[] r101) {
        this.f550036a.storeBytes(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putFloat(String r100, float r101) {
        this.f550036a.storeFloat(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putInt(String r100, int r101) {
        this.f550036a.storeInt(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putLong(String r100, long r101) {
        this.f550036a.storeLong(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putString(String r100, String r101) {
        this.f550036a.storeString(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putStringArray(String r100, String[] r101) {
        this.f550036a.storeStringArray(r100, r101);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStoreRepo
    public final void putStringSet(String r100, Set<String> r101) {
        this.f550036a.storeStringSet(r100, r101);
    }
}
