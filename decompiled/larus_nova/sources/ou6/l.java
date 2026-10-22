package ou6;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {
    public static final Uri a(Uri r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "keys");
        Set<String> r102 = UriProtector.getQueryParameterNames(r100);
        if (r102 != null) goto L5;
        return r100;
    L5:
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if ((!r101.contains((String) r106)) == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        Iterator r107 = r104.iterator();
    L13:
        if (r107.hasNext() == false) goto L16;
        String r108 = (String) r107.next();
        r103.appendQueryParameter(r108, UriProtector.getQueryParameter(r100, r108));
        goto L13
    L16:
        return r103.build();
    }

    public static final Uri b(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "newHost");
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        if (r100.getPort() == (-1)) goto L5;
        String r103 = ":" + r100.getPort();
    L6:
        r102.append(r103);
        return r100.buildUpon().authority(r102.toString()).build();
    L5:
        r103 = "";
        goto L6
    }
}
