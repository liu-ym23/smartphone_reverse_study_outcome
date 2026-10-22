package je5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class d extends c66.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498826b;

    public d() {
        this.f498826b = "ccm.log";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public String getName() {
        return this.f498826b;
    }

    public String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        return "ccm-lynx: " + r100;
    }
}
