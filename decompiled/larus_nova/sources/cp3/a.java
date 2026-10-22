package cp3;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f464630d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f464631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f464633c;

    /* JADX INFO: renamed from: cp3.a$a, reason: collision with other inner class name */
    public static final class C5563a {
    }

    static {
        f464630d = new AtomicLong(Long.MIN_VALUE);
    }

    public final String toString() {
        return "WindowEvent(requestId=" + this.f464631a + ", eventName='" + this.f464632b + "', eventParams=" + this.f464633c + ')';
    }

    public a(String r100, String r101, Map r102) {
        this.f464631a = r100;
        this.f464632b = r101;
        this.f464633c = r102;
    }
}
