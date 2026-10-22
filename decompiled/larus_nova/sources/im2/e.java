package im2;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.ugc.live.sdk.msg.network.HttpException;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f490471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.f f490472b;

    public e(h r100, com.ss.ugc.live.sdk.msg.network.f r101) {
        this.f490471a = r100;
        this.f490472b = r101;
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
        com.ss.ugc.live.sdk.msg.network.h r111 = this.f490472b.f458308k;
        if (r111 == null) goto L16;
        r111.a(r110);
    L16:
        int r112 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return new com.ss.ugc.live.sdk.msg.utils.g.c(r110);
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.retrofit2.mime.TypedByteArray");
    L19:
        String r113 = this.f490471a.e(r102);
        bc2.c.e("http post response failed, code: " + r102.getStatus() + ". logId: " + r113);
        int r114 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        return com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(r102.getStatus(), r113));
    }
}
