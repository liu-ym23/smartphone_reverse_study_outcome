package r15;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final Map<String, Object> a;
    public final com.bytedance.ee.bear.contract.d b;
    public String c;
    public final BearUrl d;

    public final void a(Map<String, String> r4) {
        BearUrl r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = "ERR";
        if (TextUtils.isEmpty(r0.b) == false) goto L8;
        String r2 = "ERR";
    L10:
        if (TextUtils.isEmpty(this.d.a) == true) goto L13;
        r1 = this.d.a;
    L13:
        HashMap r5 = (HashMap) r4;
        r5.put("file_id", r2);
        r5.put("file_type", r1);
        r5.put("module", r1);
        r5.put("block_type", this.c);
        return;
    L8:
        r2 = du5.b.g(this.d.b);
        goto L10
    }

    public final void b(String r3) {
        HashMap r0 = new HashMap();
        r0.put(JSEventListener.ACTION, r3);
        a(r0);
        com.bytedance.ee.bear.contract.d r4 = this.b;
        if (r4 == null) goto L6;
        r4.v("client_image_operation", r0);
        return;
    }

    public a(com.bytedance.ee.bear.contract.d r3, BearUrl r4) {
        this.a = new HashMap();
        this.b = r3;
        this.d = r4;
        if (r3 == null) goto L10;
        HashMap<String, Object> r5 = r3.m("docCommonParams");
        if (r5.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<String, Object> r7 = r6.next();
        this.a.put(r7.getKey(), r7.getValue());
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void c(String r3, String r4) {
        ((HashMap) this.a).put("click", r3);
        Map<String, Object> r5 = this.a;
        HashMap r6 = (HashMap) r5;
        r6.put("object_id", du5.b.g(r4));
        ((HashMap) this.a).put("object_file_type", "png");
        com.bytedance.ee.bear.contract.d r7 = this.b;
        if (r7 == null) goto L6;
        r7.n("ccm_drive_page_click", this.a);
        return;
    }
}
