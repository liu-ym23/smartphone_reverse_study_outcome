package us4;

import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class k {
    public static final void a(String r100) {
        HashMap r101 = new HashMap();
        r101.put("ccm_open_type", "base_mobile_intro");
        r101.put("bitable_type", "bitable_app");
        r101.put("file_type", DocumentType.BITABLE_NAME);
        r101.put("file_id", du5.b.g(r100));
        r101.put("user_id", ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2().uid);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_bitable_content_page_view", r101);
    }

    public static final void b(boolean r100, boolean r101, String r102, Integer r103) {
        HashMap r104 = new HashMap();
        if (r100 == false) goto L12;
        r104.put("is_base_mobile_intro", "true");
        r104.put("file_id", du5.b.g(r102));
        if (r103 == null) goto L7;
        int r105 = r103.intValue();
    L8:
        r104.put("intro_stay_days", Integer.valueOf(r105));
        if (r101 == false) goto L11;
        r104.put("is_base_mobile_intro_by_default_on", "true");
    L13:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_base_homepage_mobile_intro_entrance_view", r104);
        return;
    L11:
        r104.put("is_base_mobile_intro_by_default_on", "false");
        goto L13
    L7:
        r105 = 0;
        goto L8
    L12:
        r104.put("is_base_mobile_intro", "false");
        goto L13
    }
}
