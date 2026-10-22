package e49;

import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {
    public static final OTAUpdatePackage a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        z39.a r101 = r100.f471022a;
        if (r101 == null) goto L7;
        List<OTAUpdatePackage> r102 = r101.b();
        if (r102 == null) goto L7;
        return (OTAUpdatePackage) CollectionsKt.firstOrNull(r102);
    L7:
        return null;
    }
}
