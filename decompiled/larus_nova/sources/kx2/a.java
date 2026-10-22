package kx2;

import com.bytedance.kmp.gamecp.base.message.model.ITeamPlayMemberFlexImpl;
import com.bytedance.kmp.gamecp.base.message.model.c;
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
    public static final a f506550f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C6627a f506551g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f506552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f506553e;

    /* JADX INFO: renamed from: kx2.a$a, reason: collision with other inner class name */
    public static final class C6627a extends ModelExtensionInfoHolder.CompanionBase {
        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder.CompanionBase
        public final ModelExtensionInfoHolder a() {
            return a.f506550f;
        }

        public C6627a(int r100) {
        }
    }

    static {
        f506551g = new C6627a(0);
        f506550f = new a();
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, Class<?>> c() {
        HashMap r100 = new HashMap(2);
        r100.put(c.class, ITeamPlayMemberFlexImpl.class);
        return r100;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Map<Class<?>, List<d>> d() {
        return new HashMap(1);
    }

    public a() {
        HashSet r100 = new HashSet(2);
        r100.add(c.class);
        Unit r101 = Unit.INSTANCE;
        this.f506552d = r100;
        this.f506553e = new HashSet(1);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> a() {
        return this.f506553e;
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionInfoHolder
    public final Set<Class<?>> b() {
        return this.f506552d;
    }
}
