package yl;

import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R:\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR:\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR:\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a¨\u0006\u001f"}, d2 = {"Lyl/f;", "", "", "path", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "alias", "getAlias", "bizTag", "getBizTag", "sceneTag", "getSceneTag", "preloadType", "getPreloadType", "", "priority", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "Ljava/util/HashMap;", "Lyl/e;", "Lkotlin/collections/HashMap;", "matcher", "Ljava/util/HashMap;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/HashMap;", "requestQueryMatcher", "getRequestQueryMatcher", "fromUrlEncodeMatcher", "getFromUrlEncodeMatcher", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("alias")
    private final String alias;

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("from_url_encode_matcher")
    private final HashMap<String, e> fromUrlEncodeMatcher;

    @SerializedName("matcher")
    private final HashMap<String, e> matcher;

    @SerializedName("path")
    private final String path;

    @SerializedName(ChameleonOpenTracker.ParamKey.PRELOAD_TYPE)
    private final String preloadType;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName("request_query_matcher")
    private final HashMap<String, e> requestQueryMatcher;

    @SerializedName(FrescoMonitorConst.SCENE_TAG)
    private final String sceneTag;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L24;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.alias, r101.alias) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bizTag, r101.bizTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneTag, r101.sceneTag) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.preloadType, r101.preloadType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.matcher, r101.matcher) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.requestQueryMatcher, r101.requestQueryMatcher) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.fromUrlEncodeMatcher, r101.fromUrlEncodeMatcher) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.path;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.alias;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bizTag;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sceneTag;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.preloadType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.priority;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        HashMap<String, e> r119 = this.matcher;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        HashMap<String, e> r122 = this.requestQueryMatcher;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        HashMap<String, e> r125 = this.fromUrlEncodeMatcher;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NetImagePreloadPathConfig(path=" + this.path + ", alias=" + this.alias + ", bizTag=" + this.bizTag + ", sceneTag=" + this.sceneTag + ", preloadType=" + this.preloadType + ", priority=" + this.priority + ", matcher=" + this.matcher + ", requestQueryMatcher=" + this.requestQueryMatcher + ", fromUrlEncodeMatcher=" + this.fromUrlEncodeMatcher + ")";
    }

    public f() {
        this.path = null;
        this.alias = null;
        this.bizTag = null;
        this.sceneTag = null;
        this.preloadType = null;
        this.priority = null;
        this.matcher = null;
        this.requestQueryMatcher = null;
        this.fromUrlEncodeMatcher = null;
    }

    public final HashMap<String, e> a() {
        return this.matcher;
    }

    public final String b() {
        return this.path;
    }
}
