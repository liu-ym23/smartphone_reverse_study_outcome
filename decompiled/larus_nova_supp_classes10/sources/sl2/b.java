package sl2;

import com.bytedance.android.live.base.IService;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class b implements IService {

    public static final class a implements f.b {
        public final Class<? extends f<?, ?>> a;

        public final f<?, ?> a() {
            return this.a.newInstance();
        }

        public a(Class<? extends f<?, ?>> r2) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            this.a = r2;
        }
    }

    public b() {
    }

    public void provideStatefulMethods(Map<String, f.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public final f.b createProvider(Class<? extends f<?, ?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return new a(r2);
    }
}
