package com.bytedance.pitaya.api.feature;

import com.bytedance.pitaya.api.feature.store.PTYFeatureStoreInstance;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0005R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pitaya/api/feature/FeatureCoreFactory;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "cores", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/pitaya/api/feature/IFeatureCore;", "getCores", "()Ljava/util/concurrent/ConcurrentHashMap;", "featureStore", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureStoreInstance;", "getFeatureStore", "()Lcom/bytedance/pitaya/api/feature/store/PTYFeatureStoreInstance;", "getFeatureCore", "aid", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FeatureCoreFactory implements ReflectionCall {
    public static final FeatureCoreFactory INSTANCE = null;
    private static final ConcurrentHashMap<String, IFeatureCore> cores = null;
    private static final PTYFeatureStoreInstance featureStore = null;

    private FeatureCoreFactory() {
    }

    static {
        INSTANCE = new FeatureCoreFactory();
        cores = new ConcurrentHashMap();
        featureStore = PTYFeatureStoreInstance.INSTANCE;
    }

    public final ConcurrentHashMap<String, IFeatureCore> getCores() {
        return cores;
    }

    public final PTYFeatureStoreInstance getFeatureStore() {
        return featureStore;
    }

    public final IFeatureCore getFeatureCore(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        ConcurrentHashMap<String, IFeatureCore> r101 = cores;
        monitor-enter(r101);
        IFeatureCore r102 = r101.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }
}
