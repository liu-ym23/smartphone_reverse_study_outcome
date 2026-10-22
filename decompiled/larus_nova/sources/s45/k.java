package s45;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile k f540571e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ml5.b f540572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f540573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, String> f540574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f540575d;

    public static k a() {
        if (f540571e != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f540571e != null) goto L9;
        f540571e = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f540571e;
    }

    public k() {
        this.f540572a = new ml5.b("passportDomainConfig");
        this.f540574c = new ConcurrentHashMap();
        this.f540575d = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public final void b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.h("PassportHostHelper", "update passport host, but receive empty host");
        return;
    L6:
        this.f540573b = this.f540572a.f514368a.getString("passportHost", "");
        tt5.a.h("PassportHostHelper", "old passport host is " + this.f540573b + " new value is " + r100);
        if (TextUtils.equals(r100, this.f540573b) == true) goto L10;
        this.f540573b = r100;
        this.f540572a.b("passportHost", r100);
        return;
    }

    public final void c(Map<Integer, String> r100) {
        if (((ConcurrentHashMap) this.f540574c).size() != 0) goto L15;
        tt5.a.h("PassportHostHelper", "regex map is empty, get value from Preference");
        Iterator r101 = ((Set) this.f540572a.a("urlRegexKeySet", new HashSet())).iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        Object r102 = r101.next();
        String r103 = this.f540572a.getString(r102.toString(), "");
        Integer r104 = CastIntegerProtector.valueOf(r102.toString());     // Catch: Throwable -> L10
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L6;
        if (r104 == null) goto L6;
        ((ConcurrentHashMap) this.f540574c).put(r104, r103);
    L10:
        tt5.a.d("PassportHostHelper", "");
        r104 = null;
    L15:
        Iterator<Map.Entry<Integer, String>> r105 = r100.entrySet().iterator();
    L17:
        if (r105.hasNext() == false) goto L25;
        Map.Entry<Integer, String> r106 = r105.next();
        Map<Integer, String> r107 = this.f540574c;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        if (r108.containsKey(r106.getKey()) == true) goto L21;
        tt5.a.h("PassportHostHelper", "do not contains key, add key to map");
        Map<Integer, String> r109 = this.f540574c;
        ConcurrentHashMap r110 = (ConcurrentHashMap) r109;
        r110.put(r106.getKey(), r106.getValue());
        this.f540572a.b(r106.getKey(), r106.getValue());
    L24:
        this.f540575d.add(r106.getKey().toString());
        goto L17
    L21:
        String r111 = r106.getValue();
        Map<Integer, String> r112 = this.f540574c;
        ConcurrentHashMap r113 = (ConcurrentHashMap) r112;
        if (r111.equals(r113.get(r106.getKey())) == true) goto L24;
        tt5.a.h("PassportHostHelper", "contains key, change value");
        Map<Integer, String> r114 = this.f540574c;
        ConcurrentHashMap r115 = (ConcurrentHashMap) r114;
        r115.put(r106.getKey(), r106.getValue());
        this.f540572a.b(r106.getKey(), r106.getValue());
        goto L24
    L25:
        this.f540572a.b("urlRegexKeySet", this.f540575d);
    }
}
