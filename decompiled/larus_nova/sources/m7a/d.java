package m7a;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends a {
    public final void d(JavaOnlyArray r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L6:
        if (r102 >= r100.size()) goto L14;
        JavaOnlyMap r103 = r100.getMap(r102);
        if (r103 == null) goto L13;
        if (r103.isEmpty() == true) goto L13;
        r101.add(r103);
    L13:
        r102 = r102 + 1;
        goto L6
    L14:
        a("attachedCells", r101);
    }

    public d(int r100, String r101) {
        super(r100, r101);
    }
}
