package com.larus.home.impl.main.side_bar.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/Icon;", "", "type", "", "lightUri", "lightUrl", "darkUri", "darkUrl", "localResId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getType", "()Ljava/lang/String;", "getLightUri", "getLightUrl", "getDarkUri", "getDarkUrl", "getLocalResId", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f344505a;

    @SerializedName("dark_uri")
    private final String darkUri;

    @SerializedName("dark_url")
    private final String darkUrl;

    @SerializedName("light_uri")
    private final String lightUri;

    @SerializedName("light_url")
    private final String lightUrl;

    @SerializedName("type")
    private final String type;

    public i() {
        this(null, null, null, null, null, 0, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lightUri, r101.lightUri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lightUrl, r101.lightUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.darkUri, r101.darkUri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkUrl, r101.darkUrl) == true) goto L24;
        return false;
    L24:
        if (this.f344505a == r101.f344505a) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.lightUri;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lightUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.darkUri;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.darkUrl;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return ((r112 + r101) * 31) + this.f344505a;
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
        return "Icon(type=" + this.type + ", lightUri=" + this.lightUri + ", lightUrl=" + this.lightUrl + ", darkUri=" + this.darkUri + ", darkUrl=" + this.darkUrl + ", localResId=" + this.f344505a + ')';
    }

    public final String b() {
        return this.darkUrl;
    }

    public final String c() {
        return this.lightUrl;
    }

    public final String getType() {
        return this.type;
    }

    public static i a(i r100, String r101, String r102) {
        return new i(r100.type, r100.lightUri, r101, r100.darkUri, r102, r100.f344505a);
    }

    public i(String r100, String r101, String r102, String r103, String r104, int r105) {
        this.type = r100;
        this.lightUri = r101;
        this.lightUrl = r102;
        this.darkUri = r103;
        this.darkUrl = r104;
        this.f344505a = r105;
    }

    public /* synthetic */ i(String r100, String r101, String r110, String r111, String r112, int r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r100 = IconTypeEnum.ICON_IMAGE.getType();
    L5:
        String r102 = r100;
        if ((r114 & 2) == 0) goto L8;
        String r103 = null;
    L10:
        if ((r114 & 4) == 0) goto L12;
        String r104 = null;
    L14:
        if ((r114 & 8) == 0) goto L16;
        String r105 = null;
    L18:
        if ((r114 & 16) == 0) goto L20;
        String r106 = null;
    L22:
        if ((r114 & 32) == 0) goto L24;
        int r107 = 0;
    L25:
        this(r102, r103, r104, r105, r106, r107);
        return;
    L24:
        r107 = r113;
        goto L25
    L20:
        r106 = r112;
        goto L22
    L16:
        r105 = r111;
        goto L18
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }
}
