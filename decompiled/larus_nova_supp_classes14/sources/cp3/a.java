package cp3;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final AtomicLong d = null;
    public final String a;
    public final String b;
    public final Map<String, Object> c;

    /* JADX INFO: renamed from: cp3.a$a, reason: collision with other inner class name */
    public static final class C0116a {
    }

    static {
        d = new AtomicLong(Long.MIN_VALUE);
    }

    public final String toString() {
        return "WindowEvent(requestId=" + this.a + ", eventName='" + this.b + "', eventParams=" + this.c + ')';
    }

    public a(String r1, String r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
