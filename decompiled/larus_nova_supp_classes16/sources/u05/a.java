package u05;

import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.WikiNavInfo;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.q4;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: u05.a$a, reason: collision with other inner class name */
    public static final class C0302a implements NetService.c<DocObjInfo> {
        public final String a;

        public C0302a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "logId");
            this.a = r2;
        }

        public final WikiNavInfo a(JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "dataObj");
            JSONObject r6 = r5.optJSONObject("wiki_info");     // Catch: Exception -> L5
            WikiNavInfo r1 = new WikiNavInfo(r6.optBoolean("is_wiki"), r6.optString("wiki_token"));     // Catch: Exception -> L5
            tt5.a.h("DocObjInfoExecutor", "getWikiNavInfo. isWiki: " + r1.isWiki() + ", wikiToken: " + du5.b.g(r1.getWikiToken()) + ", logId: " + this.a);     // Catch: Exception -> L5
            return r1;
        L6:
            return new WikiNavInfo(false, null, 3, null);
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r12) {
            JSONObject r13 = new JSONObject(r12).optJSONObject("data");     // Catch: Exception -> L4
            boolean r1 = r13.optBoolean("is_pined");     // Catch: Exception -> L4
            boolean r2 = r13.optBoolean("is_stared");     // Catch: Exception -> L4
            boolean r3 = r13.optBoolean("is_subscribed");     // Catch: Exception -> L4
            boolean r4 = r13.optBoolean("is_subscribed_comment");     // Catch: Exception -> L4
            Intrinsics.checkNotNull(r13);     // Catch: Exception -> L4
            return new DocObjInfo(r1, r2, r3, r4, a(r13), this.a, r13.optInt("supports_cross_tenant_sub_with_perceive_perm"));
        L4:
            e = move-exception;
            tt5.a.d("DocObjInfoExecutor", "parse: " + e);
            return new DocObjInfo(false, false, false, false, null, null, 0, 127, null);
        }
    }

    static {
    }

    @JvmStatic
    public static final Flowable<DocObjInfo> a(q4 r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        tt5.a.h("DocObjInfoExecutor", "requestDocObjInfo. objToken: " + du5.b.g(r4.a) + ", is_wiki: " + r5);
        NetService.e r0 = new NetService.f("/space/api/aggregation/obj_info/");
        r0.b("token", r4.a);
        r0.b("obj_type", String.valueOf(r4.getType()));
        r0.b("scence", r4.g);
        ArrayList r1 = new ArrayList();
        if (r5 == false) goto L8;
        if (c.a.a.i("ccm.workspace.phoenix", false) == true) goto L8;
        r1.add("is_wiki");
    L8:
        if (r4.c == false) goto L11;
        r1.add("is_pined");
    L11:
        if (r4.d == false) goto L14;
        r1.add("is_stared");
    L14:
        if (r4.e == false) goto L16;
        r1.add("is_subscribed");
    L16:
        Unit r6 = Unit.INSTANCE;
        r0.a("info_types", r1);
        String r7 = b.a();
        r0.c(MapsKt.mapOf(TuplesKt.to("x-tt-logid", r7)));
        NetService r8 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Intrinsics.checkNotNull(r7);
        return r8.Vc(new C0302a(r7)).a(r0);
    }
}
