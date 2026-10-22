package ex9;

import com.larus.office.OfficeInputParam;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ax9.c f474726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static OfficeInputParam f474727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f474728c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f474729d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArrayList<vm9.c> f474730e = null;

    static {
        f474728c = LazyKt.lazy(new c());
        f474729d = LazyKt.lazy(new d());
        f474730e = new CopyOnWriteArrayList();
    }

    public static a a() {
        return (a) f474728c.getValue();
    }

    public static vm9.c b() {
        return (vm9.c) CollectionsKt.lastOrNull(f474730e);
    }
}
