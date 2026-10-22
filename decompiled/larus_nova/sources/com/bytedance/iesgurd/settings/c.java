package com.bytedance.iesgurd.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/iesgurd/settings/c;", "", "", "", "supportCustomRequestAks", "Ljava/util/List;", "getSupportCustomRequestAks", "()Ljava/util/List;", "", "Lcom/bytedance/iesgurd/settings/d;", "requestUpdateConfig", "Ljava/util/Map;", "getRequestUpdateConfig", "()Ljava/util/Map;", "preUpdateConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("pre_update_config")
    private final Map<String, d> preUpdateConfig;

    @SerializedName("request_update_config")
    private final Map<String, d> requestUpdateConfig;

    @SerializedName("support_custom_request_aks")
    private final List<String> supportCustomRequestAks;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.supportCustomRequestAks, r101.supportCustomRequestAks) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.requestUpdateConfig, r101.requestUpdateConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preUpdateConfig, r101.preUpdateConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.supportCustomRequestAks;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, d> r104 = this.requestUpdateConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, d> r107 = this.preUpdateConfig;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateConfig(supportCustomRequestAks=" + this.supportCustomRequestAks + ", requestUpdateConfig=" + this.requestUpdateConfig + ", preUpdateConfig=" + this.preUpdateConfig + ")";
    }

    public final Map<String, d> a() {
        return this.preUpdateConfig;
    }

    public c(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        Map<String, d> r102 = MapsKt.emptyMap();
        Map<String, d> r103 = MapsKt.emptyMap();
        this.supportCustomRequestAks = r101;
        this.requestUpdateConfig = r102;
        this.preUpdateConfig = r103;
    }
}
