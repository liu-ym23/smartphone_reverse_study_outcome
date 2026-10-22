package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureStoreInstance;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureStoreInstance$a;", "listener", "", "registerReadyListener", "Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "featureStore", "notifyAllListener$pitayacore_release", "(Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;)V", "notifyAllListener", "", "TAG", "Ljava/lang/String;", "Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "getFeatureStore", "()Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "", "listeners", "Ljava/util/Set;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PTYFeatureStoreInstance implements ReflectionCall {
    public static final PTYFeatureStoreInstance INSTANCE = null;
    private static final String TAG = "PTYFeatureStoreInstance";
    private static final IFeatureStore featureStore = null;
    private static final Set<a> listeners = null;

    public interface a {
        void onReady();
    }

    private PTYFeatureStoreInstance() {
    }

    static {
        INSTANCE = new PTYFeatureStoreInstance();
        featureStore = new AndroidFeatureStore();
        listeners = new LinkedHashSet();
    }

    public final IFeatureStore getFeatureStore() {
        return featureStore;
    }

    public final void notifyAllListener$pitayacore_release(IFeatureStore r100) {
        Intrinsics.checkNotNullParameter(r100, "featureStore");
        monitor-enter(this);
        Iterator<T> r101 = listeners.iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        ((a) r101.next()).onReady();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void registerReadyListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        monitor-enter(this);
        IFeatureStore r101 = featureStore;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.pitaya.api.feature.store.AndroidFeatureStore");     // Catch: Throwable -> L10
        if (((AndroidFeatureStore) r101).getInnerFeatureStore() == null) goto L7;
        r100.onReady();     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L7:
        listeners.add(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
