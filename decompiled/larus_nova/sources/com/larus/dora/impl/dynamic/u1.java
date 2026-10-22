package com.larus.dora.impl.dynamic;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/ImageInfo;", "", "lightUrl", "", "", "darkUrl", "<init>", "([Ljava/lang/String;[Ljava/lang/String;)V", "getLightUrl", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getDarkUrl", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "([Ljava/lang/String;[Ljava/lang/String;)Lcom/larus/dora/impl/dynamic/ImageInfo;", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u1 {

    @SerializedName("dark_url")
    private final String[] darkUrl;

    @SerializedName("light_url")
    private final String[] lightUrl;

    public final String toString() {
        return "ImageInfo(lightUrl=" + Arrays.toString(this.lightUrl) + ", darkUrl=" + Arrays.toString(this.darkUrl) + ')';
    }

    public final int hashCode() {
        String[] r100 = this.lightUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        String[] r104 = this.darkUrl;
        if (r104 == null) goto L10;
        r101 = Arrays.hashCode(r104);
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public u1() {
        this.lightUrl = null;
        this.darkUrl = null;
    }

    public final String[] a() {
        return this.darkUrl;
    }

    public final String[] b() {
        return this.lightUrl;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(u1.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.dora.impl.dynamic.ImageInfo");
        u1 r102 = (u1) r100;
        String[] r103 = this.lightUrl;
        if (r103 == null) goto L21;
        String[] r104 = r102.lightUrl;
        if (r104 != null) goto L18;
        return false;
    L18:
        if (Arrays.equals(r103, r104) == true) goto L23;
        return false;
    L23:
        String[] r105 = this.darkUrl;
        if (r105 == null) goto L32;
        String[] r106 = r102.darkUrl;
        if (r106 != null) goto L29;
        return false;
    L29:
        if (Arrays.equals(r105, r106) == true) goto L34;
        return false;
    L34:
        return true;
    L32:
        if (r102.darkUrl == null) goto L34;
        return false;
    L21:
        if (r102.lightUrl == null) goto L23;
        return false;
    L8:
        r101 = null;
        goto L10
    }
}
