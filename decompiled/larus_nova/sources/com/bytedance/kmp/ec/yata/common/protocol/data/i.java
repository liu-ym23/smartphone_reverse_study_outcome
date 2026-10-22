package com.bytedance.kmp.ec.yata.common.protocol.data;

import com.amap.api.col.s.ce;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR6\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/protocol/data/i;", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/m;", "Lcom/bytedance/kmp/ec/yata/common/platform/l;", "", RootDescription.ROOT_ELEMENT, "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "", "popupRootList", "Ljava/util/List;", "e", "()Ljava/util/List;", ce.f26395j, "(Ljava/util/List;)V", "commonNodeList", "c", RXScreenCaptureService.KEY_INDEX, "", "", "structure", "Ljava/util/Map;", "h", "()Ljava/util/Map;", ce.f26396k, "(Ljava/util/Map;)V", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class i implements m<i>, com.bytedance.kmp.ec.yata.common.platform.l {

    @SerializedName("common_node_list")
    private List<String> commonNodeList;

    @SerializedName("popup_root_list")
    private List<String> popupRootList;

    @SerializedName(RootDescription.ROOT_ELEMENT)
    private final String root;

    @SerializedName("structure")
    private Map<String, List<String>> structure;

    public i() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.root, r101.root) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.popupRootList, r101.popupRootList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.commonNodeList, r101.commonNodeList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.structure, r101.structure) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.root;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.popupRootList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.commonNodeList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, List<String>> r110 = this.structure;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "Facade(root=" + this.root + ", popupRootList=" + this.popupRootList + ", commonNodeList=" + this.commonNodeList + ", structure=" + this.structure + ')';
    }

    public final i b() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        String r100 = this.root;
        Map<String, List<String>> r101 = this.structure;
        List r102 = null;
        if (r101 == null) goto L5;
        Map<String, Object> r103 = com.bytedance.kmp.ec.yata.common.protocol.utils.b.b(r101, 1);
    L7:
        if (TypeIntrinsics.isMutableMap(r103) == true) goto L10;
        r103 = null;
    L10:
        List<String> r104 = this.commonNodeList;
        if (r104 == null) goto L13;
        List r105 = CollectionsKt.toMutableList(r104);
    L14:
        List<String> r106 = this.popupRootList;
        if (r106 == null) goto L18;
        r102 = CollectionsKt.toMutableList(r106);
    L18:
        return new i(r100, r102, r105, r103);
    L13:
        r105 = null;
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final Map<String, Object> f() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(RootDescription.ROOT_ELEMENT, g()), TuplesKt.to("popup_root_list", e()), TuplesKt.to("common_node_list", c()), TuplesKt.to("structure", h())});
    }

    public final List<String> c() {
        return this.commonNodeList;
    }

    public final List<String> e() {
        return this.popupRootList;
    }

    public final String g() {
        return this.root;
    }

    public final Map<String, List<String>> h() {
        return this.structure;
    }

    @Override // com.bytedance.kmp.ec.yata.common.protocol.data.m
    public final /* bridge */ /* synthetic */ i d(int r100) {
        return b();
    }

    public final void i(List<String> r100) {
        this.commonNodeList = r100;
    }

    public final void j(List<String> r100) {
        this.popupRootList = r100;
    }

    public final void k(Map<String, List<String>> r100) {
        this.structure = r100;
    }

    public static i a(i r100, String r101) {
        return new i(r101, r100.popupRootList, r100.commonNodeList, r100.structure);
    }

    public i(String r100, List<String> r101, List<String> r102, Map<String, List<String>> r103) {
        this.root = r100;
        this.popupRootList = r101;
        this.commonNodeList = r102;
        this.structure = r103;
    }
}
