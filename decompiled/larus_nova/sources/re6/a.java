package re6;

import com.ss.android.lark.security.compliance.infra.util.f;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes20.dex */
public abstract class a {
    public a() {
    }

    public abstract Map<String, Object> a();

    public final String toString() {
        Map<String, Object> r100 = a();
        if (r100 != null) goto L6;
        r100 = MapsKt.emptyMap();
    L6:
        return f.c(r100);
    }
}
