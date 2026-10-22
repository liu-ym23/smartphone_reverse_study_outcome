package ki4;

import android.os.Build;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaType f503628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f503629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f503630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<k0> f503631d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (this.f503628a == r101.f503628a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503629b, r101.f503629b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503630c, r101.f503630c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f503631d, r101.f503631d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f503628a.hashCode() * 31) + this.f503629b.hashCode()) * 31;
        j0 r101 = this.f503630c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<k0> r105 = this.f503631d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "QueryParam(mediaType=" + this.f503628a + ", columns=" + this.f503629b + ", selection=" + this.f503630c + ", sortOrders=" + this.f503631d + ')';
    }

    public final String b(d0 r110) {
        Intrinsics.checkNotNullParameter(r110, FilterData.FilterOptionItem.Type.RANGE);
        List<k0> r100 = this.f503631d;
        Integer r101 = null;
        if (r100 == null) goto L5;
        String r102 = CollectionsKt.joinToString$default(r100, null, null, null, 0, null, null, 63, null);
    L6:
        int r103 = r110.f503622b;
        int r111 = r110.f503621a;
        if (r102 != null) goto L11;
        if (r103 > 0) goto L11;
        if (r111 > 0) goto L11;
        return null;
    L11:
        boolean r104 = true;
        if (Build.VERSION.SDK_INT < 30) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L37;
        StringBuilder r106 = new StringBuilder();
        String r107 = "";
        if (r102 != null) goto L20;
        r102 = "";
    L20:
        r106.append(r102);
        StringBuilder r108 = new StringBuilder(" LIMIT ");
        if (r103 >= 0) goto L24;
        r103 = -1;
    L24:
        r108.append(r103);
        r106.append(r108.toString());
        Integer r112 = Integer.valueOf(r111);
        if (r112.intValue() > 0) goto L28;
        r104 = false;
    L28:
        if (r104 == false) goto L30;
        r101 = r112;
    L30:
        if (r101 == null) goto L35;
        String r113 = " OFFSET " + r101.intValue();
        if (r113 == null) goto L35;
        r107 = r113;
    L35:
        r106.append(r107);
        return r106.toString();
    L37:
        return r102;
    L14:
        r105 = false;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public static h0 a(h0 r100, j0 r101) {
        MediaType r102 = r100.f503628a;
        List<String> r103 = r100.f503629b;
        List<k0> r104 = r100.f503631d;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "mediaType");
        Intrinsics.checkNotNullParameter(r103, "columns");
        return new h0(r102, r103, r101, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(MediaType r100, List<String> r101, j0 r102, List<? extends k0> r103) {
        Intrinsics.checkNotNullParameter(r100, "mediaType");
        Intrinsics.checkNotNullParameter(r101, "columns");
        this.f503628a = r100;
        this.f503629b = r101;
        this.f503630c = r102;
        this.f503631d = r103;
    }
}
