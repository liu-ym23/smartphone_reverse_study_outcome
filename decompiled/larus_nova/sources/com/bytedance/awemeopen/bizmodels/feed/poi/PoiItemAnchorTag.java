package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B9\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0000H\u0096\u0002J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\""}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiItemAnchorTag;", "Ljava/io/Serializable;", "", "content", "", "type", "", "priority", "style", "shouldShow", "", "(Ljava/lang/String;IIIZ)V", "getContent", "()Ljava/lang/String;", "getPriority", "()I", "getShouldShow", "()Z", "setShouldShow", "(Z)V", "getStyle", "getType", "compareTo", "other", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "hashCode", "toString", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PoiItemAnchorTag implements Serializable, Comparable<PoiItemAnchorTag> {

    @SerializedName("content")
    private final String content;

    @SerializedName("priority")
    private final int priority;
    private boolean shouldShow;

    @SerializedName("style")
    private final int style;

    @SerializedName("type")
    private final int type;

    public PoiItemAnchorTag() {
        this(null, 0, 0, 0, false, 31, null);
    }

    public static /* synthetic */ PoiItemAnchorTag copy$default(PoiItemAnchorTag r100, String r101, int r102, int r103, int r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.priority;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.style;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.shouldShow;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.priority;
    }

    public final int component4() {
        return this.style;
    }

    public final boolean component5() {
        return this.shouldShow;
    }

    public final PoiItemAnchorTag copy(String r100, int r101, int r110, int r111, boolean r112) {
        return new PoiItemAnchorTag(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiItemAnchorTag) == true) goto L8;
        return false;
    L8:
        PoiItemAnchorTag r101 = (PoiItemAnchorTag) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (this.priority == r101.priority) goto L18;
        return false;
    L18:
        if (this.style == r101.style) goto L21;
        return false;
    L21:
        if (this.shouldShow == r101.shouldShow) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.content;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((r101 * 31) + this.type) * 31) + this.priority) * 31) + this.style) * 31;
        boolean r103 = this.shouldShow;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PoiItemAnchorTag(content=" + this.content + ", type=" + this.type + ", priority=" + this.priority + ", style=" + this.style + ", shouldShow=" + this.shouldShow + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getShouldShow() {
        return this.shouldShow;
    }

    public final int getStyle() {
        return this.style;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PoiItemAnchorTag r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (this.priority <= r100.priority) goto L5;
        return -1;
    L5:
        return 1;
    }

    public final void setShouldShow(boolean r100) {
        this.shouldShow = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(PoiItemAnchorTag r100) {
        return compareTo2(r100);
    }

    public PoiItemAnchorTag(String r100, int r101, int r102, int r103, boolean r104) {
        this.content = r100;
        this.type = r101;
        this.priority = r102;
        this.style = r103;
        this.shouldShow = r104;
    }

    public /* synthetic */ PoiItemAnchorTag(String r100, int r101, int r102, int r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = "";
    L5:
        int r106 = 0;
        if ((r105 & 2) == 0) goto L8;
        int r111 = 0;
    L10:
        if ((r105 & 4) == 0) goto L12;
        int r107 = 0;
    L14:
        if ((r105 & 8) != 0) goto L18;
        r106 = r103;
    L18:
        if ((r105 & 16) == 0) goto L20;
        boolean r108 = true;
    L21:
        this(r100, r111, r107, r106, r108);
        return;
    L20:
        r108 = r104;
        goto L21
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
