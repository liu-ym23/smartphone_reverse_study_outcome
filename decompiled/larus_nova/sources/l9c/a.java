package l9c;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import k9c.d;
import k9c.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a<DATA extends Message<?, ?>> implements d<DATA> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends d<?>>, b> f508137e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DATA f508140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<k9c.b> f508141d;

    /* JADX INFO: renamed from: l9c.a$a, reason: collision with other inner class name */
    public static final class C6665a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f508142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f<? extends a<?>> f508143b;

        public b(String r100, Class<? extends d<?>> r101, f<? extends a<?>> r102) {
            Intrinsics.checkNotNullParameter(r100, "reachPointType");
            Intrinsics.checkNotNullParameter(r101, "reachPointClazz");
            Intrinsics.checkNotNullParameter(r102, "factory");
            this.f508142a = r100;
            this.f508143b = r102;
        }
    }

    public abstract ProtoAdapter<DATA> c();

    static {
        f508137e = new ConcurrentHashMap();
    }

    @Override // k9c.d
    public final String b() {
        return this.f508138a;
    }

    public void d(DATA r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f508140c = r100;
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "reachPointId");
        Intrinsics.checkNotNullParameter(r101, "reachPointType");
        this.f508138a = r100;
        this.f508139b = r101;
    }
}
