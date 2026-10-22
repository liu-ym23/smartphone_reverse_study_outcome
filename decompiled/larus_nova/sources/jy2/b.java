package jy2;

import com.bytedance.android.live.base.model.message.f3;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi_IMainEpisodeInfoResponseDataExtensionImpl;
import com.bytedance.android.livesdk.chatroom.vs_base.model.message.VSMatchHighLightMessageExtensionImpl;
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
    public static final b f500941f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f500942g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f500943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f500944e;

    public static final class a extends ModelExtensionInfoHolder.CompanionBase {
        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder.CompanionBase
        public final ModelExtensionInfoHolder a() {
            return b.f500941f;
        }

        public a(int r100) {
        }
    }

    static {
        f500942g = new a(0);
        f500941f = new b();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, Class<?>> c() {
        HashMap r100 = new HashMap(5);
        r100.put(ReplayInfoApi.b.class, ReplayInfoApi_IMainEpisodeInfoResponseDataExtensionImpl.class);
        r100.put(er1.a.class, VSMatchHighLightMessageExtensionImpl.class);
        r100.put(ReplayInfoApi.a.class, ReplayInfoApi.EpisodeInfoResponseData.class);
        return r100;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, List<d>> d() {
        HashMap r100 = new HashMap(3);
        ArrayList r101 = new ArrayList(1);
        jy2.a r102 = jy2.a.f500940a;
        r101.add(new d(ReplayInfoApi.a.class, ReplayInfoApi.b.class, 0, r102));
        Unit r103 = Unit.INSTANCE;
        r100.put(ReplayInfoApi.a.class, r101);
        ArrayList r104 = new ArrayList(1);
        r104.add(new d(f3.class, er1.a.class, 1, r102));
        r100.put(f3.class, r104);
        return r100;
    }

    public b() {
        HashSet r100 = new HashSet(5);
        r100.add(ReplayInfoApi.b.class);
        r100.add(er1.a.class);
        r100.add(ReplayInfoApi.a.class);
        Unit r101 = Unit.INSTANCE;
        this.f500943d = r100;
        HashSet r102 = new HashSet(3);
        r102.add(ReplayInfoApi.a.class);
        r102.add(f3.class);
        this.f500944e = r102;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> a() {
        return this.f500944e;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> b() {
        return this.f500943d;
    }
}
