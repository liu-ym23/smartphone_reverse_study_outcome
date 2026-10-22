package ne1;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes7.dex */
public interface a<T> {

    /* JADX INFO: renamed from: ne1.a$a, reason: collision with other inner class name */
    public static final class C6915a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <T> void a(a<T> r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "value");
            Map<String, T> r103 = r100.getParams();
            if (TypeIntrinsics.isMutableMap(r103) == true) goto L5;
            r103 = null;
        L5:
            if (r103 == null) goto L8;
            r103.put(r101, r102);
            return;
        }
    }

    Map<String, T> getParams();
}
