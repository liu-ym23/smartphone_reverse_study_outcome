package com.bytedance.ies.argus.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0080\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/bean/z;", "", "", "", "highServerList", "Ljava/util/List;", "e", "()Ljava/util/List;", "highServerUrlList", "f", "defaultServerList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "defaultServerUrlList", "b", "excludeViewHostList", "c", "excludeViewUrlList", "d", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("default_server_list")
    private final List<String> defaultServerList;

    @SerializedName("default_server_url_list")
    private final List<String> defaultServerUrlList;

    @SerializedName("exclude_view_host_list")
    private final List<String> excludeViewHostList;

    @SerializedName("exclude_view_url_list")
    private final List<String> excludeViewUrlList;

    @SerializedName("high_server_list")
    private final List<String> highServerList;

    @SerializedName("high_server_url_list")
    private final List<String> highServerUrlList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.highServerList, r101.highServerList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.highServerUrlList, r101.highServerUrlList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultServerList, r101.defaultServerList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.defaultServerUrlList, r101.defaultServerUrlList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.excludeViewHostList, r101.excludeViewHostList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.excludeViewUrlList, r101.excludeViewUrlList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.highServerList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.highServerUrlList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.defaultServerList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.defaultServerUrlList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.excludeViewHostList;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.excludeViewUrlList;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "WebShouldInterceptRequestReportConfig(highServerList=" + this.highServerList + ", highServerUrlList=" + this.highServerUrlList + ", defaultServerList=" + this.defaultServerList + ", defaultServerUrlList=" + this.defaultServerUrlList + ", excludeViewHostList=" + this.excludeViewHostList + ", excludeViewUrlList=" + this.excludeViewUrlList + ')';
    }

    public z() {
        this.highServerList = null;
        this.highServerUrlList = null;
        this.defaultServerList = null;
        this.defaultServerUrlList = null;
        this.excludeViewHostList = null;
        this.excludeViewUrlList = null;
    }

    public final List<String> a() {
        return this.defaultServerList;
    }

    public final List<String> b() {
        return this.defaultServerUrlList;
    }

    public final List<String> c() {
        return this.excludeViewHostList;
    }

    public final List<String> d() {
        return this.excludeViewUrlList;
    }

    public final List<String> e() {
        return this.highServerList;
    }

    public final List<String> f() {
        return this.highServerUrlList;
    }
}
