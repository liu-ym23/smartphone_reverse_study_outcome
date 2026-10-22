package w05;

import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.Flowable;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: w05.a$a, reason: collision with other inner class name */
    public static final class C0316a implements NetService.c<DocContainerInfo> {
        public final String a;

        public C0316a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "logId");
            this.a = r2;
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r9) {
            JSONObject r10 = new JSONObject(r9).optJSONObject("data");     // Catch: Exception -> L4
            return new DocContainerInfo(r10.optString("node_token"), r10.optInt("biz_type"), r10.optBoolean("is_exist"), this.a);
        L4:
            e = move-exception;
            tt5.a.d("DocumentContainerFetcher", "parse: " + e);
            return new DocContainerInfo(null, 0, false, null, 15, null);
        }
    }

    static {
    }

    @JvmStatic
    public static final Flowable<DocContainerInfo> a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "token");
        tt5.a.h("DocumentContainerFetcher", "requestDocContainerInfo. objToken: " + du5.b.g(r3) + " objType is " + r4);
        NetService.f r0 = new NetService.f("/space/api/bff/workspace/container/info/");
        r0.b("obj_token", r3);
        r0.b("obj_type", String.valueOf(r4));
        String r5 = u05.b.a();
        r0.c(MapsKt.mapOf(TuplesKt.to("x-tt-logid", r5)));
        NetService r6 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Intrinsics.checkNotNull(r5);
        return r6.Vc(new C0316a(r5)).a(r0);
    }
}
