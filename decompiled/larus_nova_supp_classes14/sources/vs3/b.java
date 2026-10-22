package vs3;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends WeakReference<Object> {
    public final String a;

    public static void a(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r2.concat(" must not be null"));
    }

    public b(Object r2, String r3, ReferenceQueue r4) {
        a(r2, "referent");
        a(r4, "referenceQueue");
        super(r2, r4);
        a(r3, "key");
        this.a = r3;
    }
}
