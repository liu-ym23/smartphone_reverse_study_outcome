package com.bytedance.pitaya.api.feature.store;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.pitaya.api.PTYNormalCallback;
import com.bytedance.pitaya.api.PitayaProxy;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYErrorCode;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016J\u001e\u0010%\u001a\u00020\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u0015H\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0015H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016J \u0010.\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010#\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u0002022\u0006\u0010#\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u00112\u0006\u0010#\u001a\u000203H\u0016J \u00106\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0016J\u0018\u00108\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J \u00109\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J \u0010=\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0016J0\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00042\u0006\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006C"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/AndroidFeatureStore;", "Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dumpFeature", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/pitaya/api/feature/store/PTYModelInstance;", "value", "innerFeatureStore", "getInnerFeatureStore", "()Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "setInnerFeatureStore", "(Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;)V", "producers", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureProducer;", "getProducers$pitayacore_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "addFeature", "", "name", "", "group", "Lorg/json/JSONObject;", "endSession", "featureName", "groupName", "getFeature", "", "queryType", "", "returnType", OfficeSDKRequestTag.KEY_NEW_USER, "callback", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureCallback;", "getGroupFeature", "query", "", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroupQuery;", "dump", "getModelInstance", "instanceId", "pop", "getRegisteredProducer", "registerCppCallback", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureChangeCallback;", "registerFeatureGroup", "featureGroup", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroup;", "Lcom/bytedance/pitaya/api/PTYNormalCallback;", "registerFeatureProducer", "featureProducer", "registerPyCallback", "business", "startSession", "unregisterCppCallback", "id", "unregisterFeatureGroup", "unregisterFeatureProducer", "unregisterPyCallback", "upload", "modelInstance", "sampleRate", "version", "tag", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidFeatureStore implements IFeatureStore {
    private final String TAG;
    private final ConcurrentHashMap<String, PTYModelInstance> dumpFeature;
    private IFeatureStore innerFeatureStore;
    private final ConcurrentHashMap<String, PTYFeatureProducer> producers;

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public List<String> getRegisteredProducer() {
        return Collections.list(this.producers.keys());
    }

    public AndroidFeatureStore() {
        this.TAG = "AndroidFeatureStore";
        this.producers = new ConcurrentHashMap();
        this.dumpFeature = new ConcurrentHashMap();
    }

    public final IFeatureStore getInnerFeatureStore() {
        return this.innerFeatureStore;
    }

    public final ConcurrentHashMap<String, PTYFeatureProducer> getProducers$pitayacore_release() {
        return this.producers;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final void setInnerFeatureStore(IFeatureStore r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.innerFeatureStore != null) goto L23;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.innerFeatureStore != null) goto L13;
        this.innerFeatureStore = r100;     // Catch: Throwable -> L16
        IFeatureStore r101 = PTYFeatureStoreInstance.INSTANCE.getFeatureStore();     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.pitaya.api.feature.store.AndroidFeatureStore");     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, PTYFeatureProducer>> r102 = ((AndroidFeatureStore) r101).producers.entrySet().iterator();     // Catch: Throwable -> L16
    L10:
        if (r102.hasNext() == false) goto L12;
        r100.registerFeatureProducer(r102.next().getValue(), new AndroidFeatureStore$innerFeatureStore$1$1(this));     // Catch: Throwable -> L16
        goto L10
    L12:
        PTYFeatureStoreInstance.INSTANCE.notifyAllListener$pitayacore_release(r100);     // Catch: Throwable -> L16
    L13:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean unregisterFeatureGroup(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        IFeatureStore r101 = this.innerFeatureStore;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.unregisterFeatureGroup(r100);
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean unregisterFeatureProducer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        IFeatureStore r101 = this.innerFeatureStore;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.unregisterFeatureProducer(r100);
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean endSession(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        Intrinsics.checkNotNullParameter(r101, "groupName");
        IFeatureStore r102 = this.innerFeatureStore;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.endSession(r100, r101);
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public PTYModelInstance getGroupFeature(List<PTYFeatureGroupQuery> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "query");
        PTYModelInstance r100 = new PTYModelInstance(UUID.randomUUID().toString(), SliceInitService.DEFAULT_SWITCH);
        JSONObject r101 = new JSONObject();
        ArrayList r102 = new ArrayList();
        List<String> r103 = getRegisteredProducer();
        Iterator<PTYFeatureGroupQuery> r112 = r110.iterator();
    L4:
        if (r112.hasNext() == false) goto L29;
        PTYFeatureGroupQuery r104 = r112.next();
        if (r103.contains(r104.getGroupName()) == false) goto L7;
        PTYFeatureProducer r105 = this.producers.get(r104.getGroupName());
        if (r105 == null) goto L4;
        Iterator<PTYFeatureQuery> r106 = r104.getQueries().iterator();
    L13:
        if (r106.hasNext() == false) goto L4;
        PTYFeatureQuery r107 = r106.next();
        if (r107.getQueryType() != 200) goto L13;
        JSONObject r108 = null;
        if (r107.getExtParams() == null) goto L22;
        r108 = new JSONObject(r107.getExtParams());     // Catch: JSONException -> L20
    L22:
        switch(r107.getReturnType()) {
            case 200: goto L27;
            case 201: goto L26;
            case 202: goto L25;
            case 203: goto L24;
            default: goto L13;
        };
    L24:
        r101.put(r107.getReturnFeatureName(), r105.getSeqFeature(r107.getFeatureName(), r108));
        goto L13
    L25:
        r101.put(r107.getReturnFeatureName(), r105.getDictFeature(r107.getFeatureName(), r108));
        goto L13
    L26:
        r101.put(r107.getReturnFeatureName(), r105.getStringFeature(r107.getFeatureName(), r108));
        goto L13
    L27:
        r101.put(r107.getReturnFeatureName(), Float.valueOf(r105.getNumericFeature(r107.getFeatureName(), r108)));
        goto L13
    L7:
        r102.add(r104);
        goto L4
    L29:
        if ((!r102.isEmpty()) == false) goto L41;
        IFeatureStore r113 = this.innerFeatureStore;
        if (r113 == null) goto L41;
        if (r113 == null) goto L41;
        PTYModelInstance r114 = r113.getGroupFeature(r102, false);
        if (r114 == null) goto L41;
        JSONObject r115 = r114.getFeatures();
        if (r115 == null) goto L41;
        Iterator<String> r109 = r115.keys();
    L39:
        if (r109.hasNext() == false) goto L41;
        String r116 = r109.next();
        r101.put(r116, r115.get(r116));
    L41:
        r100.updateFeatures$pitayacore_release(r101);
        if (r111 == false) goto L44;
        this.dumpFeature.put(r100.getInstanceID(), r100);
    L44:
        return r100;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public PTYModelInstance getModelInstance(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "instanceId");
        if (r101 == false) goto L6;
        return this.dumpFeature.remove(r100);
    L6:
        return this.dumpFeature.get(r100);
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void registerFeatureGroup(PTYFeatureGroup r100, PTYNormalCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "featureGroup");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IFeatureStore r102 = this.innerFeatureStore;
        if (r102 != null) goto L6;
        int r103 = PTYErrorCode.PITAYA_IMPL_NOT_READY.getCode();
        r101.onResult(false, new PTYError("FeatureStore", r103, r103, "Pitaya SDK not init", null));
        return;
    L6:
        if (r102 == null) goto L9;
        r102.registerFeatureGroup(r100, r101);
        return;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void registerFeatureProducer(PTYFeatureProducer r110, PTYNormalCallback r111) {
        Intrinsics.checkNotNullParameter(r110, "featureProducer");
        Intrinsics.checkNotNullParameter(r111, "callback");
        String r100 = r110.getGroupName();
        IFeatureStore r101 = this.innerFeatureStore;
        if (r101 == null) goto L9;
        List<String> r102 = r101.getRegisteredProducer();
        if (r102 == null) goto L9;
        if (r102.contains(r100) != true) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        int r104 = PTYErrorCode.INVALID_DATA.getCode();
        r111.onResult(false, new PTYError("FeatureStore", r104, r104, r100 + " Producer has already been registered", null));
        return;
    L13:
        PTYFeatureStoreInstance r105 = PTYFeatureStoreInstance.INSTANCE;
        monitor-enter(r105);
        this.producers.put(r100, r110);     // Catch: Throwable -> L22
        IFeatureStore r106 = this.innerFeatureStore;     // Catch: Throwable -> L22
        if (r106 == null) goto L19;
        if (r106 == null) goto L20;
        r106.registerFeatureProducer(r110, r111);     // Catch: Throwable -> L22
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        monitor-exit(r105);
        return;
    L19:
        r111.onResult(true, null);     // Catch: Throwable -> L22
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L9:
        r103 = false;
        goto L10
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean startSession(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        Intrinsics.checkNotNullParameter(r101, "groupName");
        IFeatureStore r102 = this.innerFeatureStore;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.startSession(r100, r101);
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean addFeature(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "group");
        if (this.innerFeatureStore == null) goto L5;
    L7:
        IFeatureStore r103 = this.innerFeatureStore;
        if (r103 != null) goto L10;
        return false;
    L10:
        return r103.addFeature(r100, r101, r102);
    L5:
        if (PitayaProxy.isFeatureStoreProxyEnabled() == false) goto L7;
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public String registerCppCallback(String r100, String r101, PTYFeatureChangeCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Intrinsics.checkNotNullParameter(r101, "featureName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        IFeatureStore r103 = this.innerFeatureStore;
        if (r103 == null) goto L6;
        String r104 = r103.registerCppCallback(r100, r101, r102);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public String registerPyCallback(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Intrinsics.checkNotNullParameter(r101, "featureName");
        Intrinsics.checkNotNullParameter(r102, "business");
        IFeatureStore r103 = this.innerFeatureStore;
        if (r103 == null) goto L6;
        String r104 = r103.registerPyCallback(r100, r101, r102);
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void unregisterCppCallback(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Intrinsics.checkNotNullParameter(r101, "featureName");
        Intrinsics.checkNotNullParameter(r102, "id");
        IFeatureStore r103 = this.innerFeatureStore;
        if (r103 == null) goto L6;
        r103.unregisterCppCallback(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void unregisterPyCallback(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        Intrinsics.checkNotNullParameter(r101, "featureName");
        Intrinsics.checkNotNullParameter(r102, "id");
        IFeatureStore r103 = this.innerFeatureStore;
        if (r103 == null) goto L6;
        r103.unregisterPyCallback(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean addFeature(String r100, JSONObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "group");
        if (this.innerFeatureStore == null) goto L5;
    L7:
        IFeatureStore r103 = this.innerFeatureStore;
        if (r103 != null) goto L10;
        return false;
    L10:
        return r103.addFeature(r100, r101, r102);
    L5:
        if (PitayaProxy.isFeatureStoreProxyEnabled() == false) goto L7;
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean addFeature(String r100, float r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "group");
        if (this.innerFeatureStore == null) goto L5;
    L7:
        IFeatureStore r103 = this.innerFeatureStore;
        if (r103 != null) goto L10;
        return false;
    L10:
        return r103.addFeature(r100, r101, r102);
    L5:
        if (PitayaProxy.isFeatureStoreProxyEnabled() == false) goto L7;
        return false;
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public boolean upload(PTYModelInstance r100, float r101, String r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "modelInstance");
        Intrinsics.checkNotNullParameter(r110, "business");
        Intrinsics.checkNotNullParameter(r112, "tag");
        IFeatureStore r102 = this.innerFeatureStore;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.upload(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.pitaya.api.feature.store.IFeatureStore
    public void getFeature(String r100, String r110, int r111, int r112, int r113, PTYFeatureCallback r114) {
        Intrinsics.checkNotNullParameter(r100, "featureName");
        Intrinsics.checkNotNullParameter(r110, "groupName");
        Intrinsics.checkNotNullParameter(r114, "callback");
        IFeatureStore r101 = this.innerFeatureStore;
        if (r101 != null) goto L6;
        int r102 = PTYErrorCode.PITAYA_IMPL_NOT_READY.getCode();
        r114.onResult(false, new PTYError("FeatureStore", r102, r102, "Pitaya SDK not init", null), "");
        return;
    L6:
        if (r101 == null) goto L9;
        r101.getFeature(r100, r110, r111, r112, r113, r114);
        return;
    }
}
