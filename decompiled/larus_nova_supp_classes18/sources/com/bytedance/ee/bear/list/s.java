package com.bytedance.ee.bear.list;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {

    public interface a {
        void onFail(Throwable r1);

        void onSuccess(String r1);
    }

    public static class b implements NetService.c<Result> {
        public b() {
        }

        public final Result parse(String r4) {
            Result r0 = new Result();
            JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L5
            r0.msg = r1.optString("msg");     // Catch: JSONException -> L5
            r0.code = r1.optInt("code");     // Catch: JSONException -> L5
            return r0;
        L5:
            e = move-exception;
            tt5.a.f("DeleteExecutor", e, false);
            return r0;
        }
    }

    public interface c {
        void a(DocumentListInfo r1);

        void b(String r1, int r2, Throwable r3);

        void onSuccess(String r1);
    }

    public s() {
    }

    public static void d(final Document r5, final c r6) {
        if (TextUtils.isEmpty(r5.c) == false) goto L6;
        tt5.a.d("DeleteExecutor", "removeSingleContainer()...token is empty");
        r6.b(r5.d, r5.getType(), new Throwable("token is empty"));
        return;
    L6:
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new q());
        String r2 = r5.c;
        JSONArray r3 = new JSONArray();     // Catch: Exception -> L9
        r3.put(r2);     // Catch: Exception -> L9
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
        r4.put(ResourceData.KEY_TOKEN, r3);     // Catch: Exception -> L9
        r4.put("apply", "1");     // Catch: Exception -> L9
        String r1 = r4.toString();     // Catch: Exception -> L9
    L10:
        NetService.f r7 = new NetService.f("/space/api/explorer/v2/remove/");
        ((NetService.e) r7).c = 1;
        if (TextUtils.isEmpty(r1) == true) goto L13;
        ((NetService.e) r7).j = r1;
    L13:
        r0.a(r7).observeOn(fo5.d.d()).subscribe(new g(r5, r6), new h(r5, r6));
        return;
    L9:
        tt5.a.d("DeleteExecutor", "generate remove single container params fail");
        r1 = "";
        goto L10
    }

    public static void b(final String r5, int r6, final a r7) {
        HashMap r0 = new HashMap();
        r0.put(ResourceData.KEY_OBJ_TOKEN, r5);
        r0.put("obj_type", String.valueOf(r6));
        String r8 = String.valueOf(r6);
        JSONObject r1 = new JSONObject();
        JSONArray r2 = new JSONArray();     // Catch: JSONException -> L5
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L5
        r4.put(ResourceData.KEY_OBJ_TOKEN, r5);     // Catch: JSONException -> L5
        r4.put("obj_type", r8);     // Catch: JSONException -> L5
        r2.put(r4);     // Catch: JSONException -> L5
        r1.put("entities", r2);     // Catch: JSONException -> L5
    L7:
        String r9 = r1.toString();
        if (TextUtils.isEmpty(r5) == false) goto L10;
        r7.onFail(new Throwable("token is empty"));
        return;
    L10:
        NetService.d r3 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new b());
        NetService.f r10 = new NetService.f("/api/explorer/v2/recent/delete/");
        ((NetService.e) r10).c = 1;
        if (TextUtils.isEmpty(r9) == true) goto L13;
        ((NetService.e) r10).j = r9;
    L13:
        r3.a(r10).subscribe(new f(r7, r5), new i(r7, r5));
        return;
    L5:
        e = move-exception;
        tt5.a.d("DeleteExecutor", "buildDeleteV2Params()...error = " + e);
        goto L7
    }

    public static void a(final String r4, final int r5, int r6, final com.bytedance.ee.bear.contract.c0.a r7) {
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new b());
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_OBJ_TOKEN, r4);
        r1.put("obj_type", String.valueOf(r5));
        if (qc5.a.b(r6) == false) goto L6;
        r1.put("apply", "1");
    L6:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r6)) == false) goto L8;
        NetService.f r8 = new NetService.f("/space/api/explorer/v2/remove/object/");
        ((NetService.e) r8).c = 1;
        r8.d(r1);
    L9:
        r0.a(r8).map(new j(r7)).map(new k()).map(new l(r4)).observeOn(fo5.d.d()).subscribe(new m(r5), new n(r5, r7, r4));
        return;
    L8:
        r8 = new NetService.f("/api/explorer/obj/delete/");
        ((NetService.e) r8).c = 1;
        r8.d(r1);
        goto L9
    }

    public static void c(String r2, final String r3, Map r4, final a r5) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r5.onFail(new Throwable("token is empty"));
        return;
    L6:
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new b());
        NetService.f r1 = new NetService.f(r2);
        ((NetService.e) r1).c = 1;
        r1.d(r4);
        r0.a(r1).observeOn(fo5.d.d()).subscribe(new o(r5, r3), new p(r5, r3));
    }
}
