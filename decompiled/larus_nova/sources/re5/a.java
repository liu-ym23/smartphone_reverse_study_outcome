package re5;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends s66.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537424c;

    public a() {
        this.f537424c = "ccm.getStorageInfo";
    }

    @Override // s66.a, com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f537424c;
    }

    @Override // s66.a
    public final void e(com.bytedance.ies.xbridge.model.params.b r100, s66.a.C7573a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        r101.a("android is not support");
    }
}
