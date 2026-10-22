package com.bytedance.locallife.dito.data;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.locallife.dito.utils.DitoPageAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@JsonAdapter(DitoPageAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003JK\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\u0006\u0010\u0018\u001a\u00020\u0015J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0006H\u0016R*\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/dito/data/DitoPage;", "Ljava/io/Serializable;", "pageInfo", "Lcom/bytedance/locallife/dito/data/DitoPageInfo;", "layout", "", "", "", "nodes", "Lcom/bytedance/locallife/dito/data/DitoNode;", "(Lcom/bytedance/locallife/dito/data/DitoPageInfo;Ljava/util/Map;Ljava/util/Map;)V", "getLayout", "()Ljava/util/Map;", "getNodes", "getPageInfo", "()Lcom/bytedance/locallife/dito/data/DitoPageInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hasRoot", "hashCode", "", "toString", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DitoPage implements Serializable {

    @SerializedName("layout")
    private final Map<String, List<String>> layout;

    @SerializedName("nodes")
    private final Map<String, DitoNode> nodes;

    @SerializedName("pageInfo")
    private final DitoPageInfo pageInfo;

    public DitoPage() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DitoPage copy$default(DitoPage r100, DitoPageInfo r101, Map r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.pageInfo;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.layout;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.nodes;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final DitoPageInfo component1() {
        return this.pageInfo;
    }

    public final Map<String, List<String>> component2() {
        return this.layout;
    }

    public final Map<String, DitoNode> component3() {
        return this.nodes;
    }

    public final DitoPage copy(DitoPageInfo r100, Map<String, ? extends List<String>> r101, Map<String, DitoNode> r102) {
        return new DitoPage(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoPage) == true) goto L8;
        return false;
    L8:
        DitoPage r101 = (DitoPage) r100;
        if (Intrinsics.areEqual(this.pageInfo, r101.pageInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.layout, r101.layout) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nodes, r101.nodes) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        DitoPageInfo r100 = this.pageInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, List<String>> r104 = this.layout;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, DitoNode> r107 = this.nodes;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final boolean hasRoot() {
        Map<String, List<String>> r100 = this.layout;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.containsKey(RootDescription.ROOT_ELEMENT) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "DitoPage(pageInfo=" + this.pageInfo + ", layout=" + this.layout + ", nodes=" + this.nodes + ')';
    }

    public final Map<String, List<String>> getLayout() {
        return this.layout;
    }

    public final Map<String, DitoNode> getNodes() {
        return this.nodes;
    }

    public final DitoPageInfo getPageInfo() {
        return this.pageInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DitoPage(DitoPageInfo r100, Map<String, ? extends List<String>> r101, Map<String, DitoNode> r102) {
        this.pageInfo = r100;
        this.layout = r101;
        this.nodes = r102;
    }

    public /* synthetic */ DitoPage(DitoPageInfo r100, Map r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
