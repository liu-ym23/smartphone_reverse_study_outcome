package ya3;

import androidx.lifecycle.LifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f567018b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<LifecycleOwner, C8320a> f567019a;

    /* JADX INFO: renamed from: ya3.a$a, reason: collision with other inner class name */
    public static final class C8320a {
    }

    public static final class b {
    }

    static {
        f567018b = new a();
        new Regex("(server_time=[^&]*)");
    }

    public a() {
        this.f567019a = new LinkedHashMap();
    }
}
