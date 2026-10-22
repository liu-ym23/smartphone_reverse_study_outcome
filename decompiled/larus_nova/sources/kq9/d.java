package kq9;

import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSelectionMediaType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AlbumSelectItem f505616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AlbumSelectionMediaType f505617b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f505616a, r101.f505616a) == true) goto L12;
        return false;
    L12:
        if (this.f505617b == r101.f505617b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f505616a.hashCode() * 31) + this.f505617b.hashCode();
    }

    public final String toString() {
        return "AlbumSelectionEventItem(albumItem=" + this.f505616a + ", mediaType=" + this.f505617b + ')';
    }

    public d(AlbumSelectItem r100, AlbumSelectionMediaType r101) {
        Intrinsics.checkNotNullParameter(r100, "albumItem");
        Intrinsics.checkNotNullParameter(r101, "mediaType");
        this.f505616a = r100;
        this.f505617b = r101;
    }
}
