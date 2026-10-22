package y60;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f566321a = null;

    static {
        f566321a = new AtomicBoolean();
    }

    public static final void a(Context r100) {
        Map<String, ?> r101 = r100.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2", 0).getAll();
        if (r101 != null) goto L5;
        return;
    L5:
        if ((!r101.isEmpty()) == false) goto L54;
        SharedPreferences.Editor r102 = r100.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2_for_mini_process", 0).edit();
        Iterator<T> r103 = r101.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L30;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        Object r106 = r104.getValue();
        if ((r106 instanceof Boolean) == true) goto L11;
        if ((r106 instanceof String) == true) goto L14;
        if ((r106 instanceof Integer) == true) goto L17;
        if ((r106 instanceof Long) == true) goto L20;
        if ((r106 instanceof Float) == true) goto L23;
        boolean r107 = r106 instanceof Set;
        if (r107 == false) goto L8;
        if (r107 == true) goto L28;
        r106 = null;
    L28:
        r102.putStringSet(r105, (Set) r106);
        goto L8
    L23:
        r102.putFloat(r105, ((Number) r106).floatValue());
        goto L8
    L20:
        r102.putLong(r105, ((Number) r106).longValue());
        goto L8
    L17:
        r102.putInt(r105, ((Number) r106).intValue());
        goto L8
    L14:
        r102.putString(r105, (String) r106);
        goto L8
    L11:
        r102.putBoolean(r105, ((Boolean) r106).booleanValue());
        goto L8
    L30:
        r102.commit();
        r100.getSharedPreferences("ttlive_sdk_shared_pref_cache_v2_flags", 0).edit().putBoolean("need_update_for_mini_process", false).apply();
        return;
    }
}
