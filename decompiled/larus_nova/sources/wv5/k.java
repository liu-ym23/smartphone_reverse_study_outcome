package wv5;

import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {
    public static final List<FlowSearchData> a(List<FlowSearchData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L27;
        Object r103 = r102.next();
        int r104 = ((FlowSearchData) r103).f243280b;
        boolean r105 = true;
        if (r104 != 1) goto L8;
    L25:
        if (r105 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        if (r104 == 2) goto L25;
        if (r104 == 4) goto L25;
        if (r104 == 3) goto L25;
        if (r104 == 118) goto L25;
        if (r104 == 103) goto L25;
        if (r104 == 114) goto L25;
        if (r104 == 119) goto L25;
        if (r104 == 120) goto L25;
        r105 = false;
        goto L25
    L27:
        return r101;
    }
}
