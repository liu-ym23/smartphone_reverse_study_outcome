package hu5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    public interface a<T> {
        boolean accept(T r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> a(List<T> r100, a<T> r101) {
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r100).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (r101.accept(r104) == false) goto L4;
        r103.remove();
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }
}
