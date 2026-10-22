package ya3;

import androidx.lifecycle.LifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final a b = null;
    public final Map<LifecycleOwner, C0244a> a;

    /* JADX INFO: renamed from: ya3.a$a, reason: collision with other inner class name */
    public static final class C0244a {
    }

    public static final class b {
    }

    static {
        b = new a();
        new Regex("(server_time=[^&]*)");
    }

    public a() {
        this.a = new LinkedHashMap();
    }
}
