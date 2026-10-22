package r15;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f535658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f535659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f535660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BearUrl f535661d;

    public final void a(Map<String, String> r100) {
        BearUrl r101 = this.f535661d;
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = "ERR";
        if (TextUtils.isEmpty(r101.f222561b) == false) goto L8;
        String r103 = "ERR";
    L10:
        if (TextUtils.isEmpty(this.f535661d.f222560a) == true) goto L13;
        r102 = this.f535661d.f222560a;
    L13:
        HashMap r104 = (HashMap) r100;
        r104.put("file_id", r103);
        r104.put("file_type", r102);
        r104.put(EventConstant.Key.MODULE, r102);
        r104.put("block_type", this.f535660c);
        return;
    L8:
        r103 = du5.b.g(this.f535661d.f222561b);
        goto L10
    }

    public final void b(String r100) {
        HashMap r101 = new HashMap();
        r101.put("action", r100);
        a(r101);
        com.bytedance.ee.bear.contract.d r102 = this.f535659b;
        if (r102 == null) goto L6;
        r102.v("client_image_operation", r101);
        return;
    }

    public a(com.bytedance.ee.bear.contract.d r100, BearUrl r101) {
        this.f535658a = new HashMap();
        this.f535659b = r100;
        this.f535661d = r101;
        if (r100 == null) goto L10;
        HashMap<String, Object> r102 = r100.m("docCommonParams");
        if (r102.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, Object>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, Object> r104 = r103.next();
        this.f535658a.put(r104.getKey(), r104.getValue());
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void c(String r100, String r101) {
        ((HashMap) this.f535658a).put("click", r100);
        Map<String, Object> r102 = this.f535658a;
        HashMap r103 = (HashMap) r102;
        r103.put("object_id", du5.b.g(r101));
        ((HashMap) this.f535658a).put("object_file_type", LoadParams.ImageFormat.PNG);
        com.bytedance.ee.bear.contract.d r104 = this.f535659b;
        if (r104 == null) goto L6;
        r104.n("ccm_drive_page_click", this.f535658a);
        return;
    }
}
