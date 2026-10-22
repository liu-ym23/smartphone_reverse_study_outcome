package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.api.PTYNormalCallback;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000 52\u00020\u0001:\u00015J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H'J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H'J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H'J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H'J>\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H'J \u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0003H'J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0003H'J\u0010\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018H'J \u0010\u001f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020 H'J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020$H'J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020$H'J \u0010(\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H'J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H'J \u0010+\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H'J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H'J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H'J \u0010/\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H'J4\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u00020\u0005H'¨\u00066"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/IFeatureStore;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "addFeature", "", "name", "", "value", "", "group", "Lorg/json/JSONObject;", "endSession", "featureName", "groupName", "getFeature", "", "queryType", "", "returnType", OfficeSDKRequestTag.KEY_NEW_USER, "callback", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureCallback;", "getGroupFeature", "Lcom/bytedance/pitaya/api/feature/store/PTYModelInstance;", "query", "", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroupQuery;", "dump", "getModelInstance", "instanceId", "pop", "getRegisteredProducer", "registerCppCallback", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureChangeCallback;", "registerFeatureGroup", "featureGroup", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureGroup;", "Lcom/bytedance/pitaya/api/PTYNormalCallback;", "registerFeatureProducer", "featureProducer", "Lcom/bytedance/pitaya/api/feature/store/PTYFeatureProducer;", "registerPyCallback", "business", "startSession", "unregisterCppCallback", "id", "unregisterFeatureGroup", "unregisterFeatureProducer", "unregisterPyCallback", "upload", "modelInstance", "sampleRate", "version", "tag", "Companion", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IFeatureStore extends ReflectionCall {
    public static final Companion Companion = null;
    public static final int PTYFEQueryTypeCustom = 200;
    public static final int PTYFEQueryTypeKV = 0;
    public static final int PTYFEQueryTypeLastN = 2;
    public static final int PTYFEQueryTypeLastNDay = 4;
    public static final int PTYFEQueryTypeSessionLastN = 5;
    public static final int PTYFEQueryTypeTimeNDay = 3;
    public static final int PTYFEQueryTypeTimeNSecond = 1;
    public static final int PTYFEQueryTypeUnknown = 99;
    public static final int PTYFERetTypeAvg = 6;
    public static final int PTYFERetTypeCount = 3;
    public static final int PTYFERetTypeCustomDict = 202;
    public static final int PTYFERetTypeCustomNumeric = 200;
    public static final int PTYFERetTypeCustomSeq = 203;
    public static final int PTYFERetTypeCustomString = 201;
    public static final int PTYFERetTypeDetails = 1;
    public static final int PTYFERetTypeKV = 0;
    public static final int PTYFERetTypeMax = 5;
    public static final int PTYFERetTypeMin = 4;
    public static final int PTYFERetTypePairDetails = 7;
    public static final int PTYFERetTypeSum = 2;
    public static final int PTYFERetTypeUnknown = 99;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f266544a = null;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/IFeatureStore$Companion$PTYQueryFeatureType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PTYQueryFeatureType {
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/IFeatureStore$Companion$PTYReturnFeatureType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PTYReturnFeatureType {
        }

        static {
            f266544a = new Companion();
        }

        public Companion() {
        }
    }

    static {
        Companion = Companion.f266544a;
    }

    boolean addFeature(String r100, float r101, String r102);

    boolean addFeature(String r100, String r101, String r102);

    boolean addFeature(String r100, JSONObject r101, String r102);

    boolean endSession(String r100, String r101);

    void getFeature(String r100, String r101, int r102, int r103, int r104, PTYFeatureCallback r105);

    PTYModelInstance getGroupFeature(List<PTYFeatureGroupQuery> r100, boolean r101);

    PTYModelInstance getModelInstance(String r100, boolean r101);

    List<String> getRegisteredProducer();

    String registerCppCallback(String r100, String r101, PTYFeatureChangeCallback r102);

    void registerFeatureGroup(PTYFeatureGroup r100, PTYNormalCallback r101);

    void registerFeatureProducer(PTYFeatureProducer r100, PTYNormalCallback r101);

    String registerPyCallback(String r100, String r101, String r102);

    boolean startSession(String r100, String r101);

    void unregisterCppCallback(String r100, String r101, String r102);

    boolean unregisterFeatureGroup(String r100);

    boolean unregisterFeatureProducer(String r100);

    void unregisterPyCallback(String r100, String r101, String r102);

    boolean upload(PTYModelInstance r100, float r101, String r102, int r103, String r104);
}
