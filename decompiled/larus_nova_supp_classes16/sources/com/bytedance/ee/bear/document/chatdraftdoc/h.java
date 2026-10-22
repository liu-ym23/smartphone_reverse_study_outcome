package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public static i a;
    public static m b;
    public static l c;

    static {
    }

    public h() {
    }

    public static final void a(Activity r5, String r6, Function0 r7) {
        tt5.a.h("ChatDraftDocManager", "createChatDraftDoc chatId: " + r6);
        NetService r0 = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        i r1 = a;
        if (r1 != null) goto L5;
        r1 = new i();
        a = r1;
    L5:
        b r2 = new b(r6, r7, r5);
        Intrinsics.checkNotNullParameter(r0, "netService");
        Intrinsics.checkNotNullParameter(r6, "chatId");
        Intrinsics.checkNotNullParameter(r2, "callback");
        NetService.d r8 = r0.Vc(new i.a());
        NetService.e r9 = new NetService.f("/space/api/chat_relation/obj/create");
        r9.c = 1;
        JSONObject r3 = new JSONObject();
        r3.put("chat_id", r6);
        r3.put("obj_type", 22);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.workspace.create_location_and_open_mode") == false) goto L8;
        r3.put("use_create_default_position", true);
    L8:
        r9.j = r3.toString();
        HashMap r10 = new HashMap();
        r10.put("Content-Type", "application/x-www-form-urlencoded");
        r9.c(r10);
        r1.a.add(r8.a(r9).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new j(r2), new k(r2)));
    }
}
