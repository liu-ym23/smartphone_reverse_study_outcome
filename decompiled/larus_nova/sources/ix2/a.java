package ix2;

import com.bytedance.android.gamecp.live_impl.message.o;
import com.bytedance.android.gamecp.live_impl.message.r;
import com.bytedance.kmp.gamecp.base.message.model.b;
import com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder;
import com.bytedance.tools.kcp.modelx.runtime.internal.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends ModelExtensionInfoHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f496321f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C6364a f496322g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f496323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f496324e;

    /* JADX INFO: renamed from: ix2.a$a, reason: collision with other inner class name */
    public static final class C6364a extends ModelExtensionInfoHolder.CompanionBase {
        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder.CompanionBase
        public final ModelExtensionInfoHolder a() {
            return a.f496321f;
        }

        public C6364a(int r100) {
        }
    }

    static {
        f496322g = new C6364a(0);
        f496321f = new a();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, Class<?>> c() {
        HashMap r100 = new HashMap(3);
        r100.put(b.class, r.class);
        r100.put(com.bytedance.kmp.gamecp.base.message.model.a.class, o.class);
        return r100;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, List<d>> d() {
        return new HashMap(1);
    }

    public a() {
        HashSet r100 = new HashSet(3);
        r100.add(b.class);
        r100.add(com.bytedance.kmp.gamecp.base.message.model.a.class);
        Unit r101 = Unit.INSTANCE;
        this.f496323d = r100;
        this.f496324e = new HashSet(1);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> a() {
        return this.f496324e;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> b() {
        return this.f496323d;
    }
}
