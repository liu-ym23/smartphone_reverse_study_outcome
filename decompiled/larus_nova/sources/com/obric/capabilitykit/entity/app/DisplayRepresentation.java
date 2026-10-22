package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "", "image", "Landroid/net/Uri;", "title", "", "subtitle", "time", "", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;J)V", "getImage", "()Landroid/net/Uri;", "getSubtitle", "()Ljava/lang/String;", "getTime", "()J", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DisplayRepresentation {
    private final Uri image;
    private final String subtitle;
    private final long time;
    private final String title;

    public DisplayRepresentation(Uri r100, String r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r101, "title");
        this.image = r100;
        this.title = r101;
        this.subtitle = r102;
        this.time = r103;
    }

    public /* synthetic */ DisplayRepresentation(Uri r100, String r101, String r110, long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Uri r102 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        String r103 = null;
    L10:
        this(r102, r101, r103, r111);
        return;
    L9:
        r103 = r110;
        goto L10
    L5:
        r102 = r100;
        goto L7
    }

    public static /* synthetic */ DisplayRepresentation copy$default(DisplayRepresentation r100, Uri r101, String r102, String r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.image;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.title;
    L8:
        String r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.subtitle;
    L11:
        String r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.time;
    L14:
        Uri r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final Uri component1() {
        return this.image;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final long component4() {
        return this.time;
    }

    public final DisplayRepresentation copy(Uri r100, String r101, String r110, long r111) {
        Intrinsics.checkNotNullParameter(r101, "title");
        return new DisplayRepresentation(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DisplayRepresentation) == true) goto L8;
        return false;
    L8:
        DisplayRepresentation r101 = (DisplayRepresentation) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L18;
        return false;
    L18:
        if (this.time == r101.time) goto L20;
        return false;
    L20:
        return true;
    }

    public final Uri getImage() {
        return this.image;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Uri r100 = this.image;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.title.hashCode()) * 31;
        String r104 = this.subtitle;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        long r106 = this.time;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DisplayRepresentation(image=" + this.image + ", title=" + this.title + ", subtitle=" + this.subtitle + ", time=" + this.time + ')';
    }
}
