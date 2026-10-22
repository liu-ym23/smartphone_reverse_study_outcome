package ia8;

import com.bytedance.keva.Keva;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.text.SimpleDateFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f488947a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Keva f488948b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.frameworks.baselib.network.http.util.g<String, JSONArray> f488949c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f488950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f488951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f488952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f488953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f488954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SimpleDateFormat f488955i = null;

    static {
        f488947a = LazyKt.lazy(new i());
        f488948b = Keva.getRepo("dora_tracer");
        f488949c = new com.bytedance.frameworks.baselib.network.http.util.g(200);
        f488955i = new SimpleDateFormat("HH:mm:ss.SSS");
    }

    public static void a(final DoraEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "doraEvent");
        FLogger.f375446a.e("【DoraTracer】", r100.getMessage());
        t0.a(new l(r100));
    }

    public static void b(final DoraEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "doraEvent");
        FLogger.f375446a.i("【DoraTracer】", r100.getMessage());
        t0.a(new j(r100));
    }
}
