package yb5;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.lark.dependency.t;
import com.bytedance.lark.pb.basic.v1.DocEntity;
import com.bytedance.lark.pb.basic.v1.DocPermission;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.doc.entity.DocMessage;
import com.ss.android.lark.doc.entity.ThumbnailDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static ibb.a b(Entity r8) {
        ibb.a r0 = new ibb.a();
        if (r8 != null) goto L5;
        return r0;
    L5:
        Map r1 = y.b(r8.doc_feeds, new b());
        Map r9 = y.b(r8.doc_messages, new c());
        if (r9.isEmpty() == true) goto L28;
        HashMap r2 = new HashMap();
        LinkedHashMap r3 = (LinkedHashMap) r9;
        Iterator r4 = r3.keySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L20;
        String r5 = (String) r4.next();
        DocMessage r6 = (DocMessage) r3.get(r5);
        if (r6 == null) goto L10;
        if (TextUtils.isEmpty(r6.getFromName()) == false) goto L10;
        String r7 = r6.getFromId();
        List r10 = (List) r2.get(r7);
        if (r10 != null) goto L18;
        r10 = new ArrayList();
    L18:
        r10.add(r5);
        r2.put(r7, r10);
        goto L10
    L20:
        if (r2.isEmpty() == true) goto L28;
        ArrayList r11 = new ArrayList(r2.keySet());
        t r12 = (t) org.koin.java.a.a(t.class);
        c(r9, r2, r12.a0(r11));
        if (r2.isEmpty() == true) goto L28;
        Map<String, Chatter> r13 = r12.l0(new ArrayList(r2.keySet()));
        if (r13 == null) goto L28;
        c(r9, r2, r13);
    L28:
        r0.a = r1;
        r0.b = r9;
        return r0;
    }

    public static ThumbnailDetail a(Entity r3, String r4, Map r5) {
        HashMap r1 = new HashMap();
        Iterator r6 = ((Message) r3.messages.get(r4)).content.doc_entity.element_entity_ref.values().iterator();     // Catch: Exception -> L9
    L5:
        if (r6.hasNext() == false) goto L8;
        String r7 = ((DocEntity.ElementEntity) r6.next()).doc_url;     // Catch: Exception -> L9
        r1.put(r7, (DocPermission) r5.get(r7));     // Catch: Exception -> L9
        goto L5
    L8:
        r5 = r1;
    L12:
        if (r5.size() == 1) goto L15;
        tt5.a.h("ModelParserDoc", "map.size() ==" + r5.size());
        return null;
    L15:
        DocPermission r8 = (DocPermission) r5.values().iterator().next();
        if (r8 != null) goto L19;
        tt5.a.d("ModelParserDoc", "docPermission == null");
        return null;
    L19:
        String r9 = r8.thumbnail_detail;
        if (TextUtils.isEmpty(r9) == false) goto L22;
        tt5.a.d("ModelParserDoc", "TextUtils.isEmpty(detail) == true");
        return null;
    L22:
        return (ThumbnailDetail) JSON.parseObject(r9, ThumbnailDetail.class);
    L9:
        e = move-exception;
        tt5.a.f("ModelParserDoc", e, false);
        goto L12
    }

    public static void c(Map<String, DocMessage> r5, Map<String, List<String>> r6, Map<String, Chatter> r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        if (((HashMap) r6).isEmpty() == false) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L40;
        if (r7 != null) goto L17;
    L18:
        r0 = true;
    L19:
        if (r0 == true) goto L41;
        Iterator<String> r1 = r7.keySet().iterator();
    L23:
        if (r1.hasNext() == false) goto L42;
        String r4 = r1.next();
        Chatter r8 = r7.get(r4);
        Iterator r9 = ((List) ((HashMap) r6).remove(r4)).iterator();
    L26:
        if (r9.hasNext() == false) goto L23;
        LinkedHashMap r10 = (LinkedHashMap) r5;
        DocMessage r11 = (DocMessage) r10.get((String) r9.next());
        if (r11 == null) goto L26;
        if (r8 != null) goto L31;
        String r12 = "";
    L32:
        r11.setFromName(r12);
        goto L26
    L31:
        r12 = r8.getLocalizedName();
        goto L32
    L42:
        return;
    L41:
        return;
    L17:
        if (r7.isEmpty() == false) goto L19;
    L40:
        return;
    L13:
        r3 = false;
        goto L14
    L5:
        if (r7.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
