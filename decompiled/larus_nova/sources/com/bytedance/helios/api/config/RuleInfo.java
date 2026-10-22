package com.bytedance.helios.api.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\r\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/helios/api/config/RuleInfo;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "registerType", "c", "", "", "apiIds", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "resourceIds", "d", "RegisterType", "api_release"}, k = 1, mv = {1, 4, 0})
public final class RuleInfo {

    @SerializedName("api_ids")
    private final List<Integer> apiIds;

    @SerializedName("name")
    private final String name;

    @SerializedName("register_type")
    private final String registerType;

    @SerializedName(EffectConfiguration.KEY_RESOURCE_IDS)
    private final List<String> resourceIds;

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/api/config/RuleInfo$RegisterType;", "", "api_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RegisterType {
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RuleInfo) == false) goto L14;
        RuleInfo r101 = (RuleInfo) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.registerType, r101.registerType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.apiIds, r101.apiIds) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceIds, r101.resourceIds) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.registerType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<Integer> r107 = this.apiIds;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.resourceIds;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "RuleInfo(name=" + this.name + ", registerType=" + this.registerType + ", apiIds=" + this.apiIds + ", resourceIds=" + this.resourceIds + ")";
    }

    public RuleInfo() {
        this("", "manual", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final List<Integer> a() {
        return this.apiIds;
    }

    public final String b() {
        return this.name;
    }

    public final String c() {
        return this.registerType;
    }

    public final List<String> d() {
        return this.resourceIds;
    }

    public RuleInfo(String r100, String r101, List<Integer> r102, List<String> r103) {
        this.name = r100;
        this.registerType = r101;
        this.apiIds = r102;
        this.resourceIds = r103;
    }
}
