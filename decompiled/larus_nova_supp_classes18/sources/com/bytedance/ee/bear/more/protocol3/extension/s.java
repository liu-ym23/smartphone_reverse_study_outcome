package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    public static final class a<T extends Result> implements NetService.c {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Result parse(String r14) {
            DocObjInfo r12 = new DocObjInfo(false, false, false, false, null, null, 0, 127, null);
            JSONObject r15 = new JSONObject(r14).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L12
            boolean r2 = false;
            if (r15 == null) goto L6;
            boolean r3 = r15.optBoolean("is_explorer_pin");     // Catch: Throwable -> L12
        L7:
            r12.setPined(r3);     // Catch: Throwable -> L12
            if (r15 == null) goto L10;
            r2 = r15.optBoolean("is_explorer_star");     // Catch: Throwable -> L12
        L10:
            r12.setStared(r2);     // Catch: Throwable -> L12
            tt5.a.h("DocObjInfoExtension", "get_node success. isPined=" + r12.isPined() + ", isStared=" + r12.isStared());     // Catch: Throwable -> L12
        L14:
            return r12;
        L6:
            r3 = false;
        L12:
            th = move-exception;
            tt5.a.d("DocObjInfoExtension", "get_node err: " + th);
            goto L14
        }
    }

    static {
    }

    public static Flowable a(String r4) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        NetService.d r0 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(a.a);
        NetService.f r1 = new NetService.f("/space/api/wiki/v2/tree/get_node/");
        ((HashMap) ((NetService.e) r1).e).put("wiki_token", r4);
        ((HashMap) ((NetService.e) r1).e).put("need_star", "true");
        Map r5 = ((NetService.e) r1).e;
        if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L5;
        String r2 = "1";
    L6:
        ((HashMap) r5).put("thumbnail_mode", r2);
        return r0.a(r1);
    L5:
        r2 = "0";
        goto L6
    }
}
