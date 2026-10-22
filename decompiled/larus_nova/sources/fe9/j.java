package fe9;

import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes29.dex */
public interface j {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(j r100, String r101, String r102, Map r103, int r104) {
            if ((r104 & 8) == 0) goto L5;
            r103 = MapsKt.emptyMap();
        L5:
            r100.a(r101, r102, null, r103);
        }
    }

    void a(String r100, String r101, List<String> r102, Map<String, ? extends Object> r103);

    void b(List r100, Map r101);
}
