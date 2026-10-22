package he3;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v {
    public final Map<String, Object> a;
    public int b;
    public int c;
    public l d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public boolean i;
    public boolean j;
    public String k;
    public String l;
    public final Set<String> m;
    public boolean n;
    public boolean o;
    public final String p;

    public v() {
        this.a = new LinkedHashMap();
        this.b = -1;
        this.c = -1;
        this.f = true;
        this.h = 1;
        this.m = new LinkedHashSet();
        this.p = UUID.randomUUID().toString();
    }
}
