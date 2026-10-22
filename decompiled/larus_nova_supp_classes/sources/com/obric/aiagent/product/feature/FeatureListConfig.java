package com.obric.aiagent.product.feature;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.feature.bean.FeatureConfigWrap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/product/feature/FeatureListConfig;", XmlPullParser.NO_NAMESPACE, "version", XmlPullParser.NO_NAMESPACE, "featureConfigs", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "Lcom/obric/aiagent/product/feature/FeatureConfig;", "featureConfigWraps", "Lcom/obric/aiagent/product/feature/bean/FeatureConfigWrap;", "<init>", "(ILjava/util/Map;Ljava/util/Map;)V", "getVersion", "()I", "getFeatureConfigs", "()Ljava/util/Map;", "getFeatureConfigWraps", "component1", "component2", "component3", "copy", "equals", XmlPullParser.NO_NAMESPACE, "other", "hashCode", "toString", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class FeatureListConfig {

    @SerializedName("feature_config_warps")
    private final Map<String, FeatureConfigWrap> featureConfigWraps;

    @SerializedName("feature_configs")
    private final Map<String, FeatureConfig> featureConfigs;

    @SerializedName("version")
    private final int version;

    public FeatureListConfig() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureListConfig copy$default(FeatureListConfig r0, int r1, Map r2, Map r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.version;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.featureConfigs;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.featureConfigWraps;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.version;
    }

    public final Map<String, FeatureConfig> component2() {
        return this.featureConfigs;
    }

    public final Map<String, FeatureConfigWrap> component3() {
        return this.featureConfigWraps;
    }

    public final FeatureListConfig copy(int r2, Map<String, FeatureConfig> r3, Map<String, FeatureConfigWrap> r4) {
        Intrinsics.checkNotNullParameter(r3, "featureConfigs");
        Intrinsics.checkNotNullParameter(r4, "featureConfigWraps");
        return new FeatureListConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeatureListConfig) == true) goto L8;
        return false;
    L8:
        FeatureListConfig r6 = (FeatureListConfig) r5;
        if (this.version == r6.version) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.featureConfigs, r6.featureConfigs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.featureConfigWraps, r6.featureConfigWraps) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.version * 31) + this.featureConfigs.hashCode()) * 31) + this.featureConfigWraps.hashCode();
    }

    public String toString() {
        return "FeatureListConfig(version=" + this.version + ", featureConfigs=" + this.featureConfigs + ", featureConfigWraps=" + this.featureConfigWraps + ')';
    }

    public final Map<String, FeatureConfigWrap> getFeatureConfigWraps() {
        return this.featureConfigWraps;
    }

    public final Map<String, FeatureConfig> getFeatureConfigs() {
        return this.featureConfigs;
    }

    public final int getVersion() {
        return this.version;
    }

    public FeatureListConfig(int r2, Map<String, FeatureConfig> r3, Map<String, FeatureConfigWrap> r4) {
        Intrinsics.checkNotNullParameter(r3, "featureConfigs");
        Intrinsics.checkNotNullParameter(r4, "featureConfigWraps");
        this.version = r2;
        this.featureConfigs = r3;
        this.featureConfigWraps = r4;
    }

    public /* synthetic */ FeatureListConfig(int r1, Map r2, Map r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = MapsKt.emptyMap();
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = MapsKt.emptyMap();
    L11:
        this(r1, r2, r3);
    }
}
