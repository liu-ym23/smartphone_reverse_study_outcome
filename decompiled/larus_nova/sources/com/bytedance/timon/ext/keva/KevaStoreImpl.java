package com.bytedance.timon.ext.keva;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.bytedance.timon.foundation.interfaces.IStore;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import ug7.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timon/ext/keva/KevaStoreImpl;", "Lcom/bytedance/timon/foundation/interfaces/IStore;", "<init>", "()V", "ext-keva_release"}, k = 1, mv = {1, 4, 0})
public final class KevaStoreImpl implements IStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, IStoreRepo> f270617a;

    public KevaStoreImpl() {
        this.f270617a = new LinkedHashMap();
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStore
    public final IStoreRepo a(Context r100, String r101, int r102) {
        String r103 = r101 + '_' + r102;
        IStoreRepo r104 = (IStoreRepo) ((LinkedHashMap) this.f270617a).get(r103);
        if (r104 != null) goto L6;
        a r105 = new a(Keva.getRepo(r101, r102));
        this.f270617a.put(r103, r105);
        return r105;
    L6:
        return r104;
    }
}
