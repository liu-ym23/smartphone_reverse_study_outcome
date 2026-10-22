package jab;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.statistics.Statistics;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497970a = 0;

    /* JADX INFO: renamed from: jab.a$a, reason: collision with other inner class name */
    public static final class C6408a {
        public static void a(Chat r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            Map r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Boolean.valueOf(r100.isThread()), SVGRenderEngine.CIRCLE), TuplesKt.to(Boolean.valueOf(!r100.isCrossTenant()), "internal"), TuplesKt.to(Boolean.valueOf(r100.isCrossTenant()), "external"), TuplesKt.to(Boolean.valueOf(r100.is_department()), "department"), TuplesKt.to(Boolean.valueOf(r100.isTenant()), "all_staff"), TuplesKt.to(Boolean.valueOf(r100.isOnCall()), "on_call"), TuplesKt.to(Boolean.valueOf(r100.isCustomerService()), "customer_service"), TuplesKt.to(Boolean.valueOf(r100.isMeeting()), "meeting")});
            LinkedHashMap r103 = new LinkedHashMap();
            Iterator r104 = r102.entrySet().iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            Map.Entry r105 = (Map.Entry) r104.next();
            ((Boolean) r105.getKey()).booleanValue();
            r103.put(r105.getKey(), r105.getValue());
            goto L4
        L6:
            List r106 = CollectionsKt.toList(r103.values());
            if (r100.isPublic() == false) goto L9;
            String r107 = "public";
        L10:
            boolean r108 = r100.isCrossTenant();
            JSONObject r109 = new JSONObject();
            r109.put("source", r101);
            r109.put("type", r106);
            r109.put("mode", r107);
            r109.put("is_external", r108 ? 1 : 0);
            Statistics.sendEvent("im_chat_create_success", r109);
            return;
        L9:
            r107 = BridgePrivilege.PRIVATE;
            goto L10
        }
    }

    static {
    }
}
