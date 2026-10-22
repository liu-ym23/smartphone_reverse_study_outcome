package vs3;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends WeakReference<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f556982a;

    public static void a(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r101.concat(" must not be null"));
    }

    public b(Object r100, String r101, ReferenceQueue r102) {
        a(r100, "referent");
        a(r102, "referenceQueue");
        super(r100, r102);
        a(r101, "key");
        this.f556982a = r101;
    }
}
