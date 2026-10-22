package zj2;

import com.bytedance.android.ec.core.utils.i;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.room.host.network.LiveCommerceApi;
import com.bytedance.android.livesdk.livecommerce.utils.z;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r2) {
        r2.put("ecom_sdk_version", String.valueOf(44700));
    }

    @JvmStatic
    public static final String b(String r4, FilterNullArrayList r5, boolean r6, k.b r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        a(r0);
        boolean r2 = true;
        if ((!r5.isEmpty()) == false) goto L8;
        Iterator<E> r8 = r5.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        si2.k r1 = (si2.k) r8.next();
        r0.put(((i) r1).a, ((i) r1).b);
    L8:
        LiveCommerceApi.a.getClass();
        LiveCommerceApi r9 = LiveCommerceApi.a.a();
        if (r9 == null) goto L25;
        if (r6 == false) goto L14;
        if (r7 == null) goto L13;
        SsResponse r10 = r9.postMultipart(r4, r0, r7).execute();
        z.a(r4, r10);
        String r11 = (String) r10.body();
    L15:
        if (r11 != null) goto L17;
    L20:
        if (r2 == true) goto L23;
        return r11;
    L23:
        throw new IllegalArgumentException("response body is null or empty");
    L17:
        if (r11.length() == 0) goto L20;
        r2 = false;
        goto L20
    L13:
        SsResponse r12 = r9.post(r4, r0).execute();
        z.a(r4, r12);
        r11 = (String) r12.body();
        goto L15
    L14:
        SsResponse r13 = r9.get(r4, r0).execute();
        z.a(r4, r13);
        r11 = (String) r13.body();
        goto L15
    L25:
        throw new IllegalArgumentException("LiveCommerceApi INSTANCE is null");
    }

    @JvmStatic
    public static final SsResponse c(String r3, FilterNullArrayList r4, boolean r5, List r6) {
        Intrinsics.checkNotNullParameter(r3, "url");
        LinkedHashMap r0 = new LinkedHashMap();
        a(r0);
        if (r4 != null) goto L5;
    L10:
        LinkedHashMap r7 = new LinkedHashMap();
        if (r6 == null) goto L16;
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        si2.k r1 = (si2.k) r8.next();
        r7.put(((i) r1).a, ((i) r1).b);
    L16:
        LiveCommerceApi.a.getClass();
        LiveCommerceApi r9 = LiveCommerceApi.a.a();
        if (r9 == null) goto L34;
        if (r5 == false) goto L24;
        if ((!r7.isEmpty()) == false) goto L22;
        Call<String> r10 = r9.postWithCustomHeader(r3, r0, r7);
    L27:
        SsResponse<?> r11 = r10.execute();
        Request r12 = r10.request();
        WeakHashMap<SsResponse<?>, Request> r13 = b.a;
        Intrinsics.checkNotNullParameter(r11, "$this$request");
        if (r12 != null) goto L30;
        b.a.remove(r11);
    L31:
        z.a(r3, r11);
        return r11;
    L30:
        b.a.put(r11, r12);
        goto L31
    L22:
        r10 = r9.post(r3, r0);
        goto L27
    L24:
        if ((!r7.isEmpty()) == false) goto L26;
        r10 = r9.getWithCustomHeader(r3, r0, r7);
        goto L27
    L26:
        r10 = r9.get(r3, r0);
        goto L27
    L34:
        throw new IllegalArgumentException("LiveCommerceApi INSTANCE is null");
    L5:
        if ((!r4.isEmpty()) == false) goto L10;
        Iterator<E> r14 = r4.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        si2.k r2 = (si2.k) r14.next();
        r0.put(((i) r2).a, ((i) r2).b);
        goto L8
    }
}
