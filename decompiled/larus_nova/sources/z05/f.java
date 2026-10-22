package z05;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.document.editionmanager.data.EditionListResult;
import com.bytedance.ee.bear.document.editionmanager.data.UsersBean;
import com.bytedance.ee.bear.document.editionmanager.data.VersionMetasBean;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, g> f569616a = null;

    static {
        f569616a = new ConcurrentHashMap();
    }

    public static void d(EditionListResult r100) {
        Iterator<VersionMetasBean> r101 = r100.getVersion_metas().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        g r102 = a(r101.next(), r100.getUsers());
        String r103 = b(r102.f569623g, r102.f569622f);
        ((ConcurrentHashMap) f569616a).put(r103, r102);
        goto L4
    }

    public static g a(VersionMetasBean r100, Map<String, UsersBean> r101) {
        g r102 = new g();
        String r103 = r100.getParent_token();
        String r104 = r100.getVersion();
        r102.f569617a = r100.getToken();
        r102.f569623g = r103;
        r102.f569618b = r100.getName().replace("\n", "");
        r102.f569622f = r104;
        r102.f569624h = r100.getCreate_time();
        r102.f569625i = r100.getUpdate_time();
        Iterator<UsersBean> r105 = r101.values().iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        UsersBean r106 = r105.next();
        if (TextUtils.equals(r106.getUser_id(), r100.getCreator_id()) == false) goto L4;
    L9:
        if (r106 == null) goto L13;
        r102.f569619c = r106.getName();
        r102.f569620d = r106.getEn_name();
        if (r106.getDisplay_name() == null) goto L13;
        r102.f569621e = ou5.a.a(((i0) org.koin.java.a.a(i0.class)).a(), r106.getDisplay_name(), r106.getName(), r106.getEn_name());
    L13:
        return r102;
    L8:
        r106 = null;
        goto L9
    }

    public static String b(String r100, String r101) {
        return r100 + "_" + r101;
    }

    public static g c(String r100, String r101) {
        Map<String, g> r102 = f569616a;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        return (g) r103.get(b(r100, r101));
    }
}
