package jx2;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.IInteractionInfoMessageFlexImpl;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.i;
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
    public static final a f500751f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C6489a f500752g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f500753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f500754e;

    /* JADX INFO: renamed from: jx2.a$a, reason: collision with other inner class name */
    public static final class C6489a extends ModelExtensionInfoHolder.CompanionBase {
        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder.CompanionBase
        public final ModelExtensionInfoHolder a() {
            return a.f500751f;
        }

        public C6489a(int r100) {
        }
    }

    static {
        f500752g = new C6489a(0);
        f500751f = new a();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, Class<?>> c() {
        HashMap r100 = new HashMap(2);
        r100.put(i.class, IInteractionInfoMessageFlexImpl.class);
        return r100;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, List<d>> d() {
        return new HashMap(1);
    }

    public a() {
        HashSet r100 = new HashSet(2);
        r100.add(i.class);
        Unit r101 = Unit.INSTANCE;
        this.f500753d = r100;
        this.f500754e = new HashSet(1);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> a() {
        return this.f500754e;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> b() {
        return this.f500753d;
    }
}
