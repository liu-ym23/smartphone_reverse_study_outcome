package dy2;

import com.bytedance.kmp.live.livelink.api.guestlink.model.EmptyGuestLinkChannelInfoExtensionImpl;
import com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder;
import com.bytedance.tools.kcp.modelx.runtime.internal.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends ModelExtensionInfoHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f470520f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f470521g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f470522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f470523e;

    public static final class a extends ModelExtensionInfoHolder.CompanionBase {
        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder.CompanionBase
        public final ModelExtensionInfoHolder a() {
            return b.f470520f;
        }

        public a(int r100) {
        }
    }

    static {
        f470521g = new a(0);
        f470520f = new b();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, Class<?>> c() {
        HashMap r100 = new HashMap(2);
        r100.put(pb6.a.class, EmptyGuestLinkChannelInfoExtensionImpl.class);
        return r100;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, List<d>> d() {
        HashMap r100 = new HashMap(2);
        ArrayList r101 = new ArrayList(1);
        r101.add(new d(com.bytedance.android.live.base.model.message.guestlink.a.class, pb6.a.class, 0, dy2.a.f470519a));
        Unit r102 = Unit.INSTANCE;
        r100.put(com.bytedance.android.live.base.model.message.guestlink.a.class, r101);
        return r100;
    }

    public b() {
        HashSet r100 = new HashSet(2);
        r100.add(pb6.a.class);
        Unit r101 = Unit.INSTANCE;
        this.f470522d = r100;
        HashSet r102 = new HashSet(2);
        r102.add(com.bytedance.android.live.base.model.message.guestlink.a.class);
        this.f470523e = r102;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> a() {
        return this.f470523e;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> b() {
        return this.f470522d;
    }
}
