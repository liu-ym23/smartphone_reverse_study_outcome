package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<luc.f, Map<a<Object>, Object>> f505453a;

    public static final class a<T> {
        public a() {
        }
    }

    public p() {
        this.f505453a = new ConcurrentHashMap(16);
    }

    public final <T> T a(luc.f r100, a<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r101, "key");
        Map r102 = (Map) ((ConcurrentHashMap) this.f505453a).get(r100);
        if (r102 == null) goto L5;
        Object r103 = r102.get(r101);
    L6:
        if (r103 != null) goto L9;
        return null;
    L9:
        return (T) r103;
    L5:
        r103 = null;
        goto L6
    }
}
