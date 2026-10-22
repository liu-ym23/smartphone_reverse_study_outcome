package g98;

import com.larus.audio.call.o;
import com.larus.avlink.env.DoraEnvObserveState;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static o f480522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile o f480523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile f f480524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f480525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile String f480526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LinkedHashMap<String, Integer> f480527f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f480528g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static e f480529h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f480530a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f480531b = null;

        static {
            int[] r100 = new int[DoraEnvObserveState.values().length];
            r100[DoraEnvObserveState.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r100[DoraEnvObserveState.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            f480530a = r100;
            int[] r101 = new int[EnvObserveChangeReason.values().length];
            r101[EnvObserveChangeReason.CONNECT_CHANGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            f480531b = r101;
        }
    }

    static {
        f480527f = new LinkedHashMap();
        f480528g = new Object();
    }

    public static void a(final f r100) {
        FLogger.f375446a.i("DoraEnvObserveManager", "onEnvObserveStateEvent event: " + r100);
        t0.a(new g98.a(r100));
    }

    public static void b(Integer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.intValue() <= 0) goto L32;
        Object r101 = f480528g;
        monitor-enter(r101);
        String r102 = f480526e;     // Catch: Throwable -> L24
        if (r102 != null) goto L12;
        monitor-exit(r101);
        return;
    L12:
        LinkedHashMap<String, Integer> r103 = f480527f;     // Catch: Throwable -> L24
        if (r103.containsKey(r102) == true) goto L21;
        r103.put(r102, r100);     // Catch: Throwable -> L24
    L15:
        LinkedHashMap<String, Integer> r104 = f480527f;     // Catch: Throwable -> L24
        if (r104.size() <= 16) goto L21;
        String r105 = (String) CollectionsKt.firstOrNull(r104.keySet());     // Catch: Throwable -> L24
        if (r105 == null) goto L21;
        r104.remove(r105);     // Catch: Throwable -> L24
    L21:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r101);
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
