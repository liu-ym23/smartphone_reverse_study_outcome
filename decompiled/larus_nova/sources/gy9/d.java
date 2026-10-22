package gy9;

import com.larus.bmhome.actionbar.model.g1;
import com.larus.platform.api.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public static final g1 a(Image r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new g1(null, r100.f364791a, Integer.valueOf((int) r100.f364793c), Integer.valueOf((int) r100.f364794d), 17);
    }

    public static final Image b(g1 r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.f295156b;
        String r101 = null;
        Integer r102 = r110.f295157c;
        long r103 = 0;
        if (r102 == null) goto L5;
        long r104 = r102.intValue();
    L6:
        Integer r111 = r110.f295158d;
        if (r111 == null) goto L10;
        r103 = r111.intValue();
    L10:
        return new Image(r100, r101, r104, r103, 18);
    L5:
        r104 = 0;
        goto L6
    }
}
