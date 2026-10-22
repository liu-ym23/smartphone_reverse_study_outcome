package com.ss.android.ugc.aweme.poi.perf;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/perf/PoiLynxPreloadUrlConfig;", "", "", "url", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "loadType", "I", "d", "()I", "applicableScene", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ditoTag", "b", "", "loadAsync", "Z", "c", "()Z", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiLynxPreloadUrlConfig {

    @SerializedName("applicable_scene")
    private final int applicableScene;

    @SerializedName("dito_tag")
    private final String ditoTag;

    @SerializedName("load_async")
    private final boolean loadAsync;

    @SerializedName(ChameleonOpenTracker.ParamKey.LOAD_TYPE)
    private final int loadType;

    @SerializedName("url")
    private final String url;

    public PoiLynxPreloadUrlConfig() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiLynxPreloadUrlConfig) == true) goto L8;
        return false;
    L8:
        PoiLynxPreloadUrlConfig r101 = (PoiLynxPreloadUrlConfig) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (this.loadType == r101.loadType) goto L15;
        return false;
    L15:
        if (this.applicableScene == r101.applicableScene) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ditoTag, r101.ditoTag) == true) goto L21;
        return false;
    L21:
        if (this.loadAsync == r101.loadAsync) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.loadType) * 31) + this.applicableScene) * 31;
        String r104 = this.ditoTag;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.loadAsync == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiLynxPreloadUrlConfig(url=" + this.url + ", loadType=" + this.loadType + ", applicableScene=" + this.applicableScene + ", ditoTag=" + this.ditoTag + ", loadAsync=" + this.loadAsync + ')';
    }

    public final int a() {
        return this.applicableScene;
    }

    public final String b() {
        return this.ditoTag;
    }

    public final boolean c() {
        return this.loadAsync;
    }

    public final int d() {
        return this.loadType;
    }

    public final String e() {
        return this.url;
    }

    public PoiLynxPreloadUrlConfig(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.url = r100;
        this.loadType = 0;
        this.applicableScene = 0;
        this.ditoTag = null;
        this.loadAsync = false;
    }
}
