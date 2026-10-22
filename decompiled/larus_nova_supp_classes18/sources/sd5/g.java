package sd5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.route.RouteBean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements e {
    public g() {
    }

    @Override // sd5.e
    public final RouteBean a(Document r11) {
        String r0 = r11.O;
        String r2 = "";
        if (TextUtils.isEmpty(r0) == false) goto L23;
        String r1 = "";
    L14:
        String r3 = r11.P;
        if (TextUtils.isEmpty(r2) == false) goto L17;
    L18:
        int r4 = oj5.d.b;
        oj5.d r5 = oj5.d.a.a(r3);
        if (r5 == null) goto L21;
        r2 = r5.d();
        r1 = r5.e();
    L21:
        String r7 = r2;
        String r6 = r11.G1;
        int r8 = r11.y1;
        String r9 = r11.d;
        WikiRouteBean r10 = new WikiRouteBean(r6, r8, r9, r7, r1);
        r10.f = t0.g(eu5.b.a, r11);
        return r10;
    L17:
        if (TextUtils.isEmpty(r1) == false) goto L21;
    L23:
        JSONObject r12 = new JSONObject(r0);     // Catch: Exception -> L9
        String r13 = r12.optString("wiki_space_id");     // Catch: Exception -> L9
        r2 = r12.optString("wiki_space_name");     // Catch: Exception -> L7
    L12:
        String r14 = r2;
        r2 = r13;
        r1 = r14;
    L7:
        Exception e = e;
    L11:
        tt5.a.e("WikiRouteBeanProducer", "parse wikiSpaceId err.", e, false);
    L9:
        e = move-exception;
        e = e;
        r13 = "";
        goto L11
    }
}
