package ve5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotCheckConfigStatusResult;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final NetService a;

    /* JADX INFO: renamed from: ve5.a$a, reason: collision with other inner class name */
    public static final class C0321a implements NetService.c<AiBotCheckConfigStatusResult> {
        public C0321a() {
        }

        public final Result parse(String r2) {
            Intrinsics.checkNotNullParameter(r2, "json");
            return (AiBotCheckConfigStatusResult) JSON.parseObject(r2, AiBotCheckConfigStatusResult.class);
        }
    }

    public static final class b {
    }

    public static final class c implements NetService.c<AiBotPollingAuthResult> {
        public c() {
        }

        public final Result parse(String r2) {
            Intrinsics.checkNotNullParameter(r2, "json");
            return (AiBotPollingAuthResult) JSON.parseObject(r2, AiBotPollingAuthResult.class);
        }
    }

    static {
    }

    public a() {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Intrinsics.checkNotNullParameter(r0, "netService");
        this.a = r0;
    }

    public final Flowable<AiBotCheckConfigStatusResult> a(List<Long> r6, String r7, long r8, String r10) {
        Intrinsics.checkNotNullParameter(r6, "botIds");
        Intrinsics.checkNotNullParameter(r7, "objToken");
        Intrinsics.checkNotNullParameter(r10, "scene");
        NetService.f r1 = new NetService.f("/space/api/platform/ai_bot/check_config_status");
        ((NetService.e) r1).c = 1;
        List<Long> r9 = r6;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r2.add(String.valueOf(((Number) r11.next()).longValue()));
        goto L4
    L6:
        r1.a("bot_ids", r2);
        r1.b("scene", r10);
        r1.b(ResourceData.KEY_OBJ_TOKEN, r7);
        r1.b("obj_type", String.valueOf(r8));
        ((NetService.e) r1).j = new JSONObject().toJSONString();
        return this.a.Vc(new C0321a()).a(r1);
    }
}
