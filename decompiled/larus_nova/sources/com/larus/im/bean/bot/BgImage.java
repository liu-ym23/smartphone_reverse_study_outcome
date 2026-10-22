package com.larus.im.bean.bot;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/larus/im/bean/bot/BgImage;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "bgImgUri", "", "bgImgUrl", "bgImgColor", "bgImageInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;)V", "bgImgOpen", "", "getBgImgOpen", "()Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgImage implements Serializable {
    public final BgImageInfo bgImageInfo;
    public final String bgImgColor;
    public final String bgImgUri;
    public final String bgImgUrl;

    public BgImage() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ BgImage copy$default(BgImage r100, String r101, String r102, String r103, BgImageInfo r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bgImgUri;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.bgImgUrl;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.bgImgColor;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bgImageInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.bgImgUri;
    }

    public final String component2() {
        return this.bgImgUrl;
    }

    public final String component3() {
        return this.bgImgColor;
    }

    public final BgImageInfo component4() {
        return this.bgImageInfo;
    }

    public final BgImage copy(String r100, String r101, String r102, BgImageInfo r103) {
        return new BgImage(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BgImage) == true) goto L8;
        return false;
    L8:
        BgImage r101 = (BgImage) r100;
        if (Intrinsics.areEqual(this.bgImgUri, r101.bgImgUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgImgUrl, r101.bgImgUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgImgColor, r101.bgImgColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgImageInfo, r101.bgImageInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.bgImgUri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bgImgUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgImgColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        BgImageInfo r110 = this.bgImageInfo;
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

    public String toString() {
        return "BgImage(bgImgUri=" + this.bgImgUri + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", bgImageInfo=" + this.bgImageInfo + ')';
    }

    public final Boolean getBgImgOpen() {
        BgImageInfo r100 = this.bgImageInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBgImgOpen();
    }

    public BgImage(String r100, String r101, String r102, BgImageInfo r103) {
        this.bgImgUri = r100;
        this.bgImgUrl = r101;
        this.bgImgColor = r102;
        this.bgImageInfo = r103;
    }

    public /* synthetic */ BgImage(String r100, String r101, String r102, BgImageInfo r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
