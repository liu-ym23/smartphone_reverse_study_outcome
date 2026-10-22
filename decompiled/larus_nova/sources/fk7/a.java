package fk7;

import com.bytedance.android.ec.slice.SliceInitService;
import il7.m;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f477658a;

    /* JADX INFO: renamed from: fk7.a$a, reason: collision with other inner class name */
    public static class C5920a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f477659a = null;

        static {
            f477659a = new a();
        }
    }

    public a() {
        f477658a = m.b("luckydog_ab_settings.prefs").e("key_ab_settings", "");
    }

    public void update(JSONObject r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceConfigManager", "update(), newConfig = " + r101);
        if (r101.equals(f477658a) == true) goto L14;
        f477658a = r101;
        m.b("luckydog_ab_settings.prefs").k("key_ab_settings", r101);
        if (c.f477665f.get() == true) goto L10;
        c.d();
        return;
    L10:
        Iterator r102 = ((HashMap) c.f477662c).keySet().iterator();
    L12:
        if (r102.hasNext() == false) goto L17;
        Class r103 = (Class) r102.next();
        c.c(r103, (String) ((HashMap) c.f477662c).get(r103));
        goto L12
    L17:
        return;
    L14:
        return;
    L4:
        r101 = SliceInitService.DEFAULT_SWITCH;
        goto L5
    }
}
