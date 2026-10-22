package j93;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(k r2) {
        Iterable r3 = r2.c;
        if (r3 != null) goto L5;
        r3 = CollectionsKt.emptyList();
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        List r1 = ((i) r4.next()).b();
        if (r1 != null) goto L11;
        r1 = CollectionsKt.emptyList();
    L11:
        CollectionsKt.addAll(r0, r1);
        goto L7
    L12:
        return r0;
    }

    public static boolean b(Uri r3) {
        String r0 = UriProtector.getQueryParameter(r3, "embedded_mode");
        if (r0 == null) goto L12;
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L13;
        int r2 = r1.intValue();
        if (r3.getBooleanQueryParameter("enable_lynx_config", false) == true) goto L9;
        return false;
    L9:
        if ((r2 & 1) == 0) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
    }
}
