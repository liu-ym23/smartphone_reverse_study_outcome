package com.bytedance.locallife.groupon.struct.bubble;

import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/bubble/RedDotAnimationStruct;", "", "image", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "title", "", "liveSeconds", "", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;Ljava/lang/String;I)V", "getImage", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getLiveSeconds", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RedDotAnimationStruct {

    @SerializedName("image")
    private final UrlModel image;

    @SerializedName("live_seconds")
    private final int liveSeconds;

    @SerializedName("title")
    private final String title;

    public RedDotAnimationStruct() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ RedDotAnimationStruct copy$default(RedDotAnimationStruct r100, UrlModel r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.image;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.liveSeconds;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final UrlModel component1() {
        return this.image;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.liveSeconds;
    }

    public final RedDotAnimationStruct copy(UrlModel r100, String r101, int r102) {
        return new RedDotAnimationStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RedDotAnimationStruct) == true) goto L8;
        return false;
    L8:
        RedDotAnimationStruct r101 = (RedDotAnimationStruct) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (this.liveSeconds == r101.liveSeconds) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        UrlModel r100 = this.image;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.liveSeconds;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RedDotAnimationStruct(image=" + this.image + ", title=" + this.title + ", liveSeconds=" + this.liveSeconds + ')';
    }

    public final UrlModel getImage() {
        return this.image;
    }

    public final int getLiveSeconds() {
        return this.liveSeconds;
    }

    public final String getTitle() {
        return this.title;
    }

    public RedDotAnimationStruct(UrlModel r100, String r101, int r102) {
        this.image = r100;
        this.title = r101;
        this.liveSeconds = r102;
    }

    public /* synthetic */ RedDotAnimationStruct(UrlModel r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
