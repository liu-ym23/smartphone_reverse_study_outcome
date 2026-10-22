package il6;

import com.bytedance.ies.bullet.kit.resourceloader.loader.b;
import com.bytedance.locallife.ability.model.AbilityInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AbilityInfo> f490304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f490305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f490306c = null;

    static {
        f490304a = new ConcurrentHashMap();
        f490305b = "";
        f490306c = new AtomicBoolean(false);
    }

    public static void a(ns6.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<String> r101 = r100.a();
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        String r103 = (String) r102.next();
        if (b.d(r103) == false) goto L8;
        f490304a.put(r103, new AbilityInfo(1));
        goto L8
    L18:
        return;
    }
}
