package mp9;

import android.net.Uri;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f514726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f514728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f514729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<MediaTab, Integer> f514730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<MediaTab, List<c>> f514731f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f514726a == r101.f514726a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514727b, r101.f514727b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f514728c, r101.f514728c) == true) goto L18;
        return false;
    L18:
        if (this.f514729d == r101.f514729d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f514730e, r101.f514730e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f514731f, r101.f514731f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f514726a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f514727b.hashCode()) * 31;
        Uri r102 = this.f514728c;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return ((((((r101 + r103) * 31) + this.f514729d) * 31) + this.f514730e.hashCode()) * 31) + this.f514731f.hashCode();
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public final String toString() {
        return "MediaFolder(id=" + this.f514726a + ", name=" + this.f514727b + ", coverUri=" + this.f514728c + ", mediaCount=" + this.f514729d + ", mediaCountMap=" + this.f514730e + ", mediaItemsMap=" + this.f514731f + ')';
    }

    public static b a(b r110, int r111, Map r112, Map r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        long r100 = r110.f514726a;
    L6:
        long r101 = r100;
        if ((r114 & 2) == 0) goto L9;
        String r102 = r110.f514727b;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Uri r103 = r110.f514728c;
    L15:
        if ((r114 & 8) == 0) goto L17;
        r111 = r110.f514729d;
    L17:
        int r104 = r111;
        if ((r114 & 16) == 0) goto L20;
        r112 = r110.f514730e;
    L20:
        Map r105 = r112;
        if ((r114 & 32) == 0) goto L23;
        r113 = r110.f514731f;
    L23:
        Map r106 = r113;
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r105, "mediaCountMap");
        Intrinsics.checkNotNullParameter(r106, "mediaItemsMap");
        return new b(r101, r102, r103, r104, r105, r106);
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r100 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(long r100, String r101, Uri r102, int r103, Map<MediaTab, Integer> r104, Map<MediaTab, ? extends List<c>> r105) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r104, "mediaCountMap");
        Intrinsics.checkNotNullParameter(r105, "mediaItemsMap");
        this.f514726a = r100;
        this.f514727b = r101;
        this.f514728c = r102;
        this.f514729d = r103;
        this.f514730e = r104;
        this.f514731f = r105;
    }
}
