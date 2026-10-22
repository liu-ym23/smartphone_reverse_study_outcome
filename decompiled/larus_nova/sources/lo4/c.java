package lo4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends je5.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510106c;

    public c() {
        this.f510106c = "bitable.log";
    }

    @Override // je5.d, com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f510106c;
    }

    @Override // je5.d
    public final String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return "BitableLynx: " + r100;
    }
}
