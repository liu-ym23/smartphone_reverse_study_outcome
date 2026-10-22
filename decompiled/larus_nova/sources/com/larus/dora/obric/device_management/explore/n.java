package com.larus.dora.obric.device_management.explore;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003J[\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricExploreItem;", "", "condition", "Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "tag", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "subtitle", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "action", "Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslCondition;ZLcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslAction;Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;)V", "getCondition", "()Lcom/larus/dora/impl/dynamic/dsl/DslCondition;", "getTag", "()Z", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getSubtitle", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getAction", "()Lcom/larus/dora/impl/dynamic/dsl/DslAction;", "getPageInfo", "()Lcom/larus/dora/impl/dynamic/dsl/DslFunctionIntroductionPageInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n {

    @SerializedName("action")
    private final c59.b action;

    @SerializedName("condition")
    private final c59.j condition;

    @SerializedName("image_link")
    private final c59.u imageLink;

    @SerializedName("page_info")
    private final c59.q pageInfo;

    @SerializedName("subtitle")
    private final c59.t subtitle;

    @SerializedName("tag")
    private final boolean tag;

    @SerializedName("title")
    private final c59.t title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.condition, r101.condition) == true) goto L12;
        return false;
    L12:
        if (this.tag == r101.tag) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageLink, r101.imageLink) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pageInfo, r101.pageInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        c59.j r100 = this.condition;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.tag == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        c59.t r106 = this.title;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        c59.t r109 = this.subtitle;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        c59.u r112 = this.imageLink;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        c59.b r115 = this.action;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        c59.q r118 = this.pageInfo;
        if (r118 == null) goto L31;
        r101 = r118.hashCode();
    L31:
        return r117 + r101;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricExploreItem(condition=" + this.condition + ", tag=" + this.tag + ", title=" + this.title + ", subtitle=" + this.subtitle + ", imageLink=" + this.imageLink + ", action=" + this.action + ", pageInfo=" + this.pageInfo + ')';
    }

    public n() {
        this.condition = null;
        this.tag = false;
        this.title = null;
        this.subtitle = null;
        this.imageLink = null;
        this.action = null;
        this.pageInfo = null;
    }

    public final c59.b a() {
        return this.action;
    }

    public final c59.j b() {
        return this.condition;
    }

    public final c59.u c() {
        return this.imageLink;
    }

    public final c59.q d() {
        return this.pageInfo;
    }

    public final c59.t e() {
        return this.subtitle;
    }

    public final boolean f() {
        return this.tag;
    }

    public final c59.t g() {
        return this.title;
    }
}
