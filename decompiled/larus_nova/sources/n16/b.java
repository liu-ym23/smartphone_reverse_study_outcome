package n16;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.bullet.core.k;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, k> f516671a = null;

    static {
        f516671a = new ConcurrentHashMap();
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9, types: [T, com.bytedance.ies.bullet.core.k] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static void a(String r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r110, "value");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put(r101, r110);
        Unit r103 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "schema");
        k r104 = null;
        String r105 = a36.b.e(UriProtector.parse(r100), "__x_session_id");     // Catch: Exception -> L16
        if (r105 != null) goto L6;
        r105 = UUID.randomUUID().toString();     // Catch: Exception -> L16
    L6:
        Ref.ObjectRef r106 = new Ref.ObjectRef();     // Catch: Exception -> L16
        ConcurrentHashMap<String, k> r107 = f516671a;     // Catch: Exception -> L16
        ?? r108 = r107.get(r105);     // Catch: Exception -> L16
        r106.element = r108;     // Catch: Exception -> L16
        if (r108 != 0) goto L10;
        r106.element = new k(r105);     // Catch: Exception -> L16
        ExecutorService r109 = BulletLogger.f247763a;     // Catch: Exception -> L16
        BulletLogger.k("Tracert createContext, monitorId " + ((k) r106.element).f246515a + ", schema " + r100, null, null, 6);     // Catch: Exception -> L16
        r107.put(r105, (k) r106.element);     // Catch: Exception -> L16
        new Handler(Looper.getMainLooper()).postDelayed(new a(r106), (long) 300000);     // Catch: Exception -> L16
        k r111 = (k) r106.element;     // Catch: Exception -> L16
    L15:
        r104 = r111;
    L17:
        if (r104 == null) goto L21;
        r104.b(new JSONObject(r102), new JSONObject(MapsKt.emptyMap()));
        return;
    L21:
        return;
    L10:
        ExecutorService r112 = BulletLogger.f247763a;     // Catch: Exception -> L16
        StringBuilder r113 = new StringBuilder("Tracert getContext, disableCreate false, monitorId ");     // Catch: Exception -> L16
        k r114 = (k) r106.element;     // Catch: Exception -> L16
        if (r114 == null) goto L13;
        String r115 = r114.f246515a;     // Catch: Exception -> L16
    L14:
        r113.append(r115);     // Catch: Exception -> L16
        r113.append(", schema ");     // Catch: Exception -> L16
        r113.append(r100);     // Catch: Exception -> L16
        BulletLogger.k(r113.toString(), null, null, 6);     // Catch: Exception -> L16
        r111 = (k) r106.element;     // Catch: Exception -> L16
        goto L15
    L13:
        r115 = null;
    L16:
        BulletLogger.k("invalid url in BulletTracert", null, null, 6);
        goto L17
    }
}
