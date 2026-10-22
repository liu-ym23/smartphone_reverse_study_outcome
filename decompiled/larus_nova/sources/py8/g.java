package py8;

import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements b {
    public g() {
    }

    @Override // py8.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
    }

    @Override // py8.b
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        return false;
    }

    @Override // py8.b
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceAddress");
    }

    @Override // py8.b
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "deviceAddress");
    }

    @Override // py8.b
    public final List<String> e() {
        return CollectionsKt.emptyList();
    }

    @Override // py8.b
    public final void c(String r100, FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.a("companion device not support or companion device manager null ");
    }
}
