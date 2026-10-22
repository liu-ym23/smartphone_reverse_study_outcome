package com.bytedance.android.shopping.store.hybrid.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/b;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "componentId", "getComponentId", "version", "b", "indexUrl", "getIndexUrl", "lynxIndexUrl", "a", "settingUrl", "getSettingUrl", "", "frameworkType", "I", "getFrameworkType", "()I", "extra", "getExtra", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("framework_type")
    private final int frameworkType;

    @SerializedName("id")
    private final String id;

    @SerializedName("index_url")
    private final String indexUrl;

    @SerializedName("lynx_index_url")
    private final String lynxIndexUrl;

    @SerializedName("setting_url")
    private final String settingUrl;

    @SerializedName("version")
    private final String version;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L22;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentId, r4.componentId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.version, r4.version) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.indexUrl, r4.indexUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.lynxIndexUrl, r4.lynxIndexUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.settingUrl, r4.settingUrl) == true) goto L18;
        return false;
    L18:
        if (this.frameworkType == r4.frameworkType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.componentId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.version;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.indexUrl;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.lynxIndexUrl;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.settingUrl;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (((r15 + r17) * 31) + this.frameworkType) * 31;
        String r19 = this.extra;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ComponentVersion(id=" + this.id + ", componentId=" + this.componentId + ", version=" + this.version + ", indexUrl=" + this.indexUrl + ", lynxIndexUrl=" + this.lynxIndexUrl + ", settingUrl=" + this.settingUrl + ", frameworkType=" + this.frameworkType + ", extra=" + this.extra + ")";
    }

    public b() {
        this.id = null;
        this.componentId = null;
        this.version = null;
        this.indexUrl = null;
        this.lynxIndexUrl = null;
        this.settingUrl = null;
        this.frameworkType = -1;
        this.extra = null;
    }

    public final String a() {
        return this.lynxIndexUrl;
    }

    public final String b() {
        return this.version;
    }
}
