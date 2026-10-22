package com.vivo.push.h;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
final class l extends ab {
    public l(com.vivo.push.v r100) {
        super(r100);
    }

    public static /* synthetic */ Context b(l r100) {
        return r100.f462510a;
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r110) {
        com.vivo.push.b.u r100 = (com.vivo.push.b.u) r110;
        ArrayList<String> r101 = r100.e();
        List<String> r102 = r100.f();
        ArrayList r103 = new ArrayList();
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        ArrayList r113 = new ArrayList();
        int r114 = r100.j();
        com.vivo.push.util.t.c("OnDelTagsTask", "doTask,删除成功的标签 = " + r101 + " 删除失败的= " + r102 + " 错误码= " + r114);
        String r115 = r100.i();
        if (r101 == null) goto L13;
        Iterator<String> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        String r105 = r104.next();
        if (r105.startsWith("ali/") == true) goto L9;
        if (r105.startsWith("tag/") == false) goto L6;
        r103.add(r105.replace("tag/", ""));
        goto L6
    L9:
        r111.add(r105.replace("ali/", ""));
    L13:
        if (r102 == null) goto L24;
        Iterator<String> r106 = r102.iterator();
    L16:
        if (r106.hasNext() == false) goto L24;
        String r107 = r106.next();
        if (r107.startsWith("ali/") == true) goto L19;
        if (r107.startsWith("tag/") == false) goto L16;
        r112.add(r107.replace("tag/", ""));
        goto L16
    L19:
        r113.add(r107.replace("ali/", ""));
    L24:
        if (r103.size() <= 0) goto L26;
    L27:
        com.vivo.push.util.t.c("OnDelTagsTask", "doTask1,删除成功的别名 = " + r103 + " 删除失败的别名= " + r112 + " 错误码= " + r114);
        if (r103.size() <= 0) goto L48;
        com.vivo.push.m.a();
    L46:
        e = move-exception;
        e.printStackTrace();
        com.vivo.push.restructure.a.a().e().h();
        goto L48
    L31:
        if (r103.size() <= 0) goto L48;
        String r108 = com.vivo.push.restructure.a.a().e().g();     // Catch: JSONException -> L46
        if (TextUtils.isEmpty(r108) == false) goto L36;
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L46
    L37:
        Iterator r116 = r103.iterator();     // Catch: JSONException -> L46
    L39:
        if (r116.hasNext() == false) goto L41;
        r109.remove((String) r116.next());     // Catch: JSONException -> L46
        goto L39
    L41:
        String r117 = r109.toString();     // Catch: JSONException -> L46
        if (TextUtils.isEmpty(r117) == false) goto L44;
        com.vivo.push.restructure.a.a().e().h();     // Catch: JSONException -> L46
        goto L48
    L44:
        com.vivo.push.restructure.a.a().e().d(r117);     // Catch: JSONException -> L46
        goto L48
    L36:
        r109 = new JSONObject(r108);     // Catch: JSONException -> L46
    L48:
        com.vivo.push.m.a().a(r100.i(), r114);
        com.vivo.push.t.a(new m(this, r114, r103, r112, r115));
    L50:
        if (r111.size() <= 0) goto L52;
    L53:
        com.vivo.push.util.t.c("OnDelTagsTask", "doTask1,删除成功的标签 = " + r103 + " 删除失败的标签= " + r112 + " 错误码= " + r114);
        if (r111.size() <= 0) goto L56;
        com.vivo.push.m.a().a(r111);
    L56:
        com.vivo.push.m.a().a(r100.i(), r114);
        com.vivo.push.t.a(new n(this, r114, r111, r113, r115));
        return;
    L52:
        if (r113.size() > 0) goto L53;
        return;
    L26:
        if (r112.size() <= 0) goto L50;
        goto L27
    }

    public static /* synthetic */ Context a(l r100) {
        return r100.f462510a;
    }
}
