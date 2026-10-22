package k4a;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.ss.android.token.f;
import com.ss.android.token.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends qx5.a {
    public a() {
    }

    @Override // qx5.a
    public final Request processBeforeSendRequest(Request r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super.processBeforeSendRequest(r100);
        Request.Builder r101 = r100.newBuilder();
        ArrayList r102 = new ArrayList();
        if (r100.getHeaders() == null) goto L5;
        r102.addAll(r100.getHeaders());
    L5:
        Map<String, String> r103 = null;
        f r104 = p.a(r100.getUrl(), null, null, false);
        if (r104 == null) goto L9;
        r103 = r104.f449733a;
    L9:
        Intrinsics.checkNotNull(r103);
        Iterator r105 = ((HashMap) r103).entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        Map.Entry r106 = (Map.Entry) r105.next();
        r102.add(new Header((String) r106.getKey(), (String) r106.getValue()));
        goto L11
    L13:
        r101.headers(r102);
        return r101.build();
    }
}
