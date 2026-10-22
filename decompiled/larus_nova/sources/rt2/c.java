package rt2;

import com.bytedance.android.livesdk.unify.IUnifyApi;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements com.ss.ugc.live.sdk.msg.unify.network.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IUnifyApi f539174a;

    public c() {
        this.f539174a = (IUnifyApi) com.bytedance.android.live.network.c.b().e(IUnifyApi.class);
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.network.a
    public final com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> a(com.ss.ugc.live.sdk.msg.network.f r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        TypedByteArray r101 = new TypedByteArray(r100.f458304g, r100.a(), new String[0]);     // Catch: Exception -> L37
        HashMap r102 = new HashMap();     // Catch: Exception -> L37
        Map<String, String> r103 = r100.f458305h;     // Catch: Exception -> L37
        if (r103 == null) goto L6;
        r102.putAll(r103);     // Catch: Exception -> L37
    L6:
        IUnifyApi r104 = this.f539174a;     // Catch: Exception -> L37
        String r105 = r100.f458299b;     // Catch: Exception -> L37
        List<Header> r106 = b(r100.f458300c);     // Catch: Exception -> L37
        Map<String, String> r107 = r100.f458301d;     // Catch: Exception -> L37
        if (r107 != null) goto L9;
        r107 = new HashMap();     // Catch: Exception -> L37
    L9:
        Response r108 = r104.doPost(r105, r106, r107, r101).execute().raw();     // Catch: Exception -> L37
        if (r108.isSuccessful() == false) goto L23;
        TypedInput r109 = r108.getBody();     // Catch: Exception -> L37
        if (r109 == null) goto L22;
        byte[] r110 = ((TypedByteArray) r109).getBytes();     // Catch: Exception -> L37
        List<Header> r111 = r108.getHeaders();     // Catch: Exception -> L37
        if (r111 != null) goto L16;
        r111 = CollectionsKt.emptyList();     // Catch: Exception -> L37
    L16:
        List<Header> r112 = r111;     // Catch: Exception -> L37
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));     // Catch: Exception -> L37
        Iterator<T> r114 = r112.iterator();     // Catch: Exception -> L37
    L18:
        if (r114.hasNext() == false) goto L20;
        Header r115 = (Header) r114.next();     // Catch: Exception -> L37
        r113.add(new com.ss.ugc.live.sdk.msg.network.d(r115.getName(), r115.getValue()));     // Catch: Exception -> L37
        goto L18
    L20:
        com.ss.ugc.live.sdk.msg.network.g r116 = new com.ss.ugc.live.sdk.msg.network.g();     // Catch: Exception -> L37
        r116.f458311a = r108.getStatus();     // Catch: Exception -> L37
        r116.f458312b = r108.getReason();     // Catch: Exception -> L37
        r116.f458313c = r113;     // Catch: Exception -> L37
        r116.f458314d = r110;     // Catch: Exception -> L37
        int r117 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;     // Catch: Exception -> L37
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r116);
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");     // Catch: Exception -> L37
    L23:
        List<Header> r118 = r108.getHeaders();     // Catch: Exception -> L37
        if (r118 == null) goto L35;
        Iterator<T> r119 = r118.iterator();     // Catch: Exception -> L37
    L27:
        if (r119.hasNext() == false) goto L31;
        Object r120 = r119.next();     // Catch: Exception -> L37
        if (Intrinsics.areEqual(NetResponse.HEADER_KEY_LOG_ID, ((Header) r120).getName()) == false) goto L27;
    L32:
        Header r121 = (Header) r120;     // Catch: Exception -> L37
        if (r121 == null) goto L35;
        r121.getValue();     // Catch: Exception -> L37
        goto L35
    L31:
        r120 = null;
    L35:
        int r122 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;     // Catch: Exception -> L37
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception("response failed"));
    L37:
        e = move-exception;
        bc2.c.e("http post failed: " + e.getMessage());
        int r123 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception("http exception"));
    }

    public final List<Header> b(Map<String, String> r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, String> r103 = r102.next();
        r101.add(new Header(r103.getKey(), r103.getValue()));
        goto L7
    L9:
        r101.add(new Header(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG, "t=1"));
        return r101;
    L4:
        return new ArrayList();
    }
}
