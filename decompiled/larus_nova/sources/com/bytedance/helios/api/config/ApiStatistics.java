package com.bytedance.helios.api.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001b\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/helios/api/config/ApiStatistics;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "isBlockList", "Z", "e", "()Z", "", "", "apis", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "items", "c", "", "sessionIntervalTime", "J", "d", "()J", "cached", "b", "ApiType", "api_release"}, k = 1, mv = {1, 4, 0})
public final class ApiStatistics {

    @SerializedName("apis")
    private final List<Integer> apis;

    @SerializedName("cached")
    private final boolean cached;

    @SerializedName("is_block_list")
    private final boolean isBlockList;

    @SerializedName("items")
    private final List<String> items;

    @SerializedName("session_interval_time")
    private final long sessionIntervalTime;

    @SerializedName("type")
    private final String type;

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/api/config/ApiStatistics$ApiType;", "", "api_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ApiType {
    }

    public static final class a {
    }

    static {
    }

    public ApiStatistics() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ApiStatistics) == false) goto L18;
        ApiStatistics r101 = (ApiStatistics) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (this.isBlockList == r101.isBlockList) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.apis, r101.apis) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L14;
        return false;
    L14:
        if (this.sessionIntervalTime == r101.sessionIntervalTime) goto L16;
        return false;
    L16:
        if (this.cached == r101.cached) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.isBlockList;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        List<Integer> r108 = this.apis;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        List<String> r111 = this.items;
        if (r111 == null) goto L16;
        r101 = r111.hashCode();
    L16:
        int r112 = (r110 + r101) * 31;
        long r113 = this.sessionIntervalTime;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        boolean r115 = this.cached;
        if (r115 == true) goto L21;
        r105 = r115;
    L21:
        return r114 + r105;
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ApiStatistics(type=" + this.type + ", isBlockList=" + this.isBlockList + ", apis=" + this.apis + ", items=" + this.items + ", sessionIntervalTime=" + this.sessionIntervalTime + ", cached=" + this.cached + ")";
    }

    public final List<Integer> a() {
        return this.apis;
    }

    public final boolean b() {
        return this.cached;
    }

    public final List<String> c() {
        return this.items;
    }

    public final long d() {
        return this.sessionIntervalTime;
    }

    public final boolean e() {
        return this.isBlockList;
    }

    public final String getType() {
        return this.type;
    }

    public ApiStatistics(Object r100) {
        List<Integer> r101 = CollectionsKt.emptyList();
        List<String> r102 = CollectionsKt.emptyList();
        this.type = "api";
        this.isBlockList = false;
        this.apis = r101;
        this.items = r102;
        this.sessionIntervalTime = 60000;
        this.cached = false;
    }
}
