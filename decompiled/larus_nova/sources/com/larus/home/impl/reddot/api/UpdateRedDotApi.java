package com.larus.home.impl.reddot.api;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import fc9.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/larus/home/impl/reddot/api/UpdateRedDotApi;", "", "updateRedDot", "Lcom/larus/network/bean/BizResponse;", "request", "Lcom/larus/home/impl/reddot/api/UpdateRedDotRequest;", "(Lcom/larus/home/impl/reddot/api/UpdateRedDotRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UpdateRedDotApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f346029a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f346030a = null;

        static {
            f346030a = new a();
        }

        public a() {
        }

        public final Object call(b r110, String r111, Continuation<? super com.larus.network.http.a<? extends Object>> r112) {
            FlowDowngradeServiceDelegate r100 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r101 = new JSONObject();
            String r102 = r110.c();
            if (r102 == null) goto L5;
            r101.put("user_id", r102);
        L5:
            fc9.a r103 = r110.a();
            if (r103 == null) goto L8;
            JSONObject r104 = new JSONObject();
            r104.put("action", r103.a());
            r104.put("count", r103.b());
            r104.put("type", r103.getType());
            Unit r105 = Unit.INSTANCE;
            r101.put("all_red_dot", r104);
        L8:
            List<fc9.a> r113 = r110.b();
            if (r113 == null) goto L17;
            List r114 = CollectionsKt.filterNotNull(r113);
            if (r114 == null) goto L17;
            List r115 = r114;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
            Iterator r116 = r115.iterator();
        L14:
            if (r116.hasNext() == false) goto L16;
            fc9.a r107 = (fc9.a) r116.next();
            JSONObject r117 = new JSONObject();
            r117.put("action", r107.a());
            r117.put("count", r107.b());
            r117.put("type", r107.getType());
            r106.add(r117);
            goto L14
        L16:
            r101.put("red_dot", new JSONArray(r106));
        L17:
            Unit r118 = Unit.INSTANCE;
            return IFlowDowngradeService.a.b(r100, ServiceType.BASIC_SERVICE, Object.class, "/alice/notice/update_red_dot", r101, null, false, null, MapsKt.mapOf(TuplesKt.to("source", r111)), r112, 1008);
        }
    }

    static {
        f346029a = a.f346030a;
    }

    @POST("/alice/notice/update_red_dot")
    Object updateRedDot(@Body b r100, Continuation<? super BizResponse<Object>> r101);
}
