package cxc;

import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static String a(List<Scope> r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.size() <= 0) goto L15;
        StringBuilder r101 = new StringBuilder();
        Iterator<Scope> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.append(r102.next().f276503a);
        r101.append(" ");
        goto L8
    L10:
        exc.e.c("HnIDCloudServiceUtils", "scopesToStr scopes : " + r101.toString().trim());
        return r101.toString().trim();
    L15:
        return "";
    }
}
