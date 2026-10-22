package im2;

import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.message.config.depend.IMessageApi;
import com.bytedance.android.livesdk.utils.a4;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.live.sdk.msg.network.HttpException;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements com.ss.ugc.live.sdk.msg.network.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMessageApi f490475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h80.d<Long> f490476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h80.d<String> f490477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h80.d<Map<String, String>> f490478d;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f490479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.f f490480b;

        public a(h r100, com.ss.ugc.live.sdk.msg.network.f r101) {
            this.f490479a = r100;
            this.f490480b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            SsResponse r101 = (SsResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "ssResp");
            Response r102 = r101.raw();
            if (r102.isSuccessful() == false) goto L19;
            TypedInput r103 = r102.getBody();
            if (r103 == null) goto L18;
            byte[] r104 = ((TypedByteArray) r103).getBytes();
            List<Header> r105 = r102.getHeaders();
            if (r105 != null) goto L9;
            r105 = CollectionsKt.emptyList();
        L9:
            List<Header> r106 = r105;
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
            Iterator<T> r108 = r106.iterator();
        L11:
            if (r108.hasNext() == false) goto L13;
            Header r109 = (Header) r108.next();
            r107.add(new com.ss.ugc.live.sdk.msg.network.d(r109.getName(), r109.getValue()));
            goto L11
        L13:
            com.ss.ugc.live.sdk.msg.network.g r110 = new com.ss.ugc.live.sdk.msg.network.g();
            r110.f458311a = r102.getStatus();
            r110.f458312b = r102.getReason();
            r110.f458313c = r107;
            r110.f458314d = r104;
            com.ss.ugc.live.sdk.msg.network.h r111 = this.f490480b.f458308k;
            if (r111 == null) goto L16;
            r111.a(r110);
        L16:
            int r112 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
            return new com.ss.ugc.live.sdk.msg.utils.g.c(r110);
        L18:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");
        L19:
            String r113 = this.f490479a.e(r102);
            bc2.c.e("http post response failed, code: " + r102.getStatus() + ". logId: " + r113);
            int r114 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
            return com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(r102.getStatus(), r113));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e f490481a;

        public b(com.ss.ugc.live.sdk.msg.network.e r100) {
            this.f490481a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.ss.ugc.live.sdk.msg.network.e r101 = this.f490481a;
            r101.a((com.ss.ugc.live.sdk.msg.utils.g) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e f490482a;

        public c(com.ss.ugc.live.sdk.msg.network.e r100) {
            this.f490482a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if ((r101 instanceof NetworkErrorException) == false) goto L5;
            com.ss.ugc.live.sdk.msg.network.e r102 = this.f490482a;
            int r103 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
            r102.a(com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(((NetworkErrorException) r101).statusCode, null)));
            return;
        L5:
            com.ss.ugc.live.sdk.msg.network.e r104 = this.f490482a;
            int r105 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
            r104.a(com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception(r101)));
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.network.i
    public final com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> a(com.ss.ugc.live.sdk.msg.network.f r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        HashMap r101 = new HashMap();     // Catch: Exception -> L28
        Map<String, String> r102 = r100.f458305h;     // Catch: Exception -> L28
        if (r102 == null) goto L6;
        r101.putAll(r102);     // Catch: Exception -> L28
    L6:
        r101.put("room_id", String.valueOf(this.f490476b.get().longValue()));     // Catch: Exception -> L28
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG, this.f490477c.get());     // Catch: Exception -> L28
        r101.putAll(this.f490478d.get());     // Catch: Exception -> L28
        IMessageApi r103 = this.f490475a;     // Catch: Exception -> L28
        String r104 = r100.f458299b;     // Catch: Exception -> L28
        List<Header> r105 = d(r100.f458300c);     // Catch: Exception -> L28
        Map<String, String> r106 = r100.f458301d;     // Catch: Exception -> L28
        if (r106 != null) goto L9;
        r106 = new HashMap();     // Catch: Exception -> L28
    L9:
        Response r107 = r103.doPost(r104, r105, r106, r101).execute().raw();     // Catch: Exception -> L28
        if (r107.isSuccessful() == false) goto L26;
        TypedInput r108 = r107.getBody();     // Catch: Exception -> L28
        if (r108 == null) goto L25;
        byte[] r109 = ((TypedByteArray) r108).getBytes();     // Catch: Exception -> L28
        List<Header> r110 = r107.getHeaders();     // Catch: Exception -> L28
        if (r110 != null) goto L16;
        r110 = CollectionsKt.emptyList();     // Catch: Exception -> L28
    L16:
        List<Header> r111 = r110;     // Catch: Exception -> L28
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));     // Catch: Exception -> L28
        Iterator<T> r113 = r111.iterator();     // Catch: Exception -> L28
    L18:
        if (r113.hasNext() == false) goto L20;
        Header r114 = (Header) r113.next();     // Catch: Exception -> L28
        r112.add(new com.ss.ugc.live.sdk.msg.network.d(r114.getName(), r114.getValue()));     // Catch: Exception -> L28
        goto L18
    L20:
        com.ss.ugc.live.sdk.msg.network.g r115 = new com.ss.ugc.live.sdk.msg.network.g();     // Catch: Exception -> L28
        r115.f458311a = r107.getStatus();     // Catch: Exception -> L28
        r115.f458312b = r107.getReason();     // Catch: Exception -> L28
        r115.f458313c = r112;     // Catch: Exception -> L28
        r115.f458314d = r109;     // Catch: Exception -> L28
        com.ss.ugc.live.sdk.msg.network.h r116 = r100.f458308k;     // Catch: Exception -> L28
        if (r116 == null) goto L23;
        r116.a(r115);     // Catch: Exception -> L28
    L23:
        int r117 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;     // Catch: Exception -> L28
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r115);
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");     // Catch: Exception -> L28
    L26:
        bc2.c.e("http post response failed, code: " + r107.getStatus() + ". logId: " + e(r107));     // Catch: Exception -> L28
        a4.a(r107.getStatus(), e(r107), this.f490477c.get());     // Catch: Exception -> L28
        int r118 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;     // Catch: Exception -> L28
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(r107.getStatus(), "response failed"));
    L28:
        e = move-exception;
        bc2.c.e("http post failed: " + e.getMessage());
        if ((e instanceof NetworkErrorException) == false) goto L32;
        int r119 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(((NetworkErrorException) e).statusCode, null));
    L32:
        int r120 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception("http exception"));
    }

    public final List<Header> d(Map<String, String> r100) {
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

    public final String e(Response r100) {
        List<Header> r101 = r100.getHeaders();
        if (r101 == null) goto L15;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(NetResponse.HEADER_KEY_LOG_ID, ((Header) r103).getName()) == false) goto L6;
    L11:
        Header r104 = (Header) r103;
        if (r104 == null) goto L15;
        String r105 = r104.getValue();
        if (r105 == null) goto L15;
        return r105;
    L10:
        r103 = null;
    L15:
        return "";
    }

    @Override // com.ss.ugc.live.sdk.msg.network.i
    public final void b(com.ss.ugc.live.sdk.msg.network.f r100, com.ss.ugc.live.sdk.msg.network.e r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        TypedByteArray r102 = new TypedByteArray(r100.f458304g, r100.a(), new String[0]);
        IMessageApi r103 = this.f490475a;
        String r104 = r100.f458299b;
        List<Header> r105 = d(r100.f458300c);
        Map<String, String> r106 = r100.f458301d;
        if (r106 != null) goto L5;
        r106 = new HashMap();
    L5:
        r103.doPostAsync(r104, r105, r106, r102).map(new a(this, r100)).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r101), new c(r101));
    }

    @Override // com.ss.ugc.live.sdk.msg.network.i
    public final void c(com.ss.ugc.live.sdk.msg.network.f r100, lmc.a.f r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IMessageApi r102 = this.f490475a;
        String r103 = r100.f458299b;
        List<Header> r104 = d(r100.f458300c);
        Map<String, String> r105 = r100.f458301d;
        if (r105 != null) goto L5;
        r105 = new HashMap();
    L5:
        r102.doGetAsync(r103, r104, r105).map(new e(this, r100)).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r101), new g(r101));
    }

    public h(h80.d<Long> r100, h80.d<String> r101, h80.d<Map<String, String>> r102) {
        Intrinsics.checkNotNullParameter(r100, "roomIdSupplier");
        Intrinsics.checkNotNullParameter(r101, "roomTagSupplier");
        Intrinsics.checkNotNullParameter(r102, "externalMessageFieldParams");
        this.f490476b = r100;
        this.f490477c = r101;
        this.f490478d = r102;
        this.f490475a = (IMessageApi) com.bytedance.android.live.network.c.b().e(IMessageApi.class);
    }
}
