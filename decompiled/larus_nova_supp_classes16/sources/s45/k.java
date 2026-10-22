package s45;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public static volatile k e;
    public final ml5.b a;
    public String b;
    public final Map<Integer, String> c;
    public final Set<String> d;

    public static k a() {
        if (e != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public k() {
        this.a = new ml5.b("passportDomainConfig");
        this.c = new ConcurrentHashMap();
        this.d = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public final void b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        tt5.a.h("PassportHostHelper", "update passport host, but receive empty host");
        return;
    L6:
        this.b = this.a.a.getString("passportHost", "");
        tt5.a.h("PassportHostHelper", "old passport host is " + this.b + " new value is " + r5);
        if (TextUtils.equals(r5, this.b) == true) goto L10;
        this.b = r5;
        this.a.b("passportHost", r5);
        return;
    }

    public final void c(Map<Integer, String> r8) {
        if (((ConcurrentHashMap) this.c).size() != 0) goto L15;
        tt5.a.h("PassportHostHelper", "regex map is empty, get value from Preference");
        Iterator r0 = ((Set) this.a.a("urlRegexKeySet", new HashSet())).iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        Object r3 = r0.next();
        String r4 = this.a.getString(r3.toString(), "");
        Integer r5 = CastIntegerProtector.valueOf(r3.toString());     // Catch: Throwable -> L10
    L12:
        if (TextUtils.isEmpty(r4) == true) goto L6;
        if (r5 == null) goto L6;
        ((ConcurrentHashMap) this.c).put(r5, r4);
    L10:
        tt5.a.d("PassportHostHelper", "");
        r5 = null;
    L15:
        Iterator<Map.Entry<Integer, String>> r9 = r8.entrySet().iterator();
    L17:
        if (r9.hasNext() == false) goto L25;
        Map.Entry<Integer, String> r1 = r9.next();
        Map<Integer, String> r6 = this.c;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        if (r7.containsKey(r1.getKey()) == true) goto L21;
        tt5.a.h("PassportHostHelper", "do not contains key, add key to map");
        Map<Integer, String> r10 = this.c;
        ConcurrentHashMap r11 = (ConcurrentHashMap) r10;
        r11.put(r1.getKey(), r1.getValue());
        this.a.b(r1.getKey(), r1.getValue());
    L24:
        this.d.add(r1.getKey().toString());
        goto L17
    L21:
        String r12 = r1.getValue();
        Map<Integer, String> r13 = this.c;
        ConcurrentHashMap r14 = (ConcurrentHashMap) r13;
        if (r12.equals(r14.get(r1.getKey())) == true) goto L24;
        tt5.a.h("PassportHostHelper", "contains key, change value");
        Map<Integer, String> r16 = this.c;
        ConcurrentHashMap r17 = (ConcurrentHashMap) r16;
        r17.put(r1.getKey(), r1.getValue());
        this.a.b(r1.getKey(), r1.getValue());
        goto L24
    L25:
        this.a.b("urlRegexKeySet", this.d);
    }
}
