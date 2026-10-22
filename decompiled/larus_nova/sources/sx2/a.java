package sx2;

import com.bytedance.android.livesdk.gift.model.GiftExtraWrapper;
import com.bytedance.android.livesdk.gift.model.PageExtraWapper;
import com.bytedance.android.livesdk.gift.model.k2;
import com.bytedance.android.livesdk.gift.model.p1;
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
    public static final a f543809f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C7667a f543810g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f543811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f543812e;

    /* JADX INFO: renamed from: sx2.a$a, reason: collision with other inner class name */
    public static final class C7667a extends ModelExtensionInfoHolder.CompanionBase {
        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder.CompanionBase
        public final ModelExtensionInfoHolder a() {
            return a.f543809f;
        }

        public C7667a(int r100) {
        }
    }

    static {
        f543810g = new C7667a(0);
        f543809f = new a();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, Class<?>> c() {
        HashMap r100 = new HashMap(3);
        r100.put(k2.class, PageExtraWapper.class);
        r100.put(p1.class, GiftExtraWrapper.class);
        return r100;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, List<d>> d() {
        return new HashMap(1);
    }

    public a() {
        HashSet r100 = new HashSet(3);
        r100.add(k2.class);
        r100.add(p1.class);
        Unit r101 = Unit.INSTANCE;
        this.f543811d = r100;
        this.f543812e = new HashSet(1);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> a() {
        return this.f543812e;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> b() {
        return this.f543811d;
    }
}
