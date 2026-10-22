package fi3;

import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f477329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f477330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VideoModel f477332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f477333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f477334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f477335g;

    public static final class a {
    }

    static {
    }

    public v() {
        this(null, 0, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L20;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f477329a, r101.f477329a) == true) goto L8;
        return false;
    L8:
        if (this.f477330b == r101.f477330b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477331c, r101.f477331c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477332d, r101.f477332d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f477333e, r101.f477333e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f477334f, r101.f477334f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f477335g, r101.f477335g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.f477329a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f477330b) * 31;
        String r104 = this.f477331c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        VideoModel r107 = this.f477332d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f477333e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f477334f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f477335g;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPOpenCommentItemPreviewParam(imageUrlArray=" + this.f477329a + ", imageIndex=" + this.f477330b + ", mediaType=" + this.f477331c + ", video=" + this.f477332d + ", commentRank=" + this.f477333e + ", buyerShowCount=" + this.f477334f + ", commentId=" + this.f477335g + ")";
    }

    public v(List r100, int r101, String r102, VideoModel r103, Long r104, Long r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = 0L;
    L20:
        Intrinsics.checkNotNullParameter(r100, "imageUrlArray");
        this.f477329a = r100;
        this.f477330b = r101;
        this.f477331c = r102;
        this.f477332d = r103;
        this.f477333e = r104;
        this.f477334f = null;
        this.f477335g = r105;
    }
}
