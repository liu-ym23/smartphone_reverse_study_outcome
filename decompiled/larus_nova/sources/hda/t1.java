package hda;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class t1 {
    public static final List<j0> a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "contentTime");
        j0[] r102 = new j0[2];
        j0 r103 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        j0 r104 = new j0("内容时间", r100);
    L9:
        r102[0] = r104;
        if (r101 != null) goto L12;
    L17:
        r102[1] = r103;
        return CollectionsKt.listOfNotNull(r102);
    L12:
        if ((!StringsKt.isBlank(r101)) == true) goto L15;
        r101 = null;
    L15:
        if (r101 == null) goto L17;
        r103 = new j0("来源", r101);
        goto L17
    L8:
        r104 = null;
        goto L9
    }
}
