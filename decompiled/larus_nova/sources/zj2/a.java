package zj2;

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

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f572446a = 0;

    static {
    }

    public static void a(Map r100) {
        r100.put("ecom_sdk_version", String.valueOf(44700));
    }

    @JvmStatic
    public static final String b(String r100, FilterNullArrayList r101, boolean r102, k.b r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        a(r104);
        boolean r105 = true;
        if ((!r101.isEmpty()) == false) goto L8;
        Iterator<E> r106 = r101.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        si2.k r107 = (si2.k) r106.next();
        r104.put(r107.f45605a, r107.f45606b);
    L8:
        LiveCommerceApi.f151849a.getClass();
        LiveCommerceApi r108 = LiveCommerceApi.a.a();
        if (r108 == null) goto L25;
        if (r102 == false) goto L14;
        if (r103 == null) goto L13;
        SsResponse<String> r109 = r108.postMultipart(r100, r104, r103).execute();
        z.a(r100, r109);
        String r110 = r109.body();
    L15:
        if (r110 != null) goto L17;
    L20:
        if (r105 == true) goto L23;
        return r110;
    L23:
        throw new IllegalArgumentException("response body is null or empty");
    L17:
        if (r110.length() == 0) goto L20;
        r105 = false;
        goto L20
    L13:
        SsResponse<String> r111 = r108.post(r100, r104).execute();
        z.a(r100, r111);
        r110 = r111.body();
        goto L15
    L14:
        SsResponse<String> r112 = r108.get(r100, r104).execute();
        z.a(r100, r112);
        r110 = r112.body();
        goto L15
    L25:
        throw new IllegalArgumentException("LiveCommerceApi INSTANCE is null");
    }

    @JvmStatic
    public static final SsResponse c(String r100, FilterNullArrayList r101, boolean r102, List r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        LinkedHashMap r104 = new LinkedHashMap();
        a(r104);
        if (r101 != null) goto L5;
    L10:
        LinkedHashMap r105 = new LinkedHashMap();
        if (r103 == null) goto L16;
        Iterator r106 = r103.iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        si2.k r107 = (si2.k) r106.next();
        r105.put(r107.f45605a, r107.f45606b);
    L16:
        LiveCommerceApi.f151849a.getClass();
        LiveCommerceApi r108 = LiveCommerceApi.a.a();
        if (r108 == null) goto L34;
        if (r102 == false) goto L24;
        if ((!r105.isEmpty()) == false) goto L22;
        Call<String> r109 = r108.postWithCustomHeader(r100, r104, r105);
    L27:
        SsResponse<String> r110 = r109.execute();
        Request r111 = r109.request();
        WeakHashMap<SsResponse<?>, Request> r112 = b.f572447a;
        Intrinsics.checkNotNullParameter(r110, "$this$request");
        if (r111 != null) goto L30;
        b.f572447a.remove(r110);
    L31:
        z.a(r100, r110);
        return r110;
    L30:
        b.f572447a.put(r110, r111);
        goto L31
    L22:
        r109 = r108.post(r100, r104);
        goto L27
    L24:
        if ((!r105.isEmpty()) == false) goto L26;
        r109 = r108.getWithCustomHeader(r100, r104, r105);
        goto L27
    L26:
        r109 = r108.get(r100, r104);
        goto L27
    L34:
        throw new IllegalArgumentException("LiveCommerceApi INSTANCE is null");
    L5:
        if ((!r101.isEmpty()) == false) goto L10;
        Iterator<E> r113 = r101.iterator();
    L8:
        if (r113.hasNext() == false) goto L10;
        si2.k r114 = (si2.k) r113.next();
        r104.put(r114.f45605a, r114.f45606b);
        goto L8
    }
}
