package wa8;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes25.dex */
public final class k1 {
    public static final String a(com.larus.bmhome.actionbar.model.z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.f295606b);
        r101.append(Typography.amp);
        com.larus.bmhome.actionbar.model.r r102 = r100.f295621q;
        if (r102 == null) goto L7;
        Integer r103 = r102.f295408a;
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        r101.append(r104);
        return r101.toString();
    L7:
        r104 = 0;
        goto L8
    }

    public static final boolean b(com.larus.bmhome.actionbar.model.z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.larus.bmhome.actionbar.model.d r101 = r100.f295604J;
        if (r101 == null) goto L5;
        Integer r102 = r101.f295054a;
    L6:
        if (r102 == null) goto L13;
        Integer r103 = r101.f295054a;
        if (r103 != null) goto L11;
    L12:
        return true;
    L11:
        if (r103.intValue() != 0) goto L12;
    L13:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean c(com.larus.bmhome.actionbar.model.z0 r100) {
        if (r100 == null) goto L4;
        String r101 = r100.f295606b;
    L6:
        return Intrinsics.areEqual(r101, "coco_spring_pocket");
    L4:
        r101 = null;
        goto L6
    }
}
