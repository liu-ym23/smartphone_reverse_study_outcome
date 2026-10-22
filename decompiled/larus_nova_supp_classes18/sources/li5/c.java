package li5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a<T1, T2, R> implements BiFunction {
        public static final a<T1, T2, R> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2, Object r3) {
            HashMap r4 = (HashMap) r2;
            HashMap r5 = (HashMap) r3;
            Intrinsics.checkNotNullParameter(r4, "t1");
            Intrinsics.checkNotNullParameter(r5, "t2");
            HashMap r0 = new HashMap();
            r0.putAll(r4);
            r0.putAll(r5);
            return r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final Flowable<HashMap<String, IDocUserPermission>> a(int r4, String r5, ArrayList<String> r6) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "userIds");
        ArrayList r2 = new ArrayList(new HashSet(r6));
        tt5.a.h("DocPermissionManager", "batchFetchUserPermissionWrapper()...origin size = " + r6.size() + ", final size = " + r2.size());
        if (r2.size() >= 20) goto L9;
        tt5.a.h("DocPermissionManager", "batchFetchUserPermission");
        JSONObject r7 = new JSONObject();
        r7.put(ResourceData.KEY_TYPE, Integer.valueOf(r4));
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        r7.put(ResourceData.KEY_TOKEN, r5);
        r7.put("user_ids", r2);
        NetService r8 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r9 = new NetService.f("/space/api/suite/permission/user/mget/");
        ((NetService.e) r9).j = r7.toJSONString();
        return r8.Vc(new li5.a(r2)).a(r9).map(b.a);
    L9:
        int r10 = r2.size() / 2;
        return Flowable.zip(a(r4, r5, new ArrayList(r2.subList(0, r10))), a(r4, r5, new ArrayList(r2.subList(r10, r2.size()))), a.a);
    }

    @JvmStatic
    public static final Flowable b(int r4, String r5, Map r6) {
        tt5.a.h("DocPermissionManager", "getUserInfoV2()...lastLabel = ");
        NetService.f r0 = new NetService.f("/space/api/suite/permission/members.v2/");
        if (r5 != null) goto L5;
        String r2 = "";
    L6:
        r0.b(ResourceData.KEY_TOKEN, r2);
        r0.b(ResourceData.KEY_TYPE, String.valueOf(r4));
        r0.b("last_label", "");
        r0.b("perm_type", String.valueOf(0));
        if (r6 == null) goto L12;
        Iterator r7 = r6.entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        Map.Entry r8 = (Map.Entry) r7.next();
        r0.b((String) r8.getKey(), (String) r8.getValue());
    L12:
        NetService r9 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        return r9.Vc(new zg5.b(r5)).a(r0);
    L5:
        r2 = r5;
        goto L6
    }

    @JvmStatic
    public static final Disposable c(int r1, String r2, ax4.e r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        return b(r1, r2, r4).subscribe(new f(r3), new g(r3));
    }
}
