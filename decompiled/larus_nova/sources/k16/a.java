package k16;

import com.bytedance.ies.bullet.core.kit.bridge.g;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends s26.a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f501379b = 0;

    public MethodFinder G0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return null;
    }

    public boolean I0() {
        return this instanceof com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension.a;
    }

    public boolean J0() {
        return this instanceof com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension.a;
    }

    @Override // k16.b
    public final void K(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
    }

    public void initialize() {
    }

    public a() {
    }

    @Override // k16.b
    public final List<g> E0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return CollectionsKt.emptyList();
    }

    public List<IDLXBridgeMethod> H0(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return new ArrayList();
    }

    public List<MethodFinder> L(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return CollectionsKt.emptyList();
    }

    @Override // k16.b
    public final List<com.bytedance.ies.bullet.service.base.bridge.a> h(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return new ArrayList();
    }

    @Override // k16.b
    public final List<IBridgeMethod> v(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        return new ArrayList();
    }
}
