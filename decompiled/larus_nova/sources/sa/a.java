package sa;

import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import ue7.d;

/* JADX INFO: loaded from: classes43.dex */
public class a implements IBDXBridgeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final le7.a<?> f541132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f541134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PlatformType f541135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C7588a f541136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f541137f;

    /* JADX INFO: renamed from: sa.a$a, reason: collision with other inner class name */
    public static final class C7588a implements d {
        public C7588a() {
        }

        @Override // ue7.d
        public final void a(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final View getEngineView() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final le7.a<?> getBridgeCall() {
        return this.f541132a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final String getCallId() {
        return this.f541137f;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getContainerID() {
        return this.f541133b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final d getJsEventDelegate() {
        return this.f541136e;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getNamespace() {
        return this.f541134c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f541135d;
    }

    public a(le7.a<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeCall");
        this.f541132a = r100;
        this.f541133b = "";
        this.f541134c = "";
        this.f541135d = r100.c();
        this.f541136e = new C7588a();
        this.f541137f = UUID.randomUUID().toString();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final void setCallId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f541137f = r100;
    }
}
