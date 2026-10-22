package z05;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.editionmanager.data.EditionListResult;
import com.bytedance.ee.bear.document.editionmanager.data.UsersBean;
import com.bytedance.ee.bear.document.editionmanager.data.VersionMetasBean;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public static final Map<String, g> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void d(EditionListResult r4) {
        Iterator<VersionMetasBean> r0 = r4.getVersion_metas().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        g r1 = a(r0.next(), r4.getUsers());
        String r2 = b(r1.g, r1.f);
        ((ConcurrentHashMap) a).put(r2, r1);
        goto L4
    }

    public static g a(VersionMetasBean r5, Map<String, UsersBean> r6) {
        g r0 = new g();
        String r1 = r5.getParent_token();
        String r2 = r5.getVersion();
        r0.a = r5.getToken();
        r0.g = r1;
        r0.b = r5.getName().replace(DocViewModel.ENTER_CHAR, "");
        r0.f = r2;
        r0.h = r5.getCreate_time();
        r0.i = r5.getUpdate_time();
        Iterator<UsersBean> r7 = r6.values().iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        UsersBean r3 = r7.next();
        if (TextUtils.equals(r3.getUser_id(), r5.getCreator_id()) == false) goto L4;
    L9:
        if (r3 == null) goto L13;
        r0.c = r3.getName();
        r0.d = r3.getEn_name();
        if (r3.getDisplay_name() == null) goto L13;
        r0.e = ou5.a.a(((i0) org.koin.java.a.a(i0.class)).a(), r3.getDisplay_name(), r3.getName(), r3.getEn_name());
    L13:
        return r0;
    L8:
        r3 = null;
        goto L9
    }

    public static String b(String r1, String r2) {
        return r1 + OfflineDoc.DASH_DELIMITER + r2;
    }

    public static g c(String r1, String r2) {
        Map<String, g> r0 = a;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r0;
        return (g) r3.get(b(r1, r2));
    }
}
