package sw9;

import com.larus.office.OfficeInputParam;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static pw9.c f543730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ew4.a f543731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f543732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f543733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f543734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static OfficeInputParam f543735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f543736g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f543737h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f543738i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CopyOnWriteArrayList<vm9.c> f543739j = null;

    static {
        f543734e = true;
        f543736g = LazyKt.lazy(new d());
        f543737h = LazyKt.lazy(new e());
        f543738i = LazyKt.lazy(new f());
        f543739j = new CopyOnWriteArrayList();
    }

    public static a a() {
        return (a) f543736g.getValue();
    }

    public static vm9.c b() {
        return (vm9.c) CollectionsKt.lastOrNull(f543739j);
    }

    public static b c() {
        return (b) f543737h.getValue();
    }
}
