package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f219209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static m f219210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static l f219211c;

    static {
    }

    public h() {
    }

    public static final void a(Activity r100, String r101, Function0 r102) {
        tt5.a.h("ChatDraftDocManager", "createChatDraftDoc chatId: " + r101);
        NetService r103 = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        i r104 = f219209a;
        if (r104 != null) goto L5;
        r104 = new i();
        f219209a = r104;
    L5:
        b r105 = new b(r101, r102, r100);
        Intrinsics.checkNotNullParameter(r103, "netService");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r105, "callback");
        NetService.d r106 = r103.Vc(new i.a());
        NetService.e r107 = new NetService.f("/space/api/chat_relation/obj/create");
        r107.f216906c = 1;
        JSONObject r108 = new JSONObject();
        r108.put("chat_id", r101);
        r108.put("obj_type", 22);
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.workspace.create_location_and_open_mode") == false) goto L8;
        r108.put("use_create_default_position", true);
    L8:
        r107.f216913j = r108.toString();
        HashMap r109 = new HashMap();
        r109.put("Content-Type", "application/x-www-form-urlencoded");
        r107.c(r109);
        r104.f219212a.add(r106.a(r107).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new j(r105), new k(r105)));
    }
}
