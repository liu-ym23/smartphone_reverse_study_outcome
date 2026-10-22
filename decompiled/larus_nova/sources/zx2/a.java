package zx2;

import com.bytedance.android.live.recharge.IWalletInfoFlexImpl;
import com.bytedance.android.live.recharge.l;
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
    public static final a f573874f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C8503a f573875g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f573876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f573877e;

    /* JADX INFO: renamed from: zx2.a$a, reason: collision with other inner class name */
    public static final class C8503a extends ModelExtensionInfoHolder.CompanionBase {
        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder.CompanionBase
        public final ModelExtensionInfoHolder a() {
            return a.f573874f;
        }

        public C8503a(int r100) {
        }
    }

    static {
        f573875g = new C8503a(0);
        f573874f = new a();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, Class<?>> c() {
        HashMap r100 = new HashMap(2);
        r100.put(l.class, IWalletInfoFlexImpl.class);
        return r100;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, List<d>> d() {
        return new HashMap(1);
    }

    public a() {
        HashSet r100 = new HashSet(2);
        r100.add(l.class);
        Unit r101 = Unit.INSTANCE;
        this.f573876d = r100;
        this.f573877e = new HashSet(1);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> a() {
        return this.f573877e;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> b() {
        return this.f573876d;
    }
}
