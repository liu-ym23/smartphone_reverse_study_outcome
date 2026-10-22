package com.bytedance.pitaya.api.feature;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import f57.a;
import f57.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H&R\u0014\u0010\u0012\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pitaya/api/feature/IFeatureCore;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "Le57/a;", "getCepCore", "", "businessName", "Lcom/bytedance/pitaya/api/feature/IKVStore;", "createKVStore", "createInMemoryKVStore", "Lf57/b;", "createFeatureSchema", "sharedFeatureSchema", "", "ResetRunEventCache", "Lf57/a;", "createCloudFeature", "getAid", "()Ljava/lang/String;", "aid", "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public interface IFeatureCore extends ReflectionCall {
    void ResetRunEventCache(String r100);

    a createCloudFeature(String r100);

    b createFeatureSchema(String r100);

    IKVStore createInMemoryKVStore(String r100);

    IKVStore createKVStore(String r100);

    String getAid();

    e57.a getCepCore();

    b sharedFeatureSchema();
}
