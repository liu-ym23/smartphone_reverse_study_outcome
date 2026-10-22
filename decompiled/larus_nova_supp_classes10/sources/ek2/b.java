package ek2;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int c = 0;
    public final CopyOnWriteArraySet<Integer> a;
    public final Map<Integer, List<String>> b;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<Integer, ? extends List<String>> r1) {
        this.b = r1;
        this.a = new CopyOnWriteArraySet();
    }
}
