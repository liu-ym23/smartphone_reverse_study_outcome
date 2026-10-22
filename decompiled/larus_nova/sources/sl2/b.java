package sl2;

import com.bytedance.android.live.base.IService;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class b implements IService {

    public static final class a implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends f<?, ?>> f542450a;

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final f<?, ?> a() {
            return this.f542450a.newInstance();
        }

        public a(Class<? extends f<?, ?>> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            this.f542450a = r100;
        }
    }

    public b() {
    }

    public void provideStatefulMethods(Map<String, f.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
    }

    public final f.b createProvider(Class<? extends f<?, ?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return new a(r100);
    }
}
