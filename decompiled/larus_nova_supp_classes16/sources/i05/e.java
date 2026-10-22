package i05;

import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.forecast.OperationRecord;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.util.ui.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final WebView a;
    public boolean b;
    public final Map<String, Boolean> c;
    public final Map<String, String> d;
    public final List<String> e;

    public final void d() {
        this.b = false;
        ((HashMap) this.c).clear();
        ((HashMap) this.d).clear();
        ((ArrayList) this.e).clear();
        OperationRecord r0 = com.bytedance.ee.bear.document.forecast.a.a;
        List<String> r1 = com.bytedance.ee.bear.document.forecast.a.b(DocOpenConfig.e());
        tt5.a.h("BridgeStatusHelper", "getPreloadJsSequencingConfig()... size = " + r1.size());
        Iterator<String> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        String r3 = r2.next();
        if (sbb.e.e(r3) == sbb.e.e) goto L4;
        ((ArrayList) this.e).add(r3);
        goto L4
    L8:
        s1.D = r1;
        tt5.a.h("BridgeStatusHelper", "reset.... , mDefaultJSModule: " + this.e.toString());
    }

    public e(WebView r2) {
        this.b = false;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new ArrayList();
        this.a = r2;
        d();
    }

    public final void a(List<String> r5, String r6) {
        if (this.a == null) goto L35;
        if (r5 == null) goto L48;
        ArrayList r7 = (ArrayList) r5;
        if (r7.isEmpty() == true) goto L49;
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L14;
        String r1 = (String) r8.next();
        if (((HashMap) this.c).get(r1) != null) goto L9;
        r0.add(r1);
        Map<String, Boolean> r2 = this.c;
        HashMap r3 = (HashMap) r2;
        r3.put(r1, Boolean.TRUE);
        goto L9
    L14:
        if (r0.isEmpty() == false) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L18;
        b(r0, r6);
        return;
    L18:
        HashMap r9 = new HashMap();
        ArrayList r10 = new ArrayList();
        Iterator r4 = r0.iterator();
    L20:
        if (r4.hasNext() == false) goto L29;
        String r11 = (String) r4.next();
        String r12 = (String) ((HashMap) this.d).get(r11);
        if (TextUtils.isEmpty(r12) == true) goto L23;
        List r13 = (List) r9.get(r12);
        if (r13 != null) goto L27;
        r13 = new ArrayList();
        r9.put(r12, r13);
    L27:
        r13.add(r11);
        goto L20
    L23:
        r10.add(r11);
        goto L20
    L29:
        if (hu5.a.d(r10) == true) goto L31;
        b(r10, null);
    L31:
        Iterator r14 = r9.entrySet().iterator();
    L33:
        if (r14.hasNext() == false) goto L52;
        Map.Entry r16 = (Map.Entry) r14.next();
        b((List) r16.getValue(), (String) r16.getKey());
        goto L33
    L52:
        return;
    L49:
        return;
    L48:
        return;
    }

    public final void b(List<String> r3, String r4) {
        final JSONObject r0 = new JSONObject();
        r0.put("type", r3);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.put(DocRedirectToDocxPlugin.FROM, r4);
    L5:
        tt5.a.h("BridgeStatusHelper", "callPreloadJsModule  param: " + r0);
        m.a(new d(this, r0));
    }

    public final void c(String r2, String r3) {
        if (this.b == false) goto L6;
        ArrayList r0 = new ArrayList();
        r0.add(r2);
        a(r0, r3);
        return;
    L6:
        if (((ArrayList) this.e).contains(r2) == true) goto L9;
        ((ArrayList) this.e).add(r2);
    L9:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        ((HashMap) this.d).put(r2, r3);
        return;
    }
}
