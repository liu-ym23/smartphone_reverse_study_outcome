package is2;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void a(i r100, Class r101) {
            r100.a(r101, MapsKt.emptyMap());
        }
    }

    void a(Class<? extends h> r100, Map<String, ? extends Object> r101);

    boolean isDestroyed();
}
