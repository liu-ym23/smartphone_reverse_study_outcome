package com.bytedance.timon.foundation.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.timon.foundation.interfaces.IStore;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timon/foundation/impl/SPStoreImpl;", "Lcom/bytedance/timon/foundation/interfaces/IStore;", "<init>", "()V", "timonfoundation_release"}, k = 1, mv = {1, 4, 0})
public final class SPStoreImpl implements IStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, IStoreRepo> f270623a;

    public SPStoreImpl() {
        this.f270623a = new LinkedHashMap();
    }

    @Override // com.bytedance.timon.foundation.interfaces.IStore
    public final IStoreRepo a(Context r100, String r101, int r102) {
        String r103 = r101 + '_' + r102;
        IStoreRepo r104 = (IStoreRepo) ((LinkedHashMap) this.f270623a).get(r103);
        if (r104 != null) goto L9;
        if (r100 == null) goto L6;
        SharedPreferences r105 = r100.getSharedPreferences(r101, 0);
    L7:
        a r106 = new a(r105);
        this.f270623a.put(r103, r106);
        return r106;
    L6:
        r105 = null;
        goto L7
    L9:
        return r104;
    }
}
