package i47;

import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.bridge.methods.q;
import java.util.Map;
import r47.k;

/* JADX INFO: loaded from: classes21.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f488237a = null;

    public class a implements b {
        public a() {
        }

        @Override // i47.b
        public final void b(k r100) {
        }

        @Override // i47.b
        public final boolean d(String r100, q r101) {
            return false;
        }

        @Override // i47.b
        public final void e(LoadFrom r100, d r101, l47.a<e> r102, l47.a<Throwable> r103) {
        }

        @Override // i47.b
        public final int f(String r100, Map<String, ?> r101) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: i47.b$b, reason: collision with other inner class name */
    public static class C6228b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f488238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f488239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f488240c;

        public C6228b(String r100, long r101, long r102) {
            this.f488238a = r100;
            this.f488239b = r101;
            this.f488240c = r102;
        }
    }

    void b(k r100);

    boolean d(String r100, q r101);

    void e(LoadFrom r100, d r101, l47.a<e> r102, l47.a<Throwable> r103);

    int f(String r100, Map<String, ?> r101);

    static {
        f488237a = new a();
    }
}
