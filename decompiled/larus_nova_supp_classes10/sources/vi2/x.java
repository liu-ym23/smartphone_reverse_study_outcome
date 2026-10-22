package vi2;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.network.response.ECEditCartResponse;
import com.bytedance.android.livesdk.livecommerce.room.host.network.LiveCommerceApi;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x implements h.f<ECEditCartResponse> {
    public final /* synthetic */ String a;
    public final /* synthetic */ List b;
    public final /* synthetic */ JSONObject c;

    @Override // vi2.h.f
    public final wi2.a<ECEditCartResponse> execute() throws Exception {
        String r0 = this.a;
        boolean r1 = false;
        String r3 = "";
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        String r4 = "https://ec.snssdk.com" + this.a;
    L11:
        Map<String, String> r5 = com.bytedance.android.livesdk.livecommerce.utils.y.a(this.b);
        List r6 = this.b;
        JSONObject r7 = this.c;
        com.bytedance.android.livesdk.livecommerce.network.hook.b.a(r4, r6);
        com.bytedance.android.livesdk.livecommerce.utils.z.b(r4, r6, "post");
        int r8 = zj2.a.a;
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r6, "paramList");
        Intrinsics.checkNotNullParameter(r7, "paramBody");
        LinkedHashMap r9 = new LinkedHashMap();
        zj2.a.a(r9);
        if ((!r6.isEmpty()) == false) goto L17;
        Iterator r10 = r6.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        si2.k r11 = (si2.k) r10.next();
        r9.put(((com.bytedance.android.ec.core.utils.i) r11).a, ((com.bytedance.android.ec.core.utils.i) r11).b);
    L17:
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator<String> r13 = r7.keys();
        if (r13 != null) goto L20;
    L22:
        Iterator r14 = r9.entrySet().iterator();
    L24:
        if (r14.hasNext() == false) goto L32;
        Map.Entry r15 = (Map.Entry) r14.next();
    L30:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L24
    L27:
        if (r12.contains(r15.getKey()) == true) goto L24;
        r7.put((String) r15.getKey(), r15.getValue());     // Catch: JSONException -> L30
        goto L24
    L32:
        String r16 = r7.toString();
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter("application/json", "contentType");
        LiveCommerceApi.a.getClass();
        LiveCommerceApi r17 = LiveCommerceApi.a.a();
        if (r17 == null) goto L49;
        MediaType r18 = MediaType.parse("application/json");
        if (r16 == null) goto L38;
        r3 = r16;
    L38:
        SsResponse r19 = r17.postBody(r4, RequestBody.create(r18, r3)).execute();
        com.bytedance.android.livesdk.livecommerce.utils.z.a(r4, r19);
        String r20 = (String) r19.body();
        if (r20 != null) goto L41;
    L42:
        r1 = true;
    L43:
        if (r1 == true) goto L47;
        int r21 = com.bytedance.android.livesdk.livecommerce.utils.m0.a;
        return h.f((ECEditCartResponse) GsonProtectorUtils.fromJson(com.bytedance.android.livesdk.livecommerce.utils.m0.a.a, r20, ECEditCartResponse.class), r5, null);
    L47:
        throw new IllegalArgumentException("response body is null or empty");
    L41:
        if (r20.length() != 0) goto L43;
    L49:
        throw new IllegalArgumentException("LiveCommerceApi INSTANCE is null");
    L20:
        if (r13.hasNext() == false) goto L22;
        r12.add(r13.next());
        goto L20
    L10:
        r4 = "https://ec.snssdk.com/cart/edit_new";
        goto L11
    L5:
        if (r0.trim() == "") goto L7;
        r2 = true;
        goto L8
    }

    public x(String r1, List r2, JSONObject r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
