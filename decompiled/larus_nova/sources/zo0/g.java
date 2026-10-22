package zo0;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, f> f573094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, b> f573095b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f573096c = null;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f573097a = null;

        public a() {
        }

        static {
            f573097a = new a();
        }

        @Override // zo0.g.b
        public final f a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            return new f(r100);
        }
    }

    public interface b {
        f a(String r100);
    }

    public g() {
    }

    static {
        f573096c = new g();
        f573094a = new HashMap();
        f573095b = new HashMap();
    }
}
