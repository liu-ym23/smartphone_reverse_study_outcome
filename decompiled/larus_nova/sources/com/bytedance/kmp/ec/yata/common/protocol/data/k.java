package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR*\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/k;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/m;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "", "extendBlock", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "", "nodeName", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "type", "getType", "position", ce.f26395j, "isAsyncHost", ce.f26396k, "isPassiveChange", "l", "collectionParams", "b", "", "", "dynamicFeatures", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "placeHolderType", RXScreenCaptureService.KEY_INDEX, "layoutType", ce.f26391f, "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class k implements m<k>, com.bytedance.kmp.ec.yata.common.platform.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient List<String> f251552a;

    @SerializedName("collection_params")
    private final String collectionParams;

    @SerializedName("dynamic_features")
    private final Map<String, Object> dynamicFeatures;

    @SerializedName("extend_block")
    private final Boolean extendBlock;

    @SerializedName("is_async_host")
    private final Boolean isAsyncHost;

    @SerializedName("is_passive_change")
    private final Boolean isPassiveChange;

    @SerializedName("layout_type")
    private final String layoutType;

    @SerializedName("node_name")
    private final String nodeName;

    @SerializedName("placeholder_type")
    private final String placeHolderType;

    @SerializedName("position")
    private final String position;

    @SerializedName("type")
    private final String type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.extendBlock, r101.extendBlock) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nodeName, r101.nodeName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isAsyncHost, r101.isAsyncHost) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isPassiveChange, r101.isPassiveChange) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.collectionParams, r101.collectionParams) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dynamicFeatures, r101.dynamicFeatures) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.placeHolderType, r101.placeHolderType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.layoutType, r101.layoutType) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.extendBlock;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.nodeName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.type;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.position;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isAsyncHost;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isPassiveChange;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.collectionParams;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, Object> r122 = this.dynamicFeatures;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.placeHolderType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.layoutType;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        return "Features(extendBlock=" + this.extendBlock + ", nodeName=" + this.nodeName + ", type=" + this.type + ", position=" + this.position + ", isAsyncHost=" + this.isAsyncHost + ", isPassiveChange=" + this.isPassiveChange + ", collectionParams=" + this.collectionParams + ", dynamicFeatures=" + this.dynamicFeatures + ", placeHolderType=" + this.placeHolderType + ", layoutType=" + this.layoutType + ')';
    }

    public k() {
        Boolean r100 = Boolean.FALSE;
        this(r100, null, null, null, r100, r100, null, null, null, null);
    }

    public final k a() {
        return new k(this.extendBlock, this.nodeName, this.type, this.position, this.isAsyncHost, this.isPassiveChange, this.collectionParams, this.dynamicFeatures, this.placeHolderType, this.layoutType);
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final Map<String, Object> f() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("extend_block", e()), TuplesKt.to("node_name", h()), TuplesKt.to("type", getType()), TuplesKt.to("position", j()), TuplesKt.to("is_async_host", k()), TuplesKt.to("is_passive_change", l()), TuplesKt.to("collection_params", b()), TuplesKt.to("dynamic_features", c()), TuplesKt.to("placeholder_type", i()), TuplesKt.to("layout_type", g())});
    }

    public final String b() {
        return this.collectionParams;
    }

    public final Map<String, Object> c() {
        return this.dynamicFeatures;
    }

    public final Boolean e() {
        return this.extendBlock;
    }

    public final String g() {
        return this.layoutType;
    }

    public final String getType() {
        return this.type;
    }

    public final String h() {
        return this.nodeName;
    }

    public final String i() {
        return this.placeHolderType;
    }

    public final String j() {
        return this.position;
    }

    public final Boolean k() {
        return this.isAsyncHost;
    }

    public final Boolean l() {
        return this.isPassiveChange;
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final /* bridge */ /* synthetic */ k d(int r100) {
        return a();
    }

    public k(Boolean r100, String r101, String r102, String r103, Boolean r104, Boolean r105, String r106, Map<String, ? extends Object> r107, String r108, String r110) {
        this.extendBlock = r100;
        this.nodeName = r101;
        this.type = r102;
        this.position = r103;
        this.isAsyncHost = r104;
        this.isPassiveChange = r105;
        this.collectionParams = r106;
        this.dynamicFeatures = r107;
        this.placeHolderType = r108;
        this.layoutType = r110;
    }
}
