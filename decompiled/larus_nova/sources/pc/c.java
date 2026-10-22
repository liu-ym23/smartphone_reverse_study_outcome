package pc;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final boolean a(List<String> r100, List<String> r101) {
        if (r100.size() == r101.size()) goto L5;
        return false;
    L5:
        Iterator<String> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        if (r101.contains(r102.next()) == true) goto L7;
        return false;
    L11:
        return true;
    }
}
