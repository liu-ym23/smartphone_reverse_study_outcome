package com.bytedance.android.shopping.store.hybrid.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/c;", "", "", "Lcom/bytedance/android/shopping/store/hybrid/entity/b;", "componentVersions", "Ljava/util/List;", "a", "()Ljava/util/List;", "", "isvComponentBundleUrl", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("component_versions")
    private final List<b> componentVersions;

    @SerializedName("isv_component_bundle_url")
    private final List<String> isvComponentBundleUrl;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.componentVersions, r4.componentVersions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.isvComponentBundleUrl, r4.isvComponentBundleUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<b> r0 = this.componentVersions;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.isvComponentBundleUrl;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IsvInfo(componentVersions=" + this.componentVersions + ", isvComponentBundleUrl=" + this.isvComponentBundleUrl + ")";
    }

    public c() {
        this.componentVersions = null;
        this.isvComponentBundleUrl = null;
    }

    public final List<b> a() {
        return this.componentVersions;
    }

    public final List<String> b() {
        return this.isvComponentBundleUrl;
    }
}
