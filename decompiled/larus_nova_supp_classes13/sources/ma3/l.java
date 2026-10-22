package ma3;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import java.util.Iterator;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(SsResponse r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator r6 = r5.headers().iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Object r1 = r6.next();
        if (StringsKt.equals(((Header) r1).getName(), "X-Tt-Logid", true) == false) goto L7;
    L12:
        Header r2 = (Header) r1;
        if (r2 != null) goto L15;
        return null;
    L15:
        return r2.getValue();
    L11:
        r1 = null;
        goto L12
    }
}
